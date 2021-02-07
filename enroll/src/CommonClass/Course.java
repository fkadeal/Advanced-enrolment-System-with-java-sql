package CommonClass;

import java.lang.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import javax.swing.*;

public class Course {
	private String CourseId;
	private String CourseName;
	private double price;
	private int credit_hour;
	public static String[] columnNames = {"PID", "Name", "Price", "Availablecredit_hour"};
	
	public Course() {}
	public Course(String CourseId) {
		if (!CourseId.isEmpty())
			this.CourseId = CourseId;
		else
			throw new IllegalArgumentException("Fill in the ID");
	}
	
	public void setCourseName(String name) {
		if (!name.isEmpty())
			this.CourseName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	public void setPrice(double p) {
		this.price = p;
	}
	public void setcredit_hour(int q) {
		this.credit_hour = q;
	}
	public String getCourseId() {
		return CourseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public double getPrice() {
		return price;
	}
	public int getcredit_hour() {
		return credit_hour;
	}
	
	public void fetch() {
		String query = "SELECT `CourseId`, `CourseName`, `price`, `credit_hour` FROM `Course` WHERE CourseId='"+this.CourseId+"';";     
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
				this.CourseName = rs.getString("CourseName");
				this.price = rs.getDouble("price");
				this.credit_hour = rs.getInt("credit_hour");
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
	
	public void RegisterCourse(String uid, int amount) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO `EnrollInfo` (`userId`, `CourseId`, `amount`, `date`, `cost`) VALUES ('"+uid+"','"+this.CourseId+"',"+amount+", '"+date+"', "+(amount*this.price)+");";
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
			st.execute(query);//insert
			//System.out.println("data inserted");
			updateCourse(this.CourseName, this.price, this.credit_hour-amount);
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Student doesn't exist!"); 
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
	
	public void updateCourse(String name, double price, int credit_hour) {
		String query = "UPDATE `Course` SET `CourseName`='"+name+"', `price`="+price+", `credit_hour`="+credit_hour+" WHERE `CourseId`='"+this.CourseId+"';";
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
			JOptionPane.showMessageDialog(null,"Done!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed!");
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
	
	public void createCourse() {
		String query = "INSERT INTO `Course` (`CourseName`, `price`, `credit_hour`) VALUES ('"+CourseName+"','"+price+"','"+credit_hour+"');";
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
			st.execute(query);//insert
			//System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Course Created!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to add Course!");
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
	
	public static DefaultTableModel searchCourse(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT `CourseId`, `CourseName`, `price`, `credit_hour` FROM `Course` WHERE `CourseId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT `CourseId`, `CourseName`, `price`, `credit_hour` FROM `Course` WHERE `CourseName` LIKE '%"+keyword+"%';";
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
				model.addRow(new Object[]{rs.getString("CourseId"), rs.getString("CourseName"), rs.getDouble("price"), rs.getInt("credit_hour")});
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
	
	public void deleteCourse() {
		String query1 = "DELETE FROM `Course` WHERE `CourseId`='"+this.CourseId+"';";
		Connection con = null;
        Statement st = null;
		//System.out.println(query1);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			//System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			//System.out.println("statement created");
			st.execute(query1);//delete
			//System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Course Deleted!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to delete Course!");
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
}