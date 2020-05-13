import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Items extends JFrame {

	private JPanel contentPane;
	
    int xx,xy;
    Connection con;
    int[] item = new int[100];
    int[] sold = new int[100];
    Date date ,currentAfterAdded;
    SimpleDateFormat dateFormat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items frame = new Items(0);
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Items(int cusID) {
		
		checkAndRelpaceItem();
		
		
		
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
		       Items.this.setLocation(x - xx, y - xy); 
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
		
		JLabel lblNewLabel_1 = new JLabel(" AUCTION ITEMS");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 40));
		lblNewLabel_1.setBounds(547, 26, 365, 59);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(100, 100, 1450, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(50, 50, 300, 200);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(5, 5, 290, 190);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel itemLable_1 = new JLabel("");
		itemLable_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(Color.WHITE);	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[1],cusID);	
			}
		});
		itemLable_1.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[1]+".jpg")));
		itemLable_1.setBounds(0, 0, 290, 190);
		panel_4.add(itemLable_1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(400, 50, 300, 200);
		panel.add(panel_1_1);
		
		Panel panel_4_1 = new Panel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(5, 5, 290, 190);
		panel_1_1.add(panel_4_1);
		
		JLabel itemLable_2 = new JLabel("");
		itemLable_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_1.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[2],cusID);	
			}
		});
		itemLable_2.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[2]+".jpg")));
		itemLable_2.setBounds(0, 0, 290, 190);
		panel_4_1.add(itemLable_2);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.BLACK);
		panel_1_2.setBounds(750, 50, 300, 200);
		panel.add(panel_1_2);
		
		Panel panel_4_2 = new Panel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(Color.WHITE);
		panel_4_2.setBounds(5, 5, 290, 190);
		panel_1_2.add(panel_4_2);
		
		JLabel itemLable_3 = new JLabel("");
		itemLable_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_2.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_2.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[3],cusID);
			}
		});
		itemLable_3.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[3]+".jpg")));
		itemLable_3.setBounds(0, 0, 290, 190);
		panel_4_2.add(itemLable_3);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.BLACK);
		panel_1_3.setBounds(1100, 50, 300, 200);
		panel.add(panel_1_3);
		
		Panel panel_4_3 = new Panel();
		panel_4_3.setLayout(null);
		panel_4_3.setBackground(Color.WHITE);
		panel_4_3.setBounds(5, 5, 290, 190);
		panel_1_3.add(panel_4_3);
		
		JLabel itemLable_4 = new JLabel("");
		itemLable_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_3.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_3.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[4],cusID);		
			}
		});
		itemLable_4.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[4]+".jpg")));
		itemLable_4.setBounds(0, 0, 290, 190);
		panel_4_3.add(itemLable_4);
		
		Panel panel_1_4 = new Panel();
		panel_1_4.setLayout(null);
		panel_1_4.setBackground(Color.BLACK);
		panel_1_4.setBounds(50, 300, 300, 200);
		panel.add(panel_1_4);
		
		Panel panel_4_7 = new Panel();
		panel_4_7.setLayout(null);
		panel_4_7.setBackground(Color.WHITE);
		panel_4_7.setBounds(5, 5, 290, 190);
		panel_1_4.add(panel_4_7);
		
		JLabel lblNewLabel_2_7 = new JLabel("");
		lblNewLabel_2_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_4.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_4.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[5],cusID);
			}
		});
		lblNewLabel_2_7.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[5]+".jpg")));
		lblNewLabel_2_7.setBounds(0, 0, 290, 190);
		panel_4_7.add(lblNewLabel_2_7);
		
		Panel panel_1_5 = new Panel();
		panel_1_5.setLayout(null);
		panel_1_5.setBackground(Color.BLACK);
		panel_1_5.setBounds(400, 300, 300, 200);
		panel.add(panel_1_5);
		
		Panel panel_4_6 = new Panel();
		panel_4_6.setLayout(null);
		panel_4_6.setBackground(Color.WHITE);
		panel_4_6.setBounds(5, 5, 290, 190);
		panel_1_5.add(panel_4_6);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_5.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_5.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[6],cusID);
			}
		});
		lblNewLabel_2_6.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[6]+".jpg")));
		lblNewLabel_2_6.setBounds(0, 0, 290, 190);
		panel_4_6.add(lblNewLabel_2_6);
		
		Panel panel_1_6 = new Panel();
		panel_1_6.setLayout(null);
		panel_1_6.setBackground(Color.BLACK);
		panel_1_6.setBounds(750, 300, 300, 200);
		panel.add(panel_1_6);
		
		Panel panel_4_5 = new Panel();
		panel_4_5.setLayout(null);
		panel_4_5.setBackground(Color.WHITE);
		panel_4_5.setBounds(5, 5, 290, 190);
		panel_1_6.add(panel_4_5);
		
		JLabel lblNewLabel_2_6_4 = new JLabel("");
		lblNewLabel_2_6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_6.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_6.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[7],cusID);
			}
		});
		lblNewLabel_2_6_4.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[7]+".jpg")));
		lblNewLabel_2_6_4.setBounds(0, 0, 290, 190);
		panel_4_5.add(lblNewLabel_2_6_4);
		
		Panel panel_1_7 = new Panel();
		panel_1_7.setLayout(null);
		panel_1_7.setBackground(Color.BLACK);
		panel_1_7.setBounds(1100, 300, 300, 200);
		panel.add(panel_1_7);
		
		Panel panel_4_4 = new Panel();
		panel_4_4.setLayout(null);
		panel_4_4.setBackground(Color.WHITE);
		panel_4_4.setBounds(5, 5, 290, 190);
		panel_1_7.add(panel_4_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_7.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_7.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[8],cusID);
			}
		});
		lblNewLabel_2_4.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[8]+".jpg")));
		lblNewLabel_2_4.setBounds(0, 0, 290, 190);
		panel_4_4.add(lblNewLabel_2_4);
		
		Panel panel_1_4_1 = new Panel();
		panel_1_4_1.setLayout(null);
		panel_1_4_1.setBackground(Color.BLACK);
		panel_1_4_1.setBounds(50, 550, 300, 200);
		panel.add(panel_1_4_1);
		
		Panel panel_4_8 = new Panel();
		panel_4_8.setLayout(null);
		panel_4_8.setBackground(Color.WHITE);
		panel_4_8.setBounds(5, 5, 290, 190);
		panel_1_4_1.add(panel_4_8);
		
		JLabel lblNewLabel_2_8 = new JLabel("");
		lblNewLabel_2_8.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[9]+".jpg")));
		lblNewLabel_2_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_4_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_4_1.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[9],cusID);
			}
		});
		lblNewLabel_2_8.setBounds(0, 0, 290, 190);
		panel_4_8.add(lblNewLabel_2_8);
		
		Panel panel_1_5_1 = new Panel();
		panel_1_5_1.setLayout(null);
		panel_1_5_1.setBackground(Color.BLACK);
		panel_1_5_1.setBounds(400, 550, 300, 200);
		panel.add(panel_1_5_1);
		
		Panel panel_4_6_1 = new Panel();
		panel_4_6_1.setLayout(null);
		panel_4_6_1.setBackground(Color.WHITE);
		panel_4_6_1.setBounds(5, 5, 290, 190);
		panel_1_5_1.add(panel_4_6_1);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("");
		lblNewLabel_2_6_1.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[10]+".jpg")));
		lblNewLabel_2_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_5_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_5_1.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[10],cusID);
			}
		});
		lblNewLabel_2_6_1.setBounds(0, 0, 290, 190);
		panel_4_6_1.add(lblNewLabel_2_6_1);
		
		Panel panel_1_5_2 = new Panel();
		panel_1_5_2.setLayout(null);
		panel_1_5_2.setBackground(Color.BLACK);
		panel_1_5_2.setBounds(750, 550, 300, 200);
		panel.add(panel_1_5_2);
		
		Panel panel_4_6_2 = new Panel();
		panel_4_6_2.setLayout(null);
		panel_4_6_2.setBackground(Color.WHITE);
		panel_4_6_2.setBounds(5, 5, 290, 190);
		panel_1_5_2.add(panel_4_6_2);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("");
		lblNewLabel_2_6_2.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[11]+".jpg")));
		lblNewLabel_2_6_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_5_2.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_5_2.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[11],cusID);
			}
		});
		lblNewLabel_2_6_2.setBounds(0, 0, 290, 190);
		panel_4_6_2.add(lblNewLabel_2_6_2);
		
		Panel panel_1_5_3 = new Panel();
		panel_1_5_3.setLayout(null);
		panel_1_5_3.setBackground(Color.BLACK);
		panel_1_5_3.setBounds(1100, 550, 300, 200);
		panel.add(panel_1_5_3);
		
		Panel panel_4_6_3 = new Panel();
		panel_4_6_3.setLayout(null);
		panel_4_6_3.setBackground(Color.WHITE);
		panel_4_6_3.setBounds(5, 5, 290, 190);
		panel_1_5_3.add(panel_4_6_3);
		
		JLabel lblNewLabel_2_6_3 = new JLabel("");
		lblNewLabel_2_6_3.setIcon(new ImageIcon(Items.class.getResource("/images/itemsimg/"+item[12]+".jpg")));
		lblNewLabel_2_6_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_5_3.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_5_3.setBackground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				callBiddingFrame(item[12],cusID);
			}
		});
		lblNewLabel_2_6_3.setBounds(0, 0, 290, 190);
		panel_4_6_3.add(lblNewLabel_2_6_3);
		
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Home frame = new Home();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 0, 140, 37);
		panel_3.add(lblNewLabel_3);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(1220, 39, 150, 46);
		contentPane.add(panel_2_1);
		
		Panel panel_3_1 = new Panel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 250, 205));
		panel_3_1.setBounds(5, 5, 140, 36);
		panel_2_1.add(panel_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("BIDS");
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
			public void mouseClicked(MouseEvent arg0) {
				callbidsHistory(cusID);
			}
		});
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(0, 0, 140, 37);
		panel_3_1.add(lblNewLabel_3_1);
		
	 
	}
	public void checkAndRelpaceItem() {
		 dateFormat = new SimpleDateFormat("HH:mm:ss");
		 date = new Date();
		 currentAfterAdded = new Date();
		createConnection();
		int num = 1;
		int num2 = 1;
		double maxPriceAM = 0;
		

		
		try {
			Statement rstate = con.createStatement();
			Statement estate = con.createStatement();
	    	 ResultSet done2 = estate.executeQuery("select * from timeKeeper");
			  while(done2.next()) {
				//sold = done2.getBoolean("isSold");
				 date = new Date();
				 java.sql.Time f1 = done2.getTime("stopTime"); 
				 currentAfterAdded = new Date(f1.getTime());
				 int itemID = done2.getInt("itemID");
				 
				 if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(dateFormat.format(currentAfterAdded)))) {
					 PreparedStatement prestate = con.prepareStatement("UPDATE timeKeeper SET  isSold = ?  WHERE itemID = ?");
						prestate.setBoolean(1, true);
						prestate.setInt(2, itemID);
						prestate.execute();
						
						  
				        PreparedStatement restate = con.prepareStatement("UPDATE aucItems SET  onScreenNow = false  WHERE itemID = ?");
		                restate.setInt(1, itemID);
						restate.execute();
						
						ResultSet maxPrice = rstate.executeQuery("SELECT bids.bidID, customers.cusName, aucItems.itemID, MAX(bids.bidAmount) FROM ((bids "
								+ "INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
								+ "where aucItems.itemID = '"+itemID+"'");
					    while(maxPrice.next()) {
					    	System.out.print("here");
						  maxPriceAM = maxPrice.getDouble("MAX(bids.bidAmount)");
					     }
					
					    PreparedStatement testate = con.prepareStatement("UPDATE bids SET  isSuccess = true  WHERE bidAmount = ?");
		                testate.setDouble(1, maxPriceAM);
				        testate.execute();
						
					 	 
				 }
			  }
			
			
			
			
			
			
			
			Statement state = con.createStatement();
			ResultSet items = state.executeQuery("select * from aucitems where onScreenNow = true");
            while(items.next()) {
            	item[num] = items.getInt("itemID");
            	num++;
            	}
            	
            	
     	
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public void callBiddingFrame(int itemID,int cusID) {
		String itemName = null;
		double itemStartPrice = 0.0;
		createConnection();
		
		
		try {
			
			
			
			
			
			
			
			
			
			
			
			Statement state = con.createStatement();
			ResultSet item = state.executeQuery("select * from aucitems where itemID = '"+ itemID +"'");
			
			while(item.next()) {
				  itemName = item.getString("itemName");
				  itemStartPrice = item.getDouble("itemPrice");
				}
		   state.close();
		   dispose();
		   Bidding frame = new Bidding(itemID,itemName,itemStartPrice,cusID);
		   frame.setUndecorated(true);
		   frame.setVisible(true);
		   frame.highestBids(itemID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void callbidsHistory(int cusID) {
		dispose();
		bidsHistory frame = new bidsHistory(cusID);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	public void handleErr(String msg) {
		HandleErr frame = new HandleErr(msg);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
	}
	
	
	public void createConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","root"); 
		
		} catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e);
			e.printStackTrace();
		}  
	}
	
	
	}
