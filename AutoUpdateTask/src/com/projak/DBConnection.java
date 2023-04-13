package com.projak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class DBConnection {
	
	
	
	final Logger logger = Logger.getLogger(DBConnection.class);
	
	public Connection getConnection(String dbUrl1, String dbUsername, String dbPassword) throws IOException {
		//System.out.println("Datacap Utility");
		
		Connection connection = null;
		logger.info("Calling Database Connection");
		
		try {
			
			//Database Connection properties
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			logger.debug(Class.forName("com.ibm.db2.jcc.DB2Driver"));
			
			
			connection = DriverManager.getConnection(dbUrl1, dbUsername, dbPassword);
			
			logger.debug("URL: " + dbUrl1);
			logger.debug("Username: " + dbUsername);
			logger.debug("Connection was success - " + connection);
			
		} catch (ClassNotFoundException exe) {
			exe.printStackTrace();
			logger.error(exe);
		} catch (SQLException exe) {
			exe.printStackTrace();
			logger.error(exe);
		}
		return connection;
	}

}
