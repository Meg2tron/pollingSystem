package com.example.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Candidate;
import com.example.exception.NoCandidateFound;
import com.example.exception.NotAuthorized;
import com.example.service.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@PutMapping("/{candidateId}")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate, @PathVariable Long candidateId,Principal principal) throws NoCandidateFound, NotAuthorized {
		return ResponseEntity.ok(candidateService.updateCandidateByCandidate(candidate, candidateId,principal.getName()));
	}
}
