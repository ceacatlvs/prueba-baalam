package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySHematopoyetico
 *
 */
@Entity
@Table( name = "iays_hematopoyetico",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySHematopoyetico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "sangrado", columnDefinition="BIT(1)")
	private Boolean sangrado;
	
	@Column(name = "equimosis", columnDefinition="BIT(1)")
	private Boolean equimosis;
	
	@Column(name = "adenopatias", columnDefinition="BIT(1)")
	private Boolean adenopatias;

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

	public Boolean getSangrado() {
		return sangrado;
	}

	public void setSangrado(Boolean sangrado) {
		this.sangrado = sangrado;
	}

	public Boolean getEquimosis() {
		return equimosis;
	}

	public void setEquimosis(Boolean equimosis) {
		this.equimosis = equimosis;
	}

	public Boolean getAdenopatias() {
		return adenopatias;
	}

	public void setAdenopatias(Boolean adenopatias) {
		this.adenopatias = adenopatias;
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