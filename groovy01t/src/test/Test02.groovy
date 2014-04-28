package test

for (int i = 0; i <= 9; i++) {
	print i + ",";
}
println();
for (i in 0..9) {
	print i + ",";
}
println();
for (i in ["홍길동", "임꺽정", true, 200]) {
	print "," + i;
}
println();
for (e in ["국어":100, "수학":90, "영어":80]) {
	print "[" + e.key + ":" + e.value + "],";
}
println();
for (c in "Hello, World!") {
	print c + " ";
}

println();
// each( 클로저 ) => each 메서드는 파라미터 값으로 closure를 넘겨야 한다.
// closure? 파라미터로 주고 받을 수 있는 함수 조각. == inner function
// closure 문법: { 파라미터, 파라미터, ... -> 함수 본체 }
["홍길동","임꺽정","장길산"].each({ value -> 
	print value + ",";
});

println();
// 메서드 호출 시 괄호() 생략 가능 
["홍길동","임꺽정","장길산"].each { value -> 
	print ",";
};

println();
// closure 선언 시 파라미터 생략 가능(파라미터가 한 개일 때)
// it 히든 변수는 생략된 파라미터를 가리킴.
["홍길동","임꺽정","장길산"].each {
	print it + ",";
};

println();
// closure 선언 시 파라미타가 두 개 이상이면 생략 불가능.
["홍길동","임꺽정","장길산"].eachWithIndex { value, index ->
	print value + "(" + index + "),";
};

// JavaScript Code
/*
["홍길동","임꺽정","장길산"].each(function(value, index) {
	console.log(value, index);
});
 */
























