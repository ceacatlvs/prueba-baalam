package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySBaof;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysBaofMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySBaof iaysBaof;

	@PostConstruct
	public void iaysBaof() {
		paciente = fimb.getPaciente();
		obtenerIaysBaof();		
		
		System.out.println("Se realizó PostConstruct de IAyS BAOF ");
	}
	
	private void obtenerIaysBaof() {
		iaysBaof = iaysDao.buscarIaysBaofPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysBaof == null){
			iaysBaof = new IAySBaof();
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySBaof getIaysBaof() {
		return iaysBaof;
	}

	public void setIaysBaof(IAySBaof iaysBaof) {
		this.iaysBaof = iaysBaof;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS BAOF " + iaysBaof);
			
		iaysBaof.setPaciente(paciente);
		iaysDao.registrarIaysBaof(iaysBaof);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_CARDIO);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_CARDIO);	  
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
