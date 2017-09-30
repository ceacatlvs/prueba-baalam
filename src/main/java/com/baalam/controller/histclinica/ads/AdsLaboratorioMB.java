package com.baalam.controller.histclinica.ads;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.AuxiliaresDiagnosticoDao;
import com.baalam.model.histclinica.ads.ADSLaboratorio;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class AdsLaboratorioMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private AuxiliaresDiagnosticoDao adsDao;
	
	private PadecimientoActual pa;
	private ADSLaboratorio adsLab;
	
	@PostConstruct
	public void adsLaboratorio(){
		pa = pamb.getPadecimientoActual();
		obtenerAdsLaboratorio();
	}
	
	private void obtenerAdsLaboratorio(){
		adsLab = adsDao.buscarADSLaboratorioPorIdConsulta(pa.getIdConsulta());
		
		if(adsLab == null){
			adsLab = new ADSLaboratorio();
		}
	}

	@Override
	public String registrar(Long modo) {
		System.out.println("register ADS Laboratorio");
		
		adsLab.setPadecimientoActual(pa);
		adsDao.registrarADSLaboratorio(adsLab);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_TRATA);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_ID);
			case 3:
				return rutas.getString(Rutas.DETALLE1_TRATA);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_ID);
	      default: 
	          return "";
		}	
	}
	
	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public ADSLaboratorio getAdsLab() {
		return adsLab;
	}
	public void setAdsLab(ADSLaboratorio adsLab) {
		this.adsLab = adsLab;
	}
}