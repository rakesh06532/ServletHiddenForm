package test;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/hid")
public class HiddenServletOne extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws IOException ,ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		UserBean ub=new UserBean();
		ub.setUname(req.getParameter("uname"));
		
		String fname=new RetrieveDAO().retrieve(ub);
		if(fname==null) {
			pw.println("Invalid user<br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
					rd.include(req, res);
		}
		else {
			pw.println("Welcome "+fname);
			pw.println("<form action='second' method='get'>");
			pw.println("fanme: <input type='text' ");
			pw.println();
			pw.println("</form>");
			
		}
	}

}
