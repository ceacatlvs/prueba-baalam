package com.baalam.controller.histclinica.antecedentes;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.event.TabChangeEvent;

@Named
@ViewAccessScoped
public class AntecedentesMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void onTabChange(TabChangeEvent event) {
		System.out.println("Cambio de Tab, la tab activa es: " + event.getTab().getId() + " " + event.getTab().getTitle());
		FacesMessage msg = new FacesMessage("Cambio de Tab", "La tab activa es: " + event.getTab().getId() + " " + event.getTab().getTitle());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	
}
