package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPOtrasVacunas.class)
public abstract class APPOtrasVacunas_ {

	public static volatile SingularAttribute<APPOtrasVacunas, Paciente> paciente;
	public static volatile SingularAttribute<APPOtrasVacunas, Date> fecha;
	public static volatile SingularAttribute<APPOtrasVacunas, String> observaciones;
	public static volatile SingularAttribute<APPOtrasVacunas, Long> idAppOtrasVacunas;

}

