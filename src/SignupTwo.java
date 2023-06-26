import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame  {

    JTextField panTextField,aadharNumberTextField;
    JComboBox rel,cat,ocp,edn,in;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);


        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(250,50,400,80);
        add(additionalDetails);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(90,150,100,30);
        add(religion);

        String[] a={"Hindu","Muslim","Christian","Other"};
         rel=new JComboBox(a);
        rel.setBackground(Color.white);
        rel.setForeground(Color.darkGray);
        rel.setBounds(250,150,400,30);
        add(rel);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(90,200,100,30);
        add(category);

        String[] b={"General","OBC","SC","ST","Others"};
         cat=new JComboBox(b);
        cat.setBounds(250,200,400,30);
        cat.setBackground(Color.white);
        add(cat);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(90,250,100,30);
        add(income);

        String[] c={"NULL","< 1.5 Lakh","< 2.5 Lakh","< 5 Lakh","Upto 10 Lakh"};
         in=new JComboBox(c);
        in.setBounds(250,250,400,30);
        in.setBackground(Color.white);
        add(in);



        JLabel educational=new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(90,300,200,30);
        add(educational);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(90,320,200,30);
        add(qualification);

        String[] d={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
         edn=new JComboBox(d);
        edn.setBounds(250,320,400,30);
        edn.setBackground(Color.white);
        add(edn);

        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(90,370,200,30);
        add(occupation);

        String[] e={"Salaried","Self-Employed","Business","Retired","Studtent","Others"};
         ocp=new JComboBox(e);
        ocp.setBounds(250,370,400,30);
        ocp.setBackground(Color.white);
        add(ocp);

        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(90,420,200,30);
        add(pan);

        panTextField =new JTextField();
        panTextField.setBounds(250,420,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(panTextField);

        JLabel Aadhar=new JLabel("Aadhar Number:");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(90,470,200,30);
        add(Aadhar);

        aadharNumberTextField =new JTextField();
        aadharNumberTextField.setBounds(250,470,400,30);
        aadharNumberTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadharNumberTextField);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(90,520,200,30);
        add(senior);

         syes=new JRadioButton("Yes");
        syes.setBounds(300,520,100,30);
        syes.setBackground(Color.white);
        add(syes);

         sno=new JRadioButton("No");
        sno.setBounds(500,520,100,30);
        sno.setBackground(Color.white);
        add(sno);

        JLabel existing=new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(90,570,200,30);
        add(existing);

         eyes=new JRadioButton("Yes");
        eyes.setBounds(300,570,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

         eno=new JRadioButton("No");
        eno.setBounds(500,570,100,30);
        eno.setBackground(Color.white);
        add(eno);

         next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(600,650,80,30);
        next.addActionListener(this::actionPerformed);
        //next.setEnabled(false); a button can be disabled..
        add(next);


        setSize(750,770);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setLocation(400,40);
        setTitle("Page 2");

    }

    public void actionPerformed(ActionEvent ae){
//    JComboBox rel,cat,ocp,edn,in;
        String sreligion=(String) rel.getSelectedItem();//type casting as it returns an object..
        String scategory=(String) cat.getSelectedItem();
        String soccupation=(String) ocp.getSelectedItem();
        String seducation=(String) edn.getSelectedItem();
        String sincome=(String) in.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected())
            seniorcitizen="Yes";
        else if(sno.isSelected())
            seniorcitizen="No";
        String existingaccount=null;
        if(eyes.isSelected())
            existingaccount="yes";
        else if(eno.isSelected())
            existingaccount="No";

String span=panTextField.getText();
String aadhar=aadharNumberTextField.getText();
try{
      Conn c=new Conn();
      String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+aadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
    c.s.executeUpdate(query);

    setVisible(false);
    new SignupThree(formno).setVisible(true);


}catch(Exception e){
    System.out.println(e);
}

    }
    public static void main(String[] args) {
        new SignupTwo("");

    }

}
