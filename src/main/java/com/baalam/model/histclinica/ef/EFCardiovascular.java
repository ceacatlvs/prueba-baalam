package com.baalam.model.histclinica.ef;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EFCardiovascular
 *
 */
@Entity
@Table( name = "consulta_ef_cardiovascular",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))
public class EFCardiovascular implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Size(min = 0, max = 7)
	@Column(name = "ruidosCardiacos")
	private String ruidosCardiacos;
	
	@Size(min = 0, max = 7)
	@Column(name = "ruidosAgregados")
	private String ruidosAgregados;
	
	@Size(min = 0, max = 7)
	@Column(name = "vascularPerif")
	private String vascularPerif;
	
	@Size(min = 0, max = 500)
	@Column(name = "observaciones")
	private String observaciones;

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public String getRuidosCardiacos() {
		return ruidosCardiacos;
	}

	public void setRuidosCardiacos(String ruidosCardiacos) {
		this.ruidosCardiacos = ruidosCardiacos;
	}

	public String getRuidosAgregados() {
		return ruidosAgregados;
	}

	public void setRuidosAgregados(String ruidosAgregados) {
		this.ruidosAgregados = ruidosAgregados;
	}

	public String getVascularPerif() {
		return vascularPerif;
	}

	public void setVascularPerif(String vascularPerif) {
		this.vascularPerif = vascularPerif;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}  
}