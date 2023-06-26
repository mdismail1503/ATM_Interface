import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;//For calender..
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{

    //Declaring all the variables as global..
    int x;
    JTextField nameTextField,fnameTextField,enameTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;

    SignupOne(){
        setLayout(null);
        Random ran=new Random();
         x=Math.abs(ran.nextInt()) % 1000;

        JLabel formno=new JLabel("APPLICATION FORM NO. " + x);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(140,20,600,40);//This works only when setLayout is null..
        add(formno);

        JLabel personDetails=new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(220,65,400,30);//This works only when setLayout is null..
        add(personDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,130,100,30);//This works only when setLayout is null..
        add(name);

        /*JTextField*/ nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        nameTextField.setBounds(250,130,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,180,400,30);//This works only when setLayout is null..
        add(fname);

        /*JTextField*/ fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        fnameTextField.setBounds(250,180,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,230,400,30);//This works only when setLayout is null..
        add(dob);

        /*JDateChooser*/ dateChooser=new JDateChooser();
        dateChooser.setBounds(250,230,400,30);
        dateChooser.setForeground(Color.black);
        dateChooser.setFont(new Font("Raleway",Font.BOLD,15));
        add(dateChooser);//add the jcalender in library..

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,280,400,30);//This works only when setLayout is null..
        add(gender);

        /*JRadioButton*/ male=new JRadioButton("Male");
        male.setBounds(300,280,60,30);
        male.setBackground(Color.white);
        add(male);
        /*JRadioButton*/ female=new JRadioButton("Female");
        female.setBounds(450,280,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();//If one is selected the other is deselected..
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("E-mail:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,330,400,30);//This works only when setLayout is null..
        add(email);

        /*JTextField*/ enameTextField=new JTextField();
        enameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        enameTextField.setBounds(250,330,400,30);
        add(enameTextField);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,380,400,30);//This works only when setLayout is null..
        add(marital);

        /*JRadioButton*/ married=new JRadioButton("Married");
        married.setBounds(300,380,120,30);
        married.setBackground(Color.white);
        add(married);
        /*JRadioButton*/ unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,380,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup maritalgroup=new ButtonGroup();//If one is selected the other is deselected..
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,430,400,30);//This works only when setLayout is null..
        add(address);

        /*JTextField*/ addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,13));
        addressTextField.setBounds(250,430,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,480,400,30);//This works only when setLayout is null..
        add(city);

        /*JTextField*/ cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,13));
        cityTextField.setBounds(250,480,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,530,400,30);//This works only when setLayout is null..
        add(state);

        /*JTextField*/ stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,13));
        stateTextField.setBounds(250,530,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,580,400,30);//This works only when setLayout is null..
        add(pincode);

        /*JTextField*/ pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,13));
        pinTextField.setBounds(250,580,400,30);
        add(pinTextField);

        /*JButton*/ next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550,665,100,30);
        next.addActionListener(this);
        add(next);

       getContentPane().setBackground(Color.white);

      setSize(750,770);
      setLocation(350,60);
      setVisible(true);
      setTitle("Page 1 ");
    }
public void actionPerformed(ActionEvent ae){
        String formno= ""+x;//coverting x to string;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) (dateChooser.getDateEditor().getUiComponent())).getText();

        String gender=null;
        if(male.isSelected())
            gender="Male";
            else
                gender="Female";
            String email=enameTextField.getText();

            String marital=null;
            if(married.isSelected())
                marital="Married";
            else
                marital="Unmarried";

            String address=addressTextField.getText();
            String city=cityTextField.getText();
            String state=stateTextField.getText();
            String pin=pinTextField.getText();

            try{
                if(name.equals("")) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Name is required ");
                    if(ae.getSource()==next)
                        setVisible(true);
                }
                else
                {
                    Conn c= new Conn();//for creating conncection...
                    String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                       c.s.executeUpdate(query);//the query runs in the mysql..
                         setVisible(false);
                    new SignupTwo(formno).setVisible(true);
                }//mysql query..

            }catch(Exception e){
                System.out.println(e);
            }

}
          public static void main(String[] args){
                 new SignupOne();
    }

}
