package com.fia.sem7.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INGREDIENTES")
public class Ingredientes {
	
    @Id
    @Column(name = "ID_INGREDIENTE")
    private String id_Ingrediente;
    
    @Column(name = "NOMBRE_INGREDIENTE")
    private String nombre_Ingrediente;
    
    @Column(name = "PRECIO_INGREDIENTE")
    private double precio_Ingrediente;
    
    @Column(name = "VITAMINAS")
    private double vitaminas;
    
    @Column(name = "MINERALES")
    private double minerales;
    
    @Column(name = "CARBOHIDRATOS")
    private double carbohidratos;
    

    public Ingredientes() {
        // Constructor sin argumentos requerido por JPA/Hibernate
    }


	public Ingredientes(String id_Ingrediente, String nombre_Ingrediente, double precio_Ingrediente, double vitaminas,
			double minerales, double carbohidratos) {
		super();
		this.id_Ingrediente = id_Ingrediente;
		this.nombre_Ingrediente = nombre_Ingrediente;
		this.precio_Ingrediente = precio_Ingrediente;
		this.vitaminas = vitaminas;
		this.minerales = minerales;
		this.carbohidratos = carbohidratos;
	}


	public String getId_Ingrediente() {
		return id_Ingrediente;
	}


	public void setId_Ingrediente(String id_Ingrediente) {
		this.id_Ingrediente = id_Ingrediente;
	}


	public String getNombre_Ingrediente() {
		return nombre_Ingrediente;
	}


	public void setNombre_Ingrediente(String nombre_Ingrediente) {
		this.nombre_Ingrediente = nombre_Ingrediente;
	}


	public double getPrecio_Ingrediente() {
		return precio_Ingrediente;
	}


	public void setPrecio_Ingrediente(double precio_Ingrediente) {
		this.precio_Ingrediente = precio_Ingrediente;
	}


	public double getVitaminas() {
		return vitaminas;
	}


	public void setVitaminas(double vitaminas) {
		this.vitaminas = vitaminas;
	}


	public double getMinerales() {
		return minerales;
	}


	public void setMinerales(double minerales) {
		this.minerales = minerales;
	}


	public double getCarbohidratos() {
		return carbohidratos;
	}


	public void setCarbohidratos(double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

 

}


