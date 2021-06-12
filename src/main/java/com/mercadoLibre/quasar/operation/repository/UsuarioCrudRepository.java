package com.mercadoLibre.quasar.operation.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercadoLibre.quasar.operation.entity.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{
	
	//public Usuario save(Usuario entity);

	public Usuario findByUsuarioIdAndClave(Integer id, String clave);
	
	public Usuario findByUsuarioId(Integer id);
	
	public boolean existsById(Integer id);

	public long count();

	public void deleteByUsuarioId(Integer id);

	public void delete(Usuario usuarioId);

}
