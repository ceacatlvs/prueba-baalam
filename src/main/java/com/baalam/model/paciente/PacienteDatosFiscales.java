package com.baalam.model.paciente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.controlPagos.CpCobroConsulta;

/**
 * Entity implementation class for Entity: PacienteDatosFiscales
 *
 */
@Entity
@Table(name = "datos_fiscales")
public class PacienteDatosFiscales implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Size(min = 0, max = 13)
	@Column(name = "rfc")
	private String rfc;
	
	@Size(min = 1, max = 250)
	@Column(name = "direccionFiscal")
	private String direccionFiscal;
	
	@Size(min = 1, max = 250)
	@Column(name = "coloniaFiscal")
	private String coloniaFiscal;
	
	@Column(name = "delegacionFiscal")
	@Size(min = 1, max = 250)
	private String delegacionFiscal;
	
	@OneToOne
	@JoinColumn(name="idEntidadFedereativa")
	private CatEntidadFederativa entidadFedereativa;	
	
	@Column(name = "paisFiscal")
	@Size(min = 1, max = 250)
	private String paisFiscal;
	
	@Column(name = "cpFiscal")
	@Size(min = 1, max = 6)
	private String cpFiscal;
	
	@Column(name = "telFiscal")
	@Size(min = 1, max = 20)
	private String telFiscal;
	
	@Column(name = "mailFiscal")
	@Size(min = 1, max = 150)
	private String mailFiscal;
	
	@OneToOne
	@JoinColumn(name="idCPCobroConsulta")
	private CpCobroConsulta cobro;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getDireccionFiscal() {
		return direccionFiscal;
	}

	public void setDireccionFiscal(String direccionFiscal) {
		this.direccionFiscal = direccionFiscal;
	}

	public String getColoniaFiscal() {
		return coloniaFiscal;
	}

	public void setColoniaFiscal(String coloniaFiscal) {
		this.coloniaFiscal = coloniaFiscal;
	}

	public String getDelegacionFiscal() {
		return delegacionFiscal;
	}

	public void setDelegacionFiscal(String delegacionFiscal) {
		this.delegacionFiscal = delegacionFiscal;
	}

	public CatEntidadFederativa getEntidadFedereativa() {
		return entidadFedereativa;
	}

	public void setEntidadFedereativa(CatEntidadFederativa entidadFedereativa) {
		this.entidadFedereativa = entidadFedereativa;
	}

	public String getPaisFiscal() {
		return paisFiscal;
	}

	public void setPaisFiscal(String paisFiscal) {
		this.paisFiscal = paisFiscal;
	}

	public String getCpFiscal() {
		return cpFiscal;
	}

	public void setCpFiscal(String cpFiscal) {
		this.cpFiscal = cpFiscal;
	}

	public String getTelFiscal() {
		return telFiscal;
	}

	public void setTelFiscal(String telFiscal) {
		this.telFiscal = telFiscal;
	}

	public String getMailFiscal() {
		return mailFiscal;
	}

	public void setMailFiscal(String mailFiscal) {
		this.mailFiscal = mailFiscal;
	}

	public CpCobroConsulta getCobro() {
		return cobro;
	}

	public void setCobro(CpCobroConsulta cobro) {
		this.cobro = cobro;
	}
}
