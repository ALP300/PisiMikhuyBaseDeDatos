package com.fia.sem7.models.entity;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name="ROL")
public class Rol{

	
	@Id
	@NotEmpty
	@Column(name="TIPO_ROL")
	private String tRol;
	
	@NotEmpty
	@Column(name="DETALLE_ROL")
	private String detRol;
	
	public String gettRol() {
		return tRol;
	}
	public void settRol(String tRol) {
		this.tRol = tRol;
	}
	public String getDetRol() {
		return detRol;
	}
	public void setDetRol(String detRol) {
		this.detRol = detRol;
	}
	

}
