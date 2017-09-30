package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySGenitourinario
 *
 */
@Entity
@Table( name = "iays_genitourinario",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySGenitourinario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "hematuria", columnDefinition="BIT(1)")
	private Boolean hematuria;
	
	@Column(name = "disuria", columnDefinition="BIT(1)")
	private Boolean disuria;
	
	@Column(name = "polaquiuria", columnDefinition="BIT(1)")
	private Boolean polaquiuria;
	
	@Column(name = "urgencia", columnDefinition="BIT(1)")
	private Boolean urgencia;
	
	@Column(name = "vaciadoIncompleto", columnDefinition="BIT(1)")
	private Boolean vaciadoIncompleto;
	
	@Column(name = "incontinenciaUrgencia", columnDefinition="BIT(1)")
	private Boolean incontinenciaUrgencia;
	
	@Column(name = "incontinenciaEsfuerzo", columnDefinition="BIT(1)")
	private Boolean incontinenciaEsfuerzo;
	
	@Column(name = "dispaurenia", columnDefinition="BIT(1)")
	private Boolean dispaurenia;
	
	@Column(name = "sangradoVagAnormal", columnDefinition="BIT(1)")
	private Boolean sangradoVagAnormal;
	
	@Column(name = "leucorreaAnormal", columnDefinition="BIT(1)")
	private Boolean leucorreaAnormal;
	
	@Column(name = "prurito", columnDefinition="BIT(1)")
	private Boolean prurito;
	
	@Column(name = "ardor", columnDefinition="BIT(1)")
	private Boolean ardor;
	
	@Column(name = "malOlor", columnDefinition="BIT(1)")
	private Boolean malOlor;
		
	@Size(min = 0, max = 500)
	@Column(name = "otro")
	private String otro;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Boolean getNegativo() {
		return negativo;
	}

	public void setNegativo(Boolean negativo) {
		this.negativo = negativo;
	}

	public Boolean getHematuria() {
		return hematuria;
	}

	public void setHematuria(Boolean hematuria) {
		this.hematuria = hematuria;
	}

	public Boolean getDisuria() {
		return disuria;
	}

	public void setDisuria(Boolean disuria) {
		this.disuria = disuria;
	}

	public Boolean getPolaquiuria() {
		return polaquiuria;
	}

	public void setPolaquiuria(Boolean polaquiuria) {
		this.polaquiuria = polaquiuria;
	}

	public Boolean getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(Boolean urgencia) {
		this.urgencia = urgencia;
	}

	public Boolean getVaciadoIncompleto() {
		return vaciadoIncompleto;
	}

	public void setVaciadoIncompleto(Boolean vaciadoIncompleto) {
		this.vaciadoIncompleto = vaciadoIncompleto;
	}

	public Boolean getIncontinenciaUrgencia() {
		return incontinenciaUrgencia;
	}

	public void setIncontinenciaUrgencia(Boolean incontinenciaUrgencia) {
		this.incontinenciaUrgencia = incontinenciaUrgencia;
	}

	public Boolean getIncontinenciaEsfuerzo() {
		return incontinenciaEsfuerzo;
	}

	public void setIncontinenciaEsfuerzo(Boolean incontinenciaEsfuerzo) {
		this.incontinenciaEsfuerzo = incontinenciaEsfuerzo;
	}

	public Boolean getDispaurenia() {
		return dispaurenia;
	}

	public void setDispaurenia(Boolean dispaurenia) {
		this.dispaurenia = dispaurenia;
	}

	public Boolean getSangradoVagAnormal() {
		return sangradoVagAnormal;
	}

	public void setSangradoVagAnormal(Boolean sangradoVagAnormal) {
		this.sangradoVagAnormal = sangradoVagAnormal;
	}

	public Boolean getLeucorreaAnormal() {
		return leucorreaAnormal;
	}

	public void setLeucorreaAnormal(Boolean leucorreaAnormal) {
		this.leucorreaAnormal = leucorreaAnormal;
	}

	public Boolean getPrurito() {
		return prurito;
	}

	public void setPrurito(Boolean prurito) {
		this.prurito = prurito;
	}

	public Boolean getArdor() {
		return ardor;
	}

	public void setArdor(Boolean ardor) {
		this.ardor = ardor;
	}

	public Boolean getMalOlor() {
		return malOlor;
	}

	public void setMalOlor(Boolean malOlor) {
		this.malOlor = malOlor;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}  
}