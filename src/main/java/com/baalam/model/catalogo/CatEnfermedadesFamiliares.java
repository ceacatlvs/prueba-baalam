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
@Table( name = "cat_enfermedades_familiares",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatEnfermedadFamiliar"))
public class CatEnfermedadesFamiliares implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatEnfermedadFamiliar")
	private Long idCatEnfermedadFamiliar;
	
	@Size(min = 1, max = 300)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdCatEnfermedadFamiliar() {
		return idCatEnfermedadFamiliar;
	}

	public void setIdCatEnfermedadFamiliar(Long idCatEnfermedadFamiliar) {
		this.idCatEnfermedadFamiliar = idCatEnfermedadFamiliar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatEnfermedadesFamiliares [idCatEnfermedadFamiliar="
				+ idCatEnfermedadFamiliar + ", descripcion=" + descripcion
				+ "]";
	}
	
}
