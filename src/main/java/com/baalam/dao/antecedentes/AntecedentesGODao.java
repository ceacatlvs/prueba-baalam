package com.baalam.dao.antecedentes;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatAnticonceptivos;
import com.baalam.model.histclinica.ant.go.AGOAnticonceptivosActual;
import com.baalam.model.histclinica.ant.go.AGOAnticonceptivosPrevio;
import com.baalam.model.histclinica.ant.go.AGOGinecologica;
import com.baalam.model.histclinica.ant.go.AGOObstetrica;
import com.baalam.model.histclinica.ant.go.AGOOtrosAnticonceptivosActual;
import com.baalam.model.histclinica.ant.go.AGOOtrosAnticonceptivosPrevio;
import com.baalam.model.histclinica.ant.go.AGOPartos;
import com.baalam.model.histclinica.ant.go.AGOUltimosEstudios;

@Stateful
public class AntecedentesGODao {

	@Inject
	private EntityManager em;
	
	public AGOGinecologica obtenerGinecologicaPorIdPaciente(Long idPaciente){
		AGOGinecologica ginecologica;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOGinecologica> criteria = cb.createQuery(AGOGinecologica.class);
		Root<AGOGinecologica> rAGOGinecologica = criteria.from(AGOGinecologica.class);
		criteria.select(rAGOGinecologica).where(cb.equal(rAGOGinecologica.get("paciente"), idPaciente));
		try {
			ginecologica =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return new AGOGinecologica();
		} 		 	
		return ginecologica;
	}
	
	public AGOObstetrica obtenerObstetricaPorIdPaciente(Long idPaciente){
		AGOObstetrica obstetrica;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOObstetrica> criteria = cb.createQuery(AGOObstetrica.class);
		Root<AGOObstetrica> rAGOObstetrica = criteria.from(AGOObstetrica.class);
		criteria.select(rAGOObstetrica).where(cb.equal(rAGOObstetrica.get("paciente"),idPaciente));
		try {
			obstetrica =  em.createQuery(criteria).getSingleResult();
			return obstetrica;
		} catch(NoResultException nre) {
			return new AGOObstetrica();
		} 		 	
	}
	
	public List<AGOPartos> obtenerPartosPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOPartos> criteria = cb.createQuery(AGOPartos.class);
		Root<AGOPartos> rAGOPartos = criteria.from(AGOPartos.class);
		criteria.select(rAGOPartos).where(cb.equal(rAGOPartos.get("paciente"), idPaciente));
		criteria.orderBy(cb.asc(rAGOPartos.get("fechaNacimiento")));

