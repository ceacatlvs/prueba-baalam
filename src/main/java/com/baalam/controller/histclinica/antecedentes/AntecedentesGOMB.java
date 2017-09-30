package com.baalam.controller.histclinica.antecedentes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.antecedentes.AntecedentesGODao;
import com.baalam.model.catalogo.CatAnticonceptivos;
import com.baalam.model.controlEmbarazo.CeFinEmbarazo;
import com.baalam.model.histclinica.ant.go.AGOAnticonceptivosActual;
import com.baalam.model.histclinica.ant.go.AGOAnticonceptivosPrevio;
import com.baalam.model.histclinica.ant.go.AGOGinecologica;
import com.baalam.model.histclinica.ant.go.AGOObstetrica;
import com.baalam.model.histclinica.ant.go.AGOOtrosAnticonceptivosActual;
import com.baalam.model.histclinica.ant.go.AGOOtrosAnticonceptivosPrevio;
import com.baalam.model.histclinica.ant.go.AGOPartos;
import com.baalam.model.histclinica.ant.go.AGOUltimosEstudios;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class AntecedentesGOMB extends BaseController {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Inject
	private FichaIdentificacionMB fimb;

	@Inject
	private AntecedentesGODao agoDao;
	
	private Paciente paciente;
	
	private boolean fOtraComplicacion;
	
	private AGOGinecologica histGinecologica;
	private AGOObstetrica histObstetrica;
	
	private AGOPartos parto;
	private List<AGOPartos> partos;
	
	private List<CatAnticonceptivos> catAnticonceptivos;
	
	private List<AGOAnticonceptivosPrevio> anticonceptivosPrevios;
	private AGOOtrosAnticonceptivosPrevio otroAnticonceptivoPrevio;
	private List<AGOOtrosAnticonceptivosPrevio> otrosAnticonceptivosPrevios;
	
	private List<AGOAnticonceptivosActual> anticonceptivosActuales;
	private AGOOtrosAnticonceptivosActual otroAnticonceptivoActual;
	private List<AGOOtrosAnticonceptivosActual> otrosAnticonceptivosActuales;
	
	private AGOUltimosEstudios ultimosEstudios;
	
	private CeFinEmbarazo finEmbarazo;
	
	@PostConstruct
	public void inicializar() {
		setPaciente(fimb.getPaciente());	
		setfOtraComplicacion(false);
		setHistGinecologica(agoDao.obtenerGinecologicaPorIdPaciente(getPaciente().getIdPaciente()));
		setHistObstetrica(agoDao.obtenerObstetricaPorIdPaciente(getPaciente().getIdPaciente()));
		setUltimosEstudios(agoDao.obtenerUltimosEstudiosPorIdPaciente(getPaciente().getIdPaciente()));
		setPartos(agoDao.obtenerPartosPorIdPaciente(getPaciente().getIdPaciente()));
		
		setCatAnticonceptivos(agoDao.obtenerCatAnticonceptivos());
		
		obtenerAnticonceptivos();
		
		parto = new AGOPartos();
		finEmbarazo = new CeFinEmbarazo();
	}
	
	private void obtenerAnticonceptivos() {
		
		setAnticonceptivosActuales(agoDao.obtenerAnticonceptivosActualesPorIdPaciente(getPaciente().getIdPaciente()));
		setAnticonceptivosPrevios(agoDao.obtenerAnticonceptivosPreviosPorIdPaciente(getPaciente().getIdPaciente())); 
		
		
		if(anticonceptivosActuales.isEmpty()){
			anticonceptivosActuales = new ArrayList<AGOAnticonceptivosActual>();
			
			for(int i = 0; i < catAnticonceptivos.size()-1; i++){
				AGOAnticonceptivosActual agoAntAct = new AGOAnticonceptivosActual();
				agoAntAct.setIdCatAnticonceptivos(catAnticonceptivos.get(i));
				anticonceptivosActuales.add(agoAntAct);
			}
		}
		
		if(anticonceptivosPrevios.isEmpty()){
			anticonceptivosPrevios = new ArrayList<AGOAnticonceptivosPrevio>();
			
			for(int i = 0; i < catAnticonceptivos.size()-1; i++){
				AGOAnticonceptivosPrevio agoAntPrev = new AGOAnticonceptivosPrevio();
				agoAntPrev.setIdCatAnticonceptivos(catAnticonceptivos.get(i));
				anticonceptivosPrevios.add(agoAntPrev);
			}
		}
		
		otrosAnticonceptivosPrevios = agoDao.obtenerOtrosAnticonceptivosPreviosPorIdPaciente(paciente.getIdPaciente());
		otroAnticonceptivoPrevio = new AGOOtrosAnticonceptivosPrevio();
		
		if(otrosAnticonceptivosPrevios.isEmpty()){
			otrosAnticonceptivosPrevios = new ArrayList<AGOOtrosAnticonceptivosPrevio>();
		}
			
		otrosAnticonceptivosActuales = agoDao.obtenerOtrosAnticonceptivosActualesPorIdPaciente(paciente.getIdPaciente());
		otroAnticonceptivoActual = new AGOOtrosAnticonceptivosActual();
		
		if(otrosAnticonceptivosActuales.isEmpty()){
			otrosAnticonceptivosActuales = new ArrayList<AGOOtrosAnticonceptivosActual>();
		}
	}

	public String reinitParto() {
		parto = new AGOPartos();
		fOtraComplicacion = false;
		
		return null;
	}
	
	public String reinitAnticonceptivoPrevio() {
		otroAnticonceptivoPrevio = new AGOOtrosAnticonceptivosPrevio();
		return null;
	}
	
	public String reinitAnticonceptivoActual() {
		otroAnticonceptivoActual = new AGOOtrosAnticonceptivosActual();
		return null;
	}
	
	@Override
	public String registrar(Long modo) {

		getHistGinecologica().setPaciente(getPaciente());
		getHistObstetrica().setIdPaciente(getPaciente());
		getUltimosEstudios().setPaciente(getPaciente());
		
		agoDao.registraGinecologica(getHistGinecologica());
		agoDao.registraObstetrica(getHistObstetrica());
		
		registrarAnticonceptivosActuales();
		registrarAnticonceptivosPrevios();
		
		agoDao.registrarUltimosEstudios(getUltimosEstudios());
		
		for(AGOPartos partoReg: partos){
			partoReg.setPaciente(paciente);
			agoDao.registrarParto(partoReg);
		}
		/*agoDao.eliminarAnticonceptivosDePaciente(paciente);
		for(AGOAnticonceptivosActual anticon: todosAnticonseptivos){
			anticon.setPaciente(paciente);
			anticon.setIdAgoAnticonceptivosActual(null);
			agoDao.registrarAnticonceptivosActuales(anticon);
		}*/
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_SG);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_SG);	  
	      default: 
	          return "";
		}	
	}
	
	public void registrarAnticonceptivosActuales(){
		//CatAnticonceptivos caa = catAnticonceptivos.get(catAnticonceptivos.size()-1);
		List<AGOOtrosAnticonceptivosActual> oaaABorrar = agoDao.obtenerOtrosAnticonceptivosActualesPorIdPaciente(getPaciente().getIdPaciente());
		
		for(AGOOtrosAnticonceptivosActual oaaAnterior :  oaaABorrar){
			for(AGOOtrosAnticonceptivosActual oaa : otrosAnticonceptivosActuales){
				if(oaaAnterior.getIdAgoOtroAnticonceptivoActual() == oaa.getIdAgoOtroAnticonceptivoActual()){
					oaaABorrar.remove(oaaAnterior);
				}
			}
		}
		
		for(AGOAnticonceptivosActual antiActual :  anticonceptivosActuales){
			antiActual.setPaciente(getPaciente());
			agoDao.registrarAnticonceptivosActuales(antiActual);
		}
		
		for(AGOOtrosAnticonceptivosActual otroAntiActual : otrosAnticonceptivosActuales){
			otroAntiActual.setPaciente(getPaciente());
			agoDao.registrarOtrosAnticonceptivosActuales(otroAntiActual);
		}
		
		for(AGOOtrosAnticonceptivosActual antiActBorrar : oaaABorrar){
			agoDao.borrarOtrosAnticonceptivosActuales(antiActBorrar);
		}	
	}
	
	public void registrarAnticonceptivosPrevios(){
		List<AGOOtrosAnticonceptivosPrevio> oapABorrar = agoDao.obtenerOtrosAnticonceptivosPreviosPorIdPaciente(getPaciente().getIdPaciente());
		
		for(AGOOtrosAnticonceptivosPrevio oapAnterior :  oapABorrar){
			for(AGOOtrosAnticonceptivosPrevio oap : otrosAnticonceptivosPrevios){
				if(oapAnterior.getIdAgoOtroAnticonceptivoPrevio() == oap.getIdAgoOtroAnticonceptivoPrevio()){
					oapABorrar.remove(oapAnterior);
				}
			}
		}
		
		for(AGOAnticonceptivosPrevio antiPrevio :  anticonceptivosPrevios){
			antiPrevio.setPaciente(getPaciente());
			agoDao.registrarAnticonceptivosPrevios(antiPrevio);
		}
		
		for(AGOOtrosAnticonceptivosPrevio otroAntiPrevio : otrosAnticonceptivosPrevios){
			otroAntiPrevio.setPaciente(getPaciente());
			agoDao.registrarOtrosAnticonceptivosPrevios(otroAntiPrevio);
		}
		
		for(AGOOtrosAnticonceptivosPrevio antiPrevBorrar : oapABorrar){
			agoDao.borrarOtrosAnticonceptivosPrevios(antiPrevBorrar);
		}	
	}
	
	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub	
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public boolean isfOtraComplicacion() {
		return fOtraComplicacion;
	}
	public void setfOtraComplicacion(boolean fOtraComplicacion) {
		this.fOtraComplicacion = fOtraComplicacion;
	}

	public AGOPartos getParto() {
		return parto;
	}
	public void setParto(AGOPartos parto) {
		this.parto = parto;
	}

	public List<AGOPartos> getPartos() {
		return partos;
	}
	public void setPartos(List<AGOPartos> partos) {
		this.partos = partos;
	}

	public List<CatAnticonceptivos> getCatAnticonceptivos() {
		return catAnticonceptivos;
	}
	public void setCatAnticonceptivos(List<CatAnticonceptivos> catAnticonceptivos) {
		this.catAnticonceptivos = catAnticonceptivos;
	}

	public List<AGOAnticonceptivosPrevio> getAnticonceptivosPrevios() {
		return anticonceptivosPrevios;
	}
	public void setAnticonceptivosPrevios(List<AGOAnticonceptivosPrevio> anticonceptivosPrevios) {
		this.anticonceptivosPrevios = anticonceptivosPrevios;
	}

	public List<AGOAnticonceptivosActual> getAnticonceptivosActuales() {
		return anticonceptivosActuales;
	}
	public void setAnticonceptivosActuales(List<AGOAnticonceptivosActual> anticonceptivosActuales) {
		this.anticonceptivosActuales = anticonceptivosActuales;
	}

	public AGOOtrosAnticonceptivosPrevio getOtroAnticonceptivoPrevio() {
		return otroAnticonceptivoPrevio;
	}
	public void setOtroAnticonceptivoPrevio(AGOOtrosAnticonceptivosPrevio otroAnticonceptivoPrevio) {
		this.otroAnticonceptivoPrevio = otroAnticonceptivoPrevio;
	}

	public List<AGOOtrosAnticonceptivosPrevio> getOtrosAnticonceptivosPrevios() {
		return otrosAnticonceptivosPrevios;
	}
	public void setOtrosAnticonceptivosPrevios(List<AGOOtrosAnticonceptivosPrevio> otrosAnticonceptivosPrevios) {
		this.otrosAnticonceptivosPrevios = otrosAnticonceptivosPrevios;
	}

	public AGOOtrosAnticonceptivosActual getOtroAnticonceptivoActual() {
		return otroAnticonceptivoActual;
	}
	public void setOtroAnticonceptivoActual(AGOOtrosAnticonceptivosActual otroAnticonceptivoActual) {
		this.otroAnticonceptivoActual = otroAnticonceptivoActual;
	}

	public List<AGOOtrosAnticonceptivosActual> getOtrosAnticonceptivosActuales() {
		return otrosAnticonceptivosActuales;
	}
	public void setOtrosAnticonceptivosActuales(List<AGOOtrosAnticonceptivosActual> otrosAnticonceptivosActuales) {
		this.otrosAnticonceptivosActuales = otrosAnticonceptivosActuales;
	}

	public AGOGinecologica getHistGinecologica() {
		return histGinecologica;
	}
	public void setHistGinecologica(AGOGinecologica histGinecologica) {
		this.histGinecologica = histGinecologica;
	}

	public AGOObstetrica getHistObstetrica() {
		return histObstetrica;
	}
	public void setHistObstetrica(AGOObstetrica histObstetrica) {
		this.histObstetrica = histObstetrica;
	}

	public AGOUltimosEstudios getUltimosEstudios() {
		return ultimosEstudios;
	}
	public void setUltimosEstudios(AGOUltimosEstudios ultimosEstudios) {
		this.ultimosEstudios = ultimosEstudios;
	}
	
	public CeFinEmbarazo getFinEmbarazo() {
		return finEmbarazo;
	}
	public void setFinEmbarazo(CeFinEmbarazo finEmbarazo) {
		this.finEmbarazo = finEmbarazo;
	}
}