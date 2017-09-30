package com.baalam.util;

import javax.faces.application.FacesMessage;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.lang3.StringUtils;

public class MessagePhaseListener implements PhaseListener {
	private static final long serialVersionUID = 1L;

	@Override
    public void afterPhase(PhaseEvent phaseEvent) {
       //no-op
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        for (FacesMessage message : phaseEvent.getFacesContext().getMessageList()) {
            if(StringUtils.isBlank(message.getDetail()) ||
                    (StringUtils.isNotBlank(message.getSummary()) && message.getSummary().equals(message.getDetail()))){
                message.setDetail(" ");
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
