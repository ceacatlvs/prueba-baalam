package com.baalam.model.agenda;

import java.io.Serializable;
import java.util.Date;

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

import com.baalam.model.usuario.Doctor;


@Entity
@Table(name="cita_cancelada")
public class CitaCancelada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCitaCancelada")
	private Long idCitaCancelada;
	
	@Column(name = "nombrePaciente")
	@Size(min = 1, max = 250)
	private String nombrePaciente;
	
	@Column(name = "telefonoMovil")
	@Size(min = 0, max = 20)
	private String telefonoMovil;
	
	@Column(name = "telCasa")
	@Size(min = 0, max = 20)
	private String telCasa;
	
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
	@Column(name = "motivoCancelacionCita", columnDefinition = "Varchar(300) default ' '")
	private String motivoCancelacionCita;
	
	@NotNull
	@Column(name = "fechaCitaInicio")
	private Date citaInicio;
	
	@NotNull
	@Column(name = "fechaCitaFin")
	private Date citaFin;
	
	//@NotNull
	@Column(name = "fechaCancelacion", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date fechaCancelacion;
	
	@Size(min = 1, max = 300)
	@Column(name = "cancelador")
	private String cancelador;
	
	
	public Long getIdCitaCancelada() {
		return idCitaCancelada;
	}

	public void setIdCitaCancelada(Long idCitaCancelada) {
		this.idCitaCancelada = idCitaCancelada;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getTelCasa() {
		return telCasa;
	}

	public void setTelCasa(String telCasa) {
		this.telCasa = telCasa;
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

	public String getMotivoCancelacionCita() {
		return motivoCancelacionCita;
	}

	public void setMotivoCancelacionCita(String motivoCancelacionCita) {
		this.motivoCancelacionCita = motivoCancelacionCita;
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

	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	public String getCancelador() {
		return cancelador;
	}

	public void setCancelador(String cancelador) {
		this.cancelador = cancelador;
	}
}
