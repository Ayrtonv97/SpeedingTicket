package gui;

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

public class Letter_confirmation_GUI {
	private JFrame frame;
	private JPanel panel;
	private JLabel lblTitle;
	private JLabel lblConfirm;
	private JLabel lblConfirm2;
	private JButton btnExit;
	private data_Storage getData = new data_Storage();

	public Letter_confirmation_GUI(){
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
		lblTitle = new JLabel ("Letter confirmation");
		lblTitle.setBounds(150,40,180,100);
		Font font1 = new Font ("Ariel", Font.BOLD, 18);
		lblTitle.setFont(font1);
		panel.add(lblTitle);

		lblConfirm = new JLabel ("You were caught travelling at " + getData.getCarSpeed() + " in a " + getData.getSpeedLimit() + " zone. ");
		lblConfirm.setBounds(165,120,600,150);
		
		lblConfirm2 = new JLabel ("You are fined " + getData.getfine() + " please pay this fine in 28 days. ");
		lblConfirm2.setBounds(150,140,600,150);
		
		panel.add(lblConfirm2);
		panel.add(lblConfirm);
	}
	public void addButtons(){
		btnExit = new JButton ("Exit");
		btnExit.setBounds(150,350,170,30);
		btnExit.setBackground(Color.blue);
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ExitHandler());
		panel.add(btnExit);
	}
	class ExitHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			new Speeding_ticket_GUI();
			frame.dispose();
		}
	}
	public static void main(String[] args) {
		new Letter_confirmation_GUI();

	}

}
