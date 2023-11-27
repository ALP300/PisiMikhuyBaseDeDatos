package com.fia.sem7.models.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCTOS")
public class Producto{


	@Id
	@NotEmpty
	@Column(name="ID_PRODUCTO")
	private String idProd;
	
	@NotEmpty
	@Column(name="NOMBRE")
	private String nomPla;
	
	@NotNull
	@Column(name="PRECIO_VENTA")
	private Integer precio;
	
	@NotNull
	@Column(name="COSTO_TOTAL")
	private Integer cosTot;
	
	@NotEmpty
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="IMAGEN")
	private String imagen;
	
	public Producto() {
		
	}
	public Producto(@NotEmpty String idProd, @NotEmpty String nomPla, @NotNull Integer precio, @NotNull Integer cosTot,
			@NotEmpty String descripcion, String imagen) {
		super();
		this.idProd = idProd;
		this.nomPla = nomPla;
		this.precio = precio;
		this.cosTot = cosTot;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}



	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getNomPla() {
		return nomPla;
	}

	public void setNomPla(String nomPla) {
		this.nomPla = nomPla;
	}



	public Integer getPrecio() {
		return precio;
	}



	public void setPrecio(Integer precio) {
		this.precio = precio;
	}



	public Integer getCosTot() {
		return cosTot;
	}

	public void setCosTot(Integer cosTot) {
		this.cosTot = cosTot;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

}
