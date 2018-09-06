package PetFace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPathConstants;

import PetFaceDB.UserEntry;

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

    	if (user!= null && pass !=null /*!user.trim().equals("") && userType.trim().equals("Students")*/){
    		UserEntry userLogin =new UserEntry();

    		boolean IsUserInDB=userLogin.userlookup(user, pass);
    		if(IsUserInDB) {
    			System.out.println("it's working " + IsUserInDB);
    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginPage.jsp");
    			requestDispatcher.forward(request,response);
    			//ResultSet r=userLogin.selectStatement("SELECT Major FROM Plan4.Students WHERE Username = '"+user+"'");
    			//ResultSet userID=userLogin.selectStatement("SELECT StudentID FROM Plan4.Students WHERE fName = '"+user+"'");
    			//String studentID="";
    		} else {

    	    	
    	    	try 	{

    	    		/*get the path from where it is running
    	    		String test = new File(".").getAbsolutePath();
    	    		System.out.println(test);*/
        	    	
    	    		ScriptEngineManager manager = new ScriptEngineManager();
        	    	ScriptEngine engine = manager.getEngineByName("nashorn"); //or JavaScript
        	    	Invocable inv = (Invocable) engine;
        	    	
        	    	//windows file path: ../../Users/badelmann/Documents/GitHub/PetFace/WebContent/petface.js
        	    	//mac file path: ../../../../../Documents/workspace/PetFace/WebContent/petface.js
    	    		engine.eval(new FileReader("../../Users/badelmann/Documents/GitHub/PetFace/WebContent/petface.js"));
    	    		//inv.invokeFunction("JavaLogin","");
    	    		System.out.println(engine.eval(new FileReader("../../Users/badelmann/Documents/GitHub/PetFace/WebContent/petface.js")));
      	    	  	Object result = inv.invokeFunction("login","");
      	    	  	System.out.println("result" + result);
    	        }
    	    	catch (FileNotFoundException | NoSuchMethodException | ScriptException e) {
    	        	e.printStackTrace();
    	        }
    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
    			requestDispatcher.forward(request,response);
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
