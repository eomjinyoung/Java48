package spring.test05;

public class Car {
	String 		model;
	Engine			engine;
	Tire[]			tires;
	
	public Car() {}
	
	public Car(String model) {
		this.model = model;
	}
	
	public Car(String model, Engine engine) {
		this(model); // 기존의 생성자 호출. (생성자 만이 생성자 호출 가능)
		this.engine = engine;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[자동차:" + model + ",\n");
		buf.append("   " + engine.toString() + "\n");
		
		if (tires != null) {
			for (Tire t : tires) {
				buf.append("   " + t.toString() + "\n");
			}
		}
		
	  return buf.toString();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Tire[] getTires() {
		return tires;
	}

	public void setTires(Tire[] tires) {
		this.tires = tires;
	}
	
	
}























