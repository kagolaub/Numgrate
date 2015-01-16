package src;
import javax.swing.*;
import java.awt.*;
import java.net.*;


public class NumgratePane extends JPanel { 
  JFrame frame = new JFrame("Numgrate");
  SpringLayout spring = new SpringLayout();
  double width;
  double height;
  
  public NumgratePane () {
    setBackground(Color.WHITE);
    setLayout(spring);
    
    URL iconURL = getClass().getResource("/assets/numgrateicon.png");
    ImageIcon windowIcon = new ImageIcon(iconURL);
    frame.setIconImage(windowIcon.getImage());
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    width = screenSize.getWidth();
    height = screenSize.getHeight();
    
    setSize((int)(width/2.35),(int)(height/1.97));
    frame.setSize((int)(width/2.35),(int)(height/1.97));
    frame.setLocationRelativeTo(null);
    frame.add(this);
    
    add(addTitle());
    StateManager sm = new StateManager(this, spring);
    frame.setVisible(true);
    frame.validate();
    frame.toFront();
  }
  
  private JLabel addTitle() {
    double widthTitleFactor = 43;
    double heightTitleFactor = 22.5;
    JLabel title = new JLabel();
    URL titleURL = getClass().getResource("/assets/umgrate.png");
    ImageIcon titleIcon = new ImageIcon(titleURL);
    titleIcon = new ImageIcon(titleIcon.getImage().getScaledInstance((int)(getWidth()/3.5),(int)(getHeight()/4.6),java.awt.Image.SCALE_SMOOTH));
    title.setIcon(titleIcon);
    spring.putConstraint(SpringLayout.WEST, title,(int)(getWidth()/widthTitleFactor), SpringLayout.WEST, this);
    spring.putConstraint(SpringLayout.NORTH, title,(int)(getHeight()/heightTitleFactor), SpringLayout.NORTH, this);
    return title;
  }
  
  public static void main (String[]args) {
    NumgratePane n = new NumgratePane();
  }
}