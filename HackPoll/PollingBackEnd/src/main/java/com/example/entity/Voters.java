package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Voters {
	@Id
	private String ip_add;
	@OneToOne
	@JoinColumn(name = "votedTo")
	private Candidate votedTo;

}
