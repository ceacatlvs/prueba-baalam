package com.baalam.model.histclinica.pa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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

import com.baalam.model.catalogo.CatTipoPaciente;
import com.baalam.model.paciente.Paciente;

@Entity
@Table(	name="consulta_pa")
//@IdClass(PadicimientoActualPK.class)
public class PadecimientoActual implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idConsulta")
	private Long idConsulta;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;
	
	@NotNull
	@Column(name = "fechaConsulta")
	private Date fechaConsulta;
	
	@Column(name = "motivoConsulta")
	@Size(min = 1, max = 250)
	private String motivoConsulta;
	
	@OneToOne
	@JoinColumn(name="idTipoPaciente")
	private CatTipoPaciente tipoPaciente;
	
	@Column(name = "sintomas")
	@Size(min = 0, max = 500)
	private String sintomas;
	
	@Column(name = "fechaInicio")
	private Date fechaInicio;
	
	@Column(name = "evolucion")
	@Size(min = 0, max = 500)
	private String evolucion;
	
	@Column(name = "cuidadosGenerales",
			columnDefinition="BIT(1)")
	private Boolean cuidadosGenerales;
	
	@Column(name = "tratamientoAlternativo",
			columnDefinition="BIT(1)")
	private Boolean tratamientoAlternativo;
	
	@Column(name = "medicamentos",
			columnDefinition="BIT(1)")
	private Boolean medicamentos;
	
	@Column(name = "cirugia",
			columnDefinition="BIT(1)")
	private Boolean cirugia;
	
	@Column(name = "resultados")
	@Size(min = 0, max = 500)
	private String resultados;
	
	@Column(name = "estadoActual")
	@Size(min = 0, max = 500)
	private String estadoActual;
	
	@Column(name = "tipoConsulta")
	@Size(min = 0, max = 500)
	private String tipoConsulta;

	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		Calendar hora = GregorianCalendar.getInstance();
		TimeZone timeZone = TimeZone.getTimeZone("America/Mexico_City");
		System.out.println("timezone id " + timeZone.getDisplayName() + " timezone name " + timeZone.getID());
		hora.setTimeZone(timeZone);
		fechaConsulta.setTime(hora.getTimeInMillis());
		
		this.fechaConsulta = fechaConsulta;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public CatTipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}

	public void setTipoPaciente(CatTipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	public Boolean getCuidadosGenerales() {
		return cuidadosGenerales;
	}

	public void setCuidadosGenerales(Boolean cuidadosGenerales) {
		this.cuidadosGenerales = cuidadosGenerales;
	}

	public Boolean getTratamientoAlternativo() {
		return tratamientoAlternativo;
	}

	public void setTratamientoAlternativo(Boolean tratamientoAlternativo) {
		this.tratamientoAlternativo = tratamientoAlternativo;
	}

	public Boolean getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Boolean medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Boolean getCirugia() {
		return cirugia;
	}

	public void setCirugia(Boolean cirugia) {
		this.cirugia = cirugia;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	@Override
	public String toString() {
		return "PadecimientoActual [idConsulta=" + idConsulta + ", paciente="
				+ paciente + ", fechaConsulta=" + fechaConsulta
				+ ", motivoConsulta=" + motivoConsulta + ", tipoPaciente="
				+ tipoPaciente + ", sintomas=" + sintomas + ", fechaInicio="
				+ fechaInicio + ", evolucion=" + evolucion
				+ ", cuidadosGenerales=" + cuidadosGenerales
				+ ", tratamientoAlternativo=" + tratamientoAlternativo
				+ ", medicamentos=" + medicamentos + ", cirugia=" + cirugia
				+ ", resultados=" + resultados + ", estadoActual="
				+ estadoActual + ", tipoConsulta= " + tipoConsulta + "]";
	}
}
