package com.baalam.dao.controlEmbarazo;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.controlEmbarazo.CeFinEmbarazo;

@Stateful
public class CeFinEmbarazoDao {
	
	@Inject
	private EntityManager em;
	
	public CeFinEmbarazo buscarCeFinEmbarazoPorId(Long idCEFin){
		CeFinEmbarazo cef;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CeFinEmbarazo> criteria = cb.createQuery(CeFinEmbarazo.class);
		Root<CeFinEmbarazo> rCe = criteria.from(CeFinEmbarazo.class);
		criteria.select(rCe).where(cb.equal(rCe.get("idCEFin"), idCEFin));
		try {
			cef =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return cef;
	}
	
	public void registrarCeFinEmbarazo(CeFinEmbarazo cef){
		try{
			CeFinEmbarazo cefant = null;
			if(cef.getIdCEFin()!=null){
				cefant = em.find(CeFinEmbarazo.class, cef.getIdCEFin());
			}
			if(cefant == null){
				em.persist(cef);
			}else{
				em.merge(cef);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}