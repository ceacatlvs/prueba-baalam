package com.baalam.dao.antecedentes;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatDuracion;
import com.baalam.model.catalogo.CatEscolaridad;
import com.baalam.model.catalogo.CatEstadoCivil;
import com.baalam.model.catalogo.CatOrientacionSexual;
import com.baalam.model.catalogo.CatTabaquismo;
import com.baalam.model.histclinica.ant.pnp.APNPAntecedentes;

@Stateful
public class AntecedentesPNPDao {

	@PersistenceContext
	private EntityManager em;
	
	public APNPAntecedentes buscarAPNPPorIdPaciente(Long idPaciente){
		APNPAntecedentes apnp = new APNPAntecedentes();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APNPAntecedentes> criteria = cb.createQuery(APNPAntecedentes.class);
		Root<APNPAntecedentes> rApnp = criteria.from(APNPAntecedentes.class);
		criteria.select(rApnp).where(cb.equal(rApnp.get("paciente"), idPaciente));
		try{
			apnp = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return apnp;
	}
	
	public void registrarAPNP(APNPAntecedentes apnp){
		try{
			APNPAntecedentes apnpf = em.find(APNPAntecedentes.class, apnp.getIdPaciente().getIdPaciente());
			if(apnpf == null){
				em.persist(apnp);
			}else{
				em.merge(apnp);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<CatTabaquismo> obtenerTabaquismo() {
		try{
			CriteriaQuery<CatTabaquismo> criteria = em.getCriteriaBuilder().createQuery(CatTabaquismo.class);
			criteria.select(criteria.from(CatTabaquismo.class));
			return em.createQuery(criteria).getResultList();
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<CatDuracion> obtenerDuracion() {
		try{
			CriteriaQuery<CatDuracion> criteria = em.getCriteriaBuilder().createQuery(CatDuracion.class);
			criteria.select(criteria.from(CatDuracion.class));
			return em.createQuery(criteria).getResultList();
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<CatOrientacionSexual> obtenerOrientacionSexual() {
		try{
			CriteriaQuery<CatOrientacionSexual> criteria = em.getCriteriaBuilder().createQuery(CatOrientacionSexual.class);
			criteria.select(criteria.from(CatOrientacionSexual.class));
			return em.createQuery(criteria).getResultList();
		}catch(NoResultException nre){
			return null;
		} 
	}
	
	public List<CatEstadoCivil> obtenerEdoCivil() {
		try{
			CriteriaQuery<CatEstadoCivil> criteria = em.getCriteriaBuilder().createQuery(CatEstadoCivil.class);
			criteria.select(criteria.from(CatEstadoCivil.class));
			return em.createQuery(criteria).getResultList();
		}catch(NoResultException nre){
			return null;
		} 
	}
	
	public List<CatEscolaridad> obtenerEscolaridad() {
		try{
			CriteriaQuery<CatEscolaridad> criteria = em.getCriteriaBuilder().createQuery(CatEscolaridad.class);			 
			criteria.select(criteria.from(CatEscolaridad.class));
			return em.createQuery(criteria).getResultList();
		}catch(NoResultException nre){
			return null;
		} 
	}
}