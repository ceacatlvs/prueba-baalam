package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPEnfAccidentes.class)
public abstract class APPEnfAccidentes_ {

	public static volatile SingularAttribute<APPEnfAccidentes, Paciente> paciente;
	public static volatile SingularAttribute<APPEnfAccidentes, Long> idAppEnfAccidentes;
	public static volatile SingularAttribute<APPEnfAccidentes, Date> fecha;
	public static volatile SingularAttribute<APPEnfAccidentes, String> tipo;

}

