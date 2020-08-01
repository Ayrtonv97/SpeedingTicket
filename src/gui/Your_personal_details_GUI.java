package gui;

import logic.Your_driver_details;
import logic.data_Storage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class Your_personal_details_GUI {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblTitle;
	private JLabel lblFullName;
	private JTextField txtFullName;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblDOB;
	private JTextField txtDOB;
	private JLabel lblPhoneNumber;
	private JTextField txtPhoneNumber;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JButton btnNext;
	private JButton btnHome;
	private JLabel lblError;

	public Your_personal_details_GUI(){
		createForm();
		addFields();
		addButtons();

		frame.add(panel);
		frame.setVisible(true);
	}
	public void createForm(){
		frame = new JFrame ("Your personal details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,500);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
	}
	public void addFields(){
		lblTitle = new JLabel ("Your personal details");
		lblTitle.setBounds(150,40,200,100);
		Font font1 = new Font ("Ariel", Font.BOLD, 18);
		lblTitle.setFont(font1);
		panel.add(lblTitle);

		lblFullName = new JLabel ("Full name:");
		lblFullName.setBounds(150,150,175,40);
		panel.add(lblFullName);

		lblAddress = new JLabel ("Address:");
		lblAddress.setBounds(150,200,175,40);
		panel.add(lblAddress);

		lblDOB = new JLabel ("DOB:");
		lblDOB.setBounds(150,250,175,40);
		panel.add(lblDOB);

		lblPhoneNumber = new JLabel ("Phone number:");
		lblPhoneNumber.setBounds(150,300,175, 40);
		panel.add(lblPhoneNumber);

		lblEmail = new JLabel ("Email:");
		lblEmail.setBounds(150,350,175,40);
		panel.add(lblEmail);

		txtFullName = new JTextField();
		txtFullName.setBounds(220,160,100,25);
		panel.add(txtFullName);

		txtAddress = new JTextField();
		txtAddress.setBounds(220,207,100,25);
		panel.add(txtAddress);

		txtDOB = new JTextField();
		txtDOB.setBounds(220,255,100,25);
		panel.add(txtDOB);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(250,310,100,25);
		panel.add(txtPhoneNumber);

		txtEmail = new JTextField();
		txtEmail.setBounds(220,360,140,25);
		panel.add(txtEmail);
	}
	public void addButtons(){
		btnNext = new JButton ("Next");
		btnNext.setBounds (220,400,100,35);
		btnNext.addActionListener(new NextHandler());
		btnNext.setBackground(Color.blue);
		btnNext.setForeground(Color.WHITE);
		panel.add(btnNext);

		btnHome = new JButton ("Home");
		btnHome.setBounds(20,25,100,35);
		btnHome.addActionListener(new HomeHandler());
		btnHome.setBackground(Color.blue);
		btnHome.setForeground(Color.WHITE);
		panel.add(btnHome);
	}
	class NextHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			String nextFail = "N";



			if (txtAddress.getText().equals("")){
				nextFail = "Y";
			}
			else if (txtFullName.getText().equals("")){
				nextFail = "Y";
			}
			else if (txtDOB.getText().equals("")){
				nextFail = "Y";
			}
			else if (txtPhoneNumber.getText().equals("")){
				nextFail = "Y";
			}
			else if (txtEmail.getText().equals("")){
				nextFail = "Y";
			}
			int numberCheck = 0;
			try{
				numberCheck = Integer.parseInt(txtPhoneNumber.getText());
			} catch (NumberFormatException ex){	
			}

			if (nextFail.equals("N")){
				data_Storage setData = new data_Storage();
				setData.setAddress(txtAddress.getText());
				setData.setFullName(txtFullName.getText());
				setData.setDOB(txtDOB.getText());
				setData.setPhoneNumber(numberCheck);
				setData.setEmail(txtEmail.getText());
				new Your_driver_details();
			}
			else if (nextFail.equals("Y")){
				lblError = new JLabel("Required to enter values in all fields");
				lblError.setBounds(350,200,220,170);
				lblError.setForeground(Color.RED);
				panel.add(lblError);
				panel.repaint();
			}

		}
	}
	class HomeHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			new Speeding_ticket_GUI();
			frame.dispose();
		}
	}
	public static void main(String[] args) {
		new Your_personal_details_GUI();


	}

}

