package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import attr.*;

public class ManageCourse extends JFrame implements ActionListener {
	private JPanel panel;
	ViewCourseActivity prev;
	private Course Course;
	private JButton buttonBack, buttonEdit, buttonDelete, buttonSell, buttonSubmit;
	private JLabel title, header, CourseIdLabel, CourseNameLabel, CourseQtLabel, CoursePriceLabel, userIdLabel;
	private JTextField CourseIdTF, CourseNameTF, CourseQtTF, CoursePriceTF, userIdTF;
	
	public ManageCourse(String pid, ViewCourseActivity prev) {
		super("Manage Course");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		Course = new Course(pid);
		Course.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		CourseIdLabel = new JLabel("Course ID: "+Course.getCourseId());
		CourseIdLabel.setBounds(60, 20, 140, 30);
		CourseIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(CourseIdLabel);
		
		CourseNameLabel = new JLabel("Name: ");
		CourseNameLabel.setBounds(60, 60, 140, 30);
		CourseNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(CourseNameLabel);
		
		CoursePriceLabel = new JLabel("Price: ");
		CoursePriceLabel.setBounds(60, 100, 140, 30);
		CoursePriceLabel.setVisible(false);
		CoursePriceLabel.setFont(Theme.FONT_INPUT);
		panel.add(CoursePriceLabel);
		
		userIdLabel = new JLabel("StudentID: ");
		userIdLabel.setBounds(60, 100, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		CourseQtLabel = new JLabel("credit_hour: ");
		CourseQtLabel.setBounds(60, 140, 140, 30);
		CourseQtLabel.setFont(Theme.FONT_INPUT);
		panel.add(CourseQtLabel);
		
		CourseNameTF = new JTextField(Course.getCourseName());
		CourseNameTF.setBounds(180, 60, 220, 30);
		CourseNameTF.setEnabled(false);
		CourseNameTF.setFont(Theme.FONT_INPUT);
		panel.add(CourseNameTF);
		
		userIdTF = new JTextField("");
		userIdTF.setBounds(180, 100, 220, 30);
		userIdTF.setFont(Theme.FONT_INPUT);
		panel.add(userIdTF);
		
		CoursePriceTF = new JTextField(Course.getPrice()+"");
		CoursePriceTF.setBounds(180, 100, 220, 30);
		CoursePriceTF.setFont(Theme.FONT_INPUT);
		CoursePriceTF.setVisible(false);
		panel.add(CoursePriceTF);
		
		CourseQtTF = new JTextField("");
		CourseQtTF.setBounds(180, 140, 220, 30);
		CourseQtTF.setFont(Theme.FONT_INPUT);
		panel.add(CourseQtTF);
		
		buttonEdit = new JButton("Edit");
		buttonEdit.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(300, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		buttonSell = new JButton("Sell");
		buttonSell.setBounds(60, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSell.setFont(Theme.FONT_BUTTON);
		buttonSell.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSell.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSell.addActionListener(this);
		panel.add(buttonSell);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonSell)) {
			try {
				Course.sellCourse(userIdTF.getText().trim(),Integer.parseInt(CourseQtTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Course.searchCourse(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Course.searchCourse("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			buttonSell.setEnabled(false);
			CourseQtTF.setText(Course.getcredit_hour()+"");
			CourseNameTF.setEnabled(true);
			userIdLabel.setVisible(false);
			userIdTF.setVisible(false);
			CoursePriceLabel.setVisible(true);
			CoursePriceTF.setVisible(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			try {
				Course.updateCourse(CourseNameTF.getText(),Double.parseDouble(CoursePriceTF.getText()),Integer.parseInt(CourseQtTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Course.searchCourse(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Course.searchCourse("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonDelete)) {
			Course.deleteCourse();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Course.searchCourse(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Course.searchCourse("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}