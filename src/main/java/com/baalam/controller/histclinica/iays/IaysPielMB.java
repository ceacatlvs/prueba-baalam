package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySPiel;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysPielMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySPiel iaysPiel;
	
	@PostConstruct
	public void iaysPiel() {
		paciente = fimb.getPaciente();
		obtenerIaysPiel();		
		
		System.out.println("Se realizó PostConstruct de IAyS Piel");
	}

	private void obtenerIaysPiel() {
		iaysPiel = iaysDao.buscarIaysPielPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysPiel == null){
			iaysPiel = new IAySPiel();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySPiel getIaysPiel() {
		return iaysPiel;
	}

	public void setIaysPiel(IAySPiel iaysPiel) {
		this.iaysPiel = iaysPiel;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Piel " + iaysPiel);
			
		iaysPiel.setPaciente(paciente);
		iaysDao.registrarIaysPiel(iaysPiel);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_MAMAS);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_MAMAS);	  
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