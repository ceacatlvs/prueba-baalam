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
 * Entity implementation class for Entity: IAySBaof
 *
 */
@Entity
@Table( name = "iays_baof",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))

public class IAySBaof implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "otalgia", columnDefinition="BIT(1)")
	private Boolean otalgia;
	
	@Column(name = "acufenos", columnDefinition="BIT(1)")
	private Boolean acufenos;
	
	@Column(name = "cefalea", columnDefinition="BIT(1)")
	private Boolean cefalea;
	
	@Column(name = "problemasBoca", columnDefinition="BIT(1)")
	private Boolean problemasBoca;
	
	@Column(name = "sinusitis", columnDefinition="BIT(1)")
	private Boolean sinusitis;
	
	@Column(name = "laringitis", columnDefinition="BIT(1)")
	private Boolean laringitis;
	
	@Column(name = "ulceras", columnDefinition="BIT(1)")
	private Boolean ulceras;
	
	@Column(name = "perdidaAudicion", columnDefinition="BIT(1)")
	private Boolean perdidaAudicion;
	
	@Column(name = "problemasDientes", columnDefinition="BIT(1)")
	private Boolean problemasDientes;
	
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

	public Boolean getOtalgia() {
		return otalgia;
	}

	public void setOtalgia(Boolean otalgia) {
		this.otalgia = otalgia;
	}

	public Boolean getAcufenos() {
		return acufenos;
	}

	public void setAcufenos(Boolean acufenos) {
		this.acufenos = acufenos;
	}

	public Boolean getCefalea() {
		return cefalea;
	}

	public void setCefalea(Boolean cefalea) {
		this.cefalea = cefalea;
	}

	public Boolean getProblemasBoca() {
		return problemasBoca;
	}

	public void setProblemasBoca(Boolean problemasBoca) {
		this.problemasBoca = problemasBoca;
	}

	public Boolean getSinusitis() {
		return sinusitis;
	}

	public void setSinusitis(Boolean sinusitis) {
		this.sinusitis = sinusitis;
	}

	public Boolean getLaringitis() {
		return laringitis;
	}

	public void setLaringitis(Boolean laringitis) {
		this.laringitis = laringitis;
	}

	public Boolean getUlceras() {
		return ulceras;
	}

	public void setUlceras(Boolean ulceras) {
		this.ulceras = ulceras;
	}

	public Boolean getPerdidaAudicion() {
		return perdidaAudicion;
	}

	public void setPerdidaAudicion(Boolean perdidaAudicion) {
		this.perdidaAudicion = perdidaAudicion;
	}

	public Boolean getProblemasDientes() {
		return problemasDientes;
	}

	public void setProblemasDientes(Boolean problemasDientes) {
		this.problemasDientes = problemasDientes;
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