		try{
			List<AGOPartos> partos = em.createQuery(criteria).getResultList();
			return partos;
		}catch(NoResultException nre){
			return new ArrayList<AGOPartos>();
		}
	}
	
	public List<AGOAnticonceptivosActual> obtenerAnticonceptivosActualesPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOAnticonceptivosActual> criteria = cb.createQuery(AGOAnticonceptivosActual.class);
		Root<AGOAnticonceptivosActual> rAGOAnticonceptivos = criteria.from(AGOAnticonceptivosActual.class);
		criteria.select(rAGOAnticonceptivos).where(cb.equal(rAGOAnticonceptivos.get("paciente"), idPaciente));

		try{
			List<AGOAnticonceptivosActual> anticonceptivos = em.createQuery(criteria).getResultList();
			return anticonceptivos;
		}catch(NoResultException nre){
			return new ArrayList<AGOAnticonceptivosActual>();
		}
	}
	
	public List<AGOOtrosAnticonceptivosActual> obtenerOtrosAnticonceptivosActualesPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOOtrosAnticonceptivosActual> criteria = cb.createQuery(AGOOtrosAnticonceptivosActual.class);
		Root<AGOOtrosAnticonceptivosActual> rAGOOtrosAnticonceptivos = criteria.from(AGOOtrosAnticonceptivosActual.class);
		criteria.select(rAGOOtrosAnticonceptivos).where(cb.equal(rAGOOtrosAnticonceptivos.get("paciente"), idPaciente));

		try{
			List<AGOOtrosAnticonceptivosActual> otrosAnticonceptivos = em.createQuery(criteria).getResultList();
			return otrosAnticonceptivos;
		}catch(NoResultException nre){
			return new ArrayList<AGOOtrosAnticonceptivosActual>();
		}
	}
	
	public List<AGOAnticonceptivosPrevio> obtenerAnticonceptivosPreviosPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOAnticonceptivosPrevio> criteria = cb.createQuery(AGOAnticonceptivosPrevio.class);
		Root<AGOAnticonceptivosPrevio> rAGOAnticonceptivos = criteria.from(AGOAnticonceptivosPrevio.class);
		criteria.select(rAGOAnticonceptivos).where(cb.equal(rAGOAnticonceptivos.get("paciente"), idPaciente));

		try{
			List<AGOAnticonceptivosPrevio> anticonceptivos = em.createQuery(criteria).getResultList();
			return anticonceptivos;
		}catch(NoResultException nre){
			return new ArrayList<AGOAnticonceptivosPrevio>();
		}
	}
	
	public List<AGOOtrosAnticonceptivosPrevio> obtenerOtrosAnticonceptivosPreviosPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOOtrosAnticonceptivosPrevio> criteria = cb.createQuery(AGOOtrosAnticonceptivosPrevio.class);
		Root<AGOOtrosAnticonceptivosPrevio> rAGOOtrosAnticonceptivosP = criteria.from(AGOOtrosAnticonceptivosPrevio.class);
		criteria.select(rAGOOtrosAnticonceptivosP).where(cb.equal(rAGOOtrosAnticonceptivosP.get("paciente"), idPaciente));

		try{
			List<AGOOtrosAnticonceptivosPrevio> otrosAnticonceptivosP = em.createQuery(criteria).getResultList();
			return otrosAnticonceptivosP;
		}catch(NoResultException nre){
			return new ArrayList<AGOOtrosAnticonceptivosPrevio>();
		}
	}
	
	public AGOUltimosEstudios obtenerUltimosEstudiosPorIdPaciente(Long idPaciente){
		AGOUltimosEstudios ultimosEstudios;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AGOUltimosEstudios> criteria = cb.createQuery(AGOUltimosEstudios.class);
		Root<AGOUltimosEstudios> rAGOUltimosEstudios = criteria.from(AGOUltimosEstudios.class);
		criteria.select(rAGOUltimosEstudios).where(cb.equal(rAGOUltimosEstudios.get("paciente"),idPaciente));
		try {
			ultimosEstudios =  em.createQuery(criteria).getSingleResult();
		} catch(NoResultException nre) {
			return new AGOUltimosEstudios();
		} 		 	
		return ultimosEstudios;
	}
	
	public void registraGinecologica(AGOGinecologica agogine){
		try{
			if(agogine.getPaciente()!=null){
				AGOGinecologica agopartAnt = em.find(AGOGinecologica.class, agogine);
				if(agopartAnt == null){
					em.persist(agogine);
				}else{
					em.merge(agogine);
				}
			}else{
				em.persist(agogine);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registraObstetrica(AGOObstetrica agoobs){
		try{
			if(agoobs.getIdPaciente()!=null){
				AGOObstetrica agoobsAnt = em.find(AGOObstetrica.class, agoobs);
				if(agoobsAnt == null){
					em.persist(agoobs);
				}else{
					em.merge(agoobs);
				}
			}else{
				em.persist(agoobs);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registrarParto(AGOPartos agopart){
		try{
			if(agopart.getIdParto()!=null){
				AGOPartos agopartAnt = em.find(AGOPartos.class, agopart.getIdParto());
				if(agopartAnt == null){
					em.persist(agopart);
				}else{
					em.merge(agopart);
				}
			}else{
				em.persist(agopart);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registrarAnticonceptivosActuales(AGOAnticonceptivosActual agoAntAct){
		try{
			if(agoAntAct.getIdAgoAnticonceptivosActual()!=null){
				AGOAnticonceptivosActual agoantAnt = em.find(AGOAnticonceptivosActual.class, agoAntAct.getIdAgoAnticonceptivosActual());
				if(agoantAnt == null){
					em.persist(agoAntAct);
				}else{
					em.merge(agoAntAct);
				}
			}else{
				em.persist(agoAntAct);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registrarOtrosAnticonceptivosActuales(AGOOtrosAnticonceptivosActual otroAntiActual){
		try{
			AGOOtrosAnticonceptivosActual otroAntiActualf = null;
			if(otroAntiActual.getIdAgoOtroAnticonceptivoActual() != null){
				otroAntiActualf = em.find(AGOOtrosAnticonceptivosActual.class, otroAntiActual.getIdAgoOtroAnticonceptivoActual());
			}
			if(otroAntiActualf == null){
				em.persist(otroAntiActual);
			}else{
				em.merge(otroAntiActual);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void registrarAnticonceptivosPrevios(AGOAnticonceptivosPrevio agoAntPrev){
		try{
			if(agoAntPrev.getIdAgoAnticonceptivos()!=null){
				AGOAnticonceptivosActual agoantAnt = em.find(AGOAnticonceptivosActual.class, agoAntPrev.getIdAgoAnticonceptivos());
				if(agoantAnt == null){
					em.persist(agoAntPrev);
				}else{
					em.merge(agoAntPrev);
				}
			}else{
				em.persist(agoAntPrev);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registrarOtrosAnticonceptivosPrevios(AGOOtrosAnticonceptivosPrevio otroAntiPrevio){
		try{
			AGOOtrosAnticonceptivosPrevio otroAntiPreviof = null;
			if(otroAntiPrevio.getIdAgoOtroAnticonceptivoPrevio() != null){
				otroAntiPreviof = em.find(AGOOtrosAnticonceptivosPrevio.class, otroAntiPrevio.getIdAgoOtroAnticonceptivoPrevio());
			}
			if(otroAntiPreviof == null){
				em.persist(otroAntiPrevio);
			}else{
				em.merge(otroAntiPrevio);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registrarUltimosEstudios(AGOUltimosEstudios agoulte){
		try{
			if(agoulte.getPaciente()!=null){
				AGOUltimosEstudios agoulteAnt = em.find(AGOUltimosEstudios.class, agoulte);
				if(agoulteAnt == null){
					em.persist(agoulte);
				}else{
					em.merge(agoulte);
				}
			}else{
				em.persist(agoulte);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void borrarOtrosAnticonceptivosActuales(AGOOtrosAnticonceptivosActual acaBorrar){
		try{
			em.remove(em.find(AGOOtrosAnticonceptivosActual.class, acaBorrar.getIdAgoOtroAnticonceptivoActual()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void borrarOtrosAnticonceptivosPrevios(AGOOtrosAnticonceptivosPrevio acpBorrar){
		try{
			em.remove(em.find(AGOOtrosAnticonceptivosPrevio.class, acpBorrar.getIdAgoOtroAnticonceptivoPrevio()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<CatAnticonceptivos> obtenerCatAnticonceptivos() {
		CriteriaQuery<CatAnticonceptivos> criteria = em.getCriteriaBuilder().createQuery(CatAnticonceptivos.class);
		criteria.select(criteria.from(CatAnticonceptivos.class));
		
		return em.createQuery(criteria).getResultList();
	}
}