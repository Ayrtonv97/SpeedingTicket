package logic;

import logic.data_Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class letterGenerator {

	
	public letterGenerator() throws IOException{
		letterWriter();
	}
	
	public void letterWriter() throws IOException{
		data_Storage getData = new data_Storage();
		
		PrintWriter print = new PrintWriter(new BufferedWriter (new FileWriter( getData.getregistration() + getData.getaddress() + ".txt")));
		
		print.println("Address: " + getData.getaddress());
		print.println("DOB: " + getData.getDOB());
		print.println("Email: " + getData.getemail());
		print.println("Type of vehicle: " + getData.getTypeOfVehicle());
		print.println("Registration: " + getData.getregistration());
		print.println("Hello " + getData.getfullName());
		print.println("You were caught traveling at " + getData.getCarSpeed());
		print.println("In a " + getData.getSpeedLimit() + " limit zone");
		print.println("You've been fined  " + getData.getfine());
		
		
		print.close();
	}
}
