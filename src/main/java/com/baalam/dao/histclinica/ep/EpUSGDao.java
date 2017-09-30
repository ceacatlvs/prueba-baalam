package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPUltrasonido;

@Stateful
public class EpUSGDao {

	@Inject
	private EntityManager em;
	
	public EPUltrasonido buscarEPUltrasonidoPorIdConsulta(Long idConsulta){
		EPUltrasonido epUSG = new EPUltrasonido();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPUltrasonido> criteria = cb.createQuery(EPUltrasonido.class);
		Root<EPUltrasonido> rEpUSG = criteria.from(EPUltrasonido.class);
		criteria.select(rEpUSG).where(cb.equal(rEpUSG.get("padecimientoActual"), idConsulta));
		
		try{
			epUSG = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epUSG;
	}
	
	public void registrarEpUltrasonido(EPUltrasonido epUSG){
		try{
			EPUltrasonido epUSGf = em.find(EPUltrasonido.class, epUSG.getPadecimientoActual().getIdConsulta());
			if(epUSGf == null){
				em.persist(epUSG);
			}else{
				em.merge(epUSG);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
