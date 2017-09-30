package com.baalam.model.histclinica.iays;

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

/**
 * Entity implementation class for Entity: IAySVista
 *
 */
@Entity
@Table( name = "iays_vista",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySVista implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "fosfenos", columnDefinition="BIT(1)")
	private Boolean fosfenos;
	
	@Column(name = "cambiosVision", columnDefinition="BIT(1)")
	private Boolean cambiosVision;
	
	@Column(name = "lentes", columnDefinition="BIT(1)")
	private Boolean lentes;
	
	@Size(min = 0, max = 500)
	@Column(name = "otro")
	private String otro;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Boolean getNegativo() {
		return negativo;
	}

	public void setNegativo(Boolean negativo) {
		this.negativo = negativo;
	}

	public Boolean getFosfenos() {
		return fosfenos;
	}

	public void setFosfenos(Boolean fosfenos) {
		this.fosfenos = fosfenos;
	}

	public Boolean getCambiosVision() {
		return cambiosVision;
	}

	public void setCambiosVision(Boolean cambiosVision) {
		this.cambiosVision = cambiosVision;
	}

	public Boolean getLentes() {
		return lentes;
	}

	public void setLentes(Boolean lentes) {
		this.lentes = lentes;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
   
}