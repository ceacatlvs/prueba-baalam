-- You can use this file to load seed data into the database using SQL statements
-- insert into Campo (idCampo, nombre, tipo, requerido) values (0, 'prueba', 'input',1) 
-- ,(2,'test',1,'table',1),(3,'test2',1,'table',1),(4,'pafn',1,'table',1);
-- INSERT INTO campo (nombre,requerido,tipo,idTabla) VALUES ('prueba',1,'input',NULL)

INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Elija ...')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Distrito Federal')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Estado de México')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Aguascalientes')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Baja California')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Baja California Sur')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Campeche')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Coahuila')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Colima')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Chiapas')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Chihuahua')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Durango')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Guanajuato')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Guerrero')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Hidalgo')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Jalisco')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Michoacán')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Morelos')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Nayarit')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Nuevo León')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Oaxaca')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Puebla')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Querétaro')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Quintana Roo')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('San Luis Potosí')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Sinaloa')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Sonora')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Tabasco')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Tamaulipas')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Tlaxcala')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Veracruz')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Yucatán')
INSERT INTO cat_entidad_federativa (descripcion) VALUES ('Zacatecas')


INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Elija ...')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Píldora')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Inyección')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Parche')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Anillo Vaginal')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Implante')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('DIU de Cobre')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('DIU medicado')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Condón Masculino')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Condón Femenino')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Espermaticida')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Ritmo')
INSERT INTO cat_anticonceptivos (descripcion) VALUES ('Coito interrumpido')

INSERT INTO rol (descripcion,fid,antecedentes, padecimientoActual, iays, exploracionFisica, estudiosPrevios, impresionDiagnostica, auxiliaresDiagnostico, tratamiento, signosVitales, evolucionCuadroClinico, controlEmbarazo, finEmbarazo, controlPagos, agenda, datosPersonales) VALUES ('MEDICO',1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO usuario (fechaUltimoAcceso,fechaCambioPassword,fechaCreacionUsuario,password,respuestaSecreta,preguntaSecreta,username,idRol) VALUES (NULL,NULL,'2013-07-07','123',NULL,NULL,'PAFN',1);
INSERT INTO doctor(aMaterno,aPaterno,nombre,especialidad,idUsuario) VALUES ('Padilla','Padilla','Pafnuncio','Ginecología',1) 
INSERT INTO consultorio(horario, nombre, idDoctor) VALUES ('siempre', 'consultorio de pafnuncio', 1)



INSERT INTO usuario (fechaUltimoAcceso,fechaCambioPassword,fechaCreacionUsuario,password,respuestaSecreta,preguntaSecreta,username,idRol) VALUES (NULL,NULL,'2013-07-07','123',NULL,NULL,'GERMAN',1);
INSERT INTO doctor(aMaterno,aPaterno,nombre,especialidad,idUsuario) VALUES ('Monster','Monster','German','Ginecologia',2) 
INSERT INTO consultorio(horario, nombre, idDoctor) VALUES ('siempre', 'consultorio de pafnuncio', 2)



INSERT INTO rol (descripcion,fid,antecedentes, padecimientoActual, iays, exploracionFisica, estudiosPrevios, impresionDiagnostica, auxiliaresDiagnostico, tratamiento, signosVitales, evolucionCuadroClinico, controlEmbarazo, finEmbarazo, controlPagos, agenda, datosPersonales) VALUES ('ASISTENTE',1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1);
INSERT INTO usuario (fechaUltimoAcceso,fechaCambioPassword,fechaCreacionUsuario,password,respuestaSecreta,preguntaSecreta,username,idRol) VALUES (NULL,NULL,'2013-07-07','890',NULL,NULL,'TERE',2);
INSERT INTO secretaria(aMaterno,aPaterno,nombre,idUsuario) VALUES ('Cereza','Cereza','Teresa',3);

INSERT INTO usuario (fechaUltimoAcceso,fechaCambioPassword,fechaCreacionUsuario,password,respuestaSecreta,preguntaSecreta,username,idRol) VALUES (NULL,NULL,'2013-07-07','890',NULL,NULL,'MAGNE',2);
INSERT INTO secretaria(aMaterno,aPaterno,nombre,idUsuario) VALUES ('Luneta','Luneta','Magneta',4);


INSERT INTO doctor_secretaria(idDoctor, idSecreataria, fechaCreacionRelacion, doctor_idDoctor, secreataria_idSecretaria) VALUES (1,1,'2013-07-07',1,1);
INSERT INTO doctor_secretaria(idDoctor, idSecreataria, fechaCreacionRelacion, doctor_idDoctor, secreataria_idSecretaria) VALUES (2,1,'2013-07-07',2,1);

INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('Elija ...')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('O RH+')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('O RH-')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('A RH+')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('A RH-')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('B RH+')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('B RH-')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('AB RH+')
INSERT INTO cat_grupo_sanguineo (descripcion) VALUES ('AB RH-')


/*entidad federativa*/


INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Elija ...')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Diabetes')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Hipertensión')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Hiperlipidemia')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Enfermedad cardiaca')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Cáncer de mama')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Cáncer de colon')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Cáncer de ovario')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Cáncer uterino')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Defectos al nacimiento')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Enfermedad mental o depresión')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Enfermedad Alzheimer')
INSERT INTO cat_enfermedades_familiares (descripcion) VALUES ('Adicciones (alcohol, tabaco u otros)')

