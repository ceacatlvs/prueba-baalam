package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFLinfatico
 *
 */
@Entity
@Table( name = "consulta_ef_linfatico",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFLinfatico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "gangliosCuello")
	private String gangliosCuello;
	
	@Size(min = 0, max = 7)
	@Column(name = "gangliosAxila")
	private String gangliosAxila;
	
	@Size(min = 0, max = 7)
	@Column(name = "gangliosInguinales")
	private String gangliosInguinales;
	
	@Size(min = 0, max = 7)
	@Column(name = "otrosGanglios")
	private String otrosGanglios;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;
	
	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getGangliosCuello() {
		return gangliosCuello;
	}

	public void setGangliosCuello(String gangliosCuello) {
		this.gangliosCuello = gangliosCuello;
	}

	public String getGangliosAxila() {
		return gangliosAxila;
	}

	public void setGangliosAxila(String gangliosAxila) {
		this.gangliosAxila = gangliosAxila;
	}

	public String getGangliosInguinales() {
		return gangliosInguinales;
	}

	public void setGangliosInguinales(String gangliosInguinales) {
		this.gangliosInguinales = gangliosInguinales;
	}

	public String getOtrosGanglios() {
		return otrosGanglios;
	}

	public void setOtrosGanglios(String otrosGanglios) {
		this.otrosGanglios = otrosGanglios;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}