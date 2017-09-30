package com.baalam.model.histclinica.ef;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFInspeccionGral
 *
 */
@Entity
@Table( name = "consulta_ef_inspeccion_gral",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFInspeccionGral implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "bienDesarrollado", columnDefinition="BIT(1)")
	private Boolean bienDesarrollado;
	
	@Column(name = "deformidades", columnDefinition="BIT(1)")
	private Boolean deformidades;
	
	@Column(name = "bienNutrido", columnDefinition="BIT(1)")
	private Boolean bienNutrido;
	
	@Column(name = "bienAseado", columnDefinition="BIT(1)")
	private Boolean bienAseado;
	
	@Column(name = "habitoNormal", columnDefinition="BIT(1)")
	private Boolean habitoNormal;
	
	@Column(name = "obeso", columnDefinition="BIT(1)")
	private Boolean obeso;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getBienDesarrollado() {
		return bienDesarrollado;
	}

	public void setBienDesarrollado(Boolean bienDesarrollado) {
		this.bienDesarrollado = bienDesarrollado;
	}

	public Boolean getDeformidades() {
		return deformidades;
	}

	public void setDeformidades(Boolean deformidades) {
		this.deformidades = deformidades;
	}

	public Boolean getBienNutrido() {
		return bienNutrido;
	}

	public void setBienNutrido(Boolean bienNutrido) {
		this.bienNutrido = bienNutrido;
	}

	public Boolean getBienAseado() {
		return bienAseado;
	}

	public void setBienAseado(Boolean bienAseado) {
		this.bienAseado = bienAseado;
	}

	public Boolean getHabitoNormal() {
		return habitoNormal;
	}

	public void setHabitoNormal(Boolean habitoNormal) {
		this.habitoNormal = habitoNormal;
	}

	public Boolean getObeso() {
		return obeso;
	}

	public void setObeso(Boolean obeso) {
		this.obeso = obeso;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}