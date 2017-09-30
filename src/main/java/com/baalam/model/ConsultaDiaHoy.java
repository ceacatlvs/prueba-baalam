package com.baalam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.baalam.model.paciente.PacienteDetalle;

/**
 * Entity implementation class for Entity: ConsultaDiaHoy
 * agregar columna de consulta dada para saber si la consulta de esa cita ya fue o no ha sido 
 */
@Entity
@Table(name="consultas_dia_hoy")
public class ConsultaDiaHoy extends PacienteDetalle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idCita;
	private Long idCPCobroConsulta;
	
	private Date fechaCitaInicio;
	private Date fechaCitaFin;
	private String tipoConsulta;
	private Double monto; 
	private Boolean consultaDada;

	public Long getIdCita() {
		return idCita;
	}
	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}
	
	public Long getIdCPCobroConsulta() {
		return idCPCobroConsulta;
	}
	public void setIdCPCobroConsulta(Long idCPCobroConsulta) {
		this.idCPCobroConsulta = idCPCobroConsulta;
	}
	
	public Date getFechaCitaInicio() {
		return fechaCitaInicio;
	}
	public void setFechaCitaInicio(Date fechaCitaInicio) {
		this.fechaCitaInicio = fechaCitaInicio;
	}
	
	public Date getFechaCitaFin() {
		return fechaCitaFin;
	}
	public void setFechaCitaFin(Date fechaCitaFin) {
		this.fechaCitaFin = fechaCitaFin;
	}
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	public Boolean getConsultaDada() {
		return consultaDada;
	}
	public void setConsultaDada(Boolean consultaDada) {
		this.consultaDada = consultaDada;
	}
	
	@Override
	public String toString() {
		return "ConsultaDiaHoy [idCita=" + idCita + ", idCPCobroConsulta="
				+ idCPCobroConsulta + ", fechaCitaInicio=" + fechaCitaInicio
				+ ", fechaCitaFin=" + fechaCitaFin + ", tipoConsulta="
				+ tipoConsulta + ", monto=" + monto + ", consultaDada="
				+ consultaDada + "]";
	}
}