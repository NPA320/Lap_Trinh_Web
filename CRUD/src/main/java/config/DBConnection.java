package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
public Connection getConnection()throws Exception {
	String url =
			"jdbc:sqlserver://" + serverName + "\\" + instance + ":" +
			portNumber + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;

 if(instance == null || instance.trim().isEmpty())
	 url =
		"jdbc:sqlserver://"+serverName+":"+portNumber
		+";encrypt=true;trustServerCertificate=true;databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 return DriverManager.getConnection(url, userID, password);
 }
 private final String serverName = "PhucAn\\ANDATA";
 private final String dbName = "ServletCRUDMVC";
 private final String portNumber = "1433";
 private final String instance="";
private final String userID = "sa";
private final String password = "123456";
}