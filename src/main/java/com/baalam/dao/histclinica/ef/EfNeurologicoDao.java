package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFNeuroEMental;

@Stateful
public class EfNeurologicoDao {

	@Inject
	private EntityManager em;
	
	public EFNeuroEMental buscarEFNeuroEMentalPorIdConsulta(Long idConsulta){
		EFNeuroEMental efMental = new EFNeuroEMental();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFNeuroEMental> criteria = cb.createQuery(EFNeuroEMental.class);
		Root<EFNeuroEMental> rEfMental = criteria.from(EFNeuroEMental.class);
		criteria.select(rEfMental).where(cb.equal(rEfMental.get("padecimientoActual"), idConsulta));
		try {
			efMental =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efMental;
	}
	
	public void registrarEfNeuroEMental(EFNeuroEMental efMental){
		try{
			EFNeuroEMental efMentalf = em.find(EFNeuroEMental.class, efMental.getPadecimientoActual().getIdConsulta());
			if(efMentalf == null){
				em.persist(efMental);
			}else{				
				em.merge(efMental);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}
