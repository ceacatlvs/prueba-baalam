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
@Table( name = "cat_enfermedad",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatEnfermedad"))
public class CatEnfermedad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatEnfermedad")
	private Long idCatEnfermedad;
	
	@Size(min = 1, max = 100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatEnfermedad() {
		return idCatEnfermedad;
	}

	public void setIdCatEnfermedad(Long idCatEnfermedad) {
		this.idCatEnfermedad = idCatEnfermedad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatEnfermedad [idCatEnfermedad=" + idCatEnfermedad
				+ ", descripcion=" + descripcion + "]";
	}
}
