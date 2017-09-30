package com.baalam.model.usuario;

import java.io.Serializable;

public class DoctorSecretariaId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idDoctor;
	
	private Long idSecreataria;
	
	
	public Long getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}
	
	public Long getIdSecreataria() {
		return idSecreataria;
	}
	public void setIdSecreataria(Long idSecreataria) {
		this.idSecreataria = idSecreataria;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorSecretariaId other = (DoctorSecretariaId) obj;
		if (idDoctor == null) {
			if (other.idDoctor != null)
				return false;
		} else if (!idDoctor.equals(other.idDoctor))
			return false;
		if (idSecreataria == null) {
			if (other.idSecreataria != null)
				return false;
		} else if (!idSecreataria.equals(other.idSecreataria))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDoctor == null) ? 0 : idDoctor.hashCode());
		result = prime * result
				+ ((idSecreataria == null) ? 0 : idSecreataria.hashCode());
		return result;
	}
}