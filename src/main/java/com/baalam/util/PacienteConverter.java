package com.baalam.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.myfaces.extensions.cdi.core.api.Advanced;

import com.baalam.dao.inicio.PacienteDao;
import com.baalam.model.paciente.Paciente;

//La anotación Advanced es la que habilita la inyección de CDI dentro de un convertidor de JSF.
//sin esta, la inyección de PacienteDao no funciona: https://cwiki.apache.org/confluence/display/EXTCDI/JSF+Usage#JSFUsage-DependencyInjection
@Advanced
@FacesConverter(value = "pacienteConverter")
public class PacienteConverter implements Converter {

	@Inject
	private PacienteDao pacDao;
	
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                Long idPaciente = (long) Integer.parseInt(submittedValue);
                Paciente paciente = pacDao.buscarPacientePorId(idPaciente);
                return paciente;

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El Nombre de la paciente es requerido",""));
            }
        }
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Paciente) value).getIdPaciente());
        }
    }
}
                    