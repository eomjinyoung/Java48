package basic.exam06.jdbc;

class KimGaNeKimBab implements KimBab {
  public void taste() {
	  System.out.println("우아~~ 맛있다. 특히 시금치. 세탁기로 탈수한 시금치");
  }
}

class KimGaNeStore implements KimBabStore {
  public KimBab create() {
	  return new KimGaNeKimBab();
  }
}

class KimGaNeBuilder implements KimBabStoreBuilder {
  public KimBabStore build() {
  	return new KimGaNeStore();
  }
}
