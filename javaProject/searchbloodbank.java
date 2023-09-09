package javaProject;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class searchbloodbank implements ActionListener {
  private JTextField cty;
  private JButton search;
  private JButton btn2;

  JTable table1;
  JTable searchbb =new JTable();
   String c;
         

  static JFrame f2;
  public searchbloodbank() {
    f2 = new JFrame("Search Blood Bank");
    cty = new JTextField(20);
    search = new JButton("Search");

    JLabel j1=new JLabel("Enter city :");
    f2.add(j1);
    search.addActionListener(this);
    search.setActionCommand("search");

    j1.setBounds(100,100,200,100);
    cty.setBounds(200,130,200,30);
    search.setBounds(500,130,100,30);
    f2.add(cty);
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
    if(e.getActionCommand()=="search"){
       
      table1 = new JTable();
        JFrame viewSeeker = new JFrame("Search blood bank");
        viewSeeker.setSize(600,400);
        viewSeeker.setLocationRelativeTo(null);

        DefaultTableModel tabModel = new DefaultTableModel();
        tabModel.setColumnIdentifiers(new String[]{"blood_bank_id","name","address","contact_no","stock_id"});
        table1.setModel(tabModel);

        viewSeeker.add(new JScrollPane(table1));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","#Kh@iDino1$0");
            PreparedStatement ps = con.prepareStatement("select * from blood_bank");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              if(c.equals(rs.getString("address"))){
                tabModel.addRow(new Object[]{rs.getInt("blood_bank_id"),rs.getString("name"),rs.getString("address"),rs.getString("contact_no"),rs.getInt("stock_id")});
        }}
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
    new searchbloodbank();
    
  }
}

