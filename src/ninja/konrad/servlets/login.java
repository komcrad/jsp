package ninja.konrad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import ninja.konrad.model.Car;
import ninja.konrad.model.Cars;
import ninja.konrad.model.Database;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (Database.getUser(email) != null) {
			HashMap<String, String> user = Database.getUser(email);
			//user.put("cars", Functions.getCarTableForUser(user));
			HashMap<String, Car[]> cars =  new HashMap<String, Car[]>();
			cars.put("cars", Cars.getInventory(Integer.parseInt(Database.getUser(email).get("userID"))));
			if (user.get("password").equals(password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("UserInfo", user);
				session.setAttribute("Cars", cars);
				session.setMaxInactiveInterval(60* 5);
				request.getRequestDispatcher("/UserInfo").forward(request, response);
			} else {
				Functions.sendMessage("Sorry, '"+password+"' is not the correct password for '"+email+"'.", 
										"generic", 
										"/html/SWICServlet.jsp", 
										request, response);
			}
		} else {
			HashMap message = new HashMap();
			message.put("header", "Sorry, '"+email+"' does not exist.");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/html/signup.jsp").forward(request, response);
		}
		
		response.flushBuffer();
		out.close();
	}
}
