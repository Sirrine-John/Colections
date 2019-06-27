package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.commons.lang3.StringUtils.rightPad;

/**
 *
 * @author sirri
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int passCount = request.getParameter("pass").length();
		String email = request.getParameter("email");
		String emailMask = "*";
		String userName = "";
		String domain = email.substring(email.lastIndexOf("@"), email.length());
		String emailOut;
		userName = email.substring(0, email.lastIndexOf("@"));
		emailOut = userName.substring(0, 1);
		emailOut = rightPad(emailOut,userName.length(),emailMask);
		
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
			out.println("Email: "+emailOut+domain+"<br>");
			out.println("Username: "+request.getParameter("uname")+"<br>");
			out.println("Password Length: "+passCount+"<br>");
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
