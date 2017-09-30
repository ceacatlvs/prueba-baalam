package com.baalam.model.controlEmbarazo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.ant.go.AGOPartos;

/**
 * Entity implementation class for Entity: CeFinEmbarazo
 */
@Entity
@Table(name = "control_embarazo_fin")
public class CeFinEmbarazo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCEFin")
	private Long idCEFin;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idControlEmbarazo")
	private ControlEmbarazo controlEmbarazo;
	
	@NotNull
	@Column(name = "fechaTermino")
	private Date fechaTermino;

	@Column(name = "semanas")
	private Integer semanas;
	
	@Column(name = "termino")
	@Size(min = 0, max = 3)
	private String termino;

	@Column(name = "llegoATermino",
			columnDefinition="BIT(1)")
	private Boolean llegoATermino;
	
	@OneToMany(mappedBy = "finEmbarazo")
	private Set<AGOPartos> partos;
	
	@Column(name = "tipoAborto")
	@Size(min = 0, max = 10)
	private String tipoAborto;

	@Column(name = "diferido",
			columnDefinition="BIT(1)")
	private Boolean diferido;
	
	@Column(name = "completo")
	@Size(min = 0, max = 10)
	private String completo;

	@Column(name = "lui",
			columnDefinition="BIT(1)")
	private Boolean lui;
	
	public Long getIdCEFin() {
		return idCEFin;
	}

	public void setIdCEFin(Long idCEFin) {
		this.idCEFin = idCEFin;
	}

	public ControlEmbarazo getControlEmbarazo() {
		return controlEmbarazo;
	}

	public void setControlEmbarazo(ControlEmbarazo controlEmbarazo) {
		this.controlEmbarazo = controlEmbarazo;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}
	
	public String getTipoAborto() {
		return tipoAborto;
	}

	public void setTipoAborto(String tipoAborto) {
		this.tipoAborto = tipoAborto;
	}

	public String getCompleto() {
		return completo;
	}

	public void setCompleto(String completo) {
		this.completo = completo;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Integer getSemanas() {
		return semanas;
	}

	public void setSemanas(Integer semanas) {
		this.semanas = semanas;
	}

	public Boolean getLlegoATermino() {
		return llegoATermino;
	}

	public void setLlegoATermino(Boolean llegoATermino) {
		this.llegoATermino = llegoATermino;
	}

	public Set<AGOPartos> getPartos() {
		return partos;
	}

	public void setPartos(Set<AGOPartos> partos) {
		this.partos = partos;
	}

	public Boolean getDiferido() {
		return diferido;
	}

	public void setDiferido(Boolean diferido) {
		this.diferido = diferido;
	}

	public Boolean getLui() {
		return lui;
	}

	public void setLui(Boolean lui) {
		this.lui = lui;
	}
}