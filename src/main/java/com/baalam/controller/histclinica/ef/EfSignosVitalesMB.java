package com.baalam.controller.histclinica.ef;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.histclinica.ef.EfSignosVitalesDao;
import com.baalam.model.histclinica.ef.EFSignosVitales;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import com.baalam.util.Rutas;

@Named
@RequestScoped
public class EfSignosVitalesMB extends BaseController {

	private static final long serialVersionUID = 1L;
	private static final double LIBRAS_POR_KILO = 2.20462262;
	private static final double PIES_POR_CM = 0.032808399;
	private static final double CM_POR_PIE = 30.48;
	private static final double CM_POR_PULGADA = 2.54;
	private static final int PULGADAS_POR_PIE = 12;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject 
	private EfSignosVitalesDao efSVDao;
	
	private PadecimientoActual pa;
	private EFSignosVitales efSV;
	private Date horaConsulta;
	
	@PostConstruct
	public void efSignosVitales(){
		setPa(pamb.getPadecimientoActual());
		obtenerEfSignosVitales();
		
	}
	
	private void obtenerEfSignosVitales(){
		setEfSV(efSVDao.buscarEFSignosVitalesPorIdConsulta(pa.getIdConsulta()));
		
		if(efSV == null){
			efSV = new EFSignosVitales();
		}else{
			calcularIMC();
		}
		if(efSV.getFechaConsulta()==null){
			efSV.setFechaConsulta(pa.getFechaConsulta());
			horaConsulta = pa.getFechaConsulta();
		}else{
			horaConsulta = efSV.getFechaConsulta();
		}
	}
	
	public void convertirPesoKgALb(){
		double pesoEnLb = efSV.getPesoKg().doubleValue()* LIBRAS_POR_KILO;
		efSV.setPesoLb(pesoEnLb);
	}
	
	public void convertirPesoLbAKg(){
		double pesoEnKg = efSV.getPesoLb().doubleValue() / LIBRAS_POR_KILO;
		efSV.setPesoKg(pesoEnKg);
	}
	
	public void convertirPesoIdealKgALb(){
		double pesoEnLb = efSV.getPesoIdealKg().doubleValue()* LIBRAS_POR_KILO;
		efSV.setPesoIdealLb(pesoEnLb);
	}

	public void convertirPesoIdealLbAKg(){
		double pesoEnKg = efSV.getPesoIdealLb().doubleValue()/ LIBRAS_POR_KILO;
		efSV.setPesoIdealKg(pesoEnKg);
	}
	
	public void convertirTalla(){
		Double tallaEnPies = efSV.getTallaCm().doubleValue()* PIES_POR_CM;
		Double tallaEnPiesEnteros = Math.floor(tallaEnPies);
		Double sobranteEnPulgadas = ((tallaEnPies - tallaEnPiesEnteros) * PULGADAS_POR_PIE);
		sobranteEnPulgadas = (double) Math.round(sobranteEnPulgadas);
		efSV.setTallaIn(sobranteEnPulgadas.intValue());
		efSV.setTallaPies(tallaEnPiesEnteros.intValue());
	}
	
	public void convertirTallaACm(){
		Double tallaCm = (efSV.getTallaIn().doubleValue()* CM_POR_PULGADA) + (efSV.getTallaPies().doubleValue()* CM_POR_PIE);
		efSV.setTallaCm(tallaCm.intValue());
	}
	
	public void calcularIMC(){	
		if(efSV.getTallaCm() != null && efSV.getPesoKg() != null && efSV.getTallaCm().intValue()>0 && efSV.getPesoKg().intValue()>0){
			double tallaM = efSV.getTallaCm() * .01;
			Double imc = efSV.getPesoKg() / Math.pow(tallaM, 2);
			BigDecimal bd = new BigDecimal(imc);
		    bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			imc = bd.doubleValue();
			efSV.setImc(imc);		
		}		
	}

	public void cambioPeso(){
		calcularIMC();
		convertirPesoKgALb();
	}
	
	public void cambioTalla(){
		convertirTalla();
		calcularIMC();
	}
	
	@Override
	public String registrar(Long modo) {
		calcularIMC();	
		
		Calendar horaAGuardar = GregorianCalendar.getInstance(); 
		horaAGuardar.setTime(horaConsulta); 
		Calendar fechaAGuardar = GregorianCalendar.getInstance(); 
		fechaAGuardar.setTime(efSV.getFechaConsulta());
		fechaAGuardar.set(fechaAGuardar.get(Calendar.YEAR),fechaAGuardar.get(Calendar.MONTH),fechaAGuardar.get(Calendar.DAY_OF_MONTH),horaAGuardar.get(Calendar.HOUR_OF_DAY),horaAGuardar.get(Calendar.MINUTE));
		
		efSV.setFechaConsulta(fechaAGuardar.getTime());
		efSV.setPadecimientoActual(pa);
		efSVDao.registrarEfSignosVitales(efSV);
		
		switch(modo.intValue()) {
			case 1: 
				return rutas.getString(Rutas.CONSULTA1_EF_CUELLO);	
			case 2: 
				return rutas.getString(Rutas.CONSULTA_SUB_EF_CUELLO);
			case 3:
				return rutas.getString(Rutas.DETALLE1_EF_CUELLO);
			case 4:
				return rutas.getString(Rutas.DETALLE_SUB_EF_CUELLO);
			case 5:
				return rutas.getString(Rutas.CONSULTA_SUB_EP_BH);
			case 6: 
				return rutas.getString(Rutas.DETALLE_SUB_EP_BH);	  
			default: 
				return "";
		}	
	}

	@Override
	public String cancelar() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public EFSignosVitales getEfSV() {
		return efSV;
	}
	public void setEfSV(EFSignosVitales efSV) {
		this.efSV = efSV;
	}
	
	public void setPa(PadecimientoActual pa){
		this.pa = pa;
	}

	public Date getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(Date horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
}