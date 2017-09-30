package com.baalam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="historial_consultas")
public class HistorialConsultas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idConsulta;	
	private Long idPaciente;
	private Date fechaConsulta;
	private String motivoConsulta;
	private String chOtros;
	private String tipoConsulta;
	
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public Long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	
	public String getChOtros() {
		return chOtros;
	}
	public void setChOtros(String chOtros) {
		this.chOtros = chOtros;
	}
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	@Override
	public String toString() {
		return "HistorialConsultas [idConsulta=" + idConsulta + ", idPaciente="
				+ idPaciente + ", fechaConsulta=" + fechaConsulta
				+ ", motivoConsulta=" + motivoConsulta + ", chOtros=" + chOtros
				+ ", tipoConsulta= " + tipoConsulta + "]";
	}
}