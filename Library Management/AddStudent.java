


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame {


	JLabel label,label1,label2,label3,label4,label5,label6,footer;
	JTextField text1, text2,text3, text4,text5,text6;
	JButton b1,b2;
	String s;
	
	AddStudent(){
		
		label=new JLabel("Add Student Detail");
		label.setBounds(280, 30, 450, 60);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		label1=new JLabel("ID");
		label1.setBounds(250, 160, 100, 20);
		text1=new JTextField(20);
		text1.setBounds(400, 160, 200, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
		
		label2= new JLabel("Name");
		label2.setBounds(250, 220, 100, 20);
		text2= new JTextField(20);
		text2.setBounds(400, 220, 200, 20);
		label2.setFont(font1);
		
		label3= new JLabel("Department");
		label3.setBounds(250, 280, 100, 20);
		text3= new JTextField(20);
		text3.setBounds(400, 280, 200, 20);
		label3.setFont(font1);
		
		label4= new JLabel("Address");
		label4.setBounds(250, 340, 100, 20);
		text4= new JTextField(20);
		text4.setBounds(400, 340, 200, 20);
		label4.setFont(font1);
		
		label5= new JLabel("City");
		label5.setBounds(250, 400, 100, 20);
		text5= new JTextField(20);
		text5.setBounds(400, 400, 200, 20);
		label5.setFont(font1);
		
		label6= new JLabel("Phone No");
		label6.setBounds(250, 460, 100, 20);
		text6= new JTextField(20);
		text6.setBounds(400, 460, 200, 20);
		label6.setFont(font1);
		
		b1=new JButton("Add Student");
		b1.setBounds(250, 550, 150, 30);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,500,50);
		
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
						
						JOptionPane.showMessageDialog(null, "Student added successfully!"," ",JOptionPane.PLAIN_MESSAGE);
					}
					catch(Exception e){
						System.out.println(e);
						
					}
				

				}
			
	public  void actionPerformed(ActionEvent e) {
		
		theQuery("insert into Student_record(Student_ID, Student_Name,Student_Dept,Address, City, Phone_No)"
				+ " values('"+text1.getText()+"','"+text2.getText()+"', '"+text3.getText()+"', '"+text4.getText()+"', '"+text5.getText()+"','"+text6.getText()+"')");
	}
	}	);
	
	
		b2.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new StudentSection();
				dispose();
			}
		}

				);
		
				
		setLayout(null);
		setVisible(true);
		setTitle("Add student Window");
		setSize(900,700);	
	
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,900, 660);
	}

	

	public static void main(String args[]) throws Exception{
		AddStudent alb=new AddStudent();

}


}
