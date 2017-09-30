package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPVdrlHiv;

@Stateful
public class EpVHDao {
	
	@Inject
	private EntityManager em;
	
	public EPVdrlHiv buscarEPVHPorIdConsulta(Long idConsulta) {
		EPVdrlHiv epVH = new EPVdrlHiv();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPVdrlHiv> criteria = cb.createQuery(EPVdrlHiv.class);
		Root<EPVdrlHiv> rEpVH = criteria.from(EPVdrlHiv.class);
		criteria.select(rEpVH).where(cb.equal(rEpVH.get("padecimientoActual"), idConsulta));
		
		try{
			epVH = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epVH; 
	}

	public void registrarEpVH(EPVdrlHiv epVH) {
		try{
			EPVdrlHiv epVhf = em.find(EPVdrlHiv.class, epVH.getPadecimientoActual().getIdConsulta());
			if(epVhf == null){
				em.persist(epVH);
			}else{
				em.merge(epVH);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
