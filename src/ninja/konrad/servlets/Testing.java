package ninja.konrad.servlets;

import java.util.HashMap;

import ninja.konrad.model.Car;
import ninja.konrad.model.Cars;
import ninja.konrad.model.Database;

public class Testing {

	public static void main(String[] args) {
	
		System.out.println(Database.getDatabase());
	}
	
	public static void print(String s) {
		System.out.println(s);
	}

}
