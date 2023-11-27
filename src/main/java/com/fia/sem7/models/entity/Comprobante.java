package com.fia.sem7.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="COMPROBANTE_CARRITO")
public class Comprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CARRITO")
	private Integer idCar;

	
	@Column(name="PAGO_CARRITO")
	private Double pagCar;
	

	@Column(name="TOTAL_PLATOS_COMPROBANTE")
	private Integer totPlaCom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "FECHA")
	private Date fecha=new Date();;
	
	
	@Column(name="TOTAL_PAGO_FINAL")
	private Double totPagFin;
	

	@Column(name = "TIPO_COMPROBANTE")
	private String tComprobante;
	

	@Column(name = "HISTORIAL_COMPRAS_ID")
	private String hisComp;
	

	@Column(name = "REGALOS_ID_REGALO")
	private Integer regalo;
	
	
	public Comprobante() {
		
	}
	
	

	public Comprobante(@NotEmpty Double pagCar, @NotEmpty Integer totPlaCom, @NotEmpty Double totPagFin,
			String tComprobante, String hisComp) {
		super();
		this.pagCar = pagCar;
		this.totPlaCom = totPlaCom;
		this.totPagFin = totPagFin;
		this.tComprobante = tComprobante;
		this.hisComp = hisComp;
	}





	public Comprobante(Double pagCar, Integer totPlaCom, Double totPagFin, String tComprobante, String hisComp,
			Integer regalo) {
		super();
		this.pagCar = pagCar;
		this.totPlaCom = totPlaCom;
		this.totPagFin = totPagFin;
		this.tComprobante = tComprobante;
		this.hisComp = hisComp;
		this.regalo = regalo;
	}







	public Integer getIdCar() {
		return idCar;
	}



	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}



	public Double getPagCar() {
		return pagCar;
	}



	public void setPagCar(Double pagCar) {
		this.pagCar = pagCar;
	}



	public Integer getTotPlaCom() {
		return totPlaCom;
	}



	public void setTotPlaCom(Integer totPlaCom) {
		this.totPlaCom = totPlaCom;
	}



	


	public Double getTotPagFin() {
		return totPagFin;
	}



	public void setTotPagFin(Double totPagFin) {
		this.totPagFin = totPagFin;
	}



	public String gettComprobante() {
		return tComprobante;
	}



	public void settComprobante(String tComprobante) {
		this.tComprobante = tComprobante;
	}



	public String getHisComp() {
		return hisComp;
	}



	public void setHisComp(String hisComp) {
		this.hisComp = hisComp;
	}




	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}






	public Integer getRegalo() {
		return regalo;
	}



	public void setRegalo(Integer regalo) {
		this.regalo = regalo;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
