package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySVista;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysVistaMB extends BaseController  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySVista iaysVista;
	
	@PostConstruct
	public void iaysVista(){
		paciente = fimb.getPaciente();
		obtenerIaysVista();
		
		System.out.println("Se realizó PostConstruct de IAyS Vista");
	}
	
	private void obtenerIaysVista(){
		iaysVista = iaysDao.buscarIaysVistaPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysVista == null){
			iaysVista = new IAySVista();
		}
	}

	public IAySVista getIaysVista() {
		return iaysVista;
	}

	public void setIaysVista(IAySVista iaysVista) {
		this.iaysVista = iaysVista;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Sintomas Generales " + iaysVista);
		iaysVista.setPaciente(paciente);
		iaysDao.registrarIaysVista(iaysVista);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_BAOF);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_BAOF);	  
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
