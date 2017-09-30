package com.baalam.model.histclinica.pa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "consulta_pa_medicamento")
public class PAMedicamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idPAMedicamento")
	private Long idPAMedicamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual idConsulta;
	
	@Column(name = "medicamento")
	@Size(min = 0, max = 100)
	private String medicamento;
	
	@Column(name = "dosis")
	@Size(min = 0, max = 100)
	private String dosis;
	
	@Column(name = "via")
	@Size(min = 0, max = 80)
	private String via;
	
	@Column(name = "frecuencia")
	@Size(min = 0, max = 100)
	private String frecuencia;
	
	@Column(name = "duracion")
	@Size(min = 0, max = 100)
	private String duracion;

	/**
	 * @return the idPAMedicamento
	 */
	public Long getIdPAMedicamento() {
		return idPAMedicamento;
	}

	/**
	 * @param idPAMedicamento the idPAMedicamento to set
	 */
	public void setIdPAMedicamento(Long idPAMedicamento) {
		this.idPAMedicamento = idPAMedicamento;
	}

	/**
	 * @return the idConsulta
	 */
	public PadecimientoActual getIdConsulta() {
		return idConsulta;
	}

	/**
	 * @param idConsulta the idConsulta to set
	 */
	public void setIdConsulta(PadecimientoActual idConsulta) {
		this.idConsulta = idConsulta;
	}

	/**
	 * @return the medicamento
	 */
	public String getMedicamento() {
		return medicamento;
	}

	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	/**
	 * @return the dosis
	 */
	public String getDosis() {
		return dosis;
	}

	/**
	 * @param dosis the dosis to set
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	/**
	 * @return the via
	 */
	public String getVia() {
		return via;
	}

	/**
	 * @param via the via to set
	 */
	public void setVia(String via) {
		this.via = via;
	}

	/**
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		return "PAMedicamento [idPAMedicamento=" + idPAMedicamento
				+ ", idConsulta=" + idConsulta + ", medicamento=" + medicamento
				+ ", dosis=" + dosis + ", via=" + via + ", frecuencia="
				+ frecuencia + ", duracion=" + duracion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dosis == null) ? 0 : dosis.hashCode());
		result = prime * result
				+ ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result
				+ ((frecuencia == null) ? 0 : frecuencia.hashCode());
		result = prime * result
				+ ((idConsulta == null) ? 0 : idConsulta.hashCode());
		result = prime * result
				+ ((idPAMedicamento == null) ? 0 : idPAMedicamento.hashCode());
		result = prime * result
				+ ((medicamento == null) ? 0 : medicamento.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PAMedicamento other = (PAMedicamento) obj;
		if (dosis == null) {
			if (other.dosis != null)
				return false;
		} else if (!dosis.equals(other.dosis))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (frecuencia == null) {
			if (other.frecuencia != null)
				return false;
		} else if (!frecuencia.equals(other.frecuencia))
			return false;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		if (idPAMedicamento == null) {
			if (other.idPAMedicamento != null)
				return false;
		} else if (!idPAMedicamento.equals(other.idPAMedicamento))
			return false;
		if (medicamento == null) {
			if (other.medicamento != null)
				return false;
		} else if (!medicamento.equals(other.medicamento))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}
	
}