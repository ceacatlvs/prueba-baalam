package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPQuimicaSanguiena.class)
public abstract class EPQuimicaSanguiena_ {

	public static volatile SingularAttribute<EPQuimicaSanguiena, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Date> fechaQS;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> hdl;
	public static volatile SingularAttribute<EPQuimicaSanguiena, String> otro;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> ldl;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> glucosa;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> creatinina;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> bun;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> trigliceridos;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> colesterol;
	public static volatile SingularAttribute<EPQuimicaSanguiena, String> resultadoQS;
	public static volatile SingularAttribute<EPQuimicaSanguiena, Double> acidoUrico;

}

