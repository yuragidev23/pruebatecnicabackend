package com.pruebatec.demo.models;

public class FutbolistaDTO {
    private Long idfutbolista;
    private String nombres;
    private String apellidos;
    private java.util.Date fechanaci;
    private String caracteristicas;
    private String posicionJugador; // Solo el nombre de la posición

    // Constructor vacío
    public FutbolistaDTO() {}

    // Constructor para mapear los datos
    public FutbolistaDTO(Futbolistas futbolista) {
        this.idfutbolista = futbolista.getIdfutbolista();
        this.nombres = futbolista.getNombres();
        this.apellidos = futbolista.getApellidos();
        this.fechanaci = futbolista.getFechanaci();
        this.caracteristicas = futbolista.getCaracteristicas();
        // Mapeamos el nombre de la posición
        this.posicionJugador = futbolista.getPosicion().getPosicionjugador();
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

	public String getPosicionJugador() {
		return posicionJugador;
	}

	public void setPosicionJugador(String posicionJugador) {
		this.posicionJugador = posicionJugador;
	}

    // Getters y setters
    
}

