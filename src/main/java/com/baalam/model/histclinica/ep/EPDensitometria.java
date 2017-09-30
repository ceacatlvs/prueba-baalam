package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPDensitometria
 *
 */
@Entity
@Table( name = "consulta_ep_densitometria",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPDensitometria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaDensitometria")
	private Date fechaDensitometria;
	
	@Size(min = 0, max = 500)
	@Column(name = "tipoDensitometria")
	private String tipoDensitometria;
	
	@Size(min = 0, max = 13)
	@Column(name = "cadera")
	private String cadera;
	
	@Size(min = 0, max = 13)
	@Column(name = "columna")
	private String columna;
	
	@Size(min = 0, max = 500)
	@Column(name = "otroSitio")
	private String otroSitio;
   
	@Size(min = 0, max = 13)
	@Column(name = "otroSitioClas")
	private String otroSitioClas;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observacones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaDensitometria() {
		return fechaDensitometria;
	}

	public void setFechaDensitometria(Date fechaDensitometria) {
		this.fechaDensitometria = fechaDensitometria;
	}

	public String getTipoDensitometria() {
		return tipoDensitometria;
	}

	public void setTipoDensitometria(String tipoDensitometria) {
		this.tipoDensitometria = tipoDensitometria;
	}

	public String getCadera() {
		return cadera;
	}

	public void setCadera(String cadera) {
		this.cadera = cadera;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public String getOtroSitio() {
		return otroSitio;
	}

	public void setOtroSitio(String otroSitio) {
		this.otroSitio = otroSitio;
	}

	public String getOtroSitioClas() {
		return otroSitioClas;
	}

	public void setOtroSitioClas(String otroSitioClas) {
		this.otroSitioClas = otroSitioClas;
	}

	public String getObservacones() {
		return observacones;
	}

	public void setObservacones(String observacones) {
		this.observacones = observacones;
	}
}