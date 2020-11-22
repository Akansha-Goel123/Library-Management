
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddBooks extends JFrame {

	JLabel label,label1,label2,label3,label4,label5,footer;
	JTextField text1,text2, text3, text4,text5;
	JButton b1,b2;
	
	AddBooks(){
		
		label=new JLabel("Add Books");
		label.setBounds(300, 30, 450, 80);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		label1=new JLabel("Call No");
		label1.setBounds(200, 160, 100, 20);
		text1=new JTextField(20);
		text1.setBounds(380, 160, 200, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
		
		label2= new JLabel("Name");
		label2.setBounds(200, 220, 100, 20);
		text2= new JTextField(20);
		text2.setBounds(380, 220, 200, 20);
		label2.setFont(font1);
		
		label3= new JLabel("Author");
		label3.setBounds(200, 280, 100, 20);
		label3.setFont(font1);
		text3= new JTextField(20);
		text3.setBounds(380, 280, 200, 20);
		
		label4= new JLabel("Publisher");
		label4.setBounds(200, 340, 100, 20);
		label4.setFont(font1);
		text4= new JTextField(20);
		text4.setBounds(380, 340, 200, 20);
		
		label5= new JLabel("Quantity");
		label5.setBounds(200, 400, 100, 20);
		text5= new JTextField(20);
		text5.setBounds(380, 400, 200, 20);
		label5.setFont(font1);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,500,50);
		
		b1=new JButton("Add Book");
		b1.setBounds(220, 500, 150, 30);
		
		b2=new JButton("Back");
		b2.setBounds(430, 500, 150, 30);
		
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
		this.add(footer);
		this.add(text5);
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
					
					JOptionPane.showMessageDialog(null, "Book Record updated successfully!"," ",JOptionPane.PLAIN_MESSAGE);
				}
				catch(Exception e){
					System.out.println(e);
					
				}
			}
			
			public void actionPerformed(ActionEvent e) {
				
				
				theQuery("insert into book_record(Call_No,Name, Author, Publisher,Quantity)"
						+ " values('"+text1.getText()+"','"+text2.getText()+"', '"+text3.getText()+"', '"+text4.getText()+"', '"+text5.getText()+"')");

					
				}
			
		}
				);
		
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
		setTitle("Add Book Window");

	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,900, 660);
	}


	public static void main(String args[]) throws Exception{
		AddBooks abk=new AddBooks();
}
}
