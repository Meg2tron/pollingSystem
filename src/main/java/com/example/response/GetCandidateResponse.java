package com.example.response;

import com.example.entity.Candidate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCandidateResponse {
	
	private Candidate candidate;
	private boolean isVoted;

}
