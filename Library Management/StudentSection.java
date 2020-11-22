
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentSection  extends JFrame{
	
	JLabel label,footer;
	JButton btnadd,btnview,btnissue,btnvissue,btnlog,btnreturn;
	

	
    StudentSection(){
    	
    	label=new JLabel("Student Section");
    	label.setBounds(230, 40, 450, 30);
		Font font=new Font("Tahoma",Font.BOLD,35);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,500,50);
		
		btnadd=new JButton("Add Student Record");
		btnadd.setBounds(140,200,150,30);
		
		btnview=new JButton("View Student Detail");
		btnview.setBounds(420,200,150,30);
		
		btnvissue=new JButton("View Issued Books");
		btnvissue.setBounds(140,360,150,30);
		
		btnlog=new JButton("Log Out");
		btnlog.setBounds(420,360,150,30);
		
		btnadd.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new AddStudent();
				dispose();
			}
		}

				);
		
		btnview.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new StudentDetail();
				dispose();
			
			}
		}
				);
		

		
				
		btnvissue.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new ViewIssueBooks();
				dispose();
			}
		}

				);
		
		

	    	
	    	btnlog.addActionListener(new ActionListener(){
				
				
				public void actionPerformed(ActionEvent e) {
					
					new LibrarianSection();
					dispose();
				}
			}

					);
	    setTitle("Student Section");	
	    setLayout(null);
		add(label);
		add(btnadd);
		add(btnview);
		add(btnvissue);
		add(btnlog);
		add(footer);
		setVisible(true);
		setSize(800,700);
				
	}
    

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,800, 660);
	}


	public static void main(String args[]){
    	
    	StudentSection as=new StudentSection();
    	
    	
    }



}