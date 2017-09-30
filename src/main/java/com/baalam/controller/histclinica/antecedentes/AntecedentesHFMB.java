package com.baalam.controller.histclinica.antecedentes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.antecedentes.AntecedentesHFDao;
import com.baalam.model.catalogo.CatEnfermedadesFamiliares;
import com.baalam.model.histclinica.ant.hf.AHFEnfFamiliares;
import com.baalam.model.histclinica.ant.hf.AHFFallecimiento;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;
import com.baalam.util.ValidadorCollectors;

/**
 * Este Managed Bean sirve para la pantalla de Antecedentes de HeredoFamiliares
 * Consiste en 2 secciones
 * 	La sección de los fallecimientos de familiares del paciente
 * 	La sección de las enfermedades de familiares del paciente
 */
@Named
@ViewAccessScoped
public class AntecedentesHFMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private FichaIdentificacionMB fimb;

	@Inject
	private AntecedentesHFDao ahfDao;

	private Paciente paciente;

	private boolean fHermanos;

	private int  hermanosMuertos;
	private int hermanosVivos;

	private List<AHFFallecimiento> fallecimientosHermanos;
	private List<AHFFallecimiento> listaHermanosVivos;
	private AHFFallecimiento fallecimientoMadre;
	private AHFFallecimiento fallecimientoPadre;

	private List<CatEnfermedadesFamiliares> catEnfermedadesFamiliares;
	private List<AHFEnfFamiliares> enfermedades;
	
	private AHFEnfFamiliares enfermedad;
	
	/**
	 * En este método se inicializarán los siguientes objetos justo después de construir el bean
	 *  -fHermanos
	 *  -hermanosMuertos
	 *  -hermanosVivos
	 *  -fallecimientosHermanos
	 *  -fallecimientoMadre
	 *  -fallecimientoPadre
	 *  -enfermedadesFamiliares
	 */
	@PostConstruct
	public void inicializar() {
		enfermedad = new AHFEnfFamiliares();
		enfermedades = new ArrayList<AHFEnfFamiliares>();
		
		setPaciente(fimb.getPaciente());		
		setCatEnfermedadesFamiliares(ahfDao.obtenerCatEnfermedades());
		
		obtenerFallecimientosFamiliares();				
		obtenerEnfFamiliares();
	}
	
	public String reinitEnfermedad() {
		enfermedad = new AHFEnfFamiliares();
		
		return null;
	} 

	public List<String> buscarEnfermedades(String enfermedad) {
		List<String> enfermedades = new ArrayList<String>();

		for(CatEnfermedadesFamiliares catEnferm: catEnfermedadesFamiliares){
			if(catEnferm.getDescripcion().toUpperCase().contains(enfermedad.toUpperCase())) {
				enfermedades.add(catEnferm.getDescripcion());
			}
		}
		return enfermedades;  
	}
	
	private void obtenerEnfFamiliares() {
		setEnfermedades(ahfDao.obtenerEnfermedadesFamiliaresPorIdPaciente(paciente.getIdPaciente()));
	}

	@Override
	public String registrar(Long modo) {
		ArrayList<String> ignorar = new ArrayList<String>();
		ignorar.add("paciente");
		
		if(!ValidadorCollectors.validar(enfermedad,ignorar)){
			FacesContext context = FacesContext.getCurrentInstance();  
			context.validationFailed();
			context.addMessage(null, new FacesMessage("", "Se detectaron datos sin guardar en la sección de enfermedades familiares, es necesario dar click en Agregar")); 
			return null;
		}
		
		registrarFallecimientosFamiliares();
		registrarEnfermedadesFamiliares();
		
		switch(modo.intValue()) {
		case 1: 
			return rutas.getString(Rutas.CONSULTA1_APNP);
		case 3: 
			return rutas.getString(Rutas.CONSULTA_DETALLE_APNP);	  
		default: 
			return "";
		}	
	}

	private void registrarEnfermedadesFamiliares() {
		List<AHFEnfFamiliares> enfermedadesABorrar = ahfDao.obtenerEnfermedadesFamiliaresPorIdPaciente(paciente.getIdPaciente());						
		
		for(AHFEnfFamiliares enfermedadBorrar : enfermedadesABorrar){			
			ahfDao.borrarEnfermedadesDePaciente(enfermedadBorrar);
		}
		
		for(AHFEnfFamiliares enfermedad : enfermedades){
			enfermedad.setPaciente(getPaciente());
			ahfDao.registrarEnfermedad(enfermedad);
		}		
	}

	private void registrarFallecimientosFamiliares() {
		List<AHFFallecimiento> fallecimientos = ponerFallecimientos(paciente);
		ahfDao.eliminarHermanosVivos(listaHermanosVivos);
		for(AHFFallecimiento fallecimiento : fallecimientos){
			ahfDao.registrarFallecimiento(fallecimiento);
		}
	}
	
	@Override
	public String cancelar() {
		return null;
	}
	
	/**
	 * Este método sirve para actualizar el numero de registros que se muestran en la 
	 * lista de hermanos fallecidos dependiendo de los hermanos muertos que se ingresan y el número total de hermanos
	 */
	public void actualizarFallecimientosHermanos(){
		int nuevos = fallecimientosHermanos.size()-getHermanosMuertos();
		if(nuevos > 0){
			for(int i = 0; i < nuevos; i++){
				fallecimientosHermanos.remove(0);
			}
		}else if(nuevos < 0){
			nuevos = Math.abs(nuevos);
			for(int i = 0; i < nuevos; i++){
				fallecimientosHermanos.add(new AHFFallecimiento());
			}
		}
	}
	
	/**
	 * Este método obtiene una lista de fallecimientos familiares (hermanos, padre y madre) del paciente
	 * , recorre la lista y por cada registro de fallecimiento los asigna a la lista de hermanos o al de madre o padre
	 */
	private void obtenerFallecimientosFamiliares() {

		List<AHFFallecimiento> fallecimientosFamiliaresDelPaciente = ahfDao.obtenerFallecimientosFamiliaresPorIdPaciente(paciente.getIdPaciente());

		// Se inicializan los fallecimientos, por si no se fueran a encontra sus registros en la base de datos.
		if(fallecimientosHermanos == null || fallecimientosHermanos.size() == 0){
			fallecimientosHermanos = new ArrayList<AHFFallecimiento>();
			listaHermanosVivos = new ArrayList<AHFFallecimiento>();
			fHermanos = false;
			hermanosMuertos = 0;
			hermanosVivos = 0;
		}
		if(fallecimientoMadre == null){
			fallecimientoMadre = new AHFFallecimiento();
			fallecimientoMadre.setFallecido(false);
			fallecimientoMadre.setParentesco("Madre");
		}
		if(fallecimientoPadre == null){
			fallecimientoPadre = new AHFFallecimiento();
			fallecimientoPadre.setFallecido(false);
			fallecimientoPadre.setParentesco("Padre");
		}
		// Se recorren los fallecimientos familiares para ponerlos clasificarlos por parentesco
		for (AHFFallecimiento fallecimientoFamiliar : fallecimientosFamiliaresDelPaciente){

			// si el fallecido es un hermano
			if(fallecimientoFamiliar.getParentesco()!=null && fallecimientoFamiliar.getParentesco().equalsIgnoreCase("Hermano")){
				// Si se tiene registro de hermanos vivos o fallecidos entonces debe mostrar la sección de los hermanos
				fHermanos=true;

				if(fallecimientoFamiliar.getFallecido().booleanValue()){
					fallecimientosHermanos.add(fallecimientoFamiliar);
					hermanosMuertos++;
				}else{
					listaHermanosVivos.add(fallecimientoFamiliar);
					hermanosVivos++;
				}
			}
			// si la fallecida es su madre
			else if(fallecimientoFamiliar.getParentesco()!=null && fallecimientoFamiliar.getParentesco().equalsIgnoreCase("Madre")){
				fallecimientoMadre = fallecimientoFamiliar; 
			}
			//si el fallecido es su padre
			else if(fallecimientoFamiliar.getParentesco()!=null && fallecimientoFamiliar.getParentesco().equalsIgnoreCase("Padre")){
				fallecimientoPadre = fallecimientoFamiliar;
			}
		}
	}
	
	/**
	 * Se ponen todos los fallecimientos en la misma lista, para después guardarla
	 * 	  @param paciente
	 */
	private List<AHFFallecimiento> ponerFallecimientos(Paciente paciente) {

		List <AHFFallecimiento> fallecimientos = new ArrayList<AHFFallecimiento>();
		fallecimientoMadre.setPaciente(paciente);
		fallecimientoPadre.setPaciente(paciente);
		if (fHermanos){
			for(AHFFallecimiento hermano : fallecimientosHermanos){
				hermano.setPaciente(paciente);
				hermano.setFallecido(true);
				hermano.setParentesco("Hermano");
			}

			for(int i = 0; i < hermanosVivos; i++){
				AHFFallecimiento hermano = new AHFFallecimiento();
				hermano.setParentesco("Hermano");
				hermano.setFallecido(false);
				hermano.setPaciente(paciente);
				fallecimientos.add(hermano);
			}
			fallecimientos.addAll(fallecimientosHermanos);
		}
		fallecimientos.add(fallecimientoMadre);
		fallecimientos.add(fallecimientoPadre);
		return fallecimientos;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public boolean isfHermanos() {
		return fHermanos;
	}
	public void setfHermanos(boolean fHermanos) {
		this.fHermanos = fHermanos;
	}

	public int getHermanosMuertos() {
		return hermanosMuertos;
	}
	public void setHermanosMuertos(int hermanosMuertos) {
		this.hermanosMuertos = hermanosMuertos;
	}

	public int getHermanosVivos() {
		return hermanosVivos;
	}
	public void setHermanosVivos(int hermanosVivos) {
		this.hermanosVivos = hermanosVivos;
	}

	public List<AHFFallecimiento> getFallecimientosHermanos() {
		return fallecimientosHermanos;
	}
	public void setFallecimientosHermanos(List<AHFFallecimiento> fallecimientosHermanos) {
		this.fallecimientosHermanos = fallecimientosHermanos;
	}

	public AHFFallecimiento getFallecimientoMadre() {
		return fallecimientoMadre;
	}
	public void setFallecimientoMadre(AHFFallecimiento fallecimientoMadre) {
		this.fallecimientoMadre = fallecimientoMadre;
	}

	public AHFFallecimiento getFallecimientoPadre() {
		return fallecimientoPadre;
	}
	public void setFallecimientoPadre(AHFFallecimiento fallecimientoPadre) {
		this.fallecimientoPadre = fallecimientoPadre;
	}

	public List<AHFEnfFamiliares> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(List<AHFEnfFamiliares> enfermedades) {
		this.enfermedades = enfermedades;
	}

	public AHFEnfFamiliares getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(AHFEnfFamiliares enfermedad) {
		this.enfermedad = enfermedad;
	}

	public List<CatEnfermedadesFamiliares> getCatEnfermedadesFamiliares() {
		return catEnfermedadesFamiliares;
	}
	public void setCatEnfermedadesFamiliares(List<CatEnfermedadesFamiliares> catEnfermedadesFamiliares) {
		this.catEnfermedadesFamiliares = catEnfermedadesFamiliares;
	} 
}