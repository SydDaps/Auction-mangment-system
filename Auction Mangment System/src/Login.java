import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 679);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		       Login.this.setLocation(x - xx, y - xy); 
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Home home = new Home();
				home.setUndecorated(true);	
				home.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/money (1).png")));
		lblNewLabel.setBounds(12, 13, 69, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel_1.setBounds(240, 80, 164, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblX = new JLabel(" X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);		
				}
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Broadway", Font.BOLD, 20));
		lblX.setBackground(new Color(0, 0, 139));
		lblX.setBounds(593, 13, 30, 34);
		contentPane.add(lblX);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME :");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2.setBounds(102, 144, 133, 26);
		contentPane.add(lblNewLabel_2);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(102, 176, 465, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		textField.setBounds(3, 3, 459, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD :");
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(102, 266, 133, 26);
		contentPane.add(lblNewLabel_2_1);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(102, 298, 465, 46);
		contentPane.add(panel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(3, 3, 459, 40);
		panel_1.add(passwordField);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(268, 409, 150, 46);
		contentPane.add(panel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 250, 205));
		panel_3.setBounds(5, 5, 140, 36);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			panel_2.setBackground(Color.WHITE);
			panel_3.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			panel_2.setBackground(Color.BLACK);
			panel_3.setBackground(new Color(255, 250, 205));
			}		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 0, 140, 37);
		panel_3.add(lblNewLabel_3);
	}
}
