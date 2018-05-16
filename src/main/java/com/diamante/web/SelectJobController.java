package com.diamante.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diamante.utils.DateFormat;
import com.diamante.web.dao.JobDaoImpl;
import com.diamante.web.daoInterface.JobDao;
import com.diamante.web.model.Job;

/**
 * Servlet implementation class SelectJobController
 */
public class SelectJobController extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(com.diamante.web.LoadJobsController.class.getName());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		JobDao jobDao = new JobDaoImpl();
		int jobNumber = Integer.parseInt(request.getParameter("jobNumber"));
		Job selectedJob = jobDao.getJobByNumber(jobNumber);
		session.setAttribute("editedJob", selectedJob);
		session.setAttribute("editJobNo", selectedJob.getJobNo());
		log.info("Selected job to be edited: " + selectedJob.getJobNo() + "-- " + selectedJob.getEmployer());
		response.sendRedirect("EditJob.jsp");
	}
}
