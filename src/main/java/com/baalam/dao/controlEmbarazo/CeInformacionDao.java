package com.baalam.dao.controlEmbarazo;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.controlEmbarazo.ControlEmbarazo;

@Stateful
public class CeInformacionDao {
	
	@Inject
	private EntityManager em;
	
	public ControlEmbarazo buscarCeInformacionPorIdControlEmbarazo(Long idControlEmbarazo){
		ControlEmbarazo ce = new ControlEmbarazo();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ControlEmbarazo> criteria = cb.createQuery(ControlEmbarazo.class);
		Root<ControlEmbarazo> rCe = criteria.from(ControlEmbarazo.class);
		criteria.select(rCe).where(cb.equal(rCe.get("idControlEmbarazo"), idControlEmbarazo));
		try {
			ce =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return ce;
	}
	
	public void registrarCeInformacion(ControlEmbarazo ce){
		try{
			ControlEmbarazo cef = null;
			if(ce.getIdControlEmbarazo()!=null){
				cef = em.find(ControlEmbarazo.class, ce.getIdControlEmbarazo());
			}
			if(cef == null){
				em.persist(ce);
			}else{
				em.merge(ce);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
