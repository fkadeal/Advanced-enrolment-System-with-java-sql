package CommonClass;

import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Staff extends User {
	private String StaffName;
	private String phoneNumber;
	private String role;
	public static String[] columnNames = {"StaffID", "StaffName", "PhoneNumber", "Role", "Salary"};
	public static String[] roles = {"General", "Manager"};
	private double salary;
	public Staff(String userId) {
		super(userId);
		this.setStatus(0);
	}
	
	public void setStaffName(String name) {
		if (!name.isEmpty())
			this.StaffName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	public void setPhoneNumber(int num) {
		this.phoneNumber = "+251"+num;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getStaffName() {
		return StaffName;
	}
	public String getRole() {
		return role;
	}
	public double getSalary() {
		return salary;
	}
	
	public void createStaff() {
		String query1 = "INSERT INTO `login` VALUES ('"+userId+"','"+password+"',"+status+");";
		String query2 = "INSERT INTO `Staff` VALUES ('"+userId+"','"+StaffName+"','"+phoneNumber+"','"+role+"', '"+salary+"');";
		Connection con = null;
        Statement st = null;
		//System.out.println(query1);
		//System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			//System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			//System.out.println("statement created");
			st.execute(query1);//insert
			st.execute(query2);
			//System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Account Created!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to create account!");
			//System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void fetch() {
		String query = "SELECT `userId`, `StaffName`, `phoneNumber`, `role`, `salary` FROM `Staff` WHERE userId='"+this.userId+"';";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		//System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			//System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			//System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			//System.out.println("results received");
			boolean flag = false;
			while(rs.next()) {
				this.StaffName = rs.getString("StaffName");
				this.phoneNumber = rs.getString("phoneNumber");
				this.role = rs.getString("role");
				this.salary = rs.getDouble("salary");
			}
		}
        catch(Exception ex) {
			//System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void updateStaff(String name, int phone, String role, double salary) {
		String query = "UPDATE `Staff` SET `StaffName`='"+name+"', `phoneNumber`='+251"+phone+"', `role`='"+role+"', `salary`="+salary+" WHERE `userId`='"+this.userId+"';";
		Connection con = null;
        Statement st = null;
		//System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			//System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			//System.out.println("statement created");
			st.executeUpdate(query);//insert
			//System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Information Updated!");
			this.StaffName = name;
			this.phoneNumber = "+251"+phone;
			this.role = role;
			this.salary = salary;
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to update account!");
			//System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void deleteStaff() {
		String query1 = "DELETE FROM `login` WHERE `userId`='"+this.userId+"';";
		String query2 = "DELETE FROM `Staff` WHERE `userId`='"+this.userId+"';";
		Connection con = null;
        Statement st = null;
		//System.out.println(query1);
		//System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			//System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			//System.out.println("statement created");
			st.execute(query1);
			st.execute(query2);//delete
			//System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Account Deleted!");
			this.userId = "";
			this.StaffName = "";
			this.phoneNumber = "";
			this.role = "";
			this.salary = 0;
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to delete account!");
			//System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public static DefaultTableModel searchStaff(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT * FROM `Staff` WHERE `userId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT * FROM `Staff` WHERE `StaffName` LIKE '%"+keyword+"%';";
		else {}
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		//System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			//System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			//System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			//System.out.println("results received");
			
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("userId"), rs.getString("StaffName"), rs.getString("phoneNumber"), rs.getString("role"), rs.getString("salary")});
			}
		}
        catch(Exception ex) {
			//System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
		return model;
	}
}