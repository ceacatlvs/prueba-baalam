package com.baalam.model.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name="rol",
		uniqueConstraints = @UniqueConstraint(columnNames = "idRol"))
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idRol")
	private Long idRol;
	
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "fid", columnDefinition="BIT(1)")
	private Boolean fid;
	
	@NotNull
	@Column(name = "antecedentes", columnDefinition="BIT(1)")
	private Boolean antecedentes;
	
	@NotNull
	@Column(name = "padecimientoActual", columnDefinition="BIT(1)")
	private Boolean padecimientoActual;
	
	@NotNull
	@Column(name = "iays", columnDefinition="BIT(1)")
	private Boolean iays;
	
	@NotNull
	@Column(name = "exploracionFisica", columnDefinition="BIT(1)")
	private Boolean exploracionFisica;
	
	@NotNull
	@Column(name = "estudiosPrevios", columnDefinition="BIT(1)")
	private Boolean estudiosPrevios;
	
	@NotNull
	@Column(name = "impresionDiagnostica", columnDefinition="BIT(1)")
	private Boolean impresionDiagnostica;
	
	@NotNull
	@Column(name = "auxiliaresDiagnostico", columnDefinition="BIT(1)")
	private Boolean auxiliaresDiagnostico;
	
	@NotNull
	@Column(name = "tratamiento", columnDefinition="BIT(1)")
	private Boolean tratamiento;
	
	@NotNull
	@Column(name = "signosVitales", columnDefinition="BIT(1)")
	private Boolean signosVitales;
	
	@NotNull
	@Column(name = "evolucionCuadroClinico", columnDefinition="BIT(1)")
	private Boolean evolucionCuadroClinico;
	
	@NotNull
	@Column(name = "controlEmbarazo", columnDefinition="BIT(1)")
	private Boolean controlEmbarazo;
	
	@NotNull
	@Column(name = "finEmbarazo", columnDefinition="BIT(1)")
	private Boolean finEmbarazo;
	
	@NotNull
	@Column(name = "controlPagos", columnDefinition="BIT(1)")
	private Boolean controlPagos;
	
	@NotNull
	@Column(name = "agenda", columnDefinition="BIT(1)")
	private Boolean agenda;
	
	@NotNull
	@Column(name = "datosPersonales", columnDefinition="BIT(1)")
	private Boolean datosPersonales;

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getFid() {
		return fid;
	}

	public void setFid(Boolean fid) {
		this.fid = fid;
	}

	public Boolean getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(Boolean antecedentes) {
		this.antecedentes = antecedentes;
	}

	public Boolean getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(Boolean padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getIays() {
		return iays;
	}

	public void setIays(Boolean iays) {
		this.iays = iays;
	}

	public Boolean getExploracionFisica() {
		return exploracionFisica;
	}

	public void setExploracionFisica(Boolean exploracionFisica) {
		this.exploracionFisica = exploracionFisica;
	}

	public Boolean getEstudiosPrevios() {
		return estudiosPrevios;
	}

	public void setEstudiosPrevios(Boolean estudiosPrevios) {
		this.estudiosPrevios = estudiosPrevios;
	}

	public Boolean getImpresionDiagnostica() {
		return impresionDiagnostica;
	}

	public void setImpresionDiagnostica(Boolean impresionDiagnostica) {
		this.impresionDiagnostica = impresionDiagnostica;
	}

	public Boolean getAuxiliaresDiagnostico() {
		return auxiliaresDiagnostico;
	}

	public void setAuxiliaresDiagnostico(Boolean auxiliaresDiagnostico) {
		this.auxiliaresDiagnostico = auxiliaresDiagnostico;
	}

	public Boolean getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Boolean tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Boolean getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(Boolean signosVitales) {
		this.signosVitales = signosVitales;
	}

	public Boolean getEvolucionCuadroClinico() {
		return evolucionCuadroClinico;
	}

	public void setEvolucionCuadroClinico(Boolean evolucionCuadroClinico) {
		this.evolucionCuadroClinico = evolucionCuadroClinico;
	}

	public Boolean getControlEmbarazo() {
		return controlEmbarazo;
	}

	public void setControlEmbarazo(Boolean controlEmbarazo) {
		this.controlEmbarazo = controlEmbarazo;
	}

	public Boolean getFinEmbarazo() {
		return finEmbarazo;
	}

	public void setFinEmbarazo(Boolean finEmbarazo) {
		this.finEmbarazo = finEmbarazo;
	}

	public Boolean getControlPagos() {
		return controlPagos;
	}

	public void setControlPagos(Boolean controlPagos) {
		this.controlPagos = controlPagos;
	}

	public Boolean getAgenda() {
		return agenda;
	}

	public void setAgenda(Boolean agenda) {
		this.agenda = agenda;
	}

	public Boolean getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Boolean datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", descripcion=" + descripcion
				+ ", fid=" + fid + ", antecedentes=" + antecedentes
				+ ", padecimientoActual=" + padecimientoActual + ", iays="
				+ iays + ", exploracionFisica=" + exploracionFisica
				+ ", estudiosPrevios=" + estudiosPrevios
				+ ", impresionDiagnostica=" + impresionDiagnostica
				+ ", auxiliaresDiagnostico=" + auxiliaresDiagnostico
				+ ", tratamiento=" + tratamiento + ", signosVitales="
				+ signosVitales + ", evolucionCuadroClinico="
				+ evolucionCuadroClinico + ", controlEmbarazo="
				+ controlEmbarazo + ", finEmbarazo=" + finEmbarazo
				+ ", controlPagos=" + controlPagos + ", agenda=" + agenda
				+ ", datosPersonales=" + datosPersonales + "]";
	}
}