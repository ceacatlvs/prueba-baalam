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
@Table( name = "cat_entidad_federativa",
		uniqueConstraints = @UniqueConstraint(columnNames = "idEntidadFedereativa"))
public class CatEntidadFederativa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEntidadFedereativa")
	private Long idEntidadFedereativa;

	@NotNull
	@Size(min = 1, max =100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdEntidadFedereativa() {
		return idEntidadFedereativa;
	}

	public void setIdEntidadFedereativa(Long idEntidadFedereativa) {
		this.idEntidadFedereativa = idEntidadFedereativa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EntidadFederativa [idEntidadFedereativa="
				+ idEntidadFedereativa + ", nombreEntidad=" + descripcion
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idEntidadFedereativa == null) ? 0 : idEntidadFedereativa
						.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
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
		CatEntidadFederativa other = (CatEntidadFederativa) obj;
		if (idEntidadFedereativa == null) {
			if (other.idEntidadFedereativa != null)
				return false;
		} else if (!idEntidadFedereativa.equals(other.idEntidadFedereativa))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
}