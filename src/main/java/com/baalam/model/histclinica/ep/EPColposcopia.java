package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPColposcopia
 *
 */
@Entity
@Table( name = "consulta_ep_colposcopia",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPColposcopia implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaColposcopia")
	private Date fechaColposcopia;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoColposcopia")
	private String resultadoColposcopia;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaColposcopia() {
		return fechaColposcopia;
	}

	public void setFechaColposcopia(Date fechaColposcopia) {
		this.fechaColposcopia = fechaColposcopia;
	}

	public String getResultadoColposcopia() {
		return resultadoColposcopia;
	}

	public void setResultadoColposcopia(String resultadoColposcopia) {
		this.resultadoColposcopia = resultadoColposcopia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "EPColposcopia [padecimientoActual=" + padecimientoActual
				+ ", fechaColposcopia=" + fechaColposcopia
				+ ", resultadoColposcopia=" + resultadoColposcopia
				+ ", observaciones=" + observaciones + "]";
	}  
}