/* CROSS 조인: n x m */
select * 
from SE_USERS T1, SE_STUDS T2;

/* NATURAL 조인 : 특정 조건이 일치하는 데이터만 조인 */
select * 
from SE_USERS T1, SE_STUDS T2
where T1.UNO = T2.UNO;

/* JOIN ~USING : 표준 문법 
조인하려는 컬럼 이름이 같을 경우 사용*/
select * 
from SE_USERS T1 join SE_STUDS T2
using (UNO);

/* JOIN ~ ON : 조인하려는 컬럼 이름이 다를 경우 */
select * 
from SE_USERS T1 join SE_STUDS T2
on T1.UNO = T2.UNO;

/* LEFT OUTER JOIN: 왼쪽을 기준을 조인한다. 
왼편 테이블의 데이터는 모두 출력
*/
select T1.UNO, T1.NAME, T1.TEL, T2.COMP, T2.POS, T2.STAT 
from SE_USERS T1 left outer join SE_STUDS T2
on T1.UNO = T2.UNO;

/* RIGHT OUTER JOIN: 오른쪽을 기준을 조인한다. 
오른편 테이블의 데이터는 모두 출력한다.
*/
select T1.UNO, T1.NAME, T1.TEL, T2.COMP, T2.POS, T2.STAT 
from SE_USERS T1 right outer join SE_STUDS T2
on T1.UNO = T2.UNO;