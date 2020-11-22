
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	    public class LibrarianSection extends JFrame  {
		    
			JLabel label,footer;
			JButton btnStudent, btnBook,btnlog;
					
			LibrarianSection(){
				
			label=new JLabel("Librarian Section");
			label.setBounds(200, 30, 450, 60);
			Font font=new Font("Tahoma",Font.BOLD,45);
			label.setFont(font);
			label.setForeground(Color.BLUE);
			
			btnStudent=new JButton();
			btnStudent.setBounds(100,200,190,180);
			
			btnBook=new JButton();
			btnBook.setBounds(450,200,190, 180);
		
			btnlog=new JButton("Log Out");
			btnlog.setBounds(280,500,150,30);

			footer=new JLabel("Copyright © 2019 Akansha_SVDC");
			footer.setBounds(10,620,500,50);
			
			btnStudent.addActionListener(new ActionListener(){
				
					
				public void actionPerformed(ActionEvent e) {
					
					new StudentSection();
					dispose();
					
				}
			}

					);
			
			btnBook.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e) {
					
					new BooksDetail();
					dispose();
				}
			}
					

					);
			
			btnlog.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e) {
					
					new Library();
					dispose();
				}
			}
					

					);
			
			
			setLayout(null);
			add(label);
			add(btnStudent);
			add(btnBook);
			add(footer);
			add(btnlog);
			setVisible(true);
			setSize(800,700);
			setTitle("Librarian Section");
				
			btnStudent.setIcon(new ImageIcon("C:\\Users\\hp\\3D Objects\\project\\New folder\\student.jpg"));
			add(btnStudent);
					
			btnBook.setIcon(new ImageIcon("C:\\Users\\hp\\3D Objects\\project\\New folder\\books.jpg"));
			add(btnBook);
					
			validate();
			
		}

			public void paint(Graphics g){
				
				super.paintComponents(g);
				g.setColor(Color.black);
				g.drawLine(0,660,800,660);
			}


			public static void main(String args[]){
				LibrarianSection l=new LibrarianSection();
				
			}
			
	}

