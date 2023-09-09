package javaProject;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

import java.sql.*;
public class Donor implements ActionListener{

    JFrame f;
    JPanel p1,p2;
    JTabbedPane tp;
    private JLabel statusLabel;
    String id; 
    String p;
    JTextField userText ;
    JPasswordField passwordText ;
    private JTextField i;
  private JButton delete;
  String c;
   public Donor(){
    f=new JFrame("Donor");
    p1=new JPanel();
    tp=new JTabbedPane();
    p2=new JPanel();
    statusLabel = new JLabel("",JLabel.CENTER);    
    statusLabel.setBounds(145,150,350,100);
    p1.add(statusLabel);
    p1.setVisible(true); 
    p1.setLayout(null);
    p2.setVisible(true); 
    p2.setLayout(null);
    
    

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
            String query ="UPDATE donordetails SET password ='"+p+"'  WHERE id = '"+id+"';";
            Statement sta = con.createStatement();
           int x=sta.executeUpdate(query);
         
           if(x==1){
             JOptionPane.showMessageDialog(null, " Password Updated");
           }
            String data = "Username " + userText.getText();
    data += ", Password: " + new String(passwordText.getPassword()); 
    statusLabel.setText(data);
    Donorlogin.main(null);
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
              String query ="delete from Donor where id='"+c+"';";
              String q2 ="delete from Donordetails where id='"+c+"';";
            Statement sta = con.createStatement();
           sta.executeUpdate(query);
           sta.executeUpdate(q2);
           JOptionPane.showMessageDialog(null, "Account Deleted");
           mainPage.main(null);
              con.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
    }
    
    
}

    void dis()
{
f.getContentPane().add(tp);
tp.addTab("Update Password",p1);
tp.addTab("Delete Account",p2);


f.setSize(700,450);
f.setVisible(true);
f.setResizable(true);
}
public static void main(String z[]){
    Donor d = new Donor();
    d.dis();
    }
}