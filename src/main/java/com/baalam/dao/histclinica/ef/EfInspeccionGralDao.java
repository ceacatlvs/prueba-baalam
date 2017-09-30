package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFInspeccionGral;

@Stateful
public class EfInspeccionGralDao {

	@Inject
	private EntityManager em;
	
	public EFInspeccionGral buscarEFInspeccionGralPorIdConsulta(Long idConsulta){
		EFInspeccionGral efIG = new EFInspeccionGral();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFInspeccionGral> criteria = cb.createQuery(EFInspeccionGral.class);
		Root<EFInspeccionGral> rEfIG = criteria.from(EFInspeccionGral.class);
		criteria.select(rEfIG).where(cb.equal(rEfIG.get("padecimientoActual"), idConsulta));
		try {
			efIG =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efIG;
	}
	
	public void registrarEfInspeccionGral(EFInspeccionGral efIG){
		try{
			EFInspeccionGral efIGf = em.find(EFInspeccionGral.class, efIG.getPadecimientoActual().getIdConsulta());
			if(efIGf == null){
				em.persist(efIG);
			}else{				
				em.merge(efIG);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}
