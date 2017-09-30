package com.baalam.model.histclinica.ant.go;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "ago_ginecologica",
		uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class AGOGinecologica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "paridad")
	private Double paridad;
	
	@Column(name = "fum")
	private Date fum;
	
	@Column(name = "diasEntrePeriodo")
	private Double diasEntrePeriodo;
	
	@Column(name = "diasSangrado")
	private Double diasSangrado;
	
	@Column(name = "cantidadSangrado")
	@Size(min = 0, max = 20)
	private String cantidadSangrado;
	
	@Column(name = "dismenorrea", columnDefinition="BIT(1)")
	private Boolean dismenorrea;
	
	@Column(name = "spm", columnDefinition="BIT(1)")
	private Boolean spm;
	
	@Column(name = "cambiosRecientesPeriodo", columnDefinition="BIT(1)")
	private Boolean cambiosRecientesPeriodo;
	
	@Column(name = "inicioVidaSexualActiva", columnDefinition="BIT(1)")
	private Boolean inicioVidaSexualActiva;
	
	@Column(name = "edadVidaSexual")
	private Integer edadVidaSexual;
	
	@Column(name = "sexualmenteActiva", columnDefinition="BIT(1)")
	private Boolean sexualmenteActiva;
	
	@Column(name = "parejasSexuales")
	private Integer parejasSexuales;
	
	@Column(name = "tipoParejas")
	@Size(min = 0, max = 20)
	private String tipoParejas;
	
	@Column(name = "observaciones")
	@Size(min = 0, max = 500)
	private String observaciones;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Double getParidad() {
		return paridad;
	}

	public void setParidad(Double paridad) {
		this.paridad = paridad;
	}

	public Date getFum() {
		return fum;
	}

	public void setFum(Date fum) {
		this.fum = fum;
	}

	public Double getDiasEntrePeriodo() {
		return diasEntrePeriodo;
	}

	public void setDiasEntrePeriodo(Double diasEntrePeriodo) {
		this.diasEntrePeriodo = diasEntrePeriodo;
	}

	public Double getDiasSangrado() {
		return diasSangrado;
	}

	public void setDiasSangrado(Double diasSangrado) {
		this.diasSangrado = diasSangrado;
	}

	public String getCantidadSangrado() {
		return cantidadSangrado;
	}

	public void setCantidadSangrado(String cantidadSangrado) {
		this.cantidadSangrado = cantidadSangrado;
	}

	public Boolean getDismenorrea() {
		return dismenorrea;
	}

	public void setDismenorrea(Boolean dismenorrea) {
		this.dismenorrea = dismenorrea;
	}

	public Boolean getSpm() {
		return spm;
	}

	public void setSpm(Boolean spm) {
		this.spm = spm;
	}

	public Boolean getCambiosRecientesPeriodo() {
		return cambiosRecientesPeriodo;
	}

	public void setCambiosRecientesPeriodo(Boolean cambiosRecientesPeriodo) {
		this.cambiosRecientesPeriodo = cambiosRecientesPeriodo;
	}

	public Boolean getInicioVidaSexualActiva() {
		return inicioVidaSexualActiva;
	}

	public void setInicioVidaSexualActiva(Boolean inicioVidaSexualActiva) {
		this.inicioVidaSexualActiva = inicioVidaSexualActiva;
	}

	public Integer getEdadVidaSexual() {
		return edadVidaSexual;
	}

	public void setEdadVidaSexual(Integer edadVidaSexual) {
		this.edadVidaSexual = edadVidaSexual;
	}

	public Boolean getSexualmenteActiva() {
		return sexualmenteActiva;
	}

	public void setSexualmenteActiva(Boolean sexualmenteActiva) {
		this.sexualmenteActiva = sexualmenteActiva;
	}

	public Integer getParejasSexuales() {
		return parejasSexuales;
	}

	public void setParejasSexuales(Integer parejasSexuales) {
		this.parejasSexuales = parejasSexuales;
	}

	public String getTipoParejas() {
		return tipoParejas;
	}

	public void setTipoParejas(String tipoParejas) {
		this.tipoParejas = tipoParejas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}	
}