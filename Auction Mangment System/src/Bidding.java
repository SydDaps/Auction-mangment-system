import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.javafx.tk.Toolkit;

import java.awt.TextArea;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.Timer;

import java.text.*;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class Bidding extends JFrame {

	private JPanel contentPane;
	private JTextField bidField;
	public Timer timer;
	int xx,xy,min,sec,stop,maxPriceID;
	Connection con;
    JLabel Highest_1,Highest_2 ,Highest_3, startTime , endTime ;
    long ONE_MINUTE_IN_MILLIS;
    Date date ,currentAfterAdded;
    SimpleDateFormat dateFormat;
    Button placeBidButton;
    double maxPriceAM;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Bidding frame = new Bidding(2,"NOT FOUND!",66.9,2);
					
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
	public Bidding(int itemID, String itemName,double startPrice,int cusID) {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1650, 850);
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
		       Bidding.this.setLocation(x - xx, y - xy); 
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
		
		JLabel lblNewLabel_1 = new JLabel(" BIDINGS");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 40));
		lblNewLabel_1.setBounds(699, 26, 213, 59);
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
		String imgName = "/images/bigItems/"+itemID+".jpg";
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
		
		JLabel startLable = new JLabel("   STARTED :\r\n");
		startLable.setFont(new Font("Monospaced", Font.BOLD, 20));
		startLable.setBounds(5, 42, 150, 50);
		panel_4_2.add(startLable);
		
		JLabel lblNewLabel_4_2 = new JLabel(addStartBid(startPrice));
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
		
		bidField = new JTextField();
		bidField.setFont(new Font("Monospaced", Font.BOLD, 20));
		bidField.setBounds(0, 0, 226, 36);
		panel_6.add(bidField);
		bidField.setColumns(10);
		
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
		
		startTime = new JLabel("");
		startTime.setFont(new Font("Monospaced", Font.BOLD, 30));
		startTime.setBounds(167, 42, 176, 50);
		panel_4_2.add(startTime);
		
		endTime = new JLabel("");
		endTime.setFont(new Font("Monospaced", Font.BOLD, 30));
		endTime.setBounds(469, 42, 144, 50);
		panel_4_2.add(endTime);
		
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
		
		placeBidButton = new Button(" PLACE BID\r\n");
		placeBidButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_1.setBackground(Color.WHITE);	
				placeBidButton.setBackground(new Color(238, 232, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_1.setBackground(Color.BLACK);
				placeBidButton.setBackground(new Color(255, 250, 205));
			}
		});
		min = 2;
		sec = 60;
		placeBidButton.addActionListener(new ActionListener() {
 
			public void actionPerformed(ActionEvent arg0) {
				if(placeBidButton.getLabel().equals(" PLACE BID\r\n")) {
					placeBid(itemID,cusID);	
				}
				else {
					dispose();
					Items frame = new Items(cusID);
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
				
			
				
				
				
				  
	    	  
			}}
		);
		placeBidButton.setBackground(new Color(255, 250, 205));
		placeBidButton.setForeground(Color.BLACK);
		placeBidButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		placeBidButton.setBounds(0, 0, 140, 36);
		panel_3_1_1.add(placeBidButton);
		
		JLabel lblNewLabel_4_1 = new JLabel(" ENDS AT :");
		lblNewLabel_4_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(344, 42, 127, 50);
		panel_4_2.add(lblNewLabel_4_1);
		
		
		
	
		
		JLabel lblNewLabel_5 = new JLabel("HIGHEST BIDS \r\n");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_5.setBounds(0, 0, 640, 50);
		panel_4_2_1.add(lblNewLabel_5);
		
		Panel highest_1 = new Panel();
		highest_1.setLayout(null);
		highest_1.setBackground(new Color(255, 250, 205));
		highest_1.setBounds(5, 60, 640, 40);
		panel_4_1_1.add(highest_1);
		
		Highest_1 = new JLabel();
		Highest_1.setHorizontalAlignment(SwingConstants.LEFT);
		Highest_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		Highest_1.setBounds(0, 0, 640, 40);
		highest_1.add(Highest_1);
		
		Panel panel_4_2_1_2 = new Panel();
		panel_4_2_1_2.setLayout(null);
		panel_4_2_1_2.setBackground(new Color(255, 250, 205));
		panel_4_2_1_2.setBounds(5, 105, 640, 40);
		panel_4_1_1.add(panel_4_2_1_2);
		
		Highest_2 = new JLabel("");
		Highest_2.setHorizontalAlignment(SwingConstants.LEFT);
		Highest_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		Highest_2.setBounds(0, 0, 640, 40);
		panel_4_2_1_2.add(Highest_2);
		
		Panel panel_4_2_1_3 = new Panel();
		panel_4_2_1_3.setLayout(null);
		panel_4_2_1_3.setBackground(new Color(255, 250, 205));
		panel_4_2_1_3.setBounds(5, 150, 640, 40);
		panel_4_1_1.add(panel_4_2_1_3);
		
		Highest_3 = new JLabel("\r\n");
		Highest_3.setHorizontalAlignment(SwingConstants.LEFT);
		Highest_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		Highest_3.setBounds(0, 0, 640, 40);
		panel_4_2_1_3.add(Highest_3);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				highestBids(itemID);
				
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
				Items frame = new Items(cusID);
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
	public String addStartBid(double startBid) {
		String sbid = String.valueOf(startBid); 
		return sbid = "   START BID : $"+sbid;
		
	}
	
	public void placeBid(int itemID,int cusID) {
		 double currentBid = 0.0;
		 double itemStartPrice = 0.0;
		 boolean sold = false;
		 dateFormat = new SimpleDateFormat("HH:mm:ss");
		 date = new Date();
		 currentAfterAdded = new Date();
		 createConnection();
		 maxPriceID = 0;
		 maxPriceAM = 0;
		 double currentMaxPrice = 0;
		
		 
	//Before a bid is placed check is the field is empty and handle error 	 
		if(bidField.getText().isEmpty()) {
			handleErr("Enter your bid price");
			return;
		}
	//if Not get current Bid price from Text Field  
	    currentBid = Double.parseDouble(bidField.getText());
	    
	//Now check from time keeper if time is up and update required fields 
	    try {
	    	 Statement state = con.createStatement();
	    	 ResultSet done2 = state.executeQuery("select * from timeKeeper where itemID = '"+itemID+"'");
			  while(done2.next()) {
				sold = done2.getBoolean("isSold");
				 java.sql.Time f1 = done2.getTime("stopTime"); 
				 currentAfterAdded = new Date(f1.getTime());
			  }
			  if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(dateFormat.format(currentAfterAdded)))) {
				System.out.println("Item sold do something");
				startTime.setText("SOLD !");
		        endTime.setText("SOLD !");
		        placeBidButton.setLabel(" BACK\r\n");
		        
		        PreparedStatement prestate = con.prepareStatement("UPDATE timeKeeper SET  isSold = ?  WHERE itemID = ?");
				prestate.setBoolean(1, true);
				prestate.setInt(2, itemID);
				prestate.execute();
				
				  
		        PreparedStatement restate = con.prepareStatement("UPDATE aucItems SET  onScreenNow = false  WHERE itemID = ?");
                restate.setInt(1, itemID);
				restate.execute();
				
				ResultSet maxPrice = state.executeQuery("SELECT bids.bidID, customers.cusName, aucItems.itemID, MAX(bids.bidAmount) FROM ((bids "
						+ "INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
						+ "where aucItems.itemID = '"+itemID+"'");
			    while(maxPrice.next()) {
			    	  maxPriceAM = maxPrice.getDouble("MAX(bids.bidAmount)");
			     }
			
			    PreparedStatement testate = con.prepareStatement("UPDATE bids SET  isSuccess = true  WHERE bidAmount = ?");
               testate.setDouble(1, maxPriceAM);
		        testate.execute();
				return;
			  }
			 
			
	//checking if currentBid is lesser than the strat bid to throw an error 
			ResultSet item = state.executeQuery("select * from aucitems where itemID = '"+ itemID +"'");
			
			while(item.next()) {
				  itemStartPrice = item.getDouble("itemPrice");
				  }
		  if(currentBid <=  itemStartPrice) {
			  handleErr("Top Up to place Bid");
			return;
		  }
  //Now we will get the maximum bid and make sure you bid is higher to continue	  
		  ResultSet MaxbidNow = state.executeQuery("SELECT bids.bidID, customers.cusName, aucItems.itemID, bids.bidAmount FROM ((bids "
					+ "INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
					+ "where aucItems.itemID = '"+itemID+"' ");
		  while(MaxbidNow.next()) {
			  currentMaxPrice = MaxbidNow.getDouble("bids.bidAmount");
			  
		  }
		 if( currentBid <=  currentMaxPrice &&  currentMaxPrice != 0) {
			 handleErr("Place Bid higher than $"+ currentMaxPrice);
				return;
		 }
		  
		
		  PreparedStatement prestate = con.prepareStatement("INSERT INTO bids (cusID,itemID,bidAmount) VALUES (?,?,?)");
		  prestate.setInt(1, cusID);
		  prestate.setInt(2, itemID);
		  prestate.setDouble(3, currentBid);
		  prestate.execute();
		  setTime(itemID);
		  highestBids(itemID);
		 
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	    
	}
	
	public void highestBids(int itemID) {
		String[] cusName = new String[100] ;
		double[] bidAmount = new double[100];
		String cusBid = null;
		int count = 0;
		createConnection();
		 try {
				Statement state = con.createStatement();
				ResultSet hbids = state.executeQuery("SELECT bids.bidID, customers.cusName, aucItems.itemID, bids.bidAmount FROM ((bids "
						+ "INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
						+ "where aucItems.itemID = '"+itemID+"' ORDER BY bidAmount DESC;");
				
				while(hbids.next()) {
				      cusName[count] = hbids.getString("cusName");
					  bidAmount[count] = hbids.getDouble("bidAmount");
					  count++;
					  }
				
				Highest_1.setText("\r\n \r\n 1st. "+ cusName[0] +"  - - ->   $"+ bidAmount[0]);
				Highest_2.setText("\r\n \r\n 2nd. "+ cusName[1] +"  - - ->   $"+ bidAmount[1]);
				Highest_3.setText("\r\n \r\n 3rd. "+ cusName[2] +"  - - ->   $"+ bidAmount[2]);
				
				
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    
		
	}
	
	public void setTime(int itemID) {
		 createConnection();
		  ONE_MINUTE_IN_MILLIS = 60000;
		  currentAfterAdded = new Date();
		  date = new Date();
		  long t= date.getTime();
  		  Date afterAddingMins=new Date(t + (1 * ONE_MINUTE_IN_MILLIS));
  		  long time = afterAddingMins.getTime();
  		  dateFormat = new SimpleDateFormat("HH:mm:ss");
  		  int check = 0;
  		  maxPriceID = 0;
  		  maxPriceAM = 0;
  		
		  try {
			  Statement state = con.createStatement();
			  ResultSet done = state.executeQuery("select * from timeKeeper where itemID = '"+itemID+"'");
			  while(done.next()) {
				  java.sql.Time f1 = done.getTime("stopTime"); 
				  currentAfterAdded = new Date(f1.getTime());
				  check = done.getInt("timeKeeperID");  
			  }
			  if(check == 0) {
					  System.out.println("No Record");  
					  PreparedStatement prestate = con.prepareStatement("INSERT INTO timeKeeper (itemID,stopTime) VALUES (?,?)");
					  prestate.setInt(1,itemID);
					  prestate.setTime(2,new java.sql.Time(time));
					  prestate.execute();
			  }
			  ResultSet done2 = state.executeQuery("select * from timeKeeper where itemID = '"+itemID+"'");
			  while(done2.next()) {
				  java.sql.Time f1 = done2.getTime("stopTime"); 
				  currentAfterAdded = new Date(f1.getTime()); 
			  }
			
	  	 timer = new Timer(1000, new ActionListener() {
	    	   @Override
		          public void actionPerformed(ActionEvent e) {
	    		 date = new Date();
   	  	        
	    		try {
	    			if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(dateFormat.format(currentAfterAdded))))
	    			{
	    				startTime.setText("SOLD !");
				        endTime.setText("SOLD !");
				        placeBidButton.setLabel(" BACK\r\n");
				        
				        PreparedStatement prestate = con.prepareStatement("UPDATE timeKeeper SET  isSold = ?  WHERE itemID = ?");
						prestate.setBoolean(1, true);
						prestate.setInt(2, itemID);
						prestate.execute();
					    
						 PreparedStatement restate = con.prepareStatement("UPDATE aucItems SET  onScreenNow = false  WHERE itemID = ?");
			             restate.setInt(1, itemID);
					     restate.execute();
					   
					     Statement state = con.createStatement();
						 
					     ResultSet maxPrice = state.executeQuery("SELECT bids.bidID, customers.cusName, aucItems.itemID, MAX(bids.bidAmount) FROM ((bids "
									+ "INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)"
									+ "where aucItems.itemID = '"+itemID+"'");
						while(maxPrice.next()) {
							  maxPriceAM = maxPrice.getDouble("MAX(bids.bidAmount)");
					     }
					
					    PreparedStatement testate = con.prepareStatement("UPDATE bids SET  isSuccess = true  WHERE bidAmount = ?");
		                testate.setDouble(1, maxPriceAM);
				        testate.execute();
					    
					    timer.stop();
	    				return;
	    			}else{
	    				startTime.setText(dateFormat.format(date));
				        endTime.setText(dateFormat.format(currentAfterAdded));
	    			
	    			}
	    		} catch (ParseException | SQLException e1) {
	    		
	    			e1.printStackTrace();
	    		}
 
	         }
          });
      timer.start();
			  
		  } catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
		}
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
			System.out.println("DATABASE CONNECTED SUCCESS");
		} catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e);
			e.printStackTrace();
		}  
	}
}
