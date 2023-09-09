package javaProject;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class Bloodseeker  implements ActionListener{

    JFrame f;
    JPanel p1,p2,p3,p4;
    JTabbedPane tp;
    private JLabel statusLabel;
    String id; 
    String p;
    JTextField userText ;
    JTextField Requestdate ;
    private JTextField i;
  private JButton delete;
  String c;


  private JTextField Seekerid;
  private JTextField Bloodbankid;
  private JTextField Bloodgrp;
  private JTextField Quantity;
  private JTextField location;
  private JTextField Request_date;
  private JTextField Prescription;
  private JButton btnNewButton;
    private JButton btn1;
    private JButton btn2;
  String d1;


  private JTextField Seid;
  

  private JTextField Qty;

  



   public Bloodseeker(){
    f=new JFrame("BloodSeeker");
    p1=new JPanel();
    tp=new JTabbedPane();
    p2=new JPanel();
    p3=new JPanel();
    p4=new JPanel();
    statusLabel = new JLabel("",JLabel.CENTER);    
    statusLabel.setBounds(137,231,350,100);
    p1.add(statusLabel);
    p1.setVisible(true); 
    p1.setLayout(null);
    p2.setVisible(true); 
    p2.setLayout(null);
    p3.setVisible(true); 
    p3.setLayout(null);
    p4.setVisible(true); 
    p4.setLayout(null);
    

    i = new JTextField(20);
    delete = new JButton("Delete Account");

    JLabel j1=new JLabel("Enter id:");
    p2.add(j1);
    delete.addActionListener(this);
    delete.setActionCommand("delete");

    
    JLabel namelabel= new JLabel("User ID: ", JLabel.RIGHT);
    JLabel RequestdateLabel = new JLabel("New password: ", JLabel.CENTER);
     userText = new JTextField(6);
     Requestdate = new JTextField(6); 
     JButton loginButton = new JButton("Login");
     loginButton.addActionListener(this);
   loginButton.setActionCommand("update");
   namelabel.setBounds(17, 115,100, 30);
   userText.setBounds(127, 116,100, 30);
   RequestdateLabel.setBounds(257, 115,100, 30);
   Requestdate.setBounds(367, 116,100, 30);
  loginButton.setBounds(499,115, 100, 30);
   p1.add(namelabel);
   p1.add(userText);
   p1.add(RequestdateLabel);       
   p1.add(Requestdate);
   p1.add(loginButton);


   j1.setBounds(100,100,200,100);
    i.setBounds(200,130,200,30);
    delete.setBounds(500,130,150,30);
    p2.add(i);
    p2.add(delete);




    p3.setBorder(new EmptyBorder(5, 5, 5, 5));
      
    
 
    JLabel lblNewUserRegister = new JLabel("Request Form");
    lblNewUserRegister.setBounds(312, 12, 325, 50);
    p3.add(lblNewUserRegister);

    JLabel lblSeekerid = new JLabel("Seeker id :");
    lblSeekerid.setBounds(58, 67, 99, 43);
    p3.add(lblSeekerid);

    JLabel lblNewLabel = new JLabel("BloodBank Id");
    lblNewLabel.setBounds(49, 132, 69, 29);
    p3.add(lblNewLabel);

    JLabel lblBloodgrp = new JLabel("Bloodgrp");
    lblBloodgrp.setBounds(58, 195, 124, 36);
    p3.add(lblBloodgrp);

    JLabel lblprscrption = new JLabel("prescription");
    lblprscrption.setBounds(368, 195, 124, 36);
    p3.add(lblprscrption);


    Seekerid = new JTextField();
    Seekerid.setBounds(150, 70, 160, 40);
    p3.add(Seekerid);
    Seekerid.setColumns(10);

    Bloodbankid = new JTextField();
    Bloodbankid.setBounds(150, 127, 160, 40);
    p3.add(Bloodbankid);
    Bloodbankid.setColumns(15);

    Prescription= new JTextField();
    Prescription.setBounds(437, 194, 160, 40);
    p3.add(Prescription);
    Prescription.setColumns(10);

    Bloodgrp = new JTextField();

    Bloodgrp.setBounds(150, 194, 160, 40);
    p3.add(Bloodgrp);
    Bloodgrp.setColumns(10);

    Quantity = new JTextField();
    Quantity.setBounds(437, 69, 160, 40);
    p3.add(Quantity);
    Quantity.setColumns(10);

  

    JLabel lblQuantity = new JLabel("Quantity");
    lblQuantity.setBounds(368, 74, 99, 29);
    p3.add(lblQuantity);

    JLabel lblRequestdate = new JLabel("Request date");
    lblRequestdate.setBounds(225, 268, 99, 24);
    p3.add(lblRequestdate);

    JLabel lbllocation = new JLabel("location");
    lbllocation.setBounds(368, 133, 139, 26);
    p3.add(lbllocation);

    location = new JTextField();
    location.setBounds(437, 127, 160, 40);
    p3.add(location);
    location.setColumns(10);

    Request_date = new JTextField();
    Request_date.setBounds(310, 261, 160, 40);
    p3.add(Request_date);

    btnNewButton = new JButton("Request");
    btnNewButton.addActionListener(this);
    btnNewButton.setActionCommand("Request");
    p3.add(btnNewButton);
    btnNewButton.setBounds(275, 330, 160, 40);

    JRadioButton jRadioButton1;

	JRadioButton jRadioButton2;

    ButtonGroup G1;
    JLabel L1;
    btn2 = new JButton("Go to Main Page");
    btn2.addActionListener(this);
    btn2.setActionCommand("goback");
    p2.add(btn2);
    btn2.setBounds(500, 300, 160, 40);
   
    JLabel lblpay = new JLabel("Payment");
    lblpay.setBounds(312, 12, 325, 50);
    p4.add(lblpay);
    
    JLabel requestid = new JLabel("Request id :");
    requestid.setBounds(58, 67, 99, 43);
    p4.add(requestid);


    JLabel Date = new JLabel("Date");
    Date.setBounds(356, 149, 99, 29);
    p4.add(Date);

    JLabel lblquantity = new JLabel("Quantity");
    lblquantity.setBounds(350, 72, 139, 26);
   p4.add(lblquantity);

   Seid = new JTextField();
   Seid.setBounds(113, 69, 160, 40);
   p4.add(Seid);
   Seid.setColumns(15);
   Qty= new JTextField();
    Qty.setBounds(437, 69, 160, 40);
    p4.add(Qty);
    Qty.setColumns(10);


   jRadioButton1 = new JRadioButton();
	jRadioButton2 = new JRadioButton();

        G1 = new ButtonGroup();

		L1 = new JLabel("Pay with");

        jRadioButton1.setText("UPI");

		jRadioButton2.setText("Net Banking");

        jRadioButton1.setBounds(153, 138, 120, 50);

		jRadioButton2.setBounds(152, 190, 80, 50);

        L1.setBounds(10, 138, 150, 50);
        p4.add(jRadioButton1);
		p4.add(jRadioButton2);
		p4.add(L1);

		G1.add(jRadioButton1);
		G1.add(jRadioButton2);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                d1=String.valueOf(dateChooser.getDate());
			}
		});
		dateChooser.setBounds(437, 149, 139, 39);
		p4.add(dateChooser);



        btn1 = new JButton("Make payment");
    btn1.addActionListener(this);
    btn1.setActionCommand("payment");
    p4.add(btn1);
    btn1.setBounds(248, 241, 160, 40);

 
   }

   
   public void actionPerformed(ActionEvent e){
    id=userText.getText();
    p=Requestdate.getText();
    c=i.getText();


                String d = Bloodbankid.getText();
                String sid=Seekerid.getText();
                String Bgrp = Bloodgrp.getText();
                String G = Quantity.getText();
                String ln = location.getText();
               String rd =Request_date.getText(); 
               String pr=Prescription.getText();
               String sd=Seid.getText();
              int check=0;
              

                
              String quaty=Qty.getText();

    if(e.getActionCommand()=="update"){
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
            String query ="UPDATE sdetails SET password  ='"+p+"'  WHERE id = '"+id+"';";
            Statement sta = con.createStatement();
           int x=sta.execute
         
           if(x==1){
             JOptionPane.showMessageDialog(null, "Password Updated");
             bloodseekerlogin.main(null);
           }
            String data = "Username " + userText.getText();
    data += ", Requestdate: " + new String(Requestdate.getText()); 
    statusLabel.setText(data);
//    bloodseekerlogin.main(null);
    f.dispose(); 
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
     if(e.getActionCommand()=="delete"&& id!=null){
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
              String query ="delete from blood_seeker where id='"+c+"';";
              String q2 ="delete from sdetails where id='"+c+"';";
            Statement sta = con.createStatement();
           sta.executeUpdate(query);
           sta.executeUpdate(q2);
           JOptionPane.showMessageDialog(null, "Account Deleted");
//           mainPage.main(null);
              con.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
    }
    if(e.getActionCommand()=="Request"){
        if(pr.equalsIgnoreCase("yes")){
           


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
                Statement st = cn.createStatement();
                String q1 = "INSERT INTO srequest ( ID, blood_bank_id, bloodgrp, quantity, location, request_date, prescription) values('" + sid + "','" + d + "','" + Bgrp + "','" + G + "','" + ln + "','" + rd + "','" + pr + "');";
                ResultSet rs = st.executeQuery("SELECT bs.quantity, bb.blood_bank_id, bs.bloodgrp FROM blood_stock bs JOIN blood_bank bb ON bs.stock_id = bb.stock_id;");
                while(rs.next()){
                    if((String.valueOf(rs.getInt("bs.quantity")).compareTo(G)>0) && String.valueOf(rs.getInt("bb.blood_bank_id")).equals(d) && rs.getString("bs.bloodgrp").equals(Bgrp) ){
                        st.executeUpdate(q1);
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Request accepted ");
                        check=1;
                        break;

                    }
                }
                if(check!=1){
                    JOptionPane.showMessageDialog(null, "Sorry,In that bloodbank quantity of blood that you need is unavailable", "Error", JOptionPane.ERROR_MESSAGE); 
                }

                
            
                        
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Sorry,Prescreption is necessary", "Error", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry,Prescreption is necessary", "Error", JOptionPane.ERROR_MESSAGE);

        }
        
}

if(e.getActionCommand()=="payment"){

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
                Statement st = cn.createStatement();
        String q1 = "INSERT INTO spayment (SRequest_id, quantity, date) values('"+sd+"','"+quaty+"','2023-01-12');";
        st.executeUpdate(q1);
        String q2 = "UPDATE srequest SET status = 'approved'  WHERE Srequest_ID = '"+sd+"';";
        st.executeUpdate(q2);
        JOptionPane.showMessageDialog(null, "Payment completed ");

    }
    catch (Exception exception) {
    exception.printStackTrace();
    }
}
if(e.getActionCommand()=="goback"){
    

    try {
        
        mainPage.main(null);
    }
    catch (Exception exception) {
    exception.printStackTrace();
    }
}
    
    
}

    void dis()
{
f.getContentPane().add(tp);
tp.addTab("Make request",p3);
tp.addTab("make Payment",p4);
tp.addTab("Update Password",p1);
tp.addTab("Delete Account",p2);


f.setSize(700,450);
f.setVisible(true);
f.setResizable(true);
}
public static void main(String z[]){
    Bloodseeker d = new Bloodseeker();
    d.dis();
    }




}