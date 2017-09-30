package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySRespiratorio;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysRespMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySRespiratorio iaysResp;
	
	@PostConstruct
	public void iaysRespiratorio() {
		paciente = fimb.getPaciente();
		obtenerIaysResp();		
		
		System.out.println("Se realizó PostConstruct de IAyS Respiratorio ");
	}

	private void obtenerIaysResp() {
		iaysResp = iaysDao.buscarIaysRespiratorioPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysResp == null){
			iaysResp = new IAySRespiratorio();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySRespiratorio getIaysResp() {
		return iaysResp;
	}

	public void setIaysResp(IAySRespiratorio iaysResp) {
		this.iaysResp = iaysResp;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Respiratorio " + iaysResp);
			
		iaysResp.setPaciente(paciente);
		iaysDao.registrarIaysRespiratorio(iaysResp);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_DIG);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_DIG);	  
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