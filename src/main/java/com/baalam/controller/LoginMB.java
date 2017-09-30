package com.baalam.controller;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.baalam.dao.usuarios.DoctorDao;
import com.baalam.dao.usuarios.SecretariaDao;
import com.baalam.dao.usuarios.UsuarioDao;
import com.baalam.model.usuario.Doctor;
import com.baalam.model.usuario.DoctorSecretaria;
import com.baalam.model.usuario.Secretaria;
import com.baalam.model.usuario.Usuario;
import com.baalam.util.Rutas;

@Named
@SessionScoped
public class LoginMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Doctor doctor;
	private Secretaria secreataria;
	private String msg;
	
	private boolean permiso;

	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private DoctorDao doctorDao;
	
	@Inject
	private SecretariaDao secreatariaDao;
	
	public String login() {
		String dir = "";
		FacesMessage msg = null; 
		setPermiso(false);
		setUsuario(usuarioDao.buscarPorUsuario(usuario));
          
        if(usuario != null) {        	
        	usuario.setFechaUltimoAcceso(getFechaHoy());
            
  	      	msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido a Baalam "+usuario.getUsername()+"!", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            if (usuario.getRol().getIdRol() == 1) {
            	setDoctor(doctorDao.buscarDoctor(usuario));
            	
            	setPermiso(true);
            	dir = rutas.getString(Rutas.INICIO_MEDICO);
            } else if (usuario.getRol().getIdRol() == 2) {
            	setSecretaria(secreatariaDao.buscarSecretaria(usuario));
            	setPermiso(false);
            	System.out.println("los doctores de la secretaria " + secreataria.getDoctores());
            	if(!secreataria.getDoctores().isEmpty()){
            		Iterator<DoctorSecretaria> it = secreataria.getDoctores().iterator();
                	setDoctor(doctorDao.buscarDoctorPorId(it.next().getIdDoctor()));
                	System.out.println("doctor " + getDoctor());
            	}            	
            	dir = rutas.getString(Rutas.AGENDA_ASISTENTE);
            }         
            return dir;          
            //return rutas.getString(Rutas.INICIO);
        } else {
        	msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al iniciar sesión", "Combinación de usuario y contraseña incorrectas, por favor inténtelo de nuevo");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        	return rutas.getString(Rutas.LOGIN);
        }
    }  
	
	@PostConstruct
	public void revisarSesion() {
		if(msg != null){
			if(msg.equalsIgnoreCase("nosession")){
				FacesMessage msg = null;   
	  	      	msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Expiró su sesión", "Vuelva a su ingresar Usuario y contraseña.");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
	}
	
	public String logOut(){
		setUsuario(null);
		setDoctor(null);
		setSecretaria(null);

	    FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();

	    final HttpServletRequest r = (HttpServletRequest)ec.getRequest();
	    r.getSession(false).invalidate();

		System.out.println("Se hizo el logout");
	    String login="/"+rutas.getString(Rutas.LOGIN);
	    
		return login;
	}
	
	public Usuario getUsuario() {
    	if(usuario == null){
    		usuario = new Usuario();
		}
    	return usuario;
	} 
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Doctor getDoctor() {
		if(doctor == null){
			doctor = new Doctor();
		}
		return doctor;
	}	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Secretaria getSecretaria() {
		return secreataria;
	}	
	public void setSecretaria(Secretaria secreataria) {
		this.secreataria = secreataria;
	}
	
	public boolean isPermiso() {
		return permiso;
	}
	public void setPermiso(boolean permiso) {
		this.permiso = permiso;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String registrar(Long modo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
	}
}
