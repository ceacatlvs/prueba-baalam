package com.baalam.model.histclinica.ant.go;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "ago_ultimos_estudios",
		uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class AGOUltimosEstudios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "fechaUltimaCitologiaCervical")
	private Date fechaUltimaCitologia;
	
	@Column(name = "resultadoUltimaCC")
	@Size(min = 0, max = 10)
	private String resultadoUltimaCC;
	
	@Column(name = "observacionesUltimaCC")
	@Size(min = 0, max = 500)
	private String observacionesUltimaCC;
	
	@Column(name = "autoexploracionMamaria", columnDefinition="BIT(1)")
	private Boolean autoexploracionMamaria;
	
	@Column(name = "observacionesAutoMamaria")
	@Size(min = 0, max = 500)
	private String observacionesAutoMamaria;
	
	@Column(name = "fechaUltimaMamografia")
	private Date fechaUltimaMamografia;
	
	@Column(name = "observacionesMamografia")
	@Size(min = 0, max = 500)
	private String observacionesMamografia;
	
	@Column(name = "fechaUltimaDensitometria")
	private Date fechaUltimaDensitometria;
	
	@Column(name = "observacionesUltimaDensitometria")
	@Size(min = 0, max = 500)
	private String observacionesUltimaDensitometria;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFechaUltimaCitologia() {
		return fechaUltimaCitologia;
	}

	public void setFechaUltimaCitologia(Date fechaUltimaCitologia) {
		this.fechaUltimaCitologia = fechaUltimaCitologia;
	}

	public String getResultadoUltimaCC() {
		return resultadoUltimaCC;
	}

	public void setResultadoUltimaCC(String resultadoUltimaCC) {
		this.resultadoUltimaCC = resultadoUltimaCC;
	}

	public String getObservacionesUltimaCC() {
		return observacionesUltimaCC;
	}

	public void setObservacionesUltimaCC(String observacionesUltimaCC) {
		this.observacionesUltimaCC = observacionesUltimaCC;
	}

	public Boolean getAutoexploracionMamaria() {
		return autoexploracionMamaria;
	}

	public void setAutoexploracionMamaria(Boolean autoexploracionMamaria) {
		this.autoexploracionMamaria = autoexploracionMamaria;
	}

	public String getObservacionesAutoMamaria() {
		return observacionesAutoMamaria;
	}

	public void setObservacionesAutoMamaria(String observacionesAutoMamaria) {
		this.observacionesAutoMamaria = observacionesAutoMamaria;
	}

	public Date getFechaUltimaMamografia() {
		return fechaUltimaMamografia;
	}

	public void setFechaUltimaMamografia(Date fechaUltimaMamografia) {
		this.fechaUltimaMamografia = fechaUltimaMamografia;
	}

	public String getObservacionesMamografia() {
		return observacionesMamografia;
	}

	public void setObservacionesMamografia(String observacionesMamografia) {
		this.observacionesMamografia = observacionesMamografia;
	}

	public Date getFechaUltimaDensitometria() {
		return fechaUltimaDensitometria;
	}

	public void setFechaUltimaDensitometria(Date fechaUltimaDensitometria) {
		this.fechaUltimaDensitometria = fechaUltimaDensitometria;
	}

	public String getObservacionesUltimaDensitometria() {
		return observacionesUltimaDensitometria;
	}

	public void setObservacionesUltimaDensitometria(
			String observacionesUltimaDensitometria) {
		this.observacionesUltimaDensitometria = observacionesUltimaDensitometria;
	}
}