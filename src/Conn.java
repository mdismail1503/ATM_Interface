import java.sql.*; //Importing sql library..

//JDBC Java Data Base Connectivity..is the JavaSoft specification of a standard application programming interface(API) that allows Java Programs to access DBMS..
//Current version of jdbc is 4.3

public class Conn {

//To connect java to database..
/*
1.Register the Driver..
2.Create Connection..
3.Create Statement.
4.Execute Query
5.Close Connection..
 */
  Connection c;//This is connection class object
    Statement s;
    public Conn(){
        try{
            //add mysql connector in library..
           c=DriverManager.getConnection( "jdbc:mysql:///bankmanagementsystem","root","Ismail@2001");
           s=c.createStatement();//using this statment we can execute statements..

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
