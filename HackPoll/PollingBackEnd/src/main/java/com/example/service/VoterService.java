package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CandidateDao;
import com.example.dao.VotersDao;
import com.example.entity.Voters;
import com.example.exception.NoCandidateFound;
import com.example.request.GetUserRequest;

@Service
public class VoterService {

	@Autowired
	private VotersDao votersDao;

	@Autowired
	private CandidateDao candidateDao;

	public Voters saveVote(GetUserRequest vote) throws NoCandidateFound {
		Voters voter = new Voters();
		if (candidateDao.existsById(vote.getCandidateId()))
		{
			voter.setVotedTo(candidateDao.findById(vote.getCandidateId()).get());
			voter.setIp_add(vote.getIpAdd());
			return votersDao.save(voter);
		}
		throw new NoCandidateFound("Candidate Not found for vote");
	}

}
