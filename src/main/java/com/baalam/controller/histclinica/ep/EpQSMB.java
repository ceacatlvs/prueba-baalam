package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EPQuimicaSanguineaDao;
import com.baalam.model.histclinica.ep.EPQuimicaSanguiena;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpQSMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EPQuimicaSanguineaDao epQsDao;
	
	private PadecimientoActual pa;
	private EPQuimicaSanguiena epQS;
	
	@PostConstruct
	public void epQuimSang(){
		pa = pamb.getPadecimientoActual();
		obtenerEPQS();
		
		System.out.println("Se realizó PostConstruct de Estudios Previos Biometria Hemática");
	}
	
	private void obtenerEPQS(){
		epQS = epQsDao.buscarEPQSPorIdConsulta(pa.getIdConsulta());
		
		if(epQS == null){
			epQS = new EPQuimicaSanguiena();
		}
	}

	public EPQuimicaSanguiena getEpQS() {
		return epQS;
	}

	public void setEpQS(EPQuimicaSanguiena epQS) {
		this.epQS = epQS;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register EP QS " + epQS);
		
		epQS.setPadecimientoActual(pa);
		epQsDao.registrarEpBh(epQS);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_VDRL);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_VDRL);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_VDRL);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_VDRL);
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