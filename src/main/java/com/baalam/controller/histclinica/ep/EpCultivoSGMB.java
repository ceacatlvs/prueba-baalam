package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpCSVDao;
import com.baalam.model.histclinica.ep.EPCultivoSG;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpCultivoSGMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpCSVDao epCSVDao;
	
	private PadecimientoActual pa;
	private EPCultivoSG epCSG;
	
	@PostConstruct
	public void epCultivoSecrecionesGeni(){
		pa = pamb.getPadecimientoActual();
		System.out.println("la consulta es " + pa.getIdConsulta());
		obtenerEpCSG();
		
		System.out.println("Se realizó PostConstruct de Estudios Previos Examen Gral de Orina");
	}
	
	private void obtenerEpCSG(){
		epCSG = epCSVDao.buscarEPCultivoSGPorIdConsulta(pa.getIdConsulta());
		
		if(epCSG == null){
			epCSG = new EPCultivoSG();
		}
	}
	
	public EPCultivoSG getEpCSG() {
		return epCSG;
	}
	public void setEpCSG(EPCultivoSG epCSG) {
		this.epCSG = epCSG;
	}
	
	@Override
	public String registrar(Long modo){
		epCSG.setPadecimientoActual(pa);
		epCSVDao.registrarEpBh(epCSG);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_CC);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_CC);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_CC);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_CC);
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