package net.asc.util.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
