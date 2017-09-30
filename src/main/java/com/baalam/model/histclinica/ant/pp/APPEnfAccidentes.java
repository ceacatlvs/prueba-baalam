package com.baalam.model.histclinica.ant.pp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "app_enfermedades_o_accidentes",
		uniqueConstraints = @UniqueConstraint(columnNames = "idAppEnfAccidentes"))
public class APPEnfAccidentes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAppEnfAccidentes")
	private Long idAppEnfAccidentes;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "tipo")
	@Size(min = 0, max = 200)
	private String tipo;
	
	@Column(name = "fecha")
	private Date fecha;

	public Long getIdEnfAccidentes() {
		return idAppEnfAccidentes;
	}

	public void setIdEnfAccidentes(Long idEnfAccidentes) {
		this.idAppEnfAccidentes = idEnfAccidentes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}