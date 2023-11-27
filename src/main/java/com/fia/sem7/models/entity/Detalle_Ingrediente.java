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
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="DETALLE_INGREDIENTE")
public class Detalle_Ingrediente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DETALLE_INGREDIENTE")
	private Integer idDetIng;

	@NotEmpty
	@Column(name="CANTIDAD_INGREDIENTE")
	private String cantIng;
	
	@NotEmpty
	@Column(name="COSTO_INGREDIENTE")
	private String totPagPla;
	

	@Column(name = "INGREDIENTES_ID_INGREDIENTE")
	private String ingrediente;
	

	@Column(name = "PRODUCTOS_ID_PRODUCTO")
	private String producto;



	public Integer getIdDetIng() {
		return idDetIng;
	}

	public void setIdDetIng(Integer idDetIng) {
		this.idDetIng = idDetIng;
	}

	public String getCantIng() {
		return cantIng;
	}

	public void setCantIng(String cantIng) {
		this.cantIng = cantIng;
	}

	public String getTotPagPla() {
		return totPagPla;
	}

	public void setTotPagPla(String totPagPla) {
		this.totPagPla = totPagPla;
	}



	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
