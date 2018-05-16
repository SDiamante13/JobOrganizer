package com.diamante.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Stack;

import javax.swing.JOptionPane;

import com.diamante.JobOrganizer.SQLConnection;
import com.diamante.utils.DateFormat;
import com.diamante.web.daoInterface.JobDao;
import com.diamante.web.model.Job;

	public class JobDaoImpl implements JobDao{
		public void addJob(Job newJob) {
			 Connection connection = null;
			 // Convert date to acceptable MySQL date format
			   LocalDate date = newJob.getDate();		
		        try{
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		        	connection = SQLConnection.dbConnector("jobdatabase");
		        	// create statement
		        	String query = "INSERT INTO `jobdatabase`.`jobcontacts` (`Date`, `Employer`, `Location`, `Position`, `Salary`, `Result`)"
		        			+ "values (?, ?, ?, ?, ?, ?)";
		        	PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, date.toString());
					pst.setString(2, newJob.getEmployer());
					pst.setString(3, newJob.getLocation());
					pst.setString(4, newJob.getPosition());
					pst.setString(5, newJob.getSalary());
					pst.setString(6, newJob.getResult());
					
					pst.executeUpdate();
		        }
		        catch(Exception e){
		        	System.out.println(e);
		        }
		}
		
		public Stack<Job> loadJobStack(){
		    Stack<Job> jobsStack = new Stack<>();
		    Job tempJob = null;
		    Connection conn = null;
		    // Connection
		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = SQLConnection.dbConnector("jobdatabase");
	        	// create statement
		    String query = "SELECT * FROM jobdatabase.jobcontacts";
		    PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			// load symbols into the jobs Stack
			String dateString = null;
			LocalDate locDate = null;
		    while(rs.next()){
		    	dateString = rs.getString(2);
				locDate = DateFormat.DateConverter(dateString);
		       tempJob= new Job(locDate, rs.getString(3), rs.getString(4), 
		    		   rs.getString(5), rs.getString(6), rs.getString(7));
		       tempJob.setJobNo(Integer.parseInt(rs.getString(1)));
		       jobsStack.push(tempJob);
		    }
		}
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		    return jobsStack;
}
		
		public void deleteJob(int jobNumber) {
		    Connection conn = null;
		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = SQLConnection.dbConnector("jobdatabase");
			String query = "DELETE FROM `jobdatabase`.`jobcontacts` WHERE `Job Number`= '" + jobNumber + "'  ";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			pst.close();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		public Job getJobByNumber(int jobNumber) {
			Job selectedJob = null;
		    Connection conn = null;
		    // Connection
		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = SQLConnection.dbConnector("jobdatabase");
	        	// create statement
	        	String query = "SELECT * FROM jobdatabase.jobcontacts WHERE `Job Number` = " + jobNumber;
	        	PreparedStatement pst = conn.prepareStatement(query);
	        	ResultSet rs = pst.executeQuery();
	        	String dateString = null;
	        	LocalDate locDate = null;
	        		while(rs.next()){
	        			dateString = rs.getString(2);
	        			locDate = DateFormat.DateConverter(dateString);
	        			selectedJob= new Job(locDate, rs.getString(3), rs.getString(4), 
	        					rs.getString(5), rs.getString(6), rs.getString(7));
	        			selectedJob.setJobNo(Integer.parseInt(rs.getString(1)));
	        		}
		    	}
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		    return selectedJob;
		}
		
		public void updateJob(Job jobToEdit) {
			
			//UPDATE `jobdatabase`.`jobcontacts` SET `Employer`='Taxi Com' WHERE `Job Number`='1';
			Connection connection = null;
			 // Convert date to acceptable MySQL date format
			   LocalDate date = jobToEdit.getDate();		
		        try{
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		        	connection = SQLConnection.dbConnector("jobdatabase");
		        	// create statement
		        	String query = "UPDATE `jobdatabase`.`jobcontacts` SET `Date`='" + jobToEdit.getDate() + "', `Employer`='" + jobToEdit.getEmployer()
		        	+ "', `Location`='" + jobToEdit.getLocation() + "', `Position`='" + jobToEdit.getPosition() + "', `Salary`='" + jobToEdit.getSalary()
		        	+ "', `Result`='" + jobToEdit.getResult() + "'  WHERE `Job Number` ='" + Integer.toString(jobToEdit.getJobNo()) + "'";
		        	PreparedStatement pst = connection.prepareStatement(query);
		        	int affectedRows = pst.executeUpdate();
		        }
		        catch(Exception e){
		        	System.out.println(e);
		        }
			
			
		}
		
		
		
		}