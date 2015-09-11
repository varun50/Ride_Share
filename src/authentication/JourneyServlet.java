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
 * Servlet implementation class JourneyServlet
 */
public class JourneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JourneyServlet() {
        super();
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
			request.setAttribute("message", "");
			request.setAttribute("email", "");
			String loggedIn = (String) session.getAttribute("loggedIn");
			session.setAttribute("loggedIn", loggedIn);
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			
		} else if (action.equals("journeyplanner")) {
			request.setAttribute("dateofjourney", "");
			request.setAttribute("inidest", "");
			request.setAttribute("findest", "");
			String CustomerloggedIn = (String) session.getAttribute("CustomerloggedIn");
			if (CustomerloggedIn!= "true")
				CustomerloggedIn = "true";
			session.setAttribute("CustomerloggedIn", CustomerloggedIn);
			request.getRequestDispatcher("/JourneyPlanner.jsp").forward(request,
					response);
		}
		else if (action.equals("postjourney")) {
			request.setAttribute("name", "");
			request.setAttribute("Doj", "");
			request.setAttribute("IniDes", "");
			request.setAttribute("Stops", "");
			request.setAttribute("FinDes", "");
			request.setAttribute("seats", "");
			String DriverloggedIn = (String) session.getAttribute("DriverloggedIn");
			String driverObject = (String) session.getAttribute("driverObject");
			if (DriverloggedIn!= "true")
				DriverloggedIn = "true";
			User user = new User();
			driverObject = user.getFirstName();
			session.setAttribute("DriverloggedIn", DriverloggedIn);
			session.setAttribute("driverObject", driverObject);
			request.getRequestDispatcher("/PostJourney.jsp").forward(request,
					response);
			
		} else if (action.equals("feedback")){
			
			int returnCustomerID = (int) session.getAttribute("returnCustomerID");
			//session.setAttribute("returnCustomerID", returnCustomerID);
			try {
				AuthDAO dao = new AuthDAO();
				User user = dao.readfinaljourney(returnCustomerID);
				session.setAttribute("user", user);
				request.setAttribute("msg", "");
				request.getRequestDispatcher("/feedback.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
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

		if (action == null) {
			out.println("unrecognised action");
			return;
		}
		AuthDAO dao = new AuthDAO();
		
		if (action.equals("gotoenterstops")){
			String dname = request.getParameter("dname");
			String Doj = request.getParameter("Doj");
			String IniDes = request.getParameter("postjinidestdropdown");
			//String Stops = request.getParameter("Stops");
			String FinDes = request.getParameter("postjfindestdropdown");
			String seats = request.getParameter("seats");
			int seat=Integer.parseInt(seats);
			
			int returnDriverID = (int) session.getAttribute("returnDriverID");
			
			request.setAttribute("dname", "");
			request.setAttribute("Doj", "");
			request.setAttribute("IniDes", "");
			//request.setAttribute("Stops", "");
			request.setAttribute("FinDes", "");
			request.setAttribute("seats", "");
			request.setAttribute("enterstops", "");
			request.setAttribute("msgstops", "");

			try {
				 
				dao.createjourney(returnDriverID, dname, Doj, IniDes, FinDes, seat);
				
				
				request.getRequestDispatcher("/enterstops.jsp").forward(
						request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				request.getRequestDispatcher("/JourneyError.jsp").forward(
						request, response);
			}
			
		}
		else if (action.equals("journeydetails")) {
			String stops = request.getParameter("enterstops");
			
			int returnDriverID = (int) session.getAttribute("returnDriverID");
			
			request.setAttribute("enterstops", "");
			
			//request.setAttribute("message", "Stop has been added");

			try {
				if (stops != "" || stops != null)
				dao.entertostops(returnDriverID, stops);
				
				
				request.getRequestDispatcher("/JourneySuccess.jsp").forward(
						request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				request.getRequestDispatcher("/JourneyError.jsp").forward(
						request, response);
			}
			
		} else if (action.equals("addstops")){
			
			String stops = request.getParameter("enterstops");
			
			int returnDriverID = (int) session.getAttribute("returnDriverID");
			
			request.setAttribute("enterstops", "");
			
			request.setAttribute("msgstops", "Stop has been added");

			try {
				
				dao.entertostops(returnDriverID, stops);
				
				
				request.getRequestDispatcher("/enterstops.jsp").forward(
						request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				request.getRequestDispatcher("/JourneyError.jsp").forward(
						request, response);
			}
			
			
			
		} else if (action.equals("journeyplan")) {
			String dateofjourney = request.getParameter("dateofjourney");
			String inidest = request.getParameter("mydropdown1");
			String findest = request.getParameter("mydropdown2");
			String c = request.getParameter("customerseats");
			int seat=Integer.parseInt(c);
			int returnCustomerID = (int) session.getAttribute("returnCustomerID");

			request.setAttribute("dateofjourney", "");
			request.setAttribute("inidest", "");
			request.setAttribute("findest", "");
			
			/*String initial="auburn";
			String Final="buffalo";
			int dateofjourney=7458;*/
			
			//try {
				try {
					
					dao.createroute(returnCustomerID, dateofjourney, inidest, findest, seat);
				} catch (SQLException e) {
					System.out.println("Error creating customerjourney");
					e.printStackTrace();
				}
				if(inidest==""||findest==""||dateofjourney=="")
				{
					request.setAttribute("message", "please fill in fields");
					request.getRequestDispatcher("/JourneyPlanner.jsp").forward(request,response );
				}
				
				if(dao.fetchdriveridfromcj(inidest, findest)!=null)
				{
					int[] x=dao.fetchdriveridfromcj(inidest, findest);
					
					
					int[] bool=new int[x.length];
					String[] y=dao.getName(x);
					for(int i=0;i<x.length;i++)
					{
						bool[i]=dao.ReturnSeats(x[i], inidest, findest, seat);
						
					}
					request.setAttribute("Array1", y);
					request.setAttribute("Array2", bool);
					
					request.getRequestDispatcher("/DriverList.jsp").forward(request,response);
					
				}
				 //seat=1;
				else if(dao.fetchdriveridfromcj(inidest, findest)==null&&dao.fetchdriveridfromcj(inidest)!=null&&dao.fetchdriveridfromc(findest)==null)
				{
					
					int[] array1=dao.fetchdriveridfromcj(inidest);
					int[] array2=dao.fetchdriverfromstops(inidest,findest);
					int[] array3= new int[array1.length+array2.length];
					System.arraycopy(array1, 0, array3, 0, array1.length);
					System.arraycopy(array2, 0,array3, array1.length, array2.length);
					String[] x=dao.getName(dao.fetchdriverfromstops(inidest,findest));
					String[]y=dao.getName(dao.fetchdriveridfromcj(inidest));
					String z[]=new String[x.length+y.length];
					
					System.arraycopy(x,0,z ,0, x.length);
					System.arraycopy(y, 0, z, x.length, y.length);
					int bool[]=new int[z.length];
					for(int i=0;i<x.length;i++)
					{
						bool[i]=dao.ReturnSeats(array3[i], inidest, findest, seat);
					}
					request.setAttribute("Array1", z);
					request.setAttribute("Array2",bool );
					request.getRequestDispatcher("/DriverList.jsp").forward(request,response);
					
					
				}
				else if(dao.fetchdriveridfromcj(inidest)!=null&&dao.fetchdriveridfromc(findest)!=null&&dao.fetchdriverfromstops(inidest, findest)!=null&&dao.fetchdriveridfromcj(inidest, findest)!=null)
				{
					int x[]=dao.fetchdriverfromstops(inidest, findest);
					String[] y=dao.getName(x);
					int[] bool=new int[x.length];
					for(int i=0;i<x.length;i++)
					{
						bool[i]=dao.ReturnSeats(x[i], inidest, findest, seat);
					}
					request.setAttribute("Array1",y);
					request.setAttribute("Array2", bool);
					request.getRequestDispatcher("/DriverList.jsp").forward(request,response);
					
				}
				else if(dao.fetchdriveridfromcj(inidest, findest)==null&&dao.fetchdriveridfromc(findest)!=null&&dao.fetchdriveridfromcj(inidest)==null)
				{int[] array1=dao.fetchdriveridfromc(findest);
				int[] array2=dao.fetchdriverfromstops(inidest,findest);
				int[] array3= new int[array1.length+array2.length];
				System.arraycopy(array1, 0, array3, 0, array1.length);
				System.arraycopy(array2, 0,array3, array1.length, array2.length);
				String[] x=dao.getName(dao.fetchdriverfromstops(inidest,findest));
				String[]y=dao.getName(dao.fetchdriveridfromc(findest));
				String z[]=new String[x.length+y.length];
				
				System.arraycopy(x,0,z ,0, x.length);
				System.arraycopy(y, 0, z, x.length, y.length);
				int bool[]=new int[z.length];
				for(int a=0;a<z.length;a++)
				{
					bool[a]=dao.ReturnSeats(array3[a], inidest, findest, seat);
				}
				request.setAttribute("Array1", z);
				request.setAttribute("Array2", bool);
				request.getRequestDispatcher("/DriverList.jsp").forward(request,response);
				
				}
		}

	}

}
