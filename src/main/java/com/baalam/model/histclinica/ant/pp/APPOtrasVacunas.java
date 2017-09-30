package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.paciente.Paciente;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: APPOtrasVacunas
 *
 */
@Entity
@Table( name = "app_otras_vacunas",
uniqueConstraints = @UniqueConstraint(columnNames = "idAppOtrasVacunas"))
public class APPOtrasVacunas implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppOtrasVacunas")
	private Long idAppOtrasVacunas;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "observaciones")
	@Size(min = 0, max = 300)
	private String observaciones;
  
	public Long getIdAppOtrasVacunas() {
		return this.idAppOtrasVacunas;
	}

	public void setIdAppOtrasVacunas(Long idAppOtrasVacunas) {
		this.idAppOtrasVacunas = idAppOtrasVacunas;
	}   
	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}   
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}   
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "APPOtrasVacunas [idAppOtrasVacunas=" + idAppOtrasVacunas
				+ ", paciente=" + paciente + ", fecha=" + fecha
				+ ", observaciones=" + observaciones + "]";
	}
}