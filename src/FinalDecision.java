import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalDecision extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	static JLabel finalDecision;
	static double percentOfPayment;

	/**
	 * Create the panel.
	 */
	public FinalDecision() {
		setBounds (0, 0, 1300, 700);
		setBackground(AppData.backgroundColour);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(325, 64, 650, 16);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(325, 625, 650, 16);
		add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(325, 64, 34, 563);
		add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBounds(975, 64, 34, 563);
		add(separator_1_1_1);
		
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hide interest Output panel
				AppData.interestOutputPanel.setVisible(false);
				AppData.interestOutputVisibility = false;
				
				//Show Home Screen
				AppData.homePanel.setVisible(true);
				MenuTitleBar.currentPanelLabel.setText("Home");
			}
		});
		homeButton.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		homeButton.setBounds(1016, 606, 266, 68);
		add(homeButton);
		
		finalDecision = new JLabel();
		finalDecision.setHorizontalAlignment(SwingConstants.CENTER);
		finalDecision.setFont(new Font("Serif", Font.PLAIN, 25));
		finalDecision.setBounds(325, 192, 650, 344);
		add(finalDecision);
		
		percentOfPayment = (double) ((AppData.mortgageCostPerPayment/userInput.enteredSalary) * 100);
		
		if (userInput.selectedExpense.equals("Car")) {
			if (percentOfPayment >= 20.0) {
				finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your car, it is recommended that you do not continue with this mortgage as it would be really hard to pay for your other expenses.<html>");
			}
			else {
				finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your car, it is recommended that you continue with this mortgage.<html>");
			}
		}
		else if (userInput.selectedExpense.equals("Rent")) {
			if (percentOfPayment >= 40.0) {
				finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you do not continue with this mortgage as it would be really hard to pay for your other expenses.<html>");
			}
			else {
				finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you continue with this mortgage.<html>");
			}
		}
		else {
			if (percentOfPayment >= 20.0) {
				finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you do not continue with this mortgage as it would be really hard to pay for your other expenses.<html>");
			}
			else {
				finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you continue with this mortgage.<html>");
			}
		}
		
		//Hides the current panel
		AppData.hideCurrentPanel();
	
		//Determine if a Mortgage Calculator panel has already been created
		if (AppData.mortgagePanel == null) {
			AppData.mortgagePanel = new MortgageCalculator();
			
			//Display the settings panel
			AppData.mortgagePanel.setBounds(0, 180, 1300, 700);
			AppData.mainFrame.getContentPane().add(AppData.mortgagePanel);
		}
		else {
			//Display the Settings screen panel if there is one created already 
			AppData.mortgagePanel.setVisible(true);
		}
		
		//set visible variables accordingly
		AppData.mortgageVisibility = true;
		MenuTitleBar.currentPanelLabel.setText("Mortgage Calculator");
		
	}
}