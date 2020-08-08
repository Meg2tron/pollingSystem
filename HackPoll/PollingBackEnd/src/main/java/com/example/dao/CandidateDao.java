package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Long>{
	
	Optional<Candidate> findBycandidateName(String name);

}
