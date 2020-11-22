
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewBooks extends JFrame {
	
	DefaultTableModel model=new DefaultTableModel();
	Container cnt= this.getContentPane();
	JLabel footer;
	JTable jtbl=new JTable(model);
	
	public ViewBooks(){
		

		footer=new JLabel("Copyright © 2019 Akansha_SVDC");
		footer.setBounds(10,620,500,50);
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		model.addColumn("Call No");
		model.addColumn("Name");
		model.addColumn("Author");
		model.addColumn("Publisher");
		model.addColumn("Quantity");
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
			PreparedStatement pstm=con.prepareStatement("select * from book_record");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				
				model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)});
				
			}
		}catch(Exception e){
			
			System.out.print(e.getMessage());
			
		}

		JScrollPane pg=new JScrollPane(jtbl);
		cnt.add(pg);
		this.pack();
		
		JButton btn = new JButton("Log Out");
		btn.setBounds(230,500,80,30);
		
		btn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new LibrarianSection();
				dispose();
			}
		}

				);
    	
    setLayout(null);
	add(btn);
	add(footer);
	setTitle("Book Record");
	setSize(600,700);
	setLocationRelativeTo(null);
	setVisible(true);
	
	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,600, 660);
	}


	public static void main(String args[]){
		
		ViewBooks vb=new ViewBooks();

	}
}