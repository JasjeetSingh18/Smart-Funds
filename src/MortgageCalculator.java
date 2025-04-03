import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MortgageCalculator extends AppData {

	private static final long serialVersionUID = 1L;
	
	//Calculate total payment value per payment
	public void calculateMortgagePayment () { 
		mortgageInterestRate = mortgageInterestRate/100.0;
		mortgageCostPerPayment = (((mortgageValue * (mortgageInterestRate / paymentFrequency)) * Math.pow((1 + (mortgageInterestRate / paymentFrequency)), (paymentFrequency * amortizationPeriod))) / (Math.pow((1 + (mortgageInterestRate / paymentFrequency)), (paymentFrequency * amortizationPeriod)) - 1));
	}
	
	//Calculate the total interest payed for a mortgage 
	public void calculateInterestPayed () { 
		totalInterestPayed = (mortgageCostPerPayment * (paymentFrequency * amortizationPeriod)) - mortgageValue;
	}	
	
	/**
	 * Create the panel.
	 */
	public MortgageCalculator() {
		setBounds (0, 0, 1300, 700);
		setBackground(AppData.backgroundColour);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(691, 0, 43, 700);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Mortgage Amount:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel.setBounds(0, 31, 692, 37);
		add(lblNewLabel);
		
		//Spinner to get the value of the mortgage
		JSpinner mortgageValueSpinner = new JSpinner();
		mortgageValueSpinner.setModel(new SpinnerNumberModel(AppData.mortgageValue, 0, 999999999, 1000));
		mortgageValueSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		mortgageValueSpinner.setBounds(196, 76, 325, 62);
		add(mortgageValueSpinner);
		
		JLabel lblNewLabel_1 = new JLabel(AppData.currency);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(49, 75, 140, 62);
		add(lblNewLabel_1);
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestRate.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblInterestRate.setBounds(0, 179, 692, 37);
		add(lblInterestRate);
		
		JLabel lblNewLabel_1_1 = new JLabel("%");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(49, 223, 140, 62);
		add(lblNewLabel_1_1);
		
		//Spinner to get the interest rate
		JSpinner interestRateSpinner = new JSpinner();
		interestRateSpinner.setModel(new SpinnerNumberModel(mortgageInterestRate * 100, 0.0, 100.0, 0.5));
		interestRateSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		interestRateSpinner.setBounds(196, 224, 330, 62);
		add(interestRateSpinner);
		
		JLabel lblAmortizationPeriod = new JLabel("Amortization Period");
		lblAmortizationPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmortizationPeriod.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblAmortizationPeriod.setBounds(0, 335, 692, 37);
		add(lblAmortizationPeriod);
		
		//Spinner to get the amortization period
		JSpinner amortizationSpinner = new JSpinner();
		amortizationSpinner.setModel(new SpinnerNumberModel(AppData.amortizationPeriod, 0, 100, 1));
		amortizationSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		amortizationSpinner.setBounds(196, 382, 330, 62);
		add(amortizationSpinner);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Years");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(32, 381, 157, 62);
		add(lblNewLabel_1_1_1);
		
		JLabel lblPaymentFrequency = new JLabel("Payment Frequency");
		lblPaymentFrequency.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentFrequency.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblPaymentFrequency.setBounds(0, 493, 692, 37);
		add(lblPaymentFrequency);
		
		JRadioButton WeeklyButton = new JRadioButton("Weekly");
		WeeklyButton.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		WeeklyButton.setHorizontalAlignment(SwingConstants.LEFT);
		WeeklyButton.setBounds(32, 562, 167, 37);
		add(WeeklyButton);
		
		JRadioButton BiweeklyButton = new JRadioButton("Bi-weekly");
		BiweeklyButton.setHorizontalAlignment(SwingConstants.LEFT);
		BiweeklyButton.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		BiweeklyButton.setBounds(265, 562, 167, 37);
		add(BiweeklyButton);
		
		JRadioButton MonthlyButton = new JRadioButton("Monthly");
		MonthlyButton.setHorizontalAlignment(SwingConstants.LEFT);
		MonthlyButton.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		MonthlyButton.setBounds(498, 562, 167, 37);
		add(MonthlyButton);
		
		//Invisible Radio button to make it seem like no option is selected
		JRadioButton InvisibleButton = new JRadioButton(""); 
		
		//Create a button group to get the payment Frequency
		ButtonGroup paymentFrequencyBtnGroup = new ButtonGroup();
		paymentFrequencyBtnGroup.add(MonthlyButton);
		paymentFrequencyBtnGroup.add(BiweeklyButton);
		paymentFrequencyBtnGroup.add(WeeklyButton);
		paymentFrequencyBtnGroup.add(InvisibleButton);
		
		//Determine if a previous value has been set for the payment frequency
		if (AppData.paymentFrequency == 12) {
			MonthlyButton.doClick();
		}
		else if (AppData.paymentFrequency == 26) {
			BiweeklyButton.doClick();
		}
		else if (AppData.paymentFrequency == 52) {
			WeeklyButton.doClick();
		}
		else {
			InvisibleButton.doClick();
		}
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 472, 691, 10);
		add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 318, 691, 10);
		add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(1, 162, 691, 10);
		add(separator_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Amount:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel_2.setBounds(691, 102, 609, 37);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Number of payments:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel_2_1.setBounds(691, 278, 609, 37);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total interest cost:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel_2_1_1.setBounds(691, 464, 609, 37);
		add(lblNewLabel_2_1_1);
		
		//Output for the payment value per payment
		JLabel mortgagePaymentOutput = new JLabel(AppData.currency + AppData.df.format (mortgageCostPerPayment) + " per payment");
		mortgagePaymentOutput.setHorizontalAlignment(SwingConstants.CENTER);
		mortgagePaymentOutput.setForeground(new Color(0, 0, 0));
		mortgagePaymentOutput.setBackground(new Color(255, 255, 255));
		mortgagePaymentOutput.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		mortgagePaymentOutput.setBounds(694, 167, 606, 62);
		add(mortgagePaymentOutput);
		
		//Output for the total number of payments that will be made
		JLabel totalPaymentsOutput = new JLabel(paymentFrequency * amortizationPeriod + " Payments ");
		totalPaymentsOutput.setForeground(new Color(0, 0, 0));
		totalPaymentsOutput.setHorizontalAlignment(SwingConstants.CENTER);
		totalPaymentsOutput.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		totalPaymentsOutput.setBackground(Color.WHITE);
		totalPaymentsOutput.setBounds(691, 352, 609, 62);
		add(totalPaymentsOutput);
		
		//Output for the total interest payed on the mortgage
		JLabel interestPayedOutput = new JLabel(AppData.currency + AppData.df.format (totalInterestPayed) + " in interest payed");
		interestPayedOutput.setForeground(new Color(0, 0, 0));
		interestPayedOutput.setHorizontalAlignment(SwingConstants.CENTER);
		interestPayedOutput.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		interestPayedOutput.setBackground(Color.WHITE);
		interestPayedOutput.setBounds(691, 537, 609, 62);
		add(interestPayedOutput);
		
		//Button to calculate the results
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Receive values from the spinners and set it to the according variable
				mortgageValue = (int) mortgageValueSpinner.getValue();
				mortgageInterestRate = (double) interestRateSpinner.getValue();
				amortizationPeriod = (int) amortizationSpinner.getValue();
				
				//Determine if the values entered in the JSpinners are greater than 0 before calculating
				if (AppData.mortgageValue == 0 || AppData.mortgageInterestRate == 0 || (int) AppData.amortizationPeriod == 0) {
					//Display an error message if the values entered are equal to 0
					JOptionPane.showMessageDialog (null, "One of the values you have entered is equal to 0. Please enter a valid value greater than 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//Determine which JRadioButton is selected
					if (WeeklyButton.isSelected()) {
						paymentFrequency = 52;
						
					} else if (BiweeklyButton.isSelected()) {
						paymentFrequency = 26;
						
					} else if (MonthlyButton.isSelected()){
						paymentFrequency = 12;
					}
					else {
						JOptionPane.showMessageDialog (null, "You have not selected the payment frequency. The answers displayed is calculated for a monthly mortgage plan.", "WARNING", JOptionPane.WARNING_MESSAGE);
						paymentFrequency = 12;
					}
					
					//Perform the calculations for the payment amount per month and the total interest you will need to pay for the mortgage 
					calculateMortgagePayment();
					calculateInterestPayed();
					
					//Update the text on the output side to show the new calculated values
					mortgagePaymentOutput.setText(AppData.currency + AppData.df.format (mortgageCostPerPayment) + " per payment");
					totalPaymentsOutput.setText(paymentFrequency * amortizationPeriod + " Payments ");
					interestPayedOutput.setText(AppData.currency + AppData.df.format (totalInterestPayed) + " in interest payed");
				}
			}
		});
		calculateButton.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		calculateButton.setBounds(498, 623, 166, 55);
		add(calculateButton);
		
		//Button to clear all the spinners and the radio buttons
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sets all variables for calculating the mortgage to 0
				mortgageValue = 0;
				mortgageInterestRate = 0;
				amortizationPeriod = 0;
				paymentFrequency = 0;
				
				//Setting all spinners to a value of 0
				mortgageValueSpinner.setValue(0);
				interestRateSpinner.setValue(0);
				amortizationSpinner.setValue(0);
				
				//Setting all result variables to 0 and change the output accordingly
				mortgageCostPerPayment = 0;
				totalInterestPayed = 0;
				mortgagePaymentOutput.setText(AppData.currency + AppData.df.format (mortgageCostPerPayment) + " per payment");
				totalPaymentsOutput.setText(paymentFrequency * amortizationPeriod + " Payments ");
				interestPayedOutput.setText(AppData.currency + AppData.df.format (totalInterestPayed) + " in interest payed");
				
				//Select the invisible JRadioButton to make it seem that no radio button is selected 
				InvisibleButton.doClick();
			}
		});
		btnReset.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		btnReset.setBounds(32, 623, 166, 55);
		add(btnReset);
		
		JButton calculateButton_1 = new JButton("Continue");
		calculateButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//Hides the current panel
					AppData.hideCurrentPanel();
				
					//Determine if a FinalDecision Panel has already been created
					if (AppData.finalDecisionPanel == null) {
						AppData.finalDecisionPanel = new FinalDecision();
						
						//Display the settings panel
						AppData.finalDecisionPanel.setBounds(0, 180, 1300, 700);
						AppData.mainFrame.getContentPane().add(AppData.finalDecisionPanel);
					}
					else {
						//Display the Settings screen panel if there is one created already 
						AppData.finalDecisionPanel.setVisible(true);
					}
					
					//set visible variables accordingly
					AppData.FinalDecisionVisibility = true;	
			
			if (mortgageCostPerPayment != 0) {
				
				FinalDecision.percentOfPayment = (double) ((AppData.mortgageCostPerPayment/userInput.enteredSalary) * 100);
				
				if (userInput.selectedExpense.equals("Car")) {
					if (FinalDecision.percentOfPayment >= 20.0) {
						FinalDecision.finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your car, it is recommended that you do not continue with this mortgage as it would be really hard to pay for your other expenses.<html>");
					}
					else {
						FinalDecision.finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your car, it is recommended that you continue with this mortgage.<html>");
					}
				}
				else if (userInput.selectedExpense.equals("Rent")) {
					if (FinalDecision.percentOfPayment >= 40.0) {
						FinalDecision.finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you do not continue with this mortgage as it would be really hard to pay for your other expenses.<html>");
					}
					else {
						FinalDecision.finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you continue with this mortgage.<html>");
					}
				}
				else {
					if (FinalDecision.percentOfPayment >= 20.0) {
						FinalDecision.finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you do not continue with this mortgage as it would be really hard to pay for your other expenses.<html>");
					}
					else {
						FinalDecision.finalDecision.setText("<html><center>After reviewing your salary and mortgage payment for your home/appartment, it is recommended that you continue with this mortgage.<html>");
					}
				}
			}
		}
		});
		calculateButton_1.setFont(new Font("Serif", Font.BOLD, 20));
		calculateButton_1.setBounds(1124, 623, 166, 55);
		add(calculateButton_1);
	}
}
