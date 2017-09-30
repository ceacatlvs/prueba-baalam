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
@Table( name = "cat_escolaridad",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatEscolaridad"))
public class CatEscolaridad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatEscolaridad")
	private Long idCatEscolaridad;
	
	@Size(min = 1, max = 50)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatEscolaridad() {
		return idCatEscolaridad;
	}

	public void setIdCatEscolaridad(Long idCatEscolaridad) {
		this.idCatEscolaridad = idCatEscolaridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatEscolaridad [idCatEscolaridad=" + idCatEscolaridad
				+ ", descripcion=" + descripcion + "]";
	}
	
}
