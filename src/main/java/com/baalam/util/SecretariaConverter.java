package com.baalam.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.baalam.controller.LoginMB;
import com.baalam.dao.usuarios.SecretariaDao;
import com.baalam.model.usuario.DoctorSecretaria;
import com.baalam.model.usuario.Secretaria;

@Named
@ViewAccessScoped
//@FacesConverter(value="secretariaConverter", forClass=Secretaria.class)
public class SecretariaConverter implements Serializable, Converter{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginMB loginMB;
	
	@Inject
	private SecretariaDao secreDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, 	String value) {
		
		if (value.trim().equals("")) {
            return null;
        } else {
            try {            	
                Long idSecretaria = (long)Integer.parseInt(value);   
                
                Secretaria secretaria = secreDao.buscarSecretariaPorIdSecretaria(idSecretaria);
                System.out.println("Secretaria: " + secretaria);
                
                DoctorSecretaria docSecre = new DoctorSecretaria();
                docSecre.setSecreataria(secretaria);
                docSecre.setDoctor(loginMB.getDoctor());
                docSecre.setIdDoctor(loginMB.getDoctor().getIdDoctor());
                docSecre.setIdSecreataria(secretaria.getIdSecretaria());
                
                return docSecre;
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Algo sucedio",""));
            }
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
	
		if (value == null || value.equals("")) {
            return "";
        } else {        	
            return String.valueOf(((Secretaria) value).getIdSecretaria());
        }
	}
}