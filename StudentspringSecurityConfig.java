package com.neosoft.lara.springsecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.neosoft.lara.springsecurity.api.filter.JwtFilter;
import com.neosoft.lara.springsecurity.api.service.CustomUserdetailsService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class StudentspringSecurityConfig extends WebSecurityConfigurerAdapter{

	//@Autowired
	//private UserDetailsService userDetailsService;

	@Autowired
	private CustomUserdetailsService customuserDetailsService;

	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		//auth.inMemoryAuthentication().withUser("test").password("test1").roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("avinash").password("test2").roles("USER");
		//auth.userDetailsService(userDetailsService).passwordEncoder(encodePwd());
		auth.userDetailsService(customuserDetailsService);
	}

	//security for all api

	//@Override 
	//protected void configure(HttpSecurity http) throws Exception {
	//http.csrf().disable();
	// http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	//http.authorizeRequests().antMatchers("/noauth/**").authenticated()
	//.and().authorizeRequests().antMatchers("/rest/**")
	//.authenticated().anyRequest().hasAnyRole("ADMIN").and()
	//.formLogin().permitAll();
	//http.authorizeRequests().antMatchers("/noauth/**").permitAll()
	//.antMatchers("/rest/**").hasAnyRole("ADMIN")
	//.anyRequest().authenticated();
	//}


	// here using security based on url

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().
	 * httpBasic(); }
	 */

	//security based on ROLE
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").
	 * anyRequest().fullyAuthenticated().and().httpBasic(); }
	 */


	/*
	 * @Bean public static NoOpPasswordEncoder passwordEncoder() { return
	 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); }
	 */



	/*
	 * @Bean public BCryptPasswordEncoder encodePwd() { return new
	 * BCryptPasswordEncoder(); }
	 */



	/*
	 * @Bean public PasswordEncoder passwodEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .anyRequest().authenticated() .and()
	 * .formLogin().loginPage("/login") .permitAll() .and() .logout() .permitAll();
	 * }
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/rest/auth/authenticate")
		.permitAll().anyRequest().authenticated()
		.and().exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
	}
}
