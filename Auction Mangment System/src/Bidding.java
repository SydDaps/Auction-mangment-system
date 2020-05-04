import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import java.awt.TextArea;
import javax.swing.JTextField;
import java.awt.event.MouseMotionAdapter;

public class Bidding extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Bidding frame = new Bidding("2","NOT FOUND!","$ 00000,000");
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
	public Bidding(String imgNumber, String itemName, String bid) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1650, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Items.class.getResource("/images/money (1).png")));
		lblNewLabel.setBounds(26, 13, 69, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblX = new JLabel(" X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);		
				}
			@Override
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
		lblX.setBounds(1579, 13, 30, 34);
		contentPane.add(lblX);
		
		JLabel lblNewLabel_1 = new JLabel(" BIDINGS");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		       Bidding.this.setLocation(x - xx, y - xy); 
			}
		});
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 40));
		lblNewLabel_1.setBounds(648, 26, 213, 59);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(100, 100, 1450, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(50, 50, 650, 550);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(5, 5, 640, 540);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		String imgName = "/images/bigItems/"+imgNumber+".jpg";
		lblNewLabel_2.setIcon(new ImageIcon(Bidding.class.getResource(imgName)));
		lblNewLabel_2.setBounds(0, 0, 640, 540);
		panel_4.add(lblNewLabel_2);
		
		Panel panel_4_1 = new Panel();
		panel_4_1.setBackground(Color.BLACK);
		panel_4_1.setBounds(750, 50, 650, 230);
		panel.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		Panel panel_4_2 = new Panel();
		panel_4_2.setBounds(5, 5, 640, 220);
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(new Color(255, 250, 205));
		panel_4_1.add(panel_4_2);
		
		
		JLabel lblNewLabel_4 = new JLabel(addName(itemName));
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_4.setBounds(5, 5, 527, 50);
		panel_4_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("   TIME LEFT : 0 : 00");
		lblNewLabel_4_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(5, 42, 527, 50);
		panel_4_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel(addStartBid(bid));
		lblNewLabel_4_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(5, 79, 417, 50);
		panel_4_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("   MAX BID : \r\n");
		lblNewLabel_4_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_4_3.setBounds(5, 127, 167, 46);
		panel_4_2.add(lblNewLabel_4_3);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(178, 127, 236, 46);
		panel_4_2.add(panel_5);
		panel_5.setLayout(null);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(5, 5, 226, 36);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		textField = new JTextField();
		textField.setText(" $\r\n");
		textField.setFont(new Font("Monospaced", Font.BOLD, 20));
		textField.setBounds(0, 0, 226, 36);
		panel_6.add(textField);
		textField.setColumns(10);
		
		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.BLACK);
		panel_2_1_1.setBounds(453, 127, 150, 46);
		panel_4_2.add(panel_2_1_1);
		
		Panel panel_3_1_1 = new Panel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(new Color(255, 250, 205));
		panel_3_1_1.setBounds(5, 5, 140, 36);
		panel_2_1_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(" PLACE BID");
		lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				 panel_2_1_1.setBackground(Color.WHITE);	
				 panel_3_1_1.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_1.setBackground(Color.BLACK);
				panel_3_1_1.setBackground(new Color(255, 250, 205));
			}
		});
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(0, 0, 140, 36);
		panel_3_1_1.add(lblNewLabel_3_1_1);
		
		Panel panel_4_1_1 = new Panel();
		panel_4_1_1.setBackground(Color.BLACK);
		panel_4_1_1.setBounds(750, 330, 650, 198);
		panel.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);
		
		Panel panel_4_2_1 = new Panel();
		panel_4_2_1.setBounds(5, 5, 640, 50);
		panel_4_2_1.setLayout(null);
		panel_4_2_1.setBackground(new Color(255, 250, 205));
		panel_4_1_1.add(panel_4_2_1);
		
		JLabel lblNewLabel_5 = new JLabel("HIGHEST BIDS \r\n");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_5.setBounds(0, 0, 640, 50);
		panel_4_2_1.add(lblNewLabel_5);
		
		Panel panel_4_2_1_1 = new Panel();
		panel_4_2_1_1.setLayout(null);
		panel_4_2_1_1.setBackground(new Color(255, 250, 205));
		panel_4_2_1_1.setBounds(5, 60, 640, 40);
		panel_4_1_1.add(panel_4_2_1_1);
		
		Panel panel_4_2_1_2 = new Panel();
		panel_4_2_1_2.setLayout(null);
		panel_4_2_1_2.setBackground(new Color(255, 250, 205));
		panel_4_2_1_2.setBounds(5, 105, 640, 40);
		panel_4_1_1.add(panel_4_2_1_2);
		
		Panel panel_4_2_1_3 = new Panel();
		panel_4_2_1_3.setLayout(null);
		panel_4_2_1_3.setBackground(new Color(255, 250, 205));
		panel_4_2_1_3.setBounds(5, 150, 640, 40);
		panel_4_1_1.add(panel_4_2_1_3);
		
		Panel panel_2_1_1_1 = new Panel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBackground(Color.BLACK);
		panel_2_1_1_1.setBounds(1009, 554, 150, 46);
		panel.add(panel_2_1_1_1);
		
		Panel panel_3_1_1_1 = new Panel();
		panel_3_1_1_1.setLayout(null);
		panel_3_1_1_1.setBackground(new Color(255, 250, 205));
		panel_3_1_1_1.setBounds(5, 5, 140, 36);
		panel_2_1_1_1.add(panel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("REFRESH");
		lblNewLabel_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 panel_2_1_1_1.setBackground(Color.WHITE);	
				 panel_3_1_1_1.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_1_1.setBackground(Color.BLACK);
				panel_3_1_1_1.setBackground(new Color(255, 250, 205));
			}
		});
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3_1_1_1.setBounds(0, 0, 140, 36);
		panel_3_1_1_1.add(lblNewLabel_3_1_1_1);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(1400, 39, 150, 46);
		contentPane.add(panel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 250, 205));
		panel_3.setBounds(5, 5, 140, 36);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LOGOUT");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			panel_2.setBackground(Color.WHITE);	
			panel_3.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(Color.BLACK);
				panel_3.setBackground(new Color(255, 250, 205));
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 0, 140, 37);
		panel_3.add(lblNewLabel_3);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(1218, 39, 150, 46);
		contentPane.add(panel_2_1);
		
		Panel panel_3_1 = new Panel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 250, 205));
		panel_3_1.setBounds(5, 5, 140, 36);
		panel_2_1.add(panel_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Bidding.class.getResource("/images/arrows.png")));
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			panel_2_1.setBackground(Color.WHITE);
			panel_3_1.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			panel_2_1.setBackground(Color.BLACK);
			panel_3_1.setBackground(new Color(255, 250, 205));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Items frame = new Items();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(0, 0, 140, 37);
		panel_3_1.add(lblNewLabel_3_1);
		
	}
	
	public String addName(String Name) {
		return Name = "   NAME : "+ Name;
		
	}
	public String addStartBid(String bid) {
		return bid = "   START BID : "+bid;
		
	}
	
}
