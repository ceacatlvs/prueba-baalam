package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPUrocultivo;

@Stateful
public class EpUrocultivoDao {

	@Inject
	private EntityManager em;
	
	public EPUrocultivo buscarEPUroorIdConsulta(Long idConsulta) {
		EPUrocultivo epUro = new EPUrocultivo();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPUrocultivo> criteria = cb.createQuery(EPUrocultivo.class);
		Root<EPUrocultivo> rEpUro = criteria.from(EPUrocultivo.class);
		criteria.select(rEpUro).where(cb.equal(rEpUro.get("padecimientoActual"), idConsulta));
		
		try{
			epUro = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epUro; 
	}

	public void registrarEpEGO(EPUrocultivo epUro) {
		try{
			EPUrocultivo epUrof = em.find(EPUrocultivo.class, epUro.getPadecimientoActual().getIdConsulta());
			if(epUrof == null){
				em.persist(epUro);
			}else{
				em.merge(epUro);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
