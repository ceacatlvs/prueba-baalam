package com.baalam.dao.usuarios;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.usuario.Consultorio;
import com.baalam.model.usuario.Doctor;

@Stateful
public class ConsultorioDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void registrarConsultorio(Consultorio consultorio){
		try{
			if(consultorio.getIdConsultorio() == null){
				Doctor dr= em.find(Doctor.class, consultorio.getDoctor().getIdDoctor());
				consultorio.setDoctor(dr);
				em.merge(consultorio.getDoctor());
				em.persist(consultorio);
			}else{
				em.merge(consultorio);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Consultorio> obtenerConsultoriosPorIdDoctor(Long idDoctor){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Consultorio> criteria = cb.createQuery(Consultorio.class);
		Root<Consultorio> rconsultorio = criteria.from(Consultorio.class);
		criteria.select(rconsultorio).where(cb.equal(rconsultorio.get("doctor"), idDoctor));
		try {
			List<Consultorio> consultorios =  em.createQuery(criteria).getResultList();
			return consultorios;
		} catch(NoResultException nre) {
			return null;
		} 
	}
	
	public Consultorio obtenerConsultorio(Long idConsultorio){
		Consultorio consultorio = new Consultorio();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Consultorio> criteria = cb.createQuery(Consultorio.class);
		Root<Consultorio> rConsul = criteria.from(Consultorio.class);
		criteria.select(rConsul).where(cb.equal(rConsul.get("idConsultorio"), idConsultorio));
	     
		try {
			consultorio =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		
		return consultorio;
	}
}
