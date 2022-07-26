package net.asc.util.db;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
	
	// JDBC driver name and database URL
	  static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	  static final String DB_URL = "jdbc:sqlserver://sql1.asc.local:1433;DatabaseName=posnet";

	  //  Database credentials
	  static final String USER = "";
	  static final String PASS = "";
	 
	  Connection conn = null;
	 
	  public DBConnect() {
	  // Register JDBC driver
	  try {
	  Class.forName(JDBC_DRIVER);
	  } catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	  }
	  }
	 
	 
	  public Connection getConnection() throws SQLException
	  {
	  if (conn == null) {
	  conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  }
	  return conn;
	  }

	  public void close() throws SQLException {
	  if (conn != null) {
	  conn.commit();
	  conn.close();
	  }
	  conn = null;
	  }

}

public StubhubConnector() {

	File configFile = new File("C:\\JavaApps\\stubhub.properties");

	FileReader reader;

	try {

		reader = new FileReader(configFile);

		Properties props = new Properties();

		props.load(reader);

		String userName = props.getProperty("username");

		String password = props.getProperty("password");

		String token = props.getProperty("token");

		String guid = props.getProperty("guid");

	} catch (IOException e) {

		System.out.println("ERROR CANNOT LOAD STUBHUB ACCOUNT CONFIG");

		System.exit(0);

	}



}
