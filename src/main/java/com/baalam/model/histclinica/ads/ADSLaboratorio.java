package com.baalam.model.histclinica.ads;

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
 * Entity implementation class for Entity: ADLaboratorio
 *
 */
@Entity
@Table( name = "consulta_ads_laboratorio",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class ADSLaboratorio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "biometriaHematica", columnDefinition="BIT(1)")
	private Boolean biometriaHematica;
	
	@Column(name = "quimicaSanguinea", columnDefinition="BIT(1)")
	private Boolean quimicaSanguinea;
	
	@Column(name = "elementosQS")
	private Double elementosQS;
	
	@Column(name = "gpoRhSanguineo", columnDefinition="BIT(1)")
	private Boolean gpoRhSanguineo;
	
	@Column(name = "vdrl", columnDefinition="BIT(1)")
	private Boolean vdrl;
	
	@Column(name = "hiv", columnDefinition="BIT(1)")
	private Boolean hiv;
	
	@Column(name = "tiempoProtrombina", columnDefinition="BIT(1)")
	private Boolean tiempoProtrombina;
   
	@Column(name = "tiempoTromboplastinaParcial", columnDefinition="BIT(1)")
	private Boolean tiempoTromboplastinaParcial;
	
	@Column(name = "ego", columnDefinition="BIT(1)")
	private Boolean ego;
	
	@Column(name = "urocultivo", columnDefinition="BIT(1)")
	private Boolean urocultivo;
	
	@Column(name = "glucosaPoscarga50", columnDefinition="BIT(1)")
	private Boolean glucosaPoscarga50;
	
	@Column(name = "curvaToleranciaGlucosaOral", columnDefinition="BIT(1)")
	private Boolean curvaToleranciaGlucosaOral;
	
	@Column(name = "citologiaCervical", columnDefinition="BIT(1)")
	private Boolean citologiaCervical;
	
	@Column(name = "cultivoSecrecionesVaginales", columnDefinition="BIT(1)")
	private Boolean cultivoSecrecionesVaginales;
	
	@Size(min = 0, max = 1000)
	@Column(name = "otrosDescripcion")
	private String otrosDescripcion;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getBiometriaHematica() {
		return biometriaHematica;
	}

	public void setBiometriaHematica(Boolean biometriaHematica) {
		this.biometriaHematica = biometriaHematica;
	}

	public Boolean getQuimicaSanguinea() {
		return quimicaSanguinea;
	}

	public void setQuimicaSanguinea(Boolean quimicaSanguinea) {
		this.quimicaSanguinea = quimicaSanguinea;
	}

	public Double getElementosQS() {
		return elementosQS;
	}

	public void setElementosQS(Double elementosQS) {
		this.elementosQS = elementosQS;
	}

	public Boolean getGpoRhSanguineo() {
		return gpoRhSanguineo;
	}

	public void setGpoRhSanguineo(Boolean gpoRhSanguineo) {
		this.gpoRhSanguineo = gpoRhSanguineo;
	}

	public Boolean getVdrl() {
		return vdrl;
	}

	public void setVdrl(Boolean vdrl) {
		this.vdrl = vdrl;
	}

	public Boolean getHiv() {
		return hiv;
	}

	public void setHiv(Boolean hiv) {
		this.hiv = hiv;
	}

	public Boolean getTiempoProtrombina() {
		return tiempoProtrombina;
	}

	public void setTiempoProtrombina(Boolean tiempoProtrombina) {
		this.tiempoProtrombina = tiempoProtrombina;
	}

	public Boolean getTiempoTromboplastinaParcial() {
		return tiempoTromboplastinaParcial;
	}

	public void setTiempoTromboplastinaParcial(Boolean tiempoTromboplastinaParcial) {
		this.tiempoTromboplastinaParcial = tiempoTromboplastinaParcial;
	}

	public Boolean getEgo() {
		return ego;
	}

	public void setEgo(Boolean ego) {
		this.ego = ego;
	}

	public Boolean getUrocultivo() {
		return urocultivo;
	}

	public void setUrocultivo(Boolean urocultivo) {
		this.urocultivo = urocultivo;
	}

	public Boolean getGlucosaPoscarga50() {
		return glucosaPoscarga50;
	}

	public void setGlucosaPoscarga50(Boolean glucosaPoscarga50) {
		this.glucosaPoscarga50 = glucosaPoscarga50;
	}

	public Boolean getCurvaToleranciaGlucosaOral() {
		return curvaToleranciaGlucosaOral;
	}

	public void setCurvaToleranciaGlucosaOral(Boolean curvaToleranciaGlucosaOral) {
		this.curvaToleranciaGlucosaOral = curvaToleranciaGlucosaOral;
	}

	public Boolean getCitologiaCervical() {
		return citologiaCervical;
	}

	public void setCitologiaCervical(Boolean citologiaCervical) {
		this.citologiaCervical = citologiaCervical;
	}

	public Boolean getCultivoSecrecionesVaginales() {
		return cultivoSecrecionesVaginales;
	}

	public void setCultivoSecrecionesVaginales(Boolean cultivoSecrecionesVaginales) {
		this.cultivoSecrecionesVaginales = cultivoSecrecionesVaginales;
	}

	public String getOtrosDescripcion() {
		return otrosDescripcion;
	}

	public void setOtrosDescripcion(String otrosDescripcion) {
		this.otrosDescripcion = otrosDescripcion;
	}
}
