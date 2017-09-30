package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFPiel;

@Stateful
public class EfPielDao {

	@Inject
	private EntityManager em;
	
	public EFPiel buscarEFPielPorIdConsulta(Long idConsulta){
		EFPiel efPiel = new EFPiel();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFPiel> criteria = cb.createQuery(EFPiel.class);
		Root<EFPiel> rEfPiel = criteria.from(EFPiel.class);
		criteria.select(rEfPiel).where(cb.equal(rEfPiel.get("padecimientoActual"), idConsulta));
		try {
			efPiel =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efPiel;
	}
	
	public void registrarEfPiel(EFPiel efPiel){
		try{
			EFPiel efPielf = em.find(EFPiel.class, efPiel.getPadecimientoActual().getIdConsulta());
			if(efPielf == null){
				em.persist(efPiel);
			}else{				
				em.merge(efPiel);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
}
