package com.baalam.dao.controlEmbarazo;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatLA;
import com.baalam.model.catalogo.CatPlacenta;
import com.baalam.model.catalogo.CatSexo;
import com.baalam.model.controlEmbarazo.CeUltrasonido;

@Stateful
public class CeUltrasonidoDao {
	
	@Inject
	private EntityManager em;
	
	public List<CeUltrasonido> obtenerUltrasonidosPorControlEmbarazo(Long idControlEmbarazo){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CeUltrasonido> criteria = cb.createQuery(CeUltrasonido.class);
		Root<CeUltrasonido> rCeUltrasonido = criteria.from(CeUltrasonido.class);
		criteria.select(rCeUltrasonido).where(cb.equal(rCeUltrasonido.get("controlEmbarazo"), idControlEmbarazo));
		try{
			List<CeUltrasonido> ultrasonidos = em.createQuery(criteria).getResultList();
			return ultrasonidos;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public void registrarUltrasonidosControlEmbarazo(CeUltrasonido ceUsg){
		try{
			CeUltrasonido ceUsgf = null;
			if(ceUsg.getIdCEUltrasonido() != null){
				ceUsgf = em.find(CeUltrasonido.class, ceUsg.getIdCEUltrasonido());
			}
			if(ceUsgf == null){
				em.persist(ceUsg);
			}else{
				em.merge(ceUsg);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<CatPlacenta> obtenerPlacenta() {
		CriteriaQuery<CatPlacenta> criteria = em.getCriteriaBuilder().createQuery(CatPlacenta.class);
		criteria.select(criteria.from(CatPlacenta.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<CatLA> obtenerLA() {
		CriteriaQuery<CatLA> criteria = em.getCriteriaBuilder().createQuery(CatLA.class);
		criteria.select(criteria.from(CatLA.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<CatSexo> obtenerSexo() {
		CriteriaQuery<CatSexo> criteria = em.getCriteriaBuilder().createQuery(CatSexo.class);
		criteria.select(criteria.from(CatSexo.class));
		return em.createQuery(criteria).getResultList();
	}
}
