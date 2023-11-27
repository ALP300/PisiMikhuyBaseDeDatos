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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="REGALOS")
public class Regalo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_REGALO")
	private Integer idReg;
	
	@NotEmpty
	@Column(name="DETALLE_REGALO")
	private String detReg;
	
	@NotNull
	@Column(name="DESCUENTO")
	private Double descuento;
	
	@NotEmpty
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name = "HISTORIAL_REGALOS_ID")
	private String hisReg;
	
	@Column(name = "HISTORIAL_COMPRAS_ID")
	private String hisComp;
	
	@Column(name = "COMPROBANTE_CARRITO_ID_CARRITO")
	private Integer comprobante;

	
	

	public Regalo() {

	}



	public Regalo(@NotEmpty String detReg, @NotEmpty Double descuento, @NotEmpty String estado, String hisReg) {
		super();
		this.detReg = detReg;
		this.descuento = descuento;
		this.estado = estado;
		this.hisReg = hisReg;
	}



	public Integer getIdReg() {
		return idReg;
	}

	public void setIdReg(Integer idReg) {
		this.idReg = idReg;
	}

	public String getDetReg() {
		return detReg;
	}

	public void setDetReg(String detReg) {
		this.detReg = detReg;
	}



	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getHisReg() {
		return hisReg;
	}

	public void setHisReg(String hisReg) {
		this.hisReg = hisReg;
	}

	public String getHisComp() {
		return hisComp;
	}

	public void setHisComp(String hisComp) {
		this.hisComp = hisComp;
	}



	public Integer getComprobante() {
		return comprobante;
	}

	public void setComprobante(Integer comprobante) {
		this.comprobante = comprobante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
