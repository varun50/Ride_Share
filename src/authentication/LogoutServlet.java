package authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		if(action.equals("driverlogout")){
			String logout = "You have Logged Out successfully";
			HttpSession session = request.getSession();
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			String DriverloggedIn = null;
			String CustomerloggedIn = null;
			session.setAttribute("DriverloggedIn", DriverloggedIn);
			session.setAttribute("CustomerloggedIn", CustomerloggedIn);
			request.setAttribute("logout", logout);
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
				
		if(action.equals("driverlogout")){
		
		String logout = "You have Logged Out successfully";
		HttpSession session = request.getSession();
		request.setAttribute("email", "");
		request.setAttribute("password", "");
		request.setAttribute("message", "");
		String DriverloggedIn = null;
		session.setAttribute("DriverloggedIn", DriverloggedIn);
		session.setAttribute("logout", logout);
		request.getRequestDispatcher("/DriverLogin.jsp").forward(request, response);
		
	} else if(action.equals("customerlogout")){
		
		String logout = "You have Logged Out successfully";
		HttpSession session = request.getSession();
		request.setAttribute("email", "");
		request.setAttribute("password", "");
		request.setAttribute("message", "");
		String CustomerloggedIn = null;
		session.setAttribute("CustomerloggedIn", CustomerloggedIn);
		session.setAttribute("logout", logout);
		request.getRequestDispatcher("/CustomerLogin.jsp").forward(request, response);
	}
}

}
