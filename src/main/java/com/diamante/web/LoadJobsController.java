package com.diamante.web;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diamante.web.dao.JobDaoImpl;
import com.diamante.web.daoInterface.JobDao;
import com.diamante.web.model.Job;

/**
 * Servlet implementation class LoadJobsController
 */


public class LoadJobsController extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(com.diamante.web.LoadJobsController.class.getName());
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		JobDao jobDao = new JobDaoImpl();
		Stack <Job>jobList = new Stack<>();
		jobList = jobDao.loadJobStack();
		session.setAttribute("jobs", jobList);
		session.setAttribute("jobLength", jobList.size());
		log.info("Jobs stack loaded and session attribute jobs set");
		response.sendRedirect("JobPortal.jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

}
