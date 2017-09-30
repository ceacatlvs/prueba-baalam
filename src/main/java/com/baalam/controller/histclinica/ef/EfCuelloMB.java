package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfCuelloDao;
import com.baalam.model.histclinica.ef.EFCuello;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfCuelloMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfCuelloDao efCuelloDao;
	
	private PadecimientoActual pa;
	private EFCuello efCuello;
	
	@PostConstruct
	public void efCuello(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfCuello();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Cuello");
	}
	
	private void obtenerEfCuello(){
		setEfCuello(efCuelloDao.buscarEFCuelloPorIdConsulta(pa.getIdConsulta()));
		
		if(efCuello == null){
			efCuello = new EFCuello();
		}
	}

	@Override
	public String registrar(Long modo) {
		efCuello.setPadecimientoActual(pa);
		efCuelloDao.registrarEfCuello(efCuello);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_RESP);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_RESP);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_RESP);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_RESP);
		      default: 
		          return "";
		}
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public EFCuello getEfCuello() {
		return efCuello;
	}
	public void setEfCuello(EFCuello efCuello) {
		this.efCuello = efCuello;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}