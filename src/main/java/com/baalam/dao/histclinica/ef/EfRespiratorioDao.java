package com.baalam.dao.histclinica.ef;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ef.EFRespiratorio;

@Stateful
public class EfRespiratorioDao {
	
	@Inject
	private EntityManager em;
	
	public EFRespiratorio buscarEFRespiratorioPorIdConsulta(Long idConsulta){
		EFRespiratorio efResp = new EFRespiratorio();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EFRespiratorio> criteria = cb.createQuery(EFRespiratorio.class);
		Root<EFRespiratorio> rEfResp = criteria.from(EFRespiratorio.class);
		criteria.select(rEfResp).where(cb.equal(rEfResp.get("padecimientoActual"), idConsulta));
		try {
			efResp =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return efResp;
	}
	
	public void registrarEfRespiratorio(EFRespiratorio efRespiratorio){
		try{
			EFRespiratorio efRespiratoriof = em.find(EFRespiratorio.class, efRespiratorio.getPadecimientoActual().getIdConsulta());
			if(efRespiratoriof == null){
				em.persist(efRespiratorio);
			}else{				
				em.merge(efRespiratorio);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}
