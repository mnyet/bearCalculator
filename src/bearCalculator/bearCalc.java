package bearCalculator;

import org.mariuszgromada.math.mxparser.*;
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
import javax.swing.JTextField;

public class bearCalc {

	private JFrame frame;
	private int mouseX, mouseY;
	private String value = "";
	private JTextField textFieldInput;

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
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "7";
				textFieldInput.setText(value);
			}
		});
		frame.getContentPane().add(btnSeven);
		btnSeven.setBackground(new Color(0, 95, 95));
		btnSeven.setFocusPainted(false);
		btnSeven.setBorderPainted(false);
		btnSeven.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven.setForeground(Color.WHITE);
		btnSeven.setBounds(10, 192, 60, 60);
		
		JButton btnFour = new JButton("4");
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "4";
				textFieldInput.setText(value);
			}
		});
		btnFour.setForeground(Color.WHITE);
		btnFour.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnFour.setFocusPainted(false);
		btnFour.setBorderPainted(false);
		btnFour.setBackground(new Color(0, 95, 95));
		btnFour.setBounds(10, 263, 60, 60);
		frame.getContentPane().add(btnFour);
		
		JButton btnOne = new JButton("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "1";
				textFieldInput.setText(value);
			}
		});
		btnOne.setForeground(Color.WHITE);
		btnOne.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnOne.setFocusPainted(false);
		btnOne.setBorderPainted(false);
		btnOne.setBackground(new Color(0, 95, 95));
		btnOne.setBounds(10, 334, 60, 60);
		frame.getContentPane().add(btnOne);
		
		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "0";
				textFieldInput.setText(value);
			}
		});
		btnZero.setForeground(Color.WHITE);
		btnZero.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnZero.setFocusPainted(false);
		btnZero.setBorderPainted(false);
		btnZero.setBackground(new Color(0, 95, 95));
		btnZero.setBounds(10, 405, 60, 60);
		frame.getContentPane().add(btnZero);
		
		JButton btnEight = new JButton("8");
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "8";
				textFieldInput.setText(value);
			}
		});
		btnEight.setForeground(Color.WHITE);
		btnEight.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnEight.setFocusPainted(false);
		btnEight.setBorderPainted(false);
		btnEight.setBackground(new Color(0, 95, 95));
		btnEight.setBounds(80, 191, 60, 60);
		frame.getContentPane().add(btnEight);
		
		JButton btnFive = new JButton("5");
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "5";
				textFieldInput.setText(value);
			}
		});
		btnFive.setForeground(Color.WHITE);
		btnFive.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnFive.setFocusPainted(false);
		btnFive.setBorderPainted(false);
		btnFive.setBackground(new Color(0, 95, 95));
		btnFive.setBounds(80, 263, 60, 60);
		frame.getContentPane().add(btnFive);
		
		JButton btnTwo = new JButton("2");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "2";
				textFieldInput.setText(value);
			}
		});
		btnTwo.setForeground(Color.WHITE);
		btnTwo.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnTwo.setFocusPainted(false);
		btnTwo.setBorderPainted(false);
		btnTwo.setBackground(new Color(0, 95, 95));
		btnTwo.setBounds(80, 334, 60, 60);
		frame.getContentPane().add(btnTwo);
		
		JButton btnPoint = new JButton(".");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += ".";
				textFieldInput.setText(value);
			}
		});
		btnPoint.setForeground(Color.WHITE);
		btnPoint.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnPoint.setFocusPainted(false);
		btnPoint.setBorderPainted(false);
		btnPoint.setBackground(new Color(0, 95, 95));
		btnPoint.setBounds(80, 405, 60, 60);
		frame.getContentPane().add(btnPoint);
		
		JButton btnBck = new JButton("BCK");
		btnBck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldInput.getText().length() > 0) {
					StringBuilder sb = new StringBuilder(textFieldInput.getText());
					sb.deleteCharAt(textFieldInput.getText().length()-1);
					value = sb.toString();
					textFieldInput.setText(value);
				}
			}
		});
		btnBck.setForeground(Color.WHITE);
		btnBck.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnBck.setFocusPainted(false);
		btnBck.setBorderPainted(false);
		btnBck.setBackground(new Color(0, 95, 95));
		btnBck.setBounds(150, 405, 60, 60);
		frame.getContentPane().add(btnBck);
		
		JButton btnAddition = new JButton("+");
		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "+";
				textFieldInput.setText(value);
			}
		});
		btnAddition.setForeground(Color.WHITE);
		btnAddition.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnAddition.setFocusPainted(false);
		btnAddition.setBorderPainted(false);
		btnAddition.setBackground(new Color(0, 95, 95));
		btnAddition.setBounds(220, 405, 60, 60);
		frame.getContentPane().add(btnAddition);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expression exp = new Expression(value.toString());
				String result = String.valueOf(exp.calculate());
				textFieldInput.setText(result);
			}
		});
		btnEquals.setForeground(Color.WHITE);
		btnEquals.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnEquals.setFocusPainted(false);
		btnEquals.setBorderPainted(false);
		btnEquals.setBackground(new Color(0, 95, 95));
		btnEquals.setBounds(290, 405, 60, 60);
		frame.getContentPane().add(btnEquals);
		
		JButton btnThree = new JButton("3");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "3";
				textFieldInput.setText(value);
			}
		});
		btnThree.setForeground(Color.WHITE);
		btnThree.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnThree.setFocusPainted(false);
		btnThree.setBorderPainted(false);
		btnThree.setBackground(new Color(0, 95, 95));
		btnThree.setBounds(150, 334, 60, 60);
		frame.getContentPane().add(btnThree);
		
		JButton btnSix = new JButton("6");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "6";
				textFieldInput.setText(value);
			}
		});
		btnSix.setForeground(Color.WHITE);
		btnSix.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSix.setFocusPainted(false);
		btnSix.setBorderPainted(false);
		btnSix.setBackground(new Color(0, 95, 95));
		btnSix.setBounds(150, 263, 60, 60);
		frame.getContentPane().add(btnSix);
		
		JButton btnNine = new JButton("9");
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "9";
				textFieldInput.setText(value);
			}
		});
		btnNine.setForeground(Color.WHITE);
		btnNine.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnNine.setFocusPainted(false);
		btnNine.setBorderPainted(false);
		btnNine.setBackground(new Color(0, 95, 95));
		btnNine.setBounds(150, 192, 60, 60);
		frame.getContentPane().add(btnNine);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "/";
				textFieldInput.setText(value);
			}
		});
		btnDivision.setForeground(Color.WHITE);
		btnDivision.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnDivision.setFocusPainted(false);
		btnDivision.setBorderPainted(false);
		btnDivision.setBackground(new Color(0, 95, 95));
		btnDivision.setBounds(220, 192, 60, 60);
		frame.getContentPane().add(btnDivision);
		
		JButton btnMultiplication = new JButton("\u00D7");
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "\u00D7";
				textFieldInput.setText(value);}
		});
		btnMultiplication.setForeground(Color.WHITE);
		btnMultiplication.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnMultiplication.setFocusPainted(false);
		btnMultiplication.setBorderPainted(false);
		btnMultiplication.setBackground(new Color(0, 95, 95));
		btnMultiplication.setBounds(220, 334, 60, 60);
		frame.getContentPane().add(btnMultiplication);
		
		JButton btnSubtraction = new JButton("-");
		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "-";
				textFieldInput.setText(value);
			}
		});
		btnSubtraction.setForeground(Color.WHITE);
		btnSubtraction.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSubtraction.setFocusPainted(false);
		btnSubtraction.setBorderPainted(false);
		btnSubtraction.setBackground(new Color(0, 95, 95));
		btnSubtraction.setBounds(290, 334, 60, 60);
		frame.getContentPane().add(btnSubtraction);
		
		JButton btnParenthesesOpen = new JButton("(");
		btnParenthesesOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "(";
				textFieldInput.setText(value);
			}
		});
		btnParenthesesOpen.setForeground(Color.WHITE);
		btnParenthesesOpen.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnParenthesesOpen.setFocusPainted(false);
		btnParenthesesOpen.setBorderPainted(false);
		btnParenthesesOpen.setBackground(new Color(0, 95, 95));
		btnParenthesesOpen.setBounds(220, 263, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen);
		
		JButton btnAllClear = new JButton("AC");
		btnAllClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInput.setText("");
				value = "";
			}
		});
		btnAllClear.setForeground(Color.WHITE);
		btnAllClear.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		btnAllClear.setFocusPainted(false);
		btnAllClear.setBorderPainted(false);
		btnAllClear.setBackground(new Color(0, 95, 95));
		btnAllClear.setBounds(290, 192, 60, 60);
		frame.getContentPane().add(btnAllClear);
		
		textFieldInput = new JTextField();
		textFieldInput.setEditable(false);
		textFieldInput.setText("0");
		textFieldInput.setForeground(Color.WHITE);
		textFieldInput.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldInput.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		textFieldInput.setBackground(new Color(0, 115, 115));
		textFieldInput.setBounds(10, 63, 340, 118);
		textFieldInput.setBorder(null);
		frame.getContentPane().add(textFieldInput);
		textFieldInput.setColumns(10);
		
		JButton btnParenthesesClose = new JButton(")");
		btnParenthesesClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += ")";
				textFieldInput.setText(value);
			}
		});
		btnParenthesesClose.setForeground(Color.WHITE);
		btnParenthesesClose.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnParenthesesClose.setFocusPainted(false);
		btnParenthesesClose.setBorderPainted(false);
		btnParenthesesClose.setBackground(new Color(0, 95, 95));
		btnParenthesesClose.setBounds(290, 263, 60, 60);
		frame.getContentPane().add(btnParenthesesClose);
		
		
	}
}
