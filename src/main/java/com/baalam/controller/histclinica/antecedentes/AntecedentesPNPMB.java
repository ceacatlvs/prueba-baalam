package com.baalam.controller.histclinica.antecedentes;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.antecedentes.AntecedentesPNPDao;
import com.baalam.model.catalogo.CatEscolaridad;
import com.baalam.model.catalogo.CatEstadoCivil;
import com.baalam.model.catalogo.CatOrientacionSexual;
import com.baalam.model.catalogo.CatTabaquismo;
import com.baalam.model.histclinica.ant.pnp.APNPAntecedentes;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class AntecedentesPNPMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private AntecedentesPNPDao apnpDao;
	
	private Paciente paciente;
	
	private List<CatTabaquismo> tabaquismo;
	//private List<CatDuracion> duracion;
	private List<CatOrientacionSexual> orientacionSexual;
	private List<CatEstadoCivil> edoCivil;
	private List<CatEscolaridad> escolaridad;
	
	private APNPAntecedentes apnp;
	private boolean tabaquismoActual;
	private boolean tabaquismoHistoria;
	
	@PostConstruct
	public void iniciar() {
		setPaciente(fimb.getPaciente());
		obtenerAPNP();
		setTabaquismo(apnpDao.obtenerTabaquismo());
		setOrientacionSexual(apnpDao.obtenerOrientacionSexual());
		setEdoCivil(apnpDao.obtenerEdoCivil());
		setEscolaridad(apnpDao.obtenerEscolaridad());
	}
	
	private void obtenerAPNP(){
		apnp = apnpDao.buscarAPNPPorIdPaciente(paciente.getIdPaciente());
		iniciarSelectOneMenus();
		mostrarTabaquismo();
		
	}
	
	private void iniciarSelectOneMenus(){
		if(apnp == null){
			apnp = new APNPAntecedentes();
		}
		if(apnp.getIdCatTabaquismo()==null){
			apnp.setIdCatTabaquismo(new CatTabaquismo());
		}
		if(apnp.getIdCatOrientacionSexual()==null){
			apnp.setIdCatOrientacionSexual(new CatOrientacionSexual());
		}
		if(apnp.getIdCatEscolaridad()==null){
			apnp.setIdCatEscolaridad(new CatEscolaridad());
		}
		if(apnp.getIdCatEstadoCivil()==null){
			apnp.setIdCatEstadoCivil(new CatEstadoCivil());
		}
	}
	
	public void mostrarTabaquismo() {		
		//fTabaquismo = false;
		if(apnp.getIdCatTabaquismo().getIdCatTabaquismo()!=null){
			if(apnp.getIdCatTabaquismo().getIdCatTabaquismo() == 1 || apnp.getIdCatTabaquismo().getIdCatTabaquismo() == 2) {
				tabaquismoActual = false;
				tabaquismoHistoria = false;
			}
			if(apnp.getIdCatTabaquismo().getIdCatTabaquismo() == 3) {
				tabaquismoActual = true;
				tabaquismoHistoria = false;
			}
			if(apnp.getIdCatTabaquismo().getIdCatTabaquismo() == 4) {
				tabaquismoActual = false;
				tabaquismoHistoria = true;
			}
		} else {
			tabaquismoActual = false;
			tabaquismoHistoria = false;
		}
	}
	
	@Override
	public String registrar(Long modo){
		apnp.setIdPaciente(paciente);
		
		validarSelectOneMenus();
		
		apnpDao.registrarAPNP(apnp);
		
		switch(modo.intValue()) {
	      case 1: 
	    	  return rutas.getString(Rutas.CONSULTA1_APP);
	      case 3: 
	    	  return rutas.getString(Rutas.CONSULTA_DETALLE_APP);	  
	      default: 
	          return "";
		}	
	}
	
	public void validarSelectOneMenus(){
		if(apnp.getIdCatEscolaridad().getIdCatEscolaridad()==null || apnp.getIdCatEscolaridad().getIdCatEscolaridad()==0){
			apnp.setIdCatEscolaridad(null);
		}
		if(apnp.getIdCatEstadoCivil().getIdCatEstadoCivil()==null || apnp.getIdCatEstadoCivil().getIdCatEstadoCivil()==0){
			apnp.setIdCatEstadoCivil(null);
		}
		if(apnp.getIdCatOrientacionSexual().getIdCatOrientacionSexual()==null || apnp.getIdCatOrientacionSexual().getIdCatOrientacionSexual()==0){
			apnp.setIdCatOrientacionSexual(null);
		}
		if(apnp.getIdCatTabaquismo().getIdCatTabaquismo()==null || apnp.getIdCatTabaquismo().getIdCatTabaquismo()==0){
			apnp.setIdCatTabaquismo(null);
		}
	}

	@Override
	public String cancelar() {
		return null;		
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<CatTabaquismo> getTabaquismo() {
		return tabaquismo;
	}
	public void setTabaquismo(List<CatTabaquismo> tabaquismo) {
		this.tabaquismo = tabaquismo;
	}
	/*
	public List<CatDuracion> getDuracion() {
		return duracion;
	}
	public void setDuracion(List<CatDuracion> duracion) {
		this.duracion = duracion;
	}*/
	
	public List<CatOrientacionSexual> getOrientacionSexual() {
		return orientacionSexual;
	}
	public void setOrientacionSexual(List<CatOrientacionSexual> orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
	}
	
	public List<CatEstadoCivil> getEdoCivil() {
		return edoCivil;
	}
	public void setEdoCivil(List<CatEstadoCivil> edoCivil) {
		this.edoCivil = edoCivil;
	}
	
	public List<CatEscolaridad> getEscolaridad() {
		return escolaridad;
	}
	public void setEscolaridad(List<CatEscolaridad> escolaridad) {
		this.escolaridad = escolaridad;
	}
	
	public APNPAntecedentes getApnp() {
		return apnp;
	}
	public void setApnp(APNPAntecedentes apnp) {
		this.apnp = apnp;
	}

	public boolean isTabaquismoActual() {
		return tabaquismoActual;
	}

	public void setTabaquismoActual(boolean tabaquismoActual) {
		this.tabaquismoActual = tabaquismoActual;
	}

	public boolean isTabaquismoHistoria() {
		return tabaquismoHistoria;
	}

	public void setTabaquismoHistoria(boolean tabaquismoHistoria) {
		this.tabaquismoHistoria = tabaquismoHistoria;
	}
	
}
