package com.baalam.model.catalogo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
@Table( name = "cat_duracion",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatDuracion"))
public class CatDuracion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatDuracion")
	private Long idCatDuracion;
	
	@Size(min = 1, max = 300)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatDuracion() {
		return idCatDuracion;
	}

	public void setIdCatDuracion(Long idCatDuracion) {
		this.idCatDuracion = idCatDuracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatDuracion [idCatDuracion=" + idCatDuracion + ", descripcion="
				+ descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idCatDuracion == null) ? 0 : idCatDuracion.hashCode());
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
		CatDuracion other = (CatDuracion) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idCatDuracion == null) {
			if (other.idCatDuracion != null)
				return false;
		} else if (!idCatDuracion.equals(other.idCatDuracion))
			return false;
		return true;
	}
	
}
