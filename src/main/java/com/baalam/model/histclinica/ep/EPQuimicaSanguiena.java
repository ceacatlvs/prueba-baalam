package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPQuimicaSanguiena
 *
 */
@Entity
@Table( name = "consulta_ep_quimica_sanguinea",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPQuimicaSanguiena implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaQS")
	private Date fechaQS;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoQS")
	private String resultadoQS;
	
	@Column(name = "glucosa")
	private Double glucosa;
	
	@Column(name = "bun")
	private Double bun;
	
	@Column(name = "creatinina")
	private Double creatinina;
	
	@Column(name = "acidoUrico")
	private Double acidoUrico;
	
	@Column(name = "colesterol")
	private Double colesterol;
	
	@Column(name = "trigliceridos")
	private Double trigliceridos;
	
	@Column(name = "hdl")
	private Double hdl;
	
	@Column(name = "ldl")
	private Double ldl;
	
	@Size(min = 0, max = 500)
	@Column(name = "otro")
	private String otro;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaQS() {
		return fechaQS;
	}

	public void setFechaQS(Date fechaQS) {
		this.fechaQS = fechaQS;
	}

	public String getQuimicaSang() {
		return resultadoQS;
	}

	public void setQuimicaSang(String quimicaSang) {
		this.resultadoQS = quimicaSang;
	}

	public Double getGlucosa() {
		return glucosa;
	}

	public void setGlucosa(Double glucosa) {
		this.glucosa = glucosa;
	}

	public Double getBun() {
		return bun;
	}

	public void setBun(Double bun) {
		this.bun = bun;
	}

	public Double getCreatinina() {
		return creatinina;
	}

	public void setCreatinina(Double creatinina) {
		this.creatinina = creatinina;
	}

	public Double getAcidoUrico() {
		return acidoUrico;
	}

	public void setAcidoUrico(Double acidoUrico) {
		this.acidoUrico = acidoUrico;
	}

	public Double getColesterol() {
		return colesterol;
	}

	public void setColesterol(Double colesterol) {
		this.colesterol = colesterol;
	}

	public Double getTrigliceridos() {
		return trigliceridos;
	}

	public void setTrigliceridos(Double trigliceridos) {
		this.trigliceridos = trigliceridos;
	}

	public Double getHdl() {
		return hdl;
	}

	public void setHdl(Double hdl) {
		this.hdl = hdl;
	}

	public Double getLdl() {
		return ldl;
	}

	public void setLdl(Double ldl) {
		this.ldl = ldl;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	@Override
	public String toString() {
		return "EPQuimicaSanguiena [padecimientoActual=" + padecimientoActual
				+ ", fechaQS=" + fechaQS + ", resultadoQS=" + resultadoQS
				+ ", glucosa=" + glucosa + ", bun=" + bun + ", creatinina="
				+ creatinina + ", acidoUrico=" + acidoUrico + ", colesterol="
				+ colesterol + ", trigliceridos=" + trigliceridos + ", hdl="
				+ hdl + ", ldl=" + ldl + ", otro=" + otro + "]";
	} 
}