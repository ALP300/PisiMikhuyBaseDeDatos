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
@Table(name="HISTORIAL_REGALOS")
public class Historial_Regalos{
	
	@Id
	@NotEmpty
	@Column(name="ID_HISTORIAL_REGALO")
	private String idHisReg;
	@NotNull
	@Column(name="REGALOS_DISPONIBLES")
	private Integer regDis;
	@NotNull
	@Column(name="REGALOS_USADOS")
	private Integer regUsa;

	@Column(name = "CLIENTES_IDEN_CLIENTE")
	private String cliente;
	public String getIdHisReg() {
		return idHisReg;
	}
	public void setIdHisReg(String idHisReg) {
		this.idHisReg = idHisReg;
	}

	public Integer getRegDis() {
		return regDis;
	}
	public void setRegDis(Integer regDis) {
		this.regDis = regDis;
	}
	public Integer getRegUsa() {
		return regUsa;
	}
	public void setRegUsa(Integer regUsa) {
		this.regUsa = regUsa;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	


}
