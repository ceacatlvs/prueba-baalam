package com.baalam.model.histclinica.id;

import com.baalam.model.catalogo.CatEspecialidad;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ImpresionDiagnostica.class)
public abstract class ImpresionDiagnostica_ {

	public static volatile SingularAttribute<ImpresionDiagnostica, CatEspecialidad> catEspecialidad;
	public static volatile SingularAttribute<ImpresionDiagnostica, Boolean> planInformacion;
	public static volatile SingularAttribute<ImpresionDiagnostica, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<ImpresionDiagnostica, String> planNotas;
	public static volatile SingularAttribute<ImpresionDiagnostica, Boolean> planTratQuirurgico;
	public static volatile SingularAttribute<ImpresionDiagnostica, Date> proximaVisita;
	public static volatile SingularAttribute<ImpresionDiagnostica, Boolean> planTratMedico;
	public static volatile SingularAttribute<ImpresionDiagnostica, Boolean> interconsulta;

}

