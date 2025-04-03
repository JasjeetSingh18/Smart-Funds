import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterestCalculator extends AppData {

	private static final long serialVersionUID = 1L;
	
	//Calculate total return on an interest investment 
	static void CalculateInvestmentReturn () {
		investmentInterestRate = investmentInterestRate/100;
		totalInvestmentReturn = initialInvestment * (Math.pow ((1 + (investmentInterestRate / compoundFrequency)), (investmentLength * compoundFrequency)));
		totalInvestmentReturn = totalInvestmentReturn + (monthlyContribution * (((Math.pow ((1 + (investmentInterestRate / compoundFrequency)), (investmentLength * compoundFrequency))) - 1)) / (investmentInterestRate/compoundFrequency));
		investmentInterestRate = investmentInterestRate * 100;
	}
	
	static double returnOnInvestment = 0;
	
	static void calculatorReturnOnInvestment () {
		returnOnInvestment = ((totalInvestmentReturn - initialInvestment) / initialInvestment) * 100;
	}
	
	/**
	 * Create the panel.
	 */
	public InterestCalculator() {
		setBounds (0, 0, 1300, 700);
		setBackground(AppData.backgroundColour);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 122, 1300, 20);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 244, 1300, 20);
		add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 366, 1300, 20);
		add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 488, 1300, 20);
		add(separator_1_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(0, 610, 1300, 20);
		add(separator_1_1_1_1);
		
		JLabel lblNewLabel2_1 = new JLabel("Initial Investment:");
		lblNewLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2_1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel2_1.setBounds(0, 0, 650, 125);
		add(lblNewLabel2_1);
		
		JLabel lblNewLabel2_2 = new JLabel("Monthly Contribution:");
		lblNewLabel2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2_2.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel2_2.setBounds(0, 122, 650, 125);
		add(lblNewLabel2_2);
		
		JLabel lblNewLabel2_3 = new JLabel("Investment Length:");
		lblNewLabel2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2_3.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel2_3.setBounds(0, 244, 650, 125);
		add(lblNewLabel2_3);
		
		JLabel lblNewLabel2_4 = new JLabel("Annual Interest Rate:");
		lblNewLabel2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2_4.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel2_4.setBounds(0, 366, 650, 125);
		add(lblNewLabel2_4);
		
		JLabel lblNewLabel2_5 = new JLabel("Compound Frequency:");
		lblNewLabel2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2_5.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel2_5.setBounds(0, 488, 650, 125);
		add(lblNewLabel2_5);
		
		JSpinner initialValueSpinner = new JSpinner();
		initialValueSpinner.setModel(new SpinnerNumberModel(AppData.initialInvestment, 0, 999999999, 100));
		initialValueSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		initialValueSpinner.setBounds(817, 29, 400, 66);
		add(initialValueSpinner);
		
		JSpinner monthlyContributionSpinner = new JSpinner();
		monthlyContributionSpinner.setModel(new SpinnerNumberModel(AppData.monthlyContribution, 0, 999999999, 100));
		monthlyContributionSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		monthlyContributionSpinner.setBounds(817, 151, 400, 66);
		add(monthlyContributionSpinner);
		
		JSpinner investmentLengthSpinner = new JSpinner();
		investmentLengthSpinner.setModel(new SpinnerNumberModel(AppData.investmentLength, 1, 100, 1));
		investmentLengthSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		investmentLengthSpinner.setBounds(817, 270, 400, 66);
		add(investmentLengthSpinner);
		
		JSpinner interestRateSpinner = new JSpinner();
		interestRateSpinner.setModel(new SpinnerNumberModel(AppData.investmentInterestRate, 0.0, 100.0, 0.5));
		interestRateSpinner.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		interestRateSpinner.setBounds(817, 391, 400, 66);
		add(interestRateSpinner);
		
		JComboBox<String> compoundFreqComboBox = new JComboBox<String>();
		compoundFreqComboBox.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		compoundFreqComboBox.setMaximumRowCount(5);
		compoundFreqComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Annually", "Semi-annually", "Quarterly", "Monthly", "Daily"}));
		compoundFreqComboBox.setSelectedIndex(0);
		compoundFreqComboBox.setBounds(817, 520, 400, 66);
		add(compoundFreqComboBox);
		
		//Determine if a previous value for compoundFreq has been set
		if (AppData.compoundFrequency == 2) {
			compoundFreqComboBox.setSelectedItem("Semi-annually");
		}
		else if (AppData.compoundFrequency == 4) {
			compoundFreqComboBox.setSelectedItem("Quarterly");
		}
		else if (AppData.compoundFrequency == 12) {
			compoundFreqComboBox.setSelectedItem("Monthly");
		}
		else if (AppData.compoundFrequency == 365) {
			compoundFreqComboBox.setSelectedItem("Daily");
		}
		else {
			compoundFreqComboBox.setSelectedItem("Annually");
		}
		
		JLabel lblNewLabel1 = new JLabel("CAD $");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel1.setForeground(Color.BLACK);
		lblNewLabel1.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel1.setBackground(Color.WHITE);
		lblNewLabel1.setBounds(671, 31, 140, 66);
		add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("CAD $");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel2.setForeground(Color.BLACK);
		lblNewLabel2.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel2.setBackground(Color.WHITE);
		lblNewLabel2.setBounds(671, 153, 140, 66);
		add(lblNewLabel2);
		
		JLabel lblNewLabel3 = new JLabel("Years");
		lblNewLabel3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel3.setForeground(Color.BLACK);
		lblNewLabel3.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel3.setBackground(Color.WHITE);
		lblNewLabel3.setBounds(671, 272, 140, 66);
		add(lblNewLabel3);
		
		JLabel lblNewLabel4 = new JLabel("%");
		lblNewLabel4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel4.setForeground(Color.BLACK);
		lblNewLabel4.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		lblNewLabel4.setBackground(Color.WHITE);
		lblNewLabel4.setBounds(671, 391, 140, 66);
		add(lblNewLabel4);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Gather all information entered on the screen and set it to the according variables
				AppData.initialInvestment = (int) initialValueSpinner.getValue();
				AppData.monthlyContribution = (int) monthlyContributionSpinner.getValue();
				AppData.investmentLength = (int) investmentLengthSpinner.getValue();
				AppData.investmentInterestRate = (double) interestRateSpinner.getValue();
				
				//Determine if any of the values entered are equal to 0 to prevent the calculations from crashing
				if (AppData.initialInvestment == 0 || AppData.investmentLength == 0 || AppData.investmentInterestRate == 0) {
					JOptionPane.showMessageDialog (null, "One of the values you have entered is equal to 0. Please enter a valid value greater than 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//Determine the compound Frequency
					String selectedCompoundFreq = (String) compoundFreqComboBox.getSelectedItem();
					if (selectedCompoundFreq.equals("Annually")) {
						AppData.compoundFrequency = 1;
					} 
					else if (selectedCompoundFreq.equals("Semi-annually")) {
						AppData.compoundFrequency = 2;
					}
					else if (selectedCompoundFreq.equals("Quarterly")) {
						AppData.compoundFrequency = 4;
					} 
					else if (selectedCompoundFreq.equals("Monthly")) {
						AppData.compoundFrequency = 12;
					}
					else {
						AppData.compoundFrequency = 365;
					}
					
					//Perform Calculation (Call on the calculateInvestmentReturn method and the ROI)
					CalculateInvestmentReturn();
					calculatorReturnOnInvestment();
					
					
					//Determine if the totalInvestmentReturn is too big of a number for the output to handle
					if (totalInvestmentReturn > 999999999) {
						JOptionPane.showMessageDialog (null, "Your Investment will be valued over " + AppData.currency + "999,999,999. Please enter realistic investment values.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else {
						//Hide current panel
						AppData.interestPanel.setVisible(false);
						
						//determine if a interest output panel has already been created
						if (AppData.interestOutputPanel == null) {
							AppData.interestOutputPanel = new InterestCalculator_Output ();
							
							//Display the created interest panel
							AppData.interestOutputPanel.setBounds(0, 180, 1300, 700);
							AppData.mainFrame.getContentPane().add(AppData.interestOutputPanel);
						}
						else {
							//Update the interest Output Panel with the new results
							InterestCalculator_Output.numberOfYearsLabel.setText(AppData.investmentLength + " year(s)");
							InterestCalculator_Output.investmentValueLabel.setText(AppData.currency + AppData.df.format(AppData.totalInvestmentReturn));
							InterestCalculator_Output.moneyEarnedOnInvestmentLabel.setText(AppData.currency + AppData.df.format(AppData.totalInvestmentReturn - AppData.initialInvestment));
							
							//Show the interest output Panel with the new results
							AppData.interestOutputPanel.setVisible(true);
						}
						
						if (InterestCalculator.returnOnInvestment >= 10.0) { 
							InterestCalculator_Output.lblOnYourInvestment_1.setText("<html><center>After revewing your investment, it has been decided that it is considered to be a strong investment. It is highly recommended that you invest.</html>");
						}
						else if (InterestCalculator.returnOnInvestment >= 6.0 ) { 
							InterestCalculator_Output.lblOnYourInvestment_1.setText("<html><center>After revewing your investment, it has been decided that it is considered to be a good investment. It is recommended that you invest.</html>");
						}
						else if (InterestCalculator.returnOnInvestment < 6.0 ) { 
							InterestCalculator_Output.lblOnYourInvestment_1.setText("<html><center>After revewing your investment, it has been decided that it is considered to be a week investment. It is recommended that you do not invest.</html>");
						}
						
						//Set visibility variables accordingly
						AppData.interestVisibility = false;
						AppData.interestOutputVisibility = true;
					}
				}
			}
		});
		calculateButton.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		calculateButton.setBounds(819, 626, 280, 56);
		add(calculateButton);
		
		//Button to clear all the JSpinners and the Radio Button
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set all interest calculating variables to 0
				AppData.initialInvestment = 0;
				AppData.monthlyContribution = 0;
				AppData.investmentLength = 1;
				AppData.investmentInterestRate = 0.0;
				
				//Set all spinners to their initial value
				initialValueSpinner.setValue(0);
				monthlyContributionSpinner.setValue(0);
				investmentLengthSpinner.setValue(1);
				interestRateSpinner.setValue(0.0);
				
				//Set the ComboBox to the default selection
				compoundFreqComboBox.setSelectedItem("Annually");;
			}
		});
		resetButton.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize));
		resetButton.setBounds(199, 626, 280, 56);
		add(resetButton);
	}
}
