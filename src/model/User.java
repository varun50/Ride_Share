package model;

public class User {
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private String DOB = "";
	private String address1 = "";
	private String citystate = "";
	private String zip = "";
	private String licenseno = "";
	private String dateofexpiry = "";
	private String carmodel = "";
	private String cartype = "";
	private String contactnumber = "";
	
	private int driverID;
	private int customerId;
	private String dname = "";
	private String dateofjourney = "";
	private String inidest = "";
	private String findest = "";
	private int noofstops;
	private int noofseats;
	
	private boolean loggedIn = false;
	private String message = "";

	public User() {
		
	}
	
	public User(String email){
		this.email = email;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String email, String password, String DOB, String address1, String contactnumber,
			String citystate, String zip, String licenseno, String dateofexpiry, String carmodel, String cartype) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.DOB = DOB;
		this.address1 = address1;
		this.contactnumber = contactnumber;
		this.citystate = citystate;
		this.zip = zip;
		this.licenseno = licenseno;
		this.dateofexpiry = dateofexpiry;
		this.carmodel = carmodel;
		this.cartype = cartype;
		
	}
	
	public User(String firstName, String lastName, String email, String password, String DOB, String address1, String citystate,
			String zip, String contactnumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.DOB = DOB;
		this.address1 = address1;
		this.citystate = citystate;
		this.zip = zip;
		this.contactnumber = contactnumber;
		
	}
	
	
	
	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDateofjourney() {
		return dateofjourney;
	}

	public void setDateofjourney(String dateofjourney) {
		this.dateofjourney = dateofjourney;
	}

	public String getInidest() {
		return inidest;
	}

	public void setInidest(String inidest) {
		this.inidest = inidest;
	}

	public String getFindest() {
		return findest;
	}

	public void setFindest(String findest) {
		this.findest = findest;
	}

	public int getNoofstops() {
		return noofstops;
	}

	public void setNoofstops(int noofstops) {
		this.noofstops = noofstops;
	}

	public int getNoofseats() {
		return noofseats;
	}

	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCitystate() {
		return citystate;
	}

	public void setCitystate(String citystate) {
		this.citystate = citystate;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public String getDateofexpiry() {
		return dateofexpiry;
	}

	public void setDateofexpiry(String dateofexpiry) {
		this.dateofexpiry = dateofexpiry;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getMessage() {
		return message;
	}
	
	
public boolean validate_email() {
		
		if(email == "") {
			message = "Please enter your email address";
			return false;
		}
		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address";
			return false;
		}
		return true;
}
	
	public boolean validate_login() {
		
		if(email == "") {
			message = "Please enter your email address";
			return false;
		}
		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address";
			return false;
		}
		
		if(password == "") {
			message = "Please enter your password";
			return false;
		}
		
		if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot contain space.";
			return false;
		}
		
		return true;
	}
	
	public boolean validate_createdriver(){
		
		if(firstName == "") {
			message = "First Name cannot be left Blank";
			return false;
		}
		
		if(lastName == "") {
			message = "Last Name cannot be left Blank";
			return false;
		}
		if(email == "") {
			message = "Email cannot be left Blank";
			return false;
		}
		
		if(password == "") {
			message = "Password cannot be left Blank";
			return false;
		}
		
		if(DOB == "") {
			message = "DOB cannot be left Blank";
			return false;
		}
		
		if(address1 == "") {
			message = "Address Line 1 cannot be left Blank";
			return false;
		}
		
		if(citystate == "") {
			message = "City/State cannot be left Blank";
			return false;
		}
		
		if(zip == "") {
			message = "Zip cannot be left Blank";
			return false;
		}
		
		if(licenseno == "") {
			message = "License number cannot be left Blank";
			return false;
		}
		
		if(dateofexpiry == "") {
			message = "License Data of Expiry cannot be left Blank";
			return false;
		}
		
		if(carmodel == "") {
			message = "Car name cannot be left Blank";
			return false;
		}
		
		if(cartype == "") {
			message = "Car type cannot be left Blank";
			return false;
		}
		
		if(contactnumber == "") {
			message = "Contact number cannot be left Blank";
			return false;
		}
		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address";
			return false;
		}
		
		if(password.length() < 8) {
			message = "Password must be at least 8 characters.";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot contain space.";
			return false;
		}
		return true;
		
	}
	public boolean validate_createcustomer(){
		if(firstName == "") {
			message = "First Name cannot be left Blank";
			return false;
		}
		
		if(lastName == "") {
			message = "Last Name cannot be left Blank";
			return false;
		}
		if(email == "") {
			message = "Email cannot be left Blank";
			return false;
		}
		
		if(password == "") {
			message = "Password cannot be left Blank";
			return false;
		}
		
		if(DOB == "") {
			message = "DOB cannot be left Blank";
			return false;
		}
		
		if(address1 == "") {
			message = "Address Line 1 cannot be left Blank";
			return false;
		}
		
		if(citystate == "") {
			message = "City/State cannot be left Blank";
			return false;
		}
		
		
		if(zip == "") {
			message = "Zip cannot be left Blank";
			return false;
		}
		
		if(contactnumber == "") {
			message = "Contact number cannot be left Blank";
			return false;
		}
		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address";
			return false;
		}
		
		if(password.length() < 8) {
			message = "Password must be at least 8 characters.";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot contain space.";
			return false;
		}
		return true;
	}
	
	

}

