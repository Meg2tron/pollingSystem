package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CandidateDao;
import com.example.dao.VotersDao;
import com.example.entity.Candidate;
import com.example.exception.NoCandidateFound;
import com.example.response.GetCandidateResponse;
import com.example.response.GetUsers;

@Service
public class CandidateService {

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private VotersDao votersDao;

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
		return candidateDao.save(candidate);
	}

	public Candidate updateCandidate(Candidate candidate, Long candidateId) throws NoCandidateFound {
		if (candidateId == candidate.getCandidateId() && candidateDao.findById(candidateId).isPresent())
			return candidateDao.save(candidate);
		throw new NoCandidateFound("No candidate is available for given Id :" + candidateId);
	}

	public GetCandidateResponse getCandidate(Long candidateId, String ip_add) throws NoCandidateFound {
		GetCandidateResponse response = new GetCandidateResponse();
		if (candidateDao.findById(candidateId).isPresent()) {
			response.setCandidate(candidateDao.findById(candidateId).get());
			if (votersDao.findByIp_add(ip_add).isEmpty())
				response.setVoted(false);
			else
				response.setVoted(true);

			return response;

		}
		throw new NoCandidateFound("No candidate is available for given Id :" + candidateId);
	}

	public void deleteCandidate(Long candidateId) throws NoCandidateFound {
		if (candidateDao.findById(candidateId).isPresent())
			candidateDao.deleteById(candidateId);
		throw new NoCandidateFound("No candidate is available for given Id :" + candidateId);
	}
}