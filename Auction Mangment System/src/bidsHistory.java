import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class bidsHistory extends JFrame {
   
	private JPanel contentPane;
	int xx,xy,yy;
	
	Panel[] bidsPlane1 = new Panel[100];
	JLabel[] bidLabel1 = new JLabel[100];
	Panel[] bidsPlane2 = new Panel[100];
	JLabel[] bidLabel2 = new JLabel[100];
	Panel panel_1;
	Panel panel_1_1;
	Connection con;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bidsHistory frame = new bidsHistory(1);
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
	public bidsHistory(int cusID) {
		System.out.print(cusID);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1650, 1000);
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
		       bidsHistory.this.setLocation(x - xx, y - xy); 
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX();
			     xy = e.getY();
			}
		});
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
		
		JLabel lblNewLabel_1 = new JLabel("  BIDS ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 40));
		lblNewLabel_1.setBounds(547, 26, 365, 59);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(100, 100, 1450, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
	    panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(50, 50, 650, 676);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(new Color(255, 250, 205));
		panel_4.setBounds(5, 5, 640, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ALL CURRENT BIDS");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 21));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 640, 50);
		panel_4.add(lblNewLabel_2);
		
		panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(750, 50, 650, 676);
		panel.add(panel_1_1);
		
		Panel panel_4_1 = new Panel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(255, 250, 205));
		panel_4_1.setBounds(5, 5, 640, 50);
		panel_1_1.add(panel_4_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("ITEMS BOUGHT");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 21));
		lblNewLabel_2_1.setBounds(0, 0, 640, 50);
		panel_4_1.add(lblNewLabel_2_1);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(1400, 43, 150, 46);
		contentPane.add(panel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 250, 205));
		panel_3.setBounds(5, 5, 140, 36);
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("BACK");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					dispose();
					Items frame = new Items(cusID);
					frame.setUndecorated(true);
					frame.setVisible(true);
			}
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
		lblNewLabel_3.setIcon(new ImageIcon(bidsHistory.class.getResource("/images/arrows.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 0, 140, 37);
		panel_3.add(lblNewLabel_3);
		
		setPlanes(cusID);
		
      
		
		
		
		
		
	}
	
	public void setPlanes(int cusID) {
		 int count= 61;
		 int count2 = 61;
		 int b = 0;
		
		 createConnection();
		for(int a = 0; a<11;a++) {
			bidsPlane1[a] = new Panel();
			bidsPlane1[a].setBackground(new Color(255, 250, 205));
			bidsPlane1[a].setBounds(5, count, 640, 50);
		    panel_1.add(bidsPlane1[a]);
		    bidsPlane1[a].setLayout(null);
		    
		    bidsPlane2[a] = new Panel();
			bidsPlane2[a].setBackground(new Color(255, 250, 205));
			bidsPlane2[a].setBounds(5, count, 640, 50);
			panel_1_1.add(bidsPlane2[a]);
			bidsPlane2[a].setLayout(null);
	        count = count + 56;
		}
		
		
		try {
			Statement state = con.createStatement();
			ResultSet bids,sbids;
			bids = state.executeQuery("SELECT  customers.cusName, aucItems.itemNAME, bids.bidAmount , bids.isSuccess FROM ((bids"
					+ " INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
					+ " ORDER BY bidID DESC;");
			while(bids.next()) {
				if(b < 11) {
				   if(bids.getBoolean("isSuccess") == true) {
				   bidLabel1[b] = new JLabel("\r\n \r\n"+(b+1)+"."+bids.getString("cusName")+"  "+bids.getString("itemName")+" --> $"+bids.getDouble("bidAmount")+" *");
				   bidLabel1[b].setHorizontalAlignment(SwingConstants.LEADING);
				   bidLabel1[b].setFont(new Font("Monospaced", Font.BOLD, 20));
				   bidLabel1[b].setBounds(0, 0, 640, 50);
				   bidsPlane1[b].add( bidLabel1[b]);
				   count2 = count2 + 56;
			       b++;
				   }
				   else {
					   bidLabel1[b] = new JLabel("\r\n \r\n"+(b+1)+"."+bids.getString("cusName")+"  "+bids.getString("itemName")+" --> $"+bids.getDouble("bidAmount"));
					   bidLabel1[b].setHorizontalAlignment(SwingConstants.LEADING);
					   bidLabel1[b].setFont(new Font("Monospaced", Font.BOLD, 20));
					   bidLabel1[b].setBounds(0, 0, 640, 50);
					   bidsPlane1[b].add( bidLabel1[b]);
					   count2 = count2 + 56;
				       b++;   
				   }
				  
				}
			}
			b = 0;
			count2 = 61;
			sbids = state.executeQuery("SELECT  customers.cusName, aucItems.itemNAME, bids.bidAmount FROM ((bids"
					+ " INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
					+ "where customers.cusID = '"+ cusID +"' and isSuccess = true"
					+ " ORDER BY bidID DESC;");
			while(sbids.next()) {
				if(b < 11) {
				   bidLabel2[b] = new JLabel("\r\n \r\n"+(b+1)+"."+sbids.getString("cusName")+"  "+sbids.getString("itemName")+" --> "+sbids.getDouble("bidAmount"));
				   bidLabel2[b].setHorizontalAlignment(SwingConstants.LEADING);
				   bidLabel2[b].setFont(new Font("Monospaced", Font.BOLD, 20));
				   bidLabel2[b].setBounds(0, 0, 640, 50);
				   bidsPlane2[b].add( bidLabel2[b]);
				   count2 = count2 + 56;
			      b++;
				}
			}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void createConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","root"); 
			System.out.println("DATABASE CONNECTED SUCCESS");
		} catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e);
			e.printStackTrace();
		}  
	}
}
