package com.baalam.model.controlPagos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

@Entity
@Table( name = "control_pagos_cobro_consulta",
uniqueConstraints = @UniqueConstraint(columnNames = "idCPCobroConsulta"))
public class CpCobroConsulta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCPCobroConsulta")
	private Long idCPCobroConsulta;
	
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "monto")
	private Double monto;
	
	@Column(name = "cortesia", columnDefinition="BIT(1)")
	private Boolean cortesia;
	
	@Column(name = "recibo", columnDefinition="BIT(1)")
	private Boolean recibo;
	
	@Column(name = "notas")
	@Size(min = 0, max = 500)
	private String notas;
	
	@Column(name = "pendientePagar")
	private Double pendientePagar;
	
	@Column(name = "formaPago")
	@Size(min = 0, max = 30)
	private String formaPago;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cpCobroConsulta", fetch=FetchType.EAGER)
	private List<CpPagos> cpPagos;

	public Long getIdCPCobroConsulta() {
		return idCPCobroConsulta;
	}

	public void setIdCPCobroConsulta(Long idCPCobroConsulta) {
		this.idCPCobroConsulta = idCPCobroConsulta;
	}

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Boolean getCortesia() {
		return cortesia;
	}

	public void setCortesia(Boolean cortesia) {
		this.cortesia = cortesia;
	}

	public Boolean getRecibo() {
		return recibo;
	}

	public void setRecibo(Boolean recibo) {
		this.recibo = recibo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public Double getPendientePagar() {
		return pendientePagar;
	}

	public void setPendientePagar(Double pendientePagar) {
		this.pendientePagar = pendientePagar;
	}
	
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public List<CpPagos> getCpPagos() {
		return cpPagos;
	}

	public void setCpPagos(List<CpPagos> cpPagos) {
		this.cpPagos = cpPagos;
	}

	@Override
	public String toString() {
		return "CpCobroConsulta [idCobroConsulta=" + idCPCobroConsulta
				+ ", padecimientoActual=" + padecimientoActual + ", monto="
				+ monto + ", recibo=" + recibo + ", descripcion=" + notas + "]";
	}	
}