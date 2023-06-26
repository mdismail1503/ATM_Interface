import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
   JRadioButton r1,r2,r3,r4;
   JCheckBox c1,c2,c3,c4,c5,c6,c7;

   JButton submit,cancel;
   String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,28));
        l1.setBounds(240,40,400,40);
        add(l1);

        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,200,20);
        r1.setBackground(Color.white);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,400,20);
        r2.setBackground(Color.white);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,215,150,20);
        r3.setBackground(Color.white);
        add(r3);

        r4=new JRadioButton("RD Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,215,150,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);


        JLabel number=new JLabel("XXXX-XXXX-XXXX-4102");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,400,30);
        add(number);

        JLabel carddetail =new JLabel("Your 16 digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,200,20);
        add(carddetail);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,200,30);
        add(pnumber);

        JLabel pindetail =new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);

        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services);



        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4=new JCheckBox("e-Mail & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,500,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6=new JCheckBox("e-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,660,1000,30);
        add(c7);

        submit =new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(350,710,90,30);
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(220,710,90,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(820,810);
        setLocation(370,30);
        getContentPane().setBackground(Color.white);
        setTitle("page 3");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }else if(r2.isSelected())
                accounttype="Fixed Deposit Account";
            else if(r3.isSelected())
                accounttype="Current Account";
            else if(r4.isSelected())
                accounttype="RD account";

            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextInt()%90000000L)+5040936000L);

            String pinnumber=""+Math.abs(random.nextInt()%9000L)+1000L;
            String facility="";
        if(c1.isSelected())
            facility=""+"ATM Card";
        else if(c2.isSelected())
                facility=facility+"Internet Banking";
        else if(c3.isSelected())
                facility=facility+"Mobile Banking";
            else if(c4.isSelected())
                facility=facility+"e-Mail & SMS Alerts";
            else if(c5.isSelected())
                facility=facility+"Cheque Book";
            else if(c6.isSelected())
                facility=""+"e-Statement";
            try{
                if(accounttype.equals(""))
                    JOptionPane.showMessageDialog(null,"Account type is Required");
            else {
                Conn c=new Conn();
                String query1="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Card number: "+cardnumber+"\n Pin: "+pinnumber);
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            }

            }catch(Exception e){
                System.out.println(e);
            }
            if(ae.getSource()==cancel){
                setVisible(false);
                new Login().setVisible(true);
            }
        }

    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
