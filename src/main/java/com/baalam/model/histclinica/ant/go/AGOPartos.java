package com.baalam.model.histclinica.ant.go;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import com.baalam.model.controlEmbarazo.CeFinEmbarazo;
import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "ago_partos",
		uniqueConstraints = @UniqueConstraint(columnNames = "idParto"))
public class AGOPartos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idParto")
	private Long idParto;	
	
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "nombre")
	@Size(min = 0, max = 200)
	private String nombre;
	
	@Column(name = "pesoKg")
	private Double pesoKg;
	
	@Column(name = "sexo")
	@Size(min = 0, max = 10)
	private String sexo;
	
	@Column(name = "semanasEmbarazo")
	private Integer semanasEmbarazo;
	
	@Column(name = "tipoNacimiento")
	@Size(min = 0, max = 10)
	private String tipoNacimiento;
	
	@Column(name = "indicacionCesarea")
	@Size(min = 0, max = 500)
	private String indicacionCesarea;
	
	@Column(name = "diabetes", columnDefinition="BIT(1)")
	private Boolean diabetes;
	
	@Column(name = "hipertension", columnDefinition="BIT(1)")
	private Boolean hipertension;
	
	@Column(name = "preclamsia", columnDefinition="BIT(1)")
	private Boolean preclamsia;
	
	@Column(name = "depresion", columnDefinition="BIT(1)")
	private Boolean depresion;
	
	@Column(name = "otra")
	@Size(min = 0, max = 500)
	private String otra;
	
	@Column(name = "observaciones")
	@Size(min = 0, max = 500)
	private String observaciones;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="idCEFin")
	private CeFinEmbarazo finEmbarazo;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getSemanasEmbarazo() {
		return semanasEmbarazo;
	}

	public void setSemanasEmbarazo(Integer semanasEmbarazo) {
		this.semanasEmbarazo = semanasEmbarazo;
	}

	public String getTipoNacimiento() {
		return tipoNacimiento;
	}

	public void setTipoNacimiento(String tipoNacimiento) {
		this.tipoNacimiento = tipoNacimiento;
	}

	public String getIndicacionCesarea() {
		return indicacionCesarea;
	}

	public void setIndicacionCesarea(String indicacionCesarea) {
		this.indicacionCesarea = indicacionCesarea;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getHipertension() {
		return hipertension;
	}

	public void setHipertension(Boolean hipertension) {
		this.hipertension = hipertension;
	}

	public Boolean getPreclamsia() {
		return preclamsia;
	}

	public void setPreclamsia(Boolean preclamsia) {
		this.preclamsia = preclamsia;
	}

	public Boolean getDepresion() {
		return depresion;
	}

	public void setDepresion(Boolean depresion) {
		this.depresion = depresion;
	}

	public String getOtra() {
		return otra;
	}

	public void setOtra(String otra) {
		this.otra = otra;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getIdParto() {
		return idParto;
	}

	public void setIdParto(Long idParto) {
		this.idParto = idParto;
	}
	
	public CeFinEmbarazo getFinEmbarazo() {
		return finEmbarazo;
	}

	public void setFinEmbarazo(CeFinEmbarazo finEmbarazo) {
		this.finEmbarazo = finEmbarazo;
	}

}