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

@Entity
@Table(name = "control_embarazo_laboratorio")
public class CeLaboratorio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCELaboratorio")
	private Long idCELaboratorio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idControlEmbarazo")
	private ControlEmbarazo controlEmbarazo;
	
	@NotNull
	@Column(name = "fechaLaboratorio")
	private Date fechaLaboratorio;
	
	@Column(name = "bh")
	private Integer bh;
	
	@Column(name = "ggpc")
	private Integer ggpc;
	
	@Column(name = "creau")
	private Integer creau;
	
	@Column(name = "tp")
	private Integer tp;
	
	@Column(name = "ttp")
	private Integer ttp;
	
	@Column(name = "vdrl")
	private Integer vdrl;
	
	@Column(name = "ego")
	private Integer ego;
	
	@Column(name = "uroc")
	private Integer uroc;
	
	@Column(name = "culVag")
	private Integer culVag;
	
	@Column(name = "vih")
	private Integer vih;
	
	@Column(name = "otros")
	@Size(min = 0, max = 500)
	private String otros;
	
	public Long getIdCELaboratorio() {
		return idCELaboratorio;
	}

	public void setIdCELaboratorio(Long idCELaboratorio) {
		this.idCELaboratorio = idCELaboratorio;
	}

	public ControlEmbarazo getControlEmbarazo() {
		return controlEmbarazo;
	}

	public void setControlEmbarazo(ControlEmbarazo controlEmbarazo) {
		this.controlEmbarazo = controlEmbarazo;
	}

	public Date getFechaLaboratorio() {
		return fechaLaboratorio;
	}

	public void setFechaLaboratorio(Date fechaLaboratorio) {
		this.fechaLaboratorio = fechaLaboratorio;
	}

	public Integer getBh() {
		return bh;
	}

	public void setBh(Integer bh) {
		this.bh = bh;
	}

	public Integer getGgpc() {
		return ggpc;
	}

	public void setGgpc(Integer ggpc) {
		this.ggpc = ggpc;
	}

	public Integer getCreau() {
		return creau;
	}

	public void setCreau(Integer creau) {
		this.creau = creau;
	}

	public Integer getTp() {
		return tp;
	}

	public void setTp(Integer tp) {
		this.tp = tp;
	}

	public Integer getTtp() {
		return ttp;
	}

	public void setTtp(Integer ttp) {
		this.ttp = ttp;
	}

	public Integer getVdrl() {
		return vdrl;
	}

	public void setVdrl(Integer vdrl) {
		this.vdrl = vdrl;
	}

	public Integer getEgo() {
		return ego;
	}

	public void setEgo(Integer ego) {
		this.ego = ego;
	}

	public Integer getUroc() {
		return uroc;
	}

	public void setUroc(Integer uroc) {
		this.uroc = uroc;
	}

	public Integer getCulVag() {
		return culVag;
	}

	public void setCulVag(Integer culVag) {
		this.culVag = culVag;
	}

	public Integer getVih() {
		return vih;
	}

	public void setVih(Integer vih) {
		this.vih = vih;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "CeLaboratorio [idCELaboratorio=" + idCELaboratorio
				+ ", controlEmbarazo=" + controlEmbarazo
				+ ", fechaLaboratorio=" + fechaLaboratorio + ", bh=" + bh
				+ ", ggpc=" + ggpc + ", creau=" + creau + ", tp=" + tp
				+ ", ttp=" + ttp + ", vdrl=" + vdrl + ", ego=" + ego
				+ ", uroc=" + uroc + ", culVag=" + culVag + ", vih=" + vih
				+ ", otros=" + otros + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bh == null) ? 0 : bh.hashCode());
		result = prime * result
				+ ((controlEmbarazo == null) ? 0 : controlEmbarazo.hashCode());
		result = prime * result + ((creau == null) ? 0 : creau.hashCode());
		result = prime * result + ((culVag == null) ? 0 : culVag.hashCode());
		result = prime * result + ((ego == null) ? 0 : ego.hashCode());
		result = prime
				* result
				+ ((fechaLaboratorio == null) ? 0 : fechaLaboratorio.hashCode());
		result = prime * result + ((ggpc == null) ? 0 : ggpc.hashCode());
		result = prime * result
				+ ((idCELaboratorio == null) ? 0 : idCELaboratorio.hashCode());
		result = prime * result + ((otros == null) ? 0 : otros.hashCode());
		result = prime * result + ((tp == null) ? 0 : tp.hashCode());
		result = prime * result + ((ttp == null) ? 0 : ttp.hashCode());
		result = prime * result + ((uroc == null) ? 0 : uroc.hashCode());
		result = prime * result + ((vdrl == null) ? 0 : vdrl.hashCode());
		result = prime * result + ((vih == null) ? 0 : vih.hashCode());
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
		CeLaboratorio other = (CeLaboratorio) obj;
		if (bh == null) {
			if (other.bh != null)
				return false;
		} else if (!bh.equals(other.bh))
			return false;
		if (controlEmbarazo == null) {
			if (other.controlEmbarazo != null)
				return false;
		} else if (!controlEmbarazo.equals(other.controlEmbarazo))
			return false;
		if (creau == null) {
			if (other.creau != null)
				return false;
		} else if (!creau.equals(other.creau))
			return false;
		if (culVag == null) {
			if (other.culVag != null)
				return false;
		} else if (!culVag.equals(other.culVag))
			return false;
		if (ego == null) {
			if (other.ego != null)
				return false;
		} else if (!ego.equals(other.ego))
			return false;
		if (fechaLaboratorio == null) {
			if (other.fechaLaboratorio != null)
				return false;
		} else if (!fechaLaboratorio.equals(other.fechaLaboratorio))
			return false;
		if (ggpc == null) {
			if (other.ggpc != null)
				return false;
		} else if (!ggpc.equals(other.ggpc))
			return false;
		if (idCELaboratorio == null) {
			if (other.idCELaboratorio != null)
				return false;
		} else if (!idCELaboratorio.equals(other.idCELaboratorio))
			return false;
		if (otros == null) {
			if (other.otros != null)
				return false;
		} else if (!otros.equals(other.otros))
			return false;
		if (tp == null) {
			if (other.tp != null)
				return false;
		} else if (!tp.equals(other.tp))
			return false;
		if (ttp == null) {
			if (other.ttp != null)
				return false;
		} else if (!ttp.equals(other.ttp))
			return false;
		if (uroc == null) {
			if (other.uroc != null)
				return false;
		} else if (!uroc.equals(other.uroc))
			return false;
		if (vdrl == null) {
			if (other.vdrl != null)
				return false;
		} else if (!vdrl.equals(other.vdrl))
			return false;
		if (vih == null) {
			if (other.vih != null)
				return false;
		} else if (!vih.equals(other.vih))
			return false;
		return true;
	}	
}
