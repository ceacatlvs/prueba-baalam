package com.baalam.controller.controlEmbarazo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.antecedentes.AntecedentesGODao;
import com.baalam.dao.controlEmbarazo.CeFinEmbarazoDao;
import com.baalam.dao.controlEmbarazo.CeInformacionDao;
import com.baalam.model.controlEmbarazo.CeFinEmbarazo;
import com.baalam.model.histclinica.ant.go.AGOPartos;
import com.baalam.model.paciente.Paciente;

@Named
@ViewAccessScoped
public class CeFinEmbarazoMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Inject
	private FichaIdentificacionMB fimb;

	@Inject
	private CeFinEmbarazoDao ceFinDao;
	
	@Inject
	private CeInformacionDao ceInfoDao;
	
	@Inject
	private AntecedentesGODao aGODao;

	private CeFinEmbarazo finEmbarazo;

	private AGOPartos parto;
	private List<AGOPartos> partos;

	@PostConstruct
	public void iniciar() {
		//finEmbarazo = ceFinDao.buscarCeFinEmbarazoPorId(idCEFin);
		finEmbarazo = new CeFinEmbarazo();
		//partos = ceFinDao.obtenerPartosPorIdPaciente(paciente.getIdPaciente());
		partos = new ArrayList<AGOPartos>();
		parto = new AGOPartos();
		finEmbarazo.setTermino("");
	}

	public void cambiarFechaTermino(){
		parto.setFechaNacimiento(finEmbarazo.getFechaTermino());
		for (AGOPartos partoTabla:partos){
			partoTabla.setFechaNacimiento(finEmbarazo.getFechaTermino());
		}
	}
	
	public void cambiarSemanas(){
		parto.setSemanasEmbarazo(finEmbarazo.getSemanas());
		for (AGOPartos partoTabla:partos){
			partoTabla.setSemanasEmbarazo(finEmbarazo.getSemanas());
		}
	}

	public String reinitParto() {
		parto = new AGOPartos();
		parto.setFechaNacimiento(finEmbarazo.getFechaTermino());
		parto.setSemanasEmbarazo(finEmbarazo.getSemanas());
		return null;
	}

	@Override
	public String registrar(Long modo) {

		//finEmbarazo.setControlEmbarazo(ceInfoDao.buscarCeInformacionPorIdControlEmbarazo(new Long (1)));
		ceFinDao.registrarCeFinEmbarazo(finEmbarazo);
		//hacia donde debe redirigir?

		Paciente paciente = fimb.getPaciente();	
		// se deben aliminar antes, no? se deben eliminar todos los partos cuyo fin embarazo sea este.
		for(AGOPartos partoReg: partos){
			partoReg.setPaciente(paciente);
			partoReg.setFinEmbarazo(finEmbarazo);
			aGODao.registrarParto(partoReg);
		}
		return null;
	}

	@Override
	public String cancelar() {
		return null;
	}

	public CeFinEmbarazo getFinEmbarazo() {
		return finEmbarazo;
	}
	public void setFinEmbarazo(CeFinEmbarazo finEmbarazo) {
		this.finEmbarazo = finEmbarazo;
	}

	public AGOPartos getParto() {
		return parto;
	}
	public void setParto(AGOPartos parto) {
		this.parto = parto;
	}

	public List<AGOPartos> getPartos() {
		return partos;
	}
	public void setPartos(List<AGOPartos> partos) {
		this.partos = partos;
	}
}