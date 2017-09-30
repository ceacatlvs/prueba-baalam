package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySCardiovascular;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysCardioMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	private IAySCardiovascular iaysCardio;
	
	@PostConstruct
	public void iaysCardiovascular() {
		paciente = fimb.getPaciente();
		obtenerIaysCardio();		
		
		System.out.println("Se realizó PostConstruct de IAyS Cardiovascular ");
	}

	private void obtenerIaysCardio() {
		iaysCardio = iaysDao.buscarIaysCVPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysCardio == null){
			iaysCardio = new IAySCardiovascular();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySCardiovascular getIaysCardio() {
		return iaysCardio;
	}

	public void setIaysCardio(IAySCardiovascular iaysCardio) {
		this.iaysCardio = iaysCardio;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Cardio " + iaysCardio);
			
		iaysCardio.setPaciente(paciente);
		iaysDao.registrarIAySCv(iaysCardio);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_RESP);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_RESP);	  
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