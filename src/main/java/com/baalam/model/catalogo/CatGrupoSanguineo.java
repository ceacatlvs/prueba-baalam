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
@Table( name = "cat_grupo_sanguineo", 
		uniqueConstraints = @UniqueConstraint(columnNames = "idGrupoSanguineo"))
public class CatGrupoSanguineo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idGrupoSanguineo")
	private Long idGrupoSanguineo;

	@NotNull
	@Size(min = 1, max =50)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdGrupoSanguineo() {
		return idGrupoSanguineo;
	}

	public void setIdGrupoSanguineo(Long idGrupoSanguineo) {
		this.idGrupoSanguineo = idGrupoSanguineo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idGrupoSanguineo == null) ? 0 : idGrupoSanguineo.hashCode());
		result = prime
				* result
				+ ((descripcion == null) ? 0 : descripcion
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
		CatGrupoSanguineo other = (CatGrupoSanguineo) obj;
		if (idGrupoSanguineo == null) {
			if (other.idGrupoSanguineo != null)
				return false;
		} else if (!idGrupoSanguineo.equals(other.idGrupoSanguineo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CatGrupoSanguineo [idGrupoSanguineo=" + idGrupoSanguineo
				+ ", nombreGrupoSanguineo=" + descripcion + "]";
	}
}