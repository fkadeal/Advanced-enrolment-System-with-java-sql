package ActivityPackage;

import CommonClass.Student;
import CommonClass.Theme;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageStudent extends JFrame implements ActionListener {
	private JPanel panel;
	ViewStudentActivity prev;
	private Student Student;
	private JButton buttonBack, buttonEdit, buttonDelete;
	private JLabel title, header, userIdLabel, StudentNameLabel, phoneNumberLabel, addressLabel;
	private JTextField userIdTF, StudentNameTF, phoneNumberTF, phoneCodeTF, addressTF;
	
	public ManageStudent(String cid, ViewStudentActivity prev) {
		super("Manage Student");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		Student = new Student(cid);
		Student.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		userIdLabel = new JLabel("Student ID: "+Student.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		StudentNameLabel = new JLabel("Name: ");
		StudentNameLabel.setBounds(60, 60, 140, 30);
		StudentNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(StudentNameLabel);
		
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 140, 140, 30);
		addressLabel.setFont(Theme.FONT_INPUT);
		panel.add(addressLabel);
		
		StudentNameTF = new JTextField(Student.getStudentName());
		StudentNameTF.setBounds(160, 60, 220, 30);
		StudentNameTF.setFont(Theme.FONT_INPUT);
		panel.add(StudentNameTF);
		
		phoneCodeTF = new JTextField("+251");
		phoneCodeTF.setEnabled(false);
		phoneCodeTF.setBounds(160, 100, 40, 30);
		phoneCodeTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneCodeTF);
		

		phoneNumberTF = new JTextField(Student.getPhoneNumber().substring(4)+"");
		phoneNumberTF.setBounds(200, 100, 180, 30);
		phoneNumberTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberTF);
		
		addressTF = new JTextField(Student.getAddress()+"");
		addressTF.setBounds(160, 140, 220, 30);
		addressTF.setFont(Theme.FONT_INPUT);
		panel.add(addressTF);
		
		buttonEdit = new JButton("Edit");
		buttonEdit.setBounds(60, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonEdit)) {
			try {
				Student.updateStudent(StudentNameTF.getText(),Integer.parseInt(phoneNumberTF.getText()),addressTF.getText().trim());
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Student.searchStudent(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Student.searchStudent("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonDelete)) {
			Student.deleteStudent();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Student.searchStudent(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Student.searchStudent("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}