import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userInput extends JPanel {

    private static final long serialVersionUID = 1L;

    static String selectedExpense;
    static int enteredSalary;
    
    public userInput() {

        setBounds(0, 0, 1300, 700);
        setBackground(AppData.backgroundColour);
        setLayout(null);

        String[] expenseOptions = {"Car", "Rent", "Other Expense"};

        // JLabel for welcome message
        JLabel lblNewLabel = new JLabel("Welcome to the Smart Financial Decision Calculator!");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
        lblNewLabel.setBounds(150, 50, 900, 50);
        add(lblNewLabel);

        // JLabel for expense type
        JLabel lblSelectAnExpense = new JLabel("Select an expense type:");
        lblSelectAnExpense.setFont(new Font("Arial", Font.BOLD, 24));
        lblSelectAnExpense.setBounds(200, 150, 300, 30);
        add(lblSelectAnExpense);

        // JComboBox for expense type
        JComboBox<String> expenseComboBox = new JComboBox<>(expenseOptions);
        expenseComboBox.setBackground(new Color(255, 255, 255));
        expenseComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        expenseComboBox.setBounds(510, 150, 200, 30);
        add(expenseComboBox);

        // JLabel for salary
        JLabel lblEnterMonthlySalary = new JLabel("Enter your monthly salary:");
        lblEnterMonthlySalary.setFont(new Font("Arial", Font.BOLD, 24));
        lblEnterMonthlySalary.setBounds(200, 248, 323, 30);
        add(lblEnterMonthlySalary);
        
        JSpinner salaryField = new JSpinner();
        salaryField.setModel(new SpinnerNumberModel(1000, 1, 999999, 1000));
        salaryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        salaryField.setBounds(533, 252, 206, 30);
        add(salaryField);

        // JButton for selection
        JButton selectButton = new JButton("Continue");
        selectButton.setFont(new Font("Arial", Font.PLAIN, 20));
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedExpense = (String) expenseComboBox.getSelectedItem();
            // MAKE THIS APPLICATION.DATA AND STORE THE MONTHLY AMOUNT IN THIS VARIABLE 
           
            enteredSalary = (int) salaryField.getValue();
                
          // After the user presses continue close this panel and open the mortgage calculator screen
            
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
        selectButton.setBounds(450, 350, 200, 30);
        add(selectButton);
  
    }
}
