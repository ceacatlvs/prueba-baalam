package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpBiometriaHematicaDao;
import com.baalam.model.histclinica.ep.EPBiometriaHematica;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpBHMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpBiometriaHematicaDao epBhDao;
	
	private PadecimientoActual pa;
	private EPBiometriaHematica epBH;
	
	@PostConstruct
	public void epBioHematica(){
		pa = pamb.getPadecimientoActual();
		System.out.println("la consulta es " + pa.getIdConsulta());
		obtenerEPBH();
		
		System.out.println("Se realizó PostConstruct de Estudios Previos Biometria Hemática");
	}
	
	private void obtenerEPBH(){
		epBH = epBhDao.buscarEPBHPorIdConsulta(pa.getIdConsulta());
		
		if(epBH == null){
			epBH = new EPBiometriaHematica();
		}
	}

	public PadecimientoActual getPa() {
		return pa;
	}

	public void setPa(PadecimientoActual pa) {
		this.pa = pa;
	}

	public EPBiometriaHematica getEpBH() {
		return epBH;
	}

	public void setEpBH(EPBiometriaHematica epBH) {
		this.epBH = epBH;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register EP BH " + epBH);
		
		epBH.setPadecimientoActual(pa);
		epBhDao.registrarEpBh(epBH);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_QS);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_QS);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_QS);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_QS);
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