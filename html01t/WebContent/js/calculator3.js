// 3단계: 생성자 함수
function Calculator() {
	this.sum = 0;
	this.note = '';
	this.plus = function(value) {
		this.sum += value;
		this.note += ' + ' + value;
	};
	this.minus = function(value) {
		this.sum -= value;
		this.note += ' - ' + value;
	};
	this.multiple = function(value) {
		this.sum *= value;
		this.note += ' * ' + value;
	};
	this.divide = function(value) {
		this.sum /= value;
		this.note += ' / ' + value;
	};
	this.init = function(value) {
		if (arguments.length == 0) {
			this.sum = 0;
			this.note = '';
		} else {
			this.sum = value;
			this.note = String(value);
		}
	};
	this.printResult = function() {
		console.log(this.note + ' = ' + this.sum);
	};
}













