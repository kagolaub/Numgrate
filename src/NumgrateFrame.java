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
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
double width = screenSize.getWidth();
double height = screenSize.getHeight();

    setSize((int)(width/2.35),(int)(height/1.97));
    frame.setSize((int)(width/2.35),(int)(height/1.97));
    frame.setLocationRelativeTo(null);
    frame.add(this);
    MainMenu m = new MainMenu(this);
    changeState(m);
    frame.setVisible(true);
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