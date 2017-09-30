package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpVHDao;
import com.baalam.model.histclinica.ep.EPVdrlHiv;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpVdrlVIHMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpVHDao epVHDao;
	
	private PadecimientoActual pa;
	private EPVdrlHiv epVH;

	@PostConstruct
	public void epVDRL() {
		pa = pamb.getPadecimientoActual();
		System.out.println("la consulta es " + pa.getIdConsulta());
		obtenerEpVH();
		
		System.out.println("Se realizó PostConstruct de Estudios Previos VDRL");
	}
	
	private void obtenerEpVH(){
		epVH = epVHDao.buscarEPVHPorIdConsulta(pa.getIdConsulta());
		
		System.out.println("epVH " + epVH);
		
		if(epVH == null){
			epVH = new EPVdrlHiv();
		}
	}

	public EPVdrlHiv getEpVH() {
		return epVH;
	}

	public void setEpVH(EPVdrlHiv epVH) {
		this.epVH = epVH;
	}
	
	@Override
	public String registrar(Long modo){
		System.out.println("register EP VDRL VIH " + epVH);
		
		epVH.setPadecimientoActual(pa);
		epVHDao.registrarEpVH(epVH);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_EGO);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_EGO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_EGO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_EGO);
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
