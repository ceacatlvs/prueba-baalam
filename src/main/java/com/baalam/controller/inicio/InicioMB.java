package com.baalam.controller.inicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.LoginMB;
import com.baalam.controller.controlEmbarazo.CeSeguimientoMB;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.AgendaDao;
import com.baalam.dao.inicio.ConsultaHoyDao;
import com.baalam.dao.inicio.PacienteDao;
import com.baalam.dao.usuarios.DoctorDao;
import com.baalam.model.ConsultaDiaHoy;
import com.baalam.model.agenda.CitaAgenda;
import com.baalam.model.paciente.PacienteDetalle;
import com.baalam.model.usuario.Doctor;

@Named
@ViewAccessScoped
public class InicioMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PacienteDao pacienteDao;
	
	@Inject
	private DoctorDao doctorDao;
	
	@Inject
	private ConsultaHoyDao consultaHoyDao;
	
	@Inject
	private AgendaDao agendaDao;
	
	@Inject
    private LoginMB loginMB;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private CeSeguimientoMB cemb;
	
	private String nombrePaciente;
	private Doctor doctor;
	private List<PacienteDetalle> busquedaPacientes;
	private List<ConsultaDiaHoy> consultasHoy;
	
	private Date fecha;
	
	@PostConstruct
	public void inicioMB(){
		setDoctor(loginMB.getDoctor());
		
		busquedaPacientes = new ArrayList<PacienteDetalle>();
		consultasHoy = new ArrayList<ConsultaDiaHoy>();
		
		fimb.cancelar();
		pamb.cancelar();
		cemb.cancelar();
		
		setFecha(fimb.getFechaHoy());
		
		obtenerConsultasDiaHoy();
	}
	
	private void obtenerConsultasDiaHoy(){
		setConsultasHoy(consultaHoyDao.buscarConsultaHoyPorDoctor(loginMB.getDoctor().getIdDoctor()));
	}
	
	public void buscarPacientes(){			
		setBusquedaPacientes(pacienteDao.buscarPacientePorNombre(nombrePaciente, loginMB.getDoctor().getIdDoctor()));		
	}
	
	public void cambiarDoctor(){
		setDoctor(doctorDao.buscarDoctorPorId(getDoctor().getIdDoctor()));
		setBusquedaPacientes(new ArrayList<PacienteDetalle>());
		loginMB.setDoctor(getDoctor());	
		obtenerConsultasDiaHoy();
	}
	
	public void cancelarCitaHoy(Long idCita){
		CitaAgenda cita = agendaDao.obtenerCitaporId(idCita);
		agendaDao.eliminarCita(cita);
		if(cita.getTipoConsulta().equalsIgnoreCase("P")){
			if(cita.getPaciente().getFechaUltimaCita()==null){
				pacienteDao.borrarPaciente(cita.getPaciente().getIdPaciente());
			}
		}
		
		obtenerConsultasDiaHoy();
	}
	
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	
	public List<PacienteDetalle> getBusquedaPacientes() {
		return busquedaPacientes;
	}
	public void setBusquedaPacientes(List<PacienteDetalle> busquedaPacientes) {
		this.busquedaPacientes = busquedaPacientes;
	}

	public List<ConsultaDiaHoy> getConsultasHoy() {
		return consultasHoy;
	}
	public void setConsultasHoy(List<ConsultaDiaHoy> consultasHoy) {
		this.consultasHoy = consultasHoy;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
}