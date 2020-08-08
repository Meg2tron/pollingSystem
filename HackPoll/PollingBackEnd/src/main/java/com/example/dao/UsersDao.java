package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Long>{
	
	Optional<Users> findByuserName(String userName);
	

}
