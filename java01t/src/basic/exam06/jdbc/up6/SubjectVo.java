package basic.exam06.jdbc.up6;

/* DTO(Data Transfer Object) = VO(Value Object)
 * - 데이터를 담는 그릇 역할.
 * - layer 간의 데이터 교환 시 사용됨.
 * - 테이블 <-> VO
 * - 테이블A + 테이블B + ... <-> VO
 */
public class SubjectVo {
	int 				no;				// DB 컬럼과 연결. 컬럼명 사용하지 말것. 일반 용어 사용.
	String 		title;   // 다른 프로젝트에서 재사용할 때 제약이 없다.
	String 		description;
	
}
