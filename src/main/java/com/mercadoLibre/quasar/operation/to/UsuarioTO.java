package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Usuario data")
public class UsuarioTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Identificador usuario")
	private Integer idUsuario;
	@ApiModelProperty(value = "Nombre usuario")
	private String nombreUsuario;
	@ApiModelProperty(value = "Primer apellido usuario")
	private String apellidoUno;
	@ApiModelProperty(value = "Segundo apellido usuario")
	private String apellidoDos;
	@ApiModelProperty(value = "Primer nombre usuario")
	private String nombreUno;
	@ApiModelProperty(value = "Segundo nombre usuario")
	private String nombreDos;
	@ApiModelProperty(value = "Fecha de creación del registro")
	private Date fechaAdicion;
	@ApiModelProperty(value = "Usuario creador del registro")
	private String usuarioAdicion;
	@ApiModelProperty(value = "Fecha de edición del registro")
	private Date fechaEdicion;
	@ApiModelProperty(value = "Usuario que edito el registro")
	private String usuarioEdicion;
	@ApiModelProperty(value = "Estado del registro")
	private String estado;
	@ApiModelProperty(value = "Contraseña del usuario")
	@JsonIgnore
	private String pwd;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getApellidoUno() {
		return apellidoUno;
	}
	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = apellidoUno;
	}
	public String getApellidoDos() {
		return apellidoDos;
	}
	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = apellidoDos;
	}
	public String getNombreUno() {
		return nombreUno;
	}
	public void setNombreUno(String nombreUno) {
		this.nombreUno = nombreUno;
	}
	public String getNombreDos() {
		return nombreDos;
	}
	public void setNombreDos(String nombreDos) {
		this.nombreDos = nombreDos;
	}
	public Date getFechaAdicion() {
		return fechaAdicion;
	}
	public void setFechaAdicion(Date fechaAdicion) {
		this.fechaAdicion = fechaAdicion;
	}
	public String getUsuarioAdicion() {
		return usuarioAdicion;
	}
	public void setUsuarioAdicion(String usuarioAdicion) {
		this.usuarioAdicion = usuarioAdicion;
	}
	public Date getFechaEdicion() {
		return fechaEdicion;
	}
	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}
	public String getUsuarioEdicion() {
		return usuarioEdicion;
	}
	public void setUsuarioEdicion(String usuarioEdicion) {
		this.usuarioEdicion = usuarioEdicion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
