package ActivityPackage;

import CommonClass.User;
import CommonClass.Theme;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class LoginActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonExit,buttonListMambers, buttonLogin, buttonSignup;
	private JLabel title, header, usernameLabel, passwordLabel;
	private JTextField usernameTF;
	private JPasswordField passwordF;
	public LoginActivity() {
		super("Login");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Advanced Course Enrollment System");
		title.setBounds(30, 40,555, 75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonExit.setFont(Theme.FONT_BUTTON);
		buttonExit.setBackground(Color.WHITE);
		buttonExit.setForeground(Theme.COLOR_TITLE);
		buttonExit.addActionListener(this);
		panel.add(buttonExit);
                
                buttonListMambers = new JButton("Group Members");
		buttonListMambers.setBounds(Theme.GUI_WIDTH-200, 500, Theme.BUTTON_PRIMARY_WIDTH+50,30);
		buttonListMambers.setFont(Theme.FONT_BUTTON);
		buttonListMambers.setBackground(Color.WHITE);
		buttonListMambers.setForeground(Theme.COLOR_TITLE);
		buttonListMambers.addActionListener(this);
		panel.add(buttonListMambers);
		
		buttonSignup = new JButton("Sign up");
		buttonSignup.setBounds(230, 380, 150, 30);
		buttonSignup.setFont(Theme.FONT_BUTTON);
		buttonSignup.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSignup.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSignup.addActionListener(this);
		panel.add(buttonSignup);
		
		usernameLabel = new JLabel("User ID: ");
		usernameLabel.setBounds(210, 220, 120, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(330, 220, 220, 30);
		usernameTF.setFont(Theme.FONT_INPUT);
		panel.add(usernameTF);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(210, 280, 120, 30);
		passwordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(passwordLabel);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(330, 280, 220, 30);
		passwordF.setFont(Theme.FONT_INPUT);
		panel.add(passwordF);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(230, 345, 300, 30);
		buttonLogin.setFont(Theme.FONT_BUTTON);
		buttonLogin.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonLogin.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonLogin.addActionListener(this);
		panel.add(buttonLogin);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
        JFrame frame;
	public void actionPerformed(ActionEvent ae) {
            if (ae.getSource().equals(buttonListMambers))
                

		JOptionPane.showMessageDialog(frame,""
                        + "     name________________ ID:\n"
                        + "Fkadeal Matiwos_____| CEP 0190/11:\n"
                        + "Miliyon Befkadu______| CEP 0187/11:\n"
                        + "Senait Alemayehu ____| CEP 0156/11:\n"
                        + "Gedion Hailu_________| CEP 0191/11:\n"
                        + "Amanuel Ejigu________| CEP 0087/11:\n",
                    "Group Member Names",
                    JOptionPane.PLAIN_MESSAGE);
		if (ae.getSource().equals(buttonExit))
			System.exit(0);
		else if (ae.getSource().equals(buttonSignup)) {
			this.setVisible(false);
			new SignupActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogin)) {
			int status = User.checkStatus(usernameTF.getText(), passwordF.getText());
			if (status == 0) {
				StaffActivity ea = new StaffActivity(usernameTF.getText());
				ea.setVisible(true);
				this.setVisible(false);
			}
			else if (status == 1) {
				StudentActivity ca = new StudentActivity(usernameTF.getText());
				ca.setVisible(true);
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
		else {}
	}
}