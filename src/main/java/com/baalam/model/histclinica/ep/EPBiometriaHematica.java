package com.baalam.model.histclinica.ep;

import java.io.Serializable;
import java.util.Date;

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
 * Entity implementation class for Entity: EPBiometriaHematica
 *
 */
@Entity
@Table( name = "consulta_ep_biometria_hematica",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EPBiometriaHematica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "fechaBH")
	private Date fechaBH;
	
	@Size(min = 0, max = 7)
	@Column(name = "resultadoBH")
	private String resultadoBH;
	
	@Column(name = "hemoglobina")
	private Double hemoglobina;
	
	@Column(name = "hematocrito")
	private Double hematocrito;
	
	@Column(name = "leucocitos")
	private Double leucocitos;
	
	@Column(name = "plaquetas")
	private Double plaquetas;
	
	@Column(name = "linfocitos")
	private Double linfocitos;
	
	@Size(min = 0, max = 500)
	@Column(name = "otro")
	private String otro;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Date getFechaBH() {
		return fechaBH;
	}

	public void setFechaBH(Date fechaBH) {
		this.fechaBH = fechaBH;
	}

	public String getBiometriaH() {
		return resultadoBH;
	}

	public void setBiometriaH(String biometriaH) {
		this.resultadoBH = biometriaH;
	}

	public Double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(Double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public Double getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(Double hematocrito) {
		this.hematocrito = hematocrito;
	}

	public Double getLeucocitos() {
		return leucocitos;
	}

	public void setLeucocitos(Double leucocitos) {
		this.leucocitos = leucocitos;
	}

	public Double getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(Double plaquetas) {
		this.plaquetas = plaquetas;
	}

	public Double getLinfocitos() {
		return linfocitos;
	}

	public void setLinfocitos(Double linfocitos) {
		this.linfocitos = linfocitos;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	@Override
	public String toString() {
		return "EPBiometriaHematica [padecimientoActual=" + padecimientoActual
				+ ", fechaBH=" + fechaBH + ", resultadoBH=" + resultadoBH
				+ ", hemoglobina=" + hemoglobina + ", hematocrito="
				+ hematocrito + ", leucocitos=" + leucocitos + ", plaquetas="
				+ plaquetas + ", linfocitos=" + linfocitos + ", otro=" + otro
				+ "]";
	}  
}