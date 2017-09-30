package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFCardiovascular;

@Stateful
public class EfCardiovascularDao {

	@Inject
	private EntityManager em;
	
	public EFCardiovascular buscarEFCardiovascularPorIdConsulta(Long idConsulta){
		EFCardiovascular efCardio = new EFCardiovascular();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFCardiovascular> criteria = cb.createQuery(EFCardiovascular.class);
		Root<EFCardiovascular> rEfCardio = criteria.from(EFCardiovascular.class);
		criteria.select(rEfCardio).where(cb.equal(rEfCardio.get("padecimientoActual"), idConsulta));
		try {
			efCardio =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efCardio;
	}
	
	public void registrarEfCardiovascular(EFCardiovascular efCardio){
		try{
			EFCardiovascular efCardiof = em.find(EFCardiovascular.class, efCardio.getPadecimientoActual().getIdConsulta());
			if(efCardiof == null){
				em.persist(efCardio);
			}else{				
				em.merge(efCardio);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
}
