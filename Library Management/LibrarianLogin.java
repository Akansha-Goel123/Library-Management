
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class LibrarianLogin extends JFrame{
	JLabel label,label1,label2,footer;
	JTextField lname;
	JPasswordField pwd;
	JButton b;
	
	LibrarianLogin(){
		
		label=new JLabel("Librarian Login Form");
		label.setBounds(150, 30, 450, 80);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		label1=new JLabel("Enter Name :");
		label1.setBounds(150, 200, 100, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
				
		lname=new JTextField(20);
		lname.setBounds(330, 200, 180, 20);
		
		label2= new JLabel("Enter Password :");
		label2.setBounds(130, 300, 150, 20);
		label2.setFont(font1);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,520,600,50);
				
		pwd= new JPasswordField(20);
		pwd.setBounds(330, 300, 180, 20);
		
		b=new JButton("Login");
		b.setBounds(250, 400, 80, 30);
		
		this.add(label);
		this.add(label1);
		this.add(lname);
		this.add(label2);
		this.add(footer);
		this.add(pwd);
		this.add(b);
		
		b.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				try{
					Connection con=null;
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from add_librarian");
					while(rs.next()){
						
						String Name=rs.getString("Name");
						String Password=rs.getString("Password");
						if(lname.getText().equals(Name) && pwd.getText().equals(Password))
						
						{
							new LibrarianSection();
							dispose();
						}
						else
						{	
							JOptionPane.showMessageDialog(null, "Invalid username and password");
						
						}
					}
					
					
				}
				catch(SQLException | HeadlessException ex){
					
				JOptionPane.showMessageDialog(null, ex);
				}
				

			}
		}
				);
		
		
		setLayout(null);
	    setTitle("Librarian Login Window");
		setVisible(true);
		setSize(700,600);
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,560,700, 560);
	}

	
	public static void main(String args[]){
		LibrarianLogin ll=new LibrarianLogin();
	
	}

}

