package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySEndocrino
 *
 */
@Entity
@Table( name = "iays_endocrino",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySEndocrino implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "diabetes", columnDefinition="BIT(1)")
	private Boolean diabetes;
	
	@Column(name = "hipotiroidea", columnDefinition="BIT(1)")
	private Boolean hipotiroidea;
	
	@Column(name = "hipertiroidea", columnDefinition="BIT(1)")
	private Boolean hipertiroidea;
	
	@Column(name = "bochornos", columnDefinition="BIT(1)")
	private Boolean bochornos;
	
	@Column(name = "caidaCabello", columnDefinition="BIT(1)")
	private Boolean caidaCabello;
	
	@Column(name = "intoleranciaFrio", columnDefinition="BIT(1)")
	private Boolean intoleranciaFrio;
	
	@Column(name = "intoleranciaCalor", columnDefinition="BIT(1)")
	private Boolean intoleranciaCalor;

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

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getHipotiroidea() {
		return hipotiroidea;
	}

	public void setHipotiroidea(Boolean hipotiroidea) {
		this.hipotiroidea = hipotiroidea;
	}

	public Boolean getHipertiroidea() {
		return hipertiroidea;
	}

	public void setHipertiroidea(Boolean hipertiroidea) {
		this.hipertiroidea = hipertiroidea;
	}

	public Boolean getBochornos() {
		return bochornos;
	}

	public void setBochornos(Boolean bochornos) {
		this.bochornos = bochornos;
	}

	public Boolean getCaidaCabello() {
		return caidaCabello;
	}

	public void setCaidaCabello(Boolean caidaCabello) {
		this.caidaCabello = caidaCabello;
	}

	public Boolean getIntoleranciaFrio() {
		return intoleranciaFrio;
	}

	public void setIntoleranciaFrio(Boolean intoleranciaFrio) {
		this.intoleranciaFrio = intoleranciaFrio;
	}

	public Boolean getIntoleranciaCalor() {
		return intoleranciaCalor;
	}

	public void setIntoleranciaCalor(Boolean intoleranciaCalor) {
		this.intoleranciaCalor = intoleranciaCalor;
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