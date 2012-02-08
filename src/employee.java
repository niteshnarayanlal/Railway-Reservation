import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class employee extends JFrame implements ActionListener
{
String msg="";
String true_user_name;
String true_password;

JLabel user_name;
JLabel password;
JButton submit;
JButton reset,back;
JPanel user,pass,buttons;
JTextField t1;
JPasswordField t2;

public employee()
{
	//these things can be read from a file and then read from there but then need an signup
	setBackground(Color.white);
	true_user_name="admin";//this is the actual user name
	true_password="admin";//this is the actual password 

t1=new JTextField(20);
t2=new JPasswordField(20);
//t2.setEchoChar('*');


setLayout(new GridLayout(3,3));
user=new JPanel();
pass=new JPanel();
buttons=new JPanel();

user_name=new JLabel("User Id    ");
password=new JLabel("Password");

submit=new JButton("Submit");
reset=new JButton("Reset");
back=new JButton("Back");
//user.setLayout(new FlowLayout(FlowLayout.LEFT));
user.add(user_name);
user.add(t1);
add(user);

//pass.setLayout(new FlowLayout(FlowLayout.LEFT));
pass.add(password);
pass.add(t2);
add(pass);

//buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
buttons.add(submit);
buttons.add(reset);
buttons.add(back);
add(buttons);


submit.addActionListener(this);
reset.addActionListener(this);
back.addActionListener(this);
this.setVisible(true);
//this.setSize(600,600);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pack();
this.setTitle("Employee Login");
}//end of constructor()

public void actionPerformed(ActionEvent e)
{
//String s=e.getActionCommand();
        if(e.getSource()==submit)
        {
         String u=t1.getText();
         String p=t2.getText();
        
        		 if(u.equals(true_user_name) && p.equals(true_password))
            { 
            //move to the page from where user can change the train details
            updatetraininfo et=new updatetraininfo();
            et.setVisible(true);
            this.setVisible(false);
 
            }
            else
          
            {
            	
            	JOptionPane.showMessageDialog(this, "User Name or Password must match","Error",JOptionPane.ERROR_MESSAGE);	
            		
            }
        }  
        String s=e.getActionCommand();
        if(s.equals("Back"))
        {
        	project p=new project();
        	this.setVisible(false);
        	p.setVisible(true);
        }
else if(e.getSource()==reset)
        {
        t1.setText("");
        t2.setText("");
        }
        
        

}
public static void main (String args[])
{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new employee();
			}
		});
	
}


}//end of class 

