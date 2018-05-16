package com.diamante.web;

import java.io.IOException;
import java.time.LocalDate;

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
 * Servlet implementation class EditJobController
 */
public class EditJobController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int jobNo = (int) session.getAttribute("editJobNo");
		String dateStr = request.getParameter("date");
	    LocalDate date = DateFormat.DateConverterAdd(dateStr);
		String employer = request.getParameter("employer");
		String location = request.getParameter("location");
		String position = request.getParameter("position");
		String salary = request.getParameter("salary");
		String result = request.getParameter("result");
		
		JobDao jobDao = new JobDaoImpl();
		Job editedJob = new Job(date, employer, location, position, salary, result);
		editedJob.setJobNo(jobNo);
		// replace old data with new data in database
		jobDao.updateJob(editedJob);
		RequestDispatcher rd = request.getRequestDispatcher("/loadJobs");
		rd.forward(request, response);
	}

}
