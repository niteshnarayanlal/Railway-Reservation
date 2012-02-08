
import java.awt.*;
import java.util.regex.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

import java.sql.*;
public class edittraininfo extends JFrame implements ActionListener
{
    //variables used
	String train_name,from,to,classa,classb,classc;
	int train_number;
	Time arr,dep;
	Float cost;

	//controls used
	    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JLabel l1,l2,l3,l4,l5,l6,l7,l8;
        JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
        JPanel buttonpanel;     
	    JButton submit,back,reset;
	    
public edittraininfo()
{
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLayout(new GridLayout(12,3));
p1=new JPanel();
p2=new JPanel();
p3=new JPanel();
p4=new JPanel();
p5=new JPanel();
p6=new JPanel();
p7=new JPanel();
p8=new JPanel();
p9=new JPanel();
p10=new JPanel();
p11=new JPanel();



submit=new JButton("Submit");
back=new JButton("Logout");
reset=new JButton("Reset");
submit.setPreferredSize(new Dimension(90,40));
back.setPreferredSize(new Dimension(90,40));
reset.setPreferredSize(new Dimension(90,40));
buttonpanel=new JPanel();
buttonpanel.add(submit);
buttonpanel.add(back);
buttonpanel.add(reset);

buttonpanel.setLayout(new GridLayout(2,3));
t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);
t5=new JTextField(10);
t6=new JTextField(10);
t7=new JTextField(10);
t8=new JTextField(10);


l1=new JLabel("Train Name      ");
l2=new JLabel("Train Number    ");
l3=new JLabel("From            ");
l4=new JLabel("To              ");
l5=new JLabel("Arrival         ");
l6=new JLabel("Departure       ");
l7=new JLabel("Cost            ");
l8=new JLabel("Admin Id        ");


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
p7.add(l7);
p7.add(t7);
p8.add(l8);
p8.add(t8);


p1.setLayout(new GridLayout(3,3));
p2.setLayout(new GridLayout(3,3));
p3.setLayout(new GridLayout(3,3));
p4.setLayout(new GridLayout(3,3));
p5.setLayout(new GridLayout(3,3));
p6.setLayout(new GridLayout(3,3));
p7.setLayout(new GridLayout(3,3));
p8.setLayout(new GridLayout(3,3));

buttonpanel.setLayout(new FlowLayout(JButton.CENTER));


add(p1);
add(p2);
add(p3);
add(p4);
add(p5);
add(p6);
add(p7);
add(p8);
add(p9);
add(p10);
add(buttonpanel);

submit.addActionListener(this);
back.addActionListener(this);
reset.addActionListener(this);



this.setVisible(true);
this.setTitle("Edit Train  Information");
this.setSize(5000,5000);
this.setBackground(Color.BLACK);
}	

public void actionPerformed(ActionEvent e)
{
	String s=e.getActionCommand();
	if(s.equals("Submit"))
	{
		//execute the query by fetching the data and insert in the table
		
		
		
		if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals(""))
		{
		JOptionPane.showMessageDialog(this, "All Fields must be Entered","Error",JOptionPane.ERROR_MESSAGE);	
		}
		else
		{
		
		
		String a=t1.getText();
		String b=t2.getText();
		Pattern p=Pattern.compile("[0-9]{1,5}");
		Matcher m=p.matcher(b);
		boolean match=m.matches();
	    if(!match)
	    {
	    	JOptionPane.showMessageDialog(this, "Train number is not valid ","Error",JOptionPane.ERROR_MESSAGE);	
	    }
		String c=t3.getText();
		String d=t4.getText();
        String f=t5.getText();
        String g=t6.getText();
        Pattern p1=Pattern.compile("[0-9]{3,10}");
		Matcher m1=p1.matcher(b);
		boolean match1=m1.matches();
	    if(!match1)
	    {
	    	JOptionPane.showMessageDialog(this, "Cost is not valid ","Error",JOptionPane.ERROR_MESSAGE);	
	    }
        String h=t7.getText();
	    String i=t8.getText();
	    
	    
	    if(i.equals("nitesh"))
	    {
		String query="insert into train_info "
			+" values("+b+",'"+a+"','"+c+"','"+d+"','"+i+"','"+f+"','"+g+"',"+h+")";
	    System.out.println(query);
		
		db ob=new db();
		int t=ob.execute(query);
		 if(t==0)
		   {
			   JOptionPane.showMessageDialog(this, "Unable To Insert Please try Again Later","Error",JOptionPane.ERROR_MESSAGE);	   
		   }
		   else
			   JOptionPane.showMessageDialog(this, "OPERATION SUCESSFUL ","Error",JOptionPane.INFORMATION_MESSAGE);	   
			
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(this, "You are not the admin ","Error",JOptionPane.ERROR_MESSAGE);	
	    }
		
		
		
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
	   t7.setText("");
   }
   

   
   
}







public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new edittraininfo();
			}
		});
	
	
	
	
}

}//end of reserve