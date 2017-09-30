package com.baalam.model.usuario;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name="secretaria",
		uniqueConstraints = @UniqueConstraint(columnNames = "idSecretaria"))
public class Secretaria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idSecretaria")
	private Long idSecretaria;

	@Size(min = 1, max = 80)
	@Column(name = "nombre")
	private String nombre;

	@Size(min = 1, max = 50)
	@Column(name = "aPaterno")
	private String aPaterno;

	@Size(min = 1, max = 50)
	@Column(name = "aMaterno")
	private String aMaterno;

	@Size(min = 0, max = 20)
	@Column(name = "telContacto")
	private String telContacto;

	@Size(min = 0, max = 20)
	@Column(name = "telContacto2")
	private String telContacto2;
	
	@Size(min = 1, max = 50)
	@Column(name = "correo1")
	private String correo1;

	@Size(min = 0, max = 50)
	@Column(name = "correo2")
	private String correo2;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "secreataria", fetch = FetchType.EAGER)
	private Set<DoctorSecretaria> doctores = new HashSet<DoctorSecretaria>(0);	
	

	public Long getIdSecretaria() {
		return idSecretaria;
	}

	public void setIdSecretaria(Long idSecretaria) {
		this.idSecretaria = idSecretaria;
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

	public String getTelContacto() {
		return telContacto;
	}

	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}

	public String getTelContacto2() {
		return telContacto2;
	}

	public void setTelContacto2(String telContacto2) {
		this.telContacto2 = telContacto2;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<DoctorSecretaria> getDoctores() {
		return doctores;
	}
	public void setDoctores(Set<DoctorSecretaria> doctores) {
		this.doctores = doctores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aMaterno == null) ? 0 : aMaterno.hashCode());
		result = prime * result
				+ ((aPaterno == null) ? 0 : aPaterno.hashCode());
		result = prime * result
				+ ((doctores == null) ? 0 : doctores.hashCode());
		result = prime * result
				+ ((idSecretaria == null) ? 0 : idSecretaria.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((telContacto == null) ? 0 : telContacto.hashCode());
		result = prime * result
				+ ((telContacto2 == null) ? 0 : telContacto2.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secretaria other = (Secretaria) obj;
		if (aMaterno == null) {
			if (other.aMaterno != null)
				return false;
		} else if (!aMaterno.equals(other.aMaterno))
			return false;
		if (aPaterno == null) {
			if (other.aPaterno != null)
				return false;
		} else if (!aPaterno.equals(other.aPaterno))
			return false;
		if (doctores == null) {
			if (other.doctores != null)
				return false;
		} else if (!doctores.equals(other.doctores))
			return false;
		if (idSecretaria == null) {
			if (other.idSecretaria != null)
				return false;
		} else if (!idSecretaria.equals(other.idSecretaria))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telContacto == null) {
			if (other.telContacto != null)
				return false;
		} else if (!telContacto.equals(other.telContacto))
			return false;
		if (telContacto2 == null) {
			if (other.telContacto2 != null)
				return false;
		} else if (!telContacto2.equals(other.telContacto2))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}