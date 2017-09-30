package com.baalam.controller.controlEmbarazo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.dao.controlEmbarazo.CeLaboratorioDao;
import com.baalam.dao.histclinica.TratamientoDao;
import com.baalam.model.controlEmbarazo.CeLaboratorio;
import com.baalam.model.controlEmbarazo.ControlEmbarazo;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class CeLaboratorioMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CeSeguimientoMB cemb;
	
	@Inject
	private CeLaboratorioDao ceLabDao;
	
	@Inject
	private TratamientoDao trataDao;
	
	private CeLaboratorio laboratorio;
	private ControlEmbarazo ce;
	
	private List<CeLaboratorio> laboratorios;
	
	@PostConstruct
	public void collectorUltrasonidos() {
		setCe(cemb.getCe());
		
		obtenerCeLaboratorios();
		System.out.println("Se realizó PostConstruct de CE: Laboratorio ");
	}
	
	private void obtenerCeLaboratorios(){
		laboratorio = new CeLaboratorio();	
		laboratorios = new ArrayList<CeLaboratorio>();

		getLaboratorio().setControlEmbarazo(getCe());
		getLaboratorio().setFechaLaboratorio(getFechaHoy());
		setLaboratorios(ceLabDao.obtenerLaboratoriosPorControlEmbarazo(ce.getIdControlEmbarazo()));
	}
	
	public String reinit() {
		laboratorio = new CeLaboratorio();
		laboratorio.setControlEmbarazo(getCe());
		laboratorio.setFechaLaboratorio(getFechaHoy());
		
		return null;
	}

	/*
	 * modo	1 -> 1era vez
	 * 		2 -> subsecuente
	 * 		3 -> detalle
	 * */
	@Override
	public String registrar(Long modo) {
		//Paciente paciente = cemb.getFimb().getPaciente();
		
		List<CeLaboratorio> labsActuales = ceLabDao.obtenerLaboratoriosPorControlEmbarazo(getLaboratorio().getControlEmbarazo().getIdControlEmbarazo());
		
		for(CeLaboratorio labAnterior : labsActuales){
			for(CeLaboratorio laboratorio : laboratorios){
				if(labAnterior.getIdCELaboratorio() == laboratorio.getIdCELaboratorio()){
					labsActuales.remove(labAnterior);
				}
			}
		}
		
		for(CeLaboratorio laboratorio : laboratorios){
			laboratorio.setControlEmbarazo(getCe());
			ceLabDao.registrarLaboratoriosControlEmbarazo(laboratorio);
		}
		
		/*paciente.setFechaUltimaCita(pa.getFechaConsulta());
		trataDao.registrarFechaUltimaConsulta(paciente);
		ver el asunto para registro de ultima consulta cuando es control de embarazo*/
		
		switch(modo.intValue()) {
			case 1:
				return rutas.getString(Rutas.INICIO_MEDICO);
			case 2: 
				
			case 3:
				return rutas.getString(Rutas.HISTORIAL_CONSULTAS);				
			default: 
				return "";
		}		
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub	
	}

	public CeLaboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(CeLaboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public ControlEmbarazo getCe() {
		return ce;
	}
	public void setCe(ControlEmbarazo ce) {
		this.ce = ce;
	}

	public List<CeLaboratorio> getLaboratorios() {
		return laboratorios;
	}
	public void setLaboratorios(List<CeLaboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}	
}