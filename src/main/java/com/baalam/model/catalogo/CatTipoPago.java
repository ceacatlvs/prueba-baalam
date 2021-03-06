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
@Table( name = "cat_tipo_pago",
		uniqueConstraints = @UniqueConstraint(columnNames = "idTipoPago"))
public class CatTipoPago implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idTipoPago")
	private Long idTipoPago;

	@NotNull
	@Size(min = 1, max =100)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(Long idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CatTipoPago [idTipoPago=" + idTipoPago + ", descripcion="
				+ descripcion + "]";
	}
	
}