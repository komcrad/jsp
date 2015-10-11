package ninja.konrad.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Database {
	private static HashMap<String, HashMap<String, String>> database = parseUsers();
	
	private Database() {}
	
	public static HashMap<String, String> getUser(String email) {
		if(parseUsers() != database) {
			Database.database = parseUsers();
		}
		return database.get(email);
	}
	
	public static String getUserProperty(String email, String userProperty) {
		return getUser(email).get(userProperty);
	}
	
	public static HashMap<String, HashMap<String, String>> getDatabase() {
		return database;
	}
	
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
