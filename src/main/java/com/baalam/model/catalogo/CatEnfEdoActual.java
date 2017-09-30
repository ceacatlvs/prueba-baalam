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
@Table( name = "cat_enf_edo_actual",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatEnfEdoActual"))
public class CatEnfEdoActual implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatEnfEdoActual")
	private Long idCatEnfEdoActual;
	
	@Size(min = 1, max = 100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatEnfEdoActual() {
		return idCatEnfEdoActual;
	}

	public void setIdCatEnfEdoActual(Long idCatEnfEdoActual) {
		this.idCatEnfEdoActual = idCatEnfEdoActual;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatEnfEdoActual [idCatEnfEdoActual=" + idCatEnfEdoActual
				+ ", descripcion=" + descripcion + "]";
	}
	
}