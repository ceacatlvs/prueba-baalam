package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfRespiratorioDao;
import com.baalam.model.histclinica.ef.EFRespiratorio;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfRespiratorioMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfRespiratorioDao efRespDao;
	
	private PadecimientoActual pa;
	private EFRespiratorio efResp;
	
	@PostConstruct
	public void efRespiratorio(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfRespiratorio();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Respiratorio");
	}
	
	private void obtenerEfRespiratorio(){
		setEfSV(efRespDao.buscarEFRespiratorioPorIdConsulta(pa.getIdConsulta()));
		
		if(efResp == null){
			efResp = new EFRespiratorio();
		}
	}

	@Override
	public String registrar(Long modo) {
		efResp.setPadecimientoActual(pa);
		efRespDao.registrarEfRespiratorio(efResp);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_CARDIO);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_CARDIO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_CARDIO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_CARDIO);
		      default: 
		          return "";
		}
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFRespiratorio getEfResp() {
		return efResp;
	}
	public void setEfSV(EFRespiratorio efResp) {
		this.efResp = efResp;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}
