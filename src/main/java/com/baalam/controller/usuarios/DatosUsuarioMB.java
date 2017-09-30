package com.baalam.controller.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.LoginMB;
import com.baalam.dao.histclinica.FichaIdentificacionDao;
import com.baalam.dao.usuarios.DoctorDao;
import com.baalam.dao.usuarios.SecretariaDao;
import com.baalam.dao.usuarios.UsuarioDao;
import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.catalogo.CatEspecialidad;
import com.baalam.model.usuario.Doctor;
import com.baalam.model.usuario.DoctorSecretaria;
import com.baalam.model.usuario.Secretaria;
import com.baalam.model.usuario.Usuario;

@Named
@RequestScoped
public class DatosUsuarioMB extends BaseController{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginMB loginMB;
	
	@Inject
	private FichaIdentificacionDao fichaIdentificacionDao;
	
	@Inject
	private DoctorDao doctorDao;
	
	@Inject
	private SecretariaDao secreDao;
	
	@Inject 
	private UsuarioDao usuarioDao;
	
	private Doctor doctor;
	private Secretaria secretaria;
	
	private List<CatEntidadFederativa> entidades;
	private List<CatEspecialidad> especialidades;
	private List<DoctorSecretaria> doctores;
	
	@PostConstruct
	public void datosUsuario() {
		setEntidades(fichaIdentificacionDao.obtenerEntidadesFederativas());
		
		if(loginMB.getUsuario().getRol().getIdRol() == 1){
			obtenerMedico();
		}else if(loginMB.getUsuario().getRol().getIdRol() == 2){
			obtenerSecretaria();
		}
		System.out.println("postconstruct datos médico ");
	}
	
	private void obtenerMedico(){
		setDoctor(loginMB.getDoctor());
		
		if(getDoctor() == null){
			setDoctor(new Doctor());
			getDoctor().setUsuario(new Usuario());
			getDoctor().setEspecialidad("Ginecologia");
		}else{
			getDoctor().setUsuario(loginMB.getUsuario());
		}
		
		System.out.println("médico obtenido " + getDoctor());
	}
	
	private void obtenerSecretaria(){
		setSecretaria(loginMB.getSecretaria());
		
		if(getSecretaria() == null){
			setSecretaria(new Secretaria());
			getSecretaria().setUsuario(new Usuario());			
		}else{
			getSecretaria().setUsuario(loginMB.getUsuario());
			setDoctores(new ArrayList<DoctorSecretaria>(getSecretaria().getDoctores()));
		}
		
		System.out.println("secreataria obtenida " + loginMB.getSecretaria());
	}
	
	/*en el registar ya voy a poner lo de la secretaria*/
	
	@Override
	public String registrar(Long modo) {			
		if(modo == 1){
			registrarMedico(modo);
		}else if(modo == 2){
			registrarSecretaria(modo);
		}	
		return null;
	}
	
	private void registrarMedico(Long modo){
		getDoctor().getUsuario().setRol(usuarioDao.obtenerRol(modo));
		
		usuarioDao.registrarUsuario(getDoctor().getUsuario());	
		doctorDao.registrarDoctor(getDoctor());		
	}
	
	private void registrarSecretaria(Long modo){
		getSecretaria().getUsuario().setRol(usuarioDao.obtenerRol(modo));
		
		usuarioDao.registrarUsuario(getSecretaria().getUsuario());
		secreDao.registrarSecretaria(getSecretaria());
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub		
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Secretaria getSecretaria() {
		return secretaria;
	}
	public void setSecretaria(Secretaria secreataria) {
		this.secretaria = secreataria;
	}

	public List<CatEntidadFederativa> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<CatEntidadFederativa> entidades) {
		this.entidades = entidades;
	}
	
	public List<CatEspecialidad> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<CatEspecialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public List<DoctorSecretaria> getDoctores() {
		return doctores;
	}
	public void setDoctores(List<DoctorSecretaria> doctores) {
		this.doctores = doctores;
	}	
}