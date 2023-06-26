import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


    public class Withdrawl extends JFrame implements ActionListener {

        JTextField amount;
        JButton withdraw,back;
        String pinnumber;
        Withdrawl(String pinnumber){
            this.pinnumber=pinnumber;
            setLayout(null);

            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atmsi.jpg"));
            Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);

            JLabel text=new JLabel("Enter the amount you want to withdraw");
            text.setForeground(Color.white);
            text.setFont(new Font("System",Font.BOLD,19));
            text.setBounds(160,330,500,30);
            image.add(text);

            amount =new JTextField();
            amount.setFont(new Font("Raleway",Font.BOLD,22));
            amount.setBounds(160,370,320,25);
            amount.setBackground(Color.white);
            amount.setForeground(Color.blue);
            image.add(amount);

            withdraw =new JButton("Withdraw");
            withdraw.setFont(new Font("Raleway", Font.BOLD,15));
            withdraw.setBounds(350,480,150,30);
            withdraw.addActionListener(this);
            image.add(withdraw);

            back =new JButton("Back");
            back.setFont(new Font("Raleway", Font.BOLD,15));
            back.setBounds(350,515,150,30);
            back.addActionListener(this);
            image.add(back);




            setSize(900,900);
            setLocation(300,0);
            setUndecorated(true);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==withdraw){
                String number=amount.getText();
                Date date=new Date();
                if(number.equals(""))
                    JOptionPane.showMessageDialog(null,"Please enter amount");
                else
                { try {

                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs."+number+" Withdrawn Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }

        }
        public static void main(String[] args) {
            new Withdrawl("");
        }
    }


