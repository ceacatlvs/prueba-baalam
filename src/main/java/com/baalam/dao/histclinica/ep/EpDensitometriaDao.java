package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPDensitometria;

@Stateful
public class EpDensitometriaDao {

	@Inject
	private EntityManager em;
	
	public EPDensitometria buscarEPDensitometriaPorIdConsulta(Long idConsulta){
		EPDensitometria epDensi = new EPDensitometria();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPDensitometria> criteria = cb.createQuery(EPDensitometria.class);
		Root<EPDensitometria> rEpDensi = criteria.from(EPDensitometria.class);
		criteria.select(rEpDensi).where(cb.equal(rEpDensi.get("padecimientoActual"), idConsulta));
		
		try{
			epDensi = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epDensi;
	}
	
	public void registrarEpDensitometria(EPDensitometria epDensi){
		try{
			EPDensitometria epDensif = em.find(EPDensitometria.class, epDensi.getPadecimientoActual().getIdConsulta());
			if(epDensif == null){
				em.persist(epDensi);
			}else{
				em.merge(epDensi);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
