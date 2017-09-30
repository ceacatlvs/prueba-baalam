package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpUSGDao;
import com.baalam.model.histclinica.ep.EPUltrasonido;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpUltrasonidoMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpUSGDao epUsgDao;
	
	private PadecimientoActual pa;
	private EPUltrasonido epUSG;
	
	@PostConstruct
	public void epUltrasonido(){
		pa = pamb.getPadecimientoActual();
		
		obtenerEpUltrasonido();
	}
	
	private void obtenerEpUltrasonido(){
		epUSG = epUsgDao.buscarEPUltrasonidoPorIdConsulta(pa.getIdConsulta());
		
		if(epUSG == null){
			epUSG = new EPUltrasonido();
		}
	}
	
	@Override
	public String registrar(Long modo){
		epUSG.setPadecimientoActual(pa);
		epUsgDao.registrarEpUltrasonido(epUSG);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_MAMO);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_MAMO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_MAMO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_MAMO);
	      default: 
	          return "";
		}	
	}
	
	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EPUltrasonido getEpUSG() {
		return epUSG;
	}
	public void setEpUSG(EPUltrasonido epUSG) {
		this.epUSG = epUSG;
	}
}