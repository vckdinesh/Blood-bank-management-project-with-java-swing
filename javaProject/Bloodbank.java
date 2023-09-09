package javaProject;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
public class Bloodbank implements ActionListener{

    JFrame f;
    JPanel p1,p2,p3,p4;
    JTabbedPane tp;
    private JLabel statusLabel;
    JTable table1,table2;
    String id; 
    String p;
    JTextField userText ;
    JPasswordField passwordText ;
    JButton viewbtn1,viewbtn2;
    private JTextField i;
  private JButton delete;
  String c;
   public Bloodbank(){
    f=new JFrame("Blood bank");
    p1=new JPanel();
    tp=new JTabbedPane();
    p2=new JPanel();
    p3=new JPanel();
    p4=new JPanel();
    statusLabel = new JLabel("",JLabel.CENTER);    
    statusLabel.setBounds(145,150,350,100);
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
    JLabel passwordLabel = new JLabel("New Password: ", JLabel.CENTER);
     userText = new JTextField(6);
     passwordText = new JPasswordField(6); 
     JButton loginButton = new JButton("Login");
     loginButton.addActionListener(this);
   loginButton.setActionCommand("update");
   namelabel.setBounds(10, 90,100, 30);
   userText.setBounds(120, 90,100, 30);
   passwordLabel.setBounds(250, 90,100, 30);
   passwordText.setBounds(350, 90,100, 30);
  loginButton.setBounds(500,90, 100, 30);
   p1.add(namelabel);
   p1.add(userText);
   p1.add(passwordLabel);       
   p1.add(passwordText);
   p1.add(loginButton);
   JButton viewbtn1 = new JButton("View seeker request");
   viewbtn1.addActionListener(this);
   viewbtn1.setActionCommand("viewbtn1");
   viewbtn1.setBounds(250, 100,120, 40);
   p3.add(viewbtn1);
   JButton viewbtn2 = new JButton("View Hospital request");
viewbtn2.addActionListener(this);
viewbtn2.setActionCommand("viewbtn2");
viewbtn2.setBounds(250, 100,120, 40);
   p4.add(viewbtn2);


   j1.setBounds(100,100,200,100);
    i.setBounds(200,130,200,30);
    delete.setBounds(500,130,100,30);
    p2.add(i);
    p2.add(delete);

   }
   public void actionPerformed(ActionEvent e){
    id=userText.getText();
    p=String.valueOf(passwordText.getPassword());
    c=i.getText();
    if(e.getActionCommand()=="update"){
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
            String query ="UPDATE bbdetails SET password ='"+p+"'  WHERE id = '"+id+"';";
            Statement sta = con.createStatement();
           int x=sta.executeUpdate(query);
         
           if(x==1){
             JOptionPane.showMessageDialog(null, " Password Updated");
           }
            String data = "Username " + userText.getText();
    data += ", Password: " + new String(passwordText.getPassword()); 
    statusLabel.setText(data);
    Bloodbanklogin.main(null);
    f.dispose(); 
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
     if(e.getActionCommand()=="delete"){
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
              String query ="delete from Blood_bank where blood_bank_id='"+c+"';";
              String q2 ="delete from bbdetails where id='"+c+"';";
            Statement sta = con.createStatement();
           sta.executeUpdate(query);
           sta.executeUpdate(q2);
           JOptionPane.showMessageDialog(null, "Account Deleted");
           mainPage.main(null);
           f.dispose();
              con.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
    }
    if(e.getActionCommand()=="viewbtn1"){
        table1 = new JTable();
        JFrame viewSeeker = new JFrame("View Seeker Request");
        viewSeeker.setSize(600,400);
        viewSeeker.setLocationRelativeTo(null);

        DefaultTableModel tabModel = new DefaultTableModel();
        tabModel.setColumnIdentifiers(new String[]{"Srequest ID","ID","Blood Bank Id","BloodGroup","Quantity","Location","Request_Date","Priscription","Status"});
        table1.setModel(tabModel);

        viewSeeker.add(new JScrollPane(table1));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","#Kh@iDino1$0");
            PreparedStatement ps = con.prepareStatement("select * from srequest");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tabModel.addRow(new Object[]{rs.getInt("Srequest_id"),rs.getInt("id"),rs.getString("blood_bank_id"),rs.getString("bloodgrp"),rs.getString("quantity"),rs.getString("location"),rs.getString("request_date"),rs.getString("prescription"),rs.getString("status")});
        }
    }
        catch(Exception ex){
            ex.printStackTrace();
        }
        viewSeeker.setVisible(true);
    }
    
    if(e.getActionCommand()=="viewbtn2"){
        table2 = new JTable();
        JFrame viewSeeker = new JFrame("View hospital Request");
        viewSeeker.setSize(600,400);
        viewSeeker.setLocationRelativeTo(null);

        DefaultTableModel tabModel = new DefaultTableModel();
        tabModel.setColumnIdentifiers(new String[]{"hrequest ID","hospital ID","Blood Bank Id","BloodGroup","Quantity","Location","Request_Date","Status"});
        table2.setModel(tabModel);

        viewSeeker.add(new JScrollPane(table2));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","#Kh@iDino1$0");
            PreparedStatement ps = con.prepareStatement("select * from hrequest");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tabModel.addRow(new Object[]{rs.getInt("hrequest_id"),rs.getInt("hospital_id"),rs.getString("blood_bank_id"),rs.getString("bloodgrp"),rs.getString("quantity"),rs.getString("location"),rs.getString("request_date"),rs.getString("status")});
        }
    }
        catch(Exception ex){
            ex.printStackTrace();
        }
        viewSeeker.setVisible(true);
    }
    
    
}

    void dis()
{
f.getContentPane().add(tp);
tp.addTab("Update Password",p1);
tp.addTab("Delete Account",p2);
tp.addTab("View Seeker Request",p3);
tp.addTab("View Hospital Request",p4);

f.setSize(700,450);
f.setVisible(true);
f.setResizable(true);
}
public static void main(String z[]){
    Bloodbank d = new Bloodbank();
    d.dis();
    }
}