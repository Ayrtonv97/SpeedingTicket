package logic;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class Calculation {

	public Calculation(){

	}

	public String fineCalculation(String txtCarSpeed, String txtSpeedLimit){

		int speedLimit = 0;
		int carSpeed = 0;
		String fine = null;
		
		try{
			speedLimit = Integer.parseInt(txtSpeedLimit);
			carSpeed = Integer.parseInt(txtCarSpeed);
		} catch(NumberFormatException ex){
			fine = "error";
			return fine;
		} 

		if (carSpeed <= speedLimit){
			fine = ("error");
		}
		else if (carSpeed <= speedLimit + 5){
			fine = ("�50");
		}
		else if (carSpeed <= speedLimit + 10){
			fine = ("�100");
		}
		else if (carSpeed <= speedLimit + 15){
			fine = ("�150");
		}
		else if (carSpeed <= speedLimit  + 20){
			fine = ("Disqaulified and Fined �1000");
		}
		return fine;
	}
}
