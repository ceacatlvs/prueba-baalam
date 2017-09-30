package com.baalam.controller.histclinica.ads;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.AuxiliaresDiagnosticoDao;
import com.baalam.model.histclinica.ads.ADSGabinete;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class AdsGabineteMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private AuxiliaresDiagnosticoDao adsDao;
	
	private PadecimientoActual pa;
	private ADSGabinete adsGab;
	
	@PostConstruct
	public void adsLaboratorio(){
		pa = pamb.getPadecimientoActual();
		obtenerAdsGabinete();
	}
	
	private void obtenerAdsGabinete(){
		adsGab = adsDao.buscarADSGabinetePorIdConsulta(pa.getIdConsulta());
		
		if(adsGab == null){
			adsGab = new ADSGabinete();
		}
	}
	
	@Override
	public String registrar(Long modo) {
		System.out.println("register ADS Gabinete");
		
		adsGab.setPadecimientoActual(pa);
		adsDao.registrarADSGabinete(adsGab);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_AD_LAB);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_AD_LAB);
			case 3:
				return rutas.getString(Rutas.DETALLE1_AD_LAB);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_AD_LAB);
	      default: 
	          return "";
		}	
	}
	
	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
	}
	
	public ADSGabinete getAdsGab() {
		return adsGab;
	}
	public void setAdsGab(ADSGabinete adsGab) {
		this.adsGab = adsGab;
	}
}