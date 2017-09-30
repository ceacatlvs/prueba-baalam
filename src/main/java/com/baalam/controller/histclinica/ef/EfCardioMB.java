package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfCardiovascularDao;
import com.baalam.model.histclinica.ef.EFCardiovascular;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfCardioMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfCardiovascularDao efCardioDao;
	
	private PadecimientoActual pa;
	private EFCardiovascular efCardio;
	
	@PostConstruct
	public void efCardiovascular(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfCardiovascular();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Cardiovascular");
	}
	
	private void obtenerEfCardiovascular(){
		setEfCardio(efCardioDao.buscarEFCardiovascularPorIdConsulta(pa.getIdConsulta()));
		
		if(efCardio == null){
			efCardio = new EFCardiovascular();
		}
	}

	@Override
	public String registrar(Long modo) {
		efCardio.setPadecimientoActual(pa);
		efCardioDao.registrarEfCardiovascular(efCardio);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_ABDOMEN);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_ABDOMEN);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_ABDOMEN);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_ABDOMEN);
		      default: 
		          return "";
		}	
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFCardiovascular getEfCardio() {
		return efCardio;
	}
	public void setEfCardio(EFCardiovascular efCardio) {
		this.efCardio = efCardio;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}