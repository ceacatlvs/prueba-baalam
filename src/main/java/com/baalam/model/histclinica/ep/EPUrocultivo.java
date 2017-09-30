package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPUrocultivo
 *
 */
@Entity
@Table( name = "consulta_ep_urocultivo",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPUrocultivo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaUrocultivo")
	private Date fechaUrocultivo;
	
	@Size(min = 0, max = 8)
	@Column(name = "resultadoUrocultivo")
	private String resultadoUrocultivo;
	
	@Size(min = 0, max = 500)
	@Column(name = "bacteria")
	private String bacteria;
	
	@Size(min = 0, max = 500)
	@Column(name = "antibriograma")
	private String antibiograma;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaUrocultivo() {
		return fechaUrocultivo;
	}

	public void setFechaUrocultivo(Date fechaUrocultivo) {
		this.fechaUrocultivo = fechaUrocultivo;
	}

	public String getResultadoUrocultivo() {
		return resultadoUrocultivo;
	}

	public void setResultadoUrocultivo(String resultadoUrocultivo) {
		this.resultadoUrocultivo = resultadoUrocultivo;
	}

	public String getBacteria() {
		return bacteria;
	}

	public void setBacteria(String bacteria) {
		this.bacteria = bacteria;
	}

	public String getAntibiograma() {
		return antibiograma;
	}

	public void setAntibiograma(String antibiograma) {
		this.antibiograma = antibiograma;
	}
  
}