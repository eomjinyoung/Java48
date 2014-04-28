package sems.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 자동으로 생성할 객체에 이 애노테이션을 붙인다. 
 * - 이 애노테이션이 붙은 클래스에 대해서는 인스턴스를 생성하여
 *   ServletContext에 보관한다.(by ContextLoaderListener)
 *   
 * - beans.properties 파일에 빈 정보를 설정할 필요가 없다.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	String value() default "";
}
