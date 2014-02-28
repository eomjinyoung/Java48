// 2단계: sum, 관련 함수들을 객체로 묶는다.
// - sum을 개별로 관리할 수 있다.
// - 자기 소속된 객체의 변수를 사용할 때는 this 를 붙인다.
// - this는 메서드가 소속된 객체를 가리킴.
function makeCalculator() {
	var calculator = new Object();
	calculator.sum = 0;
	calculator.note = '';
	calculator.plus = function(value) {
		this.sum += value;
		this.note += ' + ' + value;
	};
	calculator.minus = function(value) {
		this.sum -= value;
		this.note += ' - ' + value;
	};
	calculator.multiple = function(value) {
		this.sum *= value;
		this.note += ' * ' + value;
	};
	calculator.divide = function(value) {
		this.sum /= value;
		this.note += ' / ' + value;
	};
	calculator.init = function(value) {
		if (arguments.length == 0) {
			this.sum = 0;
			this.note = '';
		} else {
			this.sum = value;
			this.note = String(value);
		}
	};
	calculator.printResult = function() {
		console.log(this.note + ' = ' + this.sum);
	};
	
	return calculator;
}













