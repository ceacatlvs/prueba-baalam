package com.baalam.dao.antecedentes;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baalam.model.catalogo.CatAntecedentesVacunas;
import com.baalam.model.catalogo.CatEnfEdoActual;
import com.baalam.model.catalogo.CatEnfermedad;
import com.baalam.model.histclinica.ant.pp.APPEnfAccidentes;
import com.baalam.model.histclinica.ant.pp.APPEnfermedades;
import com.baalam.model.histclinica.ant.pp.APPHospYCirugias;
import com.baalam.model.histclinica.ant.pp.APPMedicacionActual;
import com.baalam.model.histclinica.ant.pp.APPOtrasVacunas;
import com.baalam.model.histclinica.ant.pp.APPVacunas;

@Stateful
public class AntecedentesPPDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<APPEnfermedades> obtenerEnfermedadesPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APPEnfermedades> criteria = cb.createQuery(APPEnfermedades.class);
		Root<APPEnfermedades> rAPPEnfermedades = criteria.from(APPEnfermedades.class);
		criteria.select(rAPPEnfermedades).where(cb.equal(rAPPEnfermedades.get("paciente"), idPaciente));
		
		try{
			List<APPEnfermedades> listaEnfermedades = em.createQuery(criteria).getResultList();
			return listaEnfermedades;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<APPHospYCirugias> obtenerHospYCirugiasPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APPHospYCirugias> criteria = cb.createQuery(APPHospYCirugias.class);
		Root<APPHospYCirugias> rAPPHospYCirugias = criteria.from(APPHospYCirugias.class);
		criteria.select(rAPPHospYCirugias).where(cb.equal(rAPPHospYCirugias.get("paciente"), idPaciente));
		
		try{
			List<APPHospYCirugias> listaHospYCirugias = em.createQuery(criteria).getResultList();
			return listaHospYCirugias;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<APPEnfAccidentes> obtenerEnfAccidentesPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APPEnfAccidentes> criteria = cb.createQuery(APPEnfAccidentes.class);
		Root<APPEnfAccidentes> rAppEnfAccidentes = criteria.from(APPEnfAccidentes.class);
		criteria.select(rAppEnfAccidentes).where(cb.equal(rAppEnfAccidentes.get("paciente"), idPaciente));
		
		try{
			List<APPEnfAccidentes> listaEnfAccidentes = em.createQuery(criteria).getResultList();
			return listaEnfAccidentes;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<APPVacunas> obtenerVacunasPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APPVacunas> criteria = cb.createQuery(APPVacunas.class);
		Root<APPVacunas> rAppVacunas = criteria.from(APPVacunas.class);
		criteria.select(rAppVacunas).where(cb.equal(rAppVacunas.get("paciente"), idPaciente));
		
		try{
			List<APPVacunas> listaVacunas = em.createQuery(criteria).getResultList();
			return listaVacunas;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<APPOtrasVacunas> obtenerOtrasVacunasPorIdPaciente(Long idPaciente, Long idCatVacuna){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APPOtrasVacunas> criteria = cb.createQuery(APPOtrasVacunas.class);
		Root<APPOtrasVacunas> rAppOtrasVacunas = criteria.from(APPOtrasVacunas.class);
		criteria.select(rAppOtrasVacunas).where(cb.equal(rAppOtrasVacunas.get("paciente"), idPaciente));
		
		try{
			List<APPOtrasVacunas> listaOtrasVacunas = em.createQuery(criteria).getResultList();
			return listaOtrasVacunas;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public List<APPMedicacionActual> obtenerMedicacionActualPorIdPaciente(Long idPaciente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APPMedicacionActual> criteria = cb.createQuery(APPMedicacionActual.class);
		Root<APPMedicacionActual> rAppMedicacionActual = criteria.from(APPMedicacionActual.class);
		criteria.select(rAppMedicacionActual).where(cb.equal(rAppMedicacionActual.get("paciente"), idPaciente));
		
		try{
			List<APPMedicacionActual> listaMedActual = em.createQuery(criteria).getResultList();
			return listaMedActual;
		}catch(NoResultException nre){
			return null;
		}
	}
	
	public void registrarEnfermedades(APPEnfermedades enfermedad) {
		try{
			APPEnfermedades enfermedadf = null;
			if(enfermedad.getIdAppEnfermedades() != null){
				enfermedadf = em.find(APPEnfermedades.class, enfermedad.getIdAppEnfermedades());
			}
			if(enfermedadf == null){
				em.persist(enfermedad);
			}else{
				em.merge(enfermedad);
			}	
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	public void registrarHospYCirugias(APPHospYCirugias hospYCirugia) {
		try{
			APPHospYCirugias hospYCirugiaf = null;
			if(hospYCirugia.getIdAppCirugias() != null){
				hospYCirugiaf = em.find(APPHospYCirugias.class, hospYCirugia.getIdAppCirugias());
			}
			if(hospYCirugiaf == null){
				em.persist(hospYCirugia);
			}else{
				em.merge(hospYCirugia);
			}	
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	public void registrarEnfAccidentes(APPEnfAccidentes enfAccidentes) {
		try{
			APPEnfAccidentes enfAccidentesf = null;
			if(enfAccidentes.getIdEnfAccidentes() != null){
				enfAccidentesf = em.find(APPEnfAccidentes.class, enfAccidentes.getIdEnfAccidentes());
			}
			if(enfAccidentesf == null){
				em.persist(enfAccidentes);
			}else{
				em.merge(enfAccidentes);
			}	
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void registrarVacunas(APPVacunas vacuna) {
		try{
			APPVacunas vacunaf = null;
			if(vacuna.getIdAppVacunas() != null){
				vacunaf = em.find(APPVacunas.class, vacuna.getIdAppVacunas());
			}
			if(vacunaf == null){
				em.persist(vacuna);
			}else{
				em.merge(vacuna);
			}	
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void registrarOtrasVacunas(APPOtrasVacunas otraVacuna) {
		try{
			APPOtrasVacunas otraVacunaf = null;
			if(otraVacuna.getIdAppOtrasVacunas() != null){
				otraVacunaf = em.find(APPOtrasVacunas.class, otraVacuna.getIdAppOtrasVacunas());
			}
			if(otraVacunaf == null){
				em.persist(otraVacuna);
			}else{
				em.merge(otraVacuna);
			}	
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void registrarMedicacionActual(APPMedicacionActual medActual) {
		try{
			APPMedicacionActual medActualf = null;
			if(medActual.getIdAppMedicacion() != null){
				medActualf = em.find(APPMedicacionActual.class, medActual.getIdAppMedicacion());
			}
			if(medActualf == null){
				em.persist(medActual);
			}else{
				em.merge(medActual);
			}	
			em.flush();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void borrarHospYCirugias(APPHospYCirugias hospYCirugiaBorrar) {
		try{
			em.remove(em.find(APPHospYCirugias.class, hospYCirugiaBorrar.getIdAppCirugias()));
		}catch(Exception e){
			e.printStackTrace();
	    }	
	}

	public void borrarEnfAccidentes(APPEnfAccidentes enfAccidentesBorrar) {
		try{
			em.remove(em.find(APPHospYCirugias.class, enfAccidentesBorrar.getIdEnfAccidentes()));
		}catch(Exception e){
			e.printStackTrace();
	    }		
	}
	
	public void borrarOtrasVacunas(APPOtrasVacunas vacunasBorrar) {
		try{
			em.remove(em.find(APPOtrasVacunas.class, vacunasBorrar.getIdAppOtrasVacunas()));
		}catch(Exception e){
			e.printStackTrace();
	    }		
	}
	
	public void borrarMedicacionActual(APPMedicacionActual medActualBorrar) {
		try{
			em.remove(em.find(APPMedicacionActual.class, medActualBorrar.getIdAppMedicacion()));
		}catch(Exception e){
			e.printStackTrace();
	    }			
	}	
		
	public List<CatEnfEdoActual> obtenerEdoActual(){
		CriteriaQuery<CatEnfEdoActual> criteria = em.getCriteriaBuilder().createQuery(CatEnfEdoActual.class);
		criteria.select(criteria.from(CatEnfEdoActual.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public CatEnfEdoActual obtenerEdoActualPorId(Long id){
		return em.find(CatEnfEdoActual.class, id);
	}
	
	public List<CatEnfermedad> obtenerEnfermedades(){
		CriteriaQuery<CatEnfermedad> criteria = em.getCriteriaBuilder().createQuery(CatEnfermedad.class);
		criteria.select(criteria.from(CatEnfermedad.class));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<CatAntecedentesVacunas> obtenerVacunas(){
		CriteriaQuery<CatAntecedentesVacunas> criteria = em.getCriteriaBuilder().createQuery(CatAntecedentesVacunas.class);
		criteria.select(criteria.from(CatAntecedentesVacunas.class));
		return em.createQuery(criteria).getResultList();
	}
}