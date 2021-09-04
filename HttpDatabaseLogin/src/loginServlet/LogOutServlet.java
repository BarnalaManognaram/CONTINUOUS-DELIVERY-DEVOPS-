package loginServlet;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LogOutServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("you have logged out succesfully");
		 RequestDispatcher rd = request.getRequestDispatcher("login.html");
		 rd.include(request, response);
        Cookie ck=new Cookie("auth","un");  
        ck.setMaxAge(0);
        response.addCookie(ck); 
        
       
    }  
}  