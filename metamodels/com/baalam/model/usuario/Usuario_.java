package com.baalam.model.usuario;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> username;
	public static volatile SingularAttribute<Usuario, Date> fechaCambioPassword;
	public static volatile SingularAttribute<Usuario, Long> idUsuario;
	public static volatile SingularAttribute<Usuario, Rol> rol;
	public static volatile SingularAttribute<Usuario, Date> fechaUltimoAcceso;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, String> respuestaSecreta;
	public static volatile SingularAttribute<Usuario, String> preguntaSecreta;

}

