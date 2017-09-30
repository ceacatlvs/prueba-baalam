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


@Entity
@Table( name = "cat_placenta",
		uniqueConstraints = @UniqueConstraint(columnNames = "idPlacenta"))
public class CatPlacenta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idPlacenta")
	private Long idPlacenta;

	@NotNull
	@Size(min = 1, max =100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdPlacenta() {
		return idPlacenta;
	}

	public void setIdPlacenta(Long idPlacenta) {
		this.idPlacenta = idPlacenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatPlacenta [idPlacenta=" + idPlacenta + ", descripcion="
				+ descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idPlacenta == null) ? 0 : idPlacenta.hashCode());
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
		CatPlacenta other = (CatPlacenta) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idPlacenta == null) {
			if (other.idPlacenta != null)
				return false;
		} else if (!idPlacenta.equals(other.idPlacenta))
			return false;
		return true;
	}
	
}