package src;
import javax.swing.*;
import java.awt.event.*;
public class Introduction extends JLabel implements ActionListener, View{
  JLabel title = new JLabel("Title");
  JPanel pane;
  JLabel welcome = new JLabel("Welcome to Numgrate!");
  JLabel sentence = new JLabel("This program will solve any definite integral,");
  JLabel sentence2 = new JLabel("using Newton-Cotes quadrature or Gaussian Quadrature.");
  JLabel sentence3 = new JLabel("It will solve the integral defined as:");
  JLabel function = new JLabel("Function");
  JLabel sentence4 = new JLabel("where a is the lower limit, b is the upper limit,");
  JLabel sentence5 = new JLabel("and f(x) is the function, all inputted by you.");
  JLabel fun = new JLabel("Happy Integrating!");
  JLabel credits = new JLabel("Created By: Kareem Golaub");
  JLabel thanks = new JLabel("Special thanks to Reyno Tilikaynen for his 'Equations' class.");
  
  public Introduction (JPanel pane) {
    this.pane = pane;
  }
  
  public void showUI() {
    pane.add(title);
    pane.add(welcome);
    pane.add(sentence);
    pane.add(sentence2);
    pane.add(sentence3);
    pane.add(sentence4);
    pane.add(sentence5);
    pane.add(function);
    pane.add(fun);
    pane.add(credits);
    pane.add(thanks);
  }
  
  public void removeUI() {
    pane.remove(title);
    pane.remove(welcome);
    pane.remove(sentence);
    pane.remove(sentence2);
    pane.remove(sentence3);
    pane.remove(sentence4);
    pane.remove(sentence5);
    pane.remove(function);
    pane.remove(fun);
    pane.remove(credits);
    pane.remove(thanks);
  }
  
  public void constraints() {
    SpringLayout layout = (SpringLayout) pane.getLayout();
    layout.putConstraint(SpringLayout.NORTH,title,44, SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST,title,-140,SpringLayout.EAST,pane);
    
    layout.putConstraint(SpringLayout.NORTH, welcome, 30, SpringLayout.SOUTH, title);
    layout.putConstraint(SpringLayout.EAST, welcome, -163, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH,sentence, 20, SpringLayout.SOUTH, welcome);
    layout.putConstraint(SpringLayout.EAST,sentence, -124,SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, sentence2, 2, SpringLayout.SOUTH, sentence);
    layout.putConstraint(SpringLayout.EAST,sentence2, -92, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, sentence3, 8, SpringLayout.SOUTH, sentence2);
    layout.putConstraint(SpringLayout.EAST, sentence3, -155, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, function, 15, SpringLayout.SOUTH,sentence3);
    layout.putConstraint(SpringLayout.EAST, function, -205, SpringLayout.EAST,pane);
    
    layout.putConstraint(SpringLayout.NORTH, sentence4, 15, SpringLayout.SOUTH,function);
    layout.putConstraint(SpringLayout.EAST, sentence4, -122, SpringLayout.EAST,pane);
    
    layout.putConstraint(SpringLayout.NORTH,sentence5,2, SpringLayout.SOUTH, sentence4);
    layout.putConstraint(SpringLayout.EAST,sentence5,-132, SpringLayout.EAST,pane);
    
    layout.putConstraint(SpringLayout.NORTH,fun,15, SpringLayout.SOUTH, sentence5);
    layout.putConstraint(SpringLayout.EAST,fun,-163,SpringLayout.EAST,pane);
    
    layout.putConstraint(SpringLayout.NORTH,credits, 45, SpringLayout.SOUTH,fun);
    layout.putConstraint(SpringLayout.EAST,credits,-175,SpringLayout.EAST,pane);
    
    layout.putConstraint(SpringLayout.NORTH, thanks, 5, SpringLayout.SOUTH, credits);
    layout.putConstraint(SpringLayout.EAST, thanks, -85, SpringLayout.EAST,pane);
  }
  
  public void init() {
    welcome.setFont (welcome.getFont().deriveFont (16.0f));
    fun.setFont (welcome.getFont().deriveFont (20.0f));
    try {
      ImageIcon titleImg = new ImageIcon(getClass().getResource("/assets/introductiontitle.png"));
      ImageIcon functionImg = new ImageIcon(getClass().getResource("/assets/integral.png"));
      functionImg = new ImageIcon(functionImg.getImage().getScaledInstance(100,50, java.awt.Image.SCALE_SMOOTH));
      titleImg = new ImageIcon(titleImg.getImage().getScaledInstance(220,51,java.awt.Image.SCALE_SMOOTH));
      function = new JLabel(functionImg);
      title = new JLabel(titleImg);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void actionPerformed(ActionEvent ae) {
  }
}