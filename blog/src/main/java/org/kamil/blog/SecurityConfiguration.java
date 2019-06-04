package org.kamil.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("kamil").password("{noop}password").roles("USER", "ADMIN")
		.and()
		.withUser("test").password("{noop}password").roles("USER");		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/home", "/articles/article", "/css/**").permitAll()		
		.antMatchers("/articles/").hasRole("USER")
		.antMatchers("/articles/add").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().defaultSuccessUrl("/")
		.and().logout().logoutSuccessUrl("/")
		.and().cors().and().csrf().disable();
	}

}
