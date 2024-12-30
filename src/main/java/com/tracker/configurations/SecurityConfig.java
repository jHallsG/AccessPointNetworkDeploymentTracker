package com.tracker.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tracker.jwtfilter.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(requests -> requests
						.requestMatchers("/login","/register").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				//.httpBasic(Customizer.withDefaults())		// enable this only for testing purposes
															// enables the default Basic Authentication operation
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
}
