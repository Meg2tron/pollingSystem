package com.example.response;

import lombok.Getter;

@Getter
public class ExpertResponse {

	private ExpertResponse() {

	}

	private Long expertId;
	private Long ds;
	private Long algo;
	private Long java;
	private Long python;
	private Long angular;

	public static class ExpertResponseBuilder {
		private Long expertId;
		private Long ds;
		private Long algo;
		private Long java;
		private Long python;
		private Long angular;

		public ExpertResponseBuilder expertId(Long expertId) {
			this.expertId = expertId;
			return this;
		}

		public ExpertResponseBuilder ds(Long ds) {
			this.ds = ds;
			return this;
		}

		public ExpertResponseBuilder algo(Long algo) {
			this.algo = algo;
			return this;
		}

		public ExpertResponseBuilder java(Long java) {
			this.java = java;
			return this;
		}

		public ExpertResponseBuilder python(Long python) {
			this.python = python;
			return this;
		}

		public ExpertResponseBuilder angular(Long angular) {
			this.angular = angular;
			return this;
		}

		public ExpertResponse build() {
			ExpertResponse response = new ExpertResponse();
			response.ds = this.ds;
			response.algo = this.algo;
			response.java = this.java;
			response.python = this.python;
			response.angular = this.angular;
			response.expertId = this.expertId;

			return response;

		}
	}

}
