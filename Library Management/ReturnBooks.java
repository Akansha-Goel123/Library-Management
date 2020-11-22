
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ReturnBooks extends JFrame {
	

	JLabel label,label1,label2,label3,footer;
	JTextField text1,text2,text3;
	JButton b1,b2;
	
	ReturnBooks(){
		
		label=new JLabel("Return Books");
		label.setBounds(200, 30, 450, 60);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		label1=new JLabel("Book Call No");
		label1.setBounds(130, 160, 100, 20);
		text1=new JTextField(20);
		text1.setBounds(280, 160, 200, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,520,500,50);
		
		
		label2= new JLabel("Student ID");
		label2.setBounds(130, 220, 100, 20);
		text2= new JTextField(20);
		text2.setBounds(280, 220, 200, 20);
		label2.setFont(font1);
		
		label3= new JLabel("Date");
		label3.setBounds(130, 280, 100, 20);
		text3= new JTextField(20);
		text3.setBounds(280, 280, 200, 20);
		label3.setFont(font1);

		b1=new JButton("Return Book");
		b1.setBounds(130, 360, 150, 30);
		
		b2=new JButton("Back");
		b2.setBounds(330, 360, 150, 30);
		
		this.add(label);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(label3);
		this.add(text3);
		this.add(b1);
		this.add(b2);
		
					
		b1.addActionListener(new ActionListener(){
			
				
					public void actionPerformed(ActionEvent e) {

						try{
							Connection con=null;
							PreparedStatement pos=null;
							String sql="DELETE from issue_book WHERE Book_CallNo=? AND Student_ID=?";
							con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
							pos=con.prepareStatement(sql);
							pos.setString(1,text1.getText());
							pos.setString(2, text2.getText());
							pos.executeUpdate();
							JOptionPane.showMessageDialog(null, "Book Returned successfully");
							
						}
						catch(SQLException | HeadlessException ex){
							
							JOptionPane.showMessageDialog(null, ex);
						}
						
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
		setTitle("Return Book Window");
		setSize(650,600);
		add(footer);
}

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,560,650, 560);
	}


	public static void main(String args[]) throws Exception{
		ReturnBooks rbk=new ReturnBooks();

}
}
