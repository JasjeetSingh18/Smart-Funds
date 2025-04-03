import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.net.URL;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTitleBar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//Declaring a label to display the name of the panel that is showing
	static Label currentPanelLabel;
	
	/**
	 * Create the panel.
	 */
	public MenuTitleBar() {
		setBackground(new Color(192, 192, 192));
		setBounds (0, 0, 1300, 200);
		setLayout(null);
		
		//Menu Bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1300, 35);
		menuBar.setBackground(new Color(58, 58, 58));
		add(menuBar);
		
		//Drop down menu
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(new Color(192, 192, 192));
		mnNewMenu.setBackground(new Color(58, 58, 58));
		mnNewMenu.setFont(new Font(AppData.font, Font.BOLD, 16));
		menuBar.add(mnNewMenu);

		
		//Button to open the mortgage calculator panel
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mortgage Calculator");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				currentPanelLabel.setText("Mortgage Calculator");
			}
		});
		mntmNewMenuItem_1.setFont(new Font(AppData.font, Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		//Button to open the compound interest calculator
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Compound Interest Calculator");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
				AppData.interestVisibility = true;
				currentPanelLabel.setText("Compound Interest Calculator");
			}
		});
		mntmNewMenuItem_2.setFont(new Font(AppData.font, Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		//Button to return to the home screen
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Home");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hides the current panel
				AppData.hideCurrentPanel();
				
				//Display the home screen panel
				AppData.homePanel.setVisible(true);
				currentPanelLabel.setText("Home");
				
			}
		});
		mntmNewMenuItem_3.setFont(new Font(AppData.font, Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		//Label at the top middle of the screen to tell which panel is showing
		currentPanelLabel = new Label("Home");
		currentPanelLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
		currentPanelLabel.setForeground(new Color(255, 255, 255));
		currentPanelLabel.setAlignment(Label.CENTER);
		menuBar.add(currentPanelLabel);
		
		//Add the Title Icon
		JLabel LogoBox = new JLabel("");
		LogoBox.setBounds(7, 31, 197, 162);
		LogoBox.setHorizontalAlignment(SwingConstants.CENTER);
		//Add the Logo
		LogoBox.setHorizontalAlignment(SwingConstants.CENTER);
		LogoBox.setVerticalAlignment(SwingConstants.CENTER);
		URL url = this.getClass().getResource("SmartFundsLogo.png");
		ImageIcon icon = new ImageIcon(url);
		Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		LogoBox.setIcon(new ImageIcon(image));
		add(LogoBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(158, 154, 1142, 2);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		add(separator);
		
		//Add Title and Logo
		JLabel Title = new JLabel("Smart Funds");
		Title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Hides the current panel
				AppData.hideCurrentPanel();
				
				//Display the home screen panel
				AppData.homePanel.setVisible(true);
				currentPanelLabel.setText("Home");
			}
		});
		Title.setBounds(0, 31, 1300, 162);
		Title.setBackground(new Color(0, 0, 0));
		Title.setForeground(new Color(24, 46, 109));
		Title.setFont(new Font("Monotype Corsiva", Font.PLAIN, 100));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		add(Title);
	}
}
