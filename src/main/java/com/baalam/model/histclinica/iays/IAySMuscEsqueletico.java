package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySMuscEsqueletico
 *
 */
@Entity
@Table( name = "iays_musculo_esqueletico",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySMuscEsqueletico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "dolorMuscular", columnDefinition="BIT(1)")
	private Boolean dolorMuscular;
	
	@Column(name = "dolorArticular", columnDefinition="BIT(1)")
	private Boolean dolorArticular;
	
	@Column(name = "debilidadMusc", columnDefinition="BIT(1)")
	private Boolean debilidadMusc;
	
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

	public Boolean getDolorMuscular() {
		return dolorMuscular;
	}

	public void setDolorMuscular(Boolean dolorMuscular) {
		this.dolorMuscular = dolorMuscular;
	}

	public Boolean getDolorArticular() {
		return dolorArticular;
	}

	public void setDolorArticular(Boolean dolorArticular) {
		this.dolorArticular = dolorArticular;
	}

	public Boolean getDebilidadMusc() {
		return debilidadMusc;
	}

	public void setDebilidadMusc(Boolean debilidadMusc) {
		this.debilidadMusc = debilidadMusc;
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