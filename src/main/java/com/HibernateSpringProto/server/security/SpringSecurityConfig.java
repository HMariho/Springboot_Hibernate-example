package com.HibernateSpringProto.server.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.HibernateSpringProto.server.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource (name = "userDetailService")
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	UserRepository userRepository;

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/dashboard").hasRole("USER").and().formLogin().defaultSuccessUrl("/dashboard")
				.loginPage("/login").and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * System.out.println(
	 * "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
	 * ); System.out.println("N USUARIOS "+userEntryPoint.count());
	 * System.out.println(
	 * "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
	 * ); http.csrf().disable().authorizeRequests() .anyRequest().authenticated()
	 * .and().httpBasic() .authenticationEntryPoint(authEntryPoint); }
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { System.out.println(
	 * "----------------------------------------------------------------------------------------"
	 * ); System.out.println("N USUARIOS "+userEntryPoint.count());
	 * System.out.println(
	 * "----------------------------------------------------------------------------------------"
	 * );
	 * 
	 * 
	 * auth.inMemoryAuthentication().withUser("john123").password("{noop}password").
	 * roles("USER"); }
	 */

}
