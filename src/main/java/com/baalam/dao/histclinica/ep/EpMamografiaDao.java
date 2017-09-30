package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPMamas;

@Stateful
public class EpMamografiaDao {

	@Inject
	private EntityManager em;
	
	public EPMamas buscarEPMamografiaPorIdConsulta(Long idConsulta){
		EPMamas epMamas = new EPMamas();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPMamas> criteria = cb.createQuery(EPMamas.class);
		Root<EPMamas> rEpMamas = criteria.from(EPMamas.class);
		criteria.select(rEpMamas).where(cb.equal(rEpMamas.get("padecimientoActual"), idConsulta));
		
		try{
			epMamas = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epMamas;
	}
	
	public void registrarEpMamografia(EPMamas epMamas){
		try{
			EPMamas epMamasf = em.find(EPMamas.class, epMamas.getPadecimientoActual().getIdConsulta());
			if(epMamasf == null){
				em.persist(epMamas);
			}else{
				em.merge(epMamas);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}