package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPUltrasonido
 *
 */
@Entity
@Table( name = "consulta_ep_ultrasonido",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPUltrasonido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaUltrasonido")
	private Date fechaUltrasonido;
	
	@Size(min = 0, max = 13)
	@Column(name = "tipoUltrasonido")
	private String tipoUltrasonido;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoUltrasonido")
	private String resultadoUltrasonido;
	
	@Column(name = "tamanoUterino")
	private Double tamanoUterino;
	
	@Size(min = 0, max = 13)
	@Column(name = "ecogenicidad")
	private String ecogenicidad;
	
	@Column(name = "grosorEndometrio")
	private Double grosorEndometrio;
	
	@Column(name = "miomasSubserosos", columnDefinition="BIT(1)")
	private Boolean miomasSubserosos;
	
	@Column(name = "mssTamano")
	private Double mssTamano;
	
	@Column(name = "miomasIntramurales", columnDefinition="BIT(1)")
	private Boolean miomasIntramurales;
	
	@Column(name = "mimTamano")
	private Double mimTamano;
	
	@Column(name = "miomasSubmucosos", columnDefinition="BIT(1)")
	private Boolean miomasSubmucosos;
	
	@Column(name = "msmTamano")
	private Double msmTamano;

	@Size(min = 0, max =7)
	@Column(name = "polipos")
	private String polipos;
	
	@Column(name = "polNumero")
	private Double polNumero;
	
	@Column(name = "polTamano")
	private Double polTamano;
	
	@Size(min = 0, max = 500)
	@Column(name = "observacionesUtero")
	private String observacionesUtero;

	@Column(name = "odTamano")
	private Double odTamano;
	
	@Column(name = "odQNumero")
	private Double odQNumero;
	
	@Size(min = 0, max = 13)
	@Column(name = "odEcogenicidad")
	private String odEcogenicidad;
	
	@Column(name = "odETamano")
	private Double odETamano;
	
	@Column(name = "oiTamano")
	private Double oiTamano;
	
	@Column(name = "oiQNumero")
	private Double oiQNumero;
	
	@Size(min = 0, max = 13)
	@Column(name = "oiEcogenicidad")
	private String oiEcogenicidad;
	
	@Column(name = "oiETamano")
	private Double oiETamano;
	
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
		return fechaUltrasonido;
	}

	public void setFechaColposcopia(Date fechaColposcopia) {
		this.fechaUltrasonido = fechaColposcopia;
	}

	public String getTipoUltrasonido() {
		return tipoUltrasonido;
	}

	public void setTipoUltrasonido(String tipoUltrasonido) {
		this.tipoUltrasonido = tipoUltrasonido;
	}

	public String getResultadoUltrasonido() {
		return resultadoUltrasonido;
	}

	public void setResultadoUltrasonido(String resultadoUltrasonido) {
		this.resultadoUltrasonido = resultadoUltrasonido;
	}

	public Double getTamanoUterino() {
		return tamanoUterino;
	}

	public void setTamanoUterino(Double tamanoUterino) {
		this.tamanoUterino = tamanoUterino;
	}

	public String getEcogenicidad() {
		return ecogenicidad;
	}

	public void setEcogenicidad(String ecogenicidad) {
		this.ecogenicidad = ecogenicidad;
	}

	public Double getGrosorEndometrio() {
		return grosorEndometrio;
	}

	public void setGrosorEndometrio(Double grosorEndometrio) {
		this.grosorEndometrio = grosorEndometrio;
	}

	public Boolean getMiomasSubserosos() {
		return miomasSubserosos;
	}

	public void setMiomasSubserosos(Boolean miomasSubserosos) {
		this.miomasSubserosos = miomasSubserosos;
	}

	public Double getMssTamano() {
		return mssTamano;
	}

	public void setMssTamano(Double mssTamano) {
		this.mssTamano = mssTamano;
	}

	public Boolean getMiomasIntramurales() {
		return miomasIntramurales;
	}

	public void setMiomasIntramurales(Boolean miomasIntramurales) {
		this.miomasIntramurales = miomasIntramurales;
	}

	public Double getMimTamano() {
		return mimTamano;
	}

	public void setMimTamano(Double mimTamano) {
		this.mimTamano = mimTamano;
	}

	public Boolean getMiomasSubmucosos() {
		return miomasSubmucosos;
	}

	public void setMiomasSubmucosos(Boolean miomasSubmucosos) {
		this.miomasSubmucosos = miomasSubmucosos;
	}

	public Double getMsmTamano() {
		return msmTamano;
	}

	public void setMsmTamano(Double msmTamano) {
		this.msmTamano = msmTamano;
	}

	public String getPolipos() {
		return polipos;
	}

	public void setPolipos(String polipos) {
		this.polipos = polipos;
	}

	public Double getPolNumero() {
		return polNumero;
	}

	public void setPolNumero(Double polNumero) {
		this.polNumero = polNumero;
	}

	public Double getPolTamano() {
		return polTamano;
	}

	public void setPolTamano(Double polTamano) {
		this.polTamano = polTamano;
	}

	public String getObservacionesUtero() {
		return observacionesUtero;
	}

	public void setObservacionesUtero(String observacionesUtero) {
		this.observacionesUtero = observacionesUtero;
	}

	public Double getOdTamano() {
		return odTamano;
	}

	public void setOdTamano(Double odTamano) {
		this.odTamano = odTamano;
	}

	public Double getOdQNumero() {
		return odQNumero;
	}

	public void setOdQNumero(Double odQNumero) {
		this.odQNumero = odQNumero;
	}

	public String getOdEcogenicidad() {
		return odEcogenicidad;
	}

	public void setOdEcogenicidad(String odEcogenicidad) {
		this.odEcogenicidad = odEcogenicidad;
	}

	public Double getOdETamano() {
		return odETamano;
	}

	public void setOdETamano(Double odETamano) {
		this.odETamano = odETamano;
	}

	public Double getOiTamano() {
		return oiTamano;
	}

	public void setOiTamano(Double oiTamano) {
		this.oiTamano = oiTamano;
	}

	public Double getOiQNumero() {
		return oiQNumero;
	}

	public void setOiQNumero(Double oiQNumero) {
		this.oiQNumero = oiQNumero;
	}

	public String getOiEcogenicidad() {
		return oiEcogenicidad;
	}

	public void setOiEcogenicidad(String oiEcogenicidad) {
		this.oiEcogenicidad = oiEcogenicidad;
	}

	public Double getOiETamano() {
		return oiETamano;
	}

	public void setOiETamano(Double oiETamano) {
		this.oiETamano = oiETamano;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
   
}