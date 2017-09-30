package com.baalam.dao.histclinica.ep;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ep.EPBiometriaHematica;

@Stateful
public class EpBiometriaHematicaDao {
	
	@Inject
	private EntityManager em;
	
	public EPBiometriaHematica buscarEPBHPorIdConsulta(Long idConsulta){
		EPBiometriaHematica epBH = new EPBiometriaHematica();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EPBiometriaHematica> criteria = cb.createQuery(EPBiometriaHematica.class);
		Root<EPBiometriaHematica> rEpBH = criteria.from(EPBiometriaHematica.class);
		criteria.select(rEpBH).where(cb.equal(rEpBH.get("padecimientoActual"), idConsulta));
		
		try{
			epBH = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return epBH;
	}
	
	public List<EPBiometriaHematica> buscarEPBHPorIdPaciente(Long idPaciente){
		
		return null;
	}
	
	public void registrarEpBh(EPBiometriaHematica epBh){
		try{
			EPBiometriaHematica epBhf = em.find(EPBiometriaHematica.class, epBh.getPadecimientoActual().getIdConsulta());
			if(epBhf == null){
				em.persist(epBh);
			}else{
				em.merge(epBh);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
