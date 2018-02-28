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

	/** Annotation pour ins�rer un caract�re avant */
	String before() default "";
	
	/** Annotation pour ins�rer un caract�re apr�s */
	String after() default "";
	
	/** Annotation pour mettre en majuscule ou non */
	boolean uppercase() default false;
	
}
