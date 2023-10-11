package simpleStore;

import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	
static boolean Login(String usr, String pword) {
	String userData = "credentials.json";
	
	JSONParser parser = new JSONParser();
	
	try (FileReader reader = new FileReader(userData)) {
		Object obj = parser.parse(reader);
		
		JSONObject data = (JSONObject) obj;
		
		String xname = (String) data.get("name");
		String xpass = (String) data.get("password");
		
		if (usr.equals(xname) && pword.equals(xpass)) {
			return true;
		} else {
			return false;
		}
		
	} catch (IOException | ParseException e) {	
		System.out.println(e);
		e.printStackTrace();
		return false;
	}
	
		
	};

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		
		System.out.println("Welcome to the Store.");
		
		System.out.print("Username: ");
		String uName = input.nextLine();
		
		System.out.print("Password: ");
		String pswd = input.nextLine();
		input.close();
		
		boolean auth = Login(uName, pswd);
		
		if (auth) {
			System.out.println("Welcome " + uName);
		} else {
			System.out.println("User: " + uName + " Not found.");
		}
		
		
	};
	
	

}
