package com.baalam.dao.controlPagos;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatTipoPago;
import com.baalam.model.controlPagos.CpCobroConsulta;
import com.baalam.model.controlPagos.CpPagos;
import com.baalam.model.histclinica.pa.PadecimientoActual;

@Stateful
public class ControlPagosDao {
	
	@Inject
	private EntityManager em;
	
	public List<CpCobroConsulta> obtenerCobrosConsultaPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CpCobroConsulta> criteria = cb.createQuery(CpCobroConsulta.class);
		Root<CpCobroConsulta> rCpCobroConsulta = criteria.from(CpCobroConsulta.class);
		Path<PadecimientoActual> consulta = rCpCobroConsulta.get("padecimientoActual");
		criteria.select(rCpCobroConsulta).where(cb.equal(consulta.get("paciente"), idPaciente));
		
		try{
			List<CpCobroConsulta> cobros = em.createQuery(criteria).getResultList();
			return cobros;
		}catch(NoResultException nre){
			return null;
		}		
	}
	
	public void registrarCobroConsulta(CpCobroConsulta cobroConsulta){
		try{
			CpCobroConsulta cobroConsultaf= null;
			if(cobroConsulta.getIdCPCobroConsulta()!=null){
				cobroConsultaf = em.find(CpCobroConsulta.class, cobroConsulta.getIdCPCobroConsulta());
			}
			if(cobroConsultaf == null){
				em.merge(cobroConsulta.getPadecimientoActual());
				em.persist(cobroConsulta);
			}else{				
				em.merge(cobroConsulta);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
	
	public void registrarPagoConsulta(CpPagos pago){
		try{			
			if(pago.getIdCPPagoCobro() == null){								
				em.persist(pago);
				em.merge(pago.getCpCobroConsulta());
			}else{				
				em.merge(pago);		
			}
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
	
	public List<CatTipoPago> obtenerTipoPago() {
		CriteriaQuery<CatTipoPago> criteria = em.getCriteriaBuilder().createQuery(CatTipoPago.class);
		criteria.select(criteria.from(CatTipoPago.class));
		return em.createQuery(criteria).getResultList();
	}	
}