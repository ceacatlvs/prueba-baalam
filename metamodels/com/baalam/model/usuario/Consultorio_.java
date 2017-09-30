package com.baalam.model.usuario;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consultorio.class)
public abstract class Consultorio_ {

	public static volatile SingularAttribute<Consultorio, String> nombre;
	public static volatile SingularAttribute<Consultorio, String> horario;
	public static volatile SingularAttribute<Consultorio, Boolean> requiereCita;
	public static volatile SingularAttribute<Consultorio, String> descripcion;
	public static volatile SingularAttribute<Consultorio, Long> idConsultorio;
	public static volatile SingularAttribute<Consultorio, Doctor> doctor;
	public static volatile SingularAttribute<Consultorio, DatosContacto> datosContacto;

}

