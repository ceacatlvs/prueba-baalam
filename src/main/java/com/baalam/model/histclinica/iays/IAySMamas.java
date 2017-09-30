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
 * Entity implementation class for Entity: IAySMamas
 *
 */
@Entity
@Table( name = "iays_mamas",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySMamas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "mastalgiaCiclica", columnDefinition="BIT(1)")
	private Boolean mastalgiaCiclica;
	
	@Column(name = "mastalgiaNoCiclica", columnDefinition="BIT(1)")
	private Boolean mastalgiaNoCiclica;
	
	@Column(name = "nodulos", columnDefinition="BIT(1)")
	private Boolean nodulos;
	
	@Column(name = "cambiosPiel", columnDefinition="BIT(1)")
	private Boolean cambiosPiel;
	
	@Column(name = "cambiosPezon", columnDefinition="BIT(1)")
	private Boolean cambiosPezon;
	
	@Column(name = "secrecionPezon", columnDefinition="BIT(1)")
	private Boolean secrecionPezon;
	
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

	public Boolean getMastalgiaCiclica() {
		return mastalgiaCiclica;
	}

	public void setMastalgiaCiclica(Boolean mastalgiaCiclica) {
		this.mastalgiaCiclica = mastalgiaCiclica;
	}

	public Boolean getMastalgiaNoCiclica() {
		return mastalgiaNoCiclica;
	}

	public void setMastalgiaNoCiclica(Boolean mastalgiaNoCiclica) {
		this.mastalgiaNoCiclica = mastalgiaNoCiclica;
	}

	public Boolean getNodulos() {
		return nodulos;
	}

	public void setNodulos(Boolean nodulos) {
		this.nodulos = nodulos;
	}

	public Boolean getCambiosPiel() {
		return cambiosPiel;
	}

	public void setCambiosPiel(Boolean cambiosPiel) {
		this.cambiosPiel = cambiosPiel;
	}

	public Boolean getCambiosPezon() {
		return cambiosPezon;
	}

	public void setCambiosPezon(Boolean cambiosPezon) {
		this.cambiosPezon = cambiosPezon;
	}

	public Boolean getSecrecionPezon() {
		return secrecionPezon;
	}

	public void setSecrecionPezon(Boolean secrecionPezon) {
		this.secrecionPezon = secrecionPezon;
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