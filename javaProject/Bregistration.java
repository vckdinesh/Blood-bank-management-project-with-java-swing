package javaProject;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.sql.*;



public class Bregistration  {
     static JFrame f2 = new JFrame();
    private JPanel contentPane;
    private JTextField Name;
    private JTextField Address;
    private JTextField contact_no;
    private JPasswordField passwordField;
    private JButton btnNewButton;

 
  

    public Bregistration() {
  
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel lblNewUserRegister = new JLabel("Blood Bank Registration");
        lblNewUserRegister.setBounds(462, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Address");
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

      
        Name = new JTextField();
        Name.setBounds(214, 151, 228, 50);
        contentPane.add(Name);
        Name.setColumns(10);

        Address = new JTextField();
        Address.setBounds(214, 235, 228, 50);
        contentPane.add(Address);
        Address.setColumns(10);

      
        contact_no = new JTextField();
        contact_no.setBounds(707, 151, 228, 50);
        contentPane.add(contact_no);
        contact_no.setColumns(10);

        JLabel lblcontact_no = new JLabel("Contact Number");
        lblcontact_no.setBounds(542, 159, 99, 29);
        contentPane.add(lblcontact_no);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        


        passwordField = new JPasswordField();
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n= Name.getText();
                String a = Address.getText();
                String c= contact_no.getText();
               String password = String.valueOf(passwordField.getPassword());

                String msg = "" + n;
                msg += " \n";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");

                    String query = "INSERT INTO blood_bank ( name, address, contact_no, stock_id) values('" + n + "','" + a + "','" + c + "',2);";
                    

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);

                    con.close();
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
                    String q2 = "INSERT INTO bbdetails(password) values ('"+ password +"');";
                    Statement st2 = cn.createStatement();

                    st2.executeUpdate(q2);
                    cn.close();
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else if(x==1) {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                            Bloodbanklogin.main(null);
                            f2.dispose();
                    }
                   
                    
                } catch (Exception exception) {
                   
                        JOptionPane.showMessageDialog(null, "Enter all  the details", "Error", JOptionPane.ERROR_MESSAGE);

            
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
        contentPane.setSize(990, 550);
        contentPane.setLayout(null);
        contentPane.setVisible(true);
        f2.add(contentPane);

    f2.setSize(990, 650);
    f2.setLayout(null);
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setVisible(true);
    }


public static void main(String[] args) {
    new Bregistration();
    
}
}
