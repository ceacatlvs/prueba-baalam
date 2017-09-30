package com.baalam.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistorialConsultas.class)
public abstract class HistorialConsultas_ {

	public static volatile SingularAttribute<HistorialConsultas, Long> idPaciente;
	public static volatile SingularAttribute<HistorialConsultas, String> motivoConsulta;
	public static volatile SingularAttribute<HistorialConsultas, Long> idConsulta;
	public static volatile SingularAttribute<HistorialConsultas, Date> fechaConsulta;
	public static volatile SingularAttribute<HistorialConsultas, String> tipoConsulta;
	public static volatile SingularAttribute<HistorialConsultas, String> chOtros;

}

