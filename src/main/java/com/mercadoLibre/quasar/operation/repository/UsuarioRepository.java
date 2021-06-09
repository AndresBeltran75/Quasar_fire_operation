package com.mercadoLibre.quasar.operation.repository;

import com.mercadoLibre.quasar.operation.entity.Usuario;

public interface UsuarioRepository{

	public Usuario save(Usuario entity);

	public Usuario findByUsuarioIdAndClave(Integer id, String clave);
	
	public Usuario findByUsuarioId(Integer id);

	public boolean existsByUsuarioId(Integer id);

	public long count();

	public void deleteByUsuarioId(Integer id);

	public void delete(Usuario usuarioId);

}
