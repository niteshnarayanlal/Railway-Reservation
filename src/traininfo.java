import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.sql.*;

public class traininfo extends JFrame 
{
//String train_name,cities,classa,classb,classc;
//int train_number;
//Time arr,dep;
//Float cost;JButton back,cancle,enquire;
//JLabel l1,l2,l3,l4,l5;
//JPanel p1,p2,p3,p4,p5;
JPanel buttonpanel;
JTable table;

public traininfo()
{
	Object o[][]=new Object[15][7];
	String col[]={"train_number","train_name","source","destination","arrival","departure","cost"};
	//this.setLayout(new GridLayout(8,3));
//c1=new JComboBox();
//l1=new JLabel("Select The Train Name  ");
//c2=new JComboBox();
//l2=new JLabel("Select The Train Number");
//c3=new JComboBox();
//l3=new JLabel("Select The Arrival Time");
//c4=new JComboBox();
//l4=new JLabel("Select The Departure   ");
//
//
//p1=new JPanel();
//p2=new JPanel();
//p3=new JPanel();
//p4=new JPanel();
//p5=new JPanel();
//
//p1.add(l1);
//p1.add(c1);
//p2.add(l2);
//p2.add(c2);
//p3.add(l3);
//p3.add(c3);
//p4.add(l4);
//p4.add(c4);
//
//
//
//back=new JButton("Back");
//cancle=new JButton("Cancel");
//enquire=new JButton("Enquire");
buttonpanel=new JPanel();
//add(p1);
//add(p2);
//add(p3);
//add(p4);
//add(p5);
//table=new JTable();
//add(cancle);
//add(back);
//add(enquire);

//
//back.addActionListener(this);
//cancle.addActionListener(this);
//enquire.addActionListener(this);
//buttonpanel.add(back);
//buttonpanel.add(cancle);
//buttonpanel.add(enquire);
String str="select * from train_info";
db ob=new db();
ResultSet res=ob.select(str);


int i=0;
try
{
  while(res.next())
  {
	  o[i]=new Object[7];
	  o[i][0]=res.getInt("train_number");
	  o[i][1]=res.getString("train_name");
	  o[i][2]=res.getString("source");
	  o[i][3]=res.getString("destination");
	  o[i][4]=res.getString("arrival");
	  o[i][5]=res.getString("departure");
	  o[i][6]=res.getString("price");
	  i++;
	  
  }

}
catch(Exception ex)
{
	
}
table=new JTable(o,col);

buttonpanel.add(table);
add(buttonpanel);

this.setVisible(true);
//this.setSize(5000,5000);
this.pack();
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pack();
this.setTitle("Train Information");
}



public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new traininfo();
			}
		});
	
}

}