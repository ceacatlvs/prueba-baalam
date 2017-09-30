package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFPiel
 *
 */
@Entity
@Table( name = "consulta_ef_piel",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFPiel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "inspeccion")
	private String inspeccion;
	
	@Size(min = 0, max = 7)
	@Column(name = "palpacion")
	private String palpacion;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getInspeccion() {
		return inspeccion;
	}

	public void setInspeccion(String inspeccion) {
		this.inspeccion = inspeccion;
	}

	public String getPalpacion() {
		return palpacion;
	}

	public void setPalpacion(String palpacion) {
		this.palpacion = palpacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}  
}