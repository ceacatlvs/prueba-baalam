package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySEsferaMental
 *
 */
@Entity
@Table( name = "iays_esfera_mental",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySEsferaMental implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "ansiedadSevera", columnDefinition="BIT(1)")
	private Boolean ansiedadSevera;
	
	@Column(name = "depresion", columnDefinition="BIT(1)")
	private Boolean depresion;
	
	@Column(name = "labilidadEmocional", columnDefinition="BIT(1)")
	private Boolean labilidadEmocional;
	
	@Column(name = "irritabilidad", columnDefinition="BIT(1)")
	private Boolean irritabilidad;

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

	public Boolean getAnsiedadSevera() {
		return ansiedadSevera;
	}

	public void setAnsiedadSevera(Boolean ansiedadSevera) {
		this.ansiedadSevera = ansiedadSevera;
	}

	public Boolean getDepresion() {
		return depresion;
	}

	public void setDepresion(Boolean depresion) {
		this.depresion = depresion;
	}

	public Boolean getLabilidadEmocional() {
		return labilidadEmocional;
	}

	public void setLabilidadEmocional(Boolean labilidadEmocional) {
		this.labilidadEmocional = labilidadEmocional;
	}

	public Boolean getIrritabilidad() {
		return irritabilidad;
	}

	public void setIrritabilidad(Boolean irritabilidad) {
		this.irritabilidad = irritabilidad;
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