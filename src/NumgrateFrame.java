package src;
import javax.swing.*;
import java.awt.*;
import java.net.*;


public class NumgrateFrame extends JPanel { 
  JFrame frame = new JFrame("Numgrate");
  SpringLayout spring = new SpringLayout();
  public NumgrateFrame () {
    setBackground(Color.WHITE);
    setLayout(spring);
    
    URL iconURL = getClass().getResource("/assets/numgrateicon.png");
    ImageIcon windowIcon = new ImageIcon(iconURL);
    frame.setIconImage(windowIcon.getImage());
    
    MainMenu m = new MainMenu(this);
    changeState(m);
    frame.setVisible(true);
    frame.setSize(900,570);
    frame.setLocationRelativeTo(null);
    frame.add(this);
  }
  
  public void changeState(View v) {
    removeAll();
    v.showUI();
    validate();
    repaint();
  }
  
  public static void main (String[]args) {
    NumgrateFrame n = new NumgrateFrame();
  }
}