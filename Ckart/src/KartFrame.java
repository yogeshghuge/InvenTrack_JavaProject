import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class KartFrame implements ActionListener{
	
	//main frame and reg and update elements
	String Location="D:\\";
	
	JFrame f;
	
	private JButton close,PR,PU,PI,PO,PD;
	
	private JLabel Img;
	
	private JPanel ppr;
	
	JFrame fpr,fpu;
	
	JButton save,cancel;
	
	JLabel pid,pname,pcom,pq,ppu,plogo,preg,terms,agree;
	
	static JTextField tf1,tf2,tf3,tf4,tf5;
	
	JComboBox read;
	
	JCheckBox check;
	

	
	//for product info
	
	static JFrame fpi=new JFrame("Product Details");
	static DefaultTableModel dtmCustomer;
	static JTable tbCustomer;
	static JScrollPane jspTable;
	static JButton back,delete;
	static JTextField tfd;
	static JLabel lpi,lpd,lid;
	
	//for product order
	
	static JCheckBox p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
	static JTextField f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15;
	static JButton order,CO,bk;
	static JFrame fpo=new JFrame("Product order");
	static JPanel panel;
	static JLabel ol;
	
	
	static void populateArray(String rows[][])  
	{
		
		JPanel jpShow=new JPanel();
		jpShow.setBackground(Color.orange);
		
		int row=0;
		int total=0;
		int pID=0;
		
		fpi.setSize(1500,1000);
		fpi.setLocationRelativeTo(null);
		
		
		tbCustomer= makeTable(rows);
		jspTable=new JScrollPane(tbCustomer);
		jspTable.setBounds(200,100,800,800);
		
		lpi=new JLabel("Product Details");
		lpi.setBounds(600,20,400,60);
		jpShow.add(lpi);
		
		jpShow.add(jspTable);
		
		jpShow.setLayout(null);
		
		fpi.getContentPane().add(jpShow);
		fpi.setAlwaysOnTop(true);
		
		
		back=new JButton("BACK");
		back.setBounds(40,40,120,40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		jpShow.add(back);
		
		//product deletation
		
		lpd=new JLabel("Product Deletation");
		lpd.setBounds(1110,100,200,60);
		lpd.setVisible(false);
		jpShow.add(lpd);
		
		lid=new JLabel("Product ID");
		lid.setBounds(1110,250,150,60);
		lid.setVisible(false);
		jpShow.add(lid);
		
		tfd=new JTextField();
		tfd.setBounds(1270,250,200,60);
		tfd.setVisible(false);
		jpShow.add(tfd);
		
		delete=new JButton("Delete");
		delete.setBounds(1400,400,80,30);
		delete.setVisible(false);
		jpShow.add(delete);
		
		tfd.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);

		
		delete.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		Object obj2=e.getSource();
		
		
		String pid=tfd.getText();
		
		 if(tfd.getText().equals(""))
			{
				JOptionPane.showMessageDialog
				  (fpi, "Please! Provide Product ID.",
				                "Registration System - EmptyField",
				                JOptionPane.PLAIN_MESSAGE);

				tfd.requestFocus();
			}
		 else if(obj2==delete)
		{
		
			System.out.print(pid);
			

			
			DeleteFromDatabase.delete(pid);
			tfd.setText("");
			fpi.setVisible(false);
			fpi.setVisible(true);

		}
	}
		});
		

		back.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		Object obj2=e.getSource();
		
		if(obj2==back)
		{
			fpi.setVisible(false);

		}
	}
		});
		
		//for product order
		p1=new JCheckBox();
		p1.setBounds(150,121,50,50);
		p1.setBackground(Color.black);
		p1.setVisible(false);
		jpShow.add(p1);
		
		p2=new JCheckBox();
		p2.setBounds(150,171,50,50);
		p2.setBackground(Color.black);
		p2.setVisible(false);
		jpShow.add(p2);
		

		
		p3=new JCheckBox();
		p3.setBounds(150,221,50,50);
		p3.setBackground(Color.black);
		p3.setVisible(false);
		jpShow.add(p3);
		
		p4=new JCheckBox();
		p4.setBounds(150,271,50,50);
		p4.setBackground(Color.black);
		p4.setVisible(false);
		jpShow.add(p4);
		
		p5=new JCheckBox();
		p5.setBounds(150,321,50,50);
		p5.setBackground(Color.black);
		p5.setVisible(false);
		jpShow.add(p5);
		
		p6=new JCheckBox();
		p6.setBounds(150,371,50,50);
		p6.setBackground(Color.black);
		p6.setVisible(false);
		jpShow.add(p6);
		
		p7=new JCheckBox();
		p7.setBounds(150,421,50,50);
		p7.setBackground(Color.black);
		p7.setVisible(false);
		jpShow.add(p7);
		
		p8=new JCheckBox();
		p8.setBounds(150,471,50,50);
		p8.setBackground(Color.black);
		p8.setVisible(false);
		jpShow.add(p8);
		
		p9=new JCheckBox();
		p9.setBounds(150,521,50,50);
		p9.setBackground(Color.black);
		p9.setVisible(false);
		jpShow.add(p9);
		
		p10=new JCheckBox();
		p10.setBounds(150,571,50,50);
		p10.setBackground(Color.black);
		p10.setVisible(false);
		jpShow.add(p10);
		
		p11=new JCheckBox();
		p11.setBounds(150,621,50,50);
		p11.setBackground(Color.black);
		p11.setVisible(false);
		jpShow.add(p11);
		
		p12=new JCheckBox();
		p12.setBounds(150,671,50,50);
		p12.setBackground(Color.black);
		p12.setVisible(false);
		jpShow.add(p12);
		
		p13=new JCheckBox();
		p13.setBounds(150,721,50,50);
		p13.setBackground(Color.black);
		p13.setVisible(false);
		jpShow.add(p13);
		
		p14=new JCheckBox();
		p14.setBounds(150,771,50,50);
		p14.setBackground(Color.black);
		p14.setVisible(false);
		jpShow.add(p14);
		
		p15=new JCheckBox();
		p15.setBounds(150,821,50,50);
		p15.setBackground(Color.black);
		p15.setVisible(false);
		jpShow.add(p15);
		
		
		f1=new JTextField();
		f1.setBounds(1000,121,50,50);
		f1.setForeground(Color.white);
		f1.setBackground(Color.black);
		f1.setVisible(false);
		jpShow.add(f1);
		
		f2=new JTextField();
		f2.setBounds(1000,171,50,50);
		f2.setForeground(Color.white);
		f2.setBackground(Color.black);
		f2.setVisible(false);
		jpShow.add(f2);
		

		
		f3=new JTextField();
		f3.setBounds(1000,221,50,50);
		f3.setBackground(Color.black);
		f3.setForeground(Color.white);
		f3.setVisible(false);
		jpShow.add(f3);
		
		f4=new JTextField();
		f4.setBounds(1000,271,50,50);
		f4.setBackground(Color.black);
		f4.setForeground(Color.white);
		f4.setVisible(false);
		jpShow.add(f4);
		
		f5=new JTextField();
		f5.setBounds(1000,321,50,50);
		f5.setBackground(Color.black);
		f5.setForeground(Color.white);
		f5.setVisible(false);
		jpShow.add(f5);
		
		f6=new JTextField();
		f6.setBounds(1000,371,50,50);
		f6.setBackground(Color.black);
		f6.setForeground(Color.white);
		f6.setVisible(false);
		jpShow.add(f6);
		
		f7=new JTextField();
		f7.setBounds(1000,421,50,50);
		f7.setBackground(Color.black);
		f7.setForeground(Color.white);
		f7.setVisible(false);
		jpShow.add(f7);
		
		f8=new JTextField();
		f8.setBounds(1000,471,50,50);
		f8.setBackground(Color.black);
		f8.setForeground(Color.white);
		f8.setVisible(false);
		jpShow.add(f8);
		
		f9=new JTextField();
		f9.setBounds(1000,521,50,50);
		f9.setBackground(Color.black);
		f9.setForeground(Color.white);
		f9.setVisible(false);
		jpShow.add(f9);
		
		f10=new JTextField();
		f10.setBounds(1000,571,50,50);
		f10.setBackground(Color.black);
		f10.setForeground(Color.white);
		f10.setVisible(false);
		jpShow.add(f10);
		
		f11=new JTextField();
		f11.setBounds(1000,621,50,50);
		f11.setBackground(Color.black);
		f11.setForeground(Color.white);
		f11.setVisible(false);
		jpShow.add(f11);
		
		f12=new JTextField();
		f12.setBounds(1000,671,50,50);
		f12.setBackground(Color.black);
		f12.setForeground(Color.white);
		f12.setVisible(false);
		jpShow.add(f12);
		
		f13=new JTextField();
		f13.setBounds(1000,721,50,50);
		f13.setBackground(Color.black);
		f13.setForeground(Color.white);
		f13.setVisible(false);
		jpShow.add(f13);
		
		f14=new JTextField();
		f14.setBounds(1000,771,50,50);
		f14.setBackground(Color.black);
		f14.setForeground(Color.white);
		f14.setVisible(false);
		jpShow.add(f14);
		
		f15=new JTextField();
		f15.setBounds(1000,821,50,50);
		f15.setBackground(Color.black);
		f15.setForeground(Color.white);
		f15.setVisible(false);
		jpShow.add(f15);
		
		//order button
		order=new JButton("PLACE ORDER");
		order.setBounds(1070,600,200,50);
		order.setForeground(Color.red);
		jpShow.add(order);
		
		//Cancel order button
		
		//order button
		CO=new JButton("CANCEL");
		CO.setBounds(1350,600,100,50);
		CO.setForeground(Color.blue);
		jpShow.add(CO);
		
		p1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p1.isSelected())
			{
				f1.setVisible(true);
			}
			else 
			{
				f1.setVisible(false);
				f1.setText("");
			}
		}
		});
		
		p2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p2.isSelected())
			{
				f2.setVisible(true);
			}
			else 
			{
				f2.setVisible(false);
				f2.setText("");
			}
		}
		});
		
		p3.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p3.isSelected())
			{
				f3.setVisible(true);
			}
			else 
			{
				f3.setVisible(false);
				f3.setText("");
			}
		}
		});
		
		p4.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p4.isSelected())
			{
				f4.setVisible(true);
			}
			else 
			{
				f4.setVisible(false);
				f4.setText("");
			}
		}
		});
		
		p5.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p5.isSelected())
			{
				f5.setVisible(true);
			}
			else 
			{
				f5.setVisible(false);
				f5.setText("");
			}
		}
		});
		
		p6.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p6.isSelected())
			{
				f6.setVisible(true);
			}
			else 
			{
				f6.setVisible(false);
				f6.setText("");
			}
		}
		});
		
		p7.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p7.isSelected())
			{
				f7.setVisible(true);
			}
			else 
			{
				f7.setVisible(false);
				f7.setText("");
			}
		}
		});
		
		p8.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p8.isSelected())
			{
				f8.setVisible(true);
			}
			else 
			{
				f8.setVisible(false);
				f8.setText("");
			}
		}
		});
		
		
		p9.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p9.isSelected())
			{
				f9.setVisible(true);
			}
			else 
			{
				f9.setVisible(false);
				f9.setText("");
			}
		}
		});
		
		p10.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p10.isSelected())
			{
				f10.setVisible(true);
			}
			else 
			{
				f10.setVisible(false);
				f10.setText("");
			}
		}
		});
		
		
		p11.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p11.isSelected())
			{
				f11.setVisible(true);
			}
			else 
			{
				f11.setVisible(false);
				f11.setText("");
			}
		}
		});
		
		
		p12.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p12.isSelected())
			{
				f12.setVisible(true);
			}
			else 
			{
				f12.setVisible(false);
				f12.setText("");
			}
		}
		});
		
		
		p13.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p13.isSelected())
			{
				f13.setVisible(true);
			}
			else 
			{
				f13.setVisible(false);
				f13.setText("");
			}
		}
		});
		
		
		p14.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p14.isSelected())
			{
				f14.setVisible(true);
			}
			else 
			{
				f14.setVisible(false);
				f14.setText("");
			}
		}
		});
		
		
		p15.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(p15.isSelected())
			{
				f15.setVisible(true);
			}
			else 
			{
				f15.setVisible(false);
				f15.setText("");
				
			}
		}
		});
		
		f1.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f1.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f1.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		

		
		f2.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f3.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f3.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f4.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f5.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f6.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f7.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f8.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f9.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f10.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f11.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f12.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f13.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		
		f14.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);

		f15.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					fpi.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);
		

		
		order.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(obj==order)
			{
				int n=0,n1=0,n2=0,n3=0,n4=0,n5=0,n6=0,n7=0,n8=0,n9=0,n10=0,n11=0,n12=0,n13=0,n14=0,n15=0;
				
				fpo.setSize(1500,1000);
				fpo.setLocationRelativeTo(null);
				fpo.setBackground(Color.black);
				fpo.setLayout(null);
				fpi.setVisible(false);
				
				String s1=f1.getText();
				String s2=f2.getText();
				String s3=f3.getText();
				String s4=f4.getText();
				String s5=f5.getText();
				String s6=f6.getText();
				String s7=f7.getText();
				String s8=f8.getText();
				String s9=f9.getText();
				String s10=f10.getText();
				String s11=f11.getText();
				String s12=f12.getText();
				String s13=f13.getText();
				String s14=f14.getText();
				String s15=f15.getText();
				
				if(s1.length()>0)
				{
					n1=Integer.parseInt(s1);
				}
				
				
				if(s2.length()>0)
				{
					n2=Integer.parseInt(s2);
				}
				
				
				if(s3.length()>0)
				{
					n3=Integer.parseInt(s3);
				}				
				
				if(s4.length()>0)
				{
					n4=Integer.parseInt(s4);
				}	
				
				
				if(s5.length()>0)
				{
					n5=Integer.parseInt(s5);
				}				
				
				if(s6.length()>0)
				{
					n6=Integer.parseInt(s6);
				}				
				
				if(s7.length()>0)
				{
					n7=Integer.parseInt(s7);
				}				
				
				if(s8.length()>0)
				{
					n8=Integer.parseInt(s8);
				}				
				
				if(s9.length()>0)
				{
					n9=Integer.parseInt(s9);
				}
				
				if(s10.length()>0)
				{
					n10=Integer.parseInt(s10);
				}				
				
				if(s11.length()>0)
				{
					n11=Integer.parseInt(s11);
				}				
				
				if(s12.length()>0)
				{
					n12=Integer.parseInt(s12);
				}
				
				
				if(s13.length()>0)
				{
					n13=Integer.parseInt(s13);
				}
				
				
				if(s14.length()>0)
				{
					n14=Integer.parseInt(s14);
				}
				
				if(s15.length()>0)
				{
					n15=Integer.parseInt(s15);
				}

				//taking product price from database
				
				int a[]=new int[15];
				try
				{
					DAO db=new DAO();
					
					Connection conn=db.getConnection();
					
					String selectQuery="select ppriceperunit from productdetails ";
					
					PreparedStatement preparedStatement=conn.prepareStatement(selectQuery);
					
					ResultSet result=preparedStatement.executeQuery();
					
					int j=0;
					
					while(result.next() || j<15)
					{

						for(int i=0;i<1;i++)  //here we taken i<1 bcoz there is only one column of priceperunit  and j to add 
												//at perticular place in array from 0 to14
						{
							a[j]=Integer.parseInt(result.getString((i+1)));
							System.out.println(a[j]+"");
						
						}
						
						j++;
							
						
					}
				}

				
				
					catch(Exception e1)
					{
						System.out.println(e1);
					}

				for(int i=0;i<15;i++)
				{			
					System.out.println(a[i]+"");					
				}
				
				//this is price of product per unit from first to last product 

				

				int pp1=a[0],pp2=a[1],pp3=a[2],pp4=a[3],pp5=a[4],pp6=a[5],pp7=a[6],pp8=a[7],pp9=a[8],pp10=a[9],
						pp11=a[10],pp12=a[11],pp13=a[12],pp14=a[13],pp15=a[14];
				
				
				//n is total payble bill
				
			    n=(pp1*n1)+(pp2*n2)+(pp3*n3)+(pp4*n4)+(pp5*n5)+(pp6*n6)+(pp7*n7)+(pp8*n8)+(pp9*n9)+(pp10*n10)+(pp11*n11)
						+(pp12*n12)+(pp13*n13)+(pp14*n14)+(pp15*n15);
			    
			    f1.setText("");
			    f2.setText("");
			    f3.setText("");
			    f4.setText("");
			    f5.setText("");
			    f6.setText("");
			    f7.setText("");
			    f8.setText("");
			    f9.setText("");
			    f10.setText("");
			    f11.setText("");
			    f12.setText("");
			    f13.setText("");
			    f14.setText("");
			    f15.setText("");
				
				panel=new JPanel();
				panel.setBounds(0,0,1500,1000);
				panel.setBackground(new Color(240,125,24));
				fpo.add(panel);
				
				ol=new JLabel("TOTAL PAYBLE BILL = "+n);
				ol.setBounds(400,300,200,70);
				ol.setBackground(Color.red);
				panel.add(ol);
				

				
				fpo.add(panel);
				fpo.setLayout(null);
				
				bk=new JButton("Back");
				bk.setBounds(100,100,100,50);
				bk.setBackground(Color.yellow);
				
				panel.add(bk);
				
				bk.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					Object obj=e.getSource();
					
					if(obj==bk)
					{
						fpi.setVisible(false);
						fpo.setVisible(false);
					}
				}
				});
				
				fpo.setVisible(true);
				 JOptionPane.showMessageDialog(null,"Your order placed Successfully!!!");
			}
			
		}
		});
		
		fpi.setVisible(true);
		
		CO.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			
			if(obj==CO)
			{
				fpi.setVisible(false);
				
			}
		}
		});
		
		
		
	}
	private static JTable makeTable(String rowData[][])
	{
		String cols[]={"Product Id","product Name","company","Av Quantity","priceper unit"};
		dtmCustomer =new DefaultTableModel(rowData,cols);
		
		tbCustomer =new JTable(dtmCustomer)
		{
			public boolean isCellEditable(int iRow,int iCol)
			{
				return false;//Disable All Columns of Table.
			}
		};
		tbCustomer.setBackground(new Color(0,0,0));
		tbCustomer.setForeground( Color.white);
		
		(tbCustomer.getColumnModel().getColumn(0)).setPreferredWidth(100);
		
		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth(200);
		
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth(200);
		
		(tbCustomer.getColumnModel().getColumn(3)).setPreferredWidth(100);
		
		(tbCustomer.getColumnModel().getColumn(4)).setPreferredWidth(100);
		
		tbCustomer.setRowHeight(50);
		
		tbCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		return tbCustomer;
		
		
		
		
	}
	


	//for textclear
	
	static void textClear()
	{
		tf1.setText("");tf2.setText("");tf3.setText("");tf4.setText("");tf5.setText("");
		tf1.requestFocus();
	}



	
	KartFrame()
	{
		f=new JFrame();
		f.setSize(1500,1000);
		f.setLocationRelativeTo(null);
		//f.setResizable(false);
		
		
		
		PR=new JButton("Product Registration");
		PR.setBounds(100,200,250,60);
		PR.setBackground(new Color(0,0,0));
		PR.setForeground(Color.white);
		f.add(PR);
		
		PU=new JButton("Update Product");
		PU.setBounds(100,300,250,60);
		PU.setBackground(new Color(0,0,0));
		PU.setForeground(Color.white);
		f.add(PU);
		
		PI=new JButton("Product Information");
		PI.setBounds(100,400,250,60);
		PI.setBackground(new Color(0,0,0));
		PI.setForeground(Color.white);
		f.add(PI);
		
	
		
		
		PO=new JButton("Place Order");
		PO.setBounds(100,500,250,60);
		PO.setBackground(new Color(0,0,0));
		PO.setForeground(Color.white);
		f.add(PO);
		
		PD=new JButton("Delete Product");
		PD.setBounds(100,600,250,60);
		PD.setBackground(new Color(0,0,0));
		PD.setForeground(Color.white);
		f.add(PD);		
		
		
		PR.addActionListener(this);
		PU.addActionListener(this);
		PI.addActionListener(this);
		PO.addActionListener(this);
		PD.addActionListener(this);
		
		
		Img=new JLabel();
		Img.setBounds(200,200,1500,1000);
		Img.setIcon(new ImageIcon(Location+"FkartImg1.jpg"));
		//Img.setVisible(true);

		
		close=new JButton("CLOSE");
		close.setBounds(40,40,120,40);
		close.setBackground(Color.black);
		close.setForeground(Color.white);
		f.add(close);
		
		close.addActionListener(this);
		
		f.add(Img);
		f.setVisible(true);
	}

	


	
	public void actionPerformed(ActionEvent e) {

		Object obj=e.getSource();
		
		if(obj==close)
		{
 
			f.setVisible(false); 
			//fpr.setVisible(false); 
			//fpu.setVisible(false); 
			//fpi.setVisible(false);
			
			
		}
		
		else if(obj==PR)
		{
			
			//f.setVisible(false);
			try
			{
			fpr=new JFrame();
			fpr.setSize(1500,1000);
			fpr.setVisible(true);
			fpr.setLayout(null);
			fpr.setLocationRelativeTo(null);
			

			
			
			
			preg=new JLabel("Register Your Product Here");
			preg.setBounds(20,20,500,100);
			fpr.add(preg);
			
			pid=new JLabel("Product ID");
			pid.setBounds(40,150,200,50);
			fpr.add(pid);
			
			tf1=new JTextField();
			tf1.setBounds(300,150,250,50);
			fpr.add(tf1);
			
			
			pname=new JLabel("Product Name");
			pname.setBounds(40,250,200,50);
			fpr.add(pname);
			
			tf2=new JTextField();
			tf2.setBounds(300,250,250,50);
			fpr.add(tf2);
			
			pcom=new JLabel("Product Company");
			pcom.setBounds(40,350,200,50);
			fpr.add(pcom);
			
			tf3=new JTextField();
			tf3.setBounds(300,350,250,50);
			fpr.add(tf3);
			
			
			pq=new JLabel("Product Quantity");
			pq.setBounds(40,450,200,50);
			fpr.add(pq);
			
			tf4=new JTextField();
			tf4.setBounds(300,450,250,50);
			fpr.add(tf4);
			
			ppu=new JLabel("Price Per Unit");
			ppu.setBounds(40,550,200,50);
			fpr.add(ppu);
			
			tf5=new JTextField();
			tf5.setBounds(300,550,250,50);
			fpr.add(tf5);
			
			plogo=new JLabel();
			plogo.setBounds(600,300,230,230);
			plogo.setIcon(new ImageIcon(Location+"ckartlogo.jpg"));
			fpr.add(plogo);
			
			terms=new JLabel("Terms & conditions");
			terms.setBounds(40,650,250,80);
			fpr.add(terms);
			
			String cond[]={"you are chutiya to register at chutiya kart "};
			
			read=new JComboBox(cond);
			read.setBounds(300,650,250,50);
			fpr.add(read);
			
			agree=new JLabel("Agree");
			agree.setBounds(300,750,120,50);
			fpr.add(agree);
			
			check=new JCheckBox();
			check.setBounds(430,750,120,50);
			fpr.add(check);
			

			
			save=new JButton("SAVE");
			save.setBounds(600,750,300,60);
			save.setVisible(false);
			fpr.add(save);
			
			cancel=new JButton("CANCEL");
			cancel.setBounds(900,750,300,60);
			fpr.add(cancel);
			
			tf1.addKeyListener (new KeyAdapter()
			{
				public void keyTyped (KeyEvent ke)
				{
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
					{
						fpr.getToolkit().beep ();
						ke.consume ();
	      			}
	    		}
	  		}
			);
			
			tf4.addKeyListener (new KeyAdapter()
			{
				public void keyTyped (KeyEvent ke)
				{
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
					{
						fpr.getToolkit().beep ();
						ke.consume ();
	      			}
	    		}
	  		}
			);
			
			tf5.addKeyListener (new KeyAdapter()
			{
				public void keyTyped (KeyEvent ke)
				{
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
					{
						fpr.getToolkit().beep ();
						ke.consume ();
	      			}
	    		}
	  		}
			);

			check.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			Object obj1=e.getSource();
					
			if(check.isSelected())
			{
				save.setVisible(true);
			}
			else 
			{
				save.setVisible(false);
			}
			}
			});
	
			save.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			Object obj1=e.getSource();
			
			if(obj1==save)
			{
				if (tf1.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpr, "Please! Provide Product Id.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf1.requestFocus();
				}
				
				else if (tf2.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpr, "Please! Provide Product name.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf2.requestFocus();
				}
				
				else if (tf3.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpr, "Please! Provide Product company.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf3.requestFocus();
				}
				
				else if (tf4.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpr, "Please! Provide Product quantity.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf4.requestFocus();
				}
				
				else if (tf5.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpr, "Please! Provide Product price per unit.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf5.requestFocus();
				}
				
				else
				{
					String productID=tf1.getText().trim();
					String productName=tf2.getText().trim();
					String company=tf3.getText().trim();
					String quantity=tf4.getText().trim();
					String priceperunit=tf5.getText().trim();
					
					InsertIntoDatabase.insert(productID,productName,company,quantity,priceperunit);
					textClear();
				}
				


			}
		}
			});
			


			cancel.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			Object obj1=e.getSource();
			
			if(obj1==cancel)
			{
				fpr.setVisible(false);

			}
		}
			});
			
			}
			catch (Exception e1)
			{
				System.out.print(e1);
			}
			

		}
		
		//product Update
		
		else if(obj==PU)
		{
			//f.setVisible(false);
			
			fpu=new JFrame();
			fpu.setSize(1500,1000);
			fpu.setVisible(true);
			fpu.setLayout(null);
			fpu.setLocationRelativeTo(null);

			
			
			
			preg=new JLabel("Register Your Product Here");
			preg.setBounds(20,20,500,100);
			fpu.add(preg);
			
			pid=new JLabel("Product ID");
			pid.setBounds(40,150,200,50);
			fpu.add(pid);
			
			tf1=new JTextField();
			tf1.setBounds(300,150,250,50);
			fpu.add(tf1);
			
			
			pname=new JLabel("Product Name");
			pname.setBounds(40,250,200,50);
			fpu.add(pname);
			
			tf2=new JTextField();
			tf2.setBounds(300,250,250,50);
			fpu.add(tf2);
			
			pcom=new JLabel("Product Company");
			pcom.setBounds(40,350,200,50);
			fpu.add(pcom);
			
			tf3=new JTextField();
			tf3.setBounds(300,350,250,50);
			fpu.add(tf3);
			
			
			pq=new JLabel("Product Quantity");
			pq.setBounds(40,450,200,50);
			fpu.add(pq);
			
			tf4=new JTextField();
			tf4.setBounds(300,450,250,50);
			fpu.add(tf4);
			
			ppu=new JLabel("Price Per Unit");
			ppu.setBounds(40,550,200,50);
			fpu.add(ppu);
			
			tf5=new JTextField();
			tf5.setBounds(300,550,250,50);
			fpu.add(tf5);
			
			plogo=new JLabel();
			plogo.setBounds(600,300,230,230);
			plogo.setIcon(new ImageIcon(Location+"ckartlogo.jpg"));
			fpu.add(plogo);
			
			terms=new JLabel("Terms & conditions");
			terms.setBounds(40,650,250,80);
			fpu.add(terms);
			
			String cond[]={"you are chutiya to register at chutiya kart "};
			
			read=new JComboBox(cond);
			read.setBounds(300,650,250,50);
			fpu.add(read);
			
			agree=new JLabel("Agree");
			agree.setBounds(300,750,120,50);
			fpu.add(agree);
			
			check=new JCheckBox();
			check.setBounds(430,750,120,50);
			fpu.add(check);
			

			
			save=new JButton("UPDATE");
			save.setBounds(600,750,300,60);
			save.setVisible(false);
			fpu.add(save);
			
			cancel=new JButton("CANCEL");
			cancel.setBounds(900,750,300,60);
			fpu.add(cancel);
			
			tf1.addKeyListener (new KeyAdapter()
			{
				public void keyTyped (KeyEvent ke)
				{
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
					{
						fpr.getToolkit().beep ();
						ke.consume ();
	      			}
	    		}
	  		}
			);
			
			tf4.addKeyListener (new KeyAdapter()
			{
				public void keyTyped (KeyEvent ke)
				{
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
					{
						fpr.getToolkit().beep ();
						ke.consume ();
	      			}
	    		}
	  		}
			);
			
			tf5.addKeyListener (new KeyAdapter()
			{
				public void keyTyped (KeyEvent ke)
				{
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
					{
						fpr.getToolkit().beep ();
						ke.consume ();
	      			}
	    		}
	  		}
			);

			check.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			Object obj1=e.getSource();
					
			if(check.isSelected())
			{
				save.setVisible(true);
			}
			else 
			{
				save.setVisible(false);
			}
			}
			});
	
			save.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			Object obj1=e.getSource();
			
			if(obj1==save)
			{
				if (tf1.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpu, "Please! Provide Product Id.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf1.requestFocus();
				}
				
				else if (tf2.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpu, "Please! Provide Product name.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf2.requestFocus();
				}
				
				else if (tf3.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpu, "Please! Provide Product company.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf3.requestFocus();
				}
				
				else if (tf4.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpu, "Please! Provide Product quantity.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf4.requestFocus();
				}
				
				else if (tf5.getText().equals(""))
				{
					JOptionPane.showMessageDialog
					  (fpu, "Please! Provide Product price per unit.",
					                "Registration System - EmptyField",
					                JOptionPane.PLAIN_MESSAGE);

					tf5.requestFocus();
				}
				

			


			

				
				else
				{
					String productID=tf1.getText().trim();
					String productName=tf2.getText().trim();
					String company=tf3.getText().trim();
					String quantity=tf4.getText().trim();
					String priceperunit=tf5.getText().trim();
					
					UpdateDatabaseRecords.update(productID,productName,company,quantity,priceperunit);
					textClear();
				}
				


			}
		}
			});
			


			cancel.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			Object obj1=e.getSource();
			
			if(obj1==cancel)
			{
				fpu.setVisible(false);

			}
		}
			});
			


		}
		
		//product Information
		
		else if(obj==PI)
		{
			DisplayAllRecords.display();
			
		}
		
		//product Delete
		
		else if(obj==PD)
		{
			try
			{
			
			DisplayAllRecords.display();
			jspTable.setBounds(200,100,800,800);
			lpd.setVisible(true);
			lid.setVisible(true);
			tfd.setVisible(true);
			delete.setVisible(true);
			CO.setVisible(false);
			order.setVisible(false);
			fpi.setVisible(true);
			
			}
			catch(Exception e1)
			{
				System.out.print(e1);
			}
			
		}
		
		else if(obj==PO)
		{
			try
			{
			DisplayAllRecords.display();
			p1.setVisible(true);
			p2.setVisible(true);
			p3.setVisible(true);
			p4.setVisible(true);
			p5.setVisible(true);
			p6.setVisible(true);
			p7.setVisible(true);
			p8.setVisible(true);
			p9.setVisible(true);
			p10.setVisible(true);
			p11.setVisible(true);
			p12.setVisible(true);
			p13.setVisible(true);
			p14.setVisible(true);
			p15.setVisible(true);
			
			order.setVisible(true);
			back.setVisible(true);
			fpi.setVisible(true);
			}
			catch(Exception e1)
			{
				System.out.print(e1);
			}


			
		}
		
	}
	
	public static void main(String[] args) 
	{


		new KartFrame();
	}

}
