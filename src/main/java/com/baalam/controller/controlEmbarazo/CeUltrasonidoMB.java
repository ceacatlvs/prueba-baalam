package com.baalam.controller.controlEmbarazo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.dao.controlEmbarazo.CeUltrasonidoDao;
import com.baalam.model.catalogo.CatLA;
import com.baalam.model.catalogo.CatPlacenta;
import com.baalam.model.catalogo.CatSexo;
import com.baalam.model.controlEmbarazo.CeUltrasonido;
import com.baalam.model.controlEmbarazo.ControlEmbarazo;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class CeUltrasonidoMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CeSeguimientoMB cemb;
	
	@Inject
	private CeUltrasonidoDao ceUltraDao;
	
	private CeUltrasonido ultrasonido;
	private ControlEmbarazo ce;
	
	private List<CeUltrasonido> ultrasonidos;
	private List<CatPlacenta> tipoPlacenta;
	private List<CatLA> tipoLA;
	private List<CatSexo> tipoSexo;
	
	@PostConstruct
	public void collectorUltrasonidos() {
		setCe(cemb.getCe());
		
		obtenerCeUltrasonidos();
		
		setTipoPlacenta(ceUltraDao.obtenerPlacenta());
		setTipoLA(ceUltraDao.obtenerLA());
		setTipoSexo(ceUltraDao.obtenerSexo());
		
		System.out.println("Se realizó PostConstruct de CE: Ultrasonido " + ultrasonido);
	}
	
	private void obtenerCeUltrasonidos(){
		ultrasonido = new CeUltrasonido();		
		
		ultrasonido.setControlEmbarazo(getCe());
		ultrasonido.setIdPlacenta(new CatPlacenta());
		ultrasonido.setIdLA(new CatLA());
		ultrasonido.setIdSexo(new CatSexo());
		ultrasonido.setFechaUltrasonido(getFechaHoy());
		ultrasonidos = new ArrayList<CeUltrasonido>();
		
		setUltrasonidos(ceUltraDao.obtenerUltrasonidosPorControlEmbarazo(ce.getIdControlEmbarazo()));
	}
	
	public String reinit() {
		ultrasonido = new CeUltrasonido();
		ultrasonido.setControlEmbarazo(getCe());
		ultrasonido.setIdPlacenta(new CatPlacenta());
		ultrasonido.setIdLA(new CatLA());
		ultrasonido.setIdSexo(new CatSexo());
		ultrasonido.setFechaUltrasonido(getFechaHoy());
		
		return null;
	}
	
	public void setDescripcionPlacenta() {
		Long idPlacenta = ultrasonido.getIdPlacenta().getIdPlacenta();
		CatPlacenta ultraPlacenta = tipoPlacenta.get((int)(idPlacenta-1));
		
		ultrasonido.getIdPlacenta().setIdPlacenta(idPlacenta);
		ultrasonido.getIdPlacenta().setDescripcion(ultraPlacenta.getDescripcion());
	}
	
	public void cambiarDescripcionPlacenta(CeUltrasonido ultrasonidoCollector) {
		Long idPlacenta = ultrasonidoCollector.getIdPlacenta().getIdPlacenta();
		CatPlacenta ultraPlacenta = tipoPlacenta.get((int)(idPlacenta-1));
		
		ultrasonidoCollector.getIdPlacenta().setIdPlacenta(idPlacenta);
		ultrasonidoCollector.getIdPlacenta().setDescripcion(ultraPlacenta.getDescripcion());
	}
	
	public void setDescripcionLA() {
		Long idLA = ultrasonido.getIdLA().getIdLA();
		CatLA ultraLA = tipoLA.get((int)(idLA-1));
		
		ultrasonido.getIdLA().setIdLA(idLA);
		ultrasonido.getIdLA().setDescripcion(ultraLA.getDescripcion());
	}
	
	public void cambiarDescripcionLA(CeUltrasonido ultrasonidoCollector) {
		Long idLA = ultrasonidoCollector.getIdLA().getIdLA();
		CatLA ultraLA = tipoLA.get((int)(idLA-1));
		
		ultrasonidoCollector.getIdLA().setIdLA(idLA);
		ultrasonidoCollector.getIdLA().setDescripcion(ultraLA.getDescripcion());
	}
	
	public void setDescripcionSexo() {
		Long idSexo = ultrasonido.getIdSexo().getIdSexo();
		CatSexo ultraSexo = tipoSexo.get((int)(idSexo-1));
		
		ultrasonido.getIdSexo().setIdSexo(idSexo);
		ultrasonido.getIdSexo().setDescripcion(ultraSexo.getDescripcion());
	}
	
	public void cambiarDescripcionSexo(CeUltrasonido ultrasonidoCollector) {
		Long idSexo = ultrasonidoCollector.getIdSexo().getIdSexo();
		CatSexo ultraSexo = tipoSexo.get((int)(idSexo-1));
		
		ultrasonidoCollector.getIdSexo().setIdSexo(idSexo);
		ultrasonidoCollector.getIdSexo().setDescripcion(ultraSexo.getDescripcion());
	}
	
	@Override
	public String registrar(Long modo) {
		List<CeUltrasonido> ultraActuales = ceUltraDao.obtenerUltrasonidosPorControlEmbarazo(ultrasonido.getControlEmbarazo().getIdControlEmbarazo());
		
		for(CeUltrasonido ultraAnterior : ultraActuales){
			for(CeUltrasonido ultrasonido : ultrasonidos){
				if(ultraAnterior.getIdCEUltrasonido() == ultrasonido.getIdCEUltrasonido()){
					ultraActuales.remove(ultraAnterior);
				}
			}
		}
		
		for(CeUltrasonido ultrasonido : ultrasonidos){
			ultrasonido.setControlEmbarazo(getCe());
			ceUltraDao.registrarUltrasonidosControlEmbarazo(ultrasonido);
		}
		
		switch(modo.intValue()){
			case 1:
				// ir a laboratorio, consulta 1ra vez
				return rutas.getString(Rutas.CONSULTA1_CE_LAB);
			case 2:				
				// ir a laboratorio, consulta subsecuente
				return rutas.getString(Rutas.CONSULTASUB_CE_LAB);
			case 3:
				// ir a laboratorio, control de embarazo
				return rutas.getString(Rutas.CONSULTACE_LAB);
			default:
				return "";
		}
		
	}

	@Override
	public String cancelar() {
		return null;
	}

	public CeUltrasonido getUltrasonido() {
		return ultrasonido;
	}
	public void setUltrasonido(CeUltrasonido ultrasonido) {
		this.ultrasonido = ultrasonido;
	}

	public ControlEmbarazo getCe() {
		return ce;
	}
	public void setCe(ControlEmbarazo ce) {
		this.ce = ce;
	}

	public List<CeUltrasonido> getUltrasonidos() {
		return ultrasonidos;
	}
	public void setUltrasonidos(List<CeUltrasonido> ultrasonidos) {
		this.ultrasonidos = ultrasonidos;
	}

	public List<CatPlacenta> getTipoPlacenta() {
		return tipoPlacenta;
	}
	public void setTipoPlacenta(List<CatPlacenta> tipoPlacenta) {
		this.tipoPlacenta = tipoPlacenta;
	}

	public List<CatLA> getTipoLA() {
		return tipoLA;
	}
	public void setTipoLA(List<CatLA> tipoLA) {
		this.tipoLA = tipoLA;
	}

	public List<CatSexo> getTipoSexo() {
		return tipoSexo;
	}
	public void setTipoSexo(List<CatSexo> tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
}