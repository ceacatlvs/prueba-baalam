package com.baalam.model.histclinica.tratamiento;

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

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: Tratamiento
 *
 */
@Entity
@Table( name = "consulta_tratamiento",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class Tratamiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "minutosEducacionSalud")
	private Double minutosEducacionSalud;
	
	@Size(min = 0, max = 1000)
	@Column(name = "observacionesEducacionSalud")
	private String observacionesEducacionSalud;
	
	@Column(name = "chReposo", columnDefinition="BIT(1)")
	private Boolean chReposo;
	
	@Column(name = "chActividadNormal", columnDefinition="BIT(1)")
	private Boolean chActividadNormal;
	
	@Column(name = "chEjercicio", columnDefinition="BIT(1)")
	private Boolean chEjercicio;
	
	@Column(name = "chBano", columnDefinition="BIT(1)")
	private Boolean chBano;
	
	@Column(name = "chActividadSexual", columnDefinition="BIT(1)")
	private Boolean chActividadSexual;
	
	@Size(min = 0, max = 1000)
	@Column(name = "chOtros")
	private String chOtros;
	
	@Size(min = 0, max = 8)
	@Column(name = "dieta")
	private String dieta;
	
	@Size(min = 0, max = 1000)
	@Column(name = "dietaObservaciones")
	private String dietaObservaciones;
	
	@Column(name = "proximaCita")
	@Future
	private Date proximaCita;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Double getMinutosEducacionSalud() {
		return minutosEducacionSalud;
	}

	public void setMinutosEducacionSalud(Double minutosEducacionSalud) {
		this.minutosEducacionSalud = minutosEducacionSalud;
	}

	public String getObservacionesEducacionSalud() {
		return observacionesEducacionSalud;
	}

	public void setObservacionesEducacionSalud(String observacionesEducacionSalud) {
		this.observacionesEducacionSalud = observacionesEducacionSalud;
	}

	public Boolean getChReposo() {
		return chReposo;
	}

	public void setChReposo(Boolean chReposo) {
		this.chReposo = chReposo;
	}

	public Boolean getChActividadNormal() {
		return chActividadNormal;
	}

	public void setChActividadNormal(Boolean chActividadNormal) {
		this.chActividadNormal = chActividadNormal;
	}

	public Boolean getChEjercicio() {
		return chEjercicio;
	}

	public void setChEjercicio(Boolean chEjercicio) {
		this.chEjercicio = chEjercicio;
	}

	public Boolean getChBano() {
		return chBano;
	}

	public void setChBano(Boolean chBano) {
		this.chBano = chBano;
	}

	public Boolean getChActividadSexual() {
		return chActividadSexual;
	}

	public void setChActividadSexual(Boolean chActividadSexual) {
		this.chActividadSexual = chActividadSexual;
	}

	public String getChOtros() {
		return chOtros;
	}

	public void setChOtros(String chOtros) {
		this.chOtros = chOtros;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public String getDietaObservaciones() {
		return dietaObservaciones;
	}

	public void setDietaObservaciones(String dietaObservaciones) {
		this.dietaObservaciones = dietaObservaciones;
	}

	public Date getProximaCita() {
		return proximaCita;
	}

	public void setProximaCita(Date proximaCita) {
		this.proximaCita = proximaCita;
	}
}