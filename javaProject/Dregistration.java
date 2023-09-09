package javaProject;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.sql.*;



public class Dregistration  {
     static JFrame f2 = new JFrame();
    private JPanel contentPane;
    private JTextField Name;
    private JTextField DOB;
    private JTextField Bloodgrp;
    private JTextField Gender;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

 
  

    public Dregistration() {
  
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel lblNewUserRegister = new JLabel("Donor Registration");
        lblNewUserRegister.setBounds(462, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("DOB");
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblBloodgrp = new JLabel("Bloodgrp");
        lblBloodgrp.setBounds(58, 324, 124, 36);
        contentPane.add(lblBloodgrp);

        Name = new JTextField();
        Name.setBounds(214, 151, 228, 50);
        contentPane.add(Name);
        Name.setColumns(10);

        DOB = new JTextField();
        DOB.setBounds(214, 235, 228, 50);
        contentPane.add(DOB);
        DOB.setColumns(10);

        Bloodgrp = new JTextField();

        Bloodgrp.setBounds(214, 320, 228, 50);
        contentPane.add(Bloodgrp);
        Bloodgrp.setColumns(10);

        Gender = new JTextField();
        Gender.setBounds(707, 151, 228, 50);
        contentPane.add(Gender);
        Gender.setColumns(10);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(542, 159, 99, 29);
        contentPane.add(lblGender);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n= Name.getText();
                String d = DOB.getText();
                String Bgrp = Bloodgrp.getText();
                String G = Gender.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
               String password = String.valueOf(passwordField.getPassword());

                String msg = "" + n;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");

                    String query = "INSERT INTO Donor(dname, dob, bloodgrp, gender, phone_no) values('" + n + "','" + d + "','" + Bgrp + "','" + G + "','" + mobileNumber + "');";
                    

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);

                    con.close();
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
                    String q2 = "INSERT INTO Donordetails  (password) values ('"+ password +"');";
                    Statement st2 = cn.createStatement();

                    st2.executeUpdate(q2);
                    cn.close();
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                            Donorlogin.main(null);
                            f2.dispose();
                    }
                   
                    
                } catch (Exception exception) {
                    if(len==10){
                        JOptionPane.showMessageDialog(null, "Enter all  the details", "Error", JOptionPane.ERROR_MESSAGE);

                    }
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
    new Dregistration();
    
}
}
