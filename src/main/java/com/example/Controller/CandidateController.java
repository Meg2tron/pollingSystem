package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Candidate;
import com.example.exception.NoCandidateFound;
import com.example.service.CandidateService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@PutMapping(value = "/{candidateId}")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate, @PathVariable Long candidateId) throws NoCandidateFound {
		return ResponseEntity.ok(candidateService.updateCandidate(candidate, candidateId));
	}
}
