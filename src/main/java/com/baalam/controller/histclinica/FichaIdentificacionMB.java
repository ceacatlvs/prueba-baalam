package com.baalam.controller.histclinica;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.LoginMB;
import com.baalam.dao.histclinica.FichaIdentificacionDao;
import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.catalogo.CatGrupoSanguineo;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;
import com.baalam.util.Utilidades;

@Named
@SessionScoped
public class FichaIdentificacionMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private LoginMB loginMB;

	@Inject
	private FichaIdentificacionDao fichaIdentificacionDao;

	private List<CatEntidadFederativa> entidades;
	private List<CatGrupoSanguineo> gruposSanguineos;

	private Paciente paciente;
	private Utilidades utilidades;

	@PostConstruct
	public void iniciar(){		
		utilidades = new Utilidades();
		setEntidades(fichaIdentificacionDao.obtenerEntidadesFederativas());
		setGruposSanguineos(fichaIdentificacionDao.obtenerGruposSanguineos());	
		
		obtenerFichaIdentificacion();
	}

	public void actualizarEdad(){
		paciente.setEdad(utilidades.calcularEdad(paciente.getFechaNacimiento()));
	}

	public void obtenerFichaIdentificacion() {
		if (getPaciente() == null){
			setPaciente(new Paciente());
		}
		if (getPaciente().getIdGrupoSanguineo()==null){
			getPaciente().setIdGrupoSanguineo(new CatGrupoSanguineo());
		}
		if (getPaciente().getEntidadFedereativa()==null){
			getPaciente().setEntidadFedereativa(new CatEntidadFederativa());				
		}
		if(getPaciente().getFechaCreacion()==null){
			getPaciente().setFechaCreacion(new Date());
		}
	}

	public String registrar(Long modo) {
		getPaciente().setDoctor(loginMB.getDoctor());
		//calcularEdad(paciente.getFechaNacimiento());
		actualizarEdad();
		fichaIdentificacionDao.registrarPaciente(paciente);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "Se guardó correctamente"));
	    
		obtenerFichaIdentificacion();
		
	    switch(modo.intValue()) {
		    case 1: 
				// ir a padecimiento actual 1ra vez
				return rutas.getString(Rutas.CONSULTA1_PA);
			case 2:
				// ir a padecimiento actual subsecuente
				return rutas.getString(Rutas.CONSULTA_SUB_PA);
			case 3:
				// ir a control de embarazo
				return rutas.getString(Rutas.CONSULTACE_SEG);
			case 4:
				// ir a fin de embarazo
				return rutas.getString(Rutas.CONSULTAFIN_CE);
			case 5: 
				// ir a antecedentes heredofamiliares en detalle de paciente
				return rutas.getString(Rutas.CONSULTA_DETALLE_AHF);
		    case 21:
		    	return rutas.getString(Rutas.INICIO_ASISTENTE);
		    case 23:
		    	return rutas.getString(Rutas.HISTORIAL_CONSULTAS_ASISTENTE);//detalle de paciente en asistente
		    default: 
		    	System.out.println("default " + modo);
		      return "";
	    }	      
	}

	public String cancelar() {
		setPaciente(new Paciente());
		getPaciente().setIdGrupoSanguineo(new CatGrupoSanguineo());
		getPaciente().setEntidadFedereativa(new CatEntidadFederativa());
		getPaciente().setFechaCreacion(new Date());
		
		return rutas.getString(Rutas.INICIO_MEDICO);
	}
	
	public String verDetalle(Long idPaciente, Long rol){		
		setPaciente(fichaIdentificacionDao.buscarFIDPorIdPaciente(idPaciente));
		obtenerFichaIdentificacion();

		switch(rol.intValue()){
			case 1:
				return rutas.getString(Rutas.CONSULTA_DETALLE_FID);
			case 2:
				return rutas.getString(Rutas.CONSULTA_ASISTENTE_DETALLE_FID);
			default:
				return "";
		}
	}

	/*ya con las consultas de la paciente, de la última consulta obtener q tipo de consulta fue si obstetrica
	 * o ginecologica y así ya sabemos si va a consulta subsecuente o a embarazo, si no hay consultas es q es primera vez*/
	public String iraConsulta(Long idPaciente){
		setPaciente(fichaIdentificacionDao.buscarFIDPorIdPacienteConConsultas(idPaciente));
		obtenerFichaIdentificacion();

		Set<PadecimientoActual> consultasPaciente = getPaciente().getConsultas();
		int modo = 0;
		if(!consultasPaciente.isEmpty()){
			Iterator<PadecimientoActual> it = consultasPaciente.iterator();
			while(it.hasNext()){
				PadecimientoActual consulta = it.next();				
				if(consulta.getTipoPaciente().getIdTipoPaciente().equals((long)2) && consulta.getFechaConsulta().equals(getPaciente().getFechaUltimaCita())){ //es paciente obstétrica?
					// ir a control de embarazo
					System.out.println("modo tres " + consulta.getTipoPaciente().getIdTipoPaciente() + " " + consulta.getFechaConsulta() + " " + getPaciente().getFechaUltimaCita());
					modo = 3; 
					return rutas.getString(Rutas.CONSULTACE_FID);
				}else{
					// ir a subsecuente normal
					System.out.println("modo dos " + consulta.getTipoPaciente().getIdTipoPaciente() + " " + consulta.getFechaConsulta() + " " + getPaciente().getFechaUltimaCita());
					modo = 2;
				}
			}
		}else{
			// ir a 1era vez
			modo = 1;
		}
		
		switch(modo) {
			case 1: 
				// ir a consulta 1ra vez
				return rutas.getString(Rutas.CONSULTA1_FID);
			case 2:
				// ir a consulta subsecuente
				return rutas.getString(Rutas.CONSULTA_SUB_FID);
			case 3: 
				// ir a control de embarazo
				return rutas.getString(Rutas.CONSULTACE_FID);
			case 4:
				// ir a fin de embarazo
				return rutas.getString(Rutas.CONSULTAFIN_FID);
			default: 
				return "";
		}				
	}
	
	public String iraFinEmbarazo(Long idPaciente){
		setPaciente(fichaIdentificacionDao.buscarFIDPorIdPaciente(idPaciente));	
		obtenerFichaIdentificacion();	
		
		return rutas.getString(Rutas.CONSULTAFIN_FID);
	}
	
	public String iraFIDAsistente(Long idPaciente){
		obtenerFichaIdentificacion();
		setPaciente(fichaIdentificacionDao.buscarFIDPorIdPaciente(idPaciente));

		return rutas.getString(Rutas.CONSULTA1_ASISTENTE_FID);
	}
	
	public LoginMB getLogin() {
		return loginMB;
	}

	public List<CatEntidadFederativa> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<CatEntidadFederativa> entidades) {
		this.entidades = entidades;
	}

	public List<CatGrupoSanguineo> getGruposSanguineos() {
		return gruposSanguineos;
	}

	public void setGruposSanguineos(List<CatGrupoSanguineo> gruposSanguineos) {
		this.gruposSanguineos = gruposSanguineos;
	}	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}