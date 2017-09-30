package com.baalam.dao.histclinica;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.EvolucionCuadroClinico;

@Stateful
public class EvolucionCuadroClinicoDao {
	
	@Inject
	private EntityManager em;
	
	public EvolucionCuadroClinico buscarECCPorIdConsulta(Long idConsulta){
		EvolucionCuadroClinico ecc = new EvolucionCuadroClinico();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EvolucionCuadroClinico> criteria = cb.createQuery(EvolucionCuadroClinico.class);
		Root<EvolucionCuadroClinico> rEcc = criteria.from(EvolucionCuadroClinico.class);
		criteria.select(rEcc).where(cb.equal(rEcc.get("padecimientoActual"), idConsulta));
		try {
			ecc =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return ecc;
	}
	
	public void registrarECC(EvolucionCuadroClinico ecc){
		try{
			EvolucionCuadroClinico eccf = em.find(EvolucionCuadroClinico.class, ecc.getPadecimientoActual().getIdConsulta());
			if(eccf == null){
				em.persist(ecc);
			}else{				
				em.merge(ecc);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}