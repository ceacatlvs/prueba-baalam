package com.baalam.model.usuario;

import com.baalam.model.catalogo.CatEspecialidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Doctor.class)
public abstract class Doctor_ {

	public static volatile SingularAttribute<Doctor, String> nombre;
	public static volatile SingularAttribute<Doctor, String> aPaterno;
	public static volatile SingularAttribute<Doctor, Long> idDoctor;
	public static volatile SingularAttribute<Doctor, Usuario> usuario;
	public static volatile SetAttribute<Doctor, Secretaria> secretarias;
	public static volatile SingularAttribute<Doctor, CatEspecialidad> especialidad;
	public static volatile SingularAttribute<Doctor, String> aMaterno;
	public static volatile SingularAttribute<Doctor, DatosContacto> datosContacto;

}

