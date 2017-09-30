package com.baalam.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseController implements Serializable {
	
	private static final long serialVersionUID = 1441838121233106346L;

	/**
	 * ResourceBundle que contiene las rutas de las vistas
	 */
	protected ResourceBundle rutas;
	
	protected static Date fechaHoy;
	
	public BaseController() {
		rutas = ResourceBundle.getBundle("com.baalam.rutas");
		fechaHoy = new Date();
	}
	
	public Date getFechaHoy() {
		return fechaHoy;
	}
	
	public boolean validarFecha(Date fecha) {
		if (fecha.before(fechaHoy)) {
			System.out.println("La fecha " + fecha + " es válida");
			return true;
		}
		
		System.out.println("La fecha " + fecha + " NO es válida");
		FacesContext.getCurrentInstance().addMessage("agoFechaNacimiento", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje", "La fecha es mayor al día de hoy"));
		return false;
	}
	
	/*1 consulta 1era vez
	 *2 consulta subsecuente
	 *3 ver detalle
	 * */
	public abstract String registrar(Long modo);
	public abstract String cancelar();

}
