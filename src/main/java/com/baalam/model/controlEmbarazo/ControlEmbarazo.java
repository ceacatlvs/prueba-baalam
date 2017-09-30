package com.baalam.model.controlEmbarazo;

import java.io.Serializable;
import java.util.Date;

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

import com.baalam.model.histclinica.pa.PadecimientoActual;

@Entity
@Table(	name="control_embarazo_informacion")
public class ControlEmbarazo implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idControlEmbarazo")
	private Long idControlEmbarazo;
	
	/*@NotNull
	@ManyToOne
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;*/
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idConsulta")
	private PadecimientoActual consulta;
	
	@Column(name = "gs")
	@Size(min = 0, max = 15)
	private String gs;
	
	@Column(name = "gesta")
	@Size(min = 0, max = 15)
	private String gesta;
	
	@Column(name = "para")
	@Size(min = 0, max = 15)
	private String para;
	
	@Column(name = "ces")
	@Size(min = 0, max = 15)
	private String ces;
	
	@Column(name = "ab")
	@Size(min = 0, max = 15)
	private String ab;
	
	@NotNull
	@Column(name = "fum")
	private Date fum;
	
	@NotNull
	@Column(name = "fpp")
	private Date fpp;
	
	@Column(name = "embarazo")
	@Size(min = 0, max = 100)
	private String embarazo;
	
	@Column(name = "factorRiesgo")
	@Size(min = 0, max = 100)
	private String factorRiesgo;

	public Long getIdControlEmbarazo() {
		return idControlEmbarazo;
	}

	public void setIdControlEmbarazo(Long idControlEmbarazo) {
		this.idControlEmbarazo = idControlEmbarazo;
	}

	public PadecimientoActual getConsulta() {
		return consulta;
	}

	public void setConsulta(PadecimientoActual consulta) {
		this.consulta = consulta;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getGesta() {
		return gesta;
	}

	public void setGesta(String gesta) {
		this.gesta = gesta;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getCes() {
		return ces;
	}

	public void setCes(String ces) {
		this.ces = ces;
	}

	public String getAb() {
		return ab;
	}

	public void setAb(String ab) {
		this.ab = ab;
	}

	public Date getFum() {
		return fum;
	}

	public void setFum(Date fum) {
		this.fum = fum;
	}

	public Date getFpp() {
		return fpp;
	}

	public void setFpp(Date fpp) {
		this.fpp = fpp;
	}

	public String getEmbarazo() {
		return embarazo;
	}

	public void setEmbarazo(String embarazo) {
		this.embarazo = embarazo;
	}

	public String getFactorRiesgo() {
		return factorRiesgo;
	}

	public void setFactorRiesgo(String factorRiesgo) {
		this.factorRiesgo = factorRiesgo;
	}

	@Override
	public String toString() {
		return "ControlEmbarazo [idControlEmbarazo=" + idControlEmbarazo
				+ ", consulta=" + consulta + ", gs=" + gs + ", gesta=" + gesta
				+ ", para=" + para + ", ces=" + ces + ", ab=" + ab + ", fum="
				+ fum + ", fpp=" + fpp + ", embarazo=" + embarazo
				+ ", factorRiesgo=" + factorRiesgo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ab == null) ? 0 : ab.hashCode());
		result = prime * result + ((ces == null) ? 0 : ces.hashCode());
		result = prime * result
				+ ((embarazo == null) ? 0 : embarazo.hashCode());
		result = prime * result
				+ ((factorRiesgo == null) ? 0 : factorRiesgo.hashCode());
		result = prime * result + ((fpp == null) ? 0 : fpp.hashCode());
		result = prime * result + ((fum == null) ? 0 : fum.hashCode());
		result = prime * result + ((gesta == null) ? 0 : gesta.hashCode());
		result = prime * result + ((gs == null) ? 0 : gs.hashCode());
		result = prime
				* result
				+ ((idControlEmbarazo == null) ? 0 : idControlEmbarazo
						.hashCode());
		result = prime * result
				+ ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((para == null) ? 0 : para.hashCode());
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
		ControlEmbarazo other = (ControlEmbarazo) obj;
		if (ab == null) {
			if (other.ab != null)
				return false;
		} else if (!ab.equals(other.ab))
			return false;
		if (ces == null) {
			if (other.ces != null)
				return false;
		} else if (!ces.equals(other.ces))
			return false;
		if (embarazo == null) {
			if (other.embarazo != null)
				return false;
		} else if (!embarazo.equals(other.embarazo))
			return false;
		if (factorRiesgo == null) {
			if (other.factorRiesgo != null)
				return false;
		} else if (!factorRiesgo.equals(other.factorRiesgo))
			return false;
		if (fpp == null) {
			if (other.fpp != null)
				return false;
		} else if (!fpp.equals(other.fpp))
			return false;
		if (fum == null) {
			if (other.fum != null)
				return false;
		} else if (!fum.equals(other.fum))
			return false;
		if (gesta == null) {
			if (other.gesta != null)
				return false;
		} else if (!gesta.equals(other.gesta))
			return false;
		if (gs == null) {
			if (other.gs != null)
				return false;
		} else if (!gs.equals(other.gs))
			return false;
		if (idControlEmbarazo == null) {
			if (other.idControlEmbarazo != null)
				return false;
		} else if (!idControlEmbarazo.equals(other.idControlEmbarazo))
			return false;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (para == null) {
			if (other.para != null)
				return false;
		} else if (!para.equals(other.para))
			return false;
		return true;
	}
	
}
