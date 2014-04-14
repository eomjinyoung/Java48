package episode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* Annotation
 * - 컴파일러와 자바 런타임(JVM)이 사용할 특별한 주석 
 * - 컴파일이나 실행 시에 참조할 클래스에 대한 부가 정보를 설정하는 문법  
 * - 애노테이션으로 설정된 정보는 컴파일 시 추출하거나 실행 시에 추출할 수 있음.
 * - 문법: 인터페이스 선언하는 방법과 유사!
 * 
 * RetensionPolicy
 * - 애노테이션 정보 유지 정책
 * - 언제까지 애노테이션 정보를 유지할 것인가?
 * - SOURCE : 컴파일 후 사라짐. 바이트코드(.class)에 없다.
 * - CLASS(기본): 컴파일 후 바이트코드에 남아 있음. 
 * 						실행 시에는 추출 불가! => 클래스 로딩할 때 함께 로딩되지 않음. 
 * - RUNTIME: 컴파일 후 바이트코드에 남아 있음. 
 * 						실행 시에 추출 가능! => 클래스 로딩할 때 애노테이션 정보도 함께 로딩됨.
 */

@Retention(value=RetentionPolicy.RUNTIME)
public @interface ClassInfo {
	String		value(); // 클래스 설명
	String[] author() default "";  // 값을 꺼내고 넣을 수 있는 프로퍼티
	String 	createdDate() default "";
	int				version() default 1; // 값을 설정하지 않으면 기본 값 1
}












