package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySMamas;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysMamasMB extends BaseController {

	private static final long serialVersionUID = 1L;
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySMamas iaysMamas;
	
	@PostConstruct
	public void iaysMamas() {
		paciente = fimb.getPaciente();
		obtenerIaysGeni();		
		
		System.out.println("Se realizó PostConstruct de IAyS Hematopoyetico y Linfatico");
	}

	private void obtenerIaysGeni() {
		iaysMamas = iaysDao.buscarIaysMamasPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysMamas == null){
			iaysMamas = new IAySMamas();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySMamas getIaysMamas() {
		return iaysMamas;
	}

	public void setIaysMamas(IAySMamas iaysMamas) {
		this.iaysMamas = iaysMamas;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Mamas " + iaysMamas);
			
		iaysMamas.setPaciente(paciente);
		iaysDao.registrarIaysMamas(iaysMamas);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_EF_IG);
	      case 3: 
	    	  return rutas.getString(Rutas.HISTORIAL_CONSULTAS);	  
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