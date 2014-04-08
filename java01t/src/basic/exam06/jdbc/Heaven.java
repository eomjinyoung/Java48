package basic.exam06.jdbc;

class HeavenKimBab implements KimBab {
  public void taste() {
	  System.out.println("우아~~ 천국의 맛이다.");
  }
}

class HeavenStore implements KimBabStore {
  public KimBab create() {
	  return new HeavenKimBab();
  }
}

class HeavenBuilder implements KimBabStoreBuilder {
  public KimBabStore build() {
  	return new HeavenStore();
  }
}
