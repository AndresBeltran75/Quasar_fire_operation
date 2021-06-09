package com.mercadoLibre.quasar.operation.repository;

import java.util.List;

import com.mercadoLibre.quasar.operation.entity.Usuario;

public interface UsuarioRepository{

	public <S extends Usuario> S save(S entity);

	public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities);

	public Usuario findByUsuarioIdAndClave(Integer id, String clave);
	
	public Usuario findByUsuarioId(Integer id);

	public boolean existsByUsuarioId(Integer id);

	public List<Usuario> findAll();

	public long count();

	public void deleteByUsuarioId(Integer id);

	public void delete(Usuario usuarioId);

}
