package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpCitologiaCDao;
import com.baalam.model.histclinica.ep.EPCitologiaCervical;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpCitologiaCMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpCitologiaCDao epCCDao;
	
	private PadecimientoActual pa;
	private EPCitologiaCervical epCC;
	
	@PostConstruct
	public void epCitologiaCervical(){
		pa = pamb.getPadecimientoActual();
		System.out.println("la consulta es " + pa.getIdConsulta());
		obtenerEpCC();
	}
	
	private void obtenerEpCC(){
		epCC = epCCDao.buscarEPCCPorIdConsulta(pa.getIdConsulta());
		
		if(epCC == null){
			epCC = new EPCitologiaCervical();
		}
	}

	public EPCitologiaCervical getEpCC() {
		return epCC;
	}

	public void setEpCC(EPCitologiaCervical epCC) {
		this.epCC = epCC;
	}
	
	@Override
	public String registrar(Long modo){
		epCC.setPadecimientoActual(pa);
		epCCDao.registrarEpBh(epCC);
		
		switch(modo.intValue()) {
	    	case 1: 
	    		return rutas.getString(Rutas.CONSULTA1_EP_COLP);
	    	case 2: 
	    		return rutas.getString(Rutas.CONSULTA_SUB_EP_COLP);
	    	case 3:
	    		return rutas.getString(Rutas.DETALLE1_EP_COLP);
	    	case 4:
	    		return rutas.getString(Rutas.DETALLE_SUB_EP_COLP);
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