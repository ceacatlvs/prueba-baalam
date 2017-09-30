package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPColposcopia;

@Stateful
public class EpColposcopiaDao {

	@Inject
	private EntityManager em;
	
	public EPColposcopia buscarEPColposcopiaPorIdConsulta(Long idConsulta){
		EPColposcopia epColps = new EPColposcopia();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPColposcopia> criteria = cb.createQuery(EPColposcopia.class);
		Root<EPColposcopia> rEpColps = criteria.from(EPColposcopia.class);
		criteria.select(rEpColps).where(cb.equal(rEpColps.get("padecimientoActual"), idConsulta));
		
		try{
			epColps = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epColps;
	}
	
	public void registrarEpColposcopia(EPColposcopia epColps){
		try{
			EPColposcopia epColpsf = em.find(EPColposcopia.class, epColps.getPadecimientoActual().getIdConsulta());
			if(epColpsf == null){
				System.out.print("colpos en dao " + epColps);
				em.persist(epColps);
			}else{
				em.merge(epColps);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
