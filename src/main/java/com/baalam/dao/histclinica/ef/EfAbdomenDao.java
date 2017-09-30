package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFAbdomen;

@Stateful
public class EfAbdomenDao {

	@Inject
	private EntityManager em;
	
	public EFAbdomen buscarEFAbdomenPorIdConsulta(Long idConsulta){
		EFAbdomen efAbdomen = new EFAbdomen();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFAbdomen> criteria = cb.createQuery(EFAbdomen.class);
		Root<EFAbdomen> rEfAbdomen = criteria.from(EFAbdomen.class);
		criteria.select(rEfAbdomen).where(cb.equal(rEfAbdomen.get("padecimientoActual"), idConsulta));
		try {
			efAbdomen =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efAbdomen;
	}
	
	public void registrarEfAbdomen(EFAbdomen efAbdomen){
		try{
			EFAbdomen efAbdomenf = em.find(EFAbdomen.class, efAbdomen.getPadecimientoActual().getIdConsulta());
			if(efAbdomenf == null){
				em.persist(efAbdomen);
			}else{				
				em.merge(efAbdomen);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
}
