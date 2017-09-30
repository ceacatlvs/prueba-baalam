package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFAbdomen
 *
 */
@Entity
@Table( name = "consulta_ef_abdomen",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFAbdomen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "sensibilidad")
	private String sensibilidad;
	
	@Size(min = 0, max = 7)
	@Column(name = "masas")
	private String masas;
	
	@Size(min = 0, max = 7)
	@Column(name = "hernia")
	private String hernia;
	
	@Size(min = 0, max = 7)
	@Column(name = "higado")
	private String higado;
	
	@Size(min = 0, max = 7)
	@Column(name = "vesiculaBiliar")
	private String vesiculaBiliar;
	
	@Size(min = 0, max = 7)
	@Column(name = "bazo")
	private String bazo;
	
	@Size(min = 0, max = 7)
	@Column(name = "colon")
	private String colon;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getSensibilidad() {
		return sensibilidad;
	}

	public void setSensibilidad(String sensibilidad) {
		this.sensibilidad = sensibilidad;
	}

	public String getMasas() {
		return masas;
	}

	public void setMasas(String masas) {
		this.masas = masas;
	}

	public String getHernia() {
		return hernia;
	}

	public void setHernia(String hernia) {
		this.hernia = hernia;
	}

	public String getHigado() {
		return higado;
	}

	public void setHigado(String higado) {
		this.higado = higado;
	}

	public String getVesiculaBiliar() {
		return vesiculaBiliar;
	}

	public void setVesiculaBiliar(String vesiculaBiliar) {
		this.vesiculaBiliar = vesiculaBiliar;
	}

	public String getBazo() {
		return bazo;
	}

	public void setBazo(String bazo) {
		this.bazo = bazo;
	}

	public String getColon() {
		return colon;
	}

	public void setColon(String colon) {
		this.colon = colon;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}