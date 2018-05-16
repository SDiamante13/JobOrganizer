package com.diamante.web;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diamante.web.dao.JobDaoImpl;
import com.diamante.web.daoInterface.JobDao;
import com.diamante.web.model.Job;

/**
 * Servlet implementation class DeleteJobController
 */

// TO DO Create Edit Jobs Controller 
// TO DO make delete job revertable. If user deletes job display button which allows them to replace it. 

public class DeleteJobController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		JobDao jobDao = new JobDaoImpl();
		Stack<Job> jobContacts = (Stack<Job>) session.getAttribute("jobs");		
		if(jobContacts.isEmpty()) {
			session.setAttribute("errMsgEmpty", "There are no jobs to delete");
			response.sendRedirect("JobPortal.jsp");
		}
		else {
			jobDao.deleteJob(jobContacts.size());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loadJobs");
			dispatcher.forward(request, response);
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
