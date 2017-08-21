package bookcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import bookcloud.service.UserService;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.formLogin()
				.loginPage("/login").failureUrl("/login-error")
			.and().logout()
				.logoutSuccessUrl("/")
			.and().authorizeRequests()
				.antMatchers("/book/**","/bookstore/**","/pub/**","/sales/**","/tax/**","/sublist/**").hasAuthority("ADMIN")
				.anyRequest().permitAll()
			.and().rememberMe().tokenValiditySeconds(2419200).key("SpringSecured");
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
   }



}
