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
 * Entity implementation class for Entity: IAySPiel
 *
 */
@Entity
@Table( name = "iays_piel",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySPiel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "eritema", columnDefinition="BIT(1)")
	private Boolean eritema;
	
	@Column(name = "papulas", columnDefinition="BIT(1)")
	private Boolean papulas;
	
	@Column(name = "ulceras", columnDefinition="BIT(1)")
	private Boolean ulceras;

	@Column(name = "lesionesPigmentadas", columnDefinition="BIT(1)")
	private Boolean lesionesPigmentadas;
	
	@Column(name = "pielSeca", columnDefinition="BIT(1)")
	private Boolean pielSeca;
	
	@Column(name = "caidaCabello", columnDefinition="BIT(1)")
	private Boolean caidaCabello;
	
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

	public Boolean getEritema() {
		return eritema;
	}

	public void setEritema(Boolean eritema) {
		this.eritema = eritema;
	}

	public Boolean getPapulas() {
		return papulas;
	}

	public void setPapulas(Boolean papulas) {
		this.papulas = papulas;
	}

	public Boolean getUlceras() {
		return ulceras;
	}

	public void setUlceras(Boolean ulceras) {
		this.ulceras = ulceras;
	}

	public Boolean getLesionesPigmentadas() {
		return lesionesPigmentadas;
	}

	public void setLesionesPigmentadas(Boolean lesionesPigmentadas) {
		this.lesionesPigmentadas = lesionesPigmentadas;
	}

	public Boolean getPielSeca() {
		return pielSeca;
	}

	public void setPielSeca(Boolean pielSeca) {
		this.pielSeca = pielSeca;
	}

	public Boolean getCaidaCabello() {
		return caidaCabello;
	}

	public void setCaidaCabello(Boolean caidaCabello) {
		this.caidaCabello = caidaCabello;
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