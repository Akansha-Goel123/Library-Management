
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BooksDetail  extends JFrame{
	
	JLabel label,footer;
	JButton btnadd,btnview,btnissue,btnvissue,btnlog,btnreturn;
	
    BooksDetail(){
    	
    	label=new JLabel("Books Section");
    	label.setBounds(280, 40, 450, 30);
		Font font=new Font("Tahoma",Font.BOLD,30);
		label.setFont(font);
		label.setForeground(Color.BLUE);
		
		footer=new JLabel("Copyright © 2019 Akansha_SVDC ");
		footer.setBounds(10,620,500,50);
		
		btnadd=new JButton("Add Books");
		btnadd.setBounds(150,200,150,30);
		
		btnview=new JButton("View Books");
		btnview.setBounds(450,200,150,30);
		
		btnissue=new JButton("Issue Book");
		btnissue.setBounds(150,340,150,30);
		
		btnvissue=new JButton("View Issued Books");
		btnvissue.setBounds(450,340,150,30);
		
		btnreturn=new JButton("Return Book");
		btnreturn.setBounds(150,480,150,30);
		
		btnlog=new JButton("Log Out");
		btnlog.setBounds(450,480,150,30);
		
		btnadd.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new AddBooks();
				dispose();
			}
		}

				);
		
		btnissue.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new IssueBooks();
				dispose();
			}
		}

				);
		
		btnview.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new ViewBooks();
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
		
		
	    	btnreturn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
				
				new ReturnBooks();
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
	    	
	    setLayout(null);
		add(label);
		add(btnadd);
		add(btnview);
		add(btnissue);
		add(btnvissue);
		add(btnreturn);
		add(btnlog);
		add(footer);
		setVisible(true);
		setSize(850,700);
		setTitle("Books Detail Window ");
				
	}
    

	public void paint(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.black);
		g.drawLine(0,660,850, 660);
	}


    public static void main(String args[]){
    	
    	BooksDetail as=new BooksDetail();
    	as.setTitle("Books Section");
    }

}
