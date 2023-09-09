package javaProject;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class search implements ActionListener {
  private JTextField cty;
  private JTextField bldgrp ;
  private JButton search;
  JTable table1;
  private JButton btn2;

  JTable searchbb =new JTable();
   String c,g;
         

  static JFrame f2;
  public search() {
    f2 = new JFrame("Search Blood Bank");
    cty = new JTextField(20);
    bldgrp = new JTextField(20);
    search = new JButton("Search");

    JLabel j1=new JLabel("Enter city :");
    f2.add(j1);
    JLabel j2=new JLabel("Enter Blood Grp :");
    f2.add(j2);
    search.addActionListener(this);
    search.setActionCommand("search");

    j1.setBounds(50,100,200,100);
    cty.setBounds(150,130,200,30);
    j2.setBounds(375,100,200,100);
    bldgrp.setBounds(500,130,200,30);
    search.setBounds(350,200,100,30);
    f2.add(cty);
    f2.add(bldgrp);
    f2.add(search);
    btn2 = new JButton("Go to Main Page");
    btn2.addActionListener(this);
    btn2.setActionCommand("goback");
    f2.add(btn2);
    btn2.setBounds(500, 300, 160, 40);
    
    

    f2.setSize(800, 600);
    f2.setLayout(null);
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setVisible(true);
  }
  
 
  
  public void actionPerformed(ActionEvent e){
    c=cty.getText();
    g=bldgrp.getText();
    if(e.getActionCommand()=="search"){
       
      table1 = new JTable();
        JFrame viewSeeker = new JFrame("Search blood_bank");
        viewSeeker.setSize(600,400);
        viewSeeker.setLocationRelativeTo(null);

        DefaultTableModel tabModel = new DefaultTableModel();
        tabModel.setColumnIdentifiers(new String[]{"BloodBank Id","Name","BloodGRp","Address","Contact_no"});
        table1.setModel(tabModel);

        viewSeeker.add(new JScrollPane(table1));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","#Kh@iDino1$0");
            PreparedStatement ps = con.prepareStatement("SELECT blood_bank_id, name, bloodgrp, address, contact_no FROM blood_bank JOIN blood_stock ON blood_stock.stock_id = blood_bank.stock_id ;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              if(c.equals(rs.getString("address")) && g.equals(rs.getString("bloodgrp"))){

                tabModel.addRow(new Object[]{rs.getInt("blood_bank_id"),rs.getString("name"),rs.getString("bloodgrp"),rs.getString("address"),rs.getString("contact_no")});
              }
        }
    }
        catch(Exception ex){
            ex.printStackTrace();
        }
        viewSeeker.setVisible(true);

    
    }
   

    if(e.getActionCommand()=="goback"){
    

      try {
          
          mainPage.main(null);
          f2.dispose();
      }
      catch (Exception exception) {
      exception.printStackTrace();
      }
  }
}

  public static void main(String[] args) {
    new search();
    
  }
}


