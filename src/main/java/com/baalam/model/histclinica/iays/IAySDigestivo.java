package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySDigestivo
 *
 */
@Entity
@Table( name = "iays_digestivo",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySDigestivo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "dolor", columnDefinition="BIT(1)")
	private Boolean dolor;
	
	@Column(name = "nauseas", columnDefinition="BIT(1)")
	private Boolean nauseas;
	
	@Column(name = "vomito", columnDefinition="BIT(1)")
	private Boolean vomito;
	
	@Column(name = "indigestion", columnDefinition="BIT(1)")
	private Boolean indigestion;
	
	@Column(name = "meteorismo", columnDefinition="BIT(1)")
	private Boolean meteorismo;
	
	@Column(name = "flatulencia", columnDefinition="BIT(1)")
	private Boolean flatulencia;
	
	@Column(name = "diarrea", columnDefinition="BIT(1)")
	private Boolean diarrea;
	
	@Column(name = "constipacion", columnDefinition="BIT(1)")
	private Boolean constipacion;
	
	@Column(name = "melena", columnDefinition="BIT(1)")
	private Boolean melena;
	
	@Column(name = "sangradoAnal", columnDefinition="BIT(1)")
	private Boolean sangradoAnal;
	
	@Column(name = "incontinenciaAnal", columnDefinition="BIT(1)")
	private Boolean incontinenciaAnal;
	
	@Column(name = "hematemesis", columnDefinition="BIT(1)")
	private Boolean hematemesis;
	
	@Column(name = "regurgitaciones", columnDefinition="BIT(1)")
	private Boolean regurgitaciones;
		
	@Size(min = 0, max = 500)
	@Column(name = "otro")
	private String otro;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Boolean getNegativo() {
		return negativo;
	}

	public void setNegativo(Boolean negativo) {
		this.negativo = negativo;
	}

	public Boolean getDolor() {
		return dolor;
	}

	public void setDolor(Boolean dolor) {
		this.dolor = dolor;
	}

	public Boolean getNauseas() {
		return nauseas;
	}

	public void setNauseas(Boolean nauseas) {
		this.nauseas = nauseas;
	}

	public Boolean getVomito() {
		return vomito;
	}

	public void setVomito(Boolean vomito) {
		this.vomito = vomito;
	}

	public Boolean getIndigestion() {
		return indigestion;
	}

	public void setIndigestion(Boolean indigestion) {
		this.indigestion = indigestion;
	}

	public Boolean getMeteorismo() {
		return meteorismo;
	}

	public void setMeteorismo(Boolean meteorismo) {
		this.meteorismo = meteorismo;
	}

	public Boolean getFlatulencia() {
		return flatulencia;
	}

	public void setFlatulencia(Boolean flatulencia) {
		this.flatulencia = flatulencia;
	}

	public Boolean getDiarrea() {
		return diarrea;
	}

	public void setDiarrea(Boolean diarrea) {
		this.diarrea = diarrea;
	}

	public Boolean getConstipacion() {
		return constipacion;
	}

	public void setConstipacion(Boolean constipacion) {
		this.constipacion = constipacion;
	}

	public Boolean getMelena() {
		return melena;
	}

	public void setMelena(Boolean melena) {
		this.melena = melena;
	}

	public Boolean getSangradoAnal() {
		return sangradoAnal;
	}

	public void setSangradoAnal(Boolean sangradoAnal) {
		this.sangradoAnal = sangradoAnal;
	}

	public Boolean getIncontinenciaAnal() {
		return incontinenciaAnal;
	}

	public void setIncontinenciaAnal(Boolean incontinenciaAnal) {
		this.incontinenciaAnal = incontinenciaAnal;
	}

	public Boolean getHematemesis() {
		return hematemesis;
	}

	public void setHematemesis(Boolean hematemesis) {
		this.hematemesis = hematemesis;
	}

	public Boolean getRegurgitaciones() {
		return regurgitaciones;
	}

	public void setRegurgitaciones(Boolean regurgitaciones) {
		this.regurgitaciones = regurgitaciones;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}	
}