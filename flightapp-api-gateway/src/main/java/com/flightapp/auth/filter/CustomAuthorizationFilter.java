package com.flightapp.auth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthorizationFilter extends OncePerRequestFilter{

	@Override
	@CrossOrigin
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin")); //http://localhost:4200
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");//"GET, POST, PUT, DELETE"
        response.setHeader("Access-Control-Max-Age", "1800");
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token, rgid, caseno,Set-Cookie,Origin");
        response.setHeader("Access-Control-Allow-Headers", "proxyId,X-Requested-With,content-type, Authorization,caseno,Set-Cookie,Origin");
        response.addHeader("Access-Control-Expose-Headers", "xsrf-token,Authorization,proxyId,caseno,Set-Cookie,Origin");
        
		if(request.getServletPath().equals("/login") || request.getServletPath().equals("/api/token/refresh") || request.getServletPath().equals("/api/greet")) {
			
	        if ("OPTIONS".equals(request.getMethod())) {
	            response.setStatus(HttpServletResponse.SC_OK);
	        }else if ("TRAC".equals(request.getMethod())) {
	            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        } else { 
	            filterChain.doFilter(request, response);
	        }
		} else {
			String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				try {
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					String username = decodedJWT.getSubject();
					String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
					for(String role: roles) {
						authorities.add(new SimpleGrantedAuthority(role));
					}
					
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					filterChain.doFilter(request, response);
				} catch(Exception e) {
					System.err.println("Error logging in"+e.getMessage());
					response.setHeader("error", e.getMessage());
					response.setStatus(HttpStatus.FORBIDDEN.value());
					Map<String, String> error = new HashMap<>();
					error.put("error_message", e.getMessage());
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					
					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}
			} else {
				
		        if ("OPTIONS".equals(request.getMethod())) {
		            response.setStatus(HttpServletResponse.SC_OK);
		        }else if ("TRAC".equals(request.getMethod())) {
		            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		        } else { 
		            filterChain.doFilter(request, response);
		        }
			}
		}
		
	}
	
	

}
