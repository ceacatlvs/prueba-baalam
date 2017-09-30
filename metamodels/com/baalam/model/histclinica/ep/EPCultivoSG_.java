package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPCultivoSG.class)
public abstract class EPCultivoSG_ {

	public static volatile SingularAttribute<EPCultivoSG, String> resultadoUrocultivo;
	public static volatile SingularAttribute<EPCultivoSG, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPCultivoSG, String> antibiograma;
	public static volatile SingularAttribute<EPCultivoSG, Date> fechaUrocultivo;
	public static volatile SingularAttribute<EPCultivoSG, String> microorganismo;

}

