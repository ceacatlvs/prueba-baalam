package com.baalam.controller.histclinica.consultas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.inicio.PacienteDao;
import com.baalam.model.HistorialConsultas;
import com.baalam.model.paciente.Paciente;

@Named
@RequestScoped
public class HistoriaConsultasMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private PacienteDao pacienteDao;

	private List<HistorialConsultas> consultas;
	
	@PostConstruct
	public void historiaConsultasMB() {
		consultas = new ArrayList<HistorialConsultas>();		
		obtenerHistorialConsultas();
	}
	
	private void obtenerHistorialConsultas(){
		Paciente paciente = fimb.getPaciente();
		
		System.out.println("idPaciente " + paciente.getIdPaciente());
		
		setConsultas(pacienteDao.buscarConsultasPorIdPaciente(paciente.getIdPaciente()));
		
	}

	public List<HistorialConsultas> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<HistorialConsultas> consultas) {
		this.consultas = consultas;
	}
}
