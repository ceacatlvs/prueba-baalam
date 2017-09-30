package com.baalam.model.histclinica.ant.go;

import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AGOPartos.class)
public abstract class AGOPartos_ {

	public static volatile SingularAttribute<AGOPartos, Paciente> paciente;
	public static volatile SingularAttribute<AGOPartos, Double> pesoKg;
	public static volatile SingularAttribute<AGOPartos, Boolean> hipertension;
	public static volatile SingularAttribute<AGOPartos, String> otra;
	public static volatile SingularAttribute<AGOPartos, Boolean> depresion;
	public static volatile SingularAttribute<AGOPartos, Boolean> diabetes;
	public static volatile SingularAttribute<AGOPartos, String> sexo;
	public static volatile SingularAttribute<AGOPartos, String> observaciones;
	public static volatile SingularAttribute<AGOPartos, Date> fechaNacimiento;
	public static volatile SingularAttribute<AGOPartos, Long> idParto;
	public static volatile SingularAttribute<AGOPartos, String> nombre;
	public static volatile SingularAttribute<AGOPartos, Integer> semanasEmbarazo;
	public static volatile SingularAttribute<AGOPartos, Boolean> preclamsia;
	public static volatile SingularAttribute<AGOPartos, String> tipoNacimiento;
	public static volatile SingularAttribute<AGOPartos, String> indicacionCesarea;

}

