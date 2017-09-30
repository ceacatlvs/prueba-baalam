package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySSintomasGenerales;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaySSgMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private IAySSintomasGenerales iaysSG;

	private Paciente paciente;
	
	@PostConstruct
	public void iaysSintoGrales() {
		paciente = fimb.getPaciente();
		obtenerIaysSG();		
		
		System.out.println("Se realizó PostConstruct de IAyS Sintomas Generales ");
	}
	
	private void obtenerIaysSG(){
		iaysSG = iaysDao.buscarIaysSGPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysSG == null){
			iaysSG = new IAySSintomasGenerales();
		}
	}
	
	public IAySSintomasGenerales getIaysSG() {
		return iaysSG;
	}

	public void setIaysSG(IAySSintomasGenerales iaysSG) {
		this.iaysSG = iaysSG;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Sintomas Generales " + iaysSG);
			
		iaysSG.setPaciente(paciente);
		iaysDao.registrarIaysSG(iaysSG);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_VISTA);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_VISTA);	  
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