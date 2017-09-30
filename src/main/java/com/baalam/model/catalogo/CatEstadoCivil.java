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
@Table( name = "cat_estado_civil",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatEstadoCivil"))
public class CatEstadoCivil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatEstadoCivil")
	private Long idCatEstadoCivil;
	
	@Size(min = 1, max = 50)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatEstadoCivil() {
		return idCatEstadoCivil;
	}

	public void setIdCatEstadoCivil(Long idCatEstadoCivil) {
		this.idCatEstadoCivil = idCatEstadoCivil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatEstadoCivil [idCatEstadoCivil=" + idCatEstadoCivil
				+ ", descripcion=" + descripcion + "]";
	}
	
	
}
