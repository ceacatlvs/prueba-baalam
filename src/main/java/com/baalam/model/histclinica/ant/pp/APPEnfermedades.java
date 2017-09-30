package com.baalam.model.histclinica.ant.pp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatEnfEdoActual;
import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "app_enfermedades",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAppEnfermedades"))
public class APPEnfermedades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppEnfermedades")
	private Long idAppEnfermedades;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;	
	
	@Column(name="nombreEnfermedad")
	private String nombreEnfermedad;
	
	@Column(name = "fechaDiagnostico")
	private Date fechaDiagnostico;
	
	@ManyToOne
	@JoinColumn(name="idCatEnfEdoActual")
	private CatEnfEdoActual idCatEnfEdoActual;
	
	@Column(name = "tratamiento")
	@Size(min = 0, max = 500)
	private String tratamiento;

	public Long getIdAppEnfermedades() {
		return idAppEnfermedades;
	}

	public void setIdAppEnfermedades(Long idAppEnfermedades) {
		this.idAppEnfermedades = idAppEnfermedades;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}

	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}

	public CatEnfEdoActual getIdCatEnfEdoActual() {
		return idCatEnfEdoActual;
	}

	public void setIdCatEnfEdoActual(CatEnfEdoActual idCatEnfEdoActual) {
		this.idCatEnfEdoActual = idCatEnfEdoActual;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Override
	public String toString() {
		return "APPEnfermedades [idAppEnfermedades=" + idAppEnfermedades
				+ ", idPaciente=" + paciente + ", enfermedad="
				+ nombreEnfermedad + ", fechaDiagnostico=" + fechaDiagnostico
				+ ", idCatEnfEdoActual=" + idCatEnfEdoActual + ", tratamiento="
				+ tratamiento + "]";
	}
}