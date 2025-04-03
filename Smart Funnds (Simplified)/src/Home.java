import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public Home() {
		setBackground(AppData.backgroundColour);
		setBounds (0, 0, 1300, 700);
		setLayout(null);
		
		//Add the button to open mortgage Panel 
		JButton mortgageButton = new JButton("Mortgage Calculator");
		mortgageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hides the current panel
				AppData.hideCurrentPanel();
			
				//Determine if a userInput panel has already been created
				if (AppData.userInputPanel == null) {
					AppData.userInputPanel = new userInput();
					
					//Display the settings panel
					AppData.userInputPanel.setBounds(0, 180, 1300, 700);
					AppData.mainFrame.getContentPane().add(AppData.userInputPanel);
				}
				else {
					//Display the Settings screen panel if there is one created already 
					AppData.userInputPanel.setVisible(true);
				}
				
				//set visible variables accordingly
				AppData.userInputVisibility = true;
				MenuTitleBar.currentPanelLabel.setText("Mortgage Calculator");
			}
		});
		mortgageButton.setFont(new Font("Lucida Bright", Font.ITALIC, AppData.fontSize));
		mortgageButton.setForeground(new Color(255, 255, 255));
		mortgageButton.setBackground(new Color(58, 58, 58));
		mortgageButton.setBounds(167, 514, 375, 69);
		add(mortgageButton);
		
		//Add the button to open interest investment Panel 
		JButton investmentButton = new JButton("Investment Calculator");
		investmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hides the current panel
				AppData.hideCurrentPanel();
			
				//Determine if a interest panel has already been created
				if (AppData.interestPanel == null) {
					AppData.interestPanel = new InterestCalculator();
					
					//Display the settings panel
					AppData.interestPanel.setBounds(0, 175, 1300, 700);
					AppData.mainFrame.getContentPane().add(AppData.interestPanel);
				}
				else {
					//Display the Settings screen panel if there is one created already 
					AppData.interestPanel.setVisible(true);
				}
				
				//set visible variables accordingly
				AppData.interestVisibility= true;
				MenuTitleBar.currentPanelLabel.setText("Compound Interest Calculator");
			}
		});
		investmentButton.setFont(new Font("Lucida Bright", Font.ITALIC, AppData.fontSize));
		investmentButton.setForeground(new Color(255, 255, 255));
		investmentButton.setBackground(new Color(58, 58, 58));
		investmentButton.setBounds(769, 514, 375, 69);
		add(investmentButton);
		
		//Declare and set the image for the question mark
		URL url4 = this.getClass().getResource("questionMark.png");
		ImageIcon questionMarkLogo = new ImageIcon(url4);
		Image image4 = questionMarkLogo.getImage().getScaledInstance(40, 39, Image.SCALE_SMOOTH);
		
		//Add the tool tip picture for the mortgage Calculator
		JLabel toolTip_MortgageCalculator = new JLabel("");
		toolTip_MortgageCalculator.setToolTipText("<html>Use this funtion to get an estimate of how much you will be paying per payement,<br>how many payments and how much interest you will be paying on your mortgage payment.<br>You will be promted to enter the initial value of the mortgage, the interest rate,<br>the ammortization period, and the payment frequency.</html>");
		toolTip_MortgageCalculator.setBounds(502, 477, 40, 39);
		toolTip_MortgageCalculator.setIcon(new ImageIcon(image4));
		add(toolTip_MortgageCalculator);
		
		//Add the tool tip picture for the compound interest Calculator
		JLabel toolTip_InvestmentCalculator = new JLabel("");
		toolTip_InvestmentCalculator.setToolTipText("<html>Use this function to get an estimate of what the value of your interest investment would<br> be in x number of years. You will be prompted to enter the initial value of the<br>investment, your monthly contribution, the investment length, the interest Rate,<br>and the compound frequency. Your results will be displayed on a different page which<br>you will be taken to after clicking the calculate button.</html>");
		toolTip_InvestmentCalculator.setBounds(1104, 477, 40, 39);
		toolTip_InvestmentCalculator.setIcon(new ImageIcon(image4));
		add(toolTip_InvestmentCalculator);
		
		//Increase the tool tip display time 
		javax.swing.ToolTipManager.sharedInstance().setDismissDelay(20000);
		
		//Add the Mortgage picture to the home screen
		JLabel MortgageLogo = new JLabel("");
		MortgageLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		MortgageLogo.setBounds(167, 136, 375, 385);
		MortgageLogo.setHorizontalAlignment(SwingConstants.CENTER);
		MortgageLogo.setVerticalAlignment(SwingConstants.CENTER);
		URL url = this.getClass().getResource("MortgageCalculatorLogo.jpg");
		ImageIcon icon = new ImageIcon(url);
		Image image = icon.getImage().getScaledInstance(375, 385, Image.SCALE_SMOOTH);
		MortgageLogo.setIcon(new ImageIcon(image));
		add(MortgageLogo);
		
		//Add the interest Calculator picture to the screen
		JLabel InterestLogo = new JLabel("");
		InterestLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Hides the current panel
				AppData.hideCurrentPanel();
			
				//Determine if a interest panel has already been created
				if (AppData.interestPanel == null) {
					AppData.interestPanel = new InterestCalculator();
					
					//Display the settings panel
					AppData.interestPanel.setBounds(0, 175, 1300, 700);
					AppData.mainFrame.getContentPane().add(AppData.interestPanel);
				}
				else {
					//Display the Settings screen panel if there is one created already 
					AppData.interestPanel.setVisible(true);
				}
				
				//set visible variables accordingly
				AppData.interestVisibility= true;
				MenuTitleBar.currentPanelLabel.setText("Compound Interest Calculator");
			}
		});
		InterestLogo.setBounds(769, 136, 375, 385);
		InterestLogo.setHorizontalAlignment(SwingConstants.CENTER); 
		InterestLogo.setVerticalAlignment(SwingConstants.CENTER);
		URL url3 = this.getClass().getResource("CompoundInterestLogo.jpg");
		ImageIcon icon3 = new ImageIcon(url3);
		Image image3 = icon3.getImage().getScaledInstance(375, 385, Image.SCALE_SMOOTH);
		InterestLogo.setIcon(new ImageIcon(image3));
		add(InterestLogo);
		

	}
}
