import java.io.*;
import java.sql.*;

public class db 
{
	 ResultSet result;
     Connection link;
     Statement statement;
	 int t=0;
	db()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			link=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres","");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("unable to load the class");
		    System.exit(1);
		}
        catch(SQLException e)
        {
        	System.out.println("cannot connect to the database");
        	System.exit(1);
        }
	
	}

	public int execute(String query)
	{
		try
		{
			statement=link.createStatement();
			t=statement.executeUpdate(query);
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Exception in processing");
		}
		return t;
		
	}
	
	public  ResultSet select(String query)
	{
		try
		{
			statement=link.createStatement();
			result=statement.executeQuery(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Exception in processing");
		}
		return result;
	}
	
	
	
	
	
	

}
