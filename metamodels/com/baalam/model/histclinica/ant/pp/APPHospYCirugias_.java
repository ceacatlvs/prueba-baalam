package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPHospYCirugias.class)
public abstract class APPHospYCirugias_ {

	public static volatile SingularAttribute<APPHospYCirugias, Paciente> paciente;
	public static volatile SingularAttribute<APPHospYCirugias, Date> fecha;
	public static volatile SingularAttribute<APPHospYCirugias, Long> idAppCirugias;
	public static volatile SingularAttribute<APPHospYCirugias, String> edoActual;
	public static volatile SingularAttribute<APPHospYCirugias, String> hospital;
	public static volatile SingularAttribute<APPHospYCirugias, String> causa;

}

