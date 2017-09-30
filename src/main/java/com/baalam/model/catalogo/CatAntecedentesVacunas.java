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
@Table( name = "cat_antecedentes_vacuna",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatAntVacunas"))
public class CatAntecedentesVacunas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatAntVacunas")
	private Long idCatAntVacunas;
	
	@Size(min = 1, max = 100)
	@Column(name = "descripcion")
	private String descripcion;
	
	public Long getIdCatAntVacunas() {
		return idCatAntVacunas;
	}

	public void setIdCatAntVacunas(Long idCatAntVacunas) {
		this.idCatAntVacunas = idCatAntVacunas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatAntecedentesVacunas [idCatAntVacunas=" + idCatAntVacunas
				+ ", descripcion=" + descripcion + "]";
	}
	
}
