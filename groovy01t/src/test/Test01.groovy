package test

def a = 20;
a = "Hello";
b = 3.14;

println a;
println b;

int c = 20;
//c = "Hello";
println c; 

String d = "Hello";
d = 20;
println d;

Date e = new Date();
println e;

scores = [90, 100, 80];
println scores[1];
println scores.get(1);
println scores.size();

names = ["홍길동", "임꺽정", 30];
println names[1];
println names[2];

emptylist = [];
println emptylist.getClass();
//ArrayList emptylist = new ArrayList();

scoreMap = ["국어":100, "수학":80, "영어":100];
println scoreMap["국어"];
println scoreMap.국어;
println scoreMap.getClass();

def x = 20;
if (x < 20) {
	println "미성년";
} else if (x >= 20 && x < 65) {
	println "성년";
} else {
	println "노인";
}

int y = 21;
println (((y % 2) == 0) ? "짝수" : "홀수");

def z = false;
switch (z) {
	//case "30": 	println "문자열: 30";	break;
	case 30:	println "숫자: 30"; break;
	case 50..100: println "50..100"; break;
	case [2, 5, 7, 11, true]:
		println "희한하다..."; break;
	default:
		println "그밖에...";
}

