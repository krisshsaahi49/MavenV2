package javaPatterns.j2e.creationalDesignPattern.singletonPattern;

class Database {
	private static Database dbObject;

	private Database() {
	}

	public static Database getInstance() {

		if (dbObject == null) {
			synchronized (Database.class) {
				if (dbObject == null) {
					dbObject = new Database();// instance will be created at request time
				}
			}
		}
		// create object if it's not already created
		/*
		 * if (dbObject == null) { dbObject = new Database(); }
		 */

		// returns the singleton object
		return dbObject;
	}

	public void getConnection() {
		System.out.println("You are now connected to the database.");
	}
}