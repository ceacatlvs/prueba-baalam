package com.baalam.controller.histclinica;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.dao.histclinica.TratamientoDao;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.model.histclinica.tratamiento.Tratamiento;
import com.baalam.model.histclinica.tratamiento.TratamientoFarmacos;
import com.baalam.util.Rutas;

@Named
@ConversationScoped
public class TratamientoMB extends BaseController {
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private ImpresionDiagnosticaMB idmb;
	
	@Inject
	private TratamientoDao trataDao;
	
	private Tratamiento tratamiento;
	private TratamientoFarmacos farmaco;
	
	private PadecimientoActual pa;
	
	private List<TratamientoFarmacos> farmacos; 
	
	@PostConstruct
	public void collectorFarmacos() {
		farmaco = new TratamientoFarmacos();
		farmacos = new ArrayList<TratamientoFarmacos>();
		
		setPa(pamb.getPadecimientoActual());
		
		obtenerTratamiento();
	}
	
	public String reinit() {
		farmaco = new TratamientoFarmacos();
		
		return null;
	}
	
	private void obtenerTratamiento(){
		setTratamiento(trataDao.buscarTratamientoPorIdConsulta(pa.getIdConsulta()));
		
		if(getTratamiento() == null){
			setTratamiento(new Tratamiento());
			getTratamiento().setProximaCita(idmb.getId().getProximaVisita());
		}
		
		setFarmacos(trataDao.obtenerFarmacosPorIdConsulta(pa.getIdConsulta()));
	}
	
	/*
	 * modo	1 -> 1era vez
	 * 		2 -> subsecuente
	 * 		3 -> detalle 1era
	 * 		4 -> detalle sub
	 * */
	@Override
	public String registrar(Long modo){
		PadecimientoActual pa = pamb.getPadecimientoActual();
		
		tratamiento.setPadecimientoActual(pa);
		trataDao.registrarTratamiento(tratamiento);
		
		registrarFarmacos();
		
		switch(modo.intValue()) {
			case 1: 
				if(pa.getTipoPaciente().getIdTipoPaciente() == 2){
					// ir a control de embarazo, consulta 1ra vez
	    			return rutas.getString(Rutas.CONSULTA1_CE_SEG);
	    		}else{
	    			// ir a inicio de médico, terminar consulta 1ra vez
	    			//return rutas.getString(Rutas.INICIO_MEDICO);
	    			return "";
	    		}
			case 2: 
				// ir a inicio de médico, terminar consulta subsecuente
				//return rutas.getString(Rutas.INICIO_MEDICO);
				return "";
			case 3:
				if(pa.getTipoPaciente().getIdTipoPaciente() == 2){
					// ir a detalle de control de embarazo, consulta 1ra vez
	    			return rutas.getString(Rutas.CONSULTA1_CE_SEG);
	    		}else{
	    			// ir a historial de consultas, terminar detalle consulta 1ra vez
	    			return rutas.getString(Rutas.HISTORIAL_CONSULTAS);
	    		}
			case 4:
				// ir a historial de consultas, terminar detalle consulta subsecuente 
				return rutas.getString(Rutas.HISTORIAL_CONSULTAS);
	      default: 
	          return "";
		}		
	}
	
	public void registrarFarmacos(){
		List<TratamientoFarmacos> farmacosAborrar = trataDao.obtenerFarmacosPorIdConsulta(pa.getIdConsulta());
		
		for(TratamientoFarmacos farmacoBorrar : farmacosAborrar){
			trataDao.borrarFarmacoTratamiento(farmacoBorrar);
		}
	
		for(TratamientoFarmacos farmaco : farmacos){
			farmaco.setPadecimientoActual(pa);
			trataDao.registrarTratamientoFarmacos(farmaco);
		}
	}
	
	public String cancelar(){
		return null;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}
	
	public Tratamiento getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	public TratamientoFarmacos getFarmaco() {
		return farmaco;
	}
	public void setFarmaco(TratamientoFarmacos farmaco) {
		this.farmaco = farmaco;
	}

	public List<TratamientoFarmacos> getFarmacos() {
		return farmacos;
	}
	public void setFarmacos(List<TratamientoFarmacos> farmacos) {
		this.farmacos = farmacos;
	}	
}