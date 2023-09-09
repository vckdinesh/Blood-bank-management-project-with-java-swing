package javaProject;

import javax.swing.*;
import javax.swing.JFrame;


import java.awt.event.*;
import java.sql.*;

public class hospitallogin implements ActionListener {
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton loginButton;
  private String un;
  private char[] pswrd;
  public String u1;
  public String p1;
  public int c=0;
  JFrame f2;
  public hospitallogin() {
    f2 = new JFrame("Hospital Login");
    usernameField = new JTextField(20);
    passwordField = new JPasswordField(20);
    loginButton = new JButton("Login");

    JLabel j1=new JLabel("Hospital id:");
    f2.add(j1);
    JLabel j2=new JLabel("Password:");
    f2.add(usernameField);
    //f2.add(Box.createHorizontalStrut(15)); // a spacer
    f2.add(j2);
    f2.add(passwordField);
    loginButton.addActionListener(this);
    loginButton.setActionCommand("check");

    j1.setBounds(100,100,200,100);
    usernameField.setBounds(200,130,200,30);
    j2.setBounds(100,200,100,100);
    passwordField.setBounds(200,230,200,30);
    loginButton.setBounds(220,320,100,30);
    
    f2.add(loginButton);

    f2.setSize(600, 500);
    f2.setLayout(null);
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setVisible(true);
  }
  

  
  public void actionPerformed(ActionEvent e){
    
    if(e.getActionCommand()=="check"){
        un=usernameField.getText();
        pswrd=passwordField.getPassword();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id,password from hdetails ;");
            while(rs.next()){
               u1=rs.getString("id");
               p1=rs.getString("password");
               if(u1.equalsIgnoreCase(un) && p1.equalsIgnoreCase(String.valueOf(pswrd))){
                JOptionPane.showMessageDialog(null, " Login Successful");
                Hospital.main(null);
                c=1;
                break;
              }
            }
            
            if(c!=1){
                     
       JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            con.close();
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "All the details are not correct;", "Error", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        }
    }
    f2.dispose();
}

  public static void main(String[] args) {
    new hospitallogin();
  }
}

