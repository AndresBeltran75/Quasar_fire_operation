package com.mercadoLibre.quasar.operation.service;

import com.mercadoLibre.quasar.operation.entity.Usuarios;

public interface IUsuarioService {
	
	Usuarios getUsuario(int user, String pass);
	
	Usuarios getUsuarioId(int user);
	
	Usuarios getNombreUsuario(String nombreUsuario);
	
	boolean delete(Usuarios usuarioId);
	
}
