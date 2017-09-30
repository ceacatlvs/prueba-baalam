package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFRespiratorio
 *
 */
@Entity
@Table( name = "consulta_ef_respiratorio",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFRespiratorio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "esfuerzoResp")
	private String esfuerzoResp;
	
	@Size(min = 0, max = 7)
	@Column(name = "camposPulmo")
	private String camposPulmo;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getEsfuerzoResp() {
		return esfuerzoResp;
	}

	public void setEsfuerzoResp(String esfuerzoResp) {
		this.esfuerzoResp = esfuerzoResp;
	}

	public String getCamposPulmo() {
		return camposPulmo;
	}

	public void setCamposPulmo(String camposPulmo) {
		this.camposPulmo = camposPulmo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}  
}