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
@Table( name = "cat_msFs",
		uniqueConstraints = @UniqueConstraint(columnNames = "idMsFs"))
public class CatMsFs implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idMsFs")
	private Long idMsFs;

	@NotNull
	@Size(min = 1, max =100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdMsFs() {
		return idMsFs;
	}

	public void setIdMsFs(Long idMsFs) {
		this.idMsFs = idMsFs;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatMsFs [idMsFs=" + idMsFs + ", descripcion=" + descripcion
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idMsFs == null) ? 0 : idMsFs.hashCode());
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
		CatMsFs other = (CatMsFs) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idMsFs == null) {
			if (other.idMsFs != null)
				return false;
		} else if (!idMsFs.equals(other.idMsFs))
			return false;
		return true;
	}
	
}