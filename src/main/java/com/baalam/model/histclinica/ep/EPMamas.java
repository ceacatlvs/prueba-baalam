package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPMamas
 *
 */
@Entity
@Table( name = "consulta_ep_mamas_usg",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPMamas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaMamografia")
	private Date fechaMamografia;
	
	@Size(min = 0, max = 3)
	@Column(name = "mamoBirads")
	private String mamoBirads;
	
	@Column(name = "fechaUsgMama")
	private Date fechaUsgMama;
	
	@Size(min = 0, max = 3)
	@Column(name = "usgMamasBirads")
	private String usgMamasBirads;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaMamografia() {
		return fechaMamografia;
	}

	public void setFechaMamografia(Date fechaMamografia) {
		this.fechaMamografia = fechaMamografia;
	}

	public String getMamoBirads() {
		return mamoBirads;
	}

	public void setMamoBirads(String mamoBirads) {
		this.mamoBirads = mamoBirads;
	}

	public Date getFechaUsgMama() {
		return fechaUsgMama;
	}

	public void setFechaUsgMama(Date fechaUsgMama) {
		this.fechaUsgMama = fechaUsgMama;
	}

	public String getUsgMamasBirads() {
		return usgMamasBirads;
	}

	public void setUsgMamasBirads(String usgMamasBirads) {
		this.usgMamasBirads = usgMamasBirads;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
  
}