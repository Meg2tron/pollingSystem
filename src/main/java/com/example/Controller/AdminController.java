package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Candidate;
import com.example.exception.NoCandidateFound;
import com.example.service.CandidateService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CandidateService candidateService;

	@PostMapping(value = "/")
	public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
		return ResponseEntity.ok(candidateService.addCandidate(candidate));
	}

	@PutMapping(value = "/{candidateId}")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate, @PathVariable Long candidateId)
			throws NoCandidateFound {
		return ResponseEntity.ok(candidateService.updateCandidate(candidate, candidateId));
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping(value = "/{candidateId}")
	public ResponseEntity<Void> deleteCandidateById(@PathVariable Long candidateId) throws NoCandidateFound {
		candidateService.deleteCandidate(candidateId);
		return (ResponseEntity<Void>) ResponseEntity.ok();
	}

}
