package com.baalam.dao.histclinica;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatEspecialidad;
import com.baalam.model.histclinica.id.IDDiagnostico;
import com.baalam.model.histclinica.id.ImpresionDiagnostica;

@Stateful
public class ImpresionDiagnosticaDao {
	
	@Inject
	private EntityManager em;
	
	public ImpresionDiagnostica buscarImpresionDiagnosticaPorIdConsulta(Long idConsulta){
		ImpresionDiagnostica impDiag = new ImpresionDiagnostica();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ImpresionDiagnostica> criteria = cb.createQuery(ImpresionDiagnostica.class);
		Root<ImpresionDiagnostica> rImpDiag = criteria.from(ImpresionDiagnostica.class);
		criteria.select(rImpDiag).where(cb.equal(rImpDiag.get("padecimientoActual"), idConsulta));
		try {
			impDiag =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return impDiag;
	}
	
	public void registrarImpresionDiagnostica(ImpresionDiagnostica id){
		try{
			ImpresionDiagnostica idf = em.find(ImpresionDiagnostica.class, id.getPadecimientoActual().getIdConsulta());
			if(idf == null){
				em.persist(id);
			}else{				
				em.merge(id);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
	
	public List<IDDiagnostico> obtenerDiagnosticosPorIdConsulta(Long idConsulta){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IDDiagnostico> criteria = cb.createQuery(IDDiagnostico.class);
		Root<IDDiagnostico> rIDDiagnostico = criteria.from(IDDiagnostico.class);
		criteria.select(rIDDiagnostico).where(cb.equal(rIDDiagnostico.get("padecimientoActual"), idConsulta));
		try {
			List<IDDiagnostico> diagnosticos =  em.createQuery(criteria).getResultList();
			return diagnosticos;
		} catch(NoResultException nre) {
			return null;
		} 
	}
	
	public void registrarDiagnosticos(IDDiagnostico diagnostico){
		try{
			IDDiagnostico diagnosticof = null;
			if(diagnostico.getIdIdDiagnostico()!=null){
				diagnosticof = em.find(IDDiagnostico.class, diagnostico.getIdIdDiagnostico());
			}
			if(diagnosticof == null){
				em.persist(diagnostico);
			}else{				
				em.merge(diagnostico);		
			}
	    	em.flush();
	    }
	    catch(Exception e){
	    	  e.printStackTrace();
	    }
	}
	
	public void borrarDiagnosticos(IDDiagnostico diagnostico) {
		try{	
			em.remove(em.find(IDDiagnostico.class, diagnostico.getIdIdDiagnostico()));		
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
	
	public List<CatEspecialidad> obtenerEspecialidades() {		
		try{
			CriteriaQuery<CatEspecialidad> criteria = em.getCriteriaBuilder().createQuery(CatEspecialidad.class);			 
			criteria.select(criteria.from(CatEspecialidad.class));
			return em.createQuery(criteria).getResultList();
		}catch(NoResultException nre){
			return null;
		} 
	}
}