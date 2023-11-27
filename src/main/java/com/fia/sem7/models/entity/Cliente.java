package com.fia.sem7.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="CLIENTES")
public class Cliente{

	@NotEmpty
	@Column(name="NOMBRES")
	private String nom;
	
	@Id
	@NotEmpty
	@Column(name="IDEN_CLIENTE")
	private String iden;
	
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
	
	
	
	@NotNull
	@Column(name="FECHA_NAC")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fecNac;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "FECHA_CRE")
	private Date fecCre;
	

	@Column(name = "ROL_TIPO_ROL")
	private String rol;
	
	public Cliente() {
		fecCre=new Date();
	}
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
	

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	public Date getFecNac() {
		return fecNac;
	}
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public Date getFecCre() {
		return fecCre;
	}
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
	
}
