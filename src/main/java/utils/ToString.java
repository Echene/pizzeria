package utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Emmanuel
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToString {

	/** Annotation pour insérer un caractère avant */
	String before() default "";
	
	/** Annotation pour insérer un caractère après */
	String after() default "";
	
	/** Annotation pour mettre en majuscule ou non */
	boolean uppercase() default false;
	
}
