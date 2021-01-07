package com.example.dao;

public class MyConnectionFactory {
	public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_URL") + "/" + "reinbursementDB";
	public static String username = System.getenv("TRAINING_DB_USERNAME");
	public static String password = System.getenv("TRAINING_DB_PASSWORD");

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			MyLoggerFactory.logger.error("An error occured", e);
			// e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}
}