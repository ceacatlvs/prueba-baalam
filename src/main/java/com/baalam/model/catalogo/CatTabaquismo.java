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
@Table( name = "cat_tabaquismo",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatTabaquismo"))
public class CatTabaquismo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatTabaquismo")
	private Long idCatTabaquismo;
	
	@Size(min = 1, max = 300)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatTabaquismo() {
		return idCatTabaquismo;
	}

	public void setIdCatTabaquismo(Long idCatTabaquismo) {
		this.idCatTabaquismo = idCatTabaquismo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatTabaquismo [idCatTabaquismo=" + idCatTabaquismo
				+ ", descripcion=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idCatTabaquismo == null) ? 0 : idCatTabaquismo.hashCode());
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
		CatTabaquismo other = (CatTabaquismo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idCatTabaquismo == null) {
			if (other.idCatTabaquismo != null)
				return false;
		} else if (!idCatTabaquismo.equals(other.idCatTabaquismo))
			return false;
		return true;
	}
	
}
