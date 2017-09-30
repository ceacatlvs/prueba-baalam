package com.baalam.model.histclinica.ant.go;

import java.io.Serializable;

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
@Table( name = "ago_obstetrica",
		uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class AGOObstetrica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "embarazos")
	private Integer embarazos;
	
	@Column(name = "abortos")
	private Integer abortos;
	
	@Column(name = "obitos")
	private Integer obitos;
	
	@Column(name = "prematuros")
	private Integer prematuros;
	
	@Column(name = "nacidosVivos")
	private Integer nacidosVivos;
	
	@Column(name = "vivosActuales")
	private Integer vivosActuales;
	
	@Column(name = "observaciones")
	@Size(min = 0, max = 500)
	private String observaciones;

	public Paciente getIdPaciente() {
		return paciente;
	}

	public void setIdPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getEmbarazos() {
		return embarazos;
	}

	public void setEmbarazos(Integer embarazos) {
		this.embarazos = embarazos;
	}

	public Integer getAbortos() {
		return abortos;
	}

	public void setAbortos(Integer abortos) {
		this.abortos = abortos;
	}

	public Integer getObitos() {
		return obitos;
	}

	public void setObitos(Integer obitos) {
		this.obitos = obitos;
	}

	public Integer getPrematuros() {
		return prematuros;
	}

	public void setPrematuros(Integer prematuros) {
		this.prematuros = prematuros;
	}

	public Integer getNacidosVivos() {
		return nacidosVivos;
	}

	public void setNacidosVivos(Integer nacidosVivos) {
		this.nacidosVivos = nacidosVivos;
	}

	public Integer getVivosActuales() {
		return vivosActuales;
	}

	public void setVivosActuales(Integer vivosActuales) {
		this.vivosActuales = vivosActuales;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
