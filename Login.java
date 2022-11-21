import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;
public class Login extends JFrame implements ActionListener
{

   private JPanel panel;
   private JCheckBox jCheckBox;
   private JLabel label1, label2;
   private JTextField textField1;
   private JPasswordField passwordField;
   private JButton button1, button2, button3;
   private static HashMap<String, String> userInfo = new HashMap<String, String>();
   private static ArrayList<String> loggedIn = new ArrayList<String>();

   public Login()
   {
 
      setTitle("Login");
      setSize(300, 290);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      panel = new JPanel();
      panel.setLayout(null);
     
      
      

      label1 = new JLabel("User name:");
      label1.setBounds(10, 35, 80, 25);
      panel.add(label1);
      

      textField1 = new JTextField(20);
      textField1.setBounds(100, 35, 165, 35);
      panel.add(textField1);
      

      label2 = new JLabel("Password:");
      label2.setBounds(10, 100, 80, 25);
      panel.add(label2);
      

      passwordField = new JPasswordField(20);
      passwordField.setBounds(100, 100, 165, 35);
      panel.add(passwordField);
      

      jCheckBox = new JCheckBox("show password");
      jCheckBox.setBounds(100, 150, 150, 20);
      panel.add(jCheckBox);
      jCheckBox.addActionListener(ae -> {
         JCheckBox c = (JCheckBox) ae.getSource();
         passwordField.setEchoChar(c.isSelected() ? '\u0000' : (Character)         
         UIManager.get("PasswordField.echoChar"));
      });
   
      

      button1 = new JButton("Login");
      button1.setBounds(10, 200, 80, 25);
      button1.setBackground(Color.pink);
      button1.addActionListener(this);
      panel.add(button1);
      
 
      button2 = new JButton("Logout");
      button2.setBounds(100, 200, 80, 25);
      button2.addActionListener(this);
      panel.add(button2);
      

      button3 = new JButton("Exit");
      button3.setBounds(190, 200, 80, 25);
      button3.setForeground(Color.white);
      button3.setBackground(Color.RED);
      button3.addActionListener(this);
      panel.add(button3);

      

      
      

      add(panel);
      setVisible(true);
      setLocationRelativeTo(null); 
   }
   
   

   public static void main(String[] args)
   {
      Login frame = new Login();
      userInfo.put("user1", "password1");
      userInfo.put("user2", "password2");
   }

   public void actionPerformed(ActionEvent ae)
   {
     
      if(ae.getSource() == button1)
      {
         String userName = textField1.getText();
         String password = passwordField.getText();

         if(userInfo.containsKey(userName) && userInfo.get(userName).equals(password))
         {
            if(!loggedIn.contains(userName))
            {
               loggedIn.add(userName);
               JOptionPane.showMessageDialog(null, "User " + userName + " has logged in");
            }
            else
            {
               JOptionPane.showMessageDialog(null, "User " + userName + " is already logged in");
            }
         }
         else
         {
            JOptionPane.showMessageDialog(null, "User " + userName + " is not found!");
         }
      }
      

      if(ae.getSource() == button2)
      {
         String userName = textField1.getText();
         
         if(loggedIn.contains(userName))
         {
            loggedIn.remove(userName);
            JOptionPane.showMessageDialog(null, "User " + userName + " has been logged out");
         }
         else
         {
            JOptionPane.showMessageDialog(null, "User " + userName + " is not logged in");
         }
      }
      
      if(ae.getSource() == button3)
      {
         System.exit(0);
      }
   }
}