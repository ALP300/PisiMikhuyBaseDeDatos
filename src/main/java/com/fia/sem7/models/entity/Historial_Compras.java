package com.fia.sem7.models.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="HISTORIAL_COMPRAS")
public class Historial_Compras{
	
	@Id
	@NotEmpty
	@Column(name="ID_HISTORIAL_COMPRAS")
	private String idHisCom;
	@NotNull
	@Column(name="TOTAL_COMPRAS")
	private Integer totCom;
	@NotNull
	@Column(name="ABRIR_REGALO")
	private Integer aReg;
	@Column(name = "CLIENTES_IDEN_CLIENTE")
	private String cliente;

	public String getIdHisCom() {
		return idHisCom;
	}
	public void setIdHisCom(String idHisCom) {
		this.idHisCom = idHisCom;
	}


	public Integer getTotCom() {
		return totCom;
	}
	public void setTotCom(Integer totCom) {
		this.totCom = totCom;
	}
	public Integer getaReg() {
		return aReg;
	}
	public void setaReg(Integer aReg) {
		this.aReg = aReg;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
