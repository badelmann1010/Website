package PetFace;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String user=request.getParameter("username");
    	String pass=request.getParameter("password");
    	System.out.println("going in here: " + user + " password: " + pass);
    	//String userType= request.getParameter("userType");

    	if (user!= null && !user.trim().equals("") /*&& userType.trim().equals("Students")*/){
    		UserEntry userLogin =new UserEntry();
    		
    		boolean IsUserInDB=userLogin.userlookup(user, pass);
    		if(IsUserInDB) {
    			//ResultSet r=userLogin.selectStatement("SELECT Major FROM Plan4.Students WHERE Username = '"+user+"'");
    			//ResultSet userID=userLogin.selectStatement("SELECT StudentID FROM Plan4.Students WHERE fName = '"+user+"'");
    			//String studentID="";
    		} else {
    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
    			requestDispatcher.forward(request,response);
    	    	ScriptEngineManager manager = new ScriptEngineManager();
    	    	ScriptEngine engine = manager.getEngineByName("JavaScript");
    	    	Invocable inv = (Invocable) engine;
    	    	
    	    	try 	{
    	        	engine.eval(new FileReader("../../WebContent/petface.js"));
      	    	  	Object result;
      	    	  	result = inv.invokeFunction("JavaLogin","");
      	    	  	System.out.println(result);
    	        }
    	    	catch (FileNotFoundException | NoSuchMethodException | ScriptException e) {
    	        	e.printStackTrace();
    	        }

    		}
    	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("going in here");
		doGet(request, response);
	}

}
