// 4단계: 공용함수 공유
// - prototype : 공유자원 보관소
// - 사용: 생성자함수.prototype
function Calculator() {
	this.sum = 0;
	this.note = '';
}

Calculator.prototype.plus = function(value) {
	this.sum += value;
	this.note += ' + ' + value;
};
Calculator.prototype.minus = function(value) {
	this.sum -= value;
	this.note += ' - ' + value;
};
Calculator.prototype.multiple = function(value) {
	this.sum *= value;
	this.note += ' * ' + value;
};
Calculator.prototype.divide = function(value) {
	this.sum /= value;
	this.note += ' / ' + value;
};
Calculator.prototype.init = function(value) {
	if (arguments.length == 0) {
		this.sum = 0;
		this.note = '';
	} else {
		this.sum = value;
		this.note = String(value);
	}
};
Calculator.prototype.printResult = function() {
	console.log(this.note + ' = ' + this.sum);
};














