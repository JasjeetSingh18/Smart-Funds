import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterestCalculator_Output extends JPanel {

	//Declare JLabels for the output of the interest Calculator (Allows the interest Panel to access these labels)
	static JLabel numberOfYearsLabel, investmentValueLabel, moneyEarnedOnInvestmentLabel;
	
	private static final long serialVersionUID = 1L;
	
	static JLabel lblOnYourInvestment_1;

	/**
	 * Create the panel.
	 */
	public InterestCalculator_Output() {
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
		
		numberOfYearsLabel = new JLabel(AppData.investmentLength + " year(s)");
		numberOfYearsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfYearsLabel.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize + 5));
		numberOfYearsLabel.setBounds(325, 104, 650, 77);
		add(numberOfYearsLabel);
		
		JLabel lblNewLabel = new JLabel("Your investment in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblNewLabel.setBounds(325, 64, 650, 77);
		add(lblNewLabel);
		
		JLabel lblWillBeValued = new JLabel("will be valued at:");
		lblWillBeValued.setHorizontalAlignment(SwingConstants.CENTER);
		lblWillBeValued.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblWillBeValued.setBounds(325, 162, 650, 77);
		add(lblWillBeValued);
		
		investmentValueLabel = new JLabel(AppData.currency + AppData.df.format(AppData.totalInvestmentReturn));
		investmentValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		investmentValueLabel.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize + 5));
		investmentValueLabel.setBounds(324, 210, 650, 77);
		add(investmentValueLabel);
		
		JLabel lblOnYourInvestment = new JLabel("On your Investment, you gained a total of");
		lblOnYourInvestment.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnYourInvestment.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize + 5));
		lblOnYourInvestment.setBounds(325, 275, 650, 77);
		add(lblOnYourInvestment);
		
		moneyEarnedOnInvestmentLabel = new JLabel(AppData.currency + AppData.df.format(AppData.totalInvestmentReturn - AppData.initialInvestment));
		moneyEarnedOnInvestmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyEarnedOnInvestmentLabel.setFont(new Font(AppData.font, Font.BOLD, AppData.fontSize + 5));
		moneyEarnedOnInvestmentLabel.setBounds(325, 321, 650, 77);
		add(moneyEarnedOnInvestmentLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hide output Panel
				AppData.interestOutputPanel.setVisible(false);
				AppData.interestOutputVisibility = false;
				
				//Show the interest Calculator screen
				AppData.interestPanel.setVisible(true);
				AppData.interestVisibility = true;
			}
		});
		backButton.setFont(new Font(AppData.font, Font.PLAIN, AppData.fontSize));
		backButton.setBounds(17, 606, 266, 68);
		add(backButton);
		
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
		
		lblOnYourInvestment_1 = new JLabel();
		lblOnYourInvestment_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnYourInvestment_1.setFont(new Font("Serif", Font.PLAIN, 25));
		lblOnYourInvestment_1.setBounds(325, 435, 650, 179);
		add(lblOnYourInvestment_1);
		
		
	}
}
