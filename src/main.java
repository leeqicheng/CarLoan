import java.awt.*;
import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class main {
	
	static JButton jbClear , jbCalculate;
	
	//Creating new window 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mainGui;
		JPanel btm_btn , top_title , center_content;
		JLabel top_title_label , bottom_title;
		
		mainGui = new JFrame();
		mainGui.setTitle("Car Loan Calculator");
		mainGui.setSize(400 ,300);
		mainGui.setLayout(new BorderLayout());
		mainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set Top Title 
		top_title = new JPanel();
		top_title.setLayout(new FlowLayout(FlowLayout.CENTER));
		top_title_label = new JLabel("Car Loan Calculator");
		top_title_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		top_title.add(top_title_label);
		
		
		// Set footer credits
		btm_btn = new JPanel();
		btm_btn.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottom_title = new JLabel("Created by xxx:");
		bottom_title.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btm_btn.add(bottom_title);
		
		
		
		//Center content
		
		center_content = new JPanel();
		center_content.setLayout(new GridLayout(7, 2));
		JLabel jlamt = new JLabel("Loan Amount:");
		JTextField jtlamt = new JTextField(10);
		JLabel jir = new JLabel("Interst Rate %:");
		JTextField 	jtir = new JTextField(10);
		JLabel jmonth = new JLabel("Duration (months):");
		JTextField	jtmonth = new JTextField(10);
		JLabel jreferral = new JLabel("Referral");
		JRadioButton jrbReferral_1 = new JRadioButton("Yes");
		JRadioButton jrbReferral_2 = new JRadioButton("No");
		ButtonGroup bg = new ButtonGroup();
		jrbReferral_1.setHorizontalAlignment(AbstractButton.CENTER);
		jrbReferral_2.setHorizontalAlignment(AbstractButton.CENTER);
		bg.add(jrbReferral_1);
		bg.add(jrbReferral_2);		
		jrbReferral_2.setSelected(true);
		
		JPanel referall_grid_view = new JPanel();
		referall_grid_view.setLayout(new GridLayout(1, 2));
		referall_grid_view.add(jrbReferral_1);
		referall_grid_view.add(jrbReferral_2);
		
		
		JLabel j_empty_btn = new JLabel("");
		JPanel j_btn_panel = new JPanel();
		jbCalculate = new JButton("Calculate");
		jbClear = new JButton("Clear");   
		j_btn_panel.add(jbCalculate);
		j_btn_panel.add(jbClear);
			
		JLabel jmonthly= new JLabel("Monthly payment");
		JTextField jtmonthly = new JTextField(10);
		jtmonthly.setText("0");
		jtmonthly.setEnabled(false);
		
		JLabel jtotalpayment = new JLabel("Total payment");
		JTextField jttotalpayment= new JTextField(10);
		jttotalpayment.setText("0");
		jttotalpayment.setEnabled(false);
		
		center_content.add(jlamt);
		center_content.add(jtlamt);
		center_content.add(jir);
		center_content.add(jtir);
		center_content.add(jmonth);
		center_content.add(jtmonth);
		center_content.add(jreferral);
		center_content.add(referall_grid_view);
		center_content.add(j_empty_btn);
		center_content.add(j_btn_panel);
		center_content.add(jmonthly);
		center_content.add(jtmonthly);
		center_content.add(jtotalpayment);
		center_content.add(jttotalpayment);

		//Calculator button
		jbCalculate.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	if(jtlamt.getText().equals("") || jtir.getText().equals("") || jtmonth.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "Please Fill in all the blanks before submitting", "InfoBox: " + "Error !", JOptionPane.ERROR_MESSAGE);
            	}
            	else {
	        		double loan = Double.parseDouble(jtlamt.getText());
	        		double interest = Double.parseDouble(jtir.getText());
	        		int month = Integer.parseInt(jtmonth.getText());
	        		
	            	//If Referral is true
	            	if(!jrbReferral_2.isSelected()) {
	            		
	            		interest = interest - 0.5 ;
	            		double totalresult = (loan * ((interest/100)/12)) / (1 - Math.pow((1 + ((interest/100)/12) ), -month));
	            		String result = String.format("%.2f", totalresult);
	            		jtmonthly.setText(result);
	            		String result1 = String.format("%.2f", totalresult * month);
	            		jttotalpayment.setText(result1);
	            	}
	            	else {
	            		
	            		double totalresult = (loan * ((interest/100)/12)) / (1 - Math.pow((1 + ((interest/100)/12) ), -month));
	            		String result = String.format("%.2f", totalresult);
	            		jtmonthly.setText(result);
	            		String result1 = String.format("%.2f", totalresult * month);
	            		jttotalpayment.setText(result1);
	            	}
	            }
            }
        });   
		
		// Clear button Listerner 
		jbClear.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	jtlamt.setText("");
            	jtir.setText("");
            	jtmonth.setText("");
            	jrbReferral_2.setSelected(true);
            	jtmonthly.setText("0");
            	jttotalpayment.setText("0");
            }
        });   
		
		
		mainGui.add(top_title, BorderLayout.NORTH);
		mainGui.add(center_content, BorderLayout.CENTER);
		mainGui.add(btm_btn, BorderLayout.SOUTH);
		mainGui.setVisible(true);
		mainGui.setResizable(false);
	}
}
