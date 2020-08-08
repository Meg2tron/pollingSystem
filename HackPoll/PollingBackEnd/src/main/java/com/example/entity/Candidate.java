package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateId;
	private String candidateName;
	private int challangesSolved;
	@OneToOne
	@JoinColumn(name = "candiateExperienceLevel")
	private Rating candiateExperienceLevel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "expertIn")
	private Expert expertIn;

}
