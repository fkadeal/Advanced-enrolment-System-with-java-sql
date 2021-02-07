package ActivityPackage;

import CommonClass.Student;
import CommonClass.Theme;
import ActivityPackage.MyCourseActivity.MyProfileActivity;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class StudentActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Student Student;
	private JButton buttonLogout, buttonProfile, buttonViewCourse, buttonMyCourse;
	private JLabel title, header;
	public StudentActivity(String userId) {
		super("Dashboard - Student");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		Student = new Student(userId);
		Student.fetch();
		
		title = new JLabel("Welcome, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		buttonProfile.setFont(Theme.FONT_BUTTON);
		buttonProfile.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonProfile.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);
		
		buttonViewCourse = new JButton("View Course");
		buttonViewCourse.setBounds(60, 160, 200, 30);
		buttonViewCourse.setFont(Theme.FONT_BUTTON);
		buttonViewCourse.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewCourse.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewCourse.addActionListener(this);
		panel.add(buttonViewCourse);
		
		buttonMyCourse = new JButton("Course History");
		buttonMyCourse.setBounds(60, 190, 200, 30);
		buttonMyCourse.setFont(Theme.FONT_BUTTON);
		buttonMyCourse.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonMyCourse.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonMyCourse.addActionListener(this);
		panel.add(buttonMyCourse);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, Student).setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewCourse)) {
			this.setVisible(false);
			new ViewCourseActivity(this, Student).setVisible(true);
		}
		else if (ae.getSource().equals(buttonMyCourse)) {
			this.setVisible(false);
			new MyCourseActivity(this, Student).setVisible(true);
		}
		else {}
	}
}