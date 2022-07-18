package bearCalculator;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class bearCalcOptions {

	private JFrame frame;
	private int mouseX, mouseY;

	/**
	 * Create the application.
	 */
	public bearCalcOptions() {
		initialize();
	}
	
	/**
	 * Launch the application.
	 */
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		// only way to open this window is to click the ... button on the main calculator.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bearCalcOptions window = new bearCalcOptions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(66, 66, 66));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 586, 368);
		frame.setLocationRelativeTo(null);
		
		JPanel panelTitleBar = new JPanel();
		
		//make the panel draggable even undecorated
		panelTitleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		panelTitleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		
		panelTitleBar.setBackground(new Color(33, 33, 33));
		panelTitleBar.setBounds(0, 0, 586, 52);
		frame.getContentPane().add(panelTitleBar);
		panelTitleBar.setLayout(null);
		
		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		panelTitleBar.setLayout(null);
		btnClose.setBounds(523, 11, 53, 33);
		panelTitleBar.add(btnClose);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(new Color(33, 33, 33));
		
		JLabel lblOptions = new JLabel("Options\r\n");
		lblOptions.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblOptions.setForeground(Color.WHITE);
		lblOptions.setBounds(21, 63, 162, 33);
		frame.getContentPane().add(lblOptions);
		
		JLabel lblTheme = new JLabel("Theme");
		lblTheme.setForeground(Color.WHITE);
		lblTheme.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTheme.setBounds(21, 106, 162, 33);
		frame.getContentPane().add(lblTheme);
		
		JPanel panelTeal = new JPanel();
		panelTeal.setBackground(new Color(0, 115, 115));
		panelTeal.setBounds(21, 146, 40, 40);
		frame.getContentPane().add(panelTeal);
		
		JPanel panelRed = new JPanel();
		panelRed.setBackground(new Color(195, 40, 40));
		panelRed.setBounds(21, 197, 40, 40);
		frame.getContentPane().add(panelRed);
		
		JPanel panelBlue = new JPanel();
		panelBlue.setBackground(new Color(21, 101, 192));
		panelBlue.setBounds(21, 248, 40, 40);
		frame.getContentPane().add(panelBlue);
		
		JPanel panelOrange = new JPanel();
		panelOrange.setBackground(new Color(239, 108, 0));
		panelOrange.setBounds(21, 299, 40, 40);
		frame.getContentPane().add(panelOrange);
		
		JButton btnTealTheme = new JButton("Teal");
		btnTealTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try catch is needed kasi need ng exception pag minamanipulate yung userdata so ayon yas
				try {
					File userdata = new File("bearprefs.dat");
					userdata.delete();
					FileWriter changeData = new FileWriter("bearprefs.dat");
					// this will be the default parameters for the theme
					changeData.write("#005f5f\n#007373");
					changeData.close();
					Process hide = Runtime.getRuntime().exec("attrib +H bearprefs.dat");
					JOptionPane.showMessageDialog(null, "Color Set to Teal!");
					JOptionPane.showMessageDialog(null, "Program will be closed to save changes.");
					System.exit(0);
					} 
				catch (IOException e1) {
						System.out.println("Error Occurred.");
						e1.printStackTrace();
					}
			}
		});
		btnTealTheme.setForeground(SystemColor.textHighlightText);
		btnTealTheme.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnTealTheme.setBackground(new Color(0, 95, 95));
		btnTealTheme.setBounds(71, 146, 175, 40);
		btnTealTheme.setFocusPainted(false);
		btnTealTheme.setBorderPainted(false);
		frame.getContentPane().add(btnTealTheme);
		
		JButton btnRedTheme = new JButton("Red");
		btnRedTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try catch is needed kasi need ng exception pag minamanipulate yung userdata so ayon yas
				try {
					File userdata = new File("bearprefs.dat");
					userdata.delete();
					FileWriter changeData = new FileWriter("bearprefs.dat");
					// this will be the default parameters for the theme
					changeData.write("#b71c1c\n#c32828");
					changeData.close();
					Process hide = Runtime.getRuntime().exec("attrib +H bearprefs.dat");
					JOptionPane.showMessageDialog(null, "Color Set to Red!");
					JOptionPane.showMessageDialog(null, "Program will be closed to save changes.");
					System.exit(0);
					} 
				catch (IOException e1) {
						System.out.println("Error Occurred.");
						e1.printStackTrace();
					}
			}
		});
		btnRedTheme.setForeground(Color.WHITE);
		btnRedTheme.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRedTheme.setFocusPainted(false);
		btnRedTheme.setBorderPainted(false);
		btnRedTheme.setBackground(new Color(183, 28, 28));
		btnRedTheme.setBounds(71, 197, 175, 40);
		frame.getContentPane().add(btnRedTheme);
		
		JButton btnBlueTheme = new JButton("Blue");
		btnBlueTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try catch is needed kasi need ng exception pag minamanipulate yung userdata so ayon yas
				try {
					File userdata = new File("bearprefs.dat");
					userdata.delete();
					FileWriter changeData = new FileWriter("bearprefs.dat");
					// this will be the default parameters for the theme
					changeData.write("#0d48a1\n#1565c0");
					changeData.close();
					Process hide = Runtime.getRuntime().exec("attrib +H bearprefs.dat");
					JOptionPane.showMessageDialog(null, "Color Set to Blue!");
					JOptionPane.showMessageDialog(null, "Program will be closed to save changes.");
					System.exit(0);
					} 
				catch (IOException e1) {
						System.out.println("Error Occurred.");
						e1.printStackTrace();
					}
			}
		});
		btnBlueTheme.setForeground(Color.WHITE);
		btnBlueTheme.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBlueTheme.setFocusPainted(false);
		btnBlueTheme.setBorderPainted(false);
		btnBlueTheme.setBackground(new Color(13, 71, 161));
		btnBlueTheme.setBounds(71, 248, 175, 40);
		frame.getContentPane().add(btnBlueTheme);
		
		JButton btnOrangeTheme = new JButton("Orange");
		btnOrangeTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File userdata = new File("bearprefs.dat");
					userdata.delete();
					FileWriter changeData = new FileWriter("bearprefs.dat");
					// this will be the default parameters for the theme
					changeData.write("#e65100\n#ef6c00");
					changeData.close();
					Process hide = Runtime.getRuntime().exec("attrib +H bearprefs.dat");
					JOptionPane.showMessageDialog(null, "Color Set to Orange!");
					JOptionPane.showMessageDialog(null, "Program will be closed to save changes.");
					System.exit(0);
					} 
				catch (IOException e1) {
						System.out.println("Error Occurred.");
						e1.printStackTrace();
					}
			}
		});
		btnOrangeTheme.setForeground(Color.WHITE);
		btnOrangeTheme.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnOrangeTheme.setFocusPainted(false);
		btnOrangeTheme.setBorderPainted(false);
		btnOrangeTheme.setBackground(new Color(230, 81, 0));
		btnOrangeTheme.setBounds(71, 299, 175, 40);
		frame.getContentPane().add(btnOrangeTheme);
		
		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setForeground(Color.WHITE);
		lblDeveloper.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDeveloper.setBounds(284, 63, 162, 33);
		frame.getContentPane().add(lblDeveloper);
		
		JLabel lblDeveloperName = new JLabel("Janber Calamba :D");
		lblDeveloperName.setForeground(Color.WHITE);
		lblDeveloperName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDeveloperName.setBounds(284, 106, 162, 33);
		frame.getContentPane().add(lblDeveloperName);
		
		JLabel lblIMadeThis = new JLabel("<html><strong>Dev Message:</strong><br>i made this calculator as practice"
				+ "<br>but i decided to develop this fully"
				+ "<br>kasi bakit ba gusto ko maangas"
				+ "<br><strong>aone mahal na mahal kita uwu</strong><br>"
				+ "<br>Dev build 7-28-2022</html>");
		lblIMadeThis.setVerticalAlignment(SwingConstants.TOP);
		lblIMadeThis.setToolTipText("");
		lblIMadeThis.setForeground(Color.WHITE);
		lblIMadeThis.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblIMadeThis.setBounds(284, 146, 292, 193);
		frame.getContentPane().add(lblIMadeThis);
		
		
	}
	

}
