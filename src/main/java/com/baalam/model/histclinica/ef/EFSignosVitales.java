package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFSignosVitales
 *
 */
@Entity
@Table( name = "consulta_ef_signos_vitales",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFSignosVitales implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaConsulta")
	private Date fechaConsulta;
	
	@Column(name = "acudioCita", columnDefinition="BIT(1)")
	private Boolean acudioCita;
	
	@Column(name = "tallaCm")
	private Integer tallaCm;
	
	@Column(name = "tallaPies")
	private Integer tallaPies;
	
	@Column(name = "tallaIn")
	private Integer tallaIn;
	
	@Column(name = "pesoKg")
	private Double pesoKg;
	
	@Column(name = "pesoLb")
	private Double pesoLb;
	
	@Column(name = "imc")
	private Double imc;
	
	@Column(name = "pesoIdealKg")
	private Double pesoIdealKg;
	
	@Column(name = "pesoIdealLb")
	private Double pesoIdealLb;
	
	@Column(name = "ta")
	private Double ta;
	
	@Column(name = "fc")
	private Double fc;
	
	@Column(name = "fr")
	private Double fr;
	
	@Column(name = "temp")
	private Double temp;
	
	@Column(name = "circunfAbdominal")
	private Double circunfAbdominal;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;


	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public Boolean getAcudioCita() {
		return acudioCita;
	}

	public void setAcudioCita(Boolean acudioCita) {
		this.acudioCita = acudioCita;
	}

	public Integer getTallaCm() {
		return tallaCm;
	}

	public void setTallaCm(Integer tallaCm) {
		this.tallaCm = tallaCm;
	}

	public Integer getTallaPies() {
		return tallaPies;
	}

	public void setTallaPies(Integer tallaPies) {
		this.tallaPies = tallaPies;
	}

	public Integer getTallaIn() {
		return tallaIn;
	}

	public void setTallaIn(Integer tallaIn) {
		this.tallaIn = tallaIn;
	}

	public Double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public Double getPesoLb() {
		return pesoLb;
	}

	public void setPesoLb(Double pesoLb) {
		this.pesoLb = pesoLb;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public Double getPesoIdealKg() {
		return pesoIdealKg;
	}

	public void setPesoIdealKg(Double pesoIdealKg) {
		this.pesoIdealKg = pesoIdealKg;
	}

	public Double getPesoIdealLb() {
		return pesoIdealLb;
	}

	public void setPesoIdealLb(Double pesoIdealLb) {
		this.pesoIdealLb = pesoIdealLb;
	}

	public Double getTa() {
		return ta;
	}

	public void setTa(Double ta) {
		this.ta = ta;
	}

	public Double getFc() {
		return fc;
	}

	public void setFc(Double fc) {
		this.fc = fc;
	}

	public Double getFr() {
		return fr;
	}

	public void setFr(Double fr) {
		this.fr = fr;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getCircunfAbdominal() {
		return circunfAbdominal;
	}

	public void setCircunfAbdominal(Double circunfAbdominal) {
		this.circunfAbdominal = circunfAbdominal;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	
}