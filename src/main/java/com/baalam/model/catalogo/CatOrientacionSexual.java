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
@Table( name = "cat_orientacion_sexual",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatOrientacionSexual"))
public class CatOrientacionSexual implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatOrientacionSexual")
	private Long idCatOrientacionSexual;
	
	@Size(min = 1, max = 50)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatOrientacionSexual() {
		return idCatOrientacionSexual;
	}

	public void setIdCatOrientacionSexual(Long idCatOrientacionSexual) {
		this.idCatOrientacionSexual = idCatOrientacionSexual;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatOrientacionSexual [idCatOrientacionSexual="
				+ idCatOrientacionSexual + ", descripcion=" + descripcion + "]";
	}
	
}
