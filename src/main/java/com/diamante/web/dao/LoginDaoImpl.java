package com.diamante.web.dao;
import java.sql.*;

import com.diamante.JobOrganizer.SQLConnection;
import com.diamante.web.daoInterface.LoginDao;
import com.diamante.web.model.Login;


public class LoginDaoImpl implements LoginDao{
		public Login validate(String username, String password) {
			 Connection connection = null;
			 Login existingUser = null;
		        try{
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		        	connection = SQLConnection.dbConnector("jobdatabase");
		        	// create statement
		        	String query = "select * from joblogins where Username=? and Password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, username);
					pst.setString(2, password);
					ResultSet rs = pst.executeQuery();
		        	// Process the result set
		        	if(rs.next()) {
		        		existingUser = new Login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		        	}
		        }
		        catch(Exception e){
		        	System.out.println(e);
		        }
		        return existingUser;
		}

	}

