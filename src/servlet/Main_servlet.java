package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CateringDao;
import model.User;

/**
 * Servlet implementation class Main_servlet
 */
@WebServlet("/Main_servlet")
public class Main_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
	}

	
	public void registration(HttpServletRequest request, HttpServletResponse response){
		try {
			System.out.println("inside dopost");
			String firstname =request.getParameter("first_name");
			String lastname =request.getParameter("last_name");
			String password =request.getParameter("user_password");
			String occupation =request.getParameter("occupation");
			String event_types =request.getParameter("events");	
			String confirmpsw =request.getParameter("confirm_password");
			String email =request.getParameter("email");
			String contact =request.getParameter("contact_no");
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(occupation);
			System.out.println(event_types);
			System.out.println(password);
			System.out.println(confirmpsw);
			System.out.println(email);
			System.out.println(contact);
			
			User u=new User();
			u.setFname(firstname);
			u.setLname(lastname);
			u.setPsw(password);
			
			
			CateringDao dao=new CateringDao();
			boolean isInserted =dao.registration(u);
			if (isInserted) {
				response.getWriter().append("inserted successfully");
			}
			else {
				response.getWriter().append("error in insertion");
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
