
import sun.misc.SignalHandler;

import javax.swing.*;//importing methods on swing..
import java.awt.*;//For image package..
import java.awt.event.*;
import java.sql.*;//For ddl

public class Login extends JFrame implements ActionListener { // to create template we are using swing frame
   JButton login,signup,clear;//to use them as global..
    JTextField cardTextField;
    JPasswordField pinTextField; //to hide what we are entering..
    Login(){               //ActionListener for listening actions that we performed like pressing buttons..
        setTitle("AUTOMATED TELLER MACHINE "); //GIVES TITLE OF FRAME
        setLayout(null);//This disables the default layout...

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));//to import a image this ImageIcon class is used..
        Image i2=i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);//to set the size of the impage that is imported..
        ImageIcon i3=new ImageIcon(i2);//converting image to Imageicon..
        JLabel label=new JLabel(i3);//actually we can't place pics on frame ..so we use JLabel and pass imageicon variable in it..
          label.setBounds(60,10,100,100);//for image location change inside frame..
         add(label);   // whenever we want to place anything on frame we are to use add..

        JLabel text=new JLabel("Welcome to ATM");//using Jlabel we can also write content on frame..
        text.setFont(new Font("Lucida",Font.BOLD,38));//chaning font ...
        text.setBounds(200,40,400,40); //to visible of text..
        add(text);//adding the text..

        JLabel cardno=new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);//adding the text..

        /*JTextField*/ cardTextField=new JTextField();
        cardTextField.setBounds(270,150,230,30);
        cardTextField.setFont(new Font("Areial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN: ");//using Jlabel we can also write content on frame..
        pin.setFont(new Font("Raleway",Font.BOLD,28));//chaning font ...
        pin.setBounds(160,220,400,30); //to visible of text..
        add(pin);//adding the text..

        /*JTextField*/ pinTextField=new JPasswordField();
        pinTextField.setBounds(270,220,230,30);
        pinTextField.setFont(new Font("Areial",Font.BOLD,14));
        add(pinTextField);

        /*JButton*/ login=new JButton ("SIGN IN"); //for creating buttons..
        login.setBounds(270,300,100,30);
        login.setBackground(Color.black);
        login.addActionListener(this);
        login.setForeground(Color.white);//for text color..
        add(login);

        /*JButton*/ clear=new JButton ("CLEAR"); //for creating buttons..
        clear.setBounds(400,300,100,30);
        clear.setBackground(Color.black);
        clear.addActionListener(this);
        clear.setForeground(Color.white);//for text color..
        add(clear);

        /*JButton*/ signup=new JButton ("SIGN UP"); //for creating buttons..
        signup.setBounds(270,350,230,30);
        signup.setBackground(Color.black);
        signup.addActionListener(this);
        signup.setForeground(Color.white);//for text color..
        add(signup);

        getContentPane().setBackground(Color.white);//This changes the color to white..
        setSize(800,480);//determines the frame length and breadth..
        setVisible(true);//Actually the frame will be created but will be hidden..calling this function makes the user see it..
        setLocation(350,200);//to appear the frame at the place we need

    }
    public void actionPerformed(ActionEvent ae){
             //Here we need to write what action is to be performed after clicking the particular button...
          if(ae.getSource()==clear){
              cardTextField.setText("");
              pinTextField.setText("");

          }else if(ae.getSource()==login){
              Conn conn=new Conn();
              String cardnumber=cardTextField.getText();
              String pinnumber=pinTextField.getText();
              String query="select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";
              try{
                  ResultSet rs=conn.s.executeQuery(query);//Here as data is returned then inorder to catch that data we use Result set...
                  if(rs.next()){
                      setVisible(false);
                      new Transactions(pinnumber).setVisible(true);
                  }else
                      JOptionPane.showMessageDialog(null,"Incorrect Card Number");

              }catch(Exception e){
                  System.out.println(e);
              }

          }else if(ae.getSource()==signup){
              setVisible(false);//when signup is clicked then frame closes
               new SignupOne().setVisible(true);//next frame opens..
          }
    }
    public static void main(String[] args) {
       new Login();

    }
}
