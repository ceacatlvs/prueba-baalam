package com.baalam.controller.usuarios;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.LoginMB;
import com.baalam.dao.histclinica.FichaIdentificacionDao;
import com.baalam.dao.usuarios.ConsultorioDao;
import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.usuario.Consultorio;

@Named
@ViewAccessScoped
public class DatosConsultorioMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginMB loginMB;
	
	@Inject
	private FichaIdentificacionDao fichaIdentificacionDao;
	
	@Inject
	private ConsultorioDao consulDao;
	
	private Consultorio consultorio;
	
	private List<Consultorio> consultorios;
	private List<CatEntidadFederativa> entidades;
	
	@PostConstruct
	public void datosConsultorio() {
		obtenerConsultorio();
		
		setEntidades(fichaIdentificacionDao.obtenerEntidadesFederativas());
		
		System.out.println("postconstruct datos consultorio " + getConsultorio().getEntidadFedereativa());
	}

	private void obtenerConsultorio(){
		setConsultorios(consulDao.obtenerConsultoriosPorIdDoctor(loginMB.getDoctor().getIdDoctor()));
		
		if(getConsultorio() == null){
			setConsultorio(new Consultorio());
			getConsultorio().setDoctor(loginMB.getDoctor());
			getConsultorio().setEntidadFedereativa(new CatEntidadFederativa());
			
			System.out.println("consultorio es null" + getConsultorio() + "entidad federativa " + getConsultorio().getEntidadFedereativa());
		}
		else if(getConsultorio().getEntidadFedereativa() == null){			
			System.out.println("consultorio no es null" + consultorio.getEntidadFedereativa());			
			getConsultorio().setEntidadFedereativa(new CatEntidadFederativa());
			System.out.println("consultorio no es null 2" + consultorio.getEntidadFedereativa());
			
		}
		
		
	}
	
	public void verDetalle(Long idConsultorio){
		setConsultorio(consulDao.obtenerConsultorio(idConsultorio));
		
		System.out.println("detalle de consultorio " + getConsultorio());
	}
	
	@Override
	public String registrar(Long modo) {
		consulDao.registrarConsultorio(consultorio);
		
		obtenerConsultorio();
		
		return null;
	}

	@Override
	public String cancelar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FichaIdentificacionDao getFichaIdentificacionDao() {
		return fichaIdentificacionDao;
	}
	public void setFichaIdentificacionDao(FichaIdentificacionDao fichaIdentificacionDao) {
		this.fichaIdentificacionDao = fichaIdentificacionDao;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}
	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}
	
	public List<Consultorio> getConsultorios() {
		return consultorios;
	}
	public void setConsultorios(List<Consultorio> consultorios) {
		this.consultorios = consultorios;
	}

	public List<CatEntidadFederativa> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<CatEntidadFederativa> entidades) {
		this.entidades = entidades;
	}
}
