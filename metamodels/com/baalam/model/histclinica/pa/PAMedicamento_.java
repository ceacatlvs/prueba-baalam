package com.baalam.model.histclinica.pa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PAMedicamento.class)
public abstract class PAMedicamento_ {

	public static volatile SingularAttribute<PAMedicamento, Long> idPAMedicamento;
	public static volatile SingularAttribute<PAMedicamento, String> via;
	public static volatile SingularAttribute<PAMedicamento, PadecimientoActual> idConsulta;
	public static volatile SingularAttribute<PAMedicamento, String> medicamento;
	public static volatile SingularAttribute<PAMedicamento, String> frecuencia;
	public static volatile SingularAttribute<PAMedicamento, String> duracion;
	public static volatile SingularAttribute<PAMedicamento, String> dosis;

}

