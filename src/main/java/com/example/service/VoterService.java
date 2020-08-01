package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CandidateDao;
import com.example.dao.VotersDao;
import com.example.entity.Voters;
import com.example.exception.NoCandidateFound;

@Service
public class VoterService {

	@Autowired
	private VotersDao votersDao;

	@Autowired
	private CandidateDao candidateDao;

	public Voters saveVote(Voters vote) throws NoCandidateFound {
		if (candidateDao.existsById(vote.getVotedTo().getCandidateId()))
			return votersDao.save(vote);

		throw new NoCandidateFound("Candidate Not found for vote");
	}

}
