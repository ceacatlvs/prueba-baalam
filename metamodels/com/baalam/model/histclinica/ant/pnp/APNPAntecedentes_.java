package com.baalam.model.histclinica.ant.pnp;

import com.baalam.model.catalogo.CatEscolaridad;
import com.baalam.model.catalogo.CatEstadoCivil;
import com.baalam.model.catalogo.CatOrientacionSexual;
import com.baalam.model.catalogo.CatTabaquismo;
import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APNPAntecedentes.class)
public abstract class APNPAntecedentes_ {

	public static volatile SingularAttribute<APNPAntecedentes, CatTabaquismo> idCatTabaquismo;
	public static volatile SingularAttribute<APNPAntecedentes, Paciente> paciente;
	public static volatile SingularAttribute<APNPAntecedentes, String> cigarrosDiarios;
	public static volatile SingularAttribute<APNPAntecedentes, Boolean> cafeinaRefrescos;
	public static volatile SingularAttribute<APNPAntecedentes, String> ejercicioTipo;
	public static volatile SingularAttribute<APNPAntecedentes, String> vivenConPaciente;
	public static volatile SingularAttribute<APNPAntecedentes, String> cafeinaRefrescosTipo;
	public static volatile SingularAttribute<APNPAntecedentes, String> observaciones;
	public static volatile SingularAttribute<APNPAntecedentes, String> ejercicioFrecuencia;
	public static volatile SingularAttribute<APNPAntecedentes, String> alcoholFrecuencia;
	public static volatile SingularAttribute<APNPAntecedentes, String> lugarOrigen;
	public static volatile SingularAttribute<APNPAntecedentes, Integer> cigarrosAnios;
	public static volatile SingularAttribute<APNPAntecedentes, String> drogaTipo;
	public static volatile SingularAttribute<APNPAntecedentes, String> ejercicioDuracion;
	public static volatile SingularAttribute<APNPAntecedentes, CatOrientacionSexual> idCatOrientacionSexual;
	public static volatile SingularAttribute<APNPAntecedentes, String> lacteosCalcioCantidad;
	public static volatile SingularAttribute<APNPAntecedentes, Boolean> ejercicioRegular;
	public static volatile SingularAttribute<APNPAntecedentes, CatEscolaridad> idCatEscolaridad;
	public static volatile SingularAttribute<APNPAntecedentes, Boolean> lacteosCalcio;
	public static volatile SingularAttribute<APNPAntecedentes, Integer> cigarrosAniosSinFumar;
	public static volatile SingularAttribute<APNPAntecedentes, CatEstadoCivil> idCatEstadoCivil;
	public static volatile SingularAttribute<APNPAntecedentes, String> lacteosCalcioFrecuencia;
	public static volatile SingularAttribute<APNPAntecedentes, String> empleo;
	public static volatile SingularAttribute<APNPAntecedentes, String> cafeinaRefrescosFrecuencia;
	public static volatile SingularAttribute<APNPAntecedentes, String> cafeinaRefrescosCantidad;
	public static volatile SingularAttribute<APNPAntecedentes, Boolean> alcohol;
	public static volatile SingularAttribute<APNPAntecedentes, String> drogaFrecuencia;
	public static volatile SingularAttribute<APNPAntecedentes, String> alcoholCantidad;
	public static volatile SingularAttribute<APNPAntecedentes, Boolean> drogasRecreativas;

}

