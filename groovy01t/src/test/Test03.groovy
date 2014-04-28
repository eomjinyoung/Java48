package test
// 메서드의 마지막 실행 결과가 자동 리턴된다.
def plus(a, b) {
	println "더합니다.";
	a + b;
}

int plus2(int a, int b) {
	return a + b;
}

println plus(20, 30);
println plus2(20, 30);

minus = { a, b ->
	println "뺀다...";
	a - b;
}
minus2 = {int a, int b ->
	a - b;
}
// 자바스클립트의 arguments 처럼 사용하고 싶다면,
// 배열 파라미터를 넘겨야 한다.
minus3 = {
	it[0] - it[1];
}
println minus(10, 20);
println minus2(10, 20);
println minus3([10, 20]);
//println minus3 [10, 20]; // 괄호 생략 오류!








