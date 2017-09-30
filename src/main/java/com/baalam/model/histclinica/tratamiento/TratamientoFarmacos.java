package com.baalam.model.histclinica.tratamiento;

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
 * Entity implementation class for Entity: TratamientoFarmacos
 *
 */
@Entity
@Table( name = "consulta_tratamiento_farmacos",
uniqueConstraints = @UniqueConstraint(columnNames = "idTratamientoFarmaco"))
public class TratamientoFarmacos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idTratamientoFarmaco")
	private Long idTratamientoFarmaco;
	
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "medicamento")
	@Size(min = 0, max = 200)
	private String medicamento;
	
	@Column(name = "viaAdmon")
	@Size(min = 0, max = 100)
	private String viaAdmon;
	
	@Column(name = "dosis")
	@Size(min = 0, max = 100)
	private String dosis;
	
	@Column(name = "frecuencia")
	@Size(min = 0, max = 100)
	private String frecuencia;
	
	@Column(name = "duracion")
	@Size(min = 0, max = 100)
	private String duracion;

	public Long getIdTratamientoFarmaco() {
		return idTratamientoFarmaco;
	}

	public void setIdTratamientoFarmaco(Long idTratamientoFarmaco) {
		this.idTratamientoFarmaco = idTratamientoFarmaco;
	}

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getViaAdmon() {
		return viaAdmon;
	}

	public void setViaAdmon(String viaAdmon) {
		this.viaAdmon = viaAdmon;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}  
}