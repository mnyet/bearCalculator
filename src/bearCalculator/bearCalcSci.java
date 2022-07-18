package bearCalculator;

import org.mariuszgromada.math.mxparser.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class bearCalcSci {

	private JFrame frame;
	private int mouseX, mouseY;
	private String value = "";
	private JTextField textFieldInput;
	private String primaryColor = new String();
	private String secondaryColor = new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.gc();
		
		try {
			File userdata = new File("bearprefs.dat");
			
			if(userdata.createNewFile()) {
				// creates the default theme
				FileWriter createData = new FileWriter("bearprefs.dat");
				// this will be the default parameters for the theme
				createData.write("#005f5f\n#007373\n0");
				createData.close();
				Process hide = Runtime.getRuntime().exec("attrib +H bearprefs.dat");
				System.out.println("File Created!");
				
			} else {
				System.out.println("File Already Exists!");
			} 
		}	
		catch (IOException e) {
				System.out.println("Error Occurred.");
				e.printStackTrace();
			}
		
	}
	
	/**
	 * Launches the application from the boolean sciMode.
	 */
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BufferedReader br = new BufferedReader(new FileReader("bearprefs.dat"));
					String themeColor1 = br.readLine();
					String themeColor2 = br.readLine();
					br.close();
					bearCalcSci window = new bearCalcSci();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public bearCalcSci() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		primaryColor = "";
		secondaryColor = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("bearprefs.dat"));
			
			// color palette for themes
			primaryColor = br.readLine();
			secondaryColor = br.readLine();
			br.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode(secondaryColor));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 710, 475);
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
		
		panelTitleBar.setBackground(Color.decode(primaryColor));
		panelTitleBar.setBounds(0, 0, 730, 52);
		frame.getContentPane().add(panelTitleBar);
		panelTitleBar.setLayout(null);
		
		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.gc();
				System.exit(0);
			}
		});
		
		panelTitleBar.setLayout(null);
		btnClose.setBounds(650, 10, 48, 33);
		panelTitleBar.add(btnClose);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.decode(primaryColor));
		
		JButton btnMinimize = new JButton("_");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setBackground(Color.decode(primaryColor));
		btnMinimize.setBounds(592, 9, 48, 34);
		panelTitleBar.add(btnMinimize);
		
		JButton btnOptions = new JButton("OPT");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bearCalcOptions options = new bearCalcOptions();
				options.setVisible(true);
			}
		});
		btnOptions.setForeground(Color.WHITE);
		btnOptions.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnOptions.setFocusPainted(false);
		btnOptions.setBorderPainted(false);
		btnOptions.setBackground(Color.decode(primaryColor));
		btnOptions.setBounds(73, 10, 53, 33);
		panelTitleBar.add(btnOptions);
		
		JButton btnChangeMode = new JButton("NM");
		btnChangeMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File userdata = new File("bearprefs.dat");
					File usermode = new File("bearmode.dat");
					userdata.delete(); usermode.delete();
					FileWriter changeData = new FileWriter("bearprefs.dat");
					FileWriter changeMode = new FileWriter("bearmode.dat");
					// this will be the default parameters for the theme
					changeData.write("" + primaryColor + "\n" + secondaryColor + "");
					changeData.close();
					
					// change the parameters of the mode if its scientific or normal  mode
					changeMode.write("0");
					changeMode.close();
					
					Process hide = Runtime.getRuntime().exec("attrib +H bearprefs.dat");
					Process hideMode = Runtime.getRuntime().exec("attrib +H bearmode.dat");
					JOptionPane.showMessageDialog(null, "Calculator Set to Scientific Mode!");
					frame.dispose();
					// launches scientific mode
					bearCalc sciMode = new bearCalc();
					sciMode.setVisible(true);
					} 
				catch (IOException e1) {
						System.out.println("Error Occurred.");
						e1.printStackTrace();
					}
			}
		});
		btnChangeMode.setVerticalAlignment(SwingConstants.BOTTOM);
		btnChangeMode.setForeground(Color.WHITE);
		btnChangeMode.setFont(new Font("Segoe UI Black", Font.BOLD, 9));
		btnChangeMode.setFocusPainted(false);
		btnChangeMode.setBorderPainted(false);
		btnChangeMode.setBackground(Color.decode(secondaryColor));
		btnChangeMode.setBounds(10, 10, 53, 33);
		panelTitleBar.add(btnChangeMode);
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value += "7";
				textFieldInput.setText(value);
			}
		});
		frame.getContentPane().add(btnSeven);
		btnSeven.setBackground(Color.decode(primaryColor));
		btnSeven.setFocusPainted(false);
		btnSeven.setBorderPainted(false);
		btnSeven.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnSeven.setForeground(Color.WHITE);
		btnSeven.setBounds(430, 193, 60, 60);
		
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
		btnFour.setBackground(Color.decode(primaryColor));
		btnFour.setBounds(430, 264, 60, 60);
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
		btnOne.setBackground(Color.decode(primaryColor));
		btnOne.setBounds(430, 335, 60, 60);
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
		btnZero.setBackground(Color.decode(primaryColor));
		btnZero.setBounds(500, 406, 60, 60);
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
		btnEight.setBackground(Color.decode(primaryColor));
		btnEight.setBounds(500, 193, 60, 60);
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
		btnFive.setBackground(Color.decode(primaryColor));
		btnFive.setBounds(500, 264, 60, 60);
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
		btnTwo.setBackground(Color.decode(primaryColor));
		btnTwo.setBounds(500, 335, 60, 60);
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
		btnPoint.setBackground(Color.decode(primaryColor));
		btnPoint.setBounds(570, 406, 60, 60);
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
		btnBck.setBackground(Color.decode(primaryColor));
		btnBck.setBounds(640, 264, 60, 60);
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
		btnAddition.setBackground(Color.decode(primaryColor));
		btnAddition.setBounds(430, 406, 60, 60);
		frame.getContentPane().add(btnAddition);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expression exp = new Expression(value.toString());
				String result = String.valueOf(exp.calculate());
				value = "";
				textFieldInput.setText(result);
			}
		});
		btnEquals.setForeground(Color.WHITE);
		btnEquals.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnEquals.setFocusPainted(false);
		btnEquals.setBorderPainted(false);
		btnEquals.setBackground(Color.decode(primaryColor));
		btnEquals.setBounds(640, 335, 60, 131);
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
		btnThree.setBackground(Color.decode(primaryColor));
		btnThree.setBounds(570, 335, 60, 60);
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
		btnSix.setBackground(Color.decode(primaryColor));
		btnSix.setBounds(570, 264, 60, 60);
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
		btnNine.setBackground(Color.decode(primaryColor));
		btnNine.setBounds(570, 193, 60, 60);
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
		btnDivision.setBackground(Color.decode(primaryColor));
		btnDivision.setBounds(360, 264, 60, 60);
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
		btnMultiplication.setBackground(Color.decode(primaryColor));
		btnMultiplication.setBounds(360, 406, 60, 60);
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
		btnSubtraction.setBackground(Color.decode(primaryColor));
		btnSubtraction.setBounds(360, 335, 60, 60);
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
		btnParenthesesOpen.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen.setBounds(290, 193, 60, 60);
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
		btnAllClear.setBackground(Color.decode(primaryColor));
		btnAllClear.setBounds(640, 193, 60, 60);
		frame.getContentPane().add(btnAllClear);
		
		textFieldInput = new JTextField();
		textFieldInput.setText("0");
		textFieldInput.setForeground(Color.WHITE);
		textFieldInput.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldInput.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		textFieldInput.setBackground(Color.decode(secondaryColor));
		textFieldInput.setBounds(10, 63, 690, 118);
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
		btnParenthesesClose.setBackground(Color.decode(primaryColor));
		btnParenthesesClose.setBounds(360, 193, 60, 60);
		frame.getContentPane().add(btnParenthesesClose);
		
		JButton btnParenthesesOpen_1 = new JButton("TAN");
		btnParenthesesOpen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnParenthesesOpen_1.setForeground(Color.WHITE);
		btnParenthesesOpen_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_1.setFocusPainted(false);
		btnParenthesesOpen_1.setBorderPainted(false);
		btnParenthesesOpen_1.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_1.setBounds(220, 193, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_1);
		
		JButton btnParenthesesOpen_2 = new JButton("COS");
		btnParenthesesOpen_2.setForeground(Color.WHITE);
		btnParenthesesOpen_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_2.setFocusPainted(false);
		btnParenthesesOpen_2.setBorderPainted(false);
		btnParenthesesOpen_2.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_2.setBounds(150, 193, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_2);
		
		JButton btnParenthesesOpen_3 = new JButton("SIN");
		btnParenthesesOpen_3.setForeground(Color.WHITE);
		btnParenthesesOpen_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_3.setFocusPainted(false);
		btnParenthesesOpen_3.setBorderPainted(false);
		btnParenthesesOpen_3.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_3.setBounds(80, 193, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_3);
		
		JButton btnParenthesesOpen_4 = new JButton("SQRT");
		btnParenthesesOpen_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnParenthesesOpen_4.setForeground(Color.WHITE);
		btnParenthesesOpen_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 8));
		btnParenthesesOpen_4.setFocusPainted(false);
		btnParenthesesOpen_4.setBorderPainted(false);
		btnParenthesesOpen_4.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4.setBounds(10, 193, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4);
		
		JButton btnParenthesesOpen_4_1 = new JButton("ABS");
		btnParenthesesOpen_4_1.setForeground(Color.WHITE);
		btnParenthesesOpen_4_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_4_1.setFocusPainted(false);
		btnParenthesesOpen_4_1.setBorderPainted(false);
		btnParenthesesOpen_4_1.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_1.setBounds(290, 406, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_1);
		
		JButton btnParenthesesOpen_4_3 = new JButton("RAD");
		btnParenthesesOpen_4_3.setForeground(Color.WHITE);
		btnParenthesesOpen_4_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnParenthesesOpen_4_3.setFocusPainted(false);
		btnParenthesesOpen_4_3.setBorderPainted(false);
		btnParenthesesOpen_4_3.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_3.setBounds(150, 406, 130, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_3);
		
		JButton btnParenthesesOpen_4_5 = new JButton("DEG");
		btnParenthesesOpen_4_5.setForeground(Color.WHITE);
		btnParenthesesOpen_4_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnParenthesesOpen_4_5.setFocusPainted(false);
		btnParenthesesOpen_4_5.setBorderPainted(false);
		btnParenthesesOpen_4_5.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_5.setBounds(10, 406, 130, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_5);
		
		JButton btnParenthesesOpen_4_2_1 = new JButton("^");
		btnParenthesesOpen_4_2_1.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnParenthesesOpen_4_2_1.setFocusPainted(false);
		btnParenthesesOpen_4_2_1.setBorderPainted(false);
		btnParenthesesOpen_4_2_1.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_1.setBounds(290, 335, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_1);
		
		JButton btnParenthesesOpen_4_2_2 = new JButton("TANH");
		btnParenthesesOpen_4_2_2.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 8));
		btnParenthesesOpen_4_2_2.setFocusPainted(false);
		btnParenthesesOpen_4_2_2.setBorderPainted(false);
		btnParenthesesOpen_4_2_2.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_2.setBounds(220, 335, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_2);
		
		JButton btnParenthesesOpen_4_2_3 = new JButton("COSH");
		btnParenthesesOpen_4_2_3.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 8));
		btnParenthesesOpen_4_2_3.setFocusPainted(false);
		btnParenthesesOpen_4_2_3.setBorderPainted(false);
		btnParenthesesOpen_4_2_3.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_3.setBounds(150, 335, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_3);
		
		JButton btnParenthesesOpen_4_2_4 = new JButton("SINH");
		btnParenthesesOpen_4_2_4.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 8));
		btnParenthesesOpen_4_2_4.setFocusPainted(false);
		btnParenthesesOpen_4_2_4.setBorderPainted(false);
		btnParenthesesOpen_4_2_4.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_4.setBounds(80, 335, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_4);
		
		JButton btnParenthesesOpen_4_2_5 = new JButton("\u03C0");
		btnParenthesesOpen_4_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnParenthesesOpen_4_2_5.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnParenthesesOpen_4_2_5.setFocusPainted(false);
		btnParenthesesOpen_4_2_5.setBorderPainted(false);
		btnParenthesesOpen_4_2_5.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_5.setBounds(10, 335, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_5);
		
		JButton btnParenthesesOpen_4_2_6 = new JButton("EXP");
		btnParenthesesOpen_4_2_6.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_4_2_6.setFocusPainted(false);
		btnParenthesesOpen_4_2_6.setBorderPainted(false);
		btnParenthesesOpen_4_2_6.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_6.setBounds(10, 264, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_6);
		
		JButton btnParenthesesOpen_4_2_7 = new JButton("SEC");
		btnParenthesesOpen_4_2_7.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_4_2_7.setFocusPainted(false);
		btnParenthesesOpen_4_2_7.setBorderPainted(false);
		btnParenthesesOpen_4_2_7.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_7.setBounds(80, 264, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_7);
		
		JButton btnParenthesesOpen_4_2_8 = new JButton("CSC");
		btnParenthesesOpen_4_2_8.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_8.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_4_2_8.setFocusPainted(false);
		btnParenthesesOpen_4_2_8.setBorderPainted(false);
		btnParenthesesOpen_4_2_8.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_8.setBounds(150, 264, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_8);
		
		JButton btnParenthesesOpen_4_2_9 = new JButton("COT");
		btnParenthesesOpen_4_2_9.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_9.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_4_2_9.setFocusPainted(false);
		btnParenthesesOpen_4_2_9.setBorderPainted(false);
		btnParenthesesOpen_4_2_9.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_9.setBounds(220, 264, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_9);
		
		JButton btnParenthesesOpen_4_2_10 = new JButton("TG");
		btnParenthesesOpen_4_2_10.setForeground(Color.WHITE);
		btnParenthesesOpen_4_2_10.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnParenthesesOpen_4_2_10.setFocusPainted(false);
		btnParenthesesOpen_4_2_10.setBorderPainted(false);
		btnParenthesesOpen_4_2_10.setBackground(Color.decode(primaryColor));
		btnParenthesesOpen_4_2_10.setBounds(290, 264, 60, 60);
		frame.getContentPane().add(btnParenthesesOpen_4_2_10);
		
		
	}

}
