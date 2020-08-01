package logic;

import gui.Speeding_ticket_GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.*;

/**
 * 
 * @author Ayrton
 * Student ID: s4920259	
 * Assignment: Speeding ticket
 */

public class Your_driver_details {
	private JFrame frame;
	private JPanel panel;
	private JLabel lblTitle;
	private JLabel lblTypeOfVehicle;
	private JTextField txtTypeOfVehicle;
	private JLabel lblInsurance;
	private JRadioButton rdbYes;
	private JRadioButton rdbNo;
	private JButton btnHome;
	private JButton btnSubmit;
	private static String YesString = "yes";
	private static String NoString = "no";
	ButtonGroup group = new ButtonGroup();

	public Your_driver_details(){
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
		Font font1 = new Font ("Ariel", Font.BOLD, 18);
		lblTitle = new JLabel ("Your driver details");
		lblTitle.setBounds(150,80,180,100);
		lblTitle.setFont(font1);
		panel.add(lblTitle);

		lblTypeOfVehicle = new JLabel ("Type of vehicle");
		lblTypeOfVehicle.setBounds(150,200,175,40);
		panel.add(lblTypeOfVehicle);

		lblInsurance = new JLabel ("Insurance");
		lblInsurance.setBounds(150,250,175,40);
		panel.add(lblInsurance);

		txtTypeOfVehicle = new JTextField();
		txtTypeOfVehicle.setBounds(250,208,100,25);
		panel.add(txtTypeOfVehicle);
	}

	public void addButtons(){
		btnSubmit = new JButton ("Submit");
		btnSubmit.setBounds (220,350,100,35);
		btnSubmit.setBackground(Color.blue);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.addActionListener(new SubmitHandler());
		panel.add(btnSubmit);

		btnHome = new JButton ("Home");
		btnHome.setBounds(20,25,100,35);
		btnHome.addActionListener(new HomeHandler());
		btnHome.setBackground(Color.blue);
		btnHome.setForeground(Color.WHITE);
		panel.add(btnHome);

		rdbYes = new JRadioButton (YesString);
		rdbYes.setBounds(235,259,100,25);
		rdbYes.setMnemonic(KeyEvent.VK_P);
		rdbYes.setActionCommand(YesString);
		rdbYes.setBackground(Color.GRAY);
		panel.add(rdbYes);

		rdbNo = new JRadioButton (NoString);
		rdbNo.setBounds(235,279,100,25);
		rdbNo.setMnemonic(KeyEvent.VK_P);
		rdbNo.setActionCommand(NoString);
		rdbNo.setBackground(Color.GRAY);
		panel.add(rdbNo);

		group.add(rdbNo);
		group.add(rdbYes);
	}

	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
	}

	class HomeHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			new Speeding_ticket_GUI();
			frame.dispose();
		}
	}
	class SubmitHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			data_Storage setData = new data_Storage();
			setData.setTypeOfVehicle(txtTypeOfVehicle.getText());
			setData.setInsurance(group.getSelection().getActionCommand());
		}
	}
	public static void main(String[] args) {
		new Your_driver_details();

	}

}
