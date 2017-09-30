package com.baalam.controller.usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.model.DualListModel;

import com.baalam.controller.BaseController;
import com.baalam.controller.LoginMB;
import com.baalam.dao.usuarios.DoctorDao;
import com.baalam.dao.usuarios.SecretariaDao;
import com.baalam.model.usuario.Doctor;
import com.baalam.model.usuario.DoctorSecretaria;

@Named
@ViewAccessScoped
public class RelacionAsistentesMB extends BaseController{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SecretariaDao secreDao;
	
	@Inject
	private DoctorDao doctorDao;
	
	@Inject
	private LoginMB loginMB;
	
	//Asistentes
	private List<DoctorSecretaria> origen;
	private List<DoctorSecretaria> destino; 
	
	private DualListModel<DoctorSecretaria> asistentes;
	
	@PostConstruct
	public void iniciar() {
		Doctor doctor = doctorDao.buscarDoctorConSecretarias(loginMB.getUsuario());
		
		origen = new ArrayList<DoctorSecretaria>();
		destino = new ArrayList<DoctorSecretaria>();
		
		System.out.println("postconstruc relacion " + origen + " " + destino);
		
		obtenerSecretariasAsociadasDoctor();
		obtenerSecretariasDisponibles(doctor.getIdDoctor());

		setAsistentes(new DualListModel<DoctorSecretaria>(origen, destino));
		System.out.println("DualList al cargar: " + asistentes);

	}
	
	private void obtenerSecretariasAsociadasDoctor(){
		setDestino(new ArrayList<DoctorSecretaria>(loginMB.getDoctor().getSecretarias()));
		System.out.println("secretarias asociadas " + getDestino().size());
	}
	
	private void obtenerSecretariasDisponibles(Long idDoctor){
		setOrigen(secreDao.obtenerTodasSecretarias(idDoctor));
		System.out.println("secretarias disponibles " + getOrigen().size());
	}
	
	@Override
	public String registrar(Long modo) {	
		System.out.println("Tamaño del source antes de registrar: " + asistentes.getSource().size());
		System.out.println("Tamaño del target antes de registrar: " + asistentes.getTarget().size());
		
		Doctor doctor = loginMB.getDoctor();
		
		System.out.println("target " + getAsistentes().getTarget().size());
		System.out.println("source " + getAsistentes().getSource().size());

		
		doctor.setSecretarias(new HashSet<DoctorSecretaria>(getAsistentes().getTarget()));
		
		System.out.println("Doctor: " + doctor.getSecretarias());
		
		List<DoctorSecretaria> secretariasL = new ArrayList<DoctorSecretaria>(doctor.getSecretarias());
		
		for(DoctorSecretaria ds : secretariasL){
			System.out.println("idDoctor de doctorSecretaria " + ds.getDoctor() + "idSecretaria " + ds.getSecreataria());
		}
		
		System.out.println("Asistentes del doctor: " + doctor.getSecretarias().size());
		
		doctorDao.registrarDoctor(doctor);
		
		return null;
	}

	@Override
	public String cancelar() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DoctorSecretaria> getOrigen() {
		return origen;
	}
	public void setOrigen(List<DoctorSecretaria> origen) {
		this.origen = origen;
	}

	public List<DoctorSecretaria> getDestino() {
		return destino;
	}
	public void setDestino(List<DoctorSecretaria> destino) {
		this.destino = destino;
	}

	public DualListModel<DoctorSecretaria> getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(DualListModel<DoctorSecretaria> asistentes) {
		this.asistentes = asistentes;
	}
}
