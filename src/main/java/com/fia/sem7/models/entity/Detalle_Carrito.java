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
@Table(name="DETALLE_CARRITO")
public class Detalle_Carrito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DETALLE_CARRITO")
	private Integer idDetCar;

	@Column(name="CANTIDAD_PLATO")
	private Integer cantPla;
	

	@Column(name="TOTAL_PAGO_PLATO")
	private Double totPagPla;
	
	@Column(name = "COMPROBANTE_CARRITO_ID_CARRITO")
	private Integer comprobante;
	

	@Column(name = "PRODUCTOS_ID_PRODUCTO")
	private String producto;
	
	
	
	public Detalle_Carrito() {
		
	}
	

	public Detalle_Carrito(Integer cantPla, Double totPagPla, Integer comprobante, String producto) {
		super();
		this.cantPla = cantPla;
		this.totPagPla = totPagPla;
		this.comprobante = comprobante;
		this.producto = producto;
	}




	public Integer getIdDetCar() {
		return idDetCar;
	}


	public void setIdDetCar(Integer idDetCar) {
		this.idDetCar = idDetCar;
	}


	public Integer getCantPla() {
		return cantPla;
	}

	public void setCantPla(Integer cantPla) {
		this.cantPla = cantPla;
	}

	public Double getTotPagPla() {
		return totPagPla;
	}

	public void setTotPagPla(Double totPagPla) {
		this.totPagPla = totPagPla;
	}




	public Integer getComprobante() {
		return comprobante;
	}


	public void setComprobante(Integer comprobante) {
		this.comprobante = comprobante;
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
