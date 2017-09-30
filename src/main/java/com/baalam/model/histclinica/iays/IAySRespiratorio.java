package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySRespiratorio
 *
 */
@Entity
@Table( name = "iays_respiratorio",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySRespiratorio implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "disnea", columnDefinition="BIT(1)")
	private Boolean disnea;
	
	@Column(name = "taquipnea", columnDefinition="BIT(1)")
	private Boolean taquipnea;
	
	@Column(name = "tos", columnDefinition="BIT(1)")
	private Boolean tos;
	
	@Column(name = "sibilancias", columnDefinition="BIT(1)")
	private Boolean sibilancias;
	
	@Column(name = "hemoptisis", columnDefinition="BIT(1)")
	private Boolean hemoptisis;
		
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

	public Boolean getDisnea() {
		return disnea;
	}

	public void setDisnea(Boolean disnea) {
		this.disnea = disnea;
	}

	public Boolean getTaquipnea() {
		return taquipnea;
	}

	public void setTaquipnea(Boolean taquipnea) {
		this.taquipnea = taquipnea;
	}

	public Boolean getTos() {
		return tos;
	}

	public void setTos(Boolean tos) {
		this.tos = tos;
	}

	public Boolean getSibilancias() {
		return sibilancias;
	}

	public void setSibilancias(Boolean sibilancias) {
		this.sibilancias = sibilancias;
	}

	public Boolean getHemoptisis() {
		return hemoptisis;
	}

	public void setHemoptisis(Boolean hemoptisis) {
		this.hemoptisis = hemoptisis;
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