package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPCitologiaCervical
 *
 */
@Entity
@Table( name = "consulta_ep_citologia_cervical",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPCitologiaCervical implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaCitologia")
	private Date fechaCitologia;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoCitologia")
	private String resultadoCitologia;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaCitologia() {
		return fechaCitologia;
	}

	public void setFechaCitologia(Date fechaCitologia) {
		this.fechaCitologia = fechaCitologia;
	}

	public String getResultadoCitologia() {
		return resultadoCitologia;
	}

	public void setResultadoCitologia(String resultadoCitologia) {
		this.resultadoCitologia = resultadoCitologia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}  
}