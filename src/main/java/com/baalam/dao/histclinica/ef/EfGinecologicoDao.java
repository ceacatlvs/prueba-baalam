package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFGinecologico;

@Stateful
public class EfGinecologicoDao {
	
	@Inject
	private EntityManager em;
	
	public EFGinecologico buscarEFGinecologicoPorIdConsulta(Long idConsulta){
		EFGinecologico efGineco = new EFGinecologico();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFGinecologico> criteria = cb.createQuery(EFGinecologico.class);
		Root<EFGinecologico> rEfGineco = criteria.from(EFGinecologico.class);
		criteria.select(rEfGineco).where(cb.equal(rEfGineco.get("padecimientoActual"), idConsulta));
		try {
			efGineco =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efGineco;
	}
	
	public void registrarEfGinecologico(EFGinecologico efGineco){
		try{
			EFGinecologico efGinecof = em.find(EFGinecologico.class, efGineco.getPadecimientoActual().getIdConsulta());
			if(efGinecof == null){
				em.persist(efGineco);
			}else{				
				em.merge(efGineco);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}
