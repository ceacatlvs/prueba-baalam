package com.baalam.model.histclinica.ant.go;

import com.baalam.model.catalogo.CatAnticonceptivos;
import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AGOAnticonceptivos.class)
public abstract class AGOAnticonceptivos_ {

	public static volatile SingularAttribute<AGOAnticonceptivos, CatAnticonceptivos> idCatAnticonceptivos;
	public static volatile SingularAttribute<AGOAnticonceptivos, Long> idAgoAnticonceptivos;
	public static volatile SingularAttribute<AGOAnticonceptivos, Paciente> paciente;
	public static volatile SingularAttribute<AGOAnticonceptivos, String> metodoAnticonceptivo;
	public static volatile SingularAttribute<AGOAnticonceptivos, Integer> anosUso;
	public static volatile SingularAttribute<AGOAnticonceptivos, String> observaciones;
	public static volatile SingularAttribute<AGOAnticonceptivos, Integer> mesesUso;
	public static volatile SingularAttribute<AGOAnticonceptivos, String> actualPrevio;

}

