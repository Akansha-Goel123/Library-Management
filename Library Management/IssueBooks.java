
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class IssueBooks extends JFrame {


	JLabel label,label1,label2,label3,label4,label5,label6,footer;
	JTextField text1, text2,text3, text4,text5,text6;
	JButton b1,b2;
	String s;
	
	IssueBooks(){
		
		label=new JLabel("Book Issued Window");
		label.setBounds(280, 30, 450, 60);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		label1=new JLabel("Student ID");
		label1.setBounds(230, 160, 100, 20);
		text1=new JTextField(20);
		text1.setBounds(450, 160, 200, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
		
		label2= new JLabel("Student Name");
		label2.setBounds(230, 220, 130, 20);
		text2= new JTextField(20);
		text2.setBounds(450, 220, 200, 20);
		label2.setFont(font1);
		
		label3= new JLabel("Book Call No");
		label3.setBounds(230, 280, 100, 20);
		text3= new JTextField(20);
		text3.setBounds(450, 280, 200, 20);
		label3.setFont(font1);
		
		label4= new JLabel("Book Name");
		label4.setBounds(230, 340, 100, 20);
		text4= new JTextField(20);
		text4.setBounds(450, 340, 200, 20);
		label4.setFont(font1);
		
		label5= new JLabel("Issue Date");
		label5.setBounds(230, 400, 100, 20);
		text5= new JTextField(20);
		text5.setBounds(450, 400, 200, 20);
		label5.setFont(font1);
		
		label6= new JLabel("Return Date");
		label6.setBounds(230, 460, 100, 20);
		text6= new JTextField(20);
		text6.setBounds(450, 460, 200, 20);
		label6.setFont(font1);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,600,50);
		
		b1=new JButton("Issue Book");
		b1.setBounds(250, 550, 150, 30);
		
		b2=new JButton("Back");
		b2.setBounds(430, 550, 150, 30);
		
		this.add(label);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(label3);
		this.add(text3);
		this.add(label4);
		this.add(text4);
		this.add(label5);
		this.add(text5);
		this.add(label6);
		this.add(footer);
		this.add(text6);
		this.add(b1);
		this.add(b2);
		
		
	b1.addActionListener(new ActionListener(){
			
			
				
				public void theQuery(String query) {
					
					
					Connection con=null;
					
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
						Statement stmt= con.createStatement();
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null, "Book issued successfully!"," ",JOptionPane.PLAIN_MESSAGE);
					}
					catch(Exception e){
						System.out.println(e);
						
					}
				

				}
			
	public  void actionPerformed(ActionEvent e) {
		
		theQuery("insert into issue_book(Student_ID, Student_Name, Book_CallNo, Book_Name, Issue_Date, Return_Date)"
				+ " values('"+text1.getText()+"','"+text2.getText()+"', '"+text3.getText()+"', '"+text4.getText()+"', '"+text5.getText()+"','"+text6.getText()+"')");
	}
	}	);
	
	
		b2.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new BooksDetail();
				dispose();
			}
		}

				);
		
				
		setLayout(null);
		setVisible(true);
		setSize(900,700);
		setTitle("Issue Book Window");
	
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,900, 660);
	}

	

	public static void main(String args[]) throws Exception{
		IssueBooks alb=new IssueBooks();

	}

	}
