import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class updatetrain extends JFrame implements ActionListener
{
	String train_name,from,to;
	int train_number;
	Time arr,dep;
	Float cost;

	//controls used
	    JTextField t1,t2,t3,t4,t5,t6;
        JLabel l1,l2,l3,l4,l5,l6,l7;
        JPanel p1,p2,p3,p4,p5,p6,p7;
        JPanel buttonpanel;     
	    JButton submit,back,reset;
	    JComboBox c1;
	updatetrain()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		
		c1=new JComboBox();
		
		
		try
		{
			db ob=new db();
			String query="select train_number from train_info";
			ResultSet r=ob.select(query);
			while(r.next())
			{
				int ps=r.getInt("train_number");
				c1.addItem(ps);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		p1.setLayout(new FlowLayout(JButton.CENTER));
		p2.setLayout(new FlowLayout(JButton.CENTER));
		p3.setLayout(new FlowLayout(JButton.CENTER));
		p4.setLayout(new FlowLayout(JButton.CENTER));
		p5.setLayout(new FlowLayout(JButton.CENTER));
		p6.setLayout(new FlowLayout(JButton.CENTER));
		p7.setLayout(new FlowLayout(JButton.CENTER));
		
		
		





		submit=new JButton("Submit");
		back=new JButton("Logout");
		reset=new JButton("Reset");
		submit.setPreferredSize(new Dimension(100,40));
		back.setPreferredSize(new Dimension(100,40));
		reset.setPreferredSize(new Dimension(100,40));

		buttonpanel=new JPanel();
		buttonpanel.add(submit);
		buttonpanel.add(back);
		buttonpanel.add(reset);
        
		buttonpanel.setLayout(new FlowLayout(JButton.CENTER));
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		t6=new JTextField(10);
		

		l1=new JLabel("Train Name      ");
		l7=new JLabel("Select A Train Number To Update  ");
		l2=new JLabel("From            ");
		l3=new JLabel("To              ");
		l4=new JLabel("Arrival         ");
		l5=new JLabel("Departure       ");
		l6=new JLabel("Cost            ");
		
		 p7.add(l7);
			p7.add(c1);

		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		p3.add(l3);
		p3.add(t3);
		p4.add(l4);
		p4.add(t4);
		p5.add(l5);
		p5.add(t5);
		p6.add(l6);
		p6.add(t6);
	
		
	
		p1.setLayout(new GridLayout(3,3));
		p2.setLayout(new GridLayout(3,3));
		p3.setLayout(new GridLayout(3,3));
		p4.setLayout(new GridLayout(3,3));
		p5.setLayout(new GridLayout(3,3));
		p6.setLayout(new GridLayout(3,3));
		p7.setLayout(new GridLayout(3,3));
		

		buttonpanel.setLayout(new GridLayout(3,3));

		add(p7);
		
		

        add(p1);
        add(p2);
        add(p3);
		add(p4);
		add(p5);
		add(p6);
		
		add(buttonpanel);

		submit.addActionListener(this);
		back.addActionListener(this);
		reset.addActionListener(this);



		this.setVisible(true);
       this.setBackground(Color.white);
       this.setTitle("Update Train Information");
		this.setSize(5000,5000);
	}
	    
	public void actionPerformed(ActionEvent e)
	{

		
		String s=e.getActionCommand();
		if(s.equals("Submit"))
		{
			//execute the query by fetching the data and insert in the table
			
			
			
			if(t1.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t2.getText().equals(""))
			{
			JOptionPane.showMessageDialog(this, "All Fields must be Entered","Error",JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
			
			
			String a=t1.getText();
		    String b=t2.getText();
		
			String c=t3.getText();
			String d=t4.getText();
	        String f=t5.getText();
	        String g=t6.getText();
	       
	        Pattern p1=Pattern.compile("[0-9]{3,10}");
			Matcher m1=p1.matcher(g);
			boolean match1=m1.matches();
		    if(!match1)
		    {
		    	JOptionPane.showMessageDialog(this, "Cost is not valid ","Error",JOptionPane.ERROR_MESSAGE);	
		    }
	       int ch=Integer.parseInt(""+c1.getSelectedItem());
		    
		    //update query written over here
		    String query="update train_info set train_name='"+a+"" +
		    		"', source='"+
		   b+"', destination='"+c+"', admin_id='nitesh' , arrival='"+
		    d+"', departure='"+f +"' where train_number="+ch;
		    
		    	
		    System.out.println(query);
			
			db ob=new db();
			int t=ob.execute(query);		
		   if(t==0)
		   {
			   JOptionPane.showMessageDialog(this, "Unable To Insert Please try Again Later ","Error",JOptionPane.ERROR_MESSAGE);	   
		   }
		   else
			   JOptionPane.showMessageDialog(this, "OPERATION SUCESSFUL ","Error",JOptionPane.INFORMATION_MESSAGE);	   
			
			}//end of else	
			
			
			//also check if any feild is empty if so show proper error
		}
		if(s.equals("Logout"))
		{
			employee p=new employee();
			this.setVisible(false);
			p.setVisible(true);
		}
	   if(s.equals("Reset"))
	   {
		   t1.setText("");
		   t2.setText("");
		   t3.setText("");
		   t4.setText("");
		   t5.setText("");
		   t6.setText("");
		 
	   }
	   
	}
	

	public static void main (String args[])
	{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					new updatetrain();
				}
			});
		
	}	
}
