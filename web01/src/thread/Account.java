package thread;

public class Account {
	long balance;
	
	public Account(int money) {
		this.balance = money;
	}
	
	// * 스레드 안전(Thread Safe)
	// 스레드가 동시에 접근해도 전혀 상관없다.
	public long getBalance() {
		return this.balance;
	}
	// * Critical Section
	// - 동시에 여러 스레드가 실행해서는 안되는 구간(명령어 블럭)
	// - 동시에 접근에 변수를 사용할 때 문제 발생
	// - 해결책: 동시에 접근하지 못하게 만든다.
	// * synchronized 
	// - 하나의 스레드가 크리티컬 섹션에 접근하면 즉시 잠근다.(locking)
	// - "뮤텍스": 한 번에 하나의 스레드만 진입허가.
	// 
	// * 세마포어: 지정된 개수 만큼 진입 허용.
	// - 크리티컬 섹션에 지정된 개수의 스레드가 들어가게 허용.
	synchronized public void withdraw(int money) throws Exception {
		long currMoney = this.balance;
		
		currMoney = currMoney - money;
		
		// 실행 속도를 가상으로 변경
		// Math.random() : 0 =< x < 1
		double s = 3.1459 * 34.56;
		for (int i = 0; i < (int) s; i++) {
			double x = 3.1459 * Math.random();
			double x2 = 3.1459 * Math.random();
			double x3 = 3.1459 * Math.random();
			double x4 = 3.1459 * Math.random();
		}
		
		if (currMoney >= 0) {
			this.balance = currMoney;
		} else {
			throw new Exception("잔액부족!");
		}
	}
}














