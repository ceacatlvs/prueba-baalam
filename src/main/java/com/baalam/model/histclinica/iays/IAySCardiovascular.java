package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySCardiovascular
 *
 */
@Entity
@Table( name = "iays_cardiovascular",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySCardiovascular implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "dolorToracico", columnDefinition="BIT(1)")
	private Boolean dolorToracico;
	
	@Column(name = "edema", columnDefinition="BIT(1)")
	private Boolean edema;
	
	@Column(name = "ortopnea", columnDefinition="BIT(1)")
	private Boolean ortopnea;
	
	@Column(name = "palpitaciones", columnDefinition="BIT(1)")
	private Boolean palpitaciones;
	
	@Column(name = "disneaEjercicio", columnDefinition="BIT(1)")
	private Boolean disneaEjercicio;
		
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

	public Boolean getDolorToracico() {
		return dolorToracico;
	}

	public void setDolorToracico(Boolean dolorToracico) {
		this.dolorToracico = dolorToracico;
	}

	public Boolean getEdema() {
		return edema;
	}

	public void setEdema(Boolean edema) {
		this.edema = edema;
	}

	public Boolean getOrtopnea() {
		return ortopnea;
	}

	public void setOrtopnea(Boolean ortopnea) {
		this.ortopnea = ortopnea;
	}

	public Boolean getPalpitaciones() {
		return palpitaciones;
	}

	public void setPalpitaciones(Boolean palpitaciones) {
		this.palpitaciones = palpitaciones;
	}

	public Boolean getDisneaEjercicio() {
		return disneaEjercicio;
	}

	public void setDisneaEjercicio(Boolean disneaEjercicio) {
		this.disneaEjercicio = disneaEjercicio;
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