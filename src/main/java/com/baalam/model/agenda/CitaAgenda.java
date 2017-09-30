package com.baalam.model.agenda;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.paciente.Paciente;
import com.baalam.model.usuario.Doctor;

@Entity
@Table(name="cita_agenda")
public class CitaAgenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCita")
	private Long idCita;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@NotNull	
	@ManyToOne
	@JoinColumn(name="idDoctor")
	private Doctor doctor;

	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "tipoConsulta")
	private String tipoConsulta;
	
	@Size(min = 0, max = 150)
	@Column(name = "motivoOcupado", columnDefinition = "Varchar(150) default ' '")
	private String motivoOcupado;
	
	@Column(name = "citaConfirmada", columnDefinition="BIT(1) default 0")
	private Boolean citaConfirmada;
	
	@Size(min = 0, max = 300)
	@Column(name = "notasCita", columnDefinition = "Varchar(300) default ' '")
	private String notasCita;
	
	@Size(min = 0, max = 300)
	@Column(name = "motivoCambioCita")
	private String motivoCambioCita;
	
	@NotNull
	@Column(name = "fechaCitaInicio")
	private Date citaInicio;
	
	@NotNull
	@Column(name = "fechaCitaFin")
	private Date citaFin;
	
	public Long getIdCita() {
		return idCita;
	}
	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public String getMotivoOcupado() {
		return motivoOcupado;
	}
	public void setMotivoOcupado(String motivoOcupado) {
		this.motivoOcupado = motivoOcupado;
	}

	public Boolean getCitaConfirmada() {
		return citaConfirmada;
	}
	public void setCitaConfirmada(Boolean citaConfirmada) {
		this.citaConfirmada = citaConfirmada;
	}

	public String getNotasCita() {
		return notasCita;
	}
	public void setNotasCita(String notasCita) {
		this.notasCita = notasCita;
	}

	public String getMotivoCambioCita() {
		return motivoCambioCita;
	}
	public void setMotivoCambioCita(String motivoCambioCita) {
		this.motivoCambioCita = motivoCambioCita;
	}

	public Date getCitaInicio() {
		return citaInicio;
	}
	public void setCitaInicio(Date citaInicio) {
		this.citaInicio = citaInicio;
	}

	public Date getCitaFin() {
		return citaFin;
	}
	public void setCitaFin(Date citaFin) {
		this.citaFin = citaFin;
	}
	
	@Override
	public String toString() {
		return "CitaAgenda [idCita=" + idCita + ", paciente=" + paciente
				+ ", doctor=" + doctor + ", tipoConsulta=" + tipoConsulta
				+ ", motivoOcupado=" + motivoOcupado + ", citaConfirmada="
				+ citaConfirmada + ", notasCita=" + notasCita
				+ ", motivoCambioCita=" + motivoCambioCita + ", citaInicio="
				+ citaInicio + ", citaFin=" + citaFin + "]";
	}
}