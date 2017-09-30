package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpDensitometriaDao;
import com.baalam.model.histclinica.ep.EPDensitometria;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpDensitometriaMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpDensitometriaDao epDensiDao;
	
	private PadecimientoActual pa;
	private EPDensitometria epDensi;
	
	@PostConstruct
	public void epDensitometria(){
		pa = pamb.getPadecimientoActual();
		
		obtenerEpDensitometria();
	}
	
	private void obtenerEpDensitometria(){
		epDensi = epDensiDao.buscarEPDensitometriaPorIdConsulta(pa.getIdConsulta());
		
		if(epDensi == null){
			epDensi = new EPDensitometria();
		}
	}
	
	public EPDensitometria getEpDensi() {
		return epDensi;
	}
	public void setEpDensi(EPDensitometria epDensi) {
		this.epDensi = epDensi;
	}

	@Override
	public String registrar(Long modo){
		epDensi.setPadecimientoActual(pa);
		epDensiDao.registrarEpDensitometria(epDensi);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_OTROS);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_OTROS);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_OTROS);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_OTROS);
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