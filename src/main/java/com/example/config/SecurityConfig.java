package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	@Bean

	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	    auth.jdbcAuthentication().dataSource(datasource).getUserDetailsService();
////	        .inMemoryAuthentication()
////	            .withUser("admin").password("password").roles("ADMIN"); // admin in your case
//	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
//				"/configuration/security", "/swagger-ui.html", "/webjars/**", "/h2-console/**", "/poll/**");
//		http.authorizeRequests().antMatchers("/admin/").hasAuthority("ADMIN").antMatchers("/candidate/**")
//				.hasAuthority("CANDIDATE").and().formLogin();
//		http.csrf().disable().authenticated()
//		.and().httpBasic()
		http.csrf().disable().authorizeRequests().antMatchers("/admin/").hasAuthority("ADMIN")
				.antMatchers("/candidate/**").hasAuthority("CANDIDATE").and().httpBasic();

	}
}