INSERT INTO cat_tabaquismo (descripcion) VALUES ('Elija ...')
INSERT INTO cat_tabaquismo (descripcion) VALUES ('No fumador')
INSERT INTO cat_tabaquismo (descripcion) VALUES ('Uso actual')
INSERT INTO cat_tabaquismo (descripcion) VALUES ('Historia')


INSERT INTO cat_duracion (descripcion) VALUES ('Elija ...')
INSERT INTO cat_duracion (descripcion) VALUES ('Menos de 30 minutos')
INSERT INTO cat_duracion (descripcion) VALUES ('De 30 minutos a 1 hora')
INSERT INTO cat_duracion (descripcion) VALUES ('Más de 1 hora')


INSERT INTO cat_orientacion_sexual (descripcion) VALUES ('Elija ...')
INSERT INTO cat_orientacion_sexual (descripcion) VALUES ('Heterosexual')
INSERT INTO cat_orientacion_sexual (descripcion) VALUES ('Homosexual')
INSERT INTO cat_orientacion_sexual (descripcion) VALUES ('Bisexual')


INSERT INTO cat_estado_civil (descripcion) VALUES ('Elija ...')
INSERT INTO cat_estado_civil (descripcion) VALUES ('Casada')
INSERT INTO cat_estado_civil (descripcion) VALUES ('Unión libre')
INSERT INTO cat_estado_civil (descripcion) VALUES ('Soltera')
INSERT INTO cat_estado_civil (descripcion) VALUES ('Viuda')
INSERT INTO cat_estado_civil (descripcion) VALUES ('Divorciada')


INSERT INTO cat_escolaridad (descripcion) VALUES ('Elija ...')
INSERT INTO cat_escolaridad (descripcion) VALUES ('Primaria')
INSERT INTO cat_escolaridad (descripcion) VALUES ('Secundaria')
INSERT INTO cat_escolaridad (descripcion) VALUES ('Preparatoria')
INSERT INTO cat_escolaridad (descripcion) VALUES ('Carrera técnica')
INSERT INTO cat_escolaridad (descripcion) VALUES ('Universidad')


INSERT INTO cat_enfermedad (descripcion) VALUES ('Asma')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Neumonía/Enfermedad pulmonar')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Infección renal/Cálculos')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Tuberculósis')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Enfermedad de transmisión sexual')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Problemas cardiacos')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Diabetes')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Hipertensión arterial')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Alteraciones en el apetito')
INSERT INTO cat_enfermedad (descripcion) VALUES ('VIH/SIDA')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Enfermedades autoinmunes')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Varicela')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Herpes')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Cáncer')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Reflujo/hernia hiatal/úlcera')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Depresión/ansiedad')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Anemia')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Transfusión sanguínea')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Convulsiones/epilepsia')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Problemas intestinales')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Glaucoma')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Cataratas')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Artitris/Lumbalgia')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Fracturas')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Hepatitis/Enfermedad hepática')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Enfermedad tiroidea')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Enfermedad de vías biliares')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Cefaleas')
INSERT INTO cat_enfermedad (descripcion) VALUES ('Alergias')


INSERT INTO cat_enf_edo_actual (descripcion) VALUES ('Elija ...')
INSERT INTO cat_enf_edo_actual (descripcion) VALUES ('Activa-No controlada')
INSERT INTO cat_enf_edo_actual (descripcion) VALUES ('Activa-Controlada')
INSERT INTO cat_enf_edo_actual (descripcion) VALUES ('No activa')


INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna difteria, tosferina o tétanos')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna influenza')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna hepatitis A')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna hepatitis B')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna varicela')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna neumococo')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna rubeola, sarampión o paperas')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Vacuna tuberculosis')
INSERT INTO cat_antecedentes_vacuna (descripcion) VALUES ('Otra')

