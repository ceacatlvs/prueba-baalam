package com.baalam.model.histclinica.iays;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

/**
 * Entity implementation class for Entity: IAySNeurologico
 *
 */
@Entity
@Table( name = "iays_neurologico",
uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class IAySNeurologico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "negativo", columnDefinition="BIT(1)")
	private Boolean negativo;
	
	@Column(name = "sincope", columnDefinition="BIT(1)")
	private Boolean sincope;
	
	@Column(name = "convulsiones", columnDefinition="BIT(1)")
	private Boolean convulsiones;
	
	@Column(name = "parestesias", columnDefinition="BIT(1)")
	private Boolean parestesias;
	
	@Column(name = "transtornosMarcha", columnDefinition="BIT(1)")
	private Boolean transtornosMarcha;
	
	@Column(name = "problemasSevMemoria", columnDefinition="BIT(1)")
	private Boolean problemasSevMemoria;
	
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

	public Boolean getSincope() {
		return sincope;
	}

	public void setSincope(Boolean sincope) {
		this.sincope = sincope;
	}

	public Boolean getConvulsiones() {
		return convulsiones;
	}

	public void setConvulsiones(Boolean convulsiones) {
		this.convulsiones = convulsiones;
	}

	public Boolean getParestesias() {
		return parestesias;
	}

	public void setParestesias(Boolean parestesias) {
		this.parestesias = parestesias;
	}

	public Boolean getTranstornosMarcha() {
		return transtornosMarcha;
	}

	public void setTranstornosMarcha(Boolean transtornosMarcha) {
		this.transtornosMarcha = transtornosMarcha;
	}

	public Boolean getProblemasSevMemoria() {
		return problemasSevMemoria;
	}

	public void setProblemasSevMemoria(Boolean problemasSevMemoria) {
		this.problemasSevMemoria = problemasSevMemoria;
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