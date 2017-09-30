package com.baalam.dao.usuarios;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.usuario.Doctor;
import com.baalam.model.usuario.Usuario;

@Stateful
public class DoctorDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Doctor buscarDoctor(Usuario usuario){
		Doctor doctor = new Doctor();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Doctor> criteria = cb.createQuery(Doctor.class);
		Root<Doctor> rdoctor = criteria.from(Doctor.class);
		criteria.select(rdoctor).where(cb.equal(rdoctor.get("usuario"), usuario.getIdUsuario()));
	     
		try {
			doctor =  em.createQuery(criteria).getSingleResult();

		} catch(NoResultException nre) {
			return null;
		} 		 	
		return doctor;
	}
	
	public Doctor buscarDoctorConSecretarias(Usuario usuario){ 
		Doctor doctor = new Doctor();
		try {
			doctor = buscarDoctor(usuario);
			doctor.getSecretarias();
			
			System.out.println("doctor " + doctor);
			
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return doctor;
	}
	
	public Doctor buscarDoctorPorId(Long id){
		try {
			Doctor dr= em.find(Doctor.class, id);		
			return dr;
		} catch(NoResultException nre) {
			return null;
		} 		 	
	}
	
	public void registrarDoctor(Doctor doctor){
		try{
			System.out.println("doctor a punto de guardar " + doctor);
			if(doctor.getIdDoctor() == null){
				em.persist(doctor);
			}else{
				em.merge(doctor);
			}
			em.flush();
		}catch(Exception e){
			System.out.println("doctor en exception " + doctor);
			e.printStackTrace();
		}
	}
}
