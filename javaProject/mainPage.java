package javaProject;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;


public class mainPage implements ActionListener{

    JFrame f =new JFrame();
    public mainPage()
    {   

          ImageIcon img = new ImageIcon("C:/Users/VCK Dinesh/Downloads/White Minimalist Flat Quotes Instagram Post (1).png");
          JLabel background = new JLabel("", img, JLabel.CENTER);
          //background.setBounds(300, 150, 500,500);
          background.setLayout(new FlowLayout());
          f.setContentPane(background);
       
          JMenu m1,m2,m3,m4;  
          JMenuItem i1, i2, i3,i4,i5,i6,i7,i8,i9,i10;  
          JMenuBar mb=new JMenuBar();  
          m1=new JMenu("Want to Donate blood");          
          i1=new JMenuItem("Search Blood Bank");  
          i2=new JMenuItem("Donor Login");
          i7=new JMenuItem("New Registration");

          m1.add(i1); m1.add(i2); m1.add(i7);
          m2=new JMenu("Looking For Blood");          
          i3=new JMenuItem("Hospital login");
          i4=new JMenuItem("Blood Seeker login");
          i5=new JMenuItem("Search Blood Bank");
          i8=new JMenuItem("Hospital Registration");
          i10=new JMenuItem("Blood Seeker Registration");
          m2.add(i5); m2.add(i4); m2.add(i8); m2.add(i3); m2.add(i10);    

          m3=new JMenu("About Us");          

          m4=new JMenu("Blood Bank");          
          i6=new JMenuItem("Blood Bank Login");  
          i9=new JMenuItem("Blood Bank Registration");

          
          i2.addActionListener(this);
          i2.setActionCommand("login");

          i3.addActionListener(this);
          i3.setActionCommand("hlogin");

          i4.addActionListener(this);
          i4.setActionCommand("slogin");

          i6.addActionListener(this);
          i6.setActionCommand("bblogin");

          i1.addActionListener(this);
          i1.setActionCommand("search");
          
          i5.addActionListener(this);
          i5.setActionCommand("searchbb");

          i7.addActionListener(this);
          i7.setActionCommand("dregister");

          i8.addActionListener(this);
          i8.setActionCommand("hregister");

          i10.addActionListener(this);
          i10.setActionCommand("sregister");

          i9.addActionListener(this);
          i9.setActionCommand("bbregister");

          m4.add(i6);m4.add(i9);

          mb.setBackground(Color.gray);
        
          mb.add(m3); 
          mb.add(m1);
          mb.add(m2); 
          mb.add(m4);

          
          f.setJMenuBar(mb);
		f.setSize(1100, 700);
       f.setLayout(null);
		f.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){
    
        if(e.getActionCommand()=="login"){
          Donorlogin.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="hlogin"){
           hospitallogin.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="slogin"){
            bloodseekerlogin.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="bblogin"){
          Bloodbanklogin.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="search"){
          searchbloodbank.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="searchbb"){
          search.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="dregister"){
          Dregistration.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="hregister"){
          Hregistration.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="sregister"){
          Sregistration.main(null);
        
          f.dispose();
        }
        else if(e.getActionCommand()=="bbregister"){
          Bregistration.main(null);
        
          f.dispose();
        }
    }

	public static void main(String[] args)
	{
		new mainPage();

	}

   
}
