package com.baalam.model.catalogo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table( name = "cat_especialidad",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatEspecialidad"))
public class CatEspecialidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatEspecialidad")
	private Long idCatEspecialidad;

	@NotNull
	@Size(min = 1, max =100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdEspecialidad() {
		return idCatEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idCatEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return descripcion;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.descripcion = nombreEspecialidad;
	}

	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idCatEspecialidad
				+ ", nombreEspecialidad=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime
				* result
				+ ((idCatEspecialidad == null) ? 0 : idCatEspecialidad
						.hashCode());
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
		CatEspecialidad other = (CatEspecialidad) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idCatEspecialidad == null) {
			if (other.idCatEspecialidad != null)
				return false;
		} else if (!idCatEspecialidad.equals(other.idCatEspecialidad))
			return false;
		return true;
	}
	
}
