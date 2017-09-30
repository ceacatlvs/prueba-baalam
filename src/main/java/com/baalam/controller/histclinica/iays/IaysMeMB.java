package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySMuscEsqueletico;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysMeMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySMuscEsqueletico iaysME;
	
	@PostConstruct
	public void iaysMusculoEsqueletico() {
		paciente = fimb.getPaciente();
		obtenerIaysME();		
		
		System.out.println("Se realizó PostConstruct de IAyS Musculo Esqueletico ");
	}

	private void obtenerIaysME() {
		iaysME = iaysDao.buscarIaysMePorIdPaciente(paciente.getIdPaciente());
		
		if(iaysME == null){
			iaysME = new IAySMuscEsqueletico();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySMuscEsqueletico getIaysME() {
		return iaysME;
	}

	public void setIaysME(IAySMuscEsqueletico iaysME) {
		this.iaysME = iaysME;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Musculo Esqueletico " + iaysME);
			
		iaysME.setPaciente(paciente);
		iaysDao.registrarIaysMe(iaysME);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_NEURO);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_NEURO);	  
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