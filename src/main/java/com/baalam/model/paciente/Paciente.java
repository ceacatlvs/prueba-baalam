package com.baalam.model.paciente;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.catalogo.CatGrupoSanguineo;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.model.usuario.Doctor;


@Entity
@Table(	name="paciente", uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idPaciente")
	private Long idPaciente;
	
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="idDoctor")
	private Doctor doctor;
	
	/*@OneToMany(mappedBy = "paciente")
	private Set<CitaAgenda> citas;*/
	
	@OneToMany(mappedBy = "paciente", cascade = {CascadeType.PERSIST})
	private Set<PadecimientoActual> consultas;
	
	@Column(name = "fechaUltimaCita")
	private Date fechaUltimaCita;
	
	@Column(name = "fechaCreacion")
	private Date fechaCreacion;
	
	@Column(name = "recomendo")
	@Size(min = 0, max = 250)
	private String recomendo;
	
	@Column(name = "fechaNacimiento")
	@Past
	private Date fechaNacimiento;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "nombrePaciente")
	@Size(min = 1, max = 250)
	private String nombrePaciente;
	
	@Column(name = "ocupacionPaciente")
	@Size(min = 0, max = 250)
	private String ocupacionPaciente;
	
	@Column(name = "telefonoMovil")
	@Size(min = 0, max = 20)
	private String telefonoMovil;
	
	@Column(name = "mail")
	@Size(min = 0, max = 150)
	private String correo;
	
	@Column(name = "nombreFavorito")
	@Size(min = 0, max = 250)
	private String nombreFavorito;
	
	@Column(name = "nombreEsposo")
	@Size(min = 0, max = 250)
	private String nombreEsposo;
	
	@Column(name = "ocupacionEsposo")
	@Size(min = 0, max = 250)
	private String ocupacionEsposo;
	
	@Column(name = "domicilioPaciente")
	@Size(min = 0, max = 250)
	private String domicilio;
	
	@Column(name = "colonia")
	@Size(min = 0, max = 250)
	private String colonia;
	
	@Column(name = "delegacion")
	@Size(min = 0, max = 250)
	private String delegacion;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="idEntidadFedereativa")
	private CatEntidadFederativa entidadFedereativa;	
	
	@Column(name = "cp")
	@Size(min = 0, max = 6)
	private String cp;
	
	@Column(name = "telCasa")
	@Size(min = 0, max = 20)
	private String telCasa;
	
	@Column(name = "telOficina")
	@Size(min = 0, max = 20)
	private String telOficina;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="idGrupoSanguineo")
	private CatGrupoSanguineo idGrupoSanguineo;	
	
	@Column(name = "contactoEmergencia")
	@Size(min = 0, max = 250)
	private String contactoEmergencia;
	
	@Column(name = "parentescoContacto")
	@Size(min = 0, max = 250)
	private String parentescoContacto;
	
	@Column(name = "telContactoMovil")
	@Size(min = 0, max = 20)
	private String telContactoMovil;
	
	@Column(name = "telContactoCasa")
	@Size(min = 0, max = 20)
	private String telContactoCasa;
	
	@Column(name = "telContactoOficina")
	@Size(min = 0, max = 20)
	private String telContactoOficina;

	
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getFechaUltimaCita() {
		return fechaUltimaCita;
	}

	public void setFechaUltimaCita(Date fechaUltimaCita) {
		this.fechaUltimaCita = fechaUltimaCita;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getRecomendo() {
		return recomendo;
	}

	public void setRecomendo(String recomendo) {
		this.recomendo = recomendo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		System.out.println("Edad (set):"+edad);
		this.edad = edad;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getOcupacionPaciente() {
		return ocupacionPaciente;
	}

	public void setOcupacionPaciente(String ocupacionPaciente) {
		this.ocupacionPaciente = ocupacionPaciente;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreFavorito() {
		return nombreFavorito;
	}

	public void setNombreFavorito(String nombreFavorito) {
		this.nombreFavorito = nombreFavorito;
	}

	public String getNombreEsposo() {
		return nombreEsposo;
	}

	public void setNombreEsposo(String nombreEsposo) {
		this.nombreEsposo = nombreEsposo;
	}

	public String getOcupacionEsposo() {
		return ocupacionEsposo;
	}

	public void setOcupacionEsposo(String ocupacionEsposo) {
		this.ocupacionEsposo = ocupacionEsposo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public CatEntidadFederativa getEntidadFedereativa() {
		return entidadFedereativa;
	}

	public void setEntidadFedereativa(CatEntidadFederativa entidadFedereativa) {
		this.entidadFedereativa = entidadFedereativa;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
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

	public CatGrupoSanguineo getIdGrupoSanguineo() {
		return idGrupoSanguineo;
	}

	public void setIdGrupoSanguineo(CatGrupoSanguineo idGrupoSanguineo) {
		this.idGrupoSanguineo = idGrupoSanguineo;
	}

	public String getContactoEmergencia() {
		return contactoEmergencia;
	}

	public void setContactoEmergencia(String contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}

	public String getParentescoContacto() {
		return parentescoContacto;
	}

	public void setParentescoContacto(String parentescoContacto) {
		this.parentescoContacto = parentescoContacto;
	}

	public String getTelContactoMovil() {
		return telContactoMovil;
	}

	public void setTelContactoMovil(String telContactoMovil) {
		this.telContactoMovil = telContactoMovil;
	}

	public String getTelContactoCasa() {
		return telContactoCasa;
	}

	public void setTelContactoCasa(String telContactoCasa) {
		this.telContactoCasa = telContactoCasa;
	}

	public String getTelContactoOficina() {
		return telContactoOficina;
	}

	public void setTelContactoOficina(String telContactoOficina) {
		this.telContactoOficina = telContactoOficina;
	}

	/*public Set<CitaAgenda> getCitas() {
		return citas;
	}

	public void setCitas(Set<CitaAgenda> citas) {
		this.citas = citas;
	}*/

	public Set<PadecimientoActual> getConsultas() {
		return consultas;
	}

	public void setConsultas(Set<PadecimientoActual> consultas) {
		this.consultas = consultas;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", doctor=" + doctor
				+ ", fechaUltimaCita=" + fechaUltimaCita + ", fechaCreacion="
				+ fechaCreacion + ", recomendo=" + recomendo
				+ ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad
				+ ", nombrePaciente=" + nombrePaciente + ", ocupacionPaciente="
				+ ocupacionPaciente + ", telefonoMovil=" + telefonoMovil
				+ ", correo=" + correo + ", nombreFavorito=" + nombreFavorito
				+ ", nombreEsposo=" + nombreEsposo + ", ocupacionEsposo="
				+ ocupacionEsposo + ", domicilio=" + domicilio + ", colonia="
				+ colonia + ", delegacion=" + delegacion
				+ ", entidadFedereativa=" + entidadFedereativa + ", cp=" + cp
				+ ", telCasa=" + telCasa + ", telOficina=" + telOficina
				+ ", idGrupoSanguineo=" + idGrupoSanguineo
				+ ", contactoEmergencia=" + contactoEmergencia
				+ ", parentescoContacto=" + parentescoContacto
				+ ", telContactoMovil=" + telContactoMovil
				+ ", telContactoCasa=" + telContactoCasa
				+ ", telContactoOficina=" + telContactoOficina + "]";
	}
}
