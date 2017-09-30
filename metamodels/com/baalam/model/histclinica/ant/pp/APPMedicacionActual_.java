package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPMedicacionActual.class)
public abstract class APPMedicacionActual_ {

	public static volatile SingularAttribute<APPMedicacionActual, Paciente> paciente;
	public static volatile SingularAttribute<APPMedicacionActual, Long> idAppMedicacion;
	public static volatile SingularAttribute<APPMedicacionActual, String> medicamento;
	public static volatile SingularAttribute<APPMedicacionActual, String> preescribio;
	public static volatile SingularAttribute<APPMedicacionActual, String> dosis;

}

