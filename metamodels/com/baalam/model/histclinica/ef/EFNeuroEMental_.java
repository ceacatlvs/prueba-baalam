package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFNeuroEMental.class)
public abstract class EFNeuroEMental_ {

	public static volatile SingularAttribute<EFNeuroEMental, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> conductaOtro;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> orientacionPersona;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> orientacionTiempo;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> conductaDeprimido;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> orientacionEspacio;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> orientacionComentarios;
	public static volatile SingularAttribute<EFNeuroEMental, String> observaciones;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> conductaAnsioso;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> conductaNormal;
	public static volatile SingularAttribute<EFNeuroEMental, Boolean> conductaAgitado;

}

