package com.baalam.dao.controlEmbarazo;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatEdema;
import com.baalam.model.catalogo.CatEdemaX;
import com.baalam.model.catalogo.CatMsFs;
import com.baalam.model.catalogo.CatPres;
import com.baalam.model.controlEmbarazo.CeSeguimiento;

@Stateful
public class CeSeguimientoDao {
	
	@Inject
	private EntityManager em;
	
	public List<CeSeguimiento> obtenerSeguimientosPorControlEmbarazo(Long idControlEmbarazo){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CeSeguimiento> criteria = cb.createQuery(CeSeguimiento.class);
		Root<CeSeguimiento> rCeSeguimiento = criteria.from(CeSeguimiento.class);
		criteria.select(rCeSeguimiento).where(cb.equal(rCeSeguimiento.get("controlEmbarazo"), idControlEmbarazo));
		try{
			List<CeSeguimiento> seguimientos = em.createQuery(criteria).getResultList();
			return seguimientos;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public void registrarSeguimientosControlEmbarazo(CeSeguimiento ceSeg){
		try{
			CeSeguimiento ceSegf = null;
			if(ceSeg.getIdCESeguimiento() != null){
				ceSegf = em.find(CeSeguimiento.class, ceSeg.getIdCESeguimiento());
			}
			if(ceSegf == null){
				em.persist(ceSeg);
			}else{
				em.merge(ceSeg);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<CatMsFs> obtenerMsFs() {
		CriteriaQuery<CatMsFs> criteria = em.getCriteriaBuilder().createQuery(CatMsFs.class);
		criteria.select(criteria.from(CatMsFs.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<CatPres> obtenerPres() {
		CriteriaQuery<CatPres> criteria = em.getCriteriaBuilder().createQuery(CatPres.class);
		criteria.select(criteria.from(CatPres.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<CatEdema> obtenerEdema() {
		CriteriaQuery<CatEdema> criteria = em.getCriteriaBuilder().createQuery(CatEdema.class);
		criteria.select(criteria.from(CatEdema.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<CatEdemaX> obtenerEdemaX() {
		CriteriaQuery<CatEdemaX> criteria = em.getCriteriaBuilder().createQuery(CatEdemaX.class);
		criteria.select(criteria.from(CatEdemaX.class));
		return em.createQuery(criteria).getResultList();
	}
}
