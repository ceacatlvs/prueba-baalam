package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfInspeccionGralDao;
import com.baalam.model.histclinica.ef.EFInspeccionGral;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfInspeccionGralMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfInspeccionGralDao efIGDao;
	
	private PadecimientoActual pa;
	private EFInspeccionGral efIG;
	
	@PostConstruct
	public void efInspeccionGral(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfInspeccionGral();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Inspeccion General");
	}
	
	private void obtenerEfInspeccionGral(){		
		setEfIG(efIGDao.buscarEFInspeccionGralPorIdConsulta(pa.getIdConsulta()));
		
		if(efIG == null){
			efIG = new EFInspeccionGral();
		}
	}

	@Override
	public String registrar(Long modo) {
		efIG.setPadecimientoActual(pa);
		efIGDao.registrarEfInspeccionGral(efIG);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_SV);	
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_SV);
		      default: 
		          return "";
		}
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFInspeccionGral getEfIG() {
		return efIG;
	}
	public void setEfIG(EFInspeccionGral efIG) {
		this.efIG = efIG;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}