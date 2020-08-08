package com.example.entity;

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
public class Expert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expertId;
	@OneToOne
	@JoinColumn(name = "ds")
	private Rating ds;
	@OneToOne
	@JoinColumn(name = "algo")
	private Rating algo;
	@OneToOne
	@JoinColumn(name = "java")
	private Rating java;
	@OneToOne
	@JoinColumn(name = "python")
	private Rating python;
	@OneToOne
	@JoinColumn(name = "angular")
	private Rating angular;

}
