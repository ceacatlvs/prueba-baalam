package com.baalam.model.histclinica.ant.pp;

import java.io.Serializable;
import java.util.Date;

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
@Table( name = "app_cirugias",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAppCirugias"))
public class APPHospYCirugias implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppCirugias")
	private Long idAppCirugias;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "causa")
	@Size(min = 0, max = 500)
	private String causa;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "hospital")
	@Size(min = 0, max = 100)
	private String hospital;
	
	@Column(name = "edoActual")
	@Size(min = 0, max = 100)
	private String edoActual;

	public Long getIdAppCirugias() {
		return idAppCirugias;
	}

	public void setIdAppCirugias(Long idAppCirugias) {
		this.idAppCirugias = idAppCirugias;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getEdoActual() {
		return edoActual;
	}

	public void setEdoActual(String edoActual) {
		this.edoActual = edoActual;
	}
}