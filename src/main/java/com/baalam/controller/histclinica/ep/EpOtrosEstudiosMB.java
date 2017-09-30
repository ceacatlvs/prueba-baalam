package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpOtrosDao;
import com.baalam.model.histclinica.ep.EPOtrosEstudios;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpOtrosEstudiosMB extends BaseController{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpOtrosDao epOtrosDao;
	
	private PadecimientoActual pa;
	private EPOtrosEstudios epOtros;
	
	@PostConstruct
	public void epOtrosEstudios(){
		pa = pamb.getPadecimientoActual();
		
		obtenerEpOtrosEstudios();
	}
	
	private void obtenerEpOtrosEstudios(){
		epOtros = epOtrosDao.buscarEPOtrosPorIdConsulta(pa.getIdConsulta());
		
		if(epOtros == null){
			epOtros = new EPOtrosEstudios();
		}
	}
	
	public EPOtrosEstudios getEpOtros() {
		return epOtros;
	}
	public void setEpOtros(EPOtrosEstudios epOtros) {
		this.epOtros = epOtros;
	}
	
	@Override
	public String registrar(Long modo){
		epOtros.setPadecimientoActual(pa);
		epOtrosDao.registrarEpOtros(epOtros);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_ID);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_ECC);
			case 3:
				return rutas.getString(Rutas.DETALLE1_ID);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_ECC);
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