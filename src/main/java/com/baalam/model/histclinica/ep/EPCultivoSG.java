package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EPCultivoSG
 *
 */
@Entity
@Table( name = "consulta_ep_csg",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPCultivoSG implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaCSG")
	private Date fechaUrocultivo;
	
	@Size(min = 0, max = 8)
	@Column(name = "resultadoCSG")
	private String resultadoUrocultivo;
	
	@Size(min = 0, max = 500)
	@Column(name = "microorganismo")
	private String microorganismo;
	
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

	public String getMicroorganismo() {
		return microorganismo;
	}

	public void setMicroorganismo(String microorganismo) {
		this.microorganismo = microorganismo;
	}

	public String getAntibiograma() {
		return antibiograma;
	}

	public void setAntibiograma(String antibiograma) {
		this.antibiograma = antibiograma;
	}  
}