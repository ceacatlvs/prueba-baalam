package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpMamografiaDao;
import com.baalam.model.histclinica.ep.EPMamas;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpMamografiaMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpMamografiaDao epMamoDao;
	
	private PadecimientoActual pa;
	private EPMamas epMamas;
	
	@PostConstruct
	public void epMamografia(){
		pa = pamb.getPadecimientoActual();
		
		obtenerEpUltrasonido();
	}
	
	private void obtenerEpUltrasonido(){
		epMamas = epMamoDao.buscarEPMamografiaPorIdConsulta(pa.getIdConsulta());
		
		if(epMamas == null){
			epMamas = new EPMamas();
		}
	}

	public EPMamas getEpMamas() {
		return epMamas;
	}
	public void setEpMamas(EPMamas epMamas) {
		this.epMamas = epMamas;
	}
	
	@Override
	public String registrar(Long modo){
		epMamas.setPadecimientoActual(pa);
		epMamoDao.registrarEpMamografia(epMamas);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_DENSI);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_DENSI);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_DENSI);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_DENSI);
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