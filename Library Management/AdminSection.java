
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AdminSection  extends JFrame{
	
	JLabel label,footer;
	JButton btnadd,btnview,btndelete,btnlog;
	
    AdminSection(){
    	
    	label=new JLabel("Admin Section");
    	label.setBounds(250,45, 300, 30);
		Font font=new Font("Tahoma",Font.BOLD,40);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		btnadd=new JButton("Add Librarian");
		btnadd.setBounds(130,200,150,30);
		
		btnview=new JButton("View Librarian");
		btnview.setBounds(430,200,150,30);
		
		btndelete=new JButton("Delete Librarian");
		btndelete.setBounds(130,350,150,30);
		
		btnlog=new JButton("Log Out");
		btnlog.setBounds(430,350,150,30);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,600,50);
		
		btnadd.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new AddLibrarian();
				dispose();
			}
		}

				);
		
		btnview.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
			
				new ViewLibrarian();
				
				}
		}
			

				);
		
		btndelete.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new DeleteLibrarian();
				dispose();
			}
		}

				);
		
		btnlog.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new Library();
				dispose();
			}
		}

				);
	    
	    setLayout(null);
		add(footer);
	    add(label);
		add(btnadd);
		add(btnview);
		add(btndelete);
		add(btnlog);
		setVisible(true);
		setSize(800,700);
		setTitle("Admin Section");
		
	}
    

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,850, 660);
	}


    public static void main(String args[]){
    	
    	AdminSection as=new AdminSection();
    	
    }

}
