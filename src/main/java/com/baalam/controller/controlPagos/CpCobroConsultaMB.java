package com.baalam.controller.controlPagos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.BaseController;
import com.baalam.controller.histclinica.FichaIdentificacionMB;
import com.baalam.controller.histclinica.PadecimientoActualMB;
import com.baalam.dao.controlPagos.ControlPagosDao;
import com.baalam.exceptions.NegativeNumberException;
import com.baalam.model.catalogo.CatTipoPago;
import com.baalam.model.controlPagos.CpCobroConsulta;
import com.baalam.model.controlPagos.CpPagos;
import com.baalam.util.Rutas;

@Named
@ViewAccessScoped
public class CpCobroConsultaMB extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PadecimientoActualMB pamb;
	
	@Inject
	private FichaIdentificacionMB fimb;
	
	@Inject
	private ControlPagosDao controlPagosDao;
	
	private CpCobroConsulta cobroConsulta;
	private CpPagos pago;
	private Long idPaciente;
	
	private List<CpCobroConsulta> cobrosConsulta;
	private List<CpPagos> pagosCobroConsulta;
	
	private List<CatTipoPago> tiposPago;
	
	@PostConstruct
	public void collectorCobroConsulta() {			
		System.out.println("idPaciente " + getIdPaciente());

		setIdPaciente(fimb.getPaciente().getIdPaciente());
		
		obtenerCobrosPaciente();
		
		setTiposPago(controlPagosDao.obtenerTipoPago());
		
		System.out.println("Se realizó PostConstruct de CP: Cobro consulta ");
	}
	
	private void obtenerCobrosPaciente(){		
		setCobrosConsulta(controlPagosDao.obtenerCobrosConsultaPorIdPaciente(getIdPaciente()));
		
		if(getCobroConsulta() == null){
			setCobroConsulta(new CpCobroConsulta());
			getCobroConsulta().setPadecimientoActual(pamb.getPadecimientoActual());						
		}
		
		if(getCobrosConsulta() == null){
			cobrosConsulta = new ArrayList<CpCobroConsulta>();
		}		
		
		if(getCobroConsulta().getCpPagos() == null){
			getCobroConsulta().setCpPagos(new ArrayList<CpPagos>());
		}
		
		setPago(new CpPagos());		
		getPago().setTipoPago(new CatTipoPago());
		getPago().setFechaPago(getFechaHoy());
		getPago().setCantidadPago(getCobroConsulta().getPendientePagar());
	}
	
	@Override
	public String registrar(Long modo) {
		
		if(modo == 2){ //registro de pago
			try {
				getPago().setCpCobroConsulta(getCobroConsulta());				
				getCobroConsulta().getCpPagos().add(getPago());
				System.out.println("cantidad de pago " + getPago().getCantidadPago());
				System.out.println("cobro consulta con pagos " + getCobroConsulta().getCpPagos().size());				
				getCobroConsulta().setPendientePagar(calcularCantidadAPagar());
			} catch (NegativeNumberException e) {
				Double pendientePagar = getPago().getCpCobroConsulta().getPendientePagar();
				getCobroConsulta().setPendientePagar(pendientePagar);
				return null;
			}			
		}
		else if(modo == 1){ //registro cobro
			getCobroConsulta().setPendientePagar(getCobroConsulta().getMonto());			
		}
		
		System.out.println("cobro consulta pendiente pagar " + getCobroConsulta().getPendientePagar());
		/*corregí que se guardara la cantidad pendiete a pagar cuando se registra un cobro
		 * estoy en q en la secretaria en consultas dl día en registrar registre el pago y luego seguiré
		 * con el médico tmb*/
		controlPagosDao.registrarCobroConsulta(cobroConsulta);
		
		return rutas.getString(Rutas.INICIO_MEDICO);
	}
	
	@Override
	public String cancelar() {
		//aquí se tiene que hacer algo para que cuando se registre un pago y luego se vuelva a registrar otro el formulrio este limpio
		return null;	
	}
	
	private Double calcularCantidadAPagar() throws NegativeNumberException{
		Double cantidadPago = getPago().getCantidadPago();
		Double pendientePagar = getPago().getCpCobroConsulta().getPendientePagar();
		
		if(cantidadPago <= pendientePagar){
			System.out.println("resta " + (pendientePagar - cantidadPago));
			return pendientePagar - cantidadPago;
		}else{
			System.out.println("la cantidad de pago no puede ser mayor a lo pendiente a pagar");			
			throw new NegativeNumberException("La cantidad de pago no puede ser mayor a la cantidad pendiente a pagar");
			//return pendientePagar;
		}		
	}

	public String verDetallePagos(Long idPaciente, Long rol){
		setIdPaciente(idPaciente);
		obtenerCobrosPaciente();
		
		switch(rol.intValue()){
			case 2:
				return rutas.getString(Rutas.DETALLE_CONTROL_PAGOS_ASISTENTE);
			case 1:		
			default:
				return "";
		}
	}
	
	public CpCobroConsulta getCobroConsulta() {
		return cobroConsulta;
	}
	public void setCobroConsulta(CpCobroConsulta cobroConsulta) {
		this.cobroConsulta = cobroConsulta;
	}
	
	public CpPagos getPago() {
		return pago;
	}

	public void setPago(CpPagos pago) {
		this.pago = pago;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public List<CpCobroConsulta> getCobrosConsulta() {
		return cobrosConsulta;
	}

	public void setCobrosConsulta(List<CpCobroConsulta> cobrosConsulta) {
		this.cobrosConsulta = cobrosConsulta;
	}

	public List<CpPagos> getPagosCobroConsulta() {
		return pagosCobroConsulta;
	}

	public void setPagosCobroConsulta(List<CpPagos> pagosCobroConsulta) {
		this.pagosCobroConsulta = pagosCobroConsulta;
	}

	public List<CatTipoPago> getTiposPago() {
		return tiposPago;
	}

	public void setTiposPago(List<CatTipoPago> tiposPago) {
		this.tiposPago = tiposPago;
	}
}
