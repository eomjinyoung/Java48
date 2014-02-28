// 계산기 관련 코드
var sum = 0;
var note = '';
function plus(value) {
	sum += value;
	note += ' + ' + value;
}
function minus(value) {
	sum -= value;
	note += ' - ' + value;
}
function multiple(value) {
	sum *= value;
	note += ' * ' + value;
}
function divide(value) {
	sum /= value;
	note += ' / ' + value;
}
function init(value) {
	if (arguments.length == 0) {
		sum = 0;
		note = '';
	} else {
		sum = value;
		note = String(value);
	}
}
function printResult() {
	console.log(note + ' = ' + sum);
}












