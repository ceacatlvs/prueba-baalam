package com.baalam.model.histclinica.ant.hf;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AHFFallecimiento.class)
public abstract class AHFFallecimiento_ {

	public static volatile SingularAttribute<AHFFallecimiento, Paciente> paciente;
	public static volatile SingularAttribute<AHFFallecimiento, Long> idFamiliar;
	public static volatile SingularAttribute<AHFFallecimiento, String> parentesco;
	public static volatile SingularAttribute<AHFFallecimiento, String> edad;
	public static volatile SingularAttribute<AHFFallecimiento, Boolean> fallecido;
	public static volatile SingularAttribute<AHFFallecimiento, String> causa;

}

