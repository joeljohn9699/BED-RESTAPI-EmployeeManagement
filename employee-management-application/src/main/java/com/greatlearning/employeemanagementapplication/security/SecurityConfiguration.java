package com.greatlearning.employeemanagementapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeemanagementapplication.service.impl.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/employee/listEmployees", "/employee/getEmployee/{id}",
						"/employee/searchEmployees/{firstName}", "/employee/sortEmployees", "/role/listRoles",
						"/user/listUsers")
				.hasAnyAuthority("User", "Admin")
				.antMatchers("/employee/saveEmployee", "/employee/updateEmployee/{id}", "/employee/deleteEmployee/{id}",
						"/role/saveRole", "/user/saveUser", "/user/deleteUser/{user_id}")
				.hasAuthority("Admin").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/").permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and()
				.exceptionHandling().accessDeniedPage("/403").and().httpBasic();

	}

}
