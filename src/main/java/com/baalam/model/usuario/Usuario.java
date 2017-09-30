package com.baalam.model.usuario;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name="usuario",
		uniqueConstraints = @UniqueConstraint(columnNames = "idUsuario"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "fechaCreacionUsuario")
	private Date fechaCreacionUsuario;
	
	@Column(name = "fechaUltimoAcceso")
	private Date fechaUltimoAcceso;
	
	@Size(min = 1, max = 150)
	@Column(name = "preguntaSecreta")
	private String preguntaSecreta;
	
	@Size(min = 1, max = 20)
	@Column(name = "respuestaSecreta")
	private String respuestaSecreta;
	
	@Column(name = "fechaCambioPassword")
	private Date fechaCambioPassword;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaCreacionUsuario() {
		return fechaCreacionUsuario;
	}

	public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
		this.fechaCreacionUsuario = fechaCreacionUsuario;
	}

	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	public String getPreguntaSecreta() {
		return preguntaSecreta;
	}

	public void setPreguntaSecreta(String preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}

	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}

	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}

	public Date getFechaCambioPassword() {
		return fechaCambioPassword;
	}

	public void setFechaCambioPassword(Date fechaCambioPassword) {
		this.fechaCambioPassword = fechaCambioPassword;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((fechaCambioPassword == null) ? 0 : fechaCambioPassword
						.hashCode());
		result = prime
				* result
				+ ((fechaCreacionUsuario == null) ? 0 : fechaCreacionUsuario
						.hashCode());
		result = prime
				* result
				+ ((fechaUltimoAcceso == null) ? 0 : fechaUltimoAcceso
						.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((preguntaSecreta == null) ? 0 : preguntaSecreta.hashCode());
		result = prime
				* result
				+ ((respuestaSecreta == null) ? 0 : respuestaSecreta.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (fechaCambioPassword == null) {
			if (other.fechaCambioPassword != null)
				return false;
		} else if (!fechaCambioPassword.equals(other.fechaCambioPassword))
			return false;
		if (fechaCreacionUsuario == null) {
			if (other.fechaCreacionUsuario != null)
				return false;
		} else if (!fechaCreacionUsuario.equals(other.fechaCreacionUsuario))
			return false;
		if (fechaUltimoAcceso == null) {
			if (other.fechaUltimoAcceso != null)
				return false;
		} else if (!fechaUltimoAcceso.equals(other.fechaUltimoAcceso))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (preguntaSecreta == null) {
			if (other.preguntaSecreta != null)
				return false;
		} else if (!preguntaSecreta.equals(other.preguntaSecreta))
			return false;
		if (respuestaSecreta == null) {
			if (other.respuestaSecreta != null)
				return false;
		} else if (!respuestaSecreta.equals(other.respuestaSecreta))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}