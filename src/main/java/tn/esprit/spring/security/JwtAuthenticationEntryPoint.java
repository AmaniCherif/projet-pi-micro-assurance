package tn.esprit.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import tn.esprit.spring.exceptions.InvalidLoginResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException authException) throws IOException, ServletException {
	InvalidLoginResponse loginResponse = new InvalidLoginResponse();
	String jsonLoginResponse = new Gson().toJson(loginResponse);
	
	 httpServletResponse.setContentType("application/json");
	 httpServletResponse.setStatus(401);
	 httpServletResponse.getWriter().print(jsonLoginResponse);
		
	}
	

}
