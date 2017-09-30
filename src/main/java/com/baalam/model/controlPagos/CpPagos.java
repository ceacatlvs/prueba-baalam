package com.baalam.model.controlPagos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatTipoPago;

@Entity
@Table(name = "control_pagos_pagos_cobro",
uniqueConstraints = @UniqueConstraint(columnNames = "idCPPagoCobro"))
public class CpPagos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCPPagoCobro")
	private Long idCPPagoCobro;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idCPCobroConsulta")
	private CpCobroConsulta cpCobroConsulta;
	
	@Column(name = "fechaPago")
	private Date fechaPago;
	
	@Column(name = "cantidadPago")
	private Double cantidadPago;
	
	@OneToOne
	@JoinColumn(name="tipoPago")
	private CatTipoPago tipoPago;
	
	@Column(name = "notas")
	@Size(min = 0, max = 500)
	private String notas;

	public Long getIdCPPagoCobro() {
		return idCPPagoCobro;
	}

	public void setIdCPPagoCobro(Long idCPPagoCobro) {
		this.idCPPagoCobro = idCPPagoCobro;
	}

	public CpCobroConsulta getCpCobroConsulta() {
		return cpCobroConsulta;
	}

	public void setCpCobroConsulta(CpCobroConsulta cpCobroConsulta) {
		this.cpCobroConsulta = cpCobroConsulta;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Double getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public CatTipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(CatTipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "CpPagos [idPago=" + idCPPagoCobro + ", idCobroConsulta=" + cpCobroConsulta
				+ ", fechaPago=" + fechaPago + ", cantidadPagada="
				+ cantidadPago + ", tipoPago=" + tipoPago + "]";
	}	
}
