package com.baalam.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PacienteDetalle.class)
public abstract class PacienteDetalle_ {

	public static volatile SingularAttribute<PacienteDetalle, Long> idPaciente;
	public static volatile SingularAttribute<PacienteDetalle, String> semanasEmbarazo;
	public static volatile SingularAttribute<PacienteDetalle, Long> idDoctor;
	public static volatile SingularAttribute<PacienteDetalle, String> motivoConsulta;
	public static volatile SingularAttribute<PacienteDetalle, Long> idConsulta;
	public static volatile SingularAttribute<PacienteDetalle, String> nombrePaciente;
	public static volatile SingularAttribute<PacienteDetalle, String> tratamiento;
	public static volatile SingularAttribute<PacienteDetalle, Long> idControlEmbarazo;
	public static volatile SingularAttribute<PacienteDetalle, Date> fechaUltimaCita;

}

