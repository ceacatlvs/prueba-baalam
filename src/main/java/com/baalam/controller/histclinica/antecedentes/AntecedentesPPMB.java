package com.baalam.controller.histclinica.antecedentes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.dao.antecedentes.AntecedentesPPDao;
import com.baalam.model.catalogo.CatAntecedentesVacunas;
import com.baalam.model.catalogo.CatEnfEdoActual;
import com.baalam.model.catalogo.CatEnfermedad;
import com.baalam.model.histclinica.ant.pp.APPEnfAccidentes;
import com.baalam.model.histclinica.ant.pp.APPEnfermedades;
import com.baalam.model.histclinica.ant.pp.APPHospYCirugias;
import com.baalam.model.histclinica.ant.pp.APPMedicacionActual;
import com.baalam.model.histclinica.ant.pp.APPOtrasVacunas;
import com.baalam.model.histclinica.ant.pp.APPVacunas;
import com.baalam.model.paciente.Paciente;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class AntecedentesPPMB extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private FichaIdentificacionMB fimb;

	@Inject
	private AntecedentesPPDao appDao;

	private Paciente paciente;

	private List<CatEnfEdoActual> edoActual;
	private List<CatEnfermedad> catEnfermedades;
	private List<CatAntecedentesVacunas> catVacunas;

	//private APPEnfermedades appEnf;

	private APPEnfermedades enfermedad;
	private List<APPEnfermedades> enfermedades;
	private List<APPVacunas> vacunas;

	private APPHospYCirugias hospCir;
	private List<APPHospYCirugias> listaHospCir;

	private APPEnfAccidentes enfAcc;
	private List<APPEnfAccidentes> listaEnfAcc;

	private APPOtrasVacunas otraVacuna;
	private List<APPOtrasVacunas> listaVacunas;

	private APPMedicacionActual medAct;
	private List<APPMedicacionActual> listMedAct;	

	@PostConstruct
	public void iniciar() {
		paciente = fimb.getPaciente();		
		
		setEdoActual(appDao.obtenerEdoActual());
		setCatEnfermedades(appDao.obtenerEnfermedades());
		setCatVacunas(appDao.obtenerVacunas());

		enfermedad = new APPEnfermedades();
		enfermedad.setIdCatEnfEdoActual(new CatEnfEdoActual());
		obtenerAPPEnfermedades();

		hospCir = new APPHospYCirugias();
		obtenerHospYCirugias();

		enfAcc = new APPEnfAccidentes();
		obtenerEnfAccidentes();		

		otraVacuna = new APPOtrasVacunas();
		obtenerVacunas();

		medAct = new APPMedicacionActual();
		obtenerMedActual();

		System.out.println("Se realizó PostConstruct de Antecedentes PP ");
	}

	public void setDescripcionEdoActualEnfermedad(){
		if(enfermedad.getIdCatEnfEdoActual()!= null && enfermedad.getIdCatEnfEdoActual().getIdCatEnfEdoActual()!= null && enfermedad.getIdCatEnfEdoActual().getIdCatEnfEdoActual().intValue()!=0){
			Long estadoActual = enfermedad.getIdCatEnfEdoActual().getIdCatEnfEdoActual();			
			for (CatEnfEdoActual catEdoActual : edoActual){
				if(catEdoActual.getIdCatEnfEdoActual() == estadoActual){					
					enfermedad.getIdCatEnfEdoActual().setIdCatEnfEdoActual(estadoActual);
					enfermedad.getIdCatEnfEdoActual().setDescripcion(catEdoActual.getDescripcion());
					break;
				}
			}
		}
		else{
			enfermedad.getIdCatEnfEdoActual().setIdCatEnfEdoActual(new Long(0));
			enfermedad.getIdCatEnfEdoActual().setDescripcion("");
		}
	}

	public String reinitEnfermedad() {
		enfermedad = new APPEnfermedades();
		enfermedad.setIdCatEnfEdoActual(new CatEnfEdoActual());		
		return null;
	}

	public String reinitHospyCir() {
		hospCir = new APPHospYCirugias();

		return null;
	}

	public String reinitEnfAcc() {
		enfAcc = new APPEnfAccidentes();

		return null;
	}

	public String reinitVacuna(){
		otraVacuna = new APPOtrasVacunas();

		return null;
	}

	public String reinitiMedAct() {
		medAct = new APPMedicacionActual();

		return null;
	}

	private void obtenerAPPEnfermedades(){
		enfermedades = appDao.obtenerEnfermedadesPorIdPaciente(paciente.getIdPaciente());

		if(enfermedades == null){
			enfermedades = new ArrayList<APPEnfermedades>();
		}
		
		System.out.println("enfermedades guardadas " + enfermedades.size());
	}

	private void obtenerHospYCirugias(){
		listaHospCir = appDao.obtenerHospYCirugiasPorIdPaciente(paciente.getIdPaciente());

		if(listaHospCir == null){
			listaHospCir = new ArrayList<APPHospYCirugias>();
		}
	}

	private void obtenerEnfAccidentes(){
		listaEnfAcc = appDao.obtenerEnfAccidentesPorIdPaciente(paciente.getIdPaciente());

		if(listaEnfAcc == null){
			listaEnfAcc = new ArrayList<APPEnfAccidentes>();
		}
	}

	private void obtenerVacunas(){
		CatAntecedentesVacunas cav = catVacunas.get(catVacunas.size()-1);
		vacunas = appDao.obtenerVacunasPorIdPaciente(paciente.getIdPaciente());

		if(vacunas.isEmpty()){
			vacunas = new ArrayList<APPVacunas>();

			for(int i = 0; i <catVacunas.size()-1; i++){
				APPVacunas vacuna = new APPVacunas();
				vacuna.setIdCatAntVacunas(catVacunas.get(i));
				vacunas.add(vacuna);
			}
		}

		listaVacunas = appDao.obtenerOtrasVacunasPorIdPaciente(paciente.getIdPaciente(), cav.getIdCatAntVacunas());

		if(listaVacunas.isEmpty()){
			listaVacunas = new ArrayList<APPOtrasVacunas>();
			//otraVacuna.setIdCatAntVacunas(catVacunas.get(catVacunas.size()-1));
		}
	}

	private void obtenerMedActual(){
		listMedAct = appDao.obtenerMedicacionActualPorIdPaciente(paciente.getIdPaciente());

		if(listMedAct == null){
			listMedAct = new ArrayList<APPMedicacionActual>();
		}
	}

	public List<String> buscarEnfermedades(String query) {
		List<String> enfermedades = new ArrayList<String>();

		for(CatEnfermedad catEnferm: catEnfermedades){
			if(catEnferm.getDescripcion().toUpperCase().contains(query.toUpperCase())) {
				enfermedades.add(catEnferm.getDescripcion());
			}
		}
		return enfermedades;  
	}

	/*******************************************************************************************/
	@Override
	public String registrar(Long modo){		
		registrarEnfermedades();
		registarHospYCirugias();
		registarEnfAccidentes();
		registarVacunas();
		registarMedicacionActual();

		switch(modo.intValue()) {
		case 1: 
			return rutas.getString(Rutas.CONSULTA1_AGO);
		case 3: 
			return rutas.getString(Rutas.CONSULTA_DETALLE_AGO);	  
		default: 
			return "";
		}
	}

	public void registrarEnfermedades(){
		//List<APPEnfermedades> enfermedadesAborrar = appDao.obtenerEnfermedadesPorIdPaciente(paciente.getIdPaciente());

		for(APPEnfermedades enfermedad : enfermedades){			
			if(enfermedad.getIdCatEnfEdoActual() == null){
				enfermedad.setIdCatEnfEdoActual(new CatEnfEdoActual());							
			}
			enfermedad.setPaciente(paciente);
			//System.out.println("enfermedad antes de guardar " + enfermedad);
			appDao.registrarEnfermedades(enfermedad);
		}
	}

	public void registarHospYCirugias(){
		List<APPHospYCirugias> hospYCirugiasABorrar = appDao.obtenerHospYCirugiasPorIdPaciente(paciente.getIdPaciente());
		
		for(APPHospYCirugias hospYCirugiasAnterior : hospYCirugiasABorrar){
			for(APPHospYCirugias hospYCirugias : listaHospCir){
				if(hospYCirugiasAnterior.getIdAppCirugias() == hospYCirugias.getIdAppCirugias()){
					hospYCirugiasABorrar.remove(hospYCirugiasAnterior);
				}
			}
		}
		for(APPHospYCirugias hospYCirugia : listaHospCir){
			hospYCirugia.setPaciente(paciente);
			appDao.registrarHospYCirugias(hospYCirugia);
		}
		for(APPHospYCirugias hospYCirugiaBorrar : hospYCirugiasABorrar){
			appDao.borrarHospYCirugias(hospYCirugiaBorrar);
		}
	}

	public void registarEnfAccidentes(){		
		List<APPEnfAccidentes> enfAccidentesABorrar = appDao.obtenerEnfAccidentesPorIdPaciente(paciente.getIdPaciente());

		for(APPEnfAccidentes enfAccidentesAnterior : enfAccidentesABorrar){
			for(APPEnfAccidentes enfAccidentes : listaEnfAcc){
				if(enfAccidentesAnterior.getIdEnfAccidentes() == enfAccidentes.getIdEnfAccidentes()){
					enfAccidentesABorrar.remove(enfAccidentesAnterior);
				}
			}
		}
		for(APPEnfAccidentes enfAccidentes : listaEnfAcc){
			enfAccidentes.setPaciente(paciente);
			appDao.registrarEnfAccidentes(enfAccidentes);
		}
		for(APPEnfAccidentes enfAccidentesBorrar : enfAccidentesABorrar){
			appDao.borrarEnfAccidentes(enfAccidentesBorrar);
		}
	}

	public void registarVacunas(){
		CatAntecedentesVacunas cav = catVacunas.get(catVacunas.size()-1);
		List<APPOtrasVacunas> vacunasABorrar = appDao.obtenerOtrasVacunasPorIdPaciente(paciente.getIdPaciente(), cav.getIdCatAntVacunas());

		for(APPOtrasVacunas vacunasAnterior : vacunasABorrar){
			for(APPOtrasVacunas vacunas : listaVacunas){
				if(vacunasAnterior.getIdAppOtrasVacunas() == vacunas.getIdAppOtrasVacunas()){
					vacunasABorrar.remove(vacunasAnterior);
				}
			}
		}

		for(APPVacunas vacuna : vacunas){
			vacuna.setIdPaciente(paciente);
			appDao.registrarVacunas(vacuna);			
		}

		for(APPOtrasVacunas otraVacuna : listaVacunas){
			otraVacuna.setPaciente(paciente);
			//otraVacuna.setIdCatAntVacunas(catVacunas.get(catVacunas.size()-1));
			appDao.registrarOtrasVacunas(otraVacuna);
		}

		for(APPOtrasVacunas vacunasBorrar : vacunasABorrar){
			appDao.borrarOtrasVacunas(vacunasBorrar);
		}
	}

	public void registarMedicacionActual(){		
		List<APPMedicacionActual> medActABorrar = appDao.obtenerMedicacionActualPorIdPaciente(paciente.getIdPaciente());

		for(APPMedicacionActual medActAnterior : medActABorrar){
			for(APPMedicacionActual medActual : listMedAct){
				if(medActAnterior.getIdAppMedicacion()  == medActual.getIdAppMedicacion()){
					medActABorrar.remove(medActAnterior);
				}
			}
		}
		for(APPMedicacionActual medActual : listMedAct){
			medActual.setPaciente(paciente);
			appDao.registrarMedicacionActual(medActual);
		}
		for(APPMedicacionActual medActualBorrar : medActABorrar){
			appDao.borrarMedicacionActual(medActualBorrar);
		}
	}

	@Override
	public String cancelar() {
		return null;
	}
	
	public List<CatEnfEdoActual> getEdoActual() {
		return edoActual;
	}
	public void setEdoActual(List<CatEnfEdoActual> edoActual) {
		this.edoActual = edoActual;
	}

	public List<CatEnfermedad> getCatEnfermedades() {
		return catEnfermedades;
	}
	public void setCatEnfermedades(List<CatEnfermedad> enfermedades) {
		this.catEnfermedades = enfermedades;
	}

	public List<CatAntecedentesVacunas> getCatVacunas() {
		return catVacunas;
	}
	public void setCatVacunas(List<CatAntecedentesVacunas> catVacunas) {
		this.catVacunas = catVacunas;
	}

	public APPEnfermedades getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(APPEnfermedades enfermedad) {
		this.enfermedad = enfermedad;
	}

	public List<APPEnfermedades> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(List<APPEnfermedades> enfermedades) {
		this.enfermedades = enfermedades;
	}

	public List<APPVacunas> getVacunas() {
		return vacunas;
	}
	public void setVacunas(List<APPVacunas> vacunas) {
		this.vacunas = vacunas;
	}

	public APPHospYCirugias getHospCir() {
		return hospCir;
	}
	public void setHospCir(APPHospYCirugias hospCir) {
		this.hospCir = hospCir;
	}

	public List<APPHospYCirugias> getListaHospCir() {
		return listaHospCir;
	}
	public void setListaHospCir(List<APPHospYCirugias> listaHospCir) {
		this.listaHospCir = listaHospCir;
	}

	public APPEnfAccidentes getEnfAcc() {
		return enfAcc;
	}
	public void setEnfAcc(APPEnfAccidentes enfAcc) {
		this.enfAcc = enfAcc;
	}

	public List<APPEnfAccidentes> getListaEnfAcc() {
		return listaEnfAcc;
	}
	public void setListaEnfAcc(List<APPEnfAccidentes> listaEnfAcc) {
		this.listaEnfAcc = listaEnfAcc;
	}

	public APPMedicacionActual getMedAct() {
		return medAct;
	}
	public void setMedAct(APPMedicacionActual medAct) {
		this.medAct = medAct;
	}

	public List<APPMedicacionActual> getListMedAct() {
		return listMedAct;
	}
	public void setListMedAct(List<APPMedicacionActual> listMedAct) {
		this.listMedAct = listMedAct;
	}

	public APPOtrasVacunas getOtraVacuna() {
		return otraVacuna;
	}
	public void setOtraVacuna(APPOtrasVacunas otraVacuna) {
		this.otraVacuna = otraVacuna;
	}

	public List<APPOtrasVacunas> getListaVacunas() {
		return listaVacunas;
	}
	public void setListaVacunas(List<APPOtrasVacunas> listaVacunas) {
		this.listaVacunas = listaVacunas;
	}
}