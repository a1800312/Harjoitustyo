package fi.hh.palvelinohjelmointi.Harjoitustyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.hh.palvelinohjelmointi.Harjoitustyo.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/resources/**", "/css/**", "/movies", "/login", "/api/moviesREST", "/api/moviesREST/**").permitAll()
			.and()
    	.authorizeRequests()
        	.antMatchers("/**", "/**/**", "/css/**", "/admineditmovie/{movieId}", "/admineditmovie/**", "/admineditmovie", "/editmovie/{movieId}/**", "/editmovie/*", "/editmovie/**", "/editmovie", "/editmovie/{movieId}").permitAll()
        	.anyRequest().authenticated()
        	.and()
        .formLogin()
        	.loginPage("/login")
        	.defaultSuccessUrl("/adminpagemovies")
        	.permitAll()
        	.and()
        .logout()
        	.permitAll()
			.and();
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
