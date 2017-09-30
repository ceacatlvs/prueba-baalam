package com.baalam.util;

import java.util.Calendar;
import java.util.Date;

public class Utilidades {
	
	public int calcularEdad(Date fnac){
		int edad = 0;
		if (fnac!=null){
			Calendar hoy = Calendar.getInstance();
			Calendar fechaNacimiento = Calendar.getInstance();
			fechaNacimiento.setTime(fnac);
			if (fechaNacimiento.after(hoy)) {
				throw new IllegalArgumentException("La fecha es invalida");
			}
			edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
			if ((fechaNacimiento.get(Calendar.DAY_OF_YEAR) - hoy.get(Calendar.DAY_OF_YEAR) > 3) ||
					(fechaNacimiento.get(Calendar.MONTH) > hoy.get(Calendar.MONTH ))){
				edad--;
			}else if ((fechaNacimiento.get(Calendar.MONTH) == hoy.get(Calendar.MONTH )) &&
					(fechaNacimiento.get(Calendar.DAY_OF_MONTH) > hoy.get(Calendar.DAY_OF_MONTH ))){
				edad--;
			}
		}		
		return edad;
	}
}
