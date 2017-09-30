package com.baalam.dao.controlEmbarazo;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.controlEmbarazo.CeLaboratorio;

@Stateful
public class CeLaboratorioDao {
	
	@Inject
	private EntityManager em;
	
	public List<CeLaboratorio> obtenerLaboratoriosPorControlEmbarazo(Long idControlEmbarazo){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CeLaboratorio> criteria = cb.createQuery(CeLaboratorio.class);
		Root<CeLaboratorio> rCeLab = criteria.from(CeLaboratorio.class);
		criteria.select(rCeLab).where(cb.equal(rCeLab.get("controlEmbarazo"), idControlEmbarazo));
		try{
			List<CeLaboratorio> laboratorios = em.createQuery(criteria).getResultList();
			return laboratorios;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public void registrarLaboratoriosControlEmbarazo(CeLaboratorio ceLab){
		try{
			CeLaboratorio ceLabf = null;
			if(ceLab.getIdCELaboratorio() != null){
				ceLabf = em.find(CeLaboratorio.class, ceLab.getIdCELaboratorio());
			}
			if(ceLabf == null){
				em.persist(ceLab);
			}else{
				em.merge(ceLab);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}