package gui;

import logic.Calculation;
import logic.data_Storage;
import logic.letterGenerator;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class Payment_for_ticket_GUI {
	private JFrame frame;
	private JPanel panel;
	private JLabel lblTitle;
	private JLabel lblRegistration;
	private JLabel lblCarSpeed;
	private JLabel lblSpeedLimit;
	private JLabel lblError;
	private JTextField txtRegistration;
	private JTextField txtCarSpeed;
	private JTextField txtSpeedLimit;
	private JButton btnHome;
	private JButton btnContinue;
	private String fine;
	Calculation getCalculation = new Calculation();
	data_Storage setData = new data_Storage();

	public Payment_for_ticket_GUI(){
		createForm();
		addFields();
		addButtons();

		frame.add(panel);
		frame.setVisible(true);
	}
	public void createForm(){
		frame = new JFrame ("Your driver details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
	}
	public void addFields(){
		lblTitle = new JLabel ("Payment for ticket");
		lblTitle.setBounds(150,80,180,100);
		Font font1 = new Font ("Ariel", Font.BOLD, 18);
		lblTitle.setFont(font1);
		panel.add(lblTitle);

		lblRegistration = new JLabel ("Registration");
		lblRegistration.setBounds(150,200,175,40);
		panel.add(lblRegistration);

		lblCarSpeed = new JLabel ("Car speed");
		lblCarSpeed.setBounds(150,250,175,40);
		panel.add(lblCarSpeed);

		lblSpeedLimit = new JLabel ("Speed limit");
		lblSpeedLimit.setBounds(150,300,175,40);
		panel.add(lblSpeedLimit);

		lblError = new JLabel ("");
		lblError.setBounds(268,400,120,35);
		lblError.setForeground(Color.red);
		panel.add(lblError);

		txtRegistration = new JTextField();
		txtRegistration.setBounds(225,209,100,25);
		panel.add(txtRegistration);

		txtCarSpeed = new JTextField();
		txtCarSpeed.setBounds(225,260,100,25);
		panel.add(txtCarSpeed);

		txtSpeedLimit = new JTextField();
		txtSpeedLimit.setBounds(225,308,100,25);
		panel.add(txtSpeedLimit);

	}
	public void addButtons(){

		btnContinue = new JButton ("Continue");
		btnContinue.setBounds (230,360,120,30);
		btnContinue.addActionListener(new ContinueHandler());
		btnContinue.setBackground(Color.blue);
		btnContinue.setForeground(Color.WHITE);
		panel.add(btnContinue);

		btnHome = new JButton ("Home");
		btnHome.setBounds(20,25,100,35);
		btnHome.setBackground(Color.blue);
		btnHome.setForeground(Color.WHITE);
		btnHome.addActionListener(new HomeHandler());
		panel.add(btnHome);

	}

	class HomeHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			new Speeding_ticket_GUI();
			frame.dispose();
		}
	}
	class ContinueHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			

			fine = getCalculation.fineCalculation(txtCarSpeed.getText(), txtSpeedLimit.getText());

			if(!fine.equals("error")){ //Done when no error
				setData.setCarSpeed(txtCarSpeed.getText());
				setData.setSpeedLimit(txtSpeedLimit.getText());
				setData.setRegistration(txtRegistration.getText());
				setData.setFine(fine);
				new Letter_confirmation_GUI();
				
				try {
					new letterGenerator();
				} catch (IOException ex) {
				}
			}
			if(fine.equals("error")){ //Done when error
				txtSpeedLimit.setBackground(Color.red);
				txtCarSpeed.setBackground(Color.red);
				lblError.setText("Please check data");
				
			}
		}
	}
	public static void main(String[] args) {
		new Payment_for_ticket_GUI();

	}
}
