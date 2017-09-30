package com.baalam.dao.histclinica;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.tratamiento.Tratamiento;
import com.baalam.model.histclinica.tratamiento.TratamientoFarmacos;

@Stateful
public class TratamientoDao {
	
	@Inject
	private EntityManager em;
	
	public Tratamiento buscarTratamientoPorIdConsulta(Long idConsulta){
		Tratamiento trata = new Tratamiento();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tratamiento> criteria = cb.createQuery(Tratamiento.class);
		Root<Tratamiento> rTrata = criteria.from(Tratamiento.class);
		criteria.select(rTrata).where(cb.equal(rTrata.get("padecimientoActual"), idConsulta));
		try {
			trata =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return trata;
	}
	
	public List<TratamientoFarmacos> obtenerFarmacosPorIdConsulta(Long idConsulta){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TratamientoFarmacos> criteria = cb.createQuery(TratamientoFarmacos.class);
		Root<TratamientoFarmacos> rTrataFarmaco = criteria.from(TratamientoFarmacos.class);
		criteria.select(rTrataFarmaco).where(cb.equal(rTrataFarmaco.get("padecimientoActual"), idConsulta));
		try {
			List<TratamientoFarmacos> farmacos =  em.createQuery(criteria).getResultList();
			return farmacos;
		} catch(NoResultException nre) {
			return null;
		} 
	}
	
	public void registrarTratamiento(Tratamiento trata){
		try{
			Tratamiento trataf = em.find(Tratamiento.class, trata.getPadecimientoActual().getIdConsulta());
			if(trataf == null){
				em.persist(trata);
			}else{				
				em.merge(trata);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
	
	public void registrarTratamientoFarmacos(TratamientoFarmacos trataFarma){
		try{
			TratamientoFarmacos trataFarmaf = null;
			if(trataFarma.getIdTratamientoFarmaco()!=null){
				trataFarmaf = em.find(TratamientoFarmacos.class, trataFarma.getIdTratamientoFarmaco());
			}
			if(trataFarmaf == null){
				em.persist(trataFarma);
			}else{				
				em.merge(trataFarma);		
			}
	    	em.flush();
	    }
	    catch(Exception e){
	    	  e.printStackTrace();
	    }
	}
	
	public void borrarFarmacoTratamiento(TratamientoFarmacos farmaco) {
		try{	
			em.remove(em.find(TratamientoFarmacos.class, farmaco.getIdTratamientoFarmaco()));		
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
}
