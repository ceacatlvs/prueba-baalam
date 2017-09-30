package com.baalam.dao;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.baalam.model.agenda.CitaAgenda;
import com.baalam.model.agenda.CitaCancelada;
import com.baalam.model.paciente.Paciente;

@Stateful
public class AgendaDao {

	@Inject
	private EntityManager em;


	/**
	 * Este metodo registra la cita
	 * @param cita
	 */
	public void registrarCita(CitaAgenda cita){
		try{
			CitaAgenda citaf = null;
			if(cita.getIdCita() != null){
				citaf = em.find(CitaAgenda.class, cita.getIdCita());
			}
			if(citaf == null){	
				System.out.println("la cita en registrar cita " + cita);
				if(cita.getPaciente() != null && cita.getPaciente().getIdPaciente() != null){
					Paciente pac = em.find(Paciente.class, cita.getPaciente().getIdPaciente());
					System.out.println("paciente en registrarCita " + pac);
					cita.setPaciente(pac);
				}
				
				em.persist(cita);
			}else{
				em.merge(cita);
			}
		em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public void eliminarCita(CitaAgenda cita ){
		try{	
			em.remove(em.find(CitaAgenda.class, cita.getIdCita()));			
			em.flush();
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }	
	}
	
	public void registrarCitaCancelada(CitaCancelada cita){
		try{
			em.persist(cita);
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public List<CitaAgenda> revisarEmpalme(CitaAgenda cita){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CitaAgenda> criteria = cb.createQuery(CitaAgenda.class);
		Root<CitaAgenda> rCitaAgenda = criteria.from(CitaAgenda.class);
		//Se le resta y suma un segundo a la hora, ya que si no
		//marcaría empalme cuando una cita acaba justo cuando la que se intenta guardar empieza o visceversa.
		Calendar aux = Calendar.getInstance();
		aux.setTime(cita.getCitaInicio());
		aux.add(Calendar.SECOND, 1);
		Date inicio = aux.getTime();

		aux.setTime(cita.getCitaFin());
		aux.add(Calendar.SECOND, -1);
		Date fin = aux.getTime();
		Long idCitaAux = cita.getIdCita();
		if(cita.getIdCita() == null|| cita.getIdCita().intValue() < 1){
			idCitaAux= new Long(0);
		}

		Predicate esteDoctor = cb.equal(rCitaAgenda.get("doctor"), cita.getDoctor());
		Predicate noEstaCita = cb.notEqual(rCitaAgenda.get("idCita"),idCitaAux);
		Predicate inicioEntre = cb.between(rCitaAgenda.<Date>get("citaInicio"),  inicio,fin);
		Predicate finEntre = cb.between(rCitaAgenda.<Date>get("citaFin"), inicio,fin);
		Predicate inicioLoE = cb.lessThanOrEqualTo(rCitaAgenda.<Date>get("citaInicio"), cita.getCitaInicio());
		Predicate finGoE = cb.greaterThanOrEqualTo(rCitaAgenda.<Date>get("citaFin"), cita.getCitaFin());
		Predicate dentroDeOtra = (cb.and(inicioLoE, finGoE));

		try{
			List<CitaAgenda> listaCitas = em.createQuery(criteria.select(rCitaAgenda).where(cb.and(noEstaCita,esteDoctor,cb.or(inicioEntre,finEntre,dentroDeOtra)))).getResultList();
			return listaCitas;
		}catch(NoResultException nre){
			return null;
		}
	}

	public List<CitaAgenda> obtenerCitasporDoctorYFechas(Long idDoctor, Date inicio, Date fin){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CitaAgenda> criteria = cb.createQuery(CitaAgenda.class);
		Root<CitaAgenda> rCitaAgenda = criteria.from(CitaAgenda.class);

		Predicate esteDoctor = cb.equal(rCitaAgenda.get("doctor"), idDoctor);
		Predicate inicioEntre = cb.between(rCitaAgenda.<Date>get("citaInicio"),  inicio,fin);
		Predicate finEntre = cb.between(rCitaAgenda.<Date>get("citaFin"), inicio,fin);
		Predicate inicioLoE = cb.lessThanOrEqualTo(rCitaAgenda.<Date>get("citaInicio"), inicio);
		Predicate finGoE = cb.greaterThanOrEqualTo(rCitaAgenda.<Date>get("citaFin"), fin);
		Predicate dentroDeOtra = (cb.and(inicioLoE, finGoE));

		try{
			List<CitaAgenda> listaCitas = em.createQuery(criteria.select(rCitaAgenda).where(cb.and(esteDoctor,cb.or(inicioEntre,finEntre,dentroDeOtra)))).getResultList();

			return listaCitas;
		}catch(NoResultException nre){
			return null;
		}
	}

	public CitaAgenda obtenerCitaporId(Long idCita){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CitaAgenda> criteria = cb.createQuery(CitaAgenda.class);
		Root<CitaAgenda> rCitaAgenda = criteria.from(CitaAgenda.class);
		criteria.select(rCitaAgenda).where(cb.equal(rCitaAgenda.get("idCita"), idCita));

		try{
			CitaAgenda cita = em.createQuery(criteria).getSingleResult();
			return cita;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<CitaCancelada> obtenerCitasPorEstadoPorDoctor(Long idDoctor){
		List<CitaCancelada> citas = new ArrayList<CitaCancelada>();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CitaCancelada> criteria = cb.createQuery(CitaCancelada.class);
		Root<CitaCancelada> rCitaAgenda = criteria.from(CitaCancelada.class);
		criteria.select(rCitaAgenda).where(cb.equal(rCitaAgenda.get("doctor"), idDoctor));
		
		try{
			citas = em.createQuery(criteria).getResultList();			
		}catch(NoResultException nre){
			return null;
		}
		return citas;
	}
}
