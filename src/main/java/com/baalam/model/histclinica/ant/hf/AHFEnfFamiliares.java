package com.baalam.model.histclinica.ant.hf;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "ahf_enfermedades_familiares",
		uniqueConstraints = @UniqueConstraint(columnNames = "idEnfermedad"))
public class AHFEnfFamiliares implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEnfermedad")
	private Long idEnfermedad;
	
	@Size(min = 0, max = 50)
	@Column(name = "parentesco")
	private String parentesco;
	
	@Column(name = "edadInicio")
	private Integer edadInicio;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;
	
	@Size(min = 0, max = 50)
	@Column(name = "enfermedad")
	private String enfermedad;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;

	public Long getIdEnfermedad() {
		return idEnfermedad;
	}

	public void setIdEnfermedad(Long idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Integer getEdadInicio() {
		return edadInicio;
	}

	public void setEdadInicio(Integer edadInicio) {
		this.edadInicio = edadInicio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "EnfermedadesFamiliares [idEnfermedad=" + idEnfermedad
				+ ", parentesco=" + parentesco + ", edadInicio=" + edadInicio
				+ ", observaciones=" + observaciones
				+ ", enfermedad=" + enfermedad
				+ ", paciente=" + paciente + "]";
	}
	
}
