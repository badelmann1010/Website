package PetFaceDB;
import java.sql.*;

public class UserEntry {

	static UserEntry instance = new UserEntry();
	Connection dbconn;
	ResultSet results = null;
	PreparedStatement sql;
	String dpwd = null;
	StringBuilder sb = new StringBuilder();
	
	//change URL to your database server as needed
	String dbPath="jdbc:mysql://localhost:8080";
	
	public static UserEntry getInstance() {
		if (instance==null) {
			instance = new UserEntry();
		}
		return instance;
	}
	public void closeConnection(){
		try {
			dbconn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Establish connection to MySQL server
	public Connection newConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			try {			
				dbconn = DriverManager.getConnection(dbPath,"root","");
				System.out.println("gain the connection");
				return dbconn;
			}
			catch (Exception s){
				System.out.println(s.getStackTrace().toString());}
		}
		catch (Exception err){
			System.out.println(err.getStackTrace().toString());
		}
		return null;
	}
	
	public ResultSet selectStatement( String query ) {
		try {
			System.out.println("query="+query);
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement(query);
			ResultSet results;
			results=sql.executeQuery(query);
			
			if(!results.first()){
				System.out.print("none found in db");
				
			}
			else System.out.print("found");

			return results;
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			return null;
		}
	}
	
	
	
	public boolean DBentry( String query ) {
		try {
			System.out.println("query="+query);
			instance.newConnection();
			sql=dbconn.prepareStatement(query);
			sql.executeUpdate(query);
			dbconn.close();
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}

	public boolean userlookup( String username, String userpassword, String userType) {
		String query="SELECT fName FROM Plan4."+userType+" WHERE fName ='" + username + "'" + "AND password ='" +userpassword+ "'";
		try {
			System.out.println("query="+query);
			dbconn=instance.newConnection();
			sql=dbconn.prepareStatement(query);
			ResultSet results;
			results=sql.executeQuery(query);
			
			if(!results.next()){
				System.out.print("none found in db");
				dbconn.close();
				return false;
			}
			else System.out.print("found");
			dbconn.close();
			return true;
			//WARNING!
			//Need to process ResultSet before closing connection
			
			
		}
		catch (Exception err) {
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	public boolean entry( String itemNumber, String price, String fName, String lName, String address, String cc, String ccNum ) {
		int id= (int) Math.random()*1000;
		int userId= (int) Math.random()*1000;
		try {
			instance.DBentry("INSERT INTO cs485_lab6.orders (`id`, `userID`, `itemNumber`, `price`, `fName`, `lName`, `address`, `cc`, `ccNum`) " +
								"VALUES (' " +id+ " ',' " +userId+ " ',' " +itemNumber+ " ',' " +price+ " ',' " +fName+ " ',' " +lName+ " ',' " +address+ " ',' " +cc+ " ',' " +ccNum+ " ');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	public boolean userentry( String username, String userpassword ) {
		int id= (int) Math.random()*1000;
		try {
			instance.DBentry("INSERT INTO cs485_lab6.customer (`userID`, `userName`, `userPassword`) " +
								"VALUES ('"+id+"','"+username+"','"+userpassword+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean courseEntry(String sID, String courseID, String comp) {

		try {
			instance.DBentry("INSERT INTO Plan4.Plans (`semesterID`, `CourseID`, `isComplete`) " +
								"VALUES (' " +sID+ " ',' " +courseID+ " ',' " +comp+ "');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	public boolean studentEntry( String ID, String fname, String lname, String Major, String pword) {
		try {
			instance.DBentry("INSERT INTO Plan4.Students (`StudentID`, `fName`, `lName`,`Major`,`password`) " +
								"VALUES ('"+ID+"','"+fname+"','"+lname+"','"+Major+"','"+pword+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	
	public boolean instructorEntry( String ID, String fname, String lname, String Major, String pword) {
		try {
			instance.DBentry("INSERT INTO Plan4.Instructors (`InstructorID`, `fName`, `lName`, 'Department', password) " +
								"VALUES ('"+ID+"','"+fname+"','"+lname+"','"+Major+"','"+pword+"');");	
			return true;
		}
		catch ( Exception err ) {
			err.getStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {	
		//instance.entry("Golf");
	}
}