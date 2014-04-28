package test

// 일반 메서드 호출
p = new Test04();
p.hello("홍길동");

// 객체의 프로퍼티 값 설정
p2 = new Test04(
	name:"홍길동", 
	age:20, 
	birthDate:new Date());

println p2.name + "," + p2.age + "," + p2.birthDate;

// 메서드 호출 시 맵 파라미터 전달
p3 = new Test04();
// 명시적으로 맵 객체를 만들어 파라미터로 전달할 때는
// 괄호 생략 불가!
p3.test(["aaa":"오호라", "bbb":200]);

// 암시적으로 맵 객체를 파라미터로 전달할 때는
// 괄호 생략 가능!
p3.test "aaa":"오호라", "bbb":200;





