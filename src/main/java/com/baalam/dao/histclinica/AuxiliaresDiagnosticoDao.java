package com.baalam.dao.histclinica;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.ads.ADSGabinete;
import com.baalam.model.histclinica.ads.ADSLaboratorio;

@Stateful
public class AuxiliaresDiagnosticoDao {
	
	@Inject
	private EntityManager em;
	
	public ADSGabinete buscarADSGabinetePorIdConsulta(Long idConsulta){
		ADSGabinete adsGabinete = new ADSGabinete();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ADSGabinete> criteria = cb.createQuery(ADSGabinete.class);
		Root<ADSGabinete> rAdsGabinete = criteria.from(ADSGabinete.class);
		criteria.select(rAdsGabinete).where(cb.equal(rAdsGabinete.get("padecimientoActual"), idConsulta));
		try {
			adsGabinete =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return adsGabinete;
	}
	
	public ADSLaboratorio buscarADSLaboratorioPorIdConsulta(Long idConsulta){
		ADSLaboratorio adsLab = new ADSLaboratorio();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ADSLaboratorio> criteria = cb.createQuery(ADSLaboratorio.class);
		Root<ADSLaboratorio> rAdsLab = criteria.from(ADSLaboratorio.class);
		criteria.select(rAdsLab).where(cb.equal(rAdsLab.get("padecimientoActual"), idConsulta));
		try {
			adsLab =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return adsLab;
	}
	
	public void registrarADSGabinete(ADSGabinete adsGab){
		try{
			ADSGabinete adsGabf = em.find(ADSGabinete.class, adsGab.getPadecimientoActual().getIdConsulta());
			if(adsGabf == null){
				em.persist(adsGab);
			}else{				
				em.merge(adsGab);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
	
	public void registrarADSLaboratorio(ADSLaboratorio adsLab){
		try{
			ADSLaboratorio adsLabf = em.find(ADSLaboratorio.class, adsLab.getPadecimientoActual().getIdConsulta());
			if(adsLabf == null){
				em.persist(adsLab);
			}else{				
				em.merge(adsLab);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
}