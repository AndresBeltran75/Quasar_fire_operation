package com.mercadoLibre.quasar.operation.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mercadoLibre.quasar.operation.entity.Usuario;
import com.mercadoLibre.quasar.operation.repository.UsuarioCrudRepository;
import com.mercadoLibre.quasar.operation.repository.UsuarioRepository;

@Repository
public class UsuarioFacade implements UsuarioRepository{
	
	@Autowired
	private UsuarioCrudRepository crudRepository;

	@Override
	public <S extends Usuario> S save(S entity) {
		return crudRepository.save(entity);
	}

	@Override
	public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Usuario findByUsuarioIdAndClave(Integer id, String clave) {
		return crudRepository.findByUsuarioIdAndClave(id, clave).get();
	}

	@Override
	public boolean existsByUsuarioId(Integer id) {
		return crudRepository.existsById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteByUsuarioId(Integer id) {
		crudRepository.deleteByUsuarioId(id);
	}

	@Override
	public void delete(Usuario usuarioId) {
		crudRepository.delete(usuarioId);
	}

	@Override
	public Usuario findByUsuarioId(Integer id) {
		return crudRepository.findByUsuarioId(id).get();
	}


}
