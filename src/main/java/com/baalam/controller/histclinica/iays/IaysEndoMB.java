package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySEndocrino;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysEndoMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySEndocrino iaysEndo;
	
	@PostConstruct
	public void iaysEndocrino() {
		paciente = fimb.getPaciente();
		obtenerIaysEndo();		
		
		System.out.println("Se realizó PostConstruct de IAyS Endocrino ");
	}

	private void obtenerIaysEndo() {
		iaysEndo = iaysDao.buscarIaysEndoPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysEndo == null){
			iaysEndo = new IAySEndocrino();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySEndocrino getIaysEndo() {
		return iaysEndo;
	}

	public void setIaysEndo(IAySEndocrino iaysEndo) {
		this.iaysEndo = iaysEndo;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Esfera Mental " + iaysEndo);
			
		iaysEndo.setPaciente(paciente);
		iaysDao.registrarIaysEndo(iaysEndo);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_HyL);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_HyL);	  
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