package src.menus;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import src.*;
public class MainMenu extends Menu{
  JPanel pane;
  StateManager sm;
  JLabel gif = null;
  
  public MainMenu(StateManager sm) {
    super(sm.pane);
    this.sm = sm;
    pane = sm.pane;
  }
  
  public void init() {
    try {
    URL introURL = getClass().getResource("/assets/introduction.png");
    URL introRollURL = getClass().getResource("/assets/introductionroll.png");
    URL newtonURL = getClass().getResource("/assets/newtoncotes.png");
    URL newtonRollURL = getClass().getResource("/assets/newtoncotesroll.png");
    URL gaussianURL = getClass().getResource("/assets/gaussian.png");
    URL gaussianRollURL = getClass().getResource("/assets/gaussianroll.png");
    URL clenshawURL = getClass().getResource("/assets/clenshaw.png");
    URL clenshawRollURL = getClass().getResource("/assets/clenshawroll.png");
    
    ImageIcon introIcon = new ImageIcon(introURL);
    ImageIcon introRollIcon = new ImageIcon(introRollURL);
    ImageIcon newtonIcon = new ImageIcon(newtonURL);
    ImageIcon newtonRollIcon = new ImageIcon(newtonRollURL);
    ImageIcon gaussianIcon = new ImageIcon(gaussianURL);
    ImageIcon gaussianRollIcon = new ImageIcon(gaussianRollURL);
    ImageIcon clenshawIcon = new ImageIcon(clenshawURL);
    ImageIcon clenshawRollIcon = new ImageIcon(clenshawRollURL);

    setButton(introIcon,introRollIcon,"Introduction",this,1);
    setButton(newtonIcon,newtonRollIcon,"Newton",this,2);
    setButton(gaussianIcon,gaussianRollIcon,"Gaussian",this,3);
    setButton(clenshawIcon,clenshawRollIcon,"Clenshaw",this,4);
    
    
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private JLabel addGif() {
    JLabel gif = new JLabel();
    URL gifURL = getClass().getResource("/assets/gif.gif");
    ImageIcon gifIcon = new ImageIcon(gifURL);
    gifIcon = new ImageIcon(gifIcon.getImage().getScaledInstance((int)(sm.pane.getWidth()/1.7),(int)(sm.pane.getWidth()/1.7),java.awt.Image.SCALE_FAST));
    gif.setIcon(gifIcon);
    
    sm.layout.putConstraint(SpringLayout.EAST, gif, 0, SpringLayout.EAST, sm.pane);
    sm.layout.putConstraint(SpringLayout.NORTH, gif, 0, SpringLayout.NORTH, sm.pane);
    return gif;
  }
  
  public void showUI() {
    super.showUI();
    gif = addGif();
    sm.pane.add(gif);
  }
  
  public void removeUI() {
    super.removeUI();
    if (gif != null)
    sm.pane.remove(gif);
  }
  public void actionPerformed(ActionEvent ae) {
    if (ae.getActionCommand().equals("Intro")) {
      
    }
    else if (ae.getActionCommand().equals("Newton")) {
      sm.setState(sm.NEWTONSTATE);
    }
  }
}