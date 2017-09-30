package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFInspeccionGral.class)
public abstract class EFInspeccionGral_ {

	public static volatile SingularAttribute<EFInspeccionGral, Boolean> bienNutrido;
	public static volatile SingularAttribute<EFInspeccionGral, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFInspeccionGral, Boolean> bienDesarrollado;
	public static volatile SingularAttribute<EFInspeccionGral, Boolean> bienAseado;
	public static volatile SingularAttribute<EFInspeccionGral, Boolean> habitoNormal;
	public static volatile SingularAttribute<EFInspeccionGral, Boolean> obeso;
	public static volatile SingularAttribute<EFInspeccionGral, String> observaciones;
	public static volatile SingularAttribute<EFInspeccionGral, Boolean> deformidades;

}

