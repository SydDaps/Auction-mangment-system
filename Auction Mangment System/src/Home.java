import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 679);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(728, 507, -54, -4);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(197, 112, 262, 293);
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/images/money (2).png")));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("KBOX AUCTIONS ");
		lblNewLabel_2.setBounds(170, 24, 358, 56);
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 36));
		contentPane.add(lblNewLabel_2);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(80, 495, 108, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBounds(5, 5, 98, 34);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogin = new JLabel("  LOGIN");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login userLogin = new Login();
				userLogin.setUndecorated(true);
				userLogin.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			panel.setBackground(Color.WHITE);
			panel_2.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.BLACK);
			panel_2.setBackground(new Color(255, 250, 205));
			}
		
		});
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setBounds(0, 0, 98, 34);
		panel_2.add(lblLogin);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblLogin.setBackground(new Color(255, 250, 205));
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(248, 495, 135, 44);
		contentPane.add(panel_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 250, 205));
		panel_2_1.setBounds(5, 5, 125, 34);
		panel_1.add(panel_2_1);
		
		JLabel lblRegister = new JLabel(" REGISTER");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Register userRegister = new Register();
				userRegister.setUndecorated(true);
				userRegister.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			panel_1.setBackground(Color.WHITE);
			panel_2_1.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			panel_1.setBackground(Color.BLACK);
			panel_2_1.setBackground(new Color(255, 250, 205));
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegister.setForeground(Color.BLACK);
		lblRegister.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblRegister.setBackground(new Color(0, 0, 139));
		lblRegister.setBounds(0, 0, 125, 34);
		panel_2_1.add(lblRegister);
		
		Panel panel_3 = new Panel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(433, 495, 108, 44);
		contentPane.add(panel_3);
		
		Panel panel_2_2 = new Panel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(255, 250, 205));
		panel_2_2.setBounds(5, 5, 98, 34);
		panel_3.add(panel_2_2);
		
		JLabel lblAbout = new JLabel("  ABOUT");
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				String errMsg = "OOps not found!";
				HandleErr frame = new HandleErr(errMsg);
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			panel_3.setBackground(Color.WHITE);
			panel_2_2.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			panel_3.setBackground(Color.BLACK);
			panel_2_2.setBackground(new Color(255, 250, 205));
			}
		});
		lblAbout.setHorizontalAlignment(SwingConstants.LEFT);
		lblAbout.setForeground(Color.BLACK);
		lblAbout.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblAbout.setBackground(new Color(0, 0, 139));
		lblAbout.setBounds(0, 0, 98, 34);
		panel_2_2.add(lblAbout);
		
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
		lblX.setBounds(590, 13, 30, 34);
		contentPane.add(lblX);
		
		
	}
}
