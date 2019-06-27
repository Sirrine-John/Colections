package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sirri
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet MyServlet</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Request Recieved!</h1>");
			out.println("<div>");
			out.println("Email: "+request.getParameter("email")+"<br>");
			out.println("Username: "+request.getParameter("uname")+"<br>");
			out.println("Password: "+request.getParameter("pass")+"<br>");
			out.println("Gender: "+request.getParameter("gender")+"<br>");
			out.println("Registered Courses: <table>");
			for (String strTemp : request.getParameterValues("course")){
			out.println("<tr><td>--"+strTemp+"--</td></tr>");}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "This is my servlet";
	}

}
