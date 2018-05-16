package com.diamante.JobOrganizer;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	
	static Connection myConn = null;
	public static Connection dbConnector(String databaseName) {
		try {
			String url = "jdbc:mysql://localhost:3306/" + databaseName + "?user=admin&password=E>J9glKEdq&autoReconnect=true&useSSL=false";
        	myConn = DriverManager.getConnection(url);
			return myConn;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	

}
