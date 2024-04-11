package com.pruebatec.demo.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "futbolistas")
public class Futbolistas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfutbolista;

	@Column(name = "nombres", nullable = false)
	private String nombres;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "fechanaci", nullable = false)
	private java.util.Date fechanaci;

	@Column(name = "caracteristicas", nullable = false)
	private String caracteristicas;

	@ManyToOne
	@JoinColumn(name = "idposicion", nullable = false)
	private Posicion posicion;

	// Constructors

	public Futbolistas() {
		
	}

	public Futbolistas(Long idfutbolista, String nombres, String apellidos, Date fechanaci, String caracteristicas,
			Posicion posicion) {
		this.idfutbolista = idfutbolista;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechanaci = fechanaci;
		this.caracteristicas = caracteristicas;
		this.posicion = posicion;

		// Getters and Setters
	}

	public Long getIdfutbolista() {
		return idfutbolista;
	}

	public void setIdfutbolista(Long idfutbolista) {
		this.idfutbolista = idfutbolista;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public java.util.Date getFechanaci() {
		return fechanaci;
	}

	public void setFechanaci(java.util.Date fechanaci) {
		this.fechanaci = fechanaci;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
