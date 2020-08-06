package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Voters;
import com.example.exception.NoCandidateFound;
import com.example.request.GetUserRequest;
import com.example.response.GetCandidateResponse;
import com.example.response.GetUsers;
import com.example.service.CandidateService;
import com.example.service.VoterService;

@RestController
@RequestMapping("/poll")
@CrossOrigin
public class EndUserController {

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private VoterService voterService;

	@GetMapping("/")
	public ResponseEntity<List<GetUsers>> getCandidates() {
		return ResponseEntity.ok(candidateService.getAllCandidates());
	}

	@PostMapping("/{candidateId}/")
	public ResponseEntity<GetCandidateResponse> getCandidateById(@RequestBody GetUserRequest userRequest,@PathVariable Long candidateId) throws NoCandidateFound {
		return ResponseEntity.ok(candidateService.getCandidate(userRequest.getCandidateId(), userRequest.getIpAdd()));
	}

	@PostMapping("/")
	public ResponseEntity<Voters> saveVote(@RequestBody GetUserRequest vote) throws NoCandidateFound {
		return ResponseEntity.ok(voterService.saveVote(vote));
	}

}
