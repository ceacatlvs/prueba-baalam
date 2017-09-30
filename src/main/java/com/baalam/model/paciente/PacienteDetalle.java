package com.baalam.model.paciente;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="busqueda_pacientes")
@Inheritance(strategy=InheritanceType.JOINED)
public class PacienteDetalle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idPaciente;
	
	private Long idDoctor;
	private Long idConsulta;
	private Long idControlEmbarazo;
	
	private Date fechaUltimaCita;
	
	private String nombrePaciente;
	private String motivoConsulta;
	private String semanasEmbarazo;
	private String tratamiento;
	//private String diagnostico;
	private String mail;
	private String telCasa;
	private String telOficina;
	private String telefonoMovil;
	//private Boolean recibo;
	
	public Long getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public Long getIdControlEmbarazo() {
		return idControlEmbarazo;
	}
	public void setIdControlEmbarazo(Long idControlEmbarazo) {
		this.idControlEmbarazo = idControlEmbarazo;
	}
	
	public Date getFechaUltimaCita() {
		return fechaUltimaCita;
	}
	public void setFechaUltimaCita(Date fechaUltimaCita) {
		this.fechaUltimaCita = fechaUltimaCita;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getSemanasEmbarazo() {
		/*hay un problema en el despliegue de las semanas de embarazo cuando es la semana exacta
		 * ya vi cual es el problema, lo que provoca eso es la línea donde se hace el substring 
		 * de semanas de embarazo porque el punto es 0, ya con esto ya se qué hacer para remediarlo*/
		int punto = semanasEmbarazo.indexOf(".");
		String dias = " ";
		if(punto != -1){
			Double diasd = Double.parseDouble(semanasEmbarazo.substring(punto));
			punto = (int)(Math.ceil(diasd * 7.0));
			
			dias = " " + punto + "/7";

			//if(punto != 0){
				semanasEmbarazo = semanasEmbarazo.substring(0, semanasEmbarazo.indexOf("."));
		}
		return semanasEmbarazo + dias;
	}
	
	public void setSemanasEmbarazo(String semanasEmbarazo) {
		this.semanasEmbarazo = semanasEmbarazo;
	}
	
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String chOtros) {
		this.tratamiento = chOtros;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getTelCasa() {
		return telCasa;
	}
	public void setTelCasa(String telCasa) {
		this.telCasa = telCasa;
	}
	
	public String getTelOficina() {
		return telOficina;
	}
	public void setTelOficina(String telOficina) {
		this.telOficina = telOficina;
	}
	
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	public void setTelefonoMovil(String telMovil) {
		this.telefonoMovil = telMovil;
	}
	
	/*public Boolean getRecibo() {
		return recibo;
	}
	public void setRecibo(Boolean recibo) {
		this.recibo = recibo;
	}*/
	
	@Override
	public String toString() {
		return "PacienteDetalle [idPaciente=" + idPaciente + ", idDoctor="
				+ idDoctor + ", idConsulta=" + idConsulta
				+ ", idControlEmbarazo=" + idControlEmbarazo
				+ ", fechaUltimaCita=" + fechaUltimaCita + ", nombrePaciente="
				+ nombrePaciente + ", motivoConsulta=" + motivoConsulta
				+ ", semanasEmbarazo=" + semanasEmbarazo + ", tratamiento="
				+ tratamiento + ", correoElectronico=" + mail
				+ ", telCasa=" + telCasa + ", telOficina=" + telOficina
				+ ", telMovil=" + telefonoMovil + ", recibo=" /*+ recibo */+ "]";
	}
}
