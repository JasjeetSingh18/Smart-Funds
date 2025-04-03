import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppData.mainFrame = new MainFrame();
					
					//Add the HomeScreen to the frame
					AppData.mainFrame.add(AppData.homePanel);
					AppData.homePanel.setBounds(0, 180, 1300, 700);
					
					//Set the frame to visible
					AppData.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 60, 1300, 900);
		AppData.fontSize = 20;
		getContentPane().setLayout(null);
		
		//Create the menu/title bar and the home screen
		AppData.menuTitleBarPanel = new MenuTitleBar();
		AppData.homePanel = new Home();
		
		//Set the border for the menu title bar and the home screen
		AppData.menuTitleBarPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		AppData.homePanel.setBorder(new EmptyBorder(5, 5, 5, 5));	
		
		//Add the menu and the title bar to the frame
		setContentPane(AppData.menuTitleBarPanel);
	}
}
