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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.baalam.model.catalogo.CatEdema;
import com.baalam.model.catalogo.CatEdemaX;
import com.baalam.model.catalogo.CatMsFs;
import com.baalam.model.catalogo.CatPres;

@Entity
@Table(name = "control_embarazo_seguimiento")
public class CeSeguimiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCESeguimiento")
	private Long idCESeguimiento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idControlEmbarazo")
	private ControlEmbarazo controlEmbarazo;
	
	@NotNull
	@Column(name = "fechaConsulta")
	private Date fechaConsulta;
	
	@Column(name = "eg")
	private Integer eg;
	
	@Column(name = "peso")
	private Integer peso;
	
	@Column(name = "ta")
	private Integer ta;
	
	@Column(name = "dpf")
	private Integer dpf;
	
	@Column(name = "lcf")
	private Integer lcf;
	
	@OneToOne
	@JoinColumn(name="idMsFs")
	private CatMsFs msfs;
	
	@OneToOne
	@JoinColumn(name="idPres")
	private CatPres pres;
	
	@Column(name = "pest")
	private Integer pest;
	
	@OneToOne
	@JoinColumn(name="edema")
	private CatEdema edema;
	
	@OneToOne
	@JoinColumn(name="edemaX")
	private CatEdemaX edemaX;

	public Long getIdCESeguimiento() {
		return idCESeguimiento;
	}

	public void setIdCESeguimiento(Long idCESeguimiento) {
		this.idCESeguimiento = idCESeguimiento;
	}

	public ControlEmbarazo getControlEmbarazo() {
		return controlEmbarazo;
	}

	public void setControlEmbarazo(ControlEmbarazo controlEmbarazo) {
		this.controlEmbarazo = controlEmbarazo;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public Integer getEg() {
		return eg;
	}

	public void setEg(Integer eg) {
		this.eg = eg;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getTa() {
		return ta;
	}

	public void setTa(Integer ta) {
		this.ta = ta;
	}

	public Integer getDpf() {
		return dpf;
	}

	public void setDpf(Integer dpf) {
		this.dpf = dpf;
	}

	public Integer getLcf() {
		return lcf;
	}

	public void setLcf(Integer lcf) {
		this.lcf = lcf;
	}

	public CatMsFs getMsfs() {
		return msfs;
	}

	public void setMsfs(CatMsFs msfs) {
		this.msfs = msfs;
	}

	public CatPres getPres() {
		return pres;
	}

	public void setPres(CatPres pres) {
		this.pres = pres;
	}

	public Integer getPest() {
		return pest;
	}

	public void setPest(Integer pest) {
		this.pest = pest;
	}

	public CatEdema getEdema() {
		return edema;
	}

	public void setEdema(CatEdema edema) {
		this.edema = edema;
	}

	public CatEdemaX getEdemaX() {
		return edemaX;
	}

	public void setEdemaX(CatEdemaX edemaX) {
		this.edemaX = edemaX;
	}

	@Override
	public String toString() {
		return "CESeguimiento [idCESeguimiento=" + idCESeguimiento
				+ ", controlEmbarazo=" + controlEmbarazo
				+ ", fechaConsulta=" + fechaConsulta + ", eg=" + eg + ", peso="
				+ peso + ", ta=" + ta + ", dpf=" + dpf + ", lcf=" + lcf
				+ ", msfs=" + msfs + ", pres=" + pres + ", pest=" + pest
				+ ", edema=" + edema + ", edemaX=" + edemaX + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dpf == null) ? 0 : dpf.hashCode());
		result = prime * result + ((edema == null) ? 0 : edema.hashCode());
		result = prime * result + ((edemaX == null) ? 0 : edemaX.hashCode());
		result = prime * result + ((eg == null) ? 0 : eg.hashCode());
		result = prime * result
				+ ((fechaConsulta == null) ? 0 : fechaConsulta.hashCode());
		result = prime * result
				+ ((idCESeguimiento == null) ? 0 : idCESeguimiento.hashCode());
		result = prime
				* result
				+ ((controlEmbarazo == null) ? 0 : controlEmbarazo
						.hashCode());
		result = prime * result + ((lcf == null) ? 0 : lcf.hashCode());
		result = prime * result + ((msfs == null) ? 0 : msfs.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((pest == null) ? 0 : pest.hashCode());
		result = prime * result + ((pres == null) ? 0 : pres.hashCode());
		result = prime * result + ((ta == null) ? 0 : ta.hashCode());
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
		CeSeguimiento other = (CeSeguimiento) obj;
		if (dpf == null) {
			if (other.dpf != null)
				return false;
		} else if (!dpf.equals(other.dpf))
			return false;
		if (edema == null) {
			if (other.edema != null)
				return false;
		} else if (!edema.equals(other.edema))
			return false;
		if (edemaX == null) {
			if (other.edemaX != null)
				return false;
		} else if (!edemaX.equals(other.edemaX))
			return false;
		if (eg == null) {
			if (other.eg != null)
				return false;
		} else if (!eg.equals(other.eg))
			return false;
		if (fechaConsulta == null) {
			if (other.fechaConsulta != null)
				return false;
		} else if (!fechaConsulta.equals(other.fechaConsulta))
			return false;
		if (idCESeguimiento == null) {
			if (other.idCESeguimiento != null)
				return false;
		} else if (!idCESeguimiento.equals(other.idCESeguimiento))
			return false;
		if (controlEmbarazo == null) {
			if (other.controlEmbarazo != null)
				return false;
		} else if (!controlEmbarazo.equals(other.controlEmbarazo))
			return false;
		if (lcf == null) {
			if (other.lcf != null)
				return false;
		} else if (!lcf.equals(other.lcf))
			return false;
		if (msfs == null) {
			if (other.msfs != null)
				return false;
		} else if (!msfs.equals(other.msfs))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (pest == null) {
			if (other.pest != null)
				return false;
		} else if (!pest.equals(other.pest))
			return false;
		if (pres == null) {
			if (other.pres != null)
				return false;
		} else if (!pres.equals(other.pres))
			return false;
		if (ta == null) {
			if (other.ta != null)
				return false;
		} else if (!ta.equals(other.ta))
			return false;
		return true;
	}
	
}
