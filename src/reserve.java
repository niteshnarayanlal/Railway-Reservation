
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
public class reserve extends JFrame implements ActionListener
{
    //variables used

	int pnr=0;//passenger id andseat number should be incremented only if sucessful sumission of details and then only user should get his pnr
	String passenger_name="";
	int mobile_number;
	String address="";
	int age;

	//controls used
	    JTextField t1,t2,t3,t4;
        JLabel l1,l2,l3,l4,l8,l9;
        JPanel p1,p2,p3,p4;
        JPanel button_panel,train_detail;
        JComboBox c2;//c1 is for train name list and c2 is for class in train list
	    JButton submit,back,reset;
	    JLabel pn;
	    
public reserve()
{
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLayout(new GridLayout(8,4));
p1=new JPanel();
p2=new JPanel();
p3=new JPanel();
p4=new JPanel();


button_panel=new JPanel();
train_detail=new JPanel();


c2=new JComboBox();

try
{
	db ob=new db();
	String query="select train_number from train_info";
	ResultSet r=ob.select(query);
	while(r.next())
	{
		int ps=r.getInt("train_number");
		c2.addItem(ps);
		
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}

pn=new JLabel("");
pn.setVisible(false);

submit=new JButton("Submit");
back=new JButton("Back");
reset=new JButton("Reset");
submit.setPreferredSize(new Dimension(100,40));
back.setPreferredSize(new Dimension(80,40));
reset.setPreferredSize(new Dimension(80,40));
submit.setVisible(true);

button_panel.add(submit);
button_panel.add(back);
button_panel.add(reset);




t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);


l1=new JLabel("Passenger Name  ");
l2=new JLabel("Address          ");
l3=new JLabel("Mobile Number   ");
l4=new JLabel("Age             ");
l8=new JLabel("Train Name      ");
l9=new JLabel("Train Number    ");


p1.add(l1);
p1.add(t1);
p2.add(l2);
p2.add(t2);
p3.add(l3);
p3.add(t3);
p4.add(l4);
p4.add(t4);


train_detail.add(l9);
train_detail.add(c2);
train_detail.add(submit);

p1.setLayout(new GridLayout(3,3));
p2.setLayout(new GridLayout(3,3));
p3.setLayout(new GridLayout(3,3));
p4.setLayout(new GridLayout(3,3));
train_detail.setLayout(new GridLayout(3,5));
button_panel.setLayout(new FlowLayout());;
button_panel.add(pn);
//button_panel.setPreferredSize(new Dimension(100,100));


add(p1);
add(p2);
add(p3);
add(p4);


add(train_detail);
add(button_panel);


submit.addActionListener(this);
back.addActionListener(this);
reset.addActionListener(this);


submit.setPreferredSize(getSize());
this.setVisible(true);
this.setSize(5000,5000);
this.setTitle("Seat Reservation");
//pack();
}	

public void actionPerformed(ActionEvent e)
{
	String s=e.getActionCommand();
	if(s.equals("Submit"))
	{
		//execute the query by fetching the data and insert in the table
		if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals(""))
		{
		JOptionPane.showMessageDialog(this, "All Fields must be Entered","Error",JOptionPane.ERROR_MESSAGE);	
		}
		else
		{
		String a=t1.getText();
		String b=t2.getText();
		String c=t3.getText();
		Pattern p=Pattern.compile("[0-9]{1,10}");
		Matcher m=p.matcher(c);
		boolean match=m.matches();
	    if(!match)
	    {
	    	JOptionPane.showMessageDialog(this, "Phone number is not valid ","Error",JOptionPane.ERROR_MESSAGE);	
	    }
	    else
	    { 	
		
		String d=t4.getText();
	
		
		Pattern p1=Pattern.compile("[0-9]{1,10}");
		Matcher m1=p1.matcher(d);
		boolean match1=m1.matches();
	    if(!match1)
	    {
	    	JOptionPane.showMessageDialog(this, "Age is not valid ","Error",JOptionPane.ERROR_MESSAGE);	
	    }
	    else
	    {
		
		
		String g=(String)c2.getSelectedItem();
		int no=Integer.parseInt(g);
	
		
		String query2="select train_number from reserved";
		db ob2=new db();
		int count1=0,count2=0,count3=0,count4=0;
		
		ResultSet rst=ob2.select(query2);
		try
		{
			while(rst.next())
			{
				if(rst.getInt("train_number")=='1')
				{
					count1++;
				}
				if(rst.getInt("train_number")=='2') 
						
				{
					count2++;
				}
				if(rst.getInt("train_number")=='3')
				{
					count3++;
				}
				if(rst.getInt("train_number")=='4')
				{
					count4++;
				}
			}
		}
		catch(Exception el)
		{
			el.getStackTrace();
		}
		
		if(no==1&&count1==50)
		{
			JOptionPane.showMessageDialog(this, "Reservation is not possible as seats are full","Error",JOptionPane.ERROR_MESSAGE);	
				
		}
		else if(no==2&&count2==50)
		{
			JOptionPane.showMessageDialog(this, "Reservation is not possible as seats are full","Error",JOptionPane.ERROR_MESSAGE);		
				
		}
		else if(no==3&&count3==50)
		{
			JOptionPane.showMessageDialog(this, "Reservation is not possible as seats are full","Error",JOptionPane.ERROR_MESSAGE);	
		}
		else if(no==4&&count4>=50)
		{
			System.out.println("coming here");
			JOptionPane.showMessageDialog(this, "Reservation is not possible as seats are full ","Error",JOptionPane.ERROR_MESSAGE);	
				
		}
		
		
		else
		{
		 Random randomGenerator = new Random();
		    for (int idx = 1; idx <= 10; ++idx)
		    {
		      pnr = randomGenerator.nextInt(10000);
		      
		    }
		 
		    
   
		
		
		
		
		
		String query="insert into reserved (train_number,passenger_name,mobile_number,address,age,pnr)" +
				" values("+g+",'"+
		a+"','"+c+"','"+b+"',"+d+","+pnr+")";
		
		System.out.println(query);
		db ob=new db();
		int t=ob.execute(query);		
		 if(t==0)
		   {
			   JOptionPane.showMessageDialog(this, "Unable To Insert Please try Again Later","Error",JOptionPane.ERROR_MESSAGE);	   
		   }
		   else
			   JOptionPane.showMessageDialog(this, "OPERATION SUCESSFUL ","Error",JOptionPane.INFORMATION_MESSAGE);	   
			
		String query1="insert into personal_info (passenger_name,mobile_number,address,age)" +
		" values('"+
a+"','"+c+"','"+b+"',"+d+")";
		System.out.println("now it will go to other");
		int k=ob.execute(query1);	
		
		pn.setText("Your Pnr Is:"+pnr);
		pn.setVisible(true);
		
		}//end of else checked for vaccancy
		
	    }//end of t4 regex else
		
	    }//end of t3 regex else
	    
	    
		
		}//end of class
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	if(s.equals("Back"))
	{
		project p=new project();
		this.setVisible(false);
		p.setVisible(true);
	}
   if(s.equals("Reset"))
   {
	   t1.setText("");
	   t2.setText("");
	   t3.setText("");
	   t4.setText("");

   }
   

}







public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new reserve();
			}
		});
	
	
	
	
}

}//end of reserve