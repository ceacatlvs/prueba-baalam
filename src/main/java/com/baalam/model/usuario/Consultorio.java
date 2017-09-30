package com.baalam.model.usuario;

import java.io.Serializable;

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
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatEntidadFederativa;


@Entity
@Table(	name="consultorio", 
		uniqueConstraints = @UniqueConstraint(columnNames = "idConsultorio"))
public class Consultorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idConsultorio")
	private Long idConsultorio;

	@Size(min = 0, max = 100)
	@Column(name = "nombre")
	private String nombre;

	@Size(min = 0, max = 200)
	@Column(name = "horario")
	private String horario;

	@Size(min = 0, max = 100)
	@Column(name = "calle")
	private String calle;

	@Size(min = 0, max = 10)
	@Column(name = "numeroExterior")
	private String numeroExterior;

	@Size(min = 0, max = 10)
	@Column(name = "numeroInterior")
	private String numeroInterior;

	@Size(min = 0, max = 100)
	@Column(name = "colonia")
	private String colonia;

	@Size(min = 0, max = 100)
	@Column(name = "delegMuni")
	private String delegMuni;

	@Size(min = 0, max = 6)
	@Column(name = "cp")
	private String cp;
	
	@OneToOne
	@JoinColumn(name="idEntidadFedereativa")
	private CatEntidadFederativa entidadFedereativa;

	@Size(min = 0, max = 80)
	@Column(name = "pais")
	private String pais;

	@Size(min = 0, max = 20)
	@Column(name = "telefono")
	private String telefono;

	@Size(min = 0, max = 20)
	@Column(name = "telefono2")
	private String telefono2;
	
	@Size(min = 0, max = 20)
	@Column(name = "fax")
	private String fax;
	
	@ManyToOne
	@JoinColumn(name="idDoctor")
	private Doctor doctor;

	public Long getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Long idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDelegMuni() {
		return delegMuni;
	}

	public void setDelegMuni(String delegMuni) {
		this.delegMuni = delegMuni;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public CatEntidadFederativa getEntidadFedereativa() {
		return entidadFedereativa;
	}

	public void setEntidadFedereativa(CatEntidadFederativa entidadFedereativa) {
		this.entidadFedereativa = entidadFedereativa;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Consultorio [idConsultorio=" + idConsultorio + ", nombre="
				+ nombre + ", horario=" + horario + ", calle=" + calle
				+ ", numeroExterior=" + numeroExterior + ", numeroInterior="
				+ numeroInterior + ", colonia=" + colonia + ", delegMuni="
				+ delegMuni + ", cp=" + cp + ", entidadFedereativa="
				+ entidadFedereativa + ", pais=" + pais + ", telefono="
				+ telefono + ", telefono2=" + telefono2 + ", fax=" + fax
				+ ", doctor=" + doctor + "]";
	}
}