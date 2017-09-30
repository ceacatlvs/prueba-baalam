package com.baalam.util;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ValidadorCollectors {

	public static boolean validar(Object objeto, ArrayList<String> camposIgnorar) {
		Field[] campos = objeto.getClass().getDeclaredFields();
		camposIgnorar.add("serialVersionUID");
		try {
			for (Field campo : campos) {
				boolean ignorar = false;
				for (String campoIgnorar : camposIgnorar) {
					if (campo.getName().equalsIgnoreCase(campoIgnorar)) {
						ignorar = true;
					}
				}
				if (!ignorar) {
					campo.setAccessible(true);
					Class<?> campoClass = campo.getType();
					if (campoClass.getName().equals("java.lang.Integer")) {
						if (campo.get(objeto) != null
								&& ((Integer) campo.get(objeto)).intValue() != 0) {
							System.out.println(campo.getName() + " "
									+ campo.get(objeto));
							return false;
						}
					} else if (campoClass.getName().equals("java.lang.Double")) {
						if (campo.get(objeto) != null
								&& ((Double) campo.get(objeto))
										.compareTo(new Double("0")) != 0) {
							System.out.println(campo.getName() + " "
									+ campo.get(objeto));
							return false;
						}
					} else if (campoClass.getName().equals("java.lang.Boolean")) {
						if (campo.get(objeto) != null
								&& ((Boolean) campo.get(objeto)).booleanValue()) {
							System.out.println(campo.getName() + " "
									+ campo.get(objeto));
							return false;
						}
					} else if (campoClass.getName().equals("java.lang.Long")) {
						if (campo.get(objeto) != null
								&& ((Long) campo.get(objeto)).intValue() != 0) {
							System.out.println(campo.getName() + " "
									+ campo.get(objeto));
							return false;
						}
					} else if (campoClass.getName().equals("java.lang.String")) {
						if (campo.get(objeto) != null
								&& !campo.get(objeto).toString().trim()
										.equals("")) {
							System.out.println(campo.getName() + " "
									+ campo.get(objeto));
							return false;
						}
					} else if (campo.get(objeto) != null) {
						System.out.println(campo.getName() + " "
								+ campo.get(objeto));
						return false;
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return true;
	}

}
