package com.baalam.controller.controlEmbarazo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.controlEmbarazo.CeInformacionDao;
import com.baalam.dao.controlEmbarazo.CeSeguimientoDao;
import com.baalam.model.catalogo.CatEdema;
import com.baalam.model.catalogo.CatEdemaX;
import com.baalam.model.catalogo.CatMsFs;
import com.baalam.model.catalogo.CatPres;
import com.baalam.model.controlEmbarazo.CeSeguimiento;
import com.baalam.model.controlEmbarazo.ControlEmbarazo;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@SessionScoped
public class CeSeguimientoMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private CeInformacionDao ceInfoDao;
	
	@Inject
	private CeSeguimientoDao ceSegDao;
	
	private ControlEmbarazo ce;
	private CeSeguimiento seguimiento;
	private Paciente paciente;
	
	/*con esto voy a probar q en la parte de seguimiento de CE se guarde el tipo de consulta como control de embarazo*/
	private PadecimientoActual consulta;
	
	private List<CeSeguimiento> seguimientos;
	private List<CatMsFs> tipoMsFs;
	private List<CatPres> tipoPres;
	private List<CatEdema> tipoEdema;
	private List<CatEdemaX> tipoEdemaX;
	
	private boolean bEdema;
	
	@PostConstruct
	public void collectorSeguimientos() {	
		obtenerCeSeguimiento();
		
		setTipoMsFs(ceSegDao.obtenerMsFs());
		setTipoPres(ceSegDao.obtenerPres());
		setTipoEdema(ceSegDao.obtenerEdema());
		setTipoEdemaX(ceSegDao.obtenerEdemaX());
		
		bEdema = false;
		
		System.out.println("Se realizó PostConstruct de CE: Seguimiento " );
	}
	
	private void obtenerCeSeguimiento(){
		if(getCe() == null){
			setCe(new ControlEmbarazo());
		}
				
		reinit();
		
		setSeguimientos(ceSegDao.obtenerSeguimientosPorControlEmbarazo(ce.getIdControlEmbarazo()));
	}
	
	public String reinit() {
		seguimiento = new CeSeguimiento();
		seguimiento.setMsfs(new CatMsFs());
		seguimiento.setPres(new CatPres());
		seguimiento.setEdema(new CatEdema());
		seguimiento.setEdemaX(new CatEdemaX());
		seguimiento.setFechaConsulta(getFechaHoy());
		
		return null;
	}
	
	public void setDescripcionMsFs() {
		Long idMsFs = seguimiento.getMsfs().getIdMsFs();
		CatMsFs segMsFs = tipoMsFs.get((int)(idMsFs-1));
		
		seguimiento.getMsfs().setIdMsFs(idMsFs);
		seguimiento.getMsfs().setDescripcion(segMsFs.getDescripcion());
	}
	
	public void cambiarDescripcionMsFs(CeSeguimiento seguimientoCollector) {
		Long idMsFs = seguimientoCollector.getMsfs().getIdMsFs();
		CatMsFs segMsFs = tipoMsFs.get((int)(idMsFs-1));
		
		seguimientoCollector.getMsfs().setIdMsFs(idMsFs);
		seguimientoCollector.getMsfs().setDescripcion(segMsFs.getDescripcion());
	}
	
	public void setDescripcionPres() {
		Long idPres = seguimiento.getPres().getIdPres();
		CatPres segPres = tipoPres.get((int)(idPres-1));
		
		seguimiento.getPres().setIdPres(idPres);
		seguimiento.getPres().setDescripcion(segPres.getDescripcion());
	}
	
	public void cambiarDescripcionPres(CeSeguimiento seguimientoCollector) {
		Long idPres = seguimientoCollector.getPres().getIdPres();
		CatPres segPres = tipoPres.get((int)(idPres-1));
		
		seguimientoCollector.getPres().setIdPres(idPres);
		seguimientoCollector.getPres().setDescripcion(segPres.getDescripcion());
	}
	
	public void setDescripcionEdema() {
		Long idEdema = seguimiento.getEdema().getIdEdema();
		CatEdema segEdema = tipoEdema.get((int)(idEdema-1));
		
		seguimiento.getEdema().setIdEdema(idEdema);
		seguimiento.getEdema().setDescripcion(segEdema.getDescripcion());
		
		if (segEdema.getDescripcion().equals("Positivo")) {
			bEdema = true;
		} else {
			bEdema = false;
			seguimiento.setEdemaX(new CatEdemaX());
		}
	}
	
	public void cambiarDescripcionEdema(CeSeguimiento seguimientoCollector) {
		Long idEdema = seguimientoCollector.getEdema().getIdEdema();
		CatEdema segEdema = tipoEdema.get((int)(idEdema-1));
		
		seguimientoCollector.getEdema().setIdEdema(idEdema);
		seguimientoCollector.getEdema().setDescripcion(segEdema.getDescripcion());
		
		if (segEdema.getDescripcion().equals("Positivo")) {
			bEdema = true;
		} else {
			bEdema = false;
			seguimientoCollector.setEdemaX(new CatEdemaX());
		}
	}
	
	public void setDescripcionEdemaX() {
		Long idEdemaX = seguimiento.getEdemaX().getIdEdemaX();
		CatEdemaX segEdemaX = tipoEdemaX.get((int)(idEdemaX-1));
		
		seguimiento.getEdemaX().setIdEdemaX(idEdemaX);
		seguimiento.getEdemaX().setDescripcion(segEdemaX.getDescripcion());
	}
	
	public void cambiarDescripcionEdemaX(CeSeguimiento seguimientoCollector) {
		Long idEdemaX = seguimientoCollector.getEdemaX().getIdEdemaX();
		CatEdemaX segEdemaX = tipoEdemaX.get((int)(idEdemaX-1));
		
		seguimientoCollector.getEdemaX().setIdEdemaX(idEdemaX);
		seguimientoCollector.getEdemaX().setDescripcion(segEdemaX.getDescripcion());
	}
	
	public void actualizarFPP (SelectEvent event){
		Date fum = (Date) event.getObject();
		calcularFPP(fum);
	}
	
	public void calcularFPP(Date fum){
		if (fum != null){
			Calendar fpp = Calendar.getInstance();
			fpp.setTime(fum);
			
			if (fpp.after(fechaHoy)) {
				throw new IllegalArgumentException("La fecha es invalida");
			}else{
				fpp.add(Calendar.DAY_OF_MONTH, 7);				
				fpp.add(Calendar.MONTH, 9);				
			}	
			getCe().setFpp(fpp.getTime());
		}	
	}
	
	@Override
	public String registrar(Long modo) {
		//ce.setPaciente(fimb.getPaciente());
		ce.setConsulta(pamb.getPadecimientoActual());
		ceInfoDao.registrarCeInformacion(ce);
		
		registerSeguimiento();
		
		switch(modo.intValue()){
			case 1:
				// ir a ultrasonido, consulta 1ra vez
				return rutas.getString(Rutas.CONSULTA1_CE_USG);
			case 2:
				// ir a ultrasonido, consulta subsecuente
				return rutas.getString(Rutas.CONSULTASUB_CE_USG);
			case 3:
				// ir a ultrasonido, control de embarazo
				return rutas.getString(Rutas.CONSULTACE_USG);
			default:
				return "";
		}	
	}

	private void registerSeguimiento(){
		List<CeSeguimiento> seguimientosActuales = ceSegDao.obtenerSeguimientosPorControlEmbarazo(getCe().getIdControlEmbarazo());
		
		for(CeSeguimiento seguimientoAnterior : seguimientosActuales){
			for(CeSeguimiento seguimiento : seguimientos){
				if(seguimientoAnterior.getIdCESeguimiento() == seguimiento.getIdCESeguimiento()){
					seguimientosActuales.remove(seguimientoAnterior);
				}
			}
		}
		
		for(CeSeguimiento seguimiento : seguimientos){
			seguimiento.setControlEmbarazo(getCe());
			ceSegDao.registrarSeguimientosControlEmbarazo(seguimiento);
		}
	}
	
	@Override
	public String cancelar() {	
		setCe(new ControlEmbarazo());
		reinit();
		
	    return rutas.getString(Rutas.INICIO_MEDICO);		
	}

	public CeSeguimiento getSeguimiento() {
		return seguimiento;
	}
	public void setSeguimiento(CeSeguimiento seguimiento) {
		this.seguimiento = seguimiento;
	}

	public ControlEmbarazo getCe() {
		return ce;
	}
	public void setCe(ControlEmbarazo ce) {
		this.ce = ce;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<CeSeguimiento> getSeguimientos() {
		return seguimientos;
	}
	public void setSeguimientos(List<CeSeguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public List<CatMsFs> getTipoMsFs() {
		return tipoMsFs;
	}
	public void setTipoMsFs(List<CatMsFs> tipoMsFs) {
		this.tipoMsFs = tipoMsFs;
	}

	public List<CatPres> getTipoPres() {
		return tipoPres;
	}
	public void setTipoPres(List<CatPres> tipoPres) {
		this.tipoPres = tipoPres;
	}

	public List<CatEdema> getTipoEdema() {
		return tipoEdema;
	}
	public void setTipoEdema(List<CatEdema> tipoEdema) {
		this.tipoEdema = tipoEdema;
	}

	public List<CatEdemaX> getTipoEdemaX() {
		return tipoEdemaX;
	}
	public void setTipoEdemaX(List<CatEdemaX> tipoEdemaX) {
		this.tipoEdemaX = tipoEdemaX;
	}

	public boolean isbEdema() {
		return bEdema;
	}

	public void setbEdema(boolean bEdema) {
		this.bEdema = bEdema;
	}
}