INSERT INTO cat_especialidad (descripcion) VALUES ('Especialidad 1')
INSERT INTO cat_especialidad (descripcion) VALUES ('Especialidad 2')
INSERT INTO cat_especialidad (descripcion) VALUES ('Especialidad 3')

INSERT INTO cat_tipo_paciente (descripcion) VALUES ('Ginecológica')
INSERT INTO cat_tipo_paciente (descripcion) VALUES ('Obstétrica')

INSERT INTO cat_msFs (descripcion) VALUES ('Si')
INSERT INTO cat_msFs (descripcion) VALUES ('No')


INSERT INTO cat_pres (descripcion) VALUES ('Cefálico')
INSERT INTO cat_pres (descripcion) VALUES ('Pélvico')
INSERT INTO cat_pres (descripcion) VALUES ('Hombro')
INSERT INTO cat_pres (descripcion) VALUES ('Compuesta')


INSERT INTO cat_edema (descripcion) VALUES ('Positivo')
INSERT INTO cat_edema (descripcion) VALUES ('Negativo')


INSERT INTO cat_edemaX (descripcion) VALUES ('X')
INSERT INTO cat_edemaX (descripcion) VALUES ('XX')
INSERT INTO cat_edemaX (descripcion) VALUES ('XXX')


INSERT INTO cat_placenta (descripcion) VALUES ('GI')
INSERT INTO cat_placenta (descripcion) VALUES ('GII')
INSERT INTO cat_placenta (descripcion) VALUES ('GIII')


INSERT INTO cat_la (descripcion) VALUES ('Normal')
INSERT INTO cat_la (descripcion) VALUES ('Aumentado')
INSERT INTO cat_la (descripcion) VALUES ('Disminuido')


INSERT INTO cat_sexo (descripcion) VALUES ('M')
INSERT INTO cat_sexo (descripcion) VALUES ('F')

INSERT INTO cat_tipo_pago (descripcion) VALUES ('Efectivo')
INSERT INTO cat_tipo_pago (descripcion) VALUES ('Tarjeta')
INSERT INTO cat_tipo_pago (descripcion) VALUES ('Seguro')
INSERT INTO cat_tipo_pago (descripcion) VALUES ('Cheque')
INSERT INTO cat_tipo_pago (descripcion) VALUES ('Transferencia electrónica')

INSERT INTO paciente (idDoctor, fechaUltimaCita, fechaNacimiento, edad, nombrePaciente, nombreFavorito, ocupacionPaciente, recomendo, telCasa, telOficina, telefonoMovil, idEntidadFedereativa, idGrupoSanguineo, fechaCreacion) VALUES (1, '2013-08-26', '1980-08-01', 33, 'maria', 'maria', 'bailarina nocturna', 'la amiga de maria', '(55)8392-9320', '(55)3923-4932', '(55)3920-5392', 9, 1, '2013-08-24') 

INSERT INTO consulta_pa (fechaConsulta, motivoConsulta, idPaciente, idTipoPaciente, tipoConsulta) VALUES ('2013-08-24', 'motivo consulta 1', 1, 1, 'P')						
INSERT INTO consulta_tratamiento (chOtros, idConsulta) VALUES ('tratamiento 1', 1)	

INSERT INTO consulta_pa (fechaConsulta, motivoConsulta, idPaciente, idTipoPaciente, tipoConsulta) VALUES ('2013-08-25', 'motivo consulta 2', 1, 1, 'S')								
INSERT INTO consulta_tratamiento (chOtros, idConsulta) VALUES ('tratamiento 2', 2)	

INSERT INTO consulta_pa (fechaConsulta, motivoConsulta, idPaciente, idTipoPaciente, tipoConsulta) VALUES ('2013-08-26', 'motivo consulta 3', 1, 2, 'S')
INSERT INTO consulta_tratamiento (chOtros, idConsulta) VALUES ('tratamiento 3', 3)
INSERT INTO consulta_tratamiento_farmacos (dosis, frecuencia, medicamento, viaAdmon, idConsulta) VALUES ('1 pastilla', 'cada 2 horas', 'felicidad', 'oral', 3)

INSERT INTO control_embarazo_informacion (fpp, fum, idConsulta) VALUES ('2013-08-07', '2013-10-31', 3)

INSERT INTO control_pagos_cobro_consulta (cortesia, monto, notas, pendientePagar, recibo, idConsulta) VALUES (0, 800, 'nada más consulta', 0, 1, 1)
INSERT INTO control_pagos_pagos_cobro (cantidadPago, fechaPago, notas, idCPCobroConsulta, tipoPago) VALUES (800, '2013-10-07', '1 solo pago', 1, 1)

INSERT INTO control_pagos_cobro_consulta (cortesia, monto, notas, pendientePagar, recibo, idConsulta) VALUES (0, 800, 'nada más consulta', 0, 1, 2)
INSERT INTO control_pagos_pagos_cobro (cantidadPago, fechaPago, notas, idCPCobroConsulta, tipoPago) VALUES (800, '2013-10-10', '1 solo pago', 2, 1)

INSERT INTO control_pagos_cobro_consulta (cortesia, monto, notas, pendientePagar, recibo, idConsulta) VALUES (0, 800, 'nada más consulta', 400, 1, 3)
INSERT INTO control_pagos_pagos_cobro (cantidadPago, fechaPago, notas, idCPCobroConsulta, tipoPago) VALUES (400, '2013-10-11', 'pendiente de terminar de pagar', 3, 3)



INSERT INTO paciente (idDoctor, fechaUltimaCita, fechaNacimiento, edad, nombrePaciente, nombreFavorito, ocupacionPaciente, recomendo, telCasa, telOficina, telefonoMovil, idEntidadFedereativa, idGrupoSanguineo, fechaCreacion) VALUES (1, '2013-08-29', '1980-08-01', 33, 'chole', 'chole', 'bailarina nocturna', 'la amiga de maria', '(55)1111-9320', '(55)1111-4932', '(55)1111-1111', 9, 1, '2013-08-24') 

INSERT INTO consulta_pa (fechaConsulta, motivoConsulta, idPaciente, idTipoPaciente, tipoConsulta) VALUES ('2013-08-29', 'motivo consulta 1', 2, 1, 'P')						
INSERT INTO consulta_tratamiento (chOtros, idConsulta) VALUES ('tratamiento 1', 4)	

INSERT INTO control_pagos_cobro_consulta (cortesia, monto, notas, pendientePagar, recibo, idConsulta) VALUES (0, 800, 'nada más consulta', 0, 1, 4)
INSERT INTO control_pagos_pagos_cobro (cantidadPago, fechaPago, notas, idCPCobroConsulta, tipoPago) VALUES (800, '2013-11-07', '1 solo pago', 4, 4)

INSERT INTO consulta_pa (fechaConsulta, motivoConsulta, idPaciente, idTipoPaciente, tipoConsulta) VALUES ('2014-03-29', 'motivo consulta 2 subsecuente', 2, 1, 'S')						
INSERT INTO consulta_tratamiento (chOtros, idConsulta) VALUES ('tratamiento 1', 5)

INSERT INTO control_pagos_cobro_consulta (cortesia, monto, notas, pendientePagar, recibo, idConsulta) VALUES (0, 900, 'nada más consulta', 900, 0, 5)


INSERT INTO paciente (idDoctor, fechaNacimiento, edad, nombrePaciente, nombreFavorito, ocupacionPaciente, recomendo, telCasa, telOficina, telefonoMovil, idEntidadFedereativa, idGrupoSanguineo, fechaCreacion) VALUES (1, '1980-08-01', 33, 'dirty diana', 'chole', 'no se sabe', 'la amiga de maria', '(55)8392-9320', '(55)3923-4932', '(55)3920-5392', 9, 1, '2014-01-04')
INSERT INTO paciente (idDoctor, fechaNacimiento, edad, nombrePaciente, nombreFavorito, ocupacionPaciente, recomendo, telCasa, telOficina, telefonoMovil, idEntidadFedereativa, idGrupoSanguineo, fechaCreacion) VALUES (1, '1975-01-18', 41, 'e pura', 'ciel', 'no se sabe', 'no se quien recomienda', '(55)8392-9320', '(55)9023-4932', '(55)3320-5392', 9, 1, '2016-01-04')


INSERT INTO cita_agenda (fechaCitaFin, fechaCitaInicio, motivoOcupado, tipoConsulta, idPaciente, idDoctor) VALUES ('2016-03-26 13:30:00', '2016-03-26 13:00:00', '','S', '2','1');
INSERT INTO cita_agenda (fechaCitaFin, fechaCitaInicio, motivoOcupado, tipoConsulta, idPaciente, idDoctor) VALUES ('2016-03-26 14:30:00', '2016-03-26 14:00:00', '','S', '1','1');
INSERT INTO cita_agenda (fechaCitaFin, fechaCitaInicio, motivoOcupado, tipoConsulta, idPaciente, idDoctor) VALUES ('2016-03-24 12:30:00', '2016-03-24 11:30:00', '','P', '3','1');
INSERT INTO cita_agenda (fechaCitaFin, fechaCitaInicio, motivoOcupado, tipoConsulta, idPaciente, idDoctor) VALUES ('2016-03-24 13:30:00', '2016-03-24 12:30:00', '','P', '4','1');


