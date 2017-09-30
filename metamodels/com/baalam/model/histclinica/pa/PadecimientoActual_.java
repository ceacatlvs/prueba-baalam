package com.baalam.model.histclinica.pa;

import com.baalam.model.catalogo.CatTipoPaciente;
import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PadecimientoActual.class)
public abstract class PadecimientoActual_ {

	public static volatile SingularAttribute<PadecimientoActual, String> resultados;
	public static volatile SingularAttribute<PadecimientoActual, Paciente> paciente;
	public static volatile SingularAttribute<PadecimientoActual, String> motivoConsulta;
	public static volatile SingularAttribute<PadecimientoActual, CatTipoPaciente> tipoPaciente;
	public static volatile SingularAttribute<PadecimientoActual, Boolean> cuidadosGenerales;
	public static volatile SingularAttribute<PadecimientoActual, String> tipoConsulta;
	public static volatile SingularAttribute<PadecimientoActual, Boolean> medicamentos;
	public static volatile SingularAttribute<PadecimientoActual, Boolean> tratamientoAlternativo;
	public static volatile SingularAttribute<PadecimientoActual, Boolean> cirugia;
	public static volatile SingularAttribute<PadecimientoActual, String> sintomas;
	public static volatile SingularAttribute<PadecimientoActual, Date> fechaConsulta;
	public static volatile SingularAttribute<PadecimientoActual, Long> idConsulta;
	public static volatile SingularAttribute<PadecimientoActual, String> evolucion;
	public static volatile SingularAttribute<PadecimientoActual, String> estadoActual;
	public static volatile SingularAttribute<PadecimientoActual, Date> fechaInicio;

}

