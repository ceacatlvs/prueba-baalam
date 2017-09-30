package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfNeurologicoDao;
import com.baalam.model.histclinica.ef.EFNeuroEMental;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfNeurologicoMB extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfNeurologicoDao efNEMDao;
	
	private PadecimientoActual pa;
	private EFNeuroEMental efNEM;
	
	@PostConstruct
	public void efNeurologicoEM(){
		setPa(pamb.getPadecimientoActual());
		obtenerNeurologicoEM();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Neurologico");
	}
	
	private void obtenerNeurologicoEM(){
		setEfNEM(efNEMDao.buscarEFNeuroEMentalPorIdConsulta(pa.getIdConsulta()));
		
		if(efNEM == null){
			efNEM = new EFNeuroEMental();
		}
	}

	@Override
	public String registrar(Long modo) {
		efNEM.setPadecimientoActual(pa);
		efNEMDao.registrarEfNeuroEMental(efNEM);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_GINECO);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_GINECO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_GINECO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_GINECO);
		      default: 
		          return "";
		}
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFNeuroEMental getEfNEM() {
		return efNEM;
	}
	public void setEfNEM(EFNeuroEMental efNEM) {
		this.efNEM = efNEM;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}