package utils;

import java.lang.reflect.Field;

/**
 * Classe utilitaire qui fournit les services de g�n�ration/conversion de cha�ne
 * de caract�res
 * 
 * @author Emmanuel
 *
 */
public final class StringUtils {

	/**
	 * Constructor Bloqu� car classe stateless (pas d'attribut ni m�thode
	 * d'instance)
	 * 
	 */
	private StringUtils() {

	}

	/**
	 * M�thode qui convertie un objet en chaine de caract�res. <br>
	 * Cette conversion est faite sur la base de l'annotation @ToString
	 * 
	 * @param object
	 *            objet � convertir
	 * @return String
	 */
	public static String getStringValue(Object object) {

		String chaine = "";

		try {

			Field[] fields = object.getClass().getDeclaredFields();

			for (Field f : fields) {

				f.setAccessible(true);

				if (f.isAnnotationPresent(ToString.class)) {

					ToString annotation = f.getAnnotation(ToString.class);

					Object value = f.get(object);

					// Cas upperCase
					if (annotation.uppercase()) {
						value = value.toString().toUpperCase();
					}

					// Cas before
					if (!annotation.before().equals("")) {
						value += annotation.before();
					}

					// Cas after
					if (!annotation.after().equals("")) {
						value += annotation.after();
					}

					chaine += value;

				}
			}

			return chaine;

		} catch (Exception e) {
			return null;
		}

	}

}
