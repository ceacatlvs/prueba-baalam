package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFCuello;

@Stateful
public class EfCuelloDao {
	
	@Inject
	private EntityManager em;
	
	public EFCuello buscarEFCuelloPorIdConsulta(Long idConsulta){
		EFCuello efCuello = new EFCuello();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFCuello> criteria = cb.createQuery(EFCuello.class);
		Root<EFCuello> rEfCuello = criteria.from(EFCuello.class);
		criteria.select(rEfCuello).where(cb.equal(rEfCuello.get("padecimientoActual"), idConsulta));
		try {
			efCuello =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efCuello;
	}
	
	public void registrarEfCuello(EFCuello efCuello){
		try{
			EFCuello efCuellof = em.find(EFCuello.class, efCuello.getPadecimientoActual().getIdConsulta());
			if(efCuellof == null){
				em.persist(efCuello);
			}else{				
				em.merge(efCuello);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}
