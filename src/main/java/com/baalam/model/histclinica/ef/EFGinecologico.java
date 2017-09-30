package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFGinecologico
 *
 */
@Entity
@Table( name = "consulta_ef_ginecologico",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFGinecologico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "mamas")
	private String mamas;
	
	@Size(min = 0, max = 500)
	@Column(name = "mamasObservaciones")
	private String mamasObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "axila")
	private String axila;
	
	@Size(min = 0, max = 500)
	@Column(name = "axilaObservaciones")
	private String axilaObservaciones;
   
	@Size(min = 0, max = 7)
	@Column(name = "espacioSupraclav")
	private String espacioSupraclav;
	
	@Size(min = 0, max = 500)
	@Column(name = "ecObservaciones")
	private String ecObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "genitalesExternos")
	private String genitalesExternos;
	
	@Size(min = 0, max = 500)
	@Column(name = "geObservaciones")
	private String geObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "meatoUretral")
	private String meatoUretral;
	
	@Size(min = 0, max = 500)
	@Column(name = "muObservaciones")
	private String muObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "uretra")
	private String uretra;
	
	@Size(min = 0, max = 500)
	@Column(name = "uretraObservaciones")
	private String uretraObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "vejiga")
	private String vejiga;
	
	@Size(min = 0, max = 500)
	@Column(name = "vejigaObservaciones")
	private String vejigaObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "vagina")
	private String vagina;
	
	@Size(min = 0, max = 7)
	@Column(name = "soportePelvico")
	private String soportePelvico;
	
	@Column(name = "perineEficiente", columnDefinition="BIT(1)")
	private Boolean perineEficiente;
	
	@Column(name = "insuficienciaPerI", columnDefinition="BIT(1)")
	private Boolean insuficienciaPerI;
	
	@Column(name = "insuficienciaPerII", columnDefinition="BIT(1)")
	private Boolean insuficienciaPerII;
	
	@Column(name = "insuficienciaPerIII", columnDefinition="BIT(1)")
	private Boolean insuficienciaPerIII;
	
	@Size(min = 0, max = 500)
	@Column(name = "vaginaObservaciones")
	private String vaginaObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "cervix")
	private String cervix;
	
	@Size(min = 0, max = 500)
	@Column(name = "cervixObservaciones")
	private String cervixObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "colposcopia")
	private String colposcopia;
	
	@Column(name = "colpsSatisfactoria", columnDefinition="BIT(1)")
	private Boolean colpsSatisfactoria;
	
	@Size(min = 0, max = 500)
	@Column(name = "colpsObservaciones")
	private String colpsObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "uteroSensibilidad")
	private String uteroSensibilidad;
	
	@Size(min = 0, max = 7)
	@Column(name = "uteroSituacion")
	private String uteroSituacion;
	
	@Size(min = 0, max = 7)
	@Column(name = "uteroTamano")
	private String uteroTamano;
	
	@Size(min = 0, max = 7)
	@Column(name = "uteroSuperficie")
	private String uteroSuperficie;
	
	@Size(min = 0, max = 7)
	@Column(name = "uteroConsistencia")
	private String uteroConsistencia;
	
	@Size(min = 0, max = 7)
	@Column(name = "uteroMovilidad")
	private String uteroMovilidad;
	
	@Size(min = 0, max = 500)
	@Column(name = "uteroObservaciones")
	private String uteroObservaciones;
	
	@Size(min = 0, max = 12)
	@Column(name = "anexos")
	private String anexos;
	
	@Size(min = 0, max = 7)
	@Column(name = "sensibilidad")
	private String sensibilidad;
	
	@Size(min = 0, max = 7)
	@Column(name = "masas")
	private String masas;
	
	@Size(min = 0, max = 500)
	@Column(name = "anexosObservaciones")
	private String anexosObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "parametriosSensibilidad")
	private String parametriosSensibilidad;
	
	@Size(min = 0, max = 7)
	@Column(name = "parametriosConsistencia")
	private String parametriosConsistencia;
	
	@Size(min = 0, max = 7)
	@Column(name = "parametriosMasas")
	private String parametriosMasas;
	
	@Size(min = 0, max = 500)
	@Column(name = "parametriosObservaciones")
	private String parametriosObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "perine")
	private String perine;
	
	@Size(min = 0, max = 500)
	@Column(name = "perineObservaciones")
	private String perineObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "ano")
	private String ano;
	
	@Size(min = 0, max = 500)
	@Column(name = "anoObservaciones")
	private String anoObservaciones;
	
	@Size(min = 0, max = 7)
	@Column(name = "recto")
	private String recto;
	
	@Size(min = 0, max = 500)
	@Column(name = "rectoObservaciones")
	private String rectoObservaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getMamas() {
		return mamas;
	}

	public void setMamas(String mamas) {
		this.mamas = mamas;
	}

	public String getMamasObservaciones() {
		return mamasObservaciones;
	}

	public void setMamasObservaciones(String mamasObservaciones) {
		this.mamasObservaciones = mamasObservaciones;
	}

	public String getAxila() {
		return axila;
	}

	public void setAxila(String axila) {
		this.axila = axila;
	}

	public String getAxilaObservaciones() {
		return axilaObservaciones;
	}

	public void setAxilaObservaciones(String axilaObservaciones) {
		this.axilaObservaciones = axilaObservaciones;
	}

	public String getEspacioSupraclav() {
		return espacioSupraclav;
	}

	public void setEspacioSupraclav(String espacioSupraclav) {
		this.espacioSupraclav = espacioSupraclav;
	}

	public String getEcObservaciones() {
		return ecObservaciones;
	}

	public void setEcObservaciones(String ecObservaciones) {
		this.ecObservaciones = ecObservaciones;
	}

	public String getGenitalesExternos() {
		return genitalesExternos;
	}

	public void setGenitalesExternos(String genitalesExternos) {
		this.genitalesExternos = genitalesExternos;
	}

	public String getGeObservaciones() {
		return geObservaciones;
	}

	public void setGeObservaciones(String geObservaciones) {
		this.geObservaciones = geObservaciones;
	}

	public String getMeatoUretral() {
		return meatoUretral;
	}

	public void setMeatoUretral(String meatoUretral) {
		this.meatoUretral = meatoUretral;
	}

	public String getMuObservaciones() {
		return muObservaciones;
	}

	public void setMuObservaciones(String muObservaciones) {
		this.muObservaciones = muObservaciones;
	}

	public String getUretra() {
		return uretra;
	}

	public void setUretra(String uretra) {
		this.uretra = uretra;
	}

	public String getUretraObservaciones() {
		return uretraObservaciones;
	}

	public void setUretraObservaciones(String uretraObservaciones) {
		this.uretraObservaciones = uretraObservaciones;
	}

	public String getVejiga() {
		return vejiga;
	}

	public void setVejiga(String vejiga) {
		this.vejiga = vejiga;
	}

	public String getVejigaObservaciones() {
		return vejigaObservaciones;
	}

	public void setVejigaObservaciones(String vejigaObservaciones) {
		this.vejigaObservaciones = vejigaObservaciones;
	}

	public String getVagina() {
		return vagina;
	}

	public void setVagina(String vagina) {
		this.vagina = vagina;
	}

	public String getSoportePelvico() {
		return soportePelvico;
	}

	public void setSoportePelvico(String soportePelvico) {
		this.soportePelvico = soportePelvico;
	}

	public Boolean getPerineEficiente() {
		return perineEficiente;
	}

	public void setPerineEficiente(Boolean perineEficiente) {
		this.perineEficiente = perineEficiente;
	}

	public Boolean getInsuficienciaPerI() {
		return insuficienciaPerI;
	}

	public void setInsuficienciaPerI(Boolean insuficienciaPerI) {
		this.insuficienciaPerI = insuficienciaPerI;
	}

	public Boolean getInsuficienciaPerII() {
		return insuficienciaPerII;
	}

	public void setInsuficienciaPerII(Boolean insuficienciaPerII) {
		this.insuficienciaPerII = insuficienciaPerII;
	}

	public Boolean getInsuficienciaPerIII() {
		return insuficienciaPerIII;
	}

	public void setInsuficienciaPerIII(Boolean insuficienciaPerIII) {
		this.insuficienciaPerIII = insuficienciaPerIII;
	}

	public String getVaginaObservaciones() {
		return vaginaObservaciones;
	}

	public void setVaginaObservaciones(String vaginaObservaciones) {
		this.vaginaObservaciones = vaginaObservaciones;
	}

	public String getCervix() {
		return cervix;
	}

	public void setCervix(String cervix) {
		this.cervix = cervix;
	}

	public String getCervixObservaciones() {
		return cervixObservaciones;
	}

	public void setCervixObservaciones(String cervixObservaciones) {
		this.cervixObservaciones = cervixObservaciones;
	}

	public String getColposcopia() {
		return colposcopia;
	}

	public void setColposcopia(String colposcopia) {
		this.colposcopia = colposcopia;
	}

	public Boolean getColpsSatisfactoria() {
		return colpsSatisfactoria;
	}

	public void setColpsSatisfactoria(Boolean colpsSatisfactoria) {
		this.colpsSatisfactoria = colpsSatisfactoria;
	}

	public String getColpsObservaciones() {
		return colpsObservaciones;
	}

	public void setColpsObservaciones(String colpsObservaciones) {
		this.colpsObservaciones = colpsObservaciones;
	}

	public String getUteroSensibilidad() {
		return uteroSensibilidad;
	}

	public void setUteroSensibilidad(String uteroSensibilidad) {
		this.uteroSensibilidad = uteroSensibilidad;
	}

	public String getUteroSituacion() {
		return uteroSituacion;
	}

	public void setUteroSituacion(String uteroSituacion) {
		this.uteroSituacion = uteroSituacion;
	}

	public String getUteroTamano() {
		return uteroTamano;
	}

	public void setUteroTamano(String uteroTamano) {
		this.uteroTamano = uteroTamano;
	}

	public String getUteroSuperficie() {
		return uteroSuperficie;
	}

	public void setUteroSuperficie(String uteroSuperficie) {
		this.uteroSuperficie = uteroSuperficie;
	}

	public String getUteroConsistencia() {
		return uteroConsistencia;
	}

	public void setUteroConsistencia(String uteroConsistencia) {
		this.uteroConsistencia = uteroConsistencia;
	}

	public String getUteroMovilidad() {
		return uteroMovilidad;
	}

	public void setUteroMovilidad(String uteroMovilidad) {
		this.uteroMovilidad = uteroMovilidad;
	}

	public String getUteroObservaciones() {
		return uteroObservaciones;
	}

	public void setUteroObservaciones(String uteroObservaciones) {
		this.uteroObservaciones = uteroObservaciones;
	}

	public String getAnexos() {
		return anexos;
	}

	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}

	public String getSensibilidad() {
		return sensibilidad;
	}

	public void setSensibilidad(String sensibilidad) {
		this.sensibilidad = sensibilidad;
	}

	public String getMasas() {
		return masas;
	}

	public void setMasas(String masas) {
		this.masas = masas;
	}

	public String getAnexosObservaciones() {
		return anexosObservaciones;
	}

	public void setAnexosObservaciones(String anexosObservaciones) {
		this.anexosObservaciones = anexosObservaciones;
	}

	public String getParametriosSensibilidad() {
		return parametriosSensibilidad;
	}

	public void setParametriosSensibilidad(String parametriosSensibilidad) {
		this.parametriosSensibilidad = parametriosSensibilidad;
	}

	public String getParametriosConsistencia() {
		return parametriosConsistencia;
	}

	public void setParametriosConsistencia(String parametriosConsistencia) {
		this.parametriosConsistencia = parametriosConsistencia;
	}

	public String getParametriosMasas() {
		return parametriosMasas;
	}

	public void setParametriosMasas(String parametriosMasas) {
		this.parametriosMasas = parametriosMasas;
	}

	public String getParametriosObservaciones() {
		return parametriosObservaciones;
	}

	public void setParametriosObservaciones(String parametriosObservaciones) {
		this.parametriosObservaciones = parametriosObservaciones;
	}

	public String getPerine() {
		return perine;
	}

	public void setPerine(String perine) {
		this.perine = perine;
	}

	public String getPerineObservaciones() {
		return perineObservaciones;
	}

	public void setPerineObservaciones(String perineObservaciones) {
		this.perineObservaciones = perineObservaciones;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAnoObservaciones() {
		return anoObservaciones;
	}

	public void setAnoObservaciones(String anoObservaciones) {
		this.anoObservaciones = anoObservaciones;
	}

	public String getRecto() {
		return recto;
	}

	public void setRecto(String recto) {
		this.recto = recto;
	}

	public String getRectoObservaciones() {
		return rectoObservaciones;
	}

	public void setRectoObservaciones(String rectoObservaciones) {
		this.rectoObservaciones = rectoObservaciones;
	}
}