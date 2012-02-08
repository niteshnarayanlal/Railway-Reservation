import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;




public class status extends JFrame implements ActionListener
{
    int passenger_id=0;//passenger id andseat number should be incremented only if sucessful sumission of details and then only user should get his pnr
	String passenger_name="";
	String mobile_number;
	String address="";
	int age=0,pnr=0,train_number=0;
    String res_status="",train_name="",train_arr="",train_dep="";
    
JButton enquire,back;  
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;        
JLabel p;
JTextField t;
JLabel n1,n2,blank;
JPanel pan1;
        
public status()
{
	
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLayout(new FlowLayout());
this.setBackground(Color.white);

t=new JTextField();
p=new JLabel("Enter PNR ");
enquire=new JButton("Enquire");
back=new JButton("Back");
back.setPreferredSize(new Dimension(90,40));
enquire.setPreferredSize(new Dimension(90,40));
back.setLayout(new FlowLayout(JButton.CENTER));
enquire.setLayout(new FlowLayout(JButton.CENTER));


pan1=new JPanel();
blank=new JLabel("                                                                                                   "+
		         "                                                                                                   ");
               
	l1=new JLabel();
	l1.setVisible(false);
	l2=new JLabel();
	l2.setVisible(false);
	l3=new JLabel();
	l3.setVisible(false);
	l4=new JLabel();
	l4.setVisible(false);
	l5=new JLabel();
	l5.setVisible(false);
	l6=new JLabel();
	l6.setVisible(false);
	l7=new JLabel();
	l7.setVisible(false);
	l8=new JLabel();
	l8.setVisible(false);
	l9=new JLabel();
	l9.setVisible(false);
	l10=new JLabel();
	l10.setVisible(false);
	n1=new JLabel("pnr field is empty");
	n1.setVisible(false);	
	n2=new JLabel("invalid pnr");
	n2.setVisible(false);

	pan1.add(p);
	pan1.add(t);
    p.setLayout(new FlowLayout(JLabel.CENTER));
    p.setPreferredSize(new Dimension(100,40));
    t.setPreferredSize(new Dimension(100,40));
    t.setLayout(new FlowLayout(JLabel.CENTER));
	
	
	add(pan1);

add(enquire);
add(back);
add(blank);
add(blank);
add(blank);
add(blank);
add(blank);
add(blank);
add(blank);
add(l1);

add(l2);

add(l3);


add(l4);

add(l5);

add(l6);

add(l7);

add(l8);

add(l9);

add(l10);


pan1.setVisible(true);

back.addActionListener(this);
enquire.addActionListener(this);

this.setVisible(true);
this.setSize(5000,5000);
this.setLayout(new FlowLayout());
this.setTitle("Reservation Status");

}
public void actionPerformed(ActionEvent e)
{

	String s=e.getActionCommand();

	if(t.getText().equals(""))
	{
	JOptionPane.showMessageDialog(this, "Please Enter the Pnr Number","Error",JOptionPane.ERROR_MESSAGE);	
	}
	else
	{	
	
	
	
	if(s.equals("Enquire"))
	{
		
		
		String st=t.getText();
		System.out.println("not right"+st);
		Pattern p1=Pattern.compile("[0-9]{1,5}");
		Matcher m1=p1.matcher(st);
		boolean match=m1.matches();
		System.out.println("not right"+st);
	    if(!match)
	    {
	    	JOptionPane.showMessageDialog(this, "PNR number must be a number ","Error",JOptionPane.ERROR_MESSAGE);	
	    }
	    
	    else
	    {//when the pnr is found to be a number
	    int m=Integer.parseInt(t.getText());
		boolean flag=true;
		db ob=new db();
        String query ="select pnr from reserved";
        ResultSet r=ob.select(query);
        try
        {
        	while(r.next())
        	{   int n=r.getInt("pnr");
        		if(n==m)
        		{
        			
        		flag=false;
        		break;
        		}
        	}
        }
        catch(Exception es)
        {
        	es.printStackTrace();
        }
        
        
        if(!flag)
        {
        //executing next query
        String query1="select * from reserved where pnr="+m;
        ResultSet rs=ob.select(query1);
        try
        {
         while(rs.next())
         {
        	passenger_name=rs.getString("passenger_name");
        	train_number=rs.getInt("train_number");
        	passenger_id=rs.getInt("passenger_id");
        	age=rs.getInt("age");
        	mobile_number=rs.getString("mobile_number");
        	address=rs.getString("address");
        	res_status="confirmed";
         }
       
        }
        catch(Exception et)
        {
        	et.printStackTrace();
        }
        String query2="select * from train_info where train_number="+train_number;
        ResultSet rss=ob.select(query2);
        try
        {
         while(rss.next())
         {
        	train_arr=rss.getString("arrival");
        	train_dep=rss.getString("departure");
        	train_name=rss.getString("train_name");
         }
       
        }
        catch(Exception et)
        {
        	et.printStackTrace();
        }
        String Passenger_Name="Passenger Name:"+passenger_name+"\n";
		String Train_Departure= "Train_Departure:"+train_dep+"\n";
		String Train_Arrival="Train Arrival:"+train_arr+"\n";
		String Train_Name="Train Name"+train_name+"\n";
		String Reservation_status="Reservation status:"+res_status+"\n";
		String PNR="PNR:"+passenger_id+"\n";
		String Age="Age:"+age+"\n";
		String Seat_Number="Seat Number:"+passenger_id+"\n";
		String Contact_Number="Contact Number:"+mobile_number+"\n";
		String Passenger_Address="Passenger Address:"+address+"\n";

		
		l1.setText(Passenger_Name);
		l1.setVisible(true);
		l2.setText(PNR);
		l2.setVisible(true);
		l3.setText(Train_Name);
		l3.setVisible(true);
		l4.setText(Seat_Number);
		l4.setVisible(true);
		l5.setText(Passenger_Address);
		l5.setVisible(true);
        l6.setText(Contact_Number);
		l6.setVisible(true);
		l7.setText(Reservation_status);
		l7.setVisible(true);
		l8.setText(Age);
		l8.setVisible(true);
		l9.setText(Train_Departure);
		l9.setVisible(true);
		l10.setText(Train_Arrival);
		l10.setVisible(true);
	

	
        }//end of if
        else
        {
        	
        	JOptionPane.showMessageDialog(this, "Please Enter a valid pnr number","Error",JOptionPane.ERROR_MESSAGE);	
        	
        }
	
	
	
	    }//end of else when pnr is  number
	
	}

	}//end of else
	
	if(s.equals("Back"))
	{
		project p=new project();
		this.setVisible(false);
		p.setVisible(true);
	}	

	
	
}
public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new status();
			}
		});
	
}
}