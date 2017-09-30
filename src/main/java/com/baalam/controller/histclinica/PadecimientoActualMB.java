package com.baalam.controller.histclinica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.dao.histclinica.PadecimientoActualDao;
import com.baalam.model.catalogo.CatTipoPaciente;
import com.baalam.model.histclinica.pa.PAMedicamento;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@SessionScoped
public class PadecimientoActualMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;

	@Inject
	private PadecimientoActualDao paDao;
	
	private PadecimientoActual padecimientoActual;	
	private PAMedicamento medicamento;
	
	private List<PAMedicamento> medicamentos; 	
	private List<CatTipoPaciente> tiposPaciente;
	
	private boolean controlEmbarazo;
	private boolean seccionesSubsecuentes;
	
	@PostConstruct
	public void collectorMedicamentos() {
		medicamento = new PAMedicamento();
		medicamentos = new ArrayList<PAMedicamento>();
		
		setTiposPaciente(paDao.obtenerTiposPaciente());
		obtenerPadecimientoActual();
		
		controlEmbarazo = false;
		seccionesSubsecuentes = true;
		System.out.println("Se realizó el PostConstruct de PadecimientoActualMB");
	}
	
	public String reinit() {
		medicamento = new PAMedicamento();
		
		return null;
	}
	
	public void obtenerPadecimientoActual() {		
		if (getPadecimientoActual() == null){
			setPadecimientoActual(new PadecimientoActual());
		}
		if (getPadecimientoActual().getTipoPaciente()==null){
			getPadecimientoActual().setTipoPaciente(new CatTipoPaciente());
		}
		
		if(getPadecimientoActual().getFechaConsulta()==null){
			getPadecimientoActual().setFechaConsulta(getFechaHoy());
		}
		
		if(getPadecimientoActual().getIdConsulta() != null){
			setMedicamentos(paDao.obtenerMedicamentosPorIdConsulta(getPadecimientoActual().getIdConsulta()));
		}	
	}

	/*
	 * modo 1 -> 1era vez
	 * 		2 -> subsecuente
	 * 		3 -> detalle 1ra vez
	 * 		4 -> detalle subsecuente
	 * */
	@Override
	public String registrar(Long modo) {
		padecimientoActual.setPaciente(fimb.getPaciente());
		
		Paciente paciente = padecimientoActual.getPaciente();
		
		if(modo.intValue() == 1 && padecimientoActual.getTipoPaciente().getIdTipoPaciente().intValue() == 1){
			padecimientoActual.setTipoConsulta("P");
		}else if(modo.intValue() == 1 && padecimientoActual.getTipoPaciente().getIdTipoPaciente().intValue() == 2){
			padecimientoActual.setTipoConsulta("PC");
		}else if(modo.intValue() == 2 && padecimientoActual.getTipoPaciente().getIdTipoPaciente().intValue() == 1){
			padecimientoActual.setTipoConsulta("S");
		}else if(modo.intValue() == 3 && padecimientoActual.getTipoPaciente().getIdTipoPaciente().intValue() == 2){
			padecimientoActual.setTipoConsulta("SC");
		}
		
		paciente.setFechaUltimaCita(padecimientoActual.getFechaConsulta());
		paDao.registrarFechaUltimaConsulta(paciente);
		
		paDao.registrarConsulta(padecimientoActual);
		
		registrarMedicamentos();
	    
	    if(padecimientoActual.getTipoPaciente().getIdTipoPaciente() == 2){
	    	controlEmbarazo = true;
	    	seccionesSubsecuentes = false;
	    } else {
	    	controlEmbarazo = false;
	    	seccionesSubsecuentes = true;
	    }
	    
	    switch(modo.intValue()) {
	    	case 1: 
	    		// ir a antecedentes heredofamiliares, consulta 1ra vez
	    		return rutas.getString(Rutas.CONSULTA1_AHF);
	    	case 2:
	    		if(padecimientoActual.getTipoPaciente().getIdTipoPaciente() == 2){
	    			// ir a control embarazo, consulta subsecuente
	    			return rutas.getString(Rutas.CONSULTASUB_CE_SEG);
	    		}else{
	    			//padecimientoActual.setTipoConsulta("S");
	    			// ir a signos vitales, consulta subsecuente
	    			return rutas.getString(Rutas.CONSULTA_SUB_SV);
	    		}	    		
	    	case 3:
	    		// ir a exploración física, detalle de paciente
	    		return rutas.getString(Rutas.DETALLE1_EF_IG);
	    	case 4:
	    		if(padecimientoActual.getTipoPaciente().getIdTipoPaciente() == 2){
	    			// ir a control de embarazo, detalle de paciente
	    			return rutas.getString(Rutas.DETALLE_SUB_CE_SEG);
	    		}else{
	    			// ir a signos vitales, detalle de paciente
	    			return rutas.getString(Rutas.DETALLE_SUB_SV);
	    		}	 
	    	default: 
	    		return "";
	    }	      
	}
	
	public void registrarMedicamentos(){
		List<PAMedicamento> medicamentosABorrar = paDao.obtenerMedicamentosPorIdConsulta(padecimientoActual.getIdConsulta());	    		
	    
		for(PAMedicamento medicamentoBorrar: medicamentosABorrar){	    	
	    	paDao.borrarMedicamentosConsulta(medicamentoBorrar);
	    }
		
		for(PAMedicamento medicamento: medicamentos){
	    	medicamento.setIdConsulta(padecimientoActual);	    	
	    	paDao.registrarMedicamentosConsulta(medicamento);
	    }	    	    
	}
	
	public String cancelar() {
		setPadecimientoActual(new PadecimientoActual());
		getPadecimientoActual().setTipoPaciente(new CatTipoPaciente());
		setMedicamento(new PAMedicamento());
		setMedicamentos(new ArrayList<PAMedicamento>());
		getPadecimientoActual().setFechaConsulta(new Date());
		controlEmbarazo = false;
		
	    return rutas.getString(Rutas.INICIO_MEDICO);
	}
	
	public String verDetalle(Long idConsulta){		
		setPadecimientoActual(paDao.buscarConsultaPorIdConsulta(idConsulta));
		
		char tipoConsulta = padecimientoActual.getTipoConsulta().charAt(0);
		
		if(padecimientoActual.getTipoPaciente().getIdTipoPaciente() == 2){
	    	controlEmbarazo = true;
	    } else {
	    	controlEmbarazo = false;
	    }
		
		switch(tipoConsulta){
			case 'P':
				return rutas.getString(Rutas.DETALLE1_PA);
			case 'S':
				return rutas.getString(Rutas.DETALLE_SUB_PA);
			default:
				return "";			
		}
	}
	
	public FichaIdentificacionMB getFimb() {
		return fimb;
	}
	public void setFimb(FichaIdentificacionMB fimb) {
		this.fimb = fimb;
	}

	public PAMedicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(PAMedicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<PAMedicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<PAMedicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public PadecimientoActual getPadecimientoActual() {
		if(padecimientoActual == null){
			padecimientoActual = new PadecimientoActual();
		}
		return padecimientoActual;
	}
	public void setPadecimientoActual(PadecimientoActual padecimientoActual) {
		this.padecimientoActual = padecimientoActual;
	}
	
	public List<CatTipoPaciente> getTiposPaciente() {
		return tiposPaciente;
	}
	public void setTiposPaciente(List<CatTipoPaciente> tipoPaciente) {
		this.tiposPaciente = tipoPaciente;
	}
	
	public boolean isControlEmbarazo() {
		return controlEmbarazo;
	}
	public void setControlEmbarazo(boolean controlEmbarazo) {
		this.controlEmbarazo = controlEmbarazo;
	}

	public boolean isSeccionesSubsecuentes() {
		return seccionesSubsecuentes;
	}
	public void setSeccionesSubsecuentes(boolean seccionesSubsecuentes) {
		this.seccionesSubsecuentes = seccionesSubsecuentes;
	}	
}