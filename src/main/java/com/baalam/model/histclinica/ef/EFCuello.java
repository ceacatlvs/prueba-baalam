package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFCuello
 *
 */
@Entity
@Table( name = "consulta_ef_cuello",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFCuello implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "cuello")
	private String cuello;
	
	@Size(min = 0, max = 7)
	@Column(name = "tiroides")
	private String tiroides;
	
	@Size(min = 0, max = 7)
	@Column(name = "ganglios")
	private String ganglios;
	
	@Size(min = 0, max = 7)
	@Column(name = "pulsos")
	private String pulsos;

	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getCuello() {
		return cuello;
	}

	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	public String getTiroides() {
		return tiroides;
	}

	public void setTiroides(String tiroides) {
		this.tiroides = tiroides;
	}

	public String getGanglios() {
		return ganglios;
	}

	public void setGanglios(String ganglios) {
		this.ganglios = ganglios;
	}

	public String getPulsos() {
		return pulsos;
	}

	public void setPulsos(String pulsos) {
		this.pulsos = pulsos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}