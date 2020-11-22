
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentDetail extends JFrame {
	
	JButton btn;
	DefaultTableModel model=new DefaultTableModel();
	Container cnt= this.getContentPane();
	JTable jtbl=new JTable(model);
	JLabel footer;
	
	public StudentDetail(){
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,520,700,50);
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Department");
		model.addColumn("Address");
		model.addColumn("City");
		model.addColumn("Phone No");
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarian","root","mysql");
			PreparedStatement pstm=con.prepareStatement("select * from student_record");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				
				model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)});
				
			}
		}catch(Exception e){
			
			System.out.print(e.getMessage());
			
		}

		JScrollPane pg=new JScrollPane(jtbl);
		cnt.add(pg);
		this.pack();
		
		btn=new JButton("Log Out");
		btn.setBounds(230,470,80,30);
		
		btn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new StudentSection();
				dispose();
			}
		}

				);
    	
    setLayout(null);
	add(btn);
	add(footer);
	setTitle("Student Record");
	setSize(800,600);
	setLocationRelativeTo(null);
	setVisible(true);


	}
	

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,560,800, 560);
	}


	public static void main(String args[]){
		
		StudentDetail vl=new StudentDetail();

	}
}