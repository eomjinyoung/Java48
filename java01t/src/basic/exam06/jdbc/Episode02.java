package basic.exam06.jdbc;

public class Episode02 {

	public static void main(String[] args) {
		KimBabStoreBuilder b1 = new HeavenBuilder();
		KimBabStore s1 = b1.build();
		KimBab k1 = s1.create();
		
		k1.taste();

	}

}



























