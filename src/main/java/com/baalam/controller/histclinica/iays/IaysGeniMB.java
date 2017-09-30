package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySGenitourinario;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysGeniMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySGenitourinario iaysGeni;
	
	@PostConstruct
	public void iaysGenitourinario() {
		paciente = fimb.getPaciente();
		obtenerIaysGeni();		
		
		System.out.println("Se realizó PostConstruct de IAyS Genitourinario ");
	}

	private void obtenerIaysGeni() {
		iaysGeni = iaysDao.buscarIaysGUPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysGeni == null){
			iaysGeni = new IAySGenitourinario();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySGenitourinario getIaysGeni() {
		return iaysGeni;
	}

	public void setIaysGeni(IAySGenitourinario iaysGeni) {
		this.iaysGeni = iaysGeni;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Genitourinario " + iaysGeni);
			
		iaysGeni.setPaciente(paciente);
		iaysDao.registrarIaysGU(iaysGeni);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_ME);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_ME);	  
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