package com.baalam.model.histclinica.ant.pp;

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
@Table( name = "app_medicacion_actual",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAppMedicacion"))
public class APPMedicacionActual implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppMedicacion")
	private Long idAppMedicacion;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;

	@Column(name = "medicamento")
	@Size(min = 0, max = 100)
	private String medicamento;
	
	@Column(name = "dosis")
	@Size(min = 0, max = 100)
	private String dosis;
	
	@Column(name = "preescribio")
	@Size(min = 0, max = 200)
	private String preescribio;

	public Long getIdAppMedicacion() {
		return idAppMedicacion;
	}

	public void setIdAppMedicacion(Long idAppMedicacion) {
		this.idAppMedicacion = idAppMedicacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente idPaciente) {
		this.paciente = idPaciente;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getPreescribio() {
		return preescribio;
	}

	public void setPreescribio(String preescribio) {
		this.preescribio = preescribio;
	}
}
