package com.baalam.model.histclinica.ads;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: ADGabinete
 *
 */
@Entity
@Table( name = "consulta_ads_gabinete",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class ADSGabinete implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "ultrasonogramaPelvico", columnDefinition="BIT(1)")
	private Boolean ultrasonogramaPelvico;
	
	@Column(name = "ultrasonogramaTransvaginal", columnDefinition="BIT(1)")
	private Boolean ultrasonogramaTransvaginal;
	
	@Column(name = "ultrasonogramaMama", columnDefinition="BIT(1)")
	private Boolean ultrasonogramaMama;
	
	@Column(name = "ultrasonogramaAbdomen", columnDefinition="BIT(1)")
	private Boolean ultrasonogramaAbdomen;
	
	@Size(min = 0, max = 1000)
	@Column(name = "ultrasonogramaOtro")
	private String ultrasonogramaOtro;
	
	@Column(name = "mamografia", columnDefinition="BIT(1)")
	private Boolean mamografia;
	
	@Column(name = "histerosonografia", columnDefinition="BIT(1)")
	private Boolean histerosonografia;
	
	@Column(name = "histeosalpingografia", columnDefinition="BIT(1)")
	private Boolean histeosalpingografia;
   
	@Column(name = "urogramaExcetor", columnDefinition="BIT(1)")
	private Boolean urogramaExcetor;
	
	@Column(name = "densitometria", columnDefinition="BIT(1)")
	private Boolean densitometria;
	
	@Size(min = 0, max = 1000)
	@Column(name = "otrosDescripcion")
	private String otrosDescripcion;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getUltrasonogramaPelvico() {
		return ultrasonogramaPelvico;
	}

	public void setUltrasonogramaPelvico(Boolean ultrasonogramaPelvico) {
		this.ultrasonogramaPelvico = ultrasonogramaPelvico;
	}

	public Boolean getUltrasonogramaTransvaginal() {
		return ultrasonogramaTransvaginal;
	}

	public void setUltrasonogramaTransvaginal(Boolean ultrasonogramaTransvaginal) {
		this.ultrasonogramaTransvaginal = ultrasonogramaTransvaginal;
	}

	public Boolean getUltrasonogramaMama() {
		return ultrasonogramaMama;
	}

	public void setUltrasonogramaMama(Boolean ultrasonogramaMama) {
		this.ultrasonogramaMama = ultrasonogramaMama;
	}

	public Boolean getUltrasonogramaAbdomen() {
		return ultrasonogramaAbdomen;
	}

	public void setUltrasonogramaAbdomen(Boolean ultrasonogramaAbdomen) {
		this.ultrasonogramaAbdomen = ultrasonogramaAbdomen;
	}

	public String getUltrasonogramaOtro() {
		return ultrasonogramaOtro;
	}

	public void setUltrasonogramaOtro(String ultrasonogramaOtro) {
		this.ultrasonogramaOtro = ultrasonogramaOtro;
	}

	public Boolean getMamografia() {
		return mamografia;
	}

	public void setMamografia(Boolean mamografia) {
		this.mamografia = mamografia;
	}

	public Boolean getHisterosonografia() {
		return histerosonografia;
	}

	public void setHisterosonografia(Boolean histerosonografia) {
		this.histerosonografia = histerosonografia;
	}
	
	public Boolean getHisteosalpingografia() {
		return histeosalpingografia;
	}

	public void setHisteosalpingografia(Boolean histeosalpingografia) {
		this.histeosalpingografia = histeosalpingografia;
	}

	public Boolean getUrogramaExcetor() {
		return urogramaExcetor;
	}

	public void setUrogramaExcetor(Boolean urogramaExcetor) {
		this.urogramaExcetor = urogramaExcetor;
	}

	public Boolean getDensitometria() {
		return densitometria;
	}

	public void setDensitometria(Boolean densitometria) {
		this.densitometria = densitometria;
	}

	public String getOtrosDescripcion() {
		return otrosDescripcion;
	}

	public void setOtrosDescripcion(String otrosDescripcion) {
		this.otrosDescripcion = otrosDescripcion;
	}
}