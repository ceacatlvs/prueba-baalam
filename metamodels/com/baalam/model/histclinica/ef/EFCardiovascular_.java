package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFCardiovascular.class)
public abstract class EFCardiovascular_ {

	public static volatile SingularAttribute<EFCardiovascular, String> ruidosAgregados;
	public static volatile SingularAttribute<EFCardiovascular, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFCardiovascular, String> vascularPerif;
	public static volatile SingularAttribute<EFCardiovascular, String> ruidosCardiacos;
	public static volatile SingularAttribute<EFCardiovascular, String> observaciones;

}

