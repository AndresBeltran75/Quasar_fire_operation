package com.mercadoLibre.quasar.operation.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mercadoLibre.quasar.operation.configuration.UserConfiguration;
import com.mercadoLibre.quasar.operation.to.AuthenticationRequest;
import com.mercadoLibre.quasar.operation.to.AuthenticationResponse;
import com.mercadoLibre.quasar.operation.utilidades.JWTUtil;

@RestController
public class wsAuthenticationImpl implements IwsAuthentication{
	
	   @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserConfiguration platziUserDetailsService;

	    @Autowired
	    private JWTUtil jwtUtil;

	@Override
	public ResponseEntity<AuthenticationResponse> createToken(AuthenticationRequest request) {
        try {
        	if( request != null ) {
	    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
	            UserDetails userDetails = platziUserDetailsService.loadUserByUsername(request.getUsername());
	            String jwt = jwtUtil.generateToken(userDetails);
	            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        	}else {
        		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null);
        	}
            
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
	}

}
