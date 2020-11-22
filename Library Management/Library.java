
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	    public class Library extends JFrame  {
		    
			JLabel label,footer;
			JButton btnAdmin, btnLibrarian;
					
			Library(){
				
			label=new JLabel("Library Management System");
			label.setBounds(40, 10, 750, 90);
			Font font=new Font("Tahoma",Font.BOLD,50);
			label.setFont(font);
			label.setForeground(Color.black);
			
			btnAdmin=new JButton();
			btnAdmin.setBounds(100,230,190,180);
			
			btnLibrarian=new JButton();
			btnLibrarian.setBounds(550, 230,190, 180);
		
			footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
			footer.setBounds(10,620,800,50);
						
			btnAdmin.addActionListener(new ActionListener(){
				
					
				public void actionPerformed(ActionEvent e) {
					
					new AdminLogin();
					dispose();
				}
			}

					);
			
			btnLibrarian.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e) {
					
					new LibrarianLogin();
					dispose();
				}
			}
					

					);
			
		
			setLayout(null);
			add(label);
			add(btnAdmin);
			add(btnLibrarian);
			setVisible(true);
			add(footer);
			setSize(850,700);
				
			btnAdmin.setIcon(new ImageIcon("C:\\Users\\hp\\3D Objects\\project\\New folder\\admin.jpg"));
			add(btnAdmin);
					
			btnLibrarian.setIcon(new ImageIcon("C:\\Users\\hp\\3D Objects\\project\\New folder\\librarian.jpg"));
			add(btnLibrarian);
					
			validate();
			
		}
			
			public void paint(Graphics g){
				
				super.paintComponents(g);
				g.setColor(Color.BLACK);
				g.drawRect(9,35, 830, 90);
				g.drawLine(0,660,850, 660);
			}

			public static void main(String args[]){
				Library l=new Library();
				l.setTitle("Library Management System");
				l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
	}

