package com.baalam.dao.histclinica.iays;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.histclinica.iays.IAySBaof;
import com.baalam.model.histclinica.iays.IAySCardiovascular;
import com.baalam.model.histclinica.iays.IAySDigestivo;
import com.baalam.model.histclinica.iays.IAySEndocrino;
import com.baalam.model.histclinica.iays.IAySEsferaMental;
import com.baalam.model.histclinica.iays.IAySGenitourinario;
import com.baalam.model.histclinica.iays.IAySHematopoyetico;
import com.baalam.model.histclinica.iays.IAySMamas;
import com.baalam.model.histclinica.iays.IAySMuscEsqueletico;
import com.baalam.model.histclinica.iays.IAySNeurologico;
import com.baalam.model.histclinica.iays.IAySPiel;
import com.baalam.model.histclinica.iays.IAySRespiratorio;
import com.baalam.model.histclinica.iays.IAySSintomasGenerales;
import com.baalam.model.histclinica.iays.IAySVista;

@Stateful
public class IAySDao {

	@Inject
	private EntityManager em;
	
	/**
	 * consultar iays signos generales por id paciente
	 * **/
	public IAySSintomasGenerales buscarIaysSGPorIdPaciente(Long idPaciente){
		IAySSintomasGenerales iaysSG = new IAySSintomasGenerales();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySSintomasGenerales> criteria = cb.createQuery(IAySSintomasGenerales.class);
		Root<IAySSintomasGenerales> rIaysSG = criteria.from(IAySSintomasGenerales.class);
		criteria.select(rIaysSG).where(cb.equal(rIaysSG.get("paciente"), idPaciente));
		try{
			iaysSG = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		System.out.println("adsad " + iaysSG);
		
		return iaysSG;
	}
	
	/**
	 * guardar iays signos generales por id paciente
	 * **/
	public void registrarIaysSG(IAySSintomasGenerales iaysSG){
		try{
			IAySSintomasGenerales iaysSGf = em.find(IAySSintomasGenerales.class, iaysSG.getPaciente().getIdPaciente());
			if(iaysSGf == null){
				em.persist(iaysSG);
			}else{
				em.merge(iaysSG);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays vista por id paciente
	 * **/
	public IAySVista buscarIaysVistaPorIdPaciente(Long idPaciente){
		IAySVista iaysVista = new IAySVista();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySVista> criteria = cb.createQuery(IAySVista.class);
		Root<IAySVista> rIaysVista= criteria.from(IAySVista.class);
		criteria.select(rIaysVista).where(cb.equal(rIaysVista.get("paciente"), idPaciente));
		try{
			iaysVista = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysVista;
	}
	
	/**
	 * guardar iays Vista por id paciente
	 * **/
	public void registrarIaysVista(IAySVista iaysVista){
		try{
			IAySVista iaysVistaf = em.find(IAySVista.class, iaysVista.getPaciente().getIdPaciente());
			if(iaysVistaf == null){
				em.persist(iaysVista);
			}else{
				em.merge(iaysVista);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Baof por id paciente
	 * **/
	public IAySBaof buscarIaysBaofPorIdPaciente(Long idPaciente){
		IAySBaof iaysBaof = new IAySBaof();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySBaof> criteria = cb.createQuery(IAySBaof.class);
		Root<IAySBaof> rIaysBaof= criteria.from(IAySBaof.class);
		criteria.select(rIaysBaof).where(cb.equal(rIaysBaof.get("paciente"), idPaciente));
		try{
			iaysBaof = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysBaof;
	}
	
	/**
	 * guardar iays Baof por id paciente
	 * **/
	public void registrarIaysBaof(IAySBaof iaysBaof){
		try{
			IAySBaof iaysBaoff = em.find(IAySBaof.class, iaysBaof.getPaciente().getIdPaciente());
			if(iaysBaoff == null){
				em.persist(iaysBaof);
			}else{
				em.merge(iaysBaof);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Cardiovascular por id paciente
	 * **/
	public IAySCardiovascular buscarIaysCVPorIdPaciente(Long idPaciente){
		IAySCardiovascular iaysCV = new IAySCardiovascular();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySCardiovascular> criteria = cb.createQuery(IAySCardiovascular.class);
		Root<IAySCardiovascular> rIaysCV= criteria.from(IAySCardiovascular.class);
		criteria.select(rIaysCV).where(cb.equal(rIaysCV.get("paciente"), idPaciente));
		try{
			iaysCV = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysCV;
	}
	
	/**
	 * guardar iays Cardiovascular por id paciente
	 * **/
	public void registrarIAySCv(IAySCardiovascular iaysCV){
		try{
			IAySCardiovascular iaysCVf = em.find(IAySCardiovascular.class, iaysCV.getPaciente().getIdPaciente());
			if(iaysCVf == null){
				em.persist(iaysCV);
			}else{
				em.merge(iaysCV);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Respiratorio por id paciente
	 * **/
	public IAySRespiratorio buscarIaysRespiratorioPorIdPaciente(Long idPaciente){
		IAySRespiratorio iaysResp = new IAySRespiratorio();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySRespiratorio> criteria = cb.createQuery(IAySRespiratorio.class);
		Root<IAySRespiratorio> rIaysResp = criteria.from(IAySRespiratorio.class);
		criteria.select(rIaysResp).where(cb.equal(rIaysResp.get("paciente"), idPaciente));
		try{
			iaysResp = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysResp;
	}
	
	/**
	 * guardar iays Respiratorio por id paciente
	 * **/
	public void registrarIaysRespiratorio(IAySRespiratorio iaysResp){
		try{
			IAySRespiratorio iaysRespf = em.find(IAySRespiratorio.class, iaysResp.getPaciente().getIdPaciente());
			if(iaysRespf == null){
				em.persist(iaysResp);
			}else{
				em.merge(iaysResp);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Digestivo por id paciente
	 * **/
	public IAySDigestivo buscarIaysDigestivoPorIdPaciente(Long idPaciente){
		IAySDigestivo iaysDigestivo = new IAySDigestivo();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySDigestivo> criteria = cb.createQuery(IAySDigestivo.class);
		Root<IAySDigestivo> rIaysDigestivo = criteria.from(IAySDigestivo.class);
		criteria.select(rIaysDigestivo).where(cb.equal(rIaysDigestivo.get("paciente"), idPaciente));
		try{
			iaysDigestivo = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysDigestivo;
	}
	
	/**
	 * guardar iays Digestivo por id paciente
	 * **/
	public void registrarIaysDigestivo(IAySDigestivo iaysDigestivo){
		try{
			IAySDigestivo iaysDigestivof = em.find(IAySDigestivo.class, iaysDigestivo.getPaciente().getIdPaciente());
			if(iaysDigestivof == null){
				em.persist(iaysDigestivo);
			}else{
				em.merge(iaysDigestivo);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Genitourinario por id paciente
	 * **/
	public IAySGenitourinario buscarIaysGUPorIdPaciente(Long idPaciente){
		IAySGenitourinario iaysGenitourinario = new IAySGenitourinario();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySGenitourinario> criteria = cb.createQuery(IAySGenitourinario.class);
		Root<IAySGenitourinario> riaysGenitourinario = criteria.from(IAySGenitourinario.class);
		criteria.select(riaysGenitourinario).where(cb.equal(riaysGenitourinario.get("paciente"), idPaciente));
		try{
			iaysGenitourinario = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysGenitourinario;
	}
	
	/**
	 * guardar iays Genitourinario por id paciente
	 * **/
	public void registrarIaysGU(IAySGenitourinario iaysGenitourinario){
		try{
			IAySGenitourinario iaysGenitourinariof = em.find(IAySGenitourinario.class, iaysGenitourinario.getPaciente().getIdPaciente());
			if(iaysGenitourinariof == null){
				em.persist(iaysGenitourinario);
			}else{
				em.merge(iaysGenitourinario);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Musculo esqueletico por id paciente
	 * **/
	public IAySMuscEsqueletico buscarIaysMePorIdPaciente(Long idPaciente){
		IAySMuscEsqueletico iaysMuscEsq = new IAySMuscEsqueletico();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySMuscEsqueletico> criteria = cb.createQuery(IAySMuscEsqueletico.class);
		Root<IAySMuscEsqueletico> rIaysMuscEsq = criteria.from(IAySMuscEsqueletico.class);
		criteria.select(rIaysMuscEsq).where(cb.equal(rIaysMuscEsq.get("paciente"), idPaciente));
		try{
			iaysMuscEsq = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysMuscEsq;
	}
	
	/**
	 * guardar iays Musculo Esqueletico por id paciente
	 * **/
	public void registrarIaysMe(IAySMuscEsqueletico iaysMuscEsq){
		try{
			IAySMuscEsqueletico iaysMuscEsqf = em.find(IAySMuscEsqueletico.class, iaysMuscEsq.getPaciente().getIdPaciente());
			if(iaysMuscEsqf == null){
				em.persist(iaysMuscEsq);
			}else{
				em.merge(iaysMuscEsq);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Neurologico por id paciente
	 * **/
	public IAySNeurologico buscarIaysNeurologicoPorIdPaciente(Long idPaciente){
		IAySNeurologico iaysNeurologico = new IAySNeurologico();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySNeurologico> criteria = cb.createQuery(IAySNeurologico.class);
		Root<IAySNeurologico> rIaysNeurologico = criteria.from(IAySNeurologico.class);
		criteria.select(rIaysNeurologico).where(cb.equal(rIaysNeurologico.get("paciente"), idPaciente));
		try{
			iaysNeurologico = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysNeurologico;
	}
	
	/**
	 * guardar iays Neurologico por id paciente
	 * **/
	public void registrarIaysNeurologico(IAySNeurologico iaysNeurologico){
		try{
			IAySNeurologico iaysNeurologicof = em.find(IAySNeurologico.class, iaysNeurologico.getPaciente().getIdPaciente());
			if(iaysNeurologicof == null){
				em.persist(iaysNeurologico);
			}else{
				em.merge(iaysNeurologico);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Esfera Mental por id paciente
	 * **/
	public IAySEsferaMental buscarIaysEsfMentalPorIdPaciente(Long idPaciente){
		IAySEsferaMental iaysEsfMental= new IAySEsferaMental();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySEsferaMental> criteria = cb.createQuery(IAySEsferaMental.class);
		Root<IAySEsferaMental> rIaysEsfMental = criteria.from(IAySEsferaMental.class);
		criteria.select(rIaysEsfMental).where(cb.equal(rIaysEsfMental.get("paciente"), idPaciente));
		try{
			iaysEsfMental = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysEsfMental;
	}
	
	/**
	 * guardar iays Esfera Mental por id paciente
	 * **/
	public void registrarIaysEsfMental(IAySEsferaMental iaysEsfMental){
		try{
			IAySEsferaMental iaysEsfMentalf = em.find(IAySEsferaMental.class, iaysEsfMental.getPaciente().getIdPaciente());
			if(iaysEsfMentalf == null){
				em.persist(iaysEsfMental);
			}else{
				em.merge(iaysEsfMental);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Endocrino por id paciente
	 * **/
	public IAySEndocrino buscarIaysEndoPorIdPaciente(Long idPaciente){
		IAySEndocrino iaysEndocrino= new IAySEndocrino();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySEndocrino> criteria = cb.createQuery(IAySEndocrino.class);
		Root<IAySEndocrino> rIaysEndocrino = criteria.from(IAySEndocrino.class);
		criteria.select(rIaysEndocrino).where(cb.equal(rIaysEndocrino.get("paciente"), idPaciente));
		try{
			iaysEndocrino = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysEndocrino;
	}
	
	/**
	 * guardar iays Endocrino por id paciente
	 * **/
	public void registrarIaysEndo(IAySEndocrino iaysEndocrino){
		try{
			IAySEndocrino iaysEndocrinof = em.find(IAySEndocrino.class, iaysEndocrino.getPaciente().getIdPaciente());
			if(iaysEndocrinof == null){
				em.persist(iaysEndocrino);
			}else{
				em.merge(iaysEndocrino);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Hematopoyetico por id paciente
	 * **/
	public IAySHematopoyetico buscarIaysHemaLinfaPorIdPaciente(Long idPaciente){
		IAySHematopoyetico iaysHemaLinfa= new IAySHematopoyetico();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySHematopoyetico> criteria = cb.createQuery(IAySHematopoyetico.class);
		Root<IAySHematopoyetico> rIaysHemaLinfa = criteria.from(IAySHematopoyetico.class);
		criteria.select(rIaysHemaLinfa).where(cb.equal(rIaysHemaLinfa.get("paciente"), idPaciente));
		try{
			iaysHemaLinfa = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysHemaLinfa;
	}
	
	/**
	 * guardar iays Hematopoyetico por id paciente
	 * **/
	public void registrarIaysHemaLinfa(IAySHematopoyetico iaysHemaLinfa){
		try{
			IAySHematopoyetico iaysHemaLinfaf = em.find(IAySHematopoyetico.class, iaysHemaLinfa.getPaciente().getIdPaciente());
			if(iaysHemaLinfaf == null){
				em.persist(iaysHemaLinfa);
			}else{
				em.merge(iaysHemaLinfa);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Piel por id paciente
	 * **/
	public IAySPiel buscarIaysPielPorIdPaciente(Long idPaciente){
		IAySPiel iaysPiel= new IAySPiel();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySPiel> criteria = cb.createQuery(IAySPiel.class);
		Root<IAySPiel> rIaysPiel = criteria.from(IAySPiel.class);
		criteria.select(rIaysPiel).where(cb.equal(rIaysPiel.get("paciente"), idPaciente));
		try{
			iaysPiel = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysPiel;
	}
	
	/**
	 * guardar iays Piel por id paciente
	 * **/
	public void registrarIaysPiel(IAySPiel iaysPiel){
		try{
			IAySPiel iaysPielf = em.find(IAySPiel.class, iaysPiel.getPaciente().getIdPaciente());
			if(iaysPielf == null){
				em.persist(iaysPiel);
			}else{
				em.merge(iaysPiel);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * consultar iays Mamas por id paciente
	 * **/
	public IAySMamas buscarIaysMamasPorIdPaciente(Long idPaciente){
		IAySMamas iaysMamas= new IAySMamas();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IAySMamas> criteria = cb.createQuery(IAySMamas.class);
		Root<IAySMamas> rIaysMamas = criteria.from(IAySMamas.class);
		criteria.select(rIaysMamas).where(cb.equal(rIaysMamas.get("paciente"), idPaciente));
		try{
			iaysMamas = em.createQuery(criteria).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
		return iaysMamas;
	}
	
	/**
	 * guardar iays Hematopoyetico por id paciente
	 * **/
	public void registrarIaysMamas(IAySMamas iaysMamas){
		try{
			IAySMamas iaysMamasf = em.find(IAySMamas.class, iaysMamas.getPaciente().getIdPaciente());
			if(iaysMamasf == null){
				em.persist(iaysMamas);
			}else{
				em.merge(iaysMamas);
			}
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
