package com.baalam.dao.histclinica;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.catalogo.CatGrupoSanguineo;
import com.baalam.model.paciente.Paciente;
import com.baalam.model.usuario.Doctor;

@Stateful
public class FichaIdentificacionDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Paciente buscarFIDPorIdPaciente(Long idPaciente){
		Paciente paciente = new Paciente();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> criteria = cb.createQuery(Paciente.class);
		Root<Paciente> rFichaIdentificacion = criteria.from(Paciente.class);
		criteria.select(rFichaIdentificacion).where(cb.equal(rFichaIdentificacion.get("idPaciente"), idPaciente));
		try {
			paciente =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return paciente;
	}
	
	public Paciente buscarFIDPorIdPacienteConConsultas(Long idPaciente){
		Paciente paciente = new Paciente();
		try{
			paciente = buscarFIDPorIdPaciente(idPaciente);
			paciente.getConsultas();
			System.out.println("paciente consultas " + paciente.getConsultas());
		} catch(NoResultException nre) {
			return null;
		}		
		return paciente;
	}
	
	public void registrarPaciente(Paciente paciente){
		try{
			if(paciente.getIdPaciente() == null){
				Doctor dr = em.find(Doctor.class, paciente.getDoctor().getIdDoctor());
				paciente.setDoctor(dr);				
				em.persist(paciente);
			}else{
				em.merge(paciente);
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }	
	}
	
	public List<CatEntidadFederativa> obtenerEntidadesFederativas() {
		 CriteriaQuery<CatEntidadFederativa> criteria = em.getCriteriaBuilder().createQuery(CatEntidadFederativa.class);
		    criteria.select(criteria.from(CatEntidadFederativa.class));
		    return em.createQuery(criteria).getResultList();
	}

	public List<CatGrupoSanguineo> obtenerGruposSanguineos() {		
		CriteriaQuery<CatGrupoSanguineo> criteria = em.getCriteriaBuilder().createQuery(CatGrupoSanguineo.class);
		criteria.select(criteria.from(CatGrupoSanguineo.class));
		return em.createQuery(criteria).getResultList();
	}
}
