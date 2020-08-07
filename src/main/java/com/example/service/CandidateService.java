package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.CandidateDao;
import com.example.dao.UsersDao;
import com.example.dao.VotersDao;
import com.example.entity.Candidate;
import com.example.entity.Users;
import com.example.exception.NoCandidateFound;
import com.example.exception.NotAuthorized;
import com.example.response.CandidateResponse;
import com.example.response.ExpertResponse;
import com.example.response.GetCandidateResponse;
import com.example.response.GetUsers;

@Service
public class CandidateService {

	
	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private VotersDao votersDao;

	@Autowired
	private UsersDao usersDao;

	public List<GetUsers> getAllCandidates() {
		List<Candidate> candidates = candidateDao.findAll();

		List<GetUsers> userList = new ArrayList<>();

		candidates.forEach(candidate -> {
			GetUsers user = new GetUsers();
			user.setUserId(candidate.getCandidateId());
			user.setUserName(candidate.getCandidateName());
			userList.add(user);
		});

		return userList;
	}

	public Candidate addCandidate(Candidate candidate) {
		addUser(candidate);
		return candidateDao.save(candidate);
	}

	private void addUser(Candidate candidate) {
		Users user = new Users();
		user.setUserName(candidate.getCandidateName());
		if (!usersDao.findByuserName(candidate.getCandidateName()).isPresent()) {
			user.setUserRole("CANDIDATE");
			user.setUserPassword("password");
			usersDao.save(user);
		}
	}

	private Users updateUser(Candidate candidate) {
		Users user = usersDao.findByuserName(candidate.getCandidateName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		user.setUserName(candidate.getCandidateName());

		return usersDao.save(user);
	}
	
	public Candidate updateCandidateByCandidate(Candidate candidate, Long candidateId,String principal) throws NoCandidateFound, NotAuthorized
	{
		if(candidate.getCandidateId()==candidateId && candidateDao.findBycandidateName(principal).isPresent() && candidateId== candidateDao.findBycandidateName(principal).get().getCandidateId())
		{
			return updateCandidate(candidate, candidateId);
		}
		
		throw new NotAuthorized("Not Authorized to change Candidate Details");
	}

	public Candidate updateCandidate(Candidate candidate, Long candidateId) throws NoCandidateFound {
		if (candidateId == candidate.getCandidateId() && candidateDao.findById(candidateId).isPresent()) {
			updateUser(candidate);
			return candidateDao.save(candidate);
		}

		throw new NoCandidateFound("No candidate is available for given Id :" + candidateId);
	}

	public GetCandidateResponse getCandidate(Long candidateId, String ip_add) throws NoCandidateFound {
		GetCandidateResponse response = new GetCandidateResponse();
		if (candidateDao.findById(candidateId).isPresent()) {
			Candidate candidate = candidateDao.findById(candidateId).get();
			response.setCandidate(setCandidateResponse(candidate));
			if (votersDao.findByIp_add(ip_add).isEmpty())
				response.setVoted(false);
			else
				response.setVoted(true);

			return response;

		}
		throw new NoCandidateFound("No candidate is available for given Id :" + candidateId);
	}

	private CandidateResponse setCandidateResponse(Candidate candidate) {
		CandidateResponse candidateResponse = new CandidateResponse.CandidateResponseBuilder()
				.candidateId(candidate.getCandidateId()).candidateName(candidate.getCandidateName())
				.candiateExperienceLevel(candidate.getCandiateExperienceLevel().getRating())
				.challangesSolved(candidate.getChallangesSolved())
				.expertIn(new ExpertResponse.ExpertResponseBuilder().algo(candidate.getExpertIn().getAlgo().getRating())
						.angular(candidate.getExpertIn().getAngular().getRating())
						.ds(candidate.getExpertIn().getDs().getRating())
						.java(candidate.getExpertIn().getJava().getRating())
						.python(candidate.getExpertIn().getPython().getRating())
						.expertId(candidate.getExpertIn().getExpertId()).build())
				.build();
		return candidateResponse;
	}

	public void deleteCandidate(Long candidateId) throws NoCandidateFound {
		if (candidateDao.findById(candidateId).isPresent()) {
			deleteUser(candidateDao.findById(candidateId).get().getCandidateName());
			candidateDao.deleteById(candidateId);
		}
		throw new NoCandidateFound("No candidate is available for given Id :" + candidateId);
	}

	private void deleteUser(String candidateName) {
		usersDao.delete(usersDao.findByuserName(candidateName)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found")));

	}
}
