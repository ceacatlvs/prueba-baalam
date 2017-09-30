package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPEgo;

@Stateful
public class EpEGODao {
	
	@Inject
	private EntityManager em;
	
	public EPEgo buscarEPEgoPorIdConsulta(Long idConsulta) {
		EPEgo epEGO = new EPEgo();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPEgo> criteria = cb.createQuery(EPEgo.class);
		Root<EPEgo> rEpEgo = criteria.from(EPEgo.class);
		criteria.select(rEpEgo).where(cb.equal(rEpEgo.get("padecimientoActual"), idConsulta));
		
		try{
			epEGO= em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epEGO; 
	}

	public void registrarEpEGO(EPEgo epEGO) {
		try{
			EPEgo epEGOf = em.find(EPEgo.class, epEGO.getPadecimientoActual().getIdConsulta());
			if(epEGOf == null){
				em.persist(epEGO);
			}else{
				em.merge(epEGO);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
