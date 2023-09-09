package javaProject;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.sql.*;



public class Hregistration  {
     static JFrame f2 = new JFrame();
    private JPanel contentPane;
    private JTextField Name;
    private JTextField Email;
    private JTextField city;;
    private JTextField contact_no;
    private JPasswordField passwordField;
    private JButton btnNewButton;

 
  

    public Hregistration() {
  
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel lblNewUserRegister = new JLabel("Hospital Registration");
        lblNewUserRegister.setBounds(462, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Email");
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblcity = new JLabel("city");
        lblcity.setBounds(542, 245, 99, 24);
        contentPane.add(lblcity);

        Name = new JTextField();
        Name.setBounds(214, 151, 228, 50);
        contentPane.add(Name);
        Name.setColumns(10);

        Email = new JTextField();
        Email.setBounds(214, 235, 228, 50);
        contentPane.add(Email);
        Email.setColumns(10);

        city = new JTextField();

        city.setBounds(707, 235, 228, 50);
        contentPane.add(city);
        city.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(308, 324, 124, 36);
        contentPane.add(lblPassword);

        JLabel lblcontact_Number = new JLabel("contact  number");
        lblcontact_Number.setBounds(542, 159, 99, 29);
        contentPane.add(lblcontact_Number);

        contact_no = new JTextField();
        contact_no.setBounds(707, 151, 228, 50);
        contentPane.add(contact_no);
        contact_no.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 320, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n= Name.getText();
                String em= Email.getText();
                String cty = city.getText();
                String contact_Number = contact_no.getText();
                int len = contact_Number.length();
               String password = String.valueOf(passwordField.getPassword());

                String msg = "" + n;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid contact_number");
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");

                    String query = "INSERT INTO hospital(name, email, address, contact_no) values('" + n + "','" + em + "','" + cty + "','" + contact_Number + "');";
                    

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);

                    con.close();
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "#Kh@iDino1$0");
                    String q2 = "INSERT INTO hdetails(password) values ('"+ password +"');";
                    Statement st2 = cn.createStatement();

                    st2.executeUpdate(q2);
                    cn.close();
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(f2,
                            "Welcome, " + msg + "Your account is sucessfully created");
                            hospitallogin.main(null);
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
    new Hregistration();
    
}
}
