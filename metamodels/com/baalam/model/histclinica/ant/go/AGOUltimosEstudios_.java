package com.baalam.model.histclinica.ant.go;

import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AGOUltimosEstudios.class)
public abstract class AGOUltimosEstudios_ {

	public static volatile SingularAttribute<AGOUltimosEstudios, Paciente> paciente;
	public static volatile SingularAttribute<AGOUltimosEstudios, Boolean> autoexploracionMamaria;
	public static volatile SingularAttribute<AGOUltimosEstudios, Date> fechaUltimaMamografia;
	public static volatile SingularAttribute<AGOUltimosEstudios, Date> fechaUltimaCitologia;
	public static volatile SingularAttribute<AGOUltimosEstudios, String> observacionesUltimaDensitometria;
	public static volatile SingularAttribute<AGOUltimosEstudios, String> resultadoUltimaCC;
	public static volatile SingularAttribute<AGOUltimosEstudios, String> observacionesAutoMamaria;
	public static volatile SingularAttribute<AGOUltimosEstudios, String> observacionesUltimaCC;
	public static volatile SingularAttribute<AGOUltimosEstudios, String> observacionesMamografia;
	public static volatile SingularAttribute<AGOUltimosEstudios, Date> fechaUltimaDensitometria;

}

