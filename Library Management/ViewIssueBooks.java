
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewIssueBooks extends JFrame {
	
	DefaultTableModel model=new DefaultTableModel();
	Container cnt= this.getContentPane();
	JTable jtbl=new JTable(model);
	JLabel footer;
	
	public ViewIssueBooks(){
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC");
		footer.setBounds(10,620,500,50);
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		model.addColumn("Student ID");
		model.addColumn("Student Name");
		model.addColumn("Book CallNo");
		model.addColumn("Book Name");
		model.addColumn("Issue Date");
		model.addColumn("Return Date");
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
			PreparedStatement pstm=con.prepareStatement("select * from issue_book");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				
				model.addRow(new Object[] {rs.getInt("Student_ID"), rs.getString("Student_Name"), rs.getInt("Book_CallNo"), rs.getString("Book_Name"), rs.getDate("Issue_Date"),rs.getDate("Return_Date")});
				
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

	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,600, 660);
	}


	public static void main(String args[]){
		
		ViewIssueBooks vib=new ViewIssueBooks();
		vib.setTitle("Issue Book Record");
		vib.setSize(600,700);
		vib.setLocationRelativeTo(null);
		vib.setVisible(true);
		vib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}