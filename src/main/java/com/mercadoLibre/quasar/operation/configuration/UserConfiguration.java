package com.mercadoLibre.quasar.operation.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.service.UsuarioService;
import com.mercadoLibre.quasar.operation.utilidades.Constantes;

@Component
public class UserConfiguration implements AuthenticationProvider{
	
	@Autowired
	private UsuarioService usuarioService;
	
	private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
	static {
		AUTHORITIES.add(new SimpleGrantedAuthority(Constantes.ROLE_USER));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String user = authentication.getName();
		String pass = authentication.getCredentials().toString();
		Usuario auth = usuarioService.getUsuario(Integer.parseInt(user), pass);
    	if(auth != null) {
    		return new UsernamePasswordAuthenticationToken(user, pass, AUTHORITIES); 		
    	}else {
    		authentication.setAuthenticated(false);
    		return authentication;
    	}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
