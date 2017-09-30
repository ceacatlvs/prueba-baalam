package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPEgo
 *
 */
@Entity
@Table( name = "consulta_ep_ego",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPEgo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaEgo")
	private Date fechaEgo;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoEgo")
	private String resultadoEgo;
	
	@Size(min = 0, max = 500)
	@Column(name = "ph")
	private String ph;
	
	@Size(min = 0, max = 500)
	@Column(name = "aspecto")
	private String aspecto;
	
	@Column(name = "hemoglobina")
	private Double hemoglobina;
   
	@Column(name = "proteinas")
	private Double proteinas;
	
	@Column(name = "nitritos")
	private Double nitritos;
	
	@Column(name = "cuerposCetonicos")
	private Double cuerposCetonicos;
	
	@Column(name = "sedimentoBacterias")
	private Double sedimentoBacterias;
	
	@Column(name = "sedimentoLeucocitos")
	private Double sedimentoLeucocitos;
	
	@Column(name = "sedimentoEritrocitos")
	private Double sedimentoEritrocitos;
	
	@Column(name = "sedimentoPiocitos")
	private Double sedimentoPiocitos;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaEgo() {
		return fechaEgo;
	}

	public void setFechaEgo(Date fechaEgo) {
		this.fechaEgo = fechaEgo;
	}

	public String getResultadoEgo() {
		return resultadoEgo;
	}

	public void setResultadoEgo(String resultadoEgo) {
		this.resultadoEgo = resultadoEgo;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}
	
	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	public Double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(Double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public Double getProteinas() {
		return proteinas;
	}

	public void setProteinas(Double proteinas) {
		this.proteinas = proteinas;
	}

	public Double getNitritos() {
		return nitritos;
	}

	public void setNitritos(Double nitritos) {
		this.nitritos = nitritos;
	}

	public Double getCuerposCetonicos() {
		return cuerposCetonicos;
	}

	public void setCuerposCetonicos(Double cuerposCetonicos) {
		this.cuerposCetonicos = cuerposCetonicos;
	}

	public Double getSedimentoBacterias() {
		return sedimentoBacterias;
	}

	public void setSedimentoBacterias(Double sedimentoBacterias) {
		this.sedimentoBacterias = sedimentoBacterias;
	}

	public Double getSedimentoLeucocitos() {
		return sedimentoLeucocitos;
	}

	public void setSedimentoLeucocitos(Double sedimentoLeucocitos) {
		this.sedimentoLeucocitos = sedimentoLeucocitos;
	}

	public Double getSedimentoEritrocitos() {
		return sedimentoEritrocitos;
	}

	public void setSedimentoEritrocitos(Double sedimentoEritrocitos) {
		this.sedimentoEritrocitos = sedimentoEritrocitos;
	}

	public Double getSedimentoPiocitos() {
		return sedimentoPiocitos;
	}

	public void setSedimentoPiocitos(Double sedimentoPiocitos) {
		this.sedimentoPiocitos = sedimentoPiocitos;
	}
	
}