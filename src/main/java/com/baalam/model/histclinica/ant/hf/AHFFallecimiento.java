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
@Table( name = "ahf_fallecimientos",
		uniqueConstraints = @UniqueConstraint(columnNames = "idFamiliar"))
public class AHFFallecimiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idFamiliar")
	private Long idFamiliar;
	
	@Size(min = 0, max = 50)
	@Column(name = "parentesco")
	private String parentesco;
	
	@Column(name = "edad")
	private String edad;
	
	@Size(min = 0, max = 200)
	@Column(name = "causa")
	private String causa;
	
	@Column(name = "fallecido", columnDefinition="BIT(1)")
	private Boolean fallecido;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;

	public Long getIdFamiliar() {
		return idFamiliar;
	}

	public void setIdFamiliar(Long idFamiliar) {
		this.idFamiliar = idFamiliar;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Boolean getFallecido() {
		return fallecido;
	}

	public void setFallecido(Boolean fallecido) {
		this.fallecido = fallecido;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "AHFFallecimientos [idFamiliar=" + idFamiliar + ", parentesco="
				+ parentesco + ", edad=" + edad + ", causa=" + causa
				+ ", fallecido=" + fallecido + ", idPaciente=" + paciente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causa == null) ? 0 : causa.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result
				+ ((idFamiliar == null) ? 0 : idFamiliar.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result
				+ ((parentesco == null) ? 0 : parentesco.hashCode());
		result = prime * result + ((fallecido == null) ? 0 : fallecido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AHFFallecimiento other = (AHFFallecimiento) obj;
		if (causa == null) {
			if (other.causa != null)
				return false;
		} else if (!causa.equals(other.causa))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (idFamiliar == null) {
			if (other.idFamiliar != null)
				return false;
		} else if (!idFamiliar.equals(other.idFamiliar))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (parentesco == null) {
			if (other.parentesco != null)
				return false;
		} else if (!parentesco.equals(other.parentesco))
			return false;
		if (fallecido == null) {
			if (other.fallecido != null)
				return false;
		} else if (!fallecido.equals(other.fallecido))
			return false;
		return true;
	}
	
}
