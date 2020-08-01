package logic;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class data_Storage {

	private static String speedLimit;
	private static String carSpeed;
	private static String fine;
	private static String fullName;
	private static String address;
	private static String DOB;
	private static int phoneNumber;
	private static String email;
	private static String registration;
	private static String typeOfVehicle;
	private static String insurance;
	
	public void setCarSpeed(String txtCarSpeed){
		carSpeed = txtCarSpeed;
	}
	
	public void setSpeedLimit(String txtSpeedLimit){
		speedLimit = txtSpeedLimit;
	}
	
	public void setFullName(String txtfullName){
		fullName = txtfullName;
	}
	
	public void setAddress(String txtaddress){
		address = txtaddress;
	}
	
	public void setDOB(String txtDOB){
		DOB = txtDOB;
	}
	
	public void setPhoneNumber(Integer numberCheck){
		phoneNumber = numberCheck;
	}
	
	public void setEmail(String txtemail){
		email = txtemail;
	}
	
	public void setRegistration(String txtregistration){
		registration = txtregistration;
	}
	
	public void setFine(String txtFine){
		fine = txtFine;
	}
	
	public void setTypeOfVehicle(String txtTypeOfVehicle){
		typeOfVehicle = txtTypeOfVehicle;
	}
	
	public void setInsurance(String txtInsurance){
		insurance = txtInsurance;
	}
	
	public String getCarSpeed(){
		return carSpeed;
	}	

	public String getSpeedLimit(){
		return speedLimit;
	}

	public String getfine(){
		return fine;
	}
	
	public String getfullName(){
		return fullName;
	}
	
	public String getaddress(){
		return address;
	}
	
	public String getDOB(){
		return DOB;
	}
	
	public int getphoneNumber(){
		return phoneNumber;
	}
	
	public String getemail(){
		return email;
	}
	
	public String getregistration(){
		return registration;
	}
	
	public String getTypeOfVehicle(){
		return typeOfVehicle;
	}
	public String getInsurance(){
		return insurance;
	}
}
