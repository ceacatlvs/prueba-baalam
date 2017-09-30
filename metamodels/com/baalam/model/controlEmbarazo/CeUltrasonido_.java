package com.baalam.model.controlEmbarazo;

import com.baalam.model.catalogo.CatLA;
import com.baalam.model.catalogo.CatPlacenta;
import com.baalam.model.catalogo.CatSexo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CeUltrasonido.class)
public abstract class CeUltrasonido_ {

	public static volatile SingularAttribute<CeUltrasonido, Integer> tn;
	public static volatile SingularAttribute<CeUltrasonido, Integer> hum;
	public static volatile SingularAttribute<CeUltrasonido, Integer> ca;
	public static volatile SingularAttribute<CeUltrasonido, Date> fechaUltrasonido;
	public static volatile SingularAttribute<CeUltrasonido, Integer> iracm;
	public static volatile SingularAttribute<CeUltrasonido, Long> idCEUltrasonido;
	public static volatile SingularAttribute<CeUltrasonido, CatSexo> idSexo;
	public static volatile SingularAttribute<CeUltrasonido, Integer> irumb;
	public static volatile SingularAttribute<CeUltrasonido, CatPlacenta> idPlacenta;
	public static volatile SingularAttribute<CeUltrasonido, Integer> peso;
	public static volatile SingularAttribute<CeUltrasonido, Integer> eg;
	public static volatile SingularAttribute<CeUltrasonido, ControlEmbarazo> controlEmbarazo;
	public static volatile SingularAttribute<CeUltrasonido, String> otros;
	public static volatile SingularAttribute<CeUltrasonido, Integer> lf;
	public static volatile SingularAttribute<CeUltrasonido, Integer> dbp;
	public static volatile SingularAttribute<CeUltrasonido, Integer> irut;
	public static volatile SingularAttribute<CeUltrasonido, Integer> crl;
	public static volatile SingularAttribute<CeUltrasonido, CatLA> idLA;

}

