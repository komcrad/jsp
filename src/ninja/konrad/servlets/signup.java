package ninja.konrad.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, String> errors;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/html/signup.jsp").include(request, response);
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		errors = new HashMap<String, String>();

		String email = request.getParameter("email");
		if (!email.contains("@")) {
			errors.put("email", "Email must have an @ sign");
		}
		
		String password = request.getParameter("password");
		if (password.length() < 8) {
			errors.put("password", "Password must be at least 8 characters.");
		} else if (!password.matches(".*\\W+.*")) {
			errors.put("password", "Password must have at least one special character.");
		}
		
		request.setAttribute("interest", getCheckGroupHashMap(request, "interests"));
		request.setAttribute("sex", getCheckGroupHashMap(request, "sex"));
		
		if (errors.isEmpty()) {
			onSuccess(response);
			File file = new File("signup.txt");
			PrintWriter fileOut;
			System.out.printf("File can be found at %s\n", file.toURI());
			if (file.exists()) {
				fileOut = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			} else {
				file.createNewFile();
				fileOut = new PrintWriter(new BufferedWriter(new FileWriter(file, true))); 
			}
			Enumeration<String>names = request.getParameterNames();
		
			String output = "";
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				output += (";"+name+":");
				String[] values = request.getParameterValues(name);
				for (int i = 0; i < values.length; i++) {
					if (values[i].trim().length() > 1) {
						output = output + values[i] + ", ";
						output = output.trim();
					}
				}
			}
			
			fileOut.println(output);
			onSuccess(response);
			fileOut.close();
		} else {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/html/signup.jsp").forward(request, response);
		}
	}

	
	public void onSuccess(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Thank you for creating an account page.");
		out.println("<a href='ServletOne'>Login</a>");
		out.flush();
		out.close();
	}
	
	/*
	 * 
	 * @param elementName  The name of a group of check boxes or radio buttons
	 * @return  Returns a hashmap containing keys that are the names of the elements in the group of inputs that were checked. 
	 * The values are just the string "checked"
	 */
	private HashMap<String, String> getCheckGroupHashMap(HttpServletRequest request, String elementName) {
		HashMap<String, String> map = new HashMap<String, String>();
		String[]  array = request.getParameterValues(elementName);
		try {
			for (String e : array) {
				if (e.length() > 1) {
					map.put(e, "checked");
				}
			}
		} catch (NullPointerException e) {
			errors.put(elementName, "Please select an element.");
			return null;
		}
		return map;
	}
	
}
