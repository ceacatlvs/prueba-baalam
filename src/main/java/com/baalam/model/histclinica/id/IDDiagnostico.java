package com.baalam.model.histclinica.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: IdDiagnostico
 *
 */
@Entity
@Table( name = "consulta_id_diagnostico",
uniqueConstraints = @UniqueConstraint(columnNames = "idIdDiagnostico"))
public class IDDiagnostico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idIdDiagnostico")
	private Long idIdDiagnostico;
	
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 1000)
	@Column(name = "diagnostico")
	private String diagnostico;
	
	public String getDiagnostico() {
		return diagnostico;
	}

	public Long getIdIdDiagnostico() {
		return idIdDiagnostico;
	}

	public void setIdIdDiagnostico(Long idIdDiagnostico) {
		this.idIdDiagnostico = idIdDiagnostico;
	}

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "IDDiagnostico [idIdDiagnostico=" + idIdDiagnostico
				+ ", padecimientoActual=" + padecimientoActual
				+ ", diagnostico=" + diagnostico + "]";
	}
	
}
