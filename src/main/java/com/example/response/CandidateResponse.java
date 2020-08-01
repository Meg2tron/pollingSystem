package com.example.response;

import lombok.Getter;

@Getter
public class CandidateResponse {

	private CandidateResponse() {

	}

	private Long candidateId;
	private String candidateName;
	private int challangesSolved;
	private Long candiateExperienceLevel;
	private ExpertResponse expertIn;

	public static class CandidateResponseBuilder {

		private Long candidateId;
		private String candidateName;
		private int challangesSolved;
		private Long candiateExperienceLevel;
		private ExpertResponse expertIn;

		public CandidateResponseBuilder candidateId(Long candidateId) {
			this.candidateId = candidateId;
			return this;
		}

		public CandidateResponseBuilder candidateName(String candidateName) {
			this.candidateName = candidateName;
			return this;
		}

		public CandidateResponseBuilder challangesSolved(int challangesSolved) {
			this.challangesSolved = challangesSolved;
			return this;
		}

		public CandidateResponseBuilder candiateExperienceLevel(Long candiateExperienceLevel) {
			this.candiateExperienceLevel = candiateExperienceLevel;
			return this;
		}

		public CandidateResponseBuilder expertIn(ExpertResponse expertIn) {
			this.expertIn = new ExpertResponse.ExpertResponseBuilder().algo(expertIn.getAlgo())
					.angular(expertIn.getAngular()).expertId(expertIn.getExpertId()).ds(expertIn.getDs())
					.java(expertIn.getJava()).python(expertIn.getPython()).build();
			return this;
		}

		public CandidateResponse build() {
			CandidateResponse response = new CandidateResponse();
			response.candidateId = this.candidateId;
			response.candidateName = this.candidateName;
			response.challangesSolved = this.challangesSolved;
			response.candiateExperienceLevel = this.candiateExperienceLevel;
			response.expertIn = this.expertIn;
			return response;

		}
	}

}
