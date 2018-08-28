package PetFace;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PetFaceDB.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String user=request.getParameter("user");
    	String pass=request.getParameter("password");
    	String userType= request.getParameter("userType");
    	

    	if (user!= null&&!user.trim().equals("")&&userType.trim().equals("Students")){
    		UserEntry userLogin =new UserEntry();
    		
    		boolean flag=userLogin.userlookup(user, pass, userType);
    		if(flag) {
    			ResultSet r=userLogin.selectStatement("SELECT Major FROM Plan4.Students WHERE fName = '"+user+"'");
    			ResultSet userID=userLogin.selectStatement("SELECT StudentID FROM Plan4.Students WHERE fName = '"+user+"'");
    			String studentID="";
    		}
    	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
