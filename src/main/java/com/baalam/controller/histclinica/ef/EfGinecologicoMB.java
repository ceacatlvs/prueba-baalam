package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfGinecologicoDao;
import com.baalam.model.histclinica.ef.EFGinecologico;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfGinecologicoMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfGinecologicoDao efGinecoDao;
	
	private PadecimientoActual pa;
	private EFGinecologico efGineco;
	
	@PostConstruct
	public void efGinecologico(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfGinecologico();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Ginecologico");
	}
	
	private void obtenerEfGinecologico(){
		setEfGineco(efGinecoDao.buscarEFGinecologicoPorIdConsulta(pa.getIdConsulta()));
		
		if(efGineco == null){
			efGineco = new EFGinecologico();
		}
	}


	@Override
	public String registrar(Long modo) {
		efGineco.setPadecimientoActual(pa);
		efGinecoDao.registrarEfGinecologico(efGineco);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EP_BH);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_AD_GAB);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EP_BH);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_AD_GAB);
		      default: 
		          return "";
		}
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFGinecologico getEfGineco() {
		return efGineco;
	}
	public void setEfGineco(EFGinecologico efGineco) {
		this.efGineco = efGineco;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}