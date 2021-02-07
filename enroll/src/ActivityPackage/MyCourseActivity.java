package ActivityPackage;

import CommonClass.Staff;
import CommonClass.Student;
import CommonClass.User;
import CommonClass.Theme;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;

public class MyCourseActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Student Student;
	private JFrame activity;
	private JScrollPane frame;
	private JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck;
	private JLabel title, header, keywordLabel, CourseNameLabel, CourseQtLabel, CoursePriceLabel;
	private JTextField keywordTF, CourseNameTF, CourseQtTF, CoursePriceTF;
	public MyCourseActivity(JFrame prev, Student Student) {
		super("Course History");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.Student = Student;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Course History");
		title.setBounds(30, 40, 480,75);
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
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		table = new JTable();
		table.setModel(Student.myCourse());
		frame = new JScrollPane(table);
		frame.setBounds(40,140,600,300);
		panel.add(frame);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       
    }


public static class MyProfileActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonEdit, buttonBack, buttonLogout, buttonSubmit, buttonPass, buttonDelete;
	private JFrame backActivity;
	private User usr;
	private Staff Staff;
	private Student Student;
	private JLabel title, header, usernameLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField nameTF, phoneTF1, phoneTF2, addressTF;
	private JLabel roleLabel, salaryLabel;
	public MyProfileActivity(JFrame activity, Student Student) {
		super("My Profile");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		this.Student = Student;
		this.usr = (User) Student;
		
		title = new JLabel("My Profile");
		title.setBounds(30, 40, 260,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(60, 330, 120, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(60, 330, 120, 30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonPass = new JButton("Change Password");
		buttonPass.setBounds(Theme.GUI_WIDTH-180, 115, 160, 30);
		buttonPass.setFont(Theme.FONT_BUTTON);
		buttonPass.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonPass.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		
		buttonDelete = new JButton("Delete Account");
		buttonDelete.setBounds(Theme.GUI_WIDTH-180, 150, 160, 30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("User ID:       "+Student.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		nameTF = new JTextField(Student.getStudentName());
		nameTF.setBounds(180, 190, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		
		phoneTF1 = new JTextField("+251");
		phoneTF1.setBounds(180, 240, 40, 30);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField(Student.getPhoneNumber().substring(4));
		phoneTF2.setBounds(220, 240, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		
		addressTF = new JTextField(Student.getAddress());
		addressTF.setBounds(180, 290, 220, 30);
		addressTF.setEnabled(false);
		addressTF.setFont(Theme.FONT_INPUT);
		addressTF.setDisabledTextColor(Color.BLACK);
		panel.add(addressTF);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 290, 440, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public MyProfileActivity(JFrame activity, Staff Staff) {
		super("My Profile");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		this.Staff = Staff;
		this.usr = (User) Staff;
		
		title = new JLabel("My Profile");
		title.setBounds(30, 40, 260,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(60, 380, 120, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(60, 380, 120, 30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonPass = new JButton("Change Password");
		buttonPass.setBounds(Theme.GUI_WIDTH-180, 115, 160, 30);
		buttonPass.setFont(Theme.FONT_BUTTON);
		buttonPass.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonPass.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("User ID:        "+Staff.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		roleLabel = new JLabel("Role:             "+Staff.getRole());
		roleLabel.setBounds(60, 290, 440, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary:          "+Staff.getSalary());
		salaryLabel.setBounds(60, 340, 440, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		
		
		nameTF = new JTextField(Staff.getStaffName());
		nameTF.setBounds(180, 190, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		
		phoneTF1 = new JTextField("+251");
		phoneTF1.setBounds(180, 240, 40, 30);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField(Staff.getPhoneNumber().substring(4));
		phoneTF2.setBounds(220, 240, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			backActivity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			nameTF.setEnabled(true);
			phoneTF2.setEnabled(true);
			if (Student!=null)
				addressTF.setEnabled(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			
			if (Student!=null) {
				addressTF.setEnabled(false);
				try {
					Student.updateStudent(nameTF.getText().trim(), Integer.parseInt(phoneTF2.getText()), addressTF.getText().trim());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid Number!");
				}
			}
			else if (Staff!=null) {
				try {
					Staff.updateStaff(nameTF.getText().trim(), Integer.parseInt(phoneTF2.getText()), Staff.getRole(), Staff.getSalary());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid number!");
				}
			}
		}
		else if (ae.getSource().equals(buttonPass)) {
			new ChangePasswordActivity(this.usr).setVisible(true);
		}
		else if (ae.getSource().equals(buttonDelete)) {
			int input = JOptionPane.showConfirmDialog(null, "Sure to Delete?", "Delete "+Student.getUserId()+"?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				Student.deleteStudent();
				this.setVisible(false);
				new LoginActivity().setVisible(true);
			}
			else {}
		}
		else {}
	}
}

}