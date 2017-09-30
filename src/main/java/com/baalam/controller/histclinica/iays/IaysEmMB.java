package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySEsferaMental;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysEmMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySEsferaMental iaysEM;
	
	@PostConstruct
	public void iaysEsferaMental() {
		paciente = fimb.getPaciente();
		obtenerIaysME();		
		
		System.out.println("Se realizó PostConstruct de IAyS Esfera Mental ");
	}

	private void obtenerIaysME() {
		iaysEM = iaysDao.buscarIaysEsfMentalPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysEM == null){
			iaysEM = new IAySEsferaMental();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySEsferaMental getIaysEM() {
		return iaysEM;
	}

	public void setIaysEM(IAySEsferaMental iaysEM) {
		this.iaysEM = iaysEM;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Esfera Mental " + iaysEM);
			
		iaysEM.setPaciente(paciente);
		iaysDao.registrarIaysEsfMental(iaysEM);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_ENDO);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_ENDO);	  
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