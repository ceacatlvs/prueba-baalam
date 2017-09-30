package com.baalam.dao.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.usuario.DoctorSecretaria;
import com.baalam.model.usuario.Secretaria;
import com.baalam.model.usuario.Usuario;

@Stateful
public class SecretariaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Secretaria buscarSecretaria(Usuario usuario){
		Secretaria secretaria = new Secretaria();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Secretaria> criteria = cb.createQuery(Secretaria.class);
		Root<Secretaria> rsecretaria = criteria.from(Secretaria.class);
		criteria.select(rsecretaria).where(cb.equal(rsecretaria.get("usuario"), usuario.getIdUsuario()));
	     
		try {
			secretaria =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 		 	
		return secretaria;
	}
	
	public Secretaria buscarSecretariaPorIdSecretaria(Long idSecretaria){
		try {
			Secretaria secretaria = new Secretaria();		
			secretaria = em.find(Secretaria.class, idSecretaria);
						
			return secretaria;
		} catch(NoResultException nre) {
			return null;
		} 	
	}
	
	public void registrarSecretaria(Secretaria secretaria){
		try{
			if(secretaria.getIdSecretaria() == null){
				em.persist(secretaria);
			}else{
				em.merge(secretaria);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<DoctorSecretaria> obtenerTodasSecretarias(Long idDoctor){
		List<Secretaria> secretarias = new ArrayList<Secretaria>();
		List<DoctorSecretaria> doctorSecretarias = new ArrayList<DoctorSecretaria>();
		DoctorSecretaria doctorSecretaria = new DoctorSecretaria();
		
		Query query = em.createNamedQuery("buscarSecretariasAsociarDoctor");
		query.setParameter("doctor", idDoctor);
		
		secretarias = query.getResultList();
		
		System.out.println("secretarias " + secretarias.size());
		
		for(Secretaria secretaria : secretarias){
			doctorSecretaria.setSecreataria(secretaria);
			doctorSecretarias.add(doctorSecretaria);
		}
		
		return doctorSecretarias;
	}
}	