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
@Table( name = "cat_anticonceptivos",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatAnticonceptivos"))
public class CatAnticonceptivos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatAnticonceptivos")
	private Long idCatAnticonceptivos;
	
	@Size(min = 1, max = 100)
	@Column(name = "descripcion")
	private String descripcion;
	
	public Long getIdCatAnticonceptivos() {
		return idCatAnticonceptivos;
	}

	public void setIdCatAnticonceptivos(Long idCatAnticonceptivos) {
		this.idCatAnticonceptivos = idCatAnticonceptivos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}