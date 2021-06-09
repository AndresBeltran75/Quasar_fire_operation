package com.mercadoLibre.quasar.operation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mercadoLibre.quasar.operation.entity.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{
	
	public <S extends Usuario> S save(S entity);

	public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities);

	public Optional<Usuario> findByUsuarioIdAndClave(Integer id, String clave);
	
	public Optional<Usuario> findByUsuarioId(Integer id);
	
	public boolean existsById(Integer id);

	public List<Usuario> findAll();

	public long count();

	public void deleteByUsuarioId(Integer id);

	public void delete(Usuario usuarioId);

}
