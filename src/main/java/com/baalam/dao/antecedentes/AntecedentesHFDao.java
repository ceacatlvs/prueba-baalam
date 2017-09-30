package com.baalam.dao.antecedentes;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatEnfermedadesFamiliares;
import com.baalam.model.histclinica.ant.hf.AHFEnfFamiliares;
import com.baalam.model.histclinica.ant.hf.AHFFallecimiento;

@Stateful
public class AntecedentesHFDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void registrarFallecimiento(AHFFallecimiento ahff){
		try{
			if(ahff.getIdFamiliar()!=null){
				AHFFallecimiento ahffAnt = em.find(AHFFallecimiento.class, ahff.getIdFamiliar());
				if(ahffAnt == null){
					em.persist(ahff);
				}else{
					em.merge(ahff);
				}
			}else{
				em.persist(ahff);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void eliminarHermanosVivos(List<AHFFallecimiento> lista){

		for(AHFFallecimiento hermano: lista){
			try{
				em.remove(em.find(AHFFallecimiento.class, hermano.getIdFamiliar()));
				em.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void borrarEnfermedadesDePaciente(AHFEnfFamiliares enfermedad){
		try{	
			em.remove(em.find(AHFEnfFamiliares.class, enfermedad.getIdEnfermedad()));
			em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }	
	}
	
	public void registrarEnfermedad(AHFEnfFamiliares ahef){
		try{
//			if(ahef.getIdEnfermedad()!=null){
//				AHFEnfFamiliares ahefAnt = em.find(AHFEnfFamiliares.class, ahef.getIdEnfermedad());
//				if(ahefAnt == null){
//					em.persist(ahef);
//				}else{
//					em.merge(ahef);
//				}
//			}else{
				ahef.setIdEnfermedad(null);
				em.persist(ahef);
//			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<AHFEnfFamiliares> obtenerEnfermedadesFamiliaresPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AHFEnfFamiliares> criteria = cb.createQuery(AHFEnfFamiliares.class);
		Root<AHFEnfFamiliares> rAHFEnfFamiliares = criteria.from(AHFEnfFamiliares.class);
		criteria.select(rAHFEnfFamiliares).where(cb.equal(rAHFEnfFamiliares.get("paciente"), idPaciente));	
		
		try{
			List<AHFEnfFamiliares> listaEnfermedades = em.createQuery(criteria).getResultList();
			return listaEnfermedades;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<AHFFallecimiento> obtenerFallecimientosFamiliaresPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AHFFallecimiento> criteria = cb.createQuery(AHFFallecimiento.class);
		Root<AHFFallecimiento> rAHFFallecimiento = criteria.from(AHFFallecimiento.class);
		criteria.select(rAHFFallecimiento).where(cb.equal(rAHFFallecimiento.get("paciente"), idPaciente));
		criteria.orderBy(cb.asc(rAHFFallecimiento.get("parentesco")));
		
		try{
			List<AHFFallecimiento> listaFallecimientos = em.createQuery(criteria).getResultList();
			return listaFallecimientos;
		}catch(NoResultException nre){
			return null;
		}
	}

	public List<CatEnfermedadesFamiliares> obtenerCatEnfermedades() {				
		CriteriaQuery<CatEnfermedadesFamiliares> criteria = em.getCriteriaBuilder().createQuery(CatEnfermedadesFamiliares.class);
		criteria.select(criteria.from(CatEnfermedadesFamiliares.class));
		return em.createQuery(criteria).getResultList();
	}
}