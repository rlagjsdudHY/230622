package com.sec.basic.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	PasswordEncoder passwordEncoder = new PasswordEncoder();

	@Autowired
	public	AuthFailHandler	authFailHandler;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll().antMatchers("/style/**", "/script/**", "/images/**")
				.permitAll().antMatchers("/guest/**").permitAll().antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/member/**").hasRole("ADMIN").anyRequest().authenticated();
		http.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/security_url_check")
		.failureUrl("/loginForm?error")
		.failureHandler(authFailHandler)
		.usernameParameter("sec_username")
		.passwordParameter("sec_password")
		.permitAll();
		http.csrf().disable();
//	csrf	:	Cross	Site	Request	Forgery,	불특정	다수에	대한	권한	위조	해킹은	미적용
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.passwordEncode("1234")).roles("USER")
				.and().withUser("admin").password(passwordEncoder.passwordEncode("1234")).roles("ADMIN");
	}
}
