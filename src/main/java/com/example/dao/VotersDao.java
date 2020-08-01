package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Voters;

@Repository
public interface VotersDao extends JpaRepository<Voters, String> {
	
	@Query("Select v from Voters v where v.ip_add =?1")
	List<Voters> findByIp_add(String ip_add);
	

}
