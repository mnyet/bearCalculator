package bearCalculator;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class bearCalc {

	private JFrame frame;
	private int mouseX, mouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bearCalc window = new bearCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bearCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 114, 114));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 361, 475);
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
		
		panelTitleBar.setBackground(new Color(0, 95, 95));
		panelTitleBar.setBounds(0, 0, 361, 52);
		frame.getContentPane().add(panelTitleBar);
		panelTitleBar.setLayout(null);
		
		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panelTitleBar.setLayout(null);
		btnClose.setBounds(298, 11, 53, 33);
		panelTitleBar.add(btnClose);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(new Color(0, 95, 95));
		
		
		JLabel lblEnterSyntax = new JLabel("New label");
		lblEnterSyntax.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));
		lblEnterSyntax.setForeground(Color.WHITE);
		lblEnterSyntax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterSyntax.setBounds(10, 63, 341, 118);
		frame.getContentPane().add(lblEnterSyntax);
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.getContentPane().add(btnSeven);
		btnSeven.setBackground(new Color(0, 95, 95));
		btnSeven.setFocusPainted(false);
		btnSeven.setBorderPainted(false);
		btnSeven.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven.setForeground(Color.WHITE);
		btnSeven.setBounds(10, 192, 60, 60);
		
		JButton btnSeven_1 = new JButton("4");
		btnSeven_1.setForeground(Color.WHITE);
		btnSeven_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_1.setFocusPainted(false);
		btnSeven_1.setBorderPainted(false);
		btnSeven_1.setBackground(new Color(0, 95, 95));
		btnSeven_1.setBounds(10, 263, 60, 60);
		frame.getContentPane().add(btnSeven_1);
		
		JButton btnSeven_2 = new JButton("1");
		btnSeven_2.setForeground(Color.WHITE);
		btnSeven_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_2.setFocusPainted(false);
		btnSeven_2.setBorderPainted(false);
		btnSeven_2.setBackground(new Color(0, 95, 95));
		btnSeven_2.setBounds(10, 334, 60, 60);
		frame.getContentPane().add(btnSeven_2);
		
		JButton btnSeven_3 = new JButton("0");
		btnSeven_3.setForeground(Color.WHITE);
		btnSeven_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_3.setFocusPainted(false);
		btnSeven_3.setBorderPainted(false);
		btnSeven_3.setBackground(new Color(0, 95, 95));
		btnSeven_3.setBounds(10, 405, 60, 60);
		frame.getContentPane().add(btnSeven_3);
		
		JButton btnSeven_4 = new JButton("8");
		btnSeven_4.setForeground(Color.WHITE);
		btnSeven_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_4.setFocusPainted(false);
		btnSeven_4.setBorderPainted(false);
		btnSeven_4.setBackground(new Color(0, 95, 95));
		btnSeven_4.setBounds(80, 191, 60, 60);
		frame.getContentPane().add(btnSeven_4);
		
		JButton btnSeven_5 = new JButton("5");
		btnSeven_5.setForeground(Color.WHITE);
		btnSeven_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_5.setFocusPainted(false);
		btnSeven_5.setBorderPainted(false);
		btnSeven_5.setBackground(new Color(0, 95, 95));
		btnSeven_5.setBounds(80, 263, 60, 60);
		frame.getContentPane().add(btnSeven_5);
		
		JButton btnSeven_6 = new JButton("2");
		btnSeven_6.setForeground(Color.WHITE);
		btnSeven_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_6.setFocusPainted(false);
		btnSeven_6.setBorderPainted(false);
		btnSeven_6.setBackground(new Color(0, 95, 95));
		btnSeven_6.setBounds(80, 334, 60, 60);
		frame.getContentPane().add(btnSeven_6);
		
		JButton btnSeven_7 = new JButton(".");
		btnSeven_7.setForeground(Color.WHITE);
		btnSeven_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_7.setFocusPainted(false);
		btnSeven_7.setBorderPainted(false);
		btnSeven_7.setBackground(new Color(0, 95, 95));
		btnSeven_7.setBounds(80, 405, 60, 60);
		frame.getContentPane().add(btnSeven_7);
		
		JButton btnBck = new JButton("BCK");
		btnBck.setForeground(Color.WHITE);
		btnBck.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnBck.setFocusPainted(false);
		btnBck.setBorderPainted(false);
		btnBck.setBackground(new Color(0, 95, 95));
		btnBck.setBounds(150, 405, 60, 60);
		frame.getContentPane().add(btnBck);
		
		JButton btnSeven_9 = new JButton("+");
		btnSeven_9.setForeground(Color.WHITE);
		btnSeven_9.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_9.setFocusPainted(false);
		btnSeven_9.setBorderPainted(false);
		btnSeven_9.setBackground(new Color(0, 95, 95));
		btnSeven_9.setBounds(220, 405, 60, 60);
		frame.getContentPane().add(btnSeven_9);
		
		JButton btnSeven_10 = new JButton("=");
		btnSeven_10.setForeground(Color.WHITE);
		btnSeven_10.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_10.setFocusPainted(false);
		btnSeven_10.setBorderPainted(false);
		btnSeven_10.setBackground(new Color(0, 95, 95));
		btnSeven_10.setBounds(290, 334, 60, 131);
		frame.getContentPane().add(btnSeven_10);
		
		JButton btnSeven_11 = new JButton("3");
		btnSeven_11.setForeground(Color.WHITE);
		btnSeven_11.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_11.setFocusPainted(false);
		btnSeven_11.setBorderPainted(false);
		btnSeven_11.setBackground(new Color(0, 95, 95));
		btnSeven_11.setBounds(150, 334, 60, 60);
		frame.getContentPane().add(btnSeven_11);
		
		JButton btnSeven_12 = new JButton("6");
		btnSeven_12.setForeground(Color.WHITE);
		btnSeven_12.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_12.setFocusPainted(false);
		btnSeven_12.setBorderPainted(false);
		btnSeven_12.setBackground(new Color(0, 95, 95));
		btnSeven_12.setBounds(150, 263, 60, 60);
		frame.getContentPane().add(btnSeven_12);
		
		JButton btnSeven_13 = new JButton("9");
		btnSeven_13.setForeground(Color.WHITE);
		btnSeven_13.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_13.setFocusPainted(false);
		btnSeven_13.setBorderPainted(false);
		btnSeven_13.setBackground(new Color(0, 95, 95));
		btnSeven_13.setBounds(150, 192, 60, 60);
		frame.getContentPane().add(btnSeven_13);
		
		JButton btnSeven_14 = new JButton("/");
		btnSeven_14.setForeground(Color.WHITE);
		btnSeven_14.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_14.setFocusPainted(false);
		btnSeven_14.setBorderPainted(false);
		btnSeven_14.setBackground(new Color(0, 95, 95));
		btnSeven_14.setBounds(220, 192, 60, 60);
		frame.getContentPane().add(btnSeven_14);
		
		JButton btnSeven_15 = new JButton("\u00D7");
		btnSeven_15.setForeground(Color.WHITE);
		btnSeven_15.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_15.setFocusPainted(false);
		btnSeven_15.setBorderPainted(false);
		btnSeven_15.setBackground(new Color(0, 95, 95));
		btnSeven_15.setBounds(220, 263, 60, 60);
		frame.getContentPane().add(btnSeven_15);
		
		JButton btnSeven_16 = new JButton("-");
		btnSeven_16.setForeground(Color.WHITE);
		btnSeven_16.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_16.setFocusPainted(false);
		btnSeven_16.setBorderPainted(false);
		btnSeven_16.setBackground(new Color(0, 95, 95));
		btnSeven_16.setBounds(220, 334, 60, 60);
		frame.getContentPane().add(btnSeven_16);
		
		JButton btnSeven_17 = new JButton("()");
		btnSeven_17.setForeground(Color.WHITE);
		btnSeven_17.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven_17.setFocusPainted(false);
		btnSeven_17.setBorderPainted(false);
		btnSeven_17.setBackground(new Color(0, 95, 95));
		btnSeven_17.setBounds(290, 263, 60, 60);
		frame.getContentPane().add(btnSeven_17);
		
		JButton btnAc = new JButton("AC");
		btnAc.setForeground(Color.WHITE);
		btnAc.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnAc.setFocusPainted(false);
		btnAc.setBorderPainted(false);
		btnAc.setBackground(new Color(0, 95, 95));
		btnAc.setBounds(290, 192, 60, 60);
		frame.getContentPane().add(btnAc);
		
	}
}
