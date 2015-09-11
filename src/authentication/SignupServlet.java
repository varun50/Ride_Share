package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.AuthDAO;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if (action == null) {
			String loggedIn = (String) session.getAttribute("loggedIn");
			session.setAttribute("loggedIn", loggedIn);
			request.setAttribute("message", "");
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			
		}else if (action.equals("createdriver")) {
			
			request.setAttribute("FirstName", "");
			request.setAttribute("LastName", "");
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", "");
			request.setAttribute("address1", "");
			request.setAttribute("address2", "");
			request.setAttribute("contactnumber", "");
			request.setAttribute("city", "");
			request.setAttribute("state", "");
			request.setAttribute("zip", "");
			request.setAttribute("licenseno", "");
			request.setAttribute("dateofissue", "");
			request.setAttribute("dateofexpiry", "");
			request.setAttribute("carmodel", "");
			request.setAttribute("cartype", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/DriverRegister.jsp").forward(
					request, response);
			
		}else if (action.equals("createcustomer")) {
			request.setAttribute("FirstName", "");
			request.setAttribute("LastName", "");
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", "");
			request.setAttribute("address1", "");
			request.setAttribute("address2", "");
			request.setAttribute("city", "");
			request.setAttribute("state", "");
			request.setAttribute("zip", "");
			request.setAttribute("contactnumber", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/CustomerRegister.jsp").forward(
					request, response);
		}  else if (action.equals("gotoupdatedriver")){
			request.setAttribute("FirstName", "");
			request.setAttribute("LastName", "");
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", "");
			request.setAttribute("address1", "");
			request.setAttribute("address2", "");
			request.setAttribute("contactnumber", "");
			request.setAttribute("city", "");
			request.setAttribute("state", "");
			request.setAttribute("zip", "");
			request.setAttribute("licenseno", "");
			request.setAttribute("dateofissue", "");
			request.setAttribute("dateofexpiry", "");
			request.setAttribute("carmodel", "");
			request.setAttribute("cartype", "");
			request.getRequestDispatcher("/DriverUpdate.jsp").forward(request, response);
			
		}
		else {
			out.println("unrecognised action");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unused")
		AuthDAO account = new AuthDAO();
		
		if (action == null) {
			out.println("unrecognised action");
			return;
		}
		else if(action.equals("checkdriver"))
		{
			
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			
			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("DOB", "");
			request.setAttribute("address1", "");
			request.setAttribute("address2", "");
			request.setAttribute("contactnumber", "");
			request.setAttribute("driverdropdown", "");
			request.setAttribute("zip", "");
			request.setAttribute("licenseno", "");
			request.setAttribute("dateofissue", "");
			request.setAttribute("dateofexpiry", "");
			request.setAttribute("carmodel", "");
			request.setAttribute("cartype", "");
			request.setAttribute("message", "");
			
			User user = new User(email);
			AuthDAO dao = new AuthDAO();
			
			if(!user.validate_email()) {
				// Validate email in the form before checking in database
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
				
			} 
			else{
			try {
				if(dao.isDriverNameAvailable(email)) {
					// This user already exists in the user database.
					
					request.setAttribute("message", "Username (Email) not Available");
					request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "Username (Email) Available");
					request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		} else if(action.equals("checkcustomer"))
		{
			
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("Email");
			
			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("DOB", "");
			request.setAttribute("address1", "");
			request.setAttribute("address2", "");
			request.setAttribute("custdropdown", "");
			request.setAttribute("zip", "");
			request.setAttribute("contactnumber", "");
			request.setAttribute("message", "");
			
			User user = new User(email);
			AuthDAO dao = new AuthDAO();
			
			if(!user.validate_email()) {
				// Validate email in the form before checking in database
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
				
			} else{
				
			try {
				if(dao.isCustomerNameAvailable(email)) {
					// This user already exists in the user database.
					
					request.setAttribute("message", "Username (Email) not Available");
					request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "Username (Email) Available");
					request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}
		else if(action.equals("createdriver")) {
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repeatpassword");
			String DOB = request.getParameter("Dob");
			String address1 = request.getParameter("Add1");
			String address2 = request.getParameter("Add2");
			String contactnumber = request.getParameter("contactnumber");
			String driverdropdown = request.getParameter("driverdropdown");
			String zip = request.getParameter("zip");
			String licenseno = request.getParameter("Lnum");
			String dateofissue = request.getParameter("Doi");
			String dateofexpiry = request.getParameter("Doe");
			String carmodel = request.getParameter("Cname");
			String cartype = request.getParameter("Ctype");

			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", DOB);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			request.setAttribute("contactnumber", contactnumber);
			request.setAttribute("driverdropdown", driverdropdown);
			request.setAttribute("zip", zip);
			request.setAttribute("licenseno", licenseno);
			request.setAttribute("dateofissue", dateofissue);
			request.setAttribute("dateofexpiry", dateofexpiry);
			request.setAttribute("carmodel", carmodel);
			request.setAttribute("cartype", cartype);
			request.setAttribute("message", "");
			
			User user = new User(FirstName, LastName, email, password, DOB, address1, contactnumber, driverdropdown, zip, licenseno, dateofexpiry, carmodel, cartype);
			AuthDAO dao = new AuthDAO();
			
			if(!user.validate_createdriver()) {
				// Validate data entered in the form
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
				
			}
			else {
				if(!password.equals(repassword)) {
					// Passwords don't match.
					request.setAttribute("message", "Passwords do not match.");
					request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
				}
				else {
					try {
						if(dao.isDriverNameAvailable(email)) {
							// This user (email) exists in the user database.
							request.setAttribute("message", "Username (Email) not Available");
							request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
						}
						else {
							// We create the Driver account.
							int returnedInt = dao.enterNewDriver(email, password);
							if(returnedInt != -1){
							// We create the Driver profile table	
							if(dao.enterDriverProfile(returnedInt, FirstName, LastName, email, password,
									DOB, address1, address2, contactnumber, driverdropdown, zip, 
									licenseno, dateofissue, dateofexpiry,
									carmodel, cartype)){
								request.setAttribute("message", "Account Created Successfully");
							request.getRequestDispatcher("/DriverSuccess.jsp").forward(request, response);
							}
							}
							else{
								request.setAttribute("message", "Sorry Account Creation Failed");
							    request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						request.setAttribute("message", "A SQLException occured");
						request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
					}
				}
				
			}
		} else if (action.equals("createcustomer")) {
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("Email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repeatpassword");
			String DOB = request.getParameter("dob");
			String address1 = request.getParameter("add1");
			String address2 = request.getParameter("add2");
			String citystate = request.getParameter("custdropdown");
			String zip = request.getParameter("zip");
			String contactnumber = request.getParameter("cnumber");
			

			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", DOB);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			//request.setAttribute("citystate", citystate);
			request.setAttribute("zip", zip);
			request.setAttribute("contactnumber", contactnumber);
			request.setAttribute("message", "");
			
			User user = new User(FirstName, LastName, email, password, DOB, address1, citystate, zip, contactnumber);
			AuthDAO dao = new AuthDAO();
			
			if(!user.validate_createcustomer()) {
				// Validate data entered in the form
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
				
			}
			else {
				if(!password.equals(repassword)) {
					// Passwords don't match.
					request.setAttribute("message", "Passwords do not match.");
					request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
				}
				else {
					try {
						if(dao.isCustomerNameAvailable(email)) {
							// This user (email) exists in the user database.
							request.setAttribute("message", "Username (Email) not Available");
							request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
						}
						else {
							// We create the Customer table.
							int returnedInt = dao.enterNewCustomer(email, password);
							if(returnedInt != -1){
							// We create the Customer profile table	
							if(dao.enterCustomerProfile(returnedInt, FirstName, LastName, email, password,
									DOB, address1, address2, citystate, zip, contactnumber)){
								request.setAttribute("message", "Account Created Successfully");
							request.getRequestDispatcher("/CustomerSuccess.jsp").forward(request, response);
							}
							}
							else{
								request.setAttribute("message", "Sorry Account Creation Failed");
							    request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						request.setAttribute("message", "A SQLException occured");
						request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
					}
				}
				
			}
			
		} else if (action.equals("updatedriver")){
			
			int DriverID = (int) session.getAttribute("returnDriverID");
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repeatpassword");
			String DOB = request.getParameter("Dob");
			String address1 = request.getParameter("Add1");
			String address2 = request.getParameter("Add2");
			String contactnumber = request.getParameter("contactnumber");
			String citystate = request.getParameter("citystate");
			String zip = request.getParameter("zip");
			String licenseno = request.getParameter("Lnum");
			String dateofissue = request.getParameter("Doi");
			String dateofexpiry = request.getParameter("Doe");
			String carmodel = request.getParameter("Cname");
			String cartype = request.getParameter("Ctype");

			request.setAttribute("FirstName", "");
			request.setAttribute("LastName", "");
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", "");
			request.setAttribute("address1", "");
			request.setAttribute("address2", "");
			request.setAttribute("contactnumber", "");
			request.setAttribute("citystate", "");
			request.setAttribute("zip", "");
			request.setAttribute("licenseno", "");
			request.setAttribute("dateofissue", "");
			request.setAttribute("dateofexpiry", "");
			request.setAttribute("carmodel", "");
			request.setAttribute("cartype", "");
			request.setAttribute("message", "");
			
			//session.setAttribute("returnCustomerID", returnCustomerID);
			try {
				AuthDAO dao = new AuthDAO();
				dao.updateDriver(DriverID, FirstName, LastName, email, password, DOB, address1, address2, 
						contactnumber, citystate, zip, licenseno, dateofissue, dateofexpiry, carmodel, cartype);
				
				String DriverloggedIn = (String) session.getAttribute("DriverloggedIn");
				if (DriverloggedIn!= "true")
					DriverloggedIn = "true";
				session.setAttribute("DriverloggedIn", DriverloggedIn);
				
				request.setAttribute("message", "Your Profile has been Updated");
				request.getRequestDispatcher("/PostJourney.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if (action.equals("updatecustomer")){
			
			
		}
		
		try {
			AuthDAO dao = new AuthDAO();
			dao.DB_Close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
