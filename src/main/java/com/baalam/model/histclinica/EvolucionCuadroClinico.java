package com.baalam.model.histclinica;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.baalam.model.histclinica.pa.PadecimientoActual;

/**
 * Entity implementation class for Entity: EvolucionCuadroClinico
 *
 */
@Entity
@Table(name="consulta_evolucion_cuadro_clinico",
uniqueConstraints = @UniqueConstraint(columnNames = "idConsulta"))

public class EvolucionCuadroClinico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne
	@JoinColumn(name="idConsulta")
	private PadecimientoActual padecimientoActual;
	
	@Column(name = "siguiIndicaciones", columnDefinition="BIT(1)")
	private Boolean siguiIndicaciones;
	
	@Size(min = 0, max = 500)
	@Column(name = "notasIndicaciones")
	private String notasIndicaciones;
	
	@Column(name = "mejoria", columnDefinition="BIT(1)")
	private Boolean mejoria;
	
	@Column(name = "curacion", columnDefinition="BIT(1)")
	private Boolean curacion;
	
	@Column(name = "noModificacion", columnDefinition="BIT(1)")
	private Boolean noModificacion;
	
	@Column(name = "empeoramiento", columnDefinition="BIT(1)")
	private Boolean empeoramiento;
	
	@Column(name = "otrosAgregados", columnDefinition="BIT(1)")
	private Boolean otrosAgregados;
	
	@Column(name = "ingestaTabaco", columnDefinition="BIT(1)")
	private Boolean ingestaTabaco;
	
	@Column(name = "ingestaAlcohol", columnDefinition="BIT(1)")
	private Boolean ingestaAlcohol;
	
	@Column(name = "otrasAdicciones", columnDefinition="BIT(1)")
	private Boolean otrasAdicciones;
	
	@Size(min = 0, max = 500)
	@Column(name = "notas")
	private String notas;
	

	public PadecimientoActual getPadecimientoActual() {
		return padecimientoActual;
	}

	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}

	public Boolean getSiguiIndicaciones() {
		return siguiIndicaciones;
	}

	public void setSiguiIndicaciones(Boolean siguiIndicaciones) {
		this.siguiIndicaciones = siguiIndicaciones;
	}

	public String getNotasIndicaciones() {
		return notasIndicaciones;
	}

	public void setNotasIndicaciones(String notasIndicaciones) {
		this.notasIndicaciones = notasIndicaciones;
	}

	public Boolean getMejoria() {
		return mejoria;
	}

	public void setMejoria(Boolean mejoria) {
		this.mejoria = mejoria;
	}

	public Boolean getCuracion() {
		return curacion;
	}

	public void setCuracion(Boolean curacion) {
		this.curacion = curacion;
	}

	public Boolean getNoModificacion() {
		return noModificacion;
	}

	public void setNoModificacion(Boolean noModificacion) {
		this.noModificacion = noModificacion;
	}

	public Boolean getEmpeoramiento() {
		return empeoramiento;
	}

	public void setEmpeoramiento(Boolean empeoramiento) {
		this.empeoramiento = empeoramiento;
	}

	public Boolean getOtrosAgregados() {
		return otrosAgregados;
	}

	public void setOtrosAgregados(Boolean otrosAgregados) {
		this.otrosAgregados = otrosAgregados;
	}

	public Boolean getIngestaTabaco() {
		return ingestaTabaco;
	}

	public void setIngestaTabaco(Boolean ingestaTabaco) {
		this.ingestaTabaco = ingestaTabaco;
	}

	public Boolean getIngestaAlcohol() {
		return ingestaAlcohol;
	}

	public void setIngestaAlcohol(Boolean ingestaAlcohol) {
		this.ingestaAlcohol = ingestaAlcohol;
	}

	public Boolean getOtrasAdicciones() {
		return otrasAdicciones;
	}

	public void setOtrasAdicciones(Boolean otrasAdicciones) {
		this.otrasAdicciones = otrasAdicciones;
	}
	
	public String getNotas(){
		return notas;
	}
	public void setNotas(String notas){
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "EvolucionCuadroClinico [padecimientoActual="
				+ padecimientoActual + ", siguiIndicaciones="
				+ siguiIndicaciones + ", notasIndicaciones="
				+ notasIndicaciones + ", mejoria=" + mejoria + ", curacion="
				+ curacion + ", noModificacion=" + noModificacion
				+ ", empeoramiento=" + empeoramiento + ", otrosAgregados="
				+ otrosAgregados + ", ingestaTabaco=" + ingestaTabaco
				+ ", ingestaAlcohol=" + ingestaAlcohol + ", otrasAdicciones="
				+ otrasAdicciones + ", notas=" + notas + "]";
	}
}