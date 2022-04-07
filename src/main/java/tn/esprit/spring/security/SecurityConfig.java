package tn.esprit.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tn.esprit.spring.service.Implementation.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true
		)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
private JwtAuthenticationEntryPoint unathorizeHandler;
@Autowired
private CustomUserDetailsService customUserDetailsService;

@Bean
public JwtAuthentificationFilter jwtAuthenticationFilter() {return new JwtAuthentificationFilter();}

@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	
}



	@Override
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/v2/api-docs",
	                                   "/configuration/ui",
	                                   "/swagger-resources/**",
	                                   "/configuration/security",
	                                   "/swagger-ui.html",
	                                   "/webjars/**");
	    }

	


	@Override
	protected void configure(HttpSecurity http) throws Exception {

	http.cors().and().csrf().disable()
	.exceptionHandling().authenticationEntryPoint(unathorizeHandler).and()
	.sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
	.and()
	.headers().frameOptions().sameOrigin()
	.and()
	.authorizeRequests()
	.antMatchers(
			"/",
			"/favicon.ico",
			"/**/*.png",
			"/**/*.gif",
			"/**/*.svg",
			"/**/*.jpg",
			"/**/*.html",
			"/**/*.css",
			"/**/*.js"
			).permitAll()
	.antMatchers(SecurityConstants.SIGN_UP_URLS).permitAll()
	.antMatchers("/**").permitAll()
	.antMatchers(SecurityConstants.CONTRACTOFFER).permitAll()
	.antMatchers(SecurityConstants.ACCOUNTING).permitAll()
	.antMatchers(SecurityConstants.H2_URL).permitAll()
	.anyRequest().authenticated();
	
	
	http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	  @Override
	   public void configure(WebSecurity web) throws Exception {
	       web.ignoring().antMatchers("/v2/api-docs",
	                                  "/configuration/ui",
	                                  "/swagger-resources/**",
	                                  "/configuration/security",
	                                  "/swagger-ui.html",
	                                  "/webjars/**");
	   }
	

}
 