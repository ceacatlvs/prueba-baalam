package com.baalam.model.histclinica.id;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatEspecialidad;
import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: ImpresionDiagnostica
 *
 */
@Entity
@Table( name = "consulta_impresion_diagnostica",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class ImpresionDiagnostica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "planInformacion", columnDefinition="BIT(1)")
	private Boolean planInformacion;
	
	@Column(name = "planTratMedico", columnDefinition="BIT(1)")
	private Boolean planTratMedico;
	
	@Column(name = "planTratQuirurgico", columnDefinition="BIT(1)")
	private Boolean planTratQuirurgico;
	
	@Column(name = "planNotas")
	@Size(min = 0, max = 500)
	private String planNotas;
	
	@Column(name = "interconsulta", columnDefinition="BIT(1)")
	private Boolean interconsulta;
	
	@OneToOne
	@JoinColumn(name="idCatEspecialidad")
	private CatEspecialidad catEspecialidad;
	
	@Column(name = "proximaVisita")
	@Future
	private Date proximaVisita;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getPlanInformacion() {
		return planInformacion;
	}

	public void setPlanInformacion(Boolean planInformacion) {
		this.planInformacion = planInformacion;
	}

	public Boolean getPlanTratMedico() {
		return planTratMedico;
	}

	public void setPlanTratMedico(Boolean planTratMedico) {
		this.planTratMedico = planTratMedico;
	}

	public Boolean getPlanTratQuirurgico() {
		return planTratQuirurgico;
	}

	public void setPlanTratQuirurgico(Boolean planTratQuirurgico) {
		this.planTratQuirurgico = planTratQuirurgico;
	}
	
	public String getPlanNotas() {
		return planNotas;
	}

	public void setPlanNotas(String planNotas) {
		this.planNotas = planNotas;
	}

	public Boolean getInterconsulta() {
		return interconsulta;
	}

	public void setInterconsulta(Boolean interconsulta) {
		this.interconsulta = interconsulta;
	}

	public CatEspecialidad getCatEspecialidad() {
		return catEspecialidad;
	}

	public void setCatEspecialidad(CatEspecialidad catEspecialidad) {
		this.catEspecialidad = catEspecialidad;
	}

	public Date getProximaVisita() {
		return proximaVisita;
	}

	public void setProximaVisita(Date proximaVisita) {
		this.proximaVisita = proximaVisita;
	}

	@Override
	public String toString() {
		return "ImpresionDiagnostica [padecimientoActual=" + padecimientoActual
				+ ", planInformacion=" + planInformacion + ", planTratMedico="
				+ planTratMedico + ", planTratQuirurgico=" + planTratQuirurgico
				+ ", planNotas=" + planNotas + ", interconsulta="
				+ interconsulta + ", catEspecialidad=" + catEspecialidad
				+ ", proximaVisita=" + proximaVisita + "]";
	}	
}