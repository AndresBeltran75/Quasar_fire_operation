package com.mercadoLibre.quasar.operation.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.mercadoLibre.quasar.operation.entity.Usuarios;
import com.mercadoLibre.quasar.operation.to.UsuarioTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
    @Mappings({
        @Mapping(source = "usuarioId", target = "idUsuario", ignore = true),
        @Mapping(source = "nombreUsuario", target = "nombreUsuario"),
        @Mapping(source = "primerApellido", target = "apellidoUno"),
        @Mapping(source = "segundoApellido", target = "apellidoDos"),
        @Mapping(source = "primerNombre", target = "nombreUno"),
        @Mapping(source = "segundoNombre", target = "nombreDos"),
        @Mapping(source = "fechaCreacion", target = "fechaAdicion"),
        @Mapping(source = "usuarioCreacion", target = "usuarioAdicion"),
        @Mapping(source = "fechaModificacion", target = "fechaEdicion"),
        @Mapping(source = "usuarioModificacion", target = "usuarioEdicion"),
        @Mapping(source = "estado", target = "estado"),
        @Mapping(source = "clave", target = "pwd", ignore = true),
    })
	UsuarioTO usuarioToUsuarioDto(Usuarios usuario);

    @InheritInverseConfiguration
    @Mappings({
    	@Mapping(target = "clave", ignore = true),
    	@Mapping(target = "usuarioId", ignore = true)
    })
    Usuarios toUsuario(UsuarioTO usuarioDto);
    
}