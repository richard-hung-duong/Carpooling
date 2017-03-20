package mum.edu.carpooling.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.edu.carpooling.domain.User;

/**
 * Servlet implementation class WeatherController
 */
@WebServlet("/WeatherController")
public class WeatherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user == null){
			user = new User();
			user.setZipCode("52557");
			user.setCity("Fairfield");
			user.setState("ia");
			session.setAttribute("user", user);	
		} else {
			user.setZipCode("52557");
			user.setCity("Fairfield");
			user.setState("ia");
		}	
		forward(request, response, "weather.jsp");
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String pageName)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(pageName);
		dispatch.forward(request, response);
	}
}
