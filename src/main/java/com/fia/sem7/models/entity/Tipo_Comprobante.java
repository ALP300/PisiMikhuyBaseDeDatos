package com.fia.sem7.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="TIPO_COMPROBANTE")
public class Tipo_Comprobante{

	
	@Id
	@NotEmpty
	@Column(name="TIPO_COMPROBANTE")
	private String tComp;
	
	@NotEmpty
	@Column(name="DETALLE_COMPROBANTE")
	private String detComp;

	public String gettComp() {
		return tComp;
	}

	public void settComp(String tComp) {
		this.tComp = tComp;
	}

	public String getDetComp() {
		return detComp;
	}

	public void setDetComp(String detComp) {
		this.detComp = detComp;
	}

}
