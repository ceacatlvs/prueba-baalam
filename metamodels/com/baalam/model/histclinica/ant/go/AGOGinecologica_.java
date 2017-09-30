package com.baalam.model.histclinica.ant.go;

import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AGOGinecologica.class)
public abstract class AGOGinecologica_ {

	public static volatile SingularAttribute<AGOGinecologica, String> paridad;
	public static volatile SingularAttribute<AGOGinecologica, Paciente> paciente;
	public static volatile SingularAttribute<AGOGinecologica, Boolean> sexualmenteActiva;
	public static volatile SingularAttribute<AGOGinecologica, Integer> parejasSexuales;
	public static volatile SingularAttribute<AGOGinecologica, Integer> edadVidaSexual;
	public static volatile SingularAttribute<AGOGinecologica, Boolean> spm;
	public static volatile SingularAttribute<AGOGinecologica, Date> fum;
	public static volatile SingularAttribute<AGOGinecologica, Boolean> inicioVidaSexualActiva;
	public static volatile SingularAttribute<AGOGinecologica, String> observaciones;
	public static volatile SingularAttribute<AGOGinecologica, String> tipoParejas;
	public static volatile SingularAttribute<AGOGinecologica, Boolean> cambiosRecientesPeriodo;
	public static volatile SingularAttribute<AGOGinecologica, Boolean> dismenorrea;
	public static volatile SingularAttribute<AGOGinecologica, String> cantidadSangrado;
	public static volatile SingularAttribute<AGOGinecologica, Integer> diasSangrado;
	public static volatile SingularAttribute<AGOGinecologica, Integer> diasEntrePeriodo;

}

