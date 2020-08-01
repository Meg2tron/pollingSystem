package com.example.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCandidateResponse {
	
	private CandidateResponse candidate;
	private boolean isVoted;

}
