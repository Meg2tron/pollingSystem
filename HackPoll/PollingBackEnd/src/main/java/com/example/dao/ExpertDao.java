package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Expert;

@Repository
public interface ExpertDao extends JpaRepository<Expert, Long> {

}
