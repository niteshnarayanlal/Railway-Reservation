
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class updatetraininfo extends JFrame implements ActionListener
{
JButton up;
JButton add;
JPanel p;
updatetraininfo()
{
up=new JButton("Update a current train satus");
add=new JButton("Add a new Train");
p=new JPanel();
p.add(up);
p.add(add);

p.setLayout(new FlowLayout());
this.add(p);
this.setVisible(true);
up.addActionListener(this);
add.addActionListener(this);
pack();

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("Change Train Information In Database");
}

public void actionPerformed(ActionEvent e)
{
	String s=e.getActionCommand();
if(s.equals("Add a new Train"))	
{
	System.out.println("coming to this");
	   edittraininfo et=new edittraininfo();
       et.setVisible(true);
       this.setVisible(false);
	
       
       
}
else if(s.equals("Update a current train satus"))
{
	updatetrain ob=new updatetrain();
	ob.setVisible(true);
	this.setVisible(false);
}

}



public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new updatetraininfo();
			}
		});
	
}
	
}	

