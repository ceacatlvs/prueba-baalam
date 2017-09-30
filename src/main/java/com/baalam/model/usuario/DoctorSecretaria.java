package com.baalam.model.usuario;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "buscarSecretariasAsociarDoctor", 
			query = "select s from Secretaria s where s.idSecretaria NOT IN (select ds.idSecreataria from DoctorSecretaria ds where ds.idDoctor = :doctor)"
		)
//select * from baalampakal.secretaria where idSecretaria NOT IN (select idSecreataria from baalampakal.doctor_secretaria where idDoctor = 1);
@Table(name = "doctor_secretaria")
@IdClass(DoctorSecretariaId.class)
public class DoctorSecretaria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idDoctor;
	
	@Id
	private Long idSecreataria;
	
	@Column(name = "fechaCreacionRelacion")
	private Date fechaCreacionRelacion;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
	private Doctor doctor;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "idSecreataria", referencedColumnName = "idSecretaria")
	private Secretaria secreataria;

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

	public Date getFechaCreacionRelacion() {
		return fechaCreacionRelacion;
	}

	public void setFechaCreacionRelacion(Date fechaCreacionRelacion) {
		this.fechaCreacionRelacion = fechaCreacionRelacion;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Secretaria getSecreataria() {
		return secreataria;
	}

	public void setSecreataria(Secretaria secreataria) {
		this.secreataria = secreataria;
	}
}
