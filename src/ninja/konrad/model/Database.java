package ninja.konrad.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Database {
	static private String username = "jspuser";
	static private String password = "2mgpwutm";
	static private String dbURL = "jdbc:mysql://www.konradtallman.com:3306";
	static private Statement queryExecutor = null;
	private Database() {}
	
	
	
	public static Statement getConnection() {
		Statement statement = null; 
		try {
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        return null;
		    }
			try {
				Connection conn = DriverManager.getConnection(dbURL, username, password);
				statement = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			if (queryExecutor == null) {
				queryExecutor = statement;
			}
			return statement;
	}
	
	public static HashMap<String, String> getUserByEmail(String email) {
		getConnection();
		String sql = "SELECT * FROM cis288.User where Email = '"+email+"'";
		try {
			ResultSet response = queryExecutor.executeQuery(sql);
			
			return makeUserHashMap(response);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static HashMap<String, String> makeUserHashMap(ResultSet response) throws SQLException {
		HashMap<String, String> hm = new HashMap<String, String>();
		String[] fields = {"UserID", "Email", "FirstName",
				"LastName", "StreetAddress", "BldgApt","City","Zip","Password",
				"Sex","Interests"};
		response.next();
		for (String e : fields) {
			hm.put(e, response.getString(e));
		}
		return hm;
	}
	
	public static String getUserProperty(String email, String userProperty) {
		return getUserByEmail(email).get(userProperty);
	}
	
	public static HashMap<String, HashMap<String, String>> getDatabase() {
		return null;
	}
	
	//marked for deletion
	public static HashMap<String, HashMap<String, String>> parseUsers() {
		HashMap<String, HashMap<String, String>> users = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> user;
		try {
			Scanner in = new Scanner(new File("signup.txt"));
			int userID=1;
			while (in.hasNextLine()) {
				user = new HashMap<String, String>();
				String[] temp = null;
				String userLine = in.nextLine();
				userLine = ";userID:"+userID+",;"+userLine;
				String[] userLineArray = userLine.split(";");
				for (String e : userLineArray) {
					temp = e.split(":");
					if (temp.length > 1) {
						user.put(temp[0], removeTrailingChar(temp[1], ","));
					} else {
						user.put(temp[0], "");
					}
				}
				users.put(user.get("email"), user);
				userID++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static String removeTrailingChar(String s, String charToRemove) {
		if (s.substring(s.length()-1).equals(charToRemove)) {
			return s.substring(0, s.length()-1);
		} else {
			return s;
		}
	}
}
