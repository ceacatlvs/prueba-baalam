package com.baalam.model.histclinica.ant.hf;

import com.baalam.model.catalogo.CatEnfermedadesFamiliares;
import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AHFEnfFamiliares.class)
public abstract class AHFEnfFamiliares_ {

	public static volatile SingularAttribute<AHFEnfFamiliares, Paciente> paciente;
	public static volatile SingularAttribute<AHFEnfFamiliares, String> otraEnfermedad;
	public static volatile SingularAttribute<AHFEnfFamiliares, String> parentesco;
	public static volatile SingularAttribute<AHFEnfFamiliares, Long> idEnfermedad;
	public static volatile SingularAttribute<AHFEnfFamiliares, Integer> edadInicio;
	public static volatile SingularAttribute<AHFEnfFamiliares, CatEnfermedadesFamiliares> idCatEnfermedadFamiliar;
	public static volatile SingularAttribute<AHFEnfFamiliares, String> observaciones;

}

