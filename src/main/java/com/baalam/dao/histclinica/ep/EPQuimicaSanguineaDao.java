package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPQuimicaSanguiena;

@Stateful
public class EPQuimicaSanguineaDao {
	
	@Inject
	private EntityManager em;

	public EPQuimicaSanguiena buscarEPQSPorIdConsulta(Long idConsulta) {
		EPQuimicaSanguiena epQS = new EPQuimicaSanguiena();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPQuimicaSanguiena> criteria = cb.createQuery(EPQuimicaSanguiena.class);
		Root<EPQuimicaSanguiena> rEpQS = criteria.from(EPQuimicaSanguiena.class);
		criteria.select(rEpQS).where(cb.equal(rEpQS.get("padecimientoActual"), idConsulta));
		
		try{
			epQS = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epQS; 
	}

	public void registrarEpBh(EPQuimicaSanguiena epQS) {
		try{
			EPQuimicaSanguiena epQsf = em.find(EPQuimicaSanguiena.class, epQS.getPadecimientoActual().getIdConsulta());
			if(epQsf == null){
				em.persist(epQS);
			}else{
				em.merge(epQS);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}