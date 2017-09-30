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

import com.baalam.model.catalogo.CatAntecedentesVacunas;
import com.baalam.model.paciente.Paciente;


@Entity
@Table( name = "app_vacunas",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAppVacunas"))
public class APPVacunas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppVacunas")
	private Long idAppVacunas;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="idCatAntVacunas")
	private CatAntecedentesVacunas idCatAntVacunas;
	
	@Column(name = "observaciones")
	@Size(min = 0, max = 300)
	private String observaciones;
	
	@Column(name = "fecha")
	private Date fecha;

	public Long getIdAppVacunas() {
		return idAppVacunas;
	}

	public void setIdAppVacunas(Long idAppVacunas) {
		this.idAppVacunas = idAppVacunas;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setIdPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public CatAntecedentesVacunas getIdCatAntVacunas() {
		return idCatAntVacunas;
	}

	public void setIdCatAntVacunas(CatAntecedentesVacunas idCatAntVacunas) {
		this.idCatAntVacunas = idCatAntVacunas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "APPVacunas [idAppVacunas=" + idAppVacunas + ", idPaciente="
				+ paciente + ", idCatAntVacunas=" + idCatAntVacunas
				+ ", observaciones=" + observaciones + ", fecha=" + fecha + "]";
	}
}