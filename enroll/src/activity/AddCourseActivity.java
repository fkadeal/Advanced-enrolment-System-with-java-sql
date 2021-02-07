package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

public class AddCourseActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private ViewCourseActivity activity;
	private Staff Staff;
	private JButton buttonLogout, buttonBack, buttonAdd;
	private JLabel title, header, CourseNameLabel, CourseQtLabel, CoursePriceLabel;
	private JTextField CourseNameTF, CourseQtTF, CoursePriceTF;
	
	public AddCourseActivity(ViewCourseActivity prev, Staff Staff) {
		super("Add Course");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.Staff = Staff;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Add Course");
		title.setBounds(30, 40, 280,75);
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
		
		CourseNameLabel = new JLabel("Name: ");
		CourseNameLabel.setBounds(60, 190, 140, 30);
		CourseNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(CourseNameLabel);
		
		CoursePriceLabel = new JLabel("Price: ");
		CoursePriceLabel.setBounds(60, 240, 140, 30);
		CoursePriceLabel.setFont(Theme.FONT_REGULAR);
		panel.add(CoursePriceLabel);
		
		CourseQtLabel = new JLabel("credit_hour: ");
		CourseQtLabel.setBounds(60, 290, 140, 30);
		CourseQtLabel.setFont(Theme.FONT_REGULAR);
		panel.add(CourseQtLabel);
		
		CourseNameTF = new JTextField();
		CourseNameTF.setBounds(180, 190, 220, 30);
		CourseNameTF.setFont(Theme.FONT_INPUT);
		panel.add(CourseNameTF);
		
		CoursePriceTF = new JTextField();
		CoursePriceTF.setBounds(180, 240, 220, 30);
		CoursePriceTF.setFont(Theme.FONT_INPUT);
		panel.add(CoursePriceTF);
		
		CourseQtTF = new JTextField();
		CourseQtTF.setBounds(180, 290, 220, 30);
		CourseQtTF.setFont(Theme.FONT_INPUT);
		panel.add(CourseQtTF);
		
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(60, 340, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonAdd.setFont(Theme.FONT_BUTTON);
		buttonAdd.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAdd.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAdd.addActionListener(this);
		panel.add(buttonAdd);
		
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
			new ViewCourseActivity(new StaffActivity(Staff.getUserId()), Staff).setVisible(true);
		}
		else if (ae.getSource().equals(buttonAdd)) {
			try {
				Course p = new Course();
				p.setCourseName(CourseNameTF.getText().trim());
				p.setPrice(Double.parseDouble(CoursePriceTF.getText()));
				p.setcredit_hour(Integer.parseInt(CourseQtTF.getText()));
				p.createCourse();
				CourseNameTF.setText("");
				CoursePriceTF.setText("");
				CourseQtTF.setText("");
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Course.searchCourse(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Course.searchCourse("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter price/credit_hour correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}
}