package com.baalam.model.controlEmbarazo;

import com.baalam.model.catalogo.CatEdema;
import com.baalam.model.catalogo.CatEdemaX;
import com.baalam.model.catalogo.CatMsFs;
import com.baalam.model.catalogo.CatPres;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CeSeguimiento.class)
public abstract class CeSeguimiento_ {

	public static volatile SingularAttribute<CeSeguimiento, CatEdemaX> edemaX;
	public static volatile SingularAttribute<CeSeguimiento, Integer> lcf;
	public static volatile SingularAttribute<CeSeguimiento, CatPres> pres;
	public static volatile SingularAttribute<CeSeguimiento, Long> idCESeguimiento;
	public static volatile SingularAttribute<CeSeguimiento, CatMsFs> msfs;
	public static volatile SingularAttribute<CeSeguimiento, Integer> peso;
	public static volatile SingularAttribute<CeSeguimiento, Integer> eg;
	public static volatile SingularAttribute<CeSeguimiento, Date> fechaConsulta;
	public static volatile SingularAttribute<CeSeguimiento, ControlEmbarazo> controlEmbarazo;
	public static volatile SingularAttribute<CeSeguimiento, CatEdema> edema;
	public static volatile SingularAttribute<CeSeguimiento, Integer> pest;
	public static volatile SingularAttribute<CeSeguimiento, Integer> ta;
	public static volatile SingularAttribute<CeSeguimiento, Integer> dpf;

}

