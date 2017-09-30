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

import com.baalam.model.HistorialConsultas;
import com.baalam.model.paciente.Paciente;
import com.baalam.model.paciente.PacienteDetalle;

@Stateful
public class PacienteDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Paciente> pacientesSubsecuentesPorIdDoctor(Long idDoctor, String nombre){
			List<Paciente> pacientes = new ArrayList<Paciente>();
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Paciente> criteria = cb.createQuery(Paciente.class);
			Root<Paciente> rPaciente = criteria.from(Paciente.class);
			criteria.select(rPaciente).where(cb.like(rPaciente.<String>get("nombrePaciente"), "%" + nombre + "%"),
											cb.equal(rPaciente.get("doctor"), idDoctor),
											cb.isNotNull(rPaciente.get("fechaUltimaCita")));
			try{
				pacientes = em.createQuery(criteria).getResultList();
			} catch(NoResultException nre) {
				return null;
			}		
			return pacientes;
	}
	
	public List<PacienteDetalle> buscarPacientePorNombre(String nombrePaciente, Long idDoctor){
		List<PacienteDetalle> pacientes = new ArrayList<PacienteDetalle>();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PacienteDetalle> criteria = cb.createQuery(PacienteDetalle.class);
		Root<PacienteDetalle> rPaciente = criteria.from(PacienteDetalle.class);
		criteria.select(rPaciente).where(cb.like(rPaciente.<String>get("nombrePaciente"), "%" + nombrePaciente + "%"),
										cb.equal(rPaciente.get("idDoctor"), idDoctor));
		try{
			pacientes = em.createQuery(criteria).getResultList();
		} catch(NoResultException nre) {
			return null;
		}		
		return pacientes;
	}
	
	public Paciente buscarPacientePorId(Long idPaciente){
		Paciente paciente;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> criteria = cb.createQuery(Paciente.class);
		Root<Paciente> rPaciente = criteria.from(Paciente.class);
		criteria.select(rPaciente).where(cb.equal(rPaciente.get("idPaciente"), idPaciente));
		try{
			paciente = em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		}		
		return paciente;
	}
	
	public List<HistorialConsultas> buscarConsultasPorIdPaciente(Long idPaciente){
		List<HistorialConsultas> consultas = new ArrayList<HistorialConsultas>();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<HistorialConsultas> criteria = cb.createQuery(HistorialConsultas.class);
		Root<HistorialConsultas> rConsulta = criteria.from(HistorialConsultas.class);
		criteria.select(rConsulta).where(cb.equal(rConsulta.get("idPaciente"), idPaciente));
		try{
			consultas = em.createQuery(criteria).getResultList();
		} catch(NoResultException nre) {
			return null;
		}		
		return consultas;
	}
	
	public void borrarPaciente(Long idPaciente){
		try{	
			em.remove(em.find(Paciente.class, idPaciente));		
	    	em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }				
	}
}