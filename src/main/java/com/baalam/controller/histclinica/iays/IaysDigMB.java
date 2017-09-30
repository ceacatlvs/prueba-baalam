package com.baalam.controller.histclinica.iays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.histclinica.iays.IAySDao;
import com.baalam.model.histclinica.iays.IAySDigestivo;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class IaysDigMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private IAySDao iaysDao;
	
	private Paciente paciente;
	
	private IAySDigestivo iaysDig;
	
	@PostConstruct
	public void iaysDigestivo() {
		paciente = fimb.getPaciente();
		obtenerIaysDig();		
		
		System.out.println("Se realizó PostConstruct de IAyS Digestivo ");
	}

	private void obtenerIaysDig() {
		iaysDig = iaysDao.buscarIaysDigestivoPorIdPaciente(paciente.getIdPaciente());
		
		if(iaysDig == null){
			iaysDig = new IAySDigestivo();
		}		
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public IAySDigestivo getIaysDig() {
		return iaysDig;
	}

	public void setIaysDig(IAySDigestivo iaysDig) {
		this.iaysDig = iaysDig;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register IAyS Digestivo " + iaysDig);
			
		iaysDig.setPaciente(paciente);
		iaysDao.registrarIaysDigestivo(iaysDig);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_IAyS_GENI);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_IAyS_GENI);	  
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