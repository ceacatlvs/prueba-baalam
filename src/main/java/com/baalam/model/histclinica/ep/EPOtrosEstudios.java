package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPOtrosEstudios
 *
 */
@Entity
@Table( name = "consulta_ep_otros_estudios",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPOtrosEstudios implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaOtrosEstudios")
	private Date fechaOtrosEstudios;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaOtrosEstudios() {
		return fechaOtrosEstudios;
	}

	public void setFechaOtrosEstudios(Date fechaOtrosEstudios) {
		this.fechaOtrosEstudios = fechaOtrosEstudios;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}  
}