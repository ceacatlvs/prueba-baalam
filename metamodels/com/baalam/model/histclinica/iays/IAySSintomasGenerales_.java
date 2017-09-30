package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySSintomasGenerales.class)
public abstract class IAySSintomasGenerales_ {

	public static volatile SingularAttribute<IAySSintomasGenerales, Boolean> fatiga;
	public static volatile SingularAttribute<IAySSintomasGenerales, Boolean> perdidaPeso;
	public static volatile SingularAttribute<IAySSintomasGenerales, Paciente> paciente;
	public static volatile SingularAttribute<IAySSintomasGenerales, Boolean> negativo;
	public static volatile SingularAttribute<IAySSintomasGenerales, String> otro;
	public static volatile SingularAttribute<IAySSintomasGenerales, Boolean> fiebre;
	public static volatile SingularAttribute<IAySSintomasGenerales, String> observaciones;
	public static volatile SingularAttribute<IAySSintomasGenerales, Boolean> aumentoPeso;

}

