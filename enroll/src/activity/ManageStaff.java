package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import attr.*;

public class ManageStaff extends JFrame implements ActionListener {
	private JPanel panel;
	ViewStaffActivity prev;
	private Staff Staff;
	private JButton buttonBack, buttonEdit, buttonDelete;
	private JLabel title, header, userIdLabel, StaffNameLabel, phoneNumberLabel, roleLabel, salaryLabel;
	private JTextField userIdTF, StaffNameTF, phoneNumberTF, phoneCodeTF, salaryTF;
	private JComboBox roleCB;
	
	public ManageStaff(String eid, ViewStaffActivity prev) {
		super("Manage Staff");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		Staff = new Staff(eid);
		Staff.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		userIdLabel = new JLabel("Staff ID: "+Staff.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		StaffNameLabel = new JLabel("Name: ");
		StaffNameLabel.setBounds(60, 60, 140, 30);
		StaffNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(StaffNameLabel);
		
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel);
		
		roleLabel = new JLabel("Role: ");
		roleLabel.setBounds(60, 140, 140, 30);
		roleLabel.setFont(Theme.FONT_INPUT);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(60, 180, 140, 30);
		salaryLabel.setFont(Theme.FONT_INPUT);
		panel.add(salaryLabel);
		
		StaffNameTF = new JTextField(Staff.getStaffName());
		StaffNameTF.setBounds(160, 60, 220, 30);
		StaffNameTF.setFont(Theme.FONT_INPUT);
		panel.add(StaffNameTF);
		
		phoneCodeTF = new JTextField("+251");
		phoneCodeTF.setEnabled(false);
		phoneCodeTF.setBounds(160, 100, 40, 30);
		phoneCodeTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneCodeTF);
		

		phoneNumberTF = new JTextField(Staff.getPhoneNumber().substring(4)+"");
		phoneNumberTF.setBounds(200, 100, 180, 30);
		phoneNumberTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberTF);
		
		roleCB = new JComboBox(Staff.roles);
		roleCB.setBounds(160, 140, 160, 30);
		roleCB.setSelectedIndex(Staff.getRole().equals("Manager") ? 1 : 0);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);
		
		salaryTF = new JTextField(Staff.getSalary()+"");
		salaryTF.setBounds(160, 180, 220, 30);
		salaryTF.setFont(Theme.FONT_INPUT);
		panel.add(salaryTF);
		
		buttonEdit = new JButton("Edit");
		buttonEdit.setBounds(60, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
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
				Staff.updateStaff(StaffNameTF.getText(),Integer.parseInt(phoneNumberTF.getText()),roleCB.getSelectedItem().toString(), Double.parseDouble(salaryTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Staff.searchStaff(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Staff.searchStaff("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonDelete)) {
			Staff.deleteStaff();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Staff.searchStaff(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Staff.searchStaff("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}