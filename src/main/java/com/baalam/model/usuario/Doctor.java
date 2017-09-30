package com.baalam.model.usuario;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

/*@NamedQuery(name = "buscarSecretariasNoDoctorActual",
			query = "select s.idSecretaria from Secretaria s where s.idSecretaria NOT IN (select d.secretarias.idSecretaria from Doctor d where d.idDoctor = :idDoctor)")*/

//query = "select s from Secretaria s where s.idSecretaria NOT IN (select idSecreataria from doctor_secretaria where idDoctor = :idDoctor)")

@Table( name = "doctor", uniqueConstraints = @UniqueConstraint(columnNames = "idDoctor"))
public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idDoctor")
	private Long idDoctor;

	@Size(min = 1, max = 80)
	@Column(name = "nombre")
	private String nombre;

	@Size(min = 1, max = 50)
	@Column(name = "aPaterno")
	private String aPaterno;

	@Size(min = 1, max = 50)
	@Column(name = "aMaterno")
	private String aMaterno;

	@Size(min = 1, max = 50)
	@Column(name = "especialidad")
	private String especialidad;

	@Size(min = 0, max = 20)
	@Column(name = "celular")
	private String celular;

	@Size(min = 0, max = 20)
	@Column(name = "celular2")
	private String celular2;
	
	@Size(min = 1, max = 50)
	@Column(name = "correo1")
	private String correo1;

	@Size(min = 0, max = 50)
	@Column(name = "correo2")
	private String correo2;

	@Size(min = 0, max = 150)
	@Column(name = "sitioWeb")
	private String sitioWeb;

	@NotNull
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<DoctorSecretaria> secretarias = new HashSet<DoctorSecretaria>(0);


	public Long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	public String getCorreo1() {
		return correo1;
	}

	public void setCorreo1(String correo1) {
		this.correo1 = correo1;
	}

	public String getCorreo2() {
		return correo2;
	}

	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<DoctorSecretaria> getSecretarias() {
		return secretarias;
	}

	public void setSecretarias(Set<DoctorSecretaria> secretarias) {
		this.secretarias = secretarias;
	}

	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", nombre=" + nombre
				+ ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno
				+ ", especialidad=" + especialidad + ", celular=" + celular
				+ ", celular2=" + celular2 + ", correo1=" + correo1
				+ ", correo2=" + correo2 + ", sitioWeb=" + sitioWeb
				+ ", usuario=" + usuario +  "]";
	}
}
