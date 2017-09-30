package com.baalam.model.usuario;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Secretaria.class)
public abstract class Secretaria_ {

	public static volatile SingularAttribute<Secretaria, String> nombre;
	public static volatile SingularAttribute<Secretaria, String> aPaterno;
	public static volatile SetAttribute<Secretaria, Doctor> doctores;
	public static volatile SingularAttribute<Secretaria, Usuario> usuario;
	public static volatile SingularAttribute<Secretaria, String> aMaterno;
	public static volatile SingularAttribute<Secretaria, Long> idSecretaria;
	public static volatile SingularAttribute<Secretaria, DatosContacto> datosContacto;

}

