package ninja.konrad.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOne() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("/html/SWICServlet.html").include(request, response);
		response.flushBuffer();
	}

	private File getRelativeFile(String fileName, String projectFolderName) {
		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		path = path.substring(0, path.indexOf(projectFolderName) + projectFolderName.length() + 1);
		return new File(path + fileName);
	}
	
}

