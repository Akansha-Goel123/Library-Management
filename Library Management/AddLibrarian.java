
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddLibrarian extends JFrame {


	JLabel label,label1,label2,label3,label4,label5,label6,footer,lid;
	JTextField text1, text2,text3, text4,text5,text6,text;
	JButton b1,b2;
	String s;
	
	AddLibrarian(){
		
		
		label=new JLabel("Add Librarian");
		label.setBounds(300, 10, 450, 80);
		Font font=new Font("Tahoma",Font.BOLD,40);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		lid=new JLabel("ID");
		lid.setBounds(250,100,100,20);
		text=new JTextField(20);
		text.setBounds(400,100,200,20);
		
		label1=new JLabel("Name");
		label1.setBounds(250, 160, 100, 20);
		text1=new JTextField(20);
		text1.setBounds(400, 160, 200, 20);
		
		label2= new JLabel("Email ID");
		label2.setBounds(250, 220, 100, 20);
		text2= new JTextField(20);
		text2.setBounds(400, 220, 200, 20);
		
		label3= new JLabel("Password");
		label3.setBounds(250, 280, 100, 20);
		text3= new JTextField(20);
		text3.setBounds(400, 280, 200, 20);
		
		label4= new JLabel("Address");
		label4.setBounds(250, 340, 100, 20);
		text4= new JTextField(20);
		text4.setBounds(400, 340, 200, 20);
		
		label5= new JLabel("City");
		label5.setBounds(250, 400, 100, 20);
		text5= new JTextField(20);
		text5.setBounds(400, 400, 200, 20);
		
		label6= new JLabel("Phone No");
		label6.setBounds(250, 460, 100, 20);
		text6= new JTextField(20);
		text6.setBounds(400, 460, 200, 20);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,600,50);
		
		b1=new JButton("Add Librarian");
		b1.setBounds(250, 550, 150, 30);
		
		b2=new JButton("Back");
		b2.setBounds(450, 550, 130, 30);
		
		this.add(lid);
		this.add(text);
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
		this.add(text6);
		this.add(footer);
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
						JOptionPane.showMessageDialog(null, "Librarian Added successfully!"," ",JOptionPane.PLAIN_MESSAGE);

					}
					catch(Exception e){
						System.out.println(e);
						
					}
				

				}
			
	public  void actionPerformed(ActionEvent e) {
		
		theQuery("insert into add_librarian(ID,Name, Email_ID,Password,Address, City, Phone_No)"
				+ " values('"+text.getText()+"','"+text1.getText()+"','"+text2.getText()+"', '"+text3.getText()+"', '"+text4.getText()+"', '"+text5.getText()+"','"+text6.getText()+"')");
	
		
				}
			}
		);
	
	
		b2.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new AdminSection();
				dispose();
			}
		}

				);
		
				
		setLayout(null);
		setVisible(true);
		setSize(900,700);	
		setTitle("Add Librarian Window");
		add(footer);
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,900, 660);
	}


	public static void main(String args[]) throws Exception{
		AddLibrarian alb=new AddLibrarian();
}


}
