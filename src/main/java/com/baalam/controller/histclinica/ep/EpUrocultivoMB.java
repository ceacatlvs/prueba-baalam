package com.baalam.controller.histclinica.ep;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ep.EpUrocultivoDao;
import com.baalam.model.histclinica.ep.EPUrocultivo;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EpUrocultivoMB extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EpUrocultivoDao epUroDao;
	
	private PadecimientoActual pa;
	private EPUrocultivo epUro;
	
	@PostConstruct
	public void epUrocultivo(){
		pa = pamb.getPadecimientoActual();

		obtenerEPUrocultivo();
		
		System.out.println("Se realizó PostConstruct de Estudios Previos Examen Gral de Orina");
	}
	
	public void obtenerEPUrocultivo(){
		epUro = epUroDao.buscarEPUroorIdConsulta(pa.getIdConsulta());
		
		if(epUro == null){
			epUro = new EPUrocultivo();
		}
	}
	
	public EPUrocultivo getEpUro() {
		return epUro;
	}
	public void setEpUro(EPUrocultivo epUro) {
		this.epUro = epUro;
	}
	
	@Override
	public String registrar(Long modo){
		epUro.setPadecimientoActual(pa);
		epUroDao.registrarEpEGO(epUro);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_CSV);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EP_CSV);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_CSV);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EP_CSV);
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