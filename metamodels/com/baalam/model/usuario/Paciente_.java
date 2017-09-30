package com.baalam.model.usuario;

import com.baalam.model.agenda.CitaAgenda;
import com.baalam.model.catalogo.CatEntidadFederativa;
import com.baalam.model.catalogo.CatGrupoSanguineo;
import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, CatEntidadFederativa> entidadFedereativa;
	public static volatile SingularAttribute<Paciente, String> telOficina;
	public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
	public static volatile SingularAttribute<Paciente, String> colonia;
	public static volatile SingularAttribute<Paciente, String> recomendo;
	public static volatile SingularAttribute<Paciente, String> telContactoMovil;
	public static volatile SingularAttribute<Paciente, Doctor> doctor;
	public static volatile SingularAttribute<Paciente, String> ocupacionEsposo;
	public static volatile SingularAttribute<Paciente, Integer> edad;
	public static volatile SingularAttribute<Paciente, Date> fechaCreacion;
	public static volatile SingularAttribute<Paciente, String> contactoEmergencia;
	public static volatile SingularAttribute<Paciente, Date> fechaUltimaCita;
	public static volatile SingularAttribute<Paciente, String> telContactoCasa;
	public static volatile SingularAttribute<Paciente, Long> idPaciente;
	public static volatile SetAttribute<Paciente, PadecimientoActual> consultas;
	public static volatile SingularAttribute<Paciente, String> parentescoContacto;
	public static volatile SingularAttribute<Paciente, String> domicilio;
	public static volatile SingularAttribute<Paciente, CatGrupoSanguineo> idGrupoSanguineo;
	public static volatile SingularAttribute<Paciente, String> ocupacionPaciente;
	public static volatile SingularAttribute<Paciente, String> nombreFavorito;
	public static volatile SingularAttribute<Paciente, String> cp;
	public static volatile SingularAttribute<Paciente, String> nombrePaciente;
	public static volatile SingularAttribute<Paciente, String> nombreEsposo;
	public static volatile SingularAttribute<Paciente, String> telCasa;
	public static volatile SingularAttribute<Paciente, String> telContactoOficina;
	public static volatile SetAttribute<Paciente, CitaAgenda> citas;
	public static volatile SingularAttribute<Paciente, String> correo;
	public static volatile SingularAttribute<Paciente, String> telefonoMovil;
	public static volatile SingularAttribute<Paciente, String> delegacion;

}

