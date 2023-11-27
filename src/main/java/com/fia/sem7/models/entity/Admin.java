package com.fia.sem7.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name="ADMINISTRADORES")
public class Admin{

	@Id
	@NotEmpty
	@Column(name="IDEN_ADMIN")
	private String iden;
	
	@NotEmpty
	@Column(name="CODIGO")
	private String cod;
	
	@NotEmpty
	@Column(name="NOMBRES")
	private String nom;
	
	@NotEmpty
	@Column(name="APELLIDO_PATERNO")
	private String apePa;
	
	@NotEmpty
	@Column(name="APELLIDO_MATERNO")
	private String apeMa;
	
	@NotEmpty
	@Column(name="CONTRASENA")
	private String con;
	
	@Email
	@NotEmpty
	@Column(name="CORREO")
	private String correo;
	@NotEmpty
	@Column(name="GENERO")
	private String genero;

	@Column(name = "ROL_TIPO_ROL")
	private String rol;

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApePa() {
		return apePa;
	}
	public void setApePa(String apePa) {
		this.apePa = apePa;
	}
	public String getApeMa() {
		return apeMa;
	}
	public void setApeMa(String apeMa) {
		this.apeMa = apeMa;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	

}
