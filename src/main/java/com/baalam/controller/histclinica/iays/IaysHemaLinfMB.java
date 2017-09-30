package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySHematopoyetico;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysHemaLinfMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySHematopoyetico iaysHema;
	
	@PostConstruct
	public void iaysGenitourinario() {
		paciente = fimb.getPaciente();
		obtenerIaysGeni();		
		
		System.out.println("Se realizó PostConstruct de IAyS Hematopoyetico y Linfatico");
	}

	private void obtenerIaysGeni() {
		iaysHema = iaysDao.buscarIaysHemaLinfaPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysHema == null){
			iaysHema = new IAySHematopoyetico();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySHematopoyetico getIaysHema() {
		return iaysHema;
	}

	public void setIaysHema(IAySHematopoyetico iaysHema) {
		this.iaysHema = iaysHema;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Hematopoyetico y Linfatico " + iaysHema);
			
		iaysHema.setPaciente(paciente);
		iaysDao.registrarIaysHemaLinfa(iaysHema);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_PIEL);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_PIEL);	  
	      default: 
	          return "";
		}	
	}
	
	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
}