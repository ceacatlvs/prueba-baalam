package com.baalam.dao.inicio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.ConsultaDiaHoy;

@Stateful
public class ConsultaHoyDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<ConsultaDiaHoy> buscarConsultaHoyPorDoctor(Long idDoctor){
		List<ConsultaDiaHoy> consultas = new ArrayList<ConsultaDiaHoy>();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ConsultaDiaHoy> criteria = cb.createQuery(ConsultaDiaHoy.class);
		Root<ConsultaDiaHoy> rConsulta = criteria.from(ConsultaDiaHoy.class);
		criteria.select(rConsulta).where(cb.equal(rConsulta.get("idDoctor"), idDoctor));
		try{
			consultas = em.createQuery(criteria).getResultList();
		} catch(NoResultException nre) {
			return null;
		}		
		return consultas;
	}
}