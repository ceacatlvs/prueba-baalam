package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPCultivoSG;

@Stateful
public class EpCSVDao {

	@Inject
	private EntityManager em;
	
	public EPCultivoSG buscarEPCultivoSGPorIdConsulta(Long idConsulta){
		EPCultivoSG epBH = new EPCultivoSG();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPCultivoSG> criteria = cb.createQuery(EPCultivoSG.class);
		Root<EPCultivoSG> rEpCSG = criteria.from(EPCultivoSG.class);
		criteria.select(rEpCSG).where(cb.equal(rEpCSG.get("padecimientoActual"), idConsulta));
		
		try{
			epBH = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epBH;
	}
	
	public void registrarEpBh(EPCultivoSG epCSG){
		try{
			EPCultivoSG epCSGf = em.find(EPCultivoSG.class, epCSG.getPadecimientoActual().getIdConsulta());
			if(epCSGf == null){
				em.persist(epCSG);
			}else{
				em.merge(epCSG);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
