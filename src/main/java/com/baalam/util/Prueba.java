package com.baalam.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean  
@ViewScoped
public class Prueba implements Serializable {
	
	private static final long serialVersionUID = 20111020L;  
	  
    private List<Message> messages;  
    private List<Message> filteredMessages;  
    private String newSubject = "my subject";  
    private String newText = "my text";  
  
    public Prueba() {  
        if (messages == null) {  
            messages = new ArrayList<Message>();  
  
            for (int i = 0; i < 100; i++) {  
                Message message = new Message();  
                message.setSubject("subject " + i);  
                message.setText("text " + i);  
                messages.add(message);  
            }  
        }  
    }  
  
    public List<Message> getMessages() {  
        return messages;  
    }  
  
    public void setMessages(final List<Message> messages) {  
        this.messages = messages;  
    }  
  
    public List<Message> getFilteredMessages() {  
        return filteredMessages;  
    }  
  
    public void setFilteredMessages(List<Message> filteredMessages) {  
        this.filteredMessages = filteredMessages;  
    }  
  
    public String getNewSubject() {  
        return newSubject;  
    }  
  
    public void setNewSubject(String newSubject) {  
        this.newSubject = newSubject;  
    }  
  
    public String getNewText() {  
        return newText;  
    }  
  
    public void setNewText(String newText) {  
        this.newText = newText;  
    }  
  
    public String addMessage() {  
        doSomething();  
  
        Message message = new Message();  
        message.setSubject(newSubject);  
        message.setText(newText);  
        messages.add(0, message);  
  
        newSubject = "";  
        newText = "";  
  
        FacesContext fc = FacesContext.getCurrentInstance();  
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "New message has been added successfully", null));  
  
        return null;  
    }  
  
    public void doSomething() {  
        try {  
            // simulate a long running request  
            Thread.sleep(1500);  
        } catch (Exception e) {  
            // ignore  
        }  
    }  
  
    public class Message implements Serializable {  
  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String subject;  
        private String text;  
        private long time;  
  
        public Message() {  
            time = System.currentTimeMillis() + (long) (Math.random() * 10);  
        }  
  
        public final String getSubject() {  
            return subject;  
        }  
  
        public final void setSubject(String subject) {  
            this.subject = subject;  
        }  
  
        public final String getText() {  
            return text;  
        }  
  
        public final void setText(String text) {  
            this.text = text;  
        }  
  
        public long getTime() {  
            return time;  
        }  
  
        public void setTime(long time) {  
            this.time = time;  
        }  
    }
	
}
