package com.baalam.controller.histclinica;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.dao.histclinica.EvolucionCuadroClinicoDao;
import com.baalam.model.histclinica.EvolucionCuadroClinico;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EvolucionCuadroClinicoMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private EvolucionCuadroClinicoDao eccDao;
	
	private EvolucionCuadroClinico ecc;
	private PadecimientoActual pa;

	@PostConstruct
	public void evolucionCuadroClinico() {
		setPa(pamb.getPadecimientoActual());
		obtenerECC();
	}
	
	private void obtenerECC(){
		ecc = eccDao.buscarECCPorIdConsulta(pa.getIdConsulta());
		
		if(ecc == null){
			ecc = new EvolucionCuadroClinico();
		}
	}
	
	@Override
	public String registrar(Long modo) {
		ecc.setPadecimientoActual(pa);
		eccDao.registrarECC(ecc);
		
		switch(modo.intValue()) {
		     /* case 1: 
		    	  System.out.println("case 1 consulta 1era vez");
		    	  return rutas.getString(Rutas.CONSULTA1_AHF);*/
		     case 2:
		    	  System.out.println("case 2 consulta subsecuente");
		    	  return rutas.getString(Rutas.CONSULTA_SUB_EF_CUELLO);
		     case 3: 
		    	  System.out.println("case 3 detalle historial");
		    	  return rutas.getString(Rutas.DETALLE_SUB_EF_CUELLO);	  
		      default: 
		          return "";
		}	
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public EvolucionCuadroClinico getEcc() {
		return ecc;
	}
	public void setEcc(EvolucionCuadroClinico ecc) {
		this.ecc = ecc;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}