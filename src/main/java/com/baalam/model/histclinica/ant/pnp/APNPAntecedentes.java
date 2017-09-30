package com.baalam.model.histclinica.ant.pnp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatEscolaridad;
import com.baalam.model.catalogo.CatEstadoCivil;
import com.baalam.model.catalogo.CatOrientacionSexual;
import com.baalam.model.catalogo.CatTabaquismo;
import com.baalam.model.paciente.Paciente;

@Entity
@Table( name = "apnp_antecedentes",
		uniqueConstraints = @UniqueConstraint(columnNames = "idPaciente"))
public class APNPAntecedentes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@Size(min = 0, max = 250)
	@Column(name = "lugarOrigen")
	private String lugarOrigen;
	
	@ManyToOne
	@JoinColumn(name="idCatTabaquismo", nullable = true)
	private CatTabaquismo idCatTabaquismo;
	
	@Column(name = "cigarrosDiarios")
	private Integer cigarrosDiarios;
	
	@Column(name = "cigarrosAnios")
	private Integer cigarrosAnios;
	
	@Column(name = "cigarrosAniosSinFumar")
	private Integer cigarrosAniosSinFumar;
	
	@NotNull
	@Column(name = "alcohol", columnDefinition="BIT(1)")
	private Boolean alcohol;
	
	@Size(min = 0, max = 30)
	@Column(name = "alcoholFrecuencia")
	private String alcoholFrecuencia;
	
	@Size(min = 0, max = 300)
	@Column(name = "alcoholCantidad")
	private String alcoholCantidad;
	
	@NotNull
	@Column(name = "drogasRecreativas", columnDefinition="BIT(1)")
	private Boolean drogasRecreativas;
	
	@Size(min = 0, max = 300)
	@Column(name = "drogaTipo")
	private String drogaTipo;
	
	@Size(min = 0, max = 30)
	@Column(name = "drogaFrecuencia")
	private String drogaFrecuencia;
	
	@NotNull
	@Column(name = "ejercicioRegular", columnDefinition="BIT(1)")
	private Boolean ejercicioRegular;
	
	@Size(min = 0, max = 200)
	@Column(name = "ejercicioTipo")
	private String ejercicioTipo;
	
	@Size(min = 0, max = 200)
	@Column(name = "ejercicioFrecuencia")
	private String ejercicioFrecuencia;
	
	/*@ManyToOne
	@JoinColumn(name="idCatDuracion", nullable=true)
	private CatDuracion idCatDuracion;*/
	
	@Size(min = 0, max = 200)
	@Column(name = "ejercicioDuracion")
	private String ejercicioDuracion;
	
	@NotNull
	@Column(name = "lacteosCalcio", columnDefinition="BIT(1)")
	private Boolean lacteosCalcio;
	
	@Size(min = 0, max = 50)
	@Column(name = "lacteosCalcioCantidad")
	private String lacteosCalcioCantidad;
	
	@Size(min = 0, max = 100)
	@Column(name = "lacteosCalcioFrecuencia")
	private String lacteosCalcioFrecuencia;
	
	@NotNull
	@Column(name = "cafeinaRefrescos", columnDefinition="BIT(1)")
	private Boolean cafeinaRefrescos;
	
	@Size(min = 0, max = 20)
	@Column(name = "cafeinaRefrescosCantidad")
	private String cafeinaRefrescosCantidad;
	
	@Size(min = 0, max = 100)
	@Column(name = "cafeinaRefrescosFrecuencia")
	private String cafeinaRefrescosFrecuencia;
	
	@Size(min = 0, max = 100)
	@Column(name = "cafeinaRefrescosTipo")
	private String cafeinaRefrescosTipo;
	
	@ManyToOne
	@JoinColumn(name="idCatOrientacionSexual", nullable = true)
	private CatOrientacionSexual idCatOrientacionSexual;
	
	@ManyToOne
	@JoinColumn(name="idCatEstadoCivil", nullable = true)
	private CatEstadoCivil idCatEstadoCivil;
	
	@Size(min = 0, max = 2)
	@Column(name = "vivenConPaciente")
	private String vivenConPaciente;
	
	@ManyToOne
	@JoinColumn(name="idCatEscolaridad", nullable = true)
	private CatEscolaridad idCatEscolaridad;
	
	@Size(min = 0, max = 250)
	@Column(name = "empleo")
	private String empleo;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public Paciente getIdPaciente() {
		return paciente;
	}

	public void setIdPaciente(Paciente idPaciente) {
		this.paciente = idPaciente;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public CatTabaquismo getIdCatTabaquismo() {
		return idCatTabaquismo;
	}

	public void setIdCatTabaquismo(CatTabaquismo idCatTabaquismo) {
		this.idCatTabaquismo = idCatTabaquismo;
	}

	public Integer getCigarrosDiarios() {
		return cigarrosDiarios;
	}

	public void setCigarrosDiarios(Integer cigarrosDiarios) {
		this.cigarrosDiarios = cigarrosDiarios;
	}

	public Integer getCigarrosAnios() {
		return cigarrosAnios;
	}

	public void setCigarrosAnios(Integer cigarrosAnios) {
		this.cigarrosAnios = cigarrosAnios;
	}

	public Integer getCigarrosAniosSinFumar() {
		return cigarrosAniosSinFumar;
	}

	public void setCigarrosAniosSinFumar(Integer cigarrosAniosSinFumar) {
		this.cigarrosAniosSinFumar = cigarrosAniosSinFumar;
	}

	public Boolean getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(Boolean alcohol) {
		this.alcohol = alcohol;
	}

	public String getAlcoholFrecuencia() {
		return alcoholFrecuencia;
	}

	public void setAlcoholFrecuencia(String alcoholFrecuencia) {
		this.alcoholFrecuencia = alcoholFrecuencia;
	}

	public Boolean getDrogasRecreativas() {
		return drogasRecreativas;
	}

	public void setDrogasRecreativas(Boolean drogasRecreativas) {
		this.drogasRecreativas = drogasRecreativas;
	}

	public String getDrogaTipo() {
		return drogaTipo;
	}

	public void setDrogaTipo(String drogaTipo) {
		this.drogaTipo = drogaTipo;
	}

	public String getDrogaFrecuencia() {
		return drogaFrecuencia;
	}

	public void setDrogaFrecuencia(String drogaFrecuencia) {
		this.drogaFrecuencia = drogaFrecuencia;
	}

	public Boolean getEjercicioRegular() {
		return ejercicioRegular;
	}

	public void setEjercicioRegular(Boolean ejercicioRegular) {
		this.ejercicioRegular = ejercicioRegular;
	}

	public String getEjercicioTipo() {
		return ejercicioTipo;
	}

	public void setEjercicioTipo(String ejercicioTipo) {
		this.ejercicioTipo = ejercicioTipo;
	}

	public String getEjercicioFrecuencia() {
		return ejercicioFrecuencia;
	}

	public void setEjercicioFrecuencia(String ejercicioFrecuencia) {
		this.ejercicioFrecuencia = ejercicioFrecuencia;
	}

	public String getEjercicioDuracion() {
		return ejercicioDuracion;
	}

	public void setEjercicioDuracion(String ejercicioDuracion) {
		this.ejercicioDuracion = ejercicioDuracion;
	}

	public Boolean getLacteosCalcio() {
		return lacteosCalcio;
	}

	public void setLacteosCalcio(Boolean lacteosCalcio) {
		this.lacteosCalcio = lacteosCalcio;
	}

	public String getLacteosCalcioCantidad() {
		return lacteosCalcioCantidad;
	}

	public void setLacteosCalcioCantidad(String lacteosCalcioCantidad) {
		this.lacteosCalcioCantidad = lacteosCalcioCantidad;
	}

	public String getLacteosCalcioFrecuencia() {
		return lacteosCalcioFrecuencia;
	}

	public void setLacteosCalcioFrecuencia(String lacteosCalcioFrecuencia) {
		this.lacteosCalcioFrecuencia = lacteosCalcioFrecuencia;
	}

	public Boolean getCafeinaRefrescos() {
		return cafeinaRefrescos;
	}

	public void setCafeinaRefrescos(Boolean cafeinaRefrescos) {
		this.cafeinaRefrescos = cafeinaRefrescos;
	}

	public String getCafeinaRefrescosCantidad() {
		return cafeinaRefrescosCantidad;
	}

	public void setCafeinaRefrescosCantidad(String cafeinaRefrescosCantidad) {
		this.cafeinaRefrescosCantidad = cafeinaRefrescosCantidad;
	}

	public String getCafeinaRefrescosFrecuencia() {
		return cafeinaRefrescosFrecuencia;
	}

	public void setCafeinaRefrescosFrecuencia(String cafeinaRefrescosFrecuencia) {
		this.cafeinaRefrescosFrecuencia = cafeinaRefrescosFrecuencia;
	}

	public String getCafeinaRefrescosTipo() {
		return cafeinaRefrescosTipo;
	}

	public void setCafeinaRefrescosTipo(String cafeinaRefrescosTipo) {
		this.cafeinaRefrescosTipo = cafeinaRefrescosTipo;
	}

	public CatOrientacionSexual getIdCatOrientacionSexual() {
		return idCatOrientacionSexual;
	}

	public void setIdCatOrientacionSexual(
			CatOrientacionSexual idCatOrientacionSexual) {
		this.idCatOrientacionSexual = idCatOrientacionSexual;
	}

	public CatEstadoCivil getIdCatEstadoCivil() {
		return idCatEstadoCivil;
	}

	public void setIdCatEstadoCivil(CatEstadoCivil idCatEstadoCivil) {
		this.idCatEstadoCivil = idCatEstadoCivil;
	}

	public String getVivenConPaciente() {
		return vivenConPaciente;
	}

	public void setVivenConPaciente(String vivenConPaciente) {
		this.vivenConPaciente = vivenConPaciente;
	}

	public CatEscolaridad getIdCatEscolaridad() {
		return idCatEscolaridad;
	}

	public void setIdCatEscolaridad(CatEscolaridad idCatEscolaridad) {
		this.idCatEscolaridad = idCatEscolaridad;
	}

	public String getEmpleo() {
		return empleo;
	}

	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	public String getAlcoholCantidad() {
		return alcoholCantidad;
	}

	public void setAlcoholCantidad(String alcoholCantidad) {
		this.alcoholCantidad = alcoholCantidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "APNPAntecedentes [paciente=" + paciente + ", lugarOrigen="
				+ lugarOrigen + ", idCatTabaquismo=" + idCatTabaquismo
				+ ", cigarrosDiarios=" + cigarrosDiarios + ", cigarrosAnios="
				+ cigarrosAnios + ", cigarrosAniosSinFumar="
				+ cigarrosAniosSinFumar + ", alcohol=" + alcohol
				+ ", alcoholFrecuencia=" + alcoholFrecuencia
				+ ", alcoholCantidad=" + alcoholCantidad
				+ ", drogasRecreativas=" + drogasRecreativas + ", drogaTipo="
				+ drogaTipo + ", drogaFrecuencia=" + drogaFrecuencia
				+ ", ejercicioRegular=" + ejercicioRegular + ", ejercicioTipo="
				+ ejercicioTipo + ", ejercicioFrecuencia="
				+ ejercicioFrecuencia + ", ejercicioDuracion=" + ejercicioDuracion
				+ ", lacteosCalcio=" + lacteosCalcio
				+ ", lacteosCalcioCantidad=" + lacteosCalcioCantidad
				+ ", lacteosCalcioFrecuencia=" + lacteosCalcioFrecuencia
				+ ", cafeinaRefrescos=" + cafeinaRefrescos
				+ ", cafeinaRefrescosCantidad=" + cafeinaRefrescosCantidad
				+ ", cafeinaRefrescosFrecuencia=" + cafeinaRefrescosFrecuencia
				+ ", cafeinaRefrescosTipo=" + cafeinaRefrescosTipo
				+ ", idCatOrientacionSexual=" + idCatOrientacionSexual
				+ ", idCatEstadoCivil=" + idCatEstadoCivil
				+ ", vivenConPaciente=" + vivenConPaciente
				+ ", idCatEscolaridad=" + idCatEscolaridad + ", empleo="
				+ empleo + ", observaciones=" + observaciones + "]";
	}
	
}
