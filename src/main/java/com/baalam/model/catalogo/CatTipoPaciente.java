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
@Table( name = "cat_tipo_paciente",
		uniqueConstraints = @UniqueConstraint(columnNames = "idCatTipoPaciente"))
public class CatTipoPaciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCatTipoPaciente")
	private Long idCatTipoPaciente;

	@NotNull
	@Size(min = 1, max =50)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdTipoPaciente() {
		return idCatTipoPaciente;
	}

	public void setIdTipoPaciente(Long idTipoPaciente) {
		this.idCatTipoPaciente = idTipoPaciente;
	}

	public String getDescripcionTipoPaciente() {
		return descripcion;
	}

	public void setDescripcionTipoPaciente(String descripcionTipoPaciente) {
		this.descripcion = descripcionTipoPaciente;
	}

	@Override
	public String toString() {
		return "CatTipoPaciente [idCatTipoPaciente=" + idCatTipoPaciente
				+ ", descripcion=" + descripcion + "]";
	}
}