package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfPielDao;
import com.baalam.model.histclinica.ef.EFPiel;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfPielMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfPielDao efPielDao;
	
	private PadecimientoActual pa;
	private EFPiel efPiel;
	
	@PostConstruct
	public void efPiel(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfPiel();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Piel");
	}
	
	private void obtenerEfPiel(){
		setEfPiel(efPielDao.buscarEFPielPorIdConsulta(pa.getIdConsulta()));
		
		if(efPiel == null){
			efPiel = new EFPiel();
		}
	}

	@Override
	public String registrar(Long modo) {
		efPiel.setPadecimientoActual(pa);
		efPielDao.registrarEfPiel(efPiel);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_NEURO);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_NEURO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_NEURO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_NEURO);
		      default: 
		          return "";
		}	
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFPiel getEfPiel() {
		return efPiel;
	}
	public void setEfPiel(EFPiel efPiel) {
		this.efPiel = efPiel;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}