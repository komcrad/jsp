package ninja.konrad.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ninja.konrad.model.Car;
import ninja.konrad.model.Cars;

public class Functions {
	
	public static String getCarTableForUser(HashMap<String, String> user) {
		int userID = Integer.parseInt(user.get("userID"));
		Car[] cars = Cars.getInventory(userID);
		String result = "<table>"
						+ "<thead>"
							+ "<tr>"
								+ "<td>Make</td><td>Model</td><td>Year</td><td>Color</td><td>Current Value</td>"
							+ "</tr>"
						+ "</thead>";
		for (int i = 0; i < cars.length;i++ ) {
			Car car = cars[i];
			result = result + "<tr>";
			result = result + "<td>" + car.getMake() + "</td>";
			result = result + "<td>" + car.getModel() + "</td>";
			result = result + "<td>" + car.getYear() + "</td>";
			result = result + "<td>" + car.getColor() + "</td>";
			result = result + "<td>" + car.getCurrentValue() + "</td>";
			result = result + "</tr>";
		}
		result = result+"</table>";
		return result;
	}
	
	public static String removeTrailingChar(String s, String charToRemove) {
		if (s.substring(s.length()-1).equals(charToRemove)) {
			return s.substring(0, s.length()-1);
		} else {
			return s;
		}
	}
	
	public static void sendMessage(String messageToSend, String messageName, String redirectString, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> message = new HashMap<String, String>();
		message.put(messageName, messageToSend);
		request.setAttribute("message", message);
		request.getRequestDispatcher(redirectString).forward(request, response);
	}
}
