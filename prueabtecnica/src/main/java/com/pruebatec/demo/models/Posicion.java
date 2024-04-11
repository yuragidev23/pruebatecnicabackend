package com.pruebatec.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posicion")
public class Posicion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idposicion;

    @Column(name = "posicionjugador", nullable = false)
    private String posicionjugador;
    
    
    
    
    
    
    //Constructors
    public Posicion() {
	}

	public Posicion(int idposicion, String posicionjugador) {
		this.idposicion = idposicion;
		this.posicionjugador = posicionjugador;
	}
	
	

	//Getters and Setters

	public int getIdposicion() {
		return idposicion;
	}

	public void setIdposicion(int idposicion) {
		this.idposicion = idposicion;
	}

	public String getPosicionjugador() {
		return posicionjugador;
	}

	public void setPosicionjugador(String posicionjugador) {
		this.posicionjugador = posicionjugador;
	}
    
}
