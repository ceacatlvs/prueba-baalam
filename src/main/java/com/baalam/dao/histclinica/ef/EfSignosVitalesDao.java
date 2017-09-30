package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFSignosVitales;

@Stateful
public class EfSignosVitalesDao {
	
	@Inject
	private EntityManager em;
	
	public EFSignosVitales buscarEFSignosVitalesPorIdConsulta(Long idConsulta){
		EFSignosVitales efSV = new EFSignosVitales();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFSignosVitales> criteria = cb.createQuery(EFSignosVitales.class);
		Root<EFSignosVitales> rEfSV = criteria.from(EFSignosVitales.class);
		criteria.select(rEfSV).where(cb.equal(rEfSV.get("padecimientoActual"), idConsulta));
		try {
			efSV =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efSV;
	}
	
	public void registrarEfSignosVitales(EFSignosVitales efSV){
		try{
			EFSignosVitales efSVf = em.find(EFSignosVitales.class, efSV.getPadecimientoActual().getIdConsulta());
			if(efSVf == null){
				em.persist(efSV);
			}else{				
				em.merge(efSV);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}
