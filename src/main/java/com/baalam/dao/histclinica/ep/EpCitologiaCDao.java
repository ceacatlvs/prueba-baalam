package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPCitologiaCervical;

@Stateful
public class EpCitologiaCDao {

	@Inject
	private EntityManager em;
	
	public EPCitologiaCervical buscarEPCCPorIdConsulta(Long idConsulta){
		EPCitologiaCervical epCC = new EPCitologiaCervical();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPCitologiaCervical> criteria = cb.createQuery(EPCitologiaCervical.class);
		Root<EPCitologiaCervical> rEpCC = criteria.from(EPCitologiaCervical.class);
		criteria.select(rEpCC).where(cb.equal(rEpCC.get("padecimientoActual"), idConsulta));
		
		try{
			epCC = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epCC;
	}
	
	public void registrarEpBh(EPCitologiaCervical epCC){
		try{
			EPCitologiaCervical epCCf = em.find(EPCitologiaCervical.class, epCC.getPadecimientoActual().getIdConsulta());
			if(epCCf == null){
				em.persist(epCC);
			}else{
				em.merge(epCC);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
