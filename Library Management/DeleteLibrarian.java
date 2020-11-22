
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class DeleteLibrarian extends JFrame {
	
	JLabel label,label1,footer;
	JTextField text;
	JButton b1,b2;
	
	DeleteLibrarian(){
		
		label=new JLabel("Delete Librarian Window");
		label.setBounds(80, 10, 750, 90);
		Font font=new Font("Tahoma",Font.BOLD,30);
		label.setFont(font);
		label.setForeground(Color.blue);
	
		label1=new JLabel("Enter ID");
		label1.setBounds(100, 150, 100, 20);
		text=new JTextField(20);
		text.setBounds(220, 150, 200, 20);
		Font font1=new Font("Tahoma", Font.CENTER_BASELINE,15);
		label1.setFont(font1);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,420,600,50);
		
		b1=new JButton("Delete");
		b1.setBounds(100,250,130,30);
		
		b2=new JButton("Back");
		b2.setBounds(280,250,130,30);
		
		this.add(label);
		this.add(text);
		this.add(footer);
		this.add(b1);
		this.add(b2);
		this.add(label1);
					
		b1.addActionListener(new ActionListener(){
			
						
			public void actionPerformed(ActionEvent e) {
			
				try{
					Connection con=null;
					PreparedStatement pos=null;
					String sql="DELETE from add_librarian WHERE ID=?";
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
					pos=con.prepareStatement(sql);
					pos.setString(1,text.getText());
					pos.executeUpdate();
					JOptionPane.showMessageDialog(null, "Librarian record deleted successfully");
				}
				catch(SQLException | HeadlessException ex){
					
					JOptionPane.showMessageDialog(null, ex);
				}
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
		setSize(600,500);
		setTitle("Delete Librarian Window");
		
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,460,600, 460);
	}


	public static void main(String args[]) throws Exception{
		DeleteLibrarian dlb=new DeleteLibrarian();
	
}

}
