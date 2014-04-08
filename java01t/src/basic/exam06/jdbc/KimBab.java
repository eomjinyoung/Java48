package basic.exam06.jdbc;

interface KimBabStoreBuilder {
	KimBabStore build();
}

interface KimBabStore {
	KimBab create();
}

interface KimBab {
	void taste();
}
