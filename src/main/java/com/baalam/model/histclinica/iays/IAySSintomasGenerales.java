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
 * Entity implementation class for Entity: IAySSintomasGenerales
 *
 */
@Entity
@Table( name = "iays_sintomas_grales",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))

public class IAySSintomasGenerales implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "fiebre", columnDefinition="BIT(1)")
	private Boolean fiebre;
	
	@Column(name = "fatiga", columnDefinition="BIT(1)")
	private Boolean fatiga;
	
	@Column(name = "perdidaPeso", columnDefinition="BIT(1)")
	private Boolean perdidaPeso;
	
	@Column(name = "aumentoPeso", columnDefinition="BIT(1)")
	private Boolean aumentoPeso;
	
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

	public Boolean getFiebre() {
		return fiebre;
	}

	public void setFiebre(Boolean fiebre) {
		this.fiebre = fiebre;
	}

	public Boolean getFatiga() {
		return fatiga;
	}

	public void setFatiga(Boolean fatiga) {
		this.fatiga = fatiga;
	}

	public Boolean getPerdidaPeso() {
		return perdidaPeso;
	}

	public void setPerdidaPeso(Boolean perdidaPeso) {
		this.perdidaPeso = perdidaPeso;
	}

	public Boolean getAumentoPeso() {
		return aumentoPeso;
	}

	public void setAumentoPeso(Boolean aumentoPeso) {
		this.aumentoPeso = aumentoPeso;
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

	@Override
	public String toString() {
		return "IAySSintomasGenerales [paciente=" + paciente + ", negativo="
				+ negativo + ", fiebre=" + fiebre + ", fatiga=" + fatiga
				+ ", perdidaPeso=" + perdidaPeso + ", aumentoPeso="
				+ aumentoPeso + ", otro=" + otro + ", observaciones="
				+ observaciones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aumentoPeso == null) ? 0 : aumentoPeso.hashCode());
		result = prime * result + ((fatiga == null) ? 0 : fatiga.hashCode());
		result = prime * result + ((fiebre == null) ? 0 : fiebre.hashCode());
		result = prime * result
				+ ((negativo == null) ? 0 : negativo.hashCode());
		result = prime * result
				+ ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((otro == null) ? 0 : otro.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result
				+ ((perdidaPeso == null) ? 0 : perdidaPeso.hashCode());
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
		IAySSintomasGenerales other = (IAySSintomasGenerales) obj;
		if (aumentoPeso == null) {
			if (other.aumentoPeso != null)
				return false;
		} else if (!aumentoPeso.equals(other.aumentoPeso))
			return false;
		if (fatiga == null) {
			if (other.fatiga != null)
				return false;
		} else if (!fatiga.equals(other.fatiga))
			return false;
		if (fiebre == null) {
			if (other.fiebre != null)
				return false;
		} else if (!fiebre.equals(other.fiebre))
			return false;
		if (negativo == null) {
			if (other.negativo != null)
				return false;
		} else if (!negativo.equals(other.negativo))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (otro == null) {
			if (other.otro != null)
				return false;
		} else if (!otro.equals(other.otro))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (perdidaPeso == null) {
			if (other.perdidaPeso != null)
				return false;
		} else if (!perdidaPeso.equals(other.perdidaPeso))
			return false;
		return true;
	}	
}