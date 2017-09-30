package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.catalogo.CatEnfEdoActual;
import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPOtrasEnfermedades.class)
public abstract class APPOtrasEnfermedades_ {

	public static volatile SingularAttribute<APPOtrasEnfermedades, String> nombre;
	public static volatile SingularAttribute<APPOtrasEnfermedades, Paciente> paciente;
	public static volatile SingularAttribute<APPOtrasEnfermedades, Date> fechaDiagnostico;
	public static volatile SingularAttribute<APPOtrasEnfermedades, String> tratamiento;
	public static volatile SingularAttribute<APPOtrasEnfermedades, CatEnfEdoActual> idCatEnfEdoActual;
	public static volatile SingularAttribute<APPOtrasEnfermedades, Long> idAppOtrasEnfermedades;

}

