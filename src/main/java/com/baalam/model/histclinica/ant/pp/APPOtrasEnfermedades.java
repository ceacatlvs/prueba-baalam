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
import com.baalam.model.catalogo.CatEnfermedad;
import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: APPOtrasEnfermedades
 *
 */
@Entity
@Table(name="app_otras_enfermedades",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAppOtrasEnfermedades"))

public class APPOtrasEnfermedades implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppOtrasEnfermedades")
	private Long idAppOtrasEnfermedades;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "nombre")
	@Size(min = 0, max = 500)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idCatEnfermedad", nullable = true)
	private CatEnfermedad idCatEnfermedad;
	
	@Column(name = "fechaDiagnostico")
	private Date fechaDiagnostico;
	
	@ManyToOne
	@JoinColumn(name="idCatEnfEdoActual")
	private CatEnfEdoActual idCatEnfEdoActual;
	
	@Column(name = "tratamiento")
	@Size(min = 0, max = 500)
	private String tratamiento;

	public Long getIdAppOtrasEnfermedades() {
		return idAppOtrasEnfermedades;
	}

	public void setIdAppOtrasEnfermedades(Long idAppOtrasEnfermedades) {
		this.idAppOtrasEnfermedades = idAppOtrasEnfermedades;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public CatEnfermedad getIdCatEnfermedad() {
		return idCatEnfermedad;
	}

	public void setIdCatEnfermedad(CatEnfermedad idCatEnfermedad) {
		this.idCatEnfermedad = idCatEnfermedad;
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
		return "APPOtrasEnfermedades [idAppOtrasEnfermedades="
				+ idAppOtrasEnfermedades + ", paciente=" + paciente
				+ ", nombre=" + nombre + ", fechaDiagnostico="
				+ fechaDiagnostico + ", idCatEnfEdoActual=" + idCatEnfEdoActual
				+ ", tratamiento=" + tratamiento + "]";
	}

}
