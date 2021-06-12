package com.mercadoLibre.quasar.operation.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.service.UsuarioService;
import com.mercadoLibre.quasar.operation.utilidades.Constantes;

@Service
public class UserConfiguration implements UserDetailsService{
	
	@Autowired
	private UsuarioService usuarioService;
	
	private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
	static {
		AUTHORITIES.add(new SimpleGrantedAuthority(Constantes.ROLE_USER));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario auth = usuarioService.getUsuarioId(Integer.parseInt(username));
		UserDetails detalle = new User(auth.getUsuarioId().toString(),auth.getClave(), AUTHORITIES);
		return detalle;
	}
	
}