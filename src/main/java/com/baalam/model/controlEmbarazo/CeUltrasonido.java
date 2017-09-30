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
import javax.validation.constraints.Size;

import com.baalam.model.catalogo.CatLA;
import com.baalam.model.catalogo.CatPlacenta;
import com.baalam.model.catalogo.CatSexo;

@Entity
@Table(name = "control_embarazo_ultrasonido")
public class CeUltrasonido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCEUltrasonido")
	private Long idCEUltrasonido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idControlEmbarazo")
	private ControlEmbarazo controlEmbarazo;
	
	@NotNull
	@Column(name = "fechaUltrasonido")
	private Date fechaUltrasonido;
	
	@Column(name = "crl")
	private Integer crl;
	
	@Column(name = "tn")
	private Integer tn;
	
	@Column(name = "dbp")
	private Integer dbp;
	
	@Column(name = "ca")
	private Integer ca;
	
	@Column(name = "lf")
	private Integer lf;
	
	@Column(name = "hum")
	private Integer hum;
	
	@Column(name = "eg")
	private Integer eg;
	
	@Column(name = "peso")
	private Integer peso;
	
	@OneToOne
	@JoinColumn(name="idPlacenta")
	private CatPlacenta idPlacenta;
	
	@OneToOne
	@JoinColumn(name="idLA")
	private CatLA idLA;
	
	@Column(name = "irumb")
	private Integer irumb;
	
	@Column(name = "irut")
	private Integer irut;
	
	@Column(name = "iracm")
	private Integer iracm;
	
	@OneToOne
	@JoinColumn(name="idsexo")
	private CatSexo idSexo;
	
	@Column(name = "otros")
	@Size(min = 0, max = 500)
	private String otros;
	
	public Long getIdCEUltrasonido() {
		return idCEUltrasonido;
	}

	public void setIdCEUltrasonido(Long idCEUltrasonido) {
		this.idCEUltrasonido = idCEUltrasonido;
	}

	public ControlEmbarazo getControlEmbarazo() {
		return controlEmbarazo;
	}

	public void setControlEmbarazo(ControlEmbarazo controlEmbarazo) {
		this.controlEmbarazo = controlEmbarazo;
	}

	public Date getFechaUltrasonido() {
		return fechaUltrasonido;
	}

	public void setFechaUltrasonido(Date fechaUltrasonido) {
		this.fechaUltrasonido = fechaUltrasonido;
	}

	public Integer getCrl() {
		return crl;
	}

	public void setCrl(Integer crl) {
		this.crl = crl;
	}

	public Integer getTn() {
		return tn;
	}

	public void setTn(Integer tn) {
		this.tn = tn;
	}

	public Integer getDbp() {
		return dbp;
	}

	public void setDbp(Integer dbp) {
		this.dbp = dbp;
	}

	public Integer getCa() {
		return ca;
	}

	public void setCa(Integer ca) {
		this.ca = ca;
	}

	public Integer getLf() {
		return lf;
	}

	public void setLf(Integer lf) {
		this.lf = lf;
	}

	public Integer getHum() {
		return hum;
	}

	public void setHum(Integer hum) {
		this.hum = hum;
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

	public CatPlacenta getIdPlacenta() {
		return idPlacenta;
	}

	public void setIdPlacenta(CatPlacenta idPlacenta) {
		this.idPlacenta = idPlacenta;
	}

	public CatLA getIdLA() {
		return idLA;
	}

	public void setIdLA(CatLA idLA) {
		this.idLA = idLA;
	}

	public Integer getIrumb() {
		return irumb;
	}

	public void setIrumb(Integer irumb) {
		this.irumb = irumb;
	}

	public Integer getIrut() {
		return irut;
	}

	public void setIrut(Integer irut) {
		this.irut = irut;
	}

	public Integer getIracm() {
		return iracm;
	}

	public void setIracm(Integer iracm) {
		this.iracm = iracm;
	}

	public CatSexo getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(CatSexo idSexo) {
		this.idSexo = idSexo;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "CeUltrasonido [idCEUltrasonido=" + idCEUltrasonido
				+ ", controlEmbarazo=" + controlEmbarazo
				+ ", fechaUltrasonido=" + fechaUltrasonido + ", crl=" + crl
				+ ", tn=" + tn + ", dbp=" + dbp + ", ca=" + ca + ", lf=" + lf
				+ ", hum=" + hum + ", eg=" + eg + ", peso=" + peso
				+ ", idPlacenta=" + idPlacenta + ", idLA=" + idLA + ", irumb="
				+ irumb + ", irut=" + irut + ", iracm=" + iracm + ", idSexo="
				+ idSexo + ", otros=" + otros + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ca == null) ? 0 : ca.hashCode());
		result = prime * result
				+ ((controlEmbarazo == null) ? 0 : controlEmbarazo.hashCode());
		result = prime * result + ((crl == null) ? 0 : crl.hashCode());
		result = prime * result + ((dbp == null) ? 0 : dbp.hashCode());
		result = prime * result + ((eg == null) ? 0 : eg.hashCode());
		result = prime
				* result
				+ ((fechaUltrasonido == null) ? 0 : fechaUltrasonido.hashCode());
		result = prime * result + ((hum == null) ? 0 : hum.hashCode());
		result = prime * result
				+ ((idCEUltrasonido == null) ? 0 : idCEUltrasonido.hashCode());
		result = prime * result + ((idLA == null) ? 0 : idLA.hashCode());
		result = prime * result
				+ ((idPlacenta == null) ? 0 : idPlacenta.hashCode());
		result = prime * result + ((idSexo == null) ? 0 : idSexo.hashCode());
		result = prime * result + ((iracm == null) ? 0 : iracm.hashCode());
		result = prime * result + ((irumb == null) ? 0 : irumb.hashCode());
		result = prime * result + ((irut == null) ? 0 : irut.hashCode());
		result = prime * result + ((lf == null) ? 0 : lf.hashCode());
		result = prime * result + ((otros == null) ? 0 : otros.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((tn == null) ? 0 : tn.hashCode());
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
		CeUltrasonido other = (CeUltrasonido) obj;
		if (ca == null) {
			if (other.ca != null)
				return false;
		} else if (!ca.equals(other.ca))
			return false;
		if (controlEmbarazo == null) {
			if (other.controlEmbarazo != null)
				return false;
		} else if (!controlEmbarazo.equals(other.controlEmbarazo))
			return false;
		if (crl == null) {
			if (other.crl != null)
				return false;
		} else if (!crl.equals(other.crl))
			return false;
		if (dbp == null) {
			if (other.dbp != null)
				return false;
		} else if (!dbp.equals(other.dbp))
			return false;
		if (eg == null) {
			if (other.eg != null)
				return false;
		} else if (!eg.equals(other.eg))
			return false;
		if (fechaUltrasonido == null) {
			if (other.fechaUltrasonido != null)
				return false;
		} else if (!fechaUltrasonido.equals(other.fechaUltrasonido))
			return false;
		if (hum == null) {
			if (other.hum != null)
				return false;
		} else if (!hum.equals(other.hum))
			return false;
		if (idCEUltrasonido == null) {
			if (other.idCEUltrasonido != null)
				return false;
		} else if (!idCEUltrasonido.equals(other.idCEUltrasonido))
			return false;
		if (idLA == null) {
			if (other.idLA != null)
				return false;
		} else if (!idLA.equals(other.idLA))
			return false;
		if (idPlacenta == null) {
			if (other.idPlacenta != null)
				return false;
		} else if (!idPlacenta.equals(other.idPlacenta))
			return false;
		if (idSexo == null) {
			if (other.idSexo != null)
				return false;
		} else if (!idSexo.equals(other.idSexo))
			return false;
		if (iracm == null) {
			if (other.iracm != null)
				return false;
		} else if (!iracm.equals(other.iracm))
			return false;
		if (irumb == null) {
			if (other.irumb != null)
				return false;
		} else if (!irumb.equals(other.irumb))
			return false;
		if (irut == null) {
			if (other.irut != null)
				return false;
		} else if (!irut.equals(other.irut))
			return false;
		if (lf == null) {
			if (other.lf != null)
				return false;
		} else if (!lf.equals(other.lf))
			return false;
		if (otros == null) {
			if (other.otros != null)
				return false;
		} else if (!otros.equals(other.otros))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (tn == null) {
			if (other.tn != null)
				return false;
		} else if (!tn.equals(other.tn))
			return false;
		return true;
	}
}
