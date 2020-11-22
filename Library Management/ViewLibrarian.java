
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewLibrarian extends JFrame {
	
	JButton btn;
	DefaultTableModel model=new DefaultTableModel();
	Container cnt= this.getContentPane();
	JTable jtbl=new JTable(model);
	JLabel footer;
	
	public ViewLibrarian(){
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Email ID");
		model.addColumn("Password");
		model.addColumn("Address");
		model.addColumn("City");
		model.addColumn("Phone No");
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
			PreparedStatement pstm=con.prepareStatement("select * from add_librarian");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				
				model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7)});
				
			}
		}catch(Exception e){
			
			System.out.print(e.getMessage());
			
		}

		JScrollPane pg=new JScrollPane(jtbl);
		cnt.add(pg);
		this.pack();
		
		btn=new JButton("Log Out");
		btn.setBounds(230,450,100,30);
		
		btn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new AdminSection();
				dispose();;
			}
		}

				);
    	
	footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
	footer.setBounds(10,520,600,50);
	
    setLayout(null);
    this.add(footer);
	add(btn);
	setSize(700,600);
	setTitle("View Librarian Detail");


	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,560,700, 560);
	}


	
	public static void main(String args[]){
		
		ViewLibrarian vl=new ViewLibrarian();
		vl.setLocationRelativeTo(null);
		vl.setVisible(true);
		vl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}