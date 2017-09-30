package com.baalam.controller.agenda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;

import com.baalam.controller.LoginMB;
import com.baalam.dao.AgendaDao;
import com.baalam.dao.inicio.PacienteDao;
import com.baalam.model.agenda.CitaAgenda;
import com.baalam.model.agenda.CitaCancelada;
import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.catalogo.CatGrupoSanguineo;
import com.baalam.model.paciente.Paciente;

/**
 * Esta clase es el managed bean para la pantalla de datosAgenda.xhtml, la cual 
 * sirve para crear la agenda del médico
 */
@Named
@ViewAccessScoped
public class AgendaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginMB loginMB;

	@Inject
	private AgendaDao agendaDao;

	@Inject
	private PacienteDao pacienteDao;

	private LazyScheduleModel modeloEvento;

	private DefaultScheduleEvent eventoCita;
	private CitaAgenda cita;
	private Paciente paciente;

	private int horarioConsultorioInicio;
	private int horarioConsultorioFin;
	private int duracionConsultaP;
	private int duracionConsultaS;

	// variables auxiliares que son necesarias debido a que no funciona correctamente ponerle el timepicker y el calendar al mismo objeto de fecha (solo le hace caso a 1)
	private Date fechaHoy;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaAgendaInicio;

	private boolean editarTipoCita;
	private boolean todoElDia;
	private boolean citaPasada;
	private boolean cancelarCita;

	private List<Paciente> pacientes;
	private List<CitaCancelada> citasCanceladas;
	
	@SuppressWarnings("unused")
	private String vistaAgenda;
	private String cancelacionCita;

	/**
	 * El método iniciar es lo primero que se manda llamar, al entrar a la página, y también se usa para refrescar la pantalla
	 */
	@PostConstruct
	public void iniciar() {	
		fechaHoy = new Date();
		cancelar();
	}
	
	public void cancelar(){
		//modeloEvento = new DefaultScheduleModel();
		
		modeloEvento = new LazyScheduleModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void loadEvents(Date start, Date end) {
				clear();

				List<CitaAgenda> citas = agendaDao.obtenerCitasporDoctorYFechas(loginMB.getDoctor().getIdDoctor(),start, end);
				for(CitaAgenda citaMedico : citas){
					addEvent(formatearEventoCita(citaMedico));
				}
			}	
		};
		//TODO V2 aqui se debe consultar la configuracion de agenda del doctor y setear estas 5 propiedades
		System.out.println("en cancelar inicio " );
		setTodoElDia(false);
		setCancelarCita(false);
		setHorarioConsultorioInicio(0);
		setHorarioConsultorioFin(23);
		duracionConsultaP=60;
		duracionConsultaS=30;	
		
		setCitasCanceladas(agendaDao.obtenerCitasPorEstadoPorDoctor(loginMB.getDoctor().getIdDoctor()));

		reiniciarObjetosCita();
		if(fechaAgendaInicio == null){
			fechaAgendaInicio = new Date();
		}		
	}

	/**
	 * Este método reinicia el objeto cita, el cual es el que se llena en el formulario que se abre al realizar una cita
	 */
	public void reiniciarObjetosCita() {
		setCita(new CitaAgenda());
		getCita().setDoctor(loginMB.getDoctor());
		getCita().setTipoConsulta(null);
		setCitaPasada(false);
		setTodoElDia(false);
		setCancelarCita(false);
		eventoCita = new DefaultScheduleEvent();
		editarTipoCita = true;
		fechaInicio = new Date();
		fechaFin = new Date();
	}
	
	public void mostrarCancelar() {
		setCancelarCita(true);
		System.out.println("cita en mostrar cancelar"+ getCita());
	}
	
	public void ocultarCancelar() {
		setCancelarCita(false);
		System.out.println("cita " + getCita());
	}

	/**
	 * Este método se manda a llamar cuando se hace click en alguna fecha de la agenda,donde no haya una cita
	 * e inicializa las variables de fecha inicio y fin en el objeto cita
	 * @param selectEvent
	 */
	public void onDateSelect(SelectEvent selectEvent) {
		fechaInicio = (Date) selectEvent.getObject();
		fechaFin = (Date) selectEvent.getObject();

		//se valida que la hora que se elije no sea menor a la del horario del consultorio (vista de mes regresa las 0 horas)
		//TODO posteriormente se puede poner que regrese la proxima hora disponible (version 2)
		Calendar horaInicio = GregorianCalendar.getInstance(); 
		horaInicio.setTime(fechaInicio);
		if(horaInicio.get(Calendar.HOUR_OF_DAY)<horarioConsultorioInicio){
			horaInicio.set(Calendar.HOUR_OF_DAY,horarioConsultorioInicio);
			fechaInicio = horaInicio.getTime();
		}
		cita.setCitaInicio(fechaInicio);
		cita.setCitaFin(fechaFin);
	}

	/**
	 * Este método se manda a llamar cuando se va a agregar o actualizar una cita, este metodo manda a llamar a 
	 *  agendaDao.registrarCita que registra la cita en la base de datos.
	 * @param actionEvent
	 */
	public void addEvent(ActionEvent actionEvent) {
		Calendar fechaInicioAGuardar = GregorianCalendar.getInstance(); 
		fechaInicioAGuardar.setTime(fechaInicio); 
		
		Calendar horaInicioAGuardar = GregorianCalendar.getInstance();
		
		if(todoElDia){
			horaInicioAGuardar.set(Calendar.HOUR_OF_DAY, getHorarioConsultorioInicio());
			horaInicioAGuardar.set(Calendar.MINUTE, 0);
		}else{
			horaInicioAGuardar.setTime(cita.getCitaInicio());
		}

		fechaInicioAGuardar.set(fechaInicioAGuardar.get(Calendar.YEAR),fechaInicioAGuardar.get(Calendar.MONTH),fechaInicioAGuardar.get(Calendar.DAY_OF_MONTH),horaInicioAGuardar.get(Calendar.HOUR_OF_DAY),horaInicioAGuardar.get(Calendar.MINUTE));  
		cita.setCitaInicio(fechaInicioAGuardar.getTime());

		// si es consulta subsecuente o primera vez, es en el mismo día, por lo que la fecha fin es la misma que el inicio
		if(!cita.getTipoConsulta().equalsIgnoreCase("O")){
			fechaFin=fechaInicio;
		}
		Calendar fechaFinAGuardar = GregorianCalendar.getInstance(); 
		fechaFinAGuardar.setTime(fechaFin); 
		
		Calendar horaFinAGuardar = GregorianCalendar.getInstance(); 
		
		if(todoElDia){
			horaFinAGuardar.set(Calendar.HOUR_OF_DAY, getHorarioConsultorioFin());
			horaFinAGuardar.set(Calendar.MINUTE, 0);
		}else{
			horaFinAGuardar.setTime(cita.getCitaFin());
		}
		fechaFinAGuardar.set(fechaFinAGuardar.get(Calendar.YEAR),fechaFinAGuardar.get(Calendar.MONTH),fechaFinAGuardar.get(Calendar.DAY_OF_MONTH),horaFinAGuardar.get(Calendar.HOUR_OF_DAY),horaFinAGuardar.get(Calendar.MINUTE));  
		cita.setCitaFin(fechaFinAGuardar.getTime());		

		//si no se registro la cita (por algun error)
		if(!registrarCita(cita)){
			// y la cita ya existía, se deben obtener los datos de la cita como estaba antes del cambio, para ponerlos en el modelo de la agenda.
			if(cita.getIdCita()!=null){
				CitaAgenda citaGuardada = agendaDao.obtenerCitaporId(cita.getIdCita());
				fechaInicio = citaGuardada.getCitaInicio();
				fechaFin = citaGuardada.getCitaFin();
				eventoCita.setData(citaGuardada);
				modeloEvento.updateEvent(eventoCita);				
			}
		}
	}

	/**
	 * Este método le pone un color diferente a la cita dependiendo si es:
	 *  	cita de primera vez
	 *  	subsecuente 
	 *  	o marcada como ocupada.
	 * Asi mismo le pone un título a la cita:
	 * 		Nombre de Paciente + telefono de casa si es primera vez o subsecuente
	 * 		No disponible: o motivo si es marcada como ocupada
	 * 
	 * @param citaParam
	 * @return
	 */
	public DefaultScheduleEvent formatearEventoCita(CitaAgenda citaParam){
		String titulo="";
		String estilo="";
		String telefono="";
		if (citaParam.getTipoConsulta()!=null && citaParam.getTipoConsulta().equalsIgnoreCase("P")) {
			if(citaParam.getPaciente().getTelCasa()!=null && !citaParam.getPaciente().getTelCasa().equals("")){
				telefono = "Tel: "+citaParam.getPaciente().getTelCasa();
			}
			else if(citaParam.getPaciente().getTelefonoMovil()!=null && !citaParam.getPaciente().getTelefonoMovil().equals("")){
				telefono = "Cel: "+citaParam.getPaciente().getTelefonoMovil();
			}
			
			if(citaParam.getCitaConfirmada() != null && citaParam.getCitaConfirmada()){
				titulo = "✓ " + citaParam.getPaciente().getNombrePaciente() + " " + telefono;
			}
			else if(citaParam.getCitaConfirmada() == null || !citaParam.getCitaConfirmada()){
				titulo = citaParam.getPaciente().getNombrePaciente() + " " + telefono;
			}
			
			estilo = "eventoPrimera";
		} else if (citaParam.getTipoConsulta()!=null && citaParam.getTipoConsulta().equalsIgnoreCase("S")) {
			if(citaParam.getPaciente().getTelCasa()!=null && !citaParam.getPaciente().getTelCasa().equals("")){
				telefono = "Tel: "+citaParam.getPaciente().getTelCasa();
			}
			else if(citaParam.getPaciente().getTelefonoMovil()!=null && !citaParam.getPaciente().getTelefonoMovil().equals("")){
				telefono = "Cel: "+citaParam.getPaciente().getTelefonoMovil();
			}
			
			if(citaParam.getCitaConfirmada() != null && citaParam.getCitaConfirmada()){
				titulo = "✓ " + citaParam.getPaciente().getNombrePaciente() + " " + telefono;
			}
			else if(citaParam.getCitaConfirmada() == null || !citaParam.getCitaConfirmada()){
				titulo = citaParam.getPaciente().getNombrePaciente() + " " + telefono;
			}
			
			estilo="eventoSub";
		} else if (citaParam.getTipoConsulta()!=null && citaParam.getTipoConsulta().equalsIgnoreCase("O")) {
			titulo="No disponible";
			if( citaParam.getMotivoOcupado()!=null && !citaParam.getMotivoOcupado().equals("")){
				titulo= citaParam.getMotivoOcupado();
			}
			estilo="eventoOcupado";
		}
		DefaultScheduleEvent evento = new DefaultScheduleEvent(titulo, citaParam.getCitaInicio(), citaParam.getCitaFin(), citaParam);
		evento.setStyleClass(estilo); 
		return evento;
	}

	/**
	 * Este método se manda a llamar cuando en el front se elige un tipo de consulta
	 */
	public void crearNuevoPanelCita() {
		Paciente pacienteNuevo = new Paciente();
		if(cita.getTipoConsulta() != null && !cita.getTipoConsulta().equalsIgnoreCase("O")){			
			pacienteNuevo.setEntidadFedereativa(new CatEntidadFederativa());
			pacienteNuevo.getEntidadFedereativa().setIdEntidadFedereativa(new Long(1));
			
			pacienteNuevo.setIdGrupoSanguineo(new CatGrupoSanguineo());
			pacienteNuevo.getIdGrupoSanguineo().setIdGrupoSanguineo(new Long(1));
			pacienteNuevo.setDoctor(loginMB.getDoctor());
		}
		
		if (cita.getTipoConsulta() != null && cita.getTipoConsulta().equalsIgnoreCase("P")) {
			fechaFin = DateUtils.addMinutes(fechaInicio, duracionConsultaP);
			cita.setPaciente(pacienteNuevo);
		} else if (cita.getTipoConsulta()!=null && cita.getTipoConsulta().equalsIgnoreCase("S")) {
			fechaFin = DateUtils.addMinutes(fechaInicio, duracionConsultaS);
			cita.setPaciente(pacienteNuevo);	
		}else if (cita.getTipoConsulta()!=null && cita.getTipoConsulta().equalsIgnoreCase("O")) {
			fechaFin = DateUtils.addMinutes(fechaInicio, 60);
		}
		cita.setCitaFin(fechaFin);
	}

	/**
	 * Este método se manda a llamar cuando se da click en el botón cancelar cita y
	 * quita la cita del modelo de la agenda y manda a llamar a agendaDao.eliminaCita
	 * que la quita de la base de datos.
	 * @param actionEvent
	 */
	public void removeEvent(ActionEvent actionEvent) { 
		modeloEvento.deleteEvent(eventoCita);
		
		if(cita.getPaciente() != null){
			CitaCancelada citaCancel = new CitaCancelada();
			
			if(loginMB.getUsuario()!= null && loginMB.getUsuario().getRol()!= null && loginMB.getUsuario().getRol().getIdRol() == (long)1 && loginMB.getDoctor() != null){
				citaCancel.setCancelador(loginMB.getDoctor().getNombre() + " " + loginMB.getDoctor().getaPaterno() + " " + loginMB.getDoctor().getaMaterno());
			}
			else if(loginMB.getUsuario()!= null && loginMB.getUsuario().getRol()!= null && loginMB.getUsuario().getRol().getIdRol() == (long)2 && loginMB.getSecretaria() != null){
				citaCancel.setCancelador(loginMB.getSecretaria().getNombre() + " " + loginMB.getSecretaria().getaPaterno() + " " + loginMB.getSecretaria().getaMaterno());
			}
			
			citaCancel.setCitaConfirmada(cita.getCitaConfirmada());
			citaCancel.setCitaFin(fechaFin);
			citaCancel.setCitaInicio(fechaInicio);
			citaCancel.setDoctor(cita.getDoctor());
			System.out.println("motivo cancelaion " + cita.getMotivoCambioCita());
			citaCancel.setMotivoCancelacionCita(cita.getMotivoCambioCita());
			citaCancel.setMotivoOcupado(cita.getMotivoOcupado());
			citaCancel.setNombrePaciente(cita.getPaciente().getNombrePaciente());
			citaCancel.setNotasCita(cita.getNotasCita());
			citaCancel.setTelCasa(cita.getPaciente().getTelCasa());
			citaCancel.setTelefonoMovil(cita.getPaciente().getTelefonoMovil());
			citaCancel.setTipoConsulta(cita.getTipoConsulta());
			
			agendaDao.registrarCitaCancelada(citaCancel);
		}
		
		
		//pasar a citas canceladas
		
		agendaDao.eliminarCita(cita);
		if(cita.getTipoConsulta().equalsIgnoreCase("P")){
			if(cita.getPaciente().getFechaUltimaCita()==null){
				pacienteDao.borrarPaciente(cita.getPaciente().getIdPaciente());
			}
		}
		reiniciarObjetosCita();
	}

	/**
	 * Este método se manda a llamar cuando se da click en alguna cita dentro de la agenda
	 * y asigna las fechas de la cita a las variables fechaInicio y fechaFin, para que esten correctas
	 * se usa el booleano editarTipoCita, para no permitir cambiar el tipo de cita 
	 * y mostrar el botón cancelar cambios en cita (el cual refresca la pantalla sin cambios en la cita)
	 * @param selectEvent
	 */
	public void onEventSelect(SelectEvent selectEvent) {	
		editarTipoCita = false;
		eventoCita =  (DefaultScheduleEvent) selectEvent.getObject();
		cita = (CitaAgenda) eventoCita.getData();
		System.out.println("cita seleccionada: " + getCita());
		fechaInicio = cita.getCitaInicio();
		fechaFin = cita.getCitaFin();
		
		setCitaPasada(fechaInicio.before(fechaHoy));
	}

	/**
	 * El método se llama cuando se arrastra una cita dentro de la agenda,
	 * aquí se asigna el valor de fechas de la cita a las variables fechaInicio y fechaFin
	 * y luego se lama a agendaDao.registrarCita para que se actualice en la base de datos
	 * @param event
	 */
	public void onEventMove(ScheduleEntryMoveEvent event) {  
		eventoCita = (DefaultScheduleEvent) event.getScheduleEvent();
		cita = (CitaAgenda) eventoCita.getData();
		fechaInicio = cita.getCitaInicio();
		fechaFin = cita.getCitaFin();
		//si no se registro la cita (por algun error) entonces se refresca la agenda con los datos anteriores
		if(!registrarCita(cita)){
			iniciar();
		}

	}

	/**
	 * Este metodo valida el horario de la cita, y en caso de que sea correcto guarda la cita en la base de datos
	 * @param citaGuardar
	 * @return true si se guardó, false si se tuvo un error en la validacion
	 */
	private boolean registrarCita(CitaAgenda citaGuardar) {		
		if(citaGuardar.getCitaFin().after(citaGuardar.getCitaInicio())){
			if(!agendaDao.revisarEmpalme(citaGuardar).isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();  
				context.validationFailed();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de empalme.", "Por favor elija otro.")); 
				return false;
			}else{
				agendaDao.registrarCita(citaGuardar);
				modeloEvento.deleteEvent(eventoCita);
				modeloEvento.addEvent(formatearEventoCita(citaGuardar));
				reiniciarObjetosCita();
				return true;
			}
		}
		else{
			FacesContext context = FacesContext.getCurrentInstance();  
			context.validationFailed();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Horario inválido.", "La fecha y hora de fin de cita deben ser posteriores a la fecha y hora de inicio."));
			return false;
		}
	}

	/**
	 * El método se llama cuando se hace más grande o más pequeña una cita dentro de la agenda,
	 * aquí se asigna el valor de fechas de la cita a las variables fechaInicio y fechaFin
	 * y luego se lama a agendaDao.registrarCita para que se actualice en la base de datos
	 * @param event
	 */
	public void onEventResize(ScheduleEntryResizeEvent event) {  
		eventoCita = (DefaultScheduleEvent) event.getScheduleEvent();
		cita = (CitaAgenda) eventoCita.getData();
		fechaInicio = cita.getCitaInicio();
		fechaFin = cita.getCitaFin();
		//si no se registro la cita (por algun error) entonces se refresca la agenda con los datos anteriores
		if(!registrarCita(cita)){
			iniciar();
		}
	}

	/**
	 * Este metodo sirve para autocompletar los nombres de las pacientes en una consulta subsecuente
	 * @param query es lo que el usuario ingresa (parte del nombre)
	 * @return lista de las pacientes que contienen esa parte del nombre
	 */
	public List<Paciente> buscarPacientesNombre(String query) {
		List<Paciente> pacientesLista = pacienteDao.pacientesSubsecuentesPorIdDoctor(loginMB.getDoctor().getIdDoctor(),query);
		return pacientesLista;  
	}
	
	public void establecerHoraCitaFin(){
		setFechaInicio(getCita().getCitaInicio());
		Calendar horaInicio = GregorianCalendar.getInstance(); 
		horaInicio.setTime(getFechaInicio());
		
		if(getCita().getTipoConsulta().equalsIgnoreCase("P")){
			horaInicio.add(Calendar.HOUR_OF_DAY, 1);						
		}else if(getCita().getTipoConsulta().equalsIgnoreCase("S")){
			horaInicio.add(Calendar.MINUTE, 30);
		}else if(getCita().getTipoConsulta().equalsIgnoreCase("O")){
			horaInicio.add(Calendar.HOUR_OF_DAY, 3);			
		}else{
			
		}
		
		cita.setCitaFin(horaInicio.getTime());
		System.out.println("La cita " + cita.getCitaFin());
	}

	public DefaultScheduleModel getModeloEvento() {
		return modeloEvento;
	}
	public void setModeloEvento(LazyScheduleModel modeloEvento) {
		this.modeloEvento = modeloEvento;
	}

	public CitaAgenda getCita() {
		return cita;
	}
	public void setCita(CitaAgenda cita) {
		this.cita = cita;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEditarTipoCita() {
		return editarTipoCita;
	}
	public void setEditarTipoCita(boolean editarTipoCita) {
		this.editarTipoCita = editarTipoCita;
	}

	public int getHorarioConsultorioInicio() {
		return horarioConsultorioInicio;
	}
	public void setHorarioConsultorioInicio(int horarioConsultorioInicio) {
		this.horarioConsultorioInicio = horarioConsultorioInicio;
	}

	public int getHorarioConsultorioFin() {
		return horarioConsultorioFin;
	}
	public void setHorarioConsultorioFin(int horarioConsultorioFin) {
		this.horarioConsultorioFin = horarioConsultorioFin;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Date getFechaHoy() {
		return fechaHoy;
	}
	
	public void setFechaHoy(Date fechaHoy) {
		this.fechaHoy = fechaHoy;
	}

	public Date getFechaAgendaInicio() {
		return fechaAgendaInicio;
	}
	public void setFechaAgendaInicio(Date fechaAgendaInicio) {
		this.fechaAgendaInicio = fechaAgendaInicio;
	}

	public String getVistaAgenda() {
		if(loginMB.getUsuario().getRol().getIdRol() == 2){
			return "month";
		}else{
			return "agendaWeek";
		}		
	}
	public void setVistaAgenda(String vistaAgenda) {
		this.vistaAgenda = vistaAgenda;
	}
	
	public List<CitaCancelada> getCitasCanceladas(){
		return citasCanceladas;
	}
	public void setCitasCanceladas(List<CitaCancelada> citasCanceladas){
		this.citasCanceladas = citasCanceladas;
	}
	
	public boolean isTodoElDia() {
		return todoElDia;
	}
	public void setTodoElDia(boolean todoElDia) {
		this.todoElDia = todoElDia;
	}

	public boolean isCitaPasada() {
		return citaPasada;
	}
	public void setCitaPasada(boolean citaPasada) {
		this.citaPasada = citaPasada;
	}

	public String getCancelacionCita() {
		return cancelacionCita;
	}

	public void setCancelacionCita(String cancelacionCita) {
		this.cancelacionCita = cancelacionCita;
	}

	public boolean isCancelarCita() {
		return cancelarCita;
	}

	public void setCancelarCita(boolean cancelarCita) {
		this.cancelarCita = cancelarCita;
	}
	
}
