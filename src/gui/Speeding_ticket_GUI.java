package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class Speeding_ticket_GUI {
	private JFrame frame;
	private JPanel panel;
	private JLabel lblTitle;
	private JButton btnEnter_your_details, btnPayment_for_fine;

	public Speeding_ticket_GUI(){
		createForm();
		addFields();
		addButtons();

		frame.add(panel);
		frame.setVisible(true);
	}
	public void createForm(){

		frame = new JFrame("Speeding ticket");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);

	}
	public void addFields(){
		Font font1 = new Font ("Ariel", Font.BOLD, 18);
		lblTitle = new JLabel ("Speeding ticket");
		lblTitle.setBounds(150,40,150,100);
		panel.add(lblTitle);
		lblTitle.setFont(font1);
	}
	public void addButtons(){
		btnEnter_your_details = new JButton ("Enter your details");
		btnEnter_your_details.setBounds (150, 150, 175, 40);
		btnEnter_your_details.addActionListener(new NextHandler());
		btnEnter_your_details.setBackground(Color.blue);
		btnEnter_your_details.setForeground(Color.WHITE);
		panel.add(btnEnter_your_details);

		btnPayment_for_fine = new JButton ("Payment for fine");
		btnPayment_for_fine.setBounds(150, 200, 175, 40);
		btnPayment_for_fine.addActionListener(new NextHandler3());
		btnPayment_for_fine.setBackground(Color.blue);
		btnPayment_for_fine.setForeground(Color.WHITE);
		panel.add(btnPayment_for_fine);

	}
	class NextHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			new Your_personal_details_GUI();
			frame.dispose();
		}
	}
	class NextHandler3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			new Payment_for_ticket_GUI();
			frame.dispose();
		}
	}
	public static void main(String[] args) {
		new Speeding_ticket_GUI();
		
	}
}

