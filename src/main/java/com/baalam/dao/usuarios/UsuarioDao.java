package com.baalam.dao.usuarios;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.usuario.Rol;
import com.baalam.model.usuario.Usuario;

@Stateful
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Usuario buscarPorUsuario(Usuario usuario) {
		Usuario usr = new Usuario();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = cb.createQuery(Usuario.class);
		Root<Usuario> rusuario = criteria.from(Usuario.class);
		
		criteria.select(rusuario).where(cb.equal(rusuario.get("username"), usuario.getUsername()),
			cb.equal(rusuario.get("password"), usuario.getPassword()));
		
		try {
			usr =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 
		return usr;
	}
	
	public void registrarUsuario(Usuario usuario){
		try{
			if(usuario.getIdUsuario() == null){
				em.persist(usuario);
			}else{
				em.merge(usuario);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Rol obtenerRol(Long idRol){
		Rol rol = new Rol();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Rol> criteria = cb.createQuery(Rol.class);
		Root<Rol> rrol = criteria.from(Rol.class);
		
		criteria.select(rrol).where(cb.equal(rrol.get("idRol"), idRol));
		
		try {
			rol =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return null;
		} 
		return rol;
	}	
}