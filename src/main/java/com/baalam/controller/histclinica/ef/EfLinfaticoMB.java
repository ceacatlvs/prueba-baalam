package com.baalam.controller.histclinica.ef;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfLinfaticoDao;
import com.baalam.model.histclinica.ef.EFLinfatico;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfLinfaticoMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfLinfaticoDao efLinfaDao;
	
	private PadecimientoActual pa;
	private EFLinfatico efLinfa;
	
	@PostConstruct
	public void efLinfatico(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfLinfatico();
		
		System.out.println("Se realizó PostConstruct de Exploración Física Linfatico");
	}
	
	private void obtenerEfLinfatico(){
		setEfLinfa(efLinfaDao.buscarEFLinfaticoPorIdConsulta(pa.getIdConsulta()));
		
		if(efLinfa == null){
			efLinfa = new EFLinfatico();
		}
	}

	@Override
	public String registrar(Long modo) {
		efLinfa.setPadecimientoActual(pa);
		efLinfaDao.registrarEfLinfatico(efLinfa);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_PIEL);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_PIEL);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_PIEL);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_PIEL);
		      default: 
		          return "";
		}
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public EFLinfatico getEfLinfa() {
		return efLinfa;
	}
	public void setEfLinfa(EFLinfatico efLinfa) {
		this.efLinfa = efLinfa;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
}