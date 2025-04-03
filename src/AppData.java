import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JPanel;

public class AppData extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Declare the main frame which will hold all the panels
	static MainFrame mainFrame;
	
	//Declare all the panels that will be used in the application
	static MenuTitleBar menuTitleBarPanel;
	static Home homePanel;
	static MortgageCalculator mortgagePanel;
	static InterestCalculator interestPanel;
	static InterestCalculator_Output interestOutputPanel;
	static userInput userInputPanel;
	static FinalDecision finalDecisionPanel;
	
	//Declaring and setting variables for the layout/design of the program
	static int fontSize = 20;
	static Color backgroundColour = Color.GRAY; 
	static String currency = "CAD $";
	static String font = "Serif";
	
	//(Mortgage Calculator) - Declare and initialize variables in order to calculate the mortgage payments and interest payed
	static int mortgageValue = 0, amortizationPeriod = 0, paymentFrequency = 0;
	static double mortgageInterestRate = 0.0, mortgageCostPerPayment = 0.0, totalInterestPayed = 0.0;

	//(Compound Interest Calculator) - Declaring variables for compound interest investments
	static int initialInvestment = 0, monthlyContribution = 0, investmentLength = 1, compoundFrequency = 0;
	static double investmentInterestRate = 0.0, totalInvestmentReturn = 0.0;
	
	//Declare the decimal format 
	static DecimalFormat df = new DecimalFormat ("###,###,##0.00");
	
	//Variables to know which panel is showing
	static boolean FinalDecisionVisibility = false, userInputVisibility = false, mortgageVisibility = false, interestVisibility = false, interestOutputVisibility = false ;
	
	//Determine which Panel is showing and hide it
	static void hideCurrentPanel () {
		//Conditional statement to determine which panel is showing
		if (mortgageVisibility == true) {
			mortgagePanel.setVisible(false);
			mortgageVisibility = false;
		}
		else if (interestVisibility == true) {
			interestPanel.setVisible(false);
			interestVisibility = false;			
		}
		else if (interestOutputVisibility == true) {
			interestOutputPanel.setVisible(false);
			interestOutputVisibility = false;
		}
		else if (userInputVisibility == true) {
			userInputPanel.setVisible(false);
			userInputVisibility = false;
		}
		else if (FinalDecisionVisibility == true) {
			finalDecisionPanel.setVisible(false);
			FinalDecisionVisibility = false;
		}
		else { 
			homePanel.setVisible(false);
		}
	}	
}
