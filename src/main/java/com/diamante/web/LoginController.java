package com.diamante.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diamante.web.dao.LoginDaoImpl;
import com.diamante.web.daoInterface.LoginDao;
import com.diamante.web.model.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao loginDao = new LoginDaoImpl();
		HttpSession session = request.getSession();
		Login user = loginDao.validate(username, password);
		session.setAttribute("LoginDetails", user);
		if(user != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loadJobs");
			dispatcher.forward(request, response);
		}
		else {
			session.setAttribute("errMsg", "Incorrect username and/or password. Please try again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginForm.jsp");
			dispatcher.forward(request, response);
		}
	}
}
