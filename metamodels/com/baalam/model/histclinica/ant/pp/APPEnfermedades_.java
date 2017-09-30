package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.catalogo.CatEnfEdoActual;
import com.baalam.model.catalogo.CatEnfermedad;
import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPEnfermedades.class)
public abstract class APPEnfermedades_ {

	public static volatile SingularAttribute<APPEnfermedades, Paciente> paciente;
	public static volatile SingularAttribute<APPEnfermedades, Date> fechaDiagnostico;
	public static volatile SingularAttribute<APPEnfermedades, String> tratamiento;
	public static volatile SingularAttribute<APPEnfermedades, CatEnfermedad> idCatEnfermedad;
	public static volatile SingularAttribute<APPEnfermedades, CatEnfEdoActual> idCatEnfEdoActual;
	public static volatile SingularAttribute<APPEnfermedades, Long> idAppEnfermedades;

}

