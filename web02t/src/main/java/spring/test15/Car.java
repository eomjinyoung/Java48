package spring.test15;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/* @Autowired와 @Qualifier
 * - 주입할 객체를 @Qualifier로 지정한다.
 */
public class Car {
	String 		model;
	Engine			engine;
	Tire[]			tires;
	Map<String,Object> options;
	
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
		
		if (engine != null) {
			buf.append("   " + engine.toString() + "\n");
		}
		
		if (tires != null) {
			for (Tire t : tires) {
				buf.append("   " + t.toString() + "\n");
			}
		}
		
		if (options != null) {
			for (Entry<String,Object> entry : options.entrySet()) {
				buf.append("   >" + entry.getKey() + ":" + 
										entry.getValue().toString() + "\n");
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

	@Autowired(required=false) // default 'true'
	@Qualifier("engine2")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Tire[] getTires() {
		return tires;
	}

	public void setTires(Tire[] tires) {
		this.tires = tires;
	}

	public Map<String, Object> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}
	
	
	
	
}























