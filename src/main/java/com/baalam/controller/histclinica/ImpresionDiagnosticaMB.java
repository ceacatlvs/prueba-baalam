package com.baalam.controller.histclinica;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.dao.histclinica.ImpresionDiagnosticaDao;
import com.baalam.model.catalogo.CatEspecialidad;
import com.baalam.model.histclinica.id.IDDiagnostico;
import com.baalam.model.histclinica.id.ImpresionDiagnostica;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class ImpresionDiagnosticaMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private ImpresionDiagnosticaDao idDao;

	private PadecimientoActual pa;
	private ImpresionDiagnostica id;
	private IDDiagnostico diagnostico;
	
	private List<IDDiagnostico> diagnosticos;
	private List<CatEspecialidad> especialistas;
	
	@PostConstruct
	public void impresionDiagnostica(){
		diagnostico = new IDDiagnostico();
		diagnosticos = new ArrayList<IDDiagnostico>();
		
		setEspecialistas(idDao.obtenerEspecialidades());
		setPa(pamb.getPadecimientoActual());
		
		obtenerImpresoinDiagnostica();
	}
	
	public String reinit() {  
		diagnostico = new IDDiagnostico();  
          
        return null;  
    }
	
	private void obtenerImpresoinDiagnostica(){
		setId(idDao.buscarImpresionDiagnosticaPorIdConsulta(pa.getIdConsulta()));
		
		if(id == null){
			id = new ImpresionDiagnostica();
			
			if (getId().getCatEspecialidad()==null){
				getId().setCatEspecialidad(new CatEspecialidad());
			}
		}
		setDiagnosticos(idDao.obtenerDiagnosticosPorIdConsulta(pa.getIdConsulta()));
	}
	
	@Override
	public String registrar(Long modo) {
		id.setPadecimientoActual(pa);
		idDao.registrarImpresionDiagnostica(id);
		
		registrarDiagnosticos();
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_AD_GAB);
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_TRATA);
			case 3:
				return rutas.getString(Rutas.DETALLE1_AD_GAB);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_TRATA);
	      default: 
	          return "";
		}		
	}
	
	public void registrarDiagnosticos(){
		List<IDDiagnostico> diagnosticosAborrar = idDao.obtenerDiagnosticosPorIdConsulta(pa.getIdConsulta());
		
		if(diagnosticosAborrar != null){
			for(IDDiagnostico diagnosticoAnterior : diagnosticosAborrar){
				for(IDDiagnostico diagnostico : diagnosticos){
					if(diagnosticoAnterior.getIdIdDiagnostico() == diagnostico.getIdIdDiagnostico()){
						diagnosticosAborrar.remove(diagnosticoAnterior);
					}
				}
			}
			
			for(IDDiagnostico diagnosticoBorrar : diagnosticosAborrar){
				idDao.borrarDiagnosticos(diagnosticoBorrar);
			}
		}
	
		for(IDDiagnostico diagnostico : diagnosticos){
			diagnostico.setPadecimientoActual(pa);
			idDao.registrarDiagnosticos(diagnostico);
		}
	}
	
	public String cancelar(){
		return null;
	}
	
	public List<CatEspecialidad> getEspecialistas() {
		return especialistas;
	}
	public void setEspecialistas(List<CatEspecialidad> especialistas) {
		this.especialistas = especialistas;
	}

	public ImpresionDiagnostica getId() {
		return id;
	}
	public void setId(ImpresionDiagnostica id) {
		this.id = id;
	}
	
	public IDDiagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(IDDiagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public PadecimientoActual getPa(){
		return pa;
	}
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}

	public List<IDDiagnostico> getDiagnosticos() {
		return diagnosticos;
	}
	public void setDiagnosticos(List<IDDiagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
}