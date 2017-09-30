package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySNeurologico;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysNeuroMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySNeurologico iaysNeuro;
	
	@PostConstruct
	public void iaysNeurologico() {
		paciente = fimb.getPaciente();
		obtenerIaysNeuro();		
		
		System.out.println("Se realizó PostConstruct de IAyS Neurologico ");
	}

	private void obtenerIaysNeuro() {
		iaysNeuro = iaysDao.buscarIaysNeurologicoPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysNeuro == null){
			iaysNeuro = new IAySNeurologico();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySNeurologico getIaysNeuro() {
		return iaysNeuro;
	}

	public void setIaysNeuro(IAySNeurologico iaysNeuro) {
		this.iaysNeuro = iaysNeuro;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Neurologico " + iaysNeuro);
			
		iaysNeuro.setPaciente(paciente);
		iaysDao.registrarIaysNeurologico(iaysNeuro);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_EM);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_EM);	  
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