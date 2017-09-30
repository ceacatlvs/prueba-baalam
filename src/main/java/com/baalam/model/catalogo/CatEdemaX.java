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
@Table( name = "cat_edemaX",
		uniqueConstraints = @UniqueConstraint(columnNames = "idEdemaX"))
public class CatEdemaX implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEdemaX")
	private Long idEdemaX;

	@NotNull
	@Size(min = 1, max =100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdEdemaX() {
		return idEdemaX;
	}

	public void setIdEdemaX(Long idEdemaX) {
		this.idEdemaX = idEdemaX;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatEdemaX [idEdemaX=" + idEdemaX + ", descripcion="
				+ descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idEdemaX == null) ? 0 : idEdemaX.hashCode());
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
		CatEdemaX other = (CatEdemaX) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idEdemaX == null) {
			if (other.idEdemaX != null)
				return false;
		} else if (!idEdemaX.equals(other.idEdemaX))
			return false;
		return true;
	}
	
}