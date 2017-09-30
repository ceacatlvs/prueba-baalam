package com.baalam.dao.histclinica.ep;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPOtrosEstudios;

@Stateful
public class EpOtrosDao {

	@Inject
	private EntityManager em;
	
	public EPOtrosEstudios buscarEPOtrosPorIdConsulta(Long idConsulta){
		EPOtrosEstudios epOtros = new EPOtrosEstudios();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPOtrosEstudios> criteria = cb.createQuery(EPOtrosEstudios.class);
		Root<EPOtrosEstudios> rEpOtros = criteria.from(EPOtrosEstudios.class);
		criteria.select(rEpOtros).where(cb.equal(rEpOtros.get("padecimientoActual"), idConsulta));
		
		try{
			epOtros = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epOtros;
	}
	
	public void registrarEpOtros(EPOtrosEstudios epOtros){
		try{
			EPOtrosEstudios epOtrosf = em.find(EPOtrosEstudios.class, epOtros.getPadecimientoActual().getIdConsulta());
			if(epOtrosf == null){
				em.persist(epOtros);
			}else{
				em.merge(epOtros);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
