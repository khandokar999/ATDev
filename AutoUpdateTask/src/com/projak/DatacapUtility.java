package com.projak;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DatacapUtility {

	public static void main(String[] args) throws IOException {

		
		
		PropertyConfigurator.configure("‪‪C://datacap2//log4j.properties");
		final Logger logger = Logger.getLogger(DatacapUtility.class);
		Properties prop = new Properties();
		
		//‪C:\Datacap_Utility\application.properties
		logger.info("Reading the properties file");
		FileInputStream ip = new FileInputStream("‪‪‪C://datacap2//application.properties");
		prop.load(ip);

		String dburl1 = prop.getProperty("dbUrl1");
		String dburl2 = prop.getProperty("dbUrl2");

		String username = prop.getProperty("dbUsername");
		String password = prop.getProperty("dbPassword");

		String username1 = prop.getProperty("dbUsername1");
		String password1 = prop.getProperty("dbPassword1");
	
		String dbQuery = prop.getProperty("dbQuery");
		String dbQuery1 = prop.getProperty("dbQuery1");
		String dbQuery2 = prop.getProperty("dbQuery2");


		try {
			
			//1.Creating connection of DB
			logger.debug("Creating connection of Database1 - LICENGDB");
			DBConnection dbConnection = new DBConnection();
			
			Connection db1connection = null;
			Statement db1stmt = null;
			
			ResultSet db1rs = null;
			db1connection = dbConnection.getConnection(dburl1, username, password);
			
			logger.debug("Creating a Statement of Database1 - LICENGDB");
			db1stmt = db1connection.createStatement();
			
			
			logger.info("================================================================");
			
			//2.Creating connection of DB2
			logger.debug("Creating connection of Database2 - LICEXP");
			Connection db2connection = null;
			Statement db2stmt = null;
		
			db2connection = dbConnection.getConnection(dburl2,username1, password1);

			logger.debug("Creating statement of Database2 - LICEXP");
			db2stmt = db2connection.createStatement();
		
			

			//3. Execute Query on DB1 - Select
			logger.info("Execute Select Query on Database1 - LICENGDB ");
			logger.debug(dbQuery);
			//System.out.println(dbQuery1);
			db1rs = db1stmt.executeQuery(dbQuery);
		
			while (db1rs.next()) {
				logger.info("entering while loop");
				db2stmt.addBatch(dbQuery2 +db1rs.getString("QU_BATCH"));
				logger.debug(dbQuery2 +db1rs.getString("QU_BATCH"));
				
			}

			
			//4.Execute Update Query on DB2-Update
			logger.info("Execute Update Query on Database2 - LICEXP");
			try {
				logger.debug(db2stmt.executeBatch());
			}
			catch (SQLException e) {
			    while(e!= null) {
			      logger.error(e);
			      e = e.getNextException();
			    }
			}
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				logger.error(e);
			}

			
			logger.info("+++++++++++++++++++++++++++++++++++++++++++++++");

			
			logger.info("Close all Connection of DATABASE1 - LICENGDB");
			db1rs.close();
			db1stmt.close();
			db1connection.close();
			
			

            logger.info("Closing all Connection");
			
			db2stmt.close();
			db2connection.close();
		} // try closed
		catch (Exception e) {
			//e.printStackTrace();
			logger.error(e);
		}
		

	}

}
