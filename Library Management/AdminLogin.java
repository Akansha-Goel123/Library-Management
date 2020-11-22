
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminLogin extends JFrame{
	
	JLabel label,label1,label2,footer;
	JTextField text1;
	JPasswordField text2;
	JButton b;
	
	
	
	public static void main(String args[]) throws Exception{
		AdminLogin al=new AdminLogin();
		al.setTitle("Admin Login");
		
	}

	
	
	AdminLogin(){
		
		label=new JLabel("Admin Login Form");
		label.setBounds(150, 25, 450, 60);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.blue);
		
		label1=new JLabel("Enter Name :");
		label1.setBounds(150, 200, 100, 20);
		text1=new JTextField(20);
		text1.setBounds(320, 200, 150, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
		
		label2= new JLabel("Enter Password :");
		label2.setBounds(150, 300, 150, 20);
		text2= new JPasswordField(20);
		text2.setBounds(320, 300, 150, 20);
		label2.setFont(font1);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,520,500,50);
				
		b=new JButton("Login");
		b.setBounds(230, 400, 80, 30);
		this.add(label);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(footer);
		this.add(b);
		
		b.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				String name=text1.getText();
				String password=text2.getText();
				if(name.equals("admin")&& password.equals("admin123")){
					
					new AdminSection();
					dispose();
				}
				else{
					
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or password Error","Login Error",JOptionPane.ERROR_MESSAGE);
				}

					
				}
			
		}
				);
		
		setTitle("Admin Login");
		setLayout(null);
		setVisible(true);
		setSize(600,600);
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,560,600, 560);
	}


}
