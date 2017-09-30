package com.baalam.model.histclinica.ant.go;

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
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "ago_otros_anticonceptivos_previos",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAgoOtroAnticonceptivoPrevio"))
public class AGOOtrosAnticonceptivosPrevio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAgoOtroAnticonceptivoPrevio")
	private Long idAgoOtroAnticonceptivoPrevio;
	
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "anosUso")
	private Integer anosUso;
	
	@Column(name = "mesesUso")
	private Integer mesesUso;

	@Column(name = "observaciones")
	@Size(min = 0, max = 200)
	private String observaciones;

	public Long getIdAgoOtroAnticonceptivoPrevio() {
		return idAgoOtroAnticonceptivoPrevio;
	}

	public void setIdAgoOtroAnticonceptivoPrevio(Long idAgoOtroAnticonceptivoPrevio) {
		this.idAgoOtroAnticonceptivoPrevio = idAgoOtroAnticonceptivoPrevio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getAnosUso() {
		return anosUso;
	}

	public void setAnosUso(Integer anosUso) {
		this.anosUso = anosUso;
	}

	public Integer getMesesUso() {
		return mesesUso;
	}

	public void setMesesUso(Integer mesesUso) {
		this.mesesUso = mesesUso;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}