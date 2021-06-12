package com.mercadoLibre.quasar.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadoLibre.quasar.operation.entity.Usuarios;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Integer>{

	Usuarios findByUsuarioIdAndClave(Integer id, String clave);
	
	Usuarios findByUsuarioId(Integer id);

	void deleteByUsuarioId(Integer id);

}
