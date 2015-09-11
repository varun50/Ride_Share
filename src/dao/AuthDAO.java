package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.User;

public class AuthDAO {

	private Connection conn = null;

	public AuthDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load database driver");
			Logger.getLogger(AuthDAO.class.getName()).log(Level.SEVERE, null, e);
			return;
		}

		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rideshare", "root", "");
			System.out.println("connection:: "+conn);
		} catch (SQLException e) {
			System.out.println("Can't connect to database.");
			return;
		}

		//System.out.println("Connected to database.");
		
		
	}
	
	/*Check if driver (driverid) already exists in Database*/
	public int checkDriverPass(String email, String password) throws SQLException {

		String sql = "select driverId from driver where email=? and password=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, email);
		stmt.setString(2, password);

		ResultSet checkuseraccount = stmt.executeQuery();

		if (checkuseraccount.next()){
			count=checkuseraccount.getInt(1);
		}
		
    }catch (Exception e){
	        e.printStackTrace(); 
		   	return -1;
    }		
		if(count!=0)
			return count;
		else
			return -1;
	}
	
	/*Get the Driver Details during Login and return User object*/
	public User getDriverById(int driverId) throws SQLException{
		String sql = "select * from driverprofile where driverId=?";
		User user = new User();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, driverId);

		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			user.setEmail(rs.getString("email")); 
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
		}
		
		return user;
	}
	
	
	/*Check if customer (customerid) already exists in Database*/
	public int checkCustomerPass(String email, String password) throws SQLException {

		String sql = "select customerId from customer where email=? and password=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, email);
		stmt.setString(2, password);

		ResultSet checkuseraccount = stmt.executeQuery();

		if (checkuseraccount.next()){
			count=checkuseraccount.getInt(1);
		}
		
    }catch (Exception e){
	        e.printStackTrace(); 
		   	return -1;
    }		
		if(count!=0)
			return count;
		else
			return -1;
	}
	
	/*Get the Customer Details during Login and return User object*/
	public User getCustomerById(int customerId) throws SQLException{
		String sql = "select * from customerprofile where customerId=?";
		User user = new User();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, customerId);

		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			user.setEmail(rs.getString("email")); 
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
		}
		
		return user;
	}
	
	
	/* Enter email and Password is driver table */
	public int enterNewDriver(String email, String password) throws SQLException {
		String sql = "insert into driver (email, password) values (?, ?)";
		int count = 0;
  try{
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, email);
		stmt.setString(2, password);
		
		@SuppressWarnings("unused")
		int execute = stmt.executeUpdate();
		
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()){
			count=rs.getInt(1);
		}
		
    }catch (Exception e){
	        e.printStackTrace(); 
		   	return -1;
    }
			return count;
	}
	
	
	/*Enter UserId and all user information in driver_profile table 
	 * from userID returned from enterNewDriver(String email, String password)*/
	
	public boolean enterDriverProfile(int driverId, String FirstName, String LastName, String email, String password,
			String DOB, String address1, String address2, String contactnumber, String citystate, String zip, String licenseno, String dateofissue, 
			String dateofexpiry, String carmodel, String cartype) throws SQLException {
		
		String sql = "insert into driverprofile (driverId, firstName, lastName, email, password, dob, address1, address2, contactnumber,"
				+ "citystate, zip, licenseno, dateofissue, dateofexpiry, carmodel, cartype) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, driverId);
		stmt.setString(2, FirstName);
		stmt.setString(3, LastName);
		stmt.setString(4, email);
		stmt.setString(5, password);
		stmt.setString(6, DOB);
		stmt.setString(7, address1);
		stmt.setString(8, address2);
		stmt.setString(9, contactnumber);
		stmt.setString(10, citystate);
		stmt.setString(11, zip);
		stmt.setString(12, licenseno);
		stmt.setString(13, dateofissue);
		stmt.setString(14, dateofexpiry);
		stmt.setString(15, carmodel);
		stmt.setString(16, cartype);
		
		int rs = stmt.executeUpdate();
		
		//stmt.close();
		int count = 0;
			
		count = rs;

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/* Enter email and Password is customer table */
	public int enterNewCustomer(String email, String password) throws SQLException {
		String sql = "insert into customer (email, password) values (?, ?)";
		int count = 0;
  try{
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, email);
		stmt.setString(2, password);
		
		@SuppressWarnings("unused")
		int execute = stmt.executeUpdate();
		
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()){
			count=rs.getInt(1);
		}
		
    }catch (Exception e){
	        e.printStackTrace(); 
		   	return -1;
    }
			return count;
	}
	
	
	/*Enter UserId and all user information in user_profile table 
	 * from userID returned from enterNewCustomer(String email, String password)*/
	
	public boolean enterCustomerProfile(int customerId, String FirstName, String LastName, String email, String password,
			String DOB, String address1, String address2, String citystate, String zip, String contactnumber) throws SQLException {
		
		String sql = "insert into customerprofile (customerId, firstName, lastName, email, password, dob, address1, address2,"
				+ "citystate, zip, contactnumber) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, customerId);
		stmt.setString(2, FirstName);
		stmt.setString(3, LastName);
		stmt.setString(4, email);
		stmt.setString(5, password);
		stmt.setString(6, DOB);
		stmt.setString(7, address1);
		stmt.setString(8, address2);
		stmt.setString(9, citystate);
		stmt.setString(10, zip);
		stmt.setString(11, contactnumber);
		
		int rs = stmt.executeUpdate();
		
		//stmt.close();
		int count = 0;
			
		count = rs;

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/*Check if email (Driver) exists in Database*/
	public boolean isDriverNameAvailable(String email) throws SQLException{

		String sql = "select count(*) as count from driver where email=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		rs.close();
		}catch (NullPointerException n){
			return false;
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/*Check if email (Customer) exists in Database*/
	public boolean isCustomerNameAvailable(String email) throws SQLException{

		String sql = "select count(*) as count from customer where email=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		rs.close();
		}catch (NullPointerException n){
			return false;
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void DB_Close() throws Throwable
	{
		try {
		if(conn!=null) { 
		conn.close();  // Close the connection
		}
		}
		catch(SQLException e) {
		System.out.println(e);
		}
	}
	
	public void createjourney(int driverId, String dname, String Doj, String IniDes, String FinDes, int seats) throws SQLException {
		String sql = "insert into driverjourney (driverId, dname, dateofjourney, inidest, findest, noofseats) values (?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, driverId);
		stmt.setString(2, dname);
		stmt.setString(3, Doj);
		stmt.setString(4, IniDes);
		stmt.setString(5, FinDes);
		stmt.setInt(6, seats);
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	public void entertostops(int driverId, String location) throws SQLException{
		
		String sql = "insert into stops (driverId, location) values (?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, driverId);
		stmt.setString(2, location);
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}

	
	public void createroute(int customerId, String dateofjourney, String inidest, String findest, int seat) throws SQLException {
		String sql = "insert into customerjourney (customerId, dateofjourney, inidest, findest, customerseats) values (?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, customerId);
		stmt.setString(2, dateofjourney);
		stmt.setString(3, inidest);
		stmt.setString(4, findest);
		stmt.setInt(5, seat);
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	public User readfinaljourney(int customerId) throws SQLException{
		String sql = "select * from completedjourney where customerId = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		User user = new User();
		while(rs.next()){
			user.setCustomerId(rs.getInt("customerId"));
			user.setDriverID(rs.getInt("driverID"));
			user.setDname(rs.getString("dname"));
			user.setDateofjourney(rs.getString("dateofjourney"));
			user.setInidest(rs.getString("inidest"));
			user.setFindest(rs.getString("findest"));
			user.setNoofstops(rs.getInt("noofstops"));
			user.setNoofseats(rs.getInt("noofseats"));
		}
		rs.close();
		return user;
		
	}
	
	public void updateDriverRating(int rating, int driverId) throws SQLException{
		
		String sql = "update driverprofile set rating = ? where driverId = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, rating);
		stmt.setInt(2, driverId);
		
		stmt.executeUpdate();
		System.out.println(rating+"and"+driverId);
		stmt.close();	
	}
	
	public void updateDriver (int driverId, String FirstName, String LastName, String email, String password,
			String DOB, String address1, String address2, String contactnumber, String citystate, String zip, String licenseno,
			String dateofissue, String dateofexpiry, String carmodel, String cartype) throws SQLException{
			String sql = "update driverprofile set firstName = ?, lastName = ?, email = ?, password = ?, dob = ?, address1 = ?,"
				+ "address2 = ?, contactnumber = ?, citystate = ?, zip = ?, licenseno = ?, dateofissue = ?, dateofexpiry = ?,"
				+ "carmodel = ?, cartype = ? where driverId = ?";

				PreparedStatement stmt = conn.prepareStatement(sql);

				stmt.setString(1, FirstName);
				stmt.setString(2, LastName);
				stmt.setString(3, email);
				stmt.setString(4, password);
				stmt.setString(5, DOB);
				stmt.setString(6, address1);
				stmt.setString(7, address2);
				stmt.setString(8, contactnumber);
				stmt.setString(9, citystate);
				stmt.setString(10, zip);
				stmt.setString(11, licenseno);
				stmt.setString(12, dateofissue);
				stmt.setString(13, dateofexpiry);
				stmt.setString(14, carmodel);
				stmt.setString(15, cartype);
				stmt.setInt(16, driverId);
				
				stmt.executeUpdate();
				stmt.close();
	}
	
	public int[] fetchdriveridfromcj(String initial,String Final)
	{
		ResultSet rs=null;
		int row=-1;
		
		int index=0;
	
		
		String sql="select DISTINCT driverId from driverjourney where inidest=? and findest=?";
		
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, initial);
			ps.setString(2, Final);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				if(rs.last())
				{
					row=rs.getRow();
				}
			 }
			
			 
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		if(row!=-1)
		{	
		int[] x=new int[row];
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,initial);
			ps.setString(2,Final);
			rs=ps.executeQuery();
			while(rs.next())
			{
				x[index]=rs.getInt("driverId");
				index++;
			}
			return x;
		}catch(SQLException s)
		{
			s.printStackTrace();
		}}
		return null;
	}
	
	public int[] fetchdriverfromstops(String initial,String Final)
	{
		
		ResultSet rs=null;
		int row=-1;
		
		int index=0;
		
		
		String sql="select DISTINCT driverId from stops where location=? or location=?";
		
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, initial);
			ps.setString(2, Final);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				if(rs.last())
				{
					row=rs.getRow();
				}
			 }
			
			 
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		if(row!=-1)
		{	
		int[] x=new int[row];
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,initial);
			ps.setString(2,Final);
			rs=ps.executeQuery();
			while(rs.next())
			{
				x[index]=rs.getInt("driverId");
				index++;
			}
			
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		return x;}
		return null;
	}
	
	public String[] getName(int[] x)
	{
		int[] y=x;
		String[] z=new String[y.length];
		for(int i=0;i<y.length;i++)
		{
			
			String sql="select DISTINCT firstName from driverprofile where driverId=?";
			try
			{
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, y[i]);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					z[i]=rs.getString("firstName");
				}
			}catch(SQLException s)
			{
				s.printStackTrace();
			}
			
		}
	return z;}
	
	public int getSeats(int driverid){
		
		int x=-1;
		String sql="Select noofseats from driverjourney where driverId=?";
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,driverid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				x=rs.getInt("noofseats");
			}
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		return x;
	}
	
	
	/*public boolean checkSeats(int driverid)
	{
		int x=-1;
		
		String sql="select count(DISTINCT customerId) as count from completedjourney where driverID=? ";
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, driverid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				x=rs.getInt("count");
			}
			AuthDAO account = new AuthDAO();
			if(x<account.getSeats(driverid))
			{
				return true;
			}
		}catch(SQLException s)
		{
			
		}
		return false;
	}*/
	
	/*public boolean ReturnSeatStatus(int driverid,String initial,String Final,int seat)
	{
	  
	   //int seats=AuthDAO.getSeats(driverid);
	  int x=-1;
	   String sql="Select inidest,findest from completedjourney where driverID=? ";
	   try{
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setInt(1, driverid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.last())
			{
				x=rs.getRow();
			}
		}
	   }catch(SQLException | NullPointerException s)
	   {
		   
		s.printStackTrace();   
			
	   }   
	   String[] a=new String[x];
	   String[] b=new String[x];
	   int index=0;
		try
		{
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,driverid);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				a[index]=rs.getString("inidest");
				b[index]=rs.getString("findest");
				index++;
			   
			}
		}
	   catch(SQLException s)
	   {
		   s.printStackTrace();
	   }
		int count=0;
		int count1=0;
		for(int i=0;i<a.length;i++)
		{
			if(b[i].equals(initial))
			{
				count++;
			}
			
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i].equals(initial))
			{
				count1++;
			}
			
		}
		
			if(count>=(count1+seat))
			{
				return true;
			}
	return false;}*/
	
	public int ReturnSeatsLeft(int driverid,String initial,String Final,int seat)
	{
	  
	   //int seats=AuthDAO.getSeats(driverid);
	  int x=-1;
	   String sql="Select inidest,findest from completedjourney where driverID=? ";
	   try{
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setInt(1, driverid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.last())
			{
				x=rs.getRow();
			}
		}
	   }catch(SQLException | NullPointerException s)
	   {
		   
		s.printStackTrace();   
	   }   
	   String[] a=new String[x];
	   String[] b=new String[x];
	   int index=0;
		try
		{
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,driverid);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				a[index]=rs.getString("inidest");
				b[index]=rs.getString("findest");
				index++;
			   
			}
		}
	   catch(SQLException s)
	   {
		   s.printStackTrace();
	   }
		int count=0;
		int count1=0;
		for(int i=0;i<a.length;i++)
		{
			if(b[i].equals(initial))
			{
				count++;
			}
			
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i].equals(initial))
			{
				count1++;
			}
			
		}
		
			if(count>=(count1+seat))
			{
				return count;
			}
	return 0;}
	
	// 
	public int ReturnSeats(int driverid,String initial,String Final,int seat)
	{
		
		try{
			AuthDAO account = new AuthDAO();
			if(account.checkSeats1(driverid)<account.getSeats(driverid))
			{
				return (account.getSeats(driverid)-account.checkSeats1(driverid));
			}
			else{
			int b=account.ReturnSeatsLeft(driverid, initial, Final, seat);
			return b;
			}
		}catch(NullPointerException n)
		{	
			AuthDAO account = new AuthDAO();
			return account.getSeats(driverid);
		}
		
	}

	public int checkSeats1(int driverid)
	{
		int x=-1;
		
		String sql="select count(DISTINCT customerId) as count  from completedjourney where driverID=? ";
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, driverid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				x=rs.getInt("count");
			}
			
				return x;
			
		}catch(SQLException s)
		{
			
		}
		return x;
	}

	
	public int[] fetchdriveridfromcj(String initial)
	{
		ResultSet rs=null;
		int row=-1;
		
		int index=0;
		
		
		String sql="select driverId from driverjourney where inidest=?";
		
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, initial);
			
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				if(rs.last())
				{
					row=rs.getRow();
				}
			 }
			
			 
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		if(row!=-1)
		{	
		int[] x=new int[row];
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,initial);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				x[index]=rs.getInt("driverId");
				index++;
			}
			return x;
		}catch(SQLException s)
		{
			s.printStackTrace();
		}}
		return null;
	}
	
	public int[] fetchdriveridfromc(String Final)
	{
		ResultSet rs=null;
		int row=-1;
		
		int index=0;
		
		
		String sql="select driverId from driverjourney where findest=?";
		
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Final);
			
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				if(rs.last())
				{
					row=rs.getRow();
				}
			 }
			
			 
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		if(row!=-1)
		{	
		int[] x=new int[row];
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,Final);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				x[index]=rs.getInt("driverId");
				index++;
			}
			return x;
		}catch(SQLException s)
		{
			s.printStackTrace();
		}}
		return null;
	}
	
	public int checkSeat(int driverid)
	{
		int x=-1;
		
		String sql="Select count(DISTINCT customerId) as count from completedjourney where driverID=? ";
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, driverid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				x=rs.getInt("count");
			}
			
		}catch(SQLException s)
		{
			s.printStackTrace();
		}
		return x;
	}
	
	/*public String ReturnSeatsString(int driverid,String initial,String Final,int seat)
	{
	   
	   AuthDAO account = new AuthDAO();	
	   int seats=account.getSeats(driverid);
	  int x=-1;
	   String sql="Select inidest,findest from completedjourney where driverID=? ";
	   try{
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setInt(1, driverid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.last())
			{
				x=rs.getRow();
			}
		}
	   }catch(SQLException s)
	   {
		s.printStackTrace();   
	   }   
	   String[] a=new String[x];
	   String[] b=new String[x];
	   int index=0;
		try
		{
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,driverid);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				a[index]=rs.getString("inidest");
				b[index]=rs.getString("findest");
				index++;
			   
			}
		}
	   catch(SQLException s)
	   {
		   s.printStackTrace();
	   }
		int count=0;
		int count1=0;
		for(int i=0;i<a.length;i++)
		{
			if(b[i].equals(initial))
			{
				count++;
			}
			
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i].equals(initial))
			{
				count1++;
			}
			
		}
		
			if(count>=(count1+seat))
			{
				return "empty";
			}
	return "full";}*/
	
}

