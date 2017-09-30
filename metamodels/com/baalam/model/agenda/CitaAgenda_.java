package com.baalam.model.agenda;

import com.baalam.model.usuario.Doctor;
import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CitaAgenda.class)
public abstract class CitaAgenda_ {

	public static volatile SingularAttribute<CitaAgenda, String> motivoOcupado;
	public static volatile SingularAttribute<CitaAgenda, Paciente> paciente;
	public static volatile SingularAttribute<CitaAgenda, Long> idCita;
	public static volatile SingularAttribute<CitaAgenda, Date> citaInicio;
	public static volatile SingularAttribute<CitaAgenda, Date> citaFin;
	public static volatile SingularAttribute<CitaAgenda, String> tipoConsulta;
	public static volatile SingularAttribute<CitaAgenda, Doctor> doctor;

}

