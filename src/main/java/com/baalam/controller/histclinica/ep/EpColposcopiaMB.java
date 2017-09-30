package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpColposcopiaDao;
import com.baalam.model.histclinica.ep.EPColposcopia;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpColposcopiaMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpColposcopiaDao epColposDao;
	
	private PadecimientoActual pa;
	private EPColposcopia epColpos;
	
	@PostConstruct
	public void epColposcopia(){
		pa = pamb.getPadecimientoActual();
		
		System.out.println("Colposcopia consulta " + pa.getIdConsulta());
		
		obtenerEpColposcopia();
	}
	
	private void obtenerEpColposcopia(){
		epColpos = epColposDao.buscarEPColposcopiaPorIdConsulta(pa.getIdConsulta());
		
		if(epColpos == null){
			epColpos = new EPColposcopia();
		}
	}
	
	public EPColposcopia getEpColpos() {
		return epColpos;
	}
	public void setEpColpos(EPColposcopia epColpos) {
		this.epColpos = epColpos;
	}
	
	@Override
	public String registrar(Long modo){
		epColpos.setPadecimientoActual(pa);
		System.out.println("Colpos " + epColpos);
		epColposDao.registrarEpColposcopia(epColpos);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_USG);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_USG);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_USG);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_USG);
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
