package com.baalam.dao.histclinica;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatTipoPaciente;
import com.baalam.model.histclinica.pa.PAMedicamento;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.model.paciente.Paciente;

@Stateful
public class PadecimientoActualDao {
	
	@PersistenceContext
	private EntityManager em;
	
	/*public PadecimientoActual buscarConsultaPorIdPaciente(Long idPaciente){
		PadecimientoActual pa = new PadecimientoActual();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PadecimientoActual> criteria = cb.createQuery(PadecimientoActual.class);
		Root<PadecimientoActual> rPa = criteria.from(PadecimientoActual.class);
		criteria.select(rPa).where(cb.equal(rPa.get("paciente"), idPaciente));
		try{
			pa = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return pa;
	}*/
	
	public PadecimientoActual buscarConsultaPorIdConsulta(Long idConsulta){
		PadecimientoActual pa = new PadecimientoActual();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PadecimientoActual> criteria = cb.createQuery(PadecimientoActual.class);
		Root<PadecimientoActual> rPa = criteria.from(PadecimientoActual.class);
		criteria.select(rPa).where(cb.equal(rPa.get("idConsulta"), idConsulta));
		try{
			pa = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return pa;	 	
	}
	
	public List<PAMedicamento> obtenerMedicamentosPorIdConsulta(Long idConsulta){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PAMedicamento> criteria = cb.createQuery(PAMedicamento.class);
		Root<PAMedicamento> rPAMedicamento = criteria.from(PAMedicamento.class);
		criteria.select(rPAMedicamento).where(cb.equal(rPAMedicamento.get("idConsulta"), idConsulta));
		try {
			List<PAMedicamento> medicamentos =  em.createQuery(criteria).getResultList();
			return medicamentos;
		} catch(NoResultException nre) {
			return null;
		} 
	}
	
	public void registrarConsulta(PadecimientoActual pa){
		try{
			PadecimientoActual paf= null;
			if(pa.getIdConsulta()!=null){
				 paf = em.find(PadecimientoActual.class, pa.getIdConsulta());
			}
			if(paf == null){
				em.persist(pa);
			}else{				
				em.merge(pa);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	} 
	
	public void registrarMedicamentosConsulta(PAMedicamento medicamento){
		try{
			PAMedicamento pamf = null;
			if(medicamento.getIdPAMedicamento()!=null){
				pamf = em.find(PAMedicamento.class, medicamento.getIdPAMedicamento());
			}
			if(pamf == null){
				em.persist(medicamento);
			}else{				
				em.merge(medicamento);		
			}
	    	em.flush();
	    }
	    catch(Exception e){
	    	  e.printStackTrace();
	    }
	}
	
	public void registrarFechaUltimaConsulta(Paciente paciente){
		try{
			em.merge(paciente);	
			em.flush();
		}catch(Exception e){
	    	  e.printStackTrace();
	      }	
	}
	
	public void borrarMedicamentosConsulta(PAMedicamento medicamento) {
		try{	
			em.remove(em.find(PAMedicamento.class, medicamento.getIdPAMedicamento()));		
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
	
	public List<CatTipoPaciente> obtenerTiposPaciente() {
		 CriteriaQuery<CatTipoPaciente> criteria = em.getCriteriaBuilder().createQuery(CatTipoPaciente.class);
		    criteria.select(criteria.from(CatTipoPaciente.class));
		    return em.createQuery(criteria).getResultList();
	}
	
	public CatTipoPaciente obtenerTipoPacientePorId(Long idCatTipoPaciente) {		    
		    CatTipoPaciente catTipoPaciente;
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CatTipoPaciente> criteria = cb.createQuery(CatTipoPaciente.class);
			Root<CatTipoPaciente> rCatTipoPaciente = criteria.from(CatTipoPaciente.class);
			criteria.select(rCatTipoPaciente).where(cb.equal(rCatTipoPaciente.get("idCatTipoPaciente"), idCatTipoPaciente));
			try{
				catTipoPaciente = em.createQuery(criteria).getSingleResult();
			} catch(NoResultException nre) {
				return null;
			}		
			return catTipoPaciente;
		    
		    
	}
}
