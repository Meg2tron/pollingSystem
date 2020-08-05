package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.UsersDao;
import com.example.entity.Users;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsersDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userDao.findByuserName(username);
		return new MyUserDetails(user.orElseThrow(()->new UsernameNotFoundException("User Not found!!!!")));
	}

}
