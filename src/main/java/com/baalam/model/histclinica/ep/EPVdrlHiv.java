package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPVdrlHiv
 *
 */
@Entity
@Table( name = "consulta_ep_vdrl_hiv",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPVdrlHiv implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaVdrl")
	private Date fechaVdrl;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoVdrl")
	private String resultadoVdrl;
	
	@Column(name = "fechaHIV")
	private Date fechaHIV;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoHIV")
	private String resultadoHIV;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaVdrl() {
		return fechaVdrl;
	}

	public void setFechaVdrl(Date fechaVdrl) {
		this.fechaVdrl = fechaVdrl;
	}

	public String getResultadoVdrl() {
		return resultadoVdrl;
	}

	public void setResultadoVdrl(String resultadoVdrl) {
		this.resultadoVdrl = resultadoVdrl;
	}

	public Date getFechaHIV() {
		return fechaHIV;
	}

	public void setFechaHIV(Date fechaHIV) {
		this.fechaHIV = fechaHIV;
	}

	public String getResultadoHIV() {
		return resultadoHIV;
	}

	public void setResultadoHIV(String resultadoHIV) {
		this.resultadoHIV = resultadoHIV;
	}

	@Override
	public String toString() {
		return "EPVdrlHiv [padecimientoActual=" + padecimientoActual
				+ ", fechaVdrl=" + fechaVdrl + ", resultadoVdrl="
				+ resultadoVdrl + ", fechaHIV=" + fechaHIV + ", resultadoHIV="
				+ resultadoHIV + "]";
	}
}