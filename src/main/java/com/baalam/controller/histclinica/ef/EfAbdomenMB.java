package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfAbdomenDao;
import com.baalam.model.histclinica.ef.EFAbdomen;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfAbdomenMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfAbdomenDao efAbdomenDao;
	
	private PadecimientoActual pa;
	private EFAbdomen efAbdomen;
	
	@PostConstruct
	public void efAbdomen(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfAbdomen();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Abdomen");
	}
	
	private void obtenerEfAbdomen(){
		setEfAbdomen(efAbdomenDao.buscarEFAbdomenPorIdConsulta(pa.getIdConsulta()));
		
		if(efAbdomen == null){
			efAbdomen = new EFAbdomen();
		}
	}

	@Override
	public String registrar(Long modo) {
		efAbdomen.setPadecimientoActual(pa);
		efAbdomenDao.registrarEfAbdomen(efAbdomen);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_LINFA);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_LINFA);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_LINFA);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_LINFA);
		      default: 
		          return "";
		}		
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFAbdomen getEfAbdomen() {
		return efAbdomen;
	}
	public void setEfAbdomen(EFAbdomen efAbdomen) {
		this.efAbdomen = efAbdomen;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}