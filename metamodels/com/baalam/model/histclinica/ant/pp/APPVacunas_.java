package com.baalam.model.histclinica.ant.pp;

import com.baalam.model.catalogo.CatAntecedentesVacunas;
import com.baalam.model.usuario.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(APPVacunas.class)
public abstract class APPVacunas_ {

	public static volatile SingularAttribute<APPVacunas, Paciente> paciente;
	public static volatile SingularAttribute<APPVacunas, Long> idAppVacunas;
	public static volatile SingularAttribute<APPVacunas, Date> fecha;
	public static volatile SingularAttribute<APPVacunas, CatAntecedentesVacunas> idCatAntVacunas;
	public static volatile SingularAttribute<APPVacunas, String> observaciones;

}

