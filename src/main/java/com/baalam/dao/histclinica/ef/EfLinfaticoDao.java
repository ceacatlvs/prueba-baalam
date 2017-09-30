package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFLinfatico;

@Stateful
public class EfLinfaticoDao {

	@Inject
	private EntityManager em;
	
	public EFLinfatico buscarEFLinfaticoPorIdConsulta(Long idConsulta){
		EFLinfatico efLinfa = new EFLinfatico();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFLinfatico> criteria = cb.createQuery(EFLinfatico.class);
		Root<EFLinfatico> rEfLinfa = criteria.from(EFLinfatico.class);
		criteria.select(rEfLinfa).where(cb.equal(rEfLinfa.get("padecimientoActual"), idConsulta));
		try {
			efLinfa =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efLinfa;
	}
	
	public void registrarEfLinfatico(EFLinfatico efLinfa){
		try{
			EFLinfatico efLinfaf = em.find(EFLinfatico.class, efLinfa.getPadecimientoActual().getIdConsulta());
			if(efLinfaf == null){
				em.persist(efLinfa);
			}else{				
				em.merge(efLinfa);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
}
