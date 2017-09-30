package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFNeuroEMental
 *
 */
@Entity
@Table( name = "consulta_ef_nem",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFNeuroEMental implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "orientacionTiempo", columnDefinition="BIT(1)")
	private Boolean orientacionTiempo;
	
	@Column(name = "orientacionEspacio", columnDefinition="BIT(1)")
	private Boolean orientacionEspacio;
	
	@Column(name = "orientacionPersona", columnDefinition="BIT(1)")
	private Boolean orientacionPersona;
	
	@Column(name = "orientacionComentarios", columnDefinition="BIT(1)")
	private Boolean orientacionComentarios;
	
	@Column(name = "conductaNormal", columnDefinition="BIT(1)")
	private Boolean conductaNormal;
	
	@Column(name = "conductaDeprimido", columnDefinition="BIT(1)")
	private Boolean conductaDeprimido;
	
	@Column(name = "conductaAnsioso", columnDefinition="BIT(1)")
	private Boolean conductaAnsioso;
	
	@Column(name = "conductaAgitado", columnDefinition="BIT(1)")
	private Boolean conductaAgitado;
	
	@Column(name = "conductaOtro", columnDefinition="BIT(1)")
	private Boolean conductaOtro;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getOrientacionTiempo() {
		return orientacionTiempo;
	}

	public void setOrientacionTiempo(Boolean orientacionTiempo) {
		this.orientacionTiempo = orientacionTiempo;
	}

	public Boolean getOrientacionEspacio() {
		return orientacionEspacio;
	}

	public void setOrientacionEspacio(Boolean orientacionEspacio) {
		this.orientacionEspacio = orientacionEspacio;
	}

	public Boolean getOrientacionPersona() {
		return orientacionPersona;
	}

	public void setOrientacionPersona(Boolean orientacionPersona) {
		this.orientacionPersona = orientacionPersona;
	}

	public Boolean getOrientacionComentarios() {
		return orientacionComentarios;
	}

	public void setOrientacionComentarios(Boolean orientacionComentarios) {
		this.orientacionComentarios = orientacionComentarios;
	}

	public Boolean getConductaNormal() {
		return conductaNormal;
	}

	public void setConductaNormal(Boolean conductaNormal) {
		this.conductaNormal = conductaNormal;
	}

	public Boolean getConductaDeprimido() {
		return conductaDeprimido;
	}

	public void setConductaDeprimido(Boolean conductaDeprimido) {
		this.conductaDeprimido = conductaDeprimido;
	}

	public Boolean getConductaAnsioso() {
		return conductaAnsioso;
	}

	public void setConductaAnsioso(Boolean conductaAnsioso) {
		this.conductaAnsioso = conductaAnsioso;
	}

	public Boolean getConductaAgitado() {
		return conductaAgitado;
	}

	public void setConductaAgitado(Boolean conductaAgitado) {
		this.conductaAgitado = conductaAgitado;
	}

	public Boolean getConductaOtro() {
		return conductaOtro;
	}

	public void setConductaOtro(Boolean conductaOtro) {
		this.conductaOtro = conductaOtro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}