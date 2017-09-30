package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpEGODao;
import com.baalam.model.histclinica.ep.EPEgo;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpEgoMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpEGODao epEGODao;
	
	private PadecimientoActual pa;
	private EPEgo epEGO;
	
	@PostConstruct
	public void epExGralOrina(){
		pa = pamb.getPadecimientoActual();
		System.out.println("la consulta es " + pa.getIdConsulta());
		obtenerEPEgo();
		
		System.out.println("Se realizó PostConstruct de Estudios Previos Examen Gral de Orina");
	}
	
	private void obtenerEPEgo(){
		epEGO = epEGODao.buscarEPEgoPorIdConsulta(pa.getIdConsulta());
		
		if(epEGO == null){
			epEGO = new EPEgo();
		}
	}

	public EPEgo getEpEGO() {
		return epEGO;
	}

	public void setEpEGO(EPEgo epEGO) {
		this.epEGO = epEGO;
	}
	
	@Override
	public String registrar(Long modo){	
		epEGO.setPadecimientoActual(pa);
		epEGODao.registrarEpEGO(epEGO);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_URO);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_URO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_URO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_URO);
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