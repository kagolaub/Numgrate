package src.menus;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import src.calculators.*;
import src.*;
public class MainMenu extends Menu{
  JPanel pane;
  StateManager sm;
  JLabel gif = new JLabel();
  View curr;
  View gaussian;
  View introduction;
  
  public MainMenu(StateManager sm) {
    super(sm.pane);
    this.sm = sm;
    pane = sm.pane;
    gaussian = new Gaussian(sm.pane);
    introduction = new Introduction(sm.pane);
  }
  
  public void init() {
    try {
      URL introURL = getClass().getResource("/assets/introduction.png");
      URL introRollURL = getClass().getResource("/assets/introductionroll.png");
      URL newtonURL = getClass().getResource("/assets/newtoncotes.png");
      URL newtonRollURL = getClass().getResource("/assets/newtoncotesroll.png");
      URL gaussianURL = getClass().getResource("/assets/gaussian.png");
      URL gaussianRollURL = getClass().getResource("/assets/gaussianroll.png");
      URL exitURL = getClass().getResource("/assets/exit.png");
      URL exitRollURL = getClass().getResource("/assets/exitroll.png");
      
      ImageIcon introIcon = new ImageIcon(introURL);
      ImageIcon introRollIcon = new ImageIcon(introRollURL);
      ImageIcon newtonIcon = new ImageIcon(newtonURL);
      ImageIcon newtonRollIcon = new ImageIcon(newtonRollURL);
      ImageIcon gaussianIcon = new ImageIcon(gaussianURL);
      ImageIcon gaussianRollIcon = new ImageIcon(gaussianRollURL);
      ImageIcon exitIcon = new ImageIcon(exitURL);
      ImageIcon exitRollIcon = new ImageIcon(exitRollURL);
      
      setButton(introIcon,introRollIcon,"Introduction",this,1);
      setButton(newtonIcon,newtonRollIcon,"Newton",this,2);
      setButton(gaussianIcon,gaussianRollIcon,"Gaussian",this,3);
      setButton(exitIcon,exitRollIcon,"Clenshaw",this,4);
      
      gaussian.init();
      introduction.init();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void showUI() {
    super.showUI();
    gif = addGif();
    sm.pane.add(gif);
  }
  
  public void removeUI() {
    super.removeUI();
    if (SwingUtilities.getAncestorOfClass(Container.class,gif)!=null)
        sm.pane.remove(gif);
  }
  
  public void actionPerformed(ActionEvent ae) {
    pane.setSize(817,548);
    if (SwingUtilities.getAncestorOfClass(Container.class,gif)!=null)
        sm.pane.remove(gif);
    if (ae.getActionCommand().equals("Introduction")) {
      if (curr!= null)
        curr.removeUI();
      curr = introduction;
      curr.showUI();
      curr.constraints();
      sm.pane.repaint();
      sm.pane.validate();
    }
    else if (ae.getActionCommand().equals("Newton")) {
      if (curr!= null)
        curr.removeUI();
      sm.setState(sm.NEWTONSTATE);
    }
    else if (ae.getActionCommand().equals("Gaussian")) {
      if (curr!= null)
        curr.removeUI();
      
      curr = gaussian;
      curr.showUI();
      curr.constraints();
      sm.pane.repaint();
      sm.pane.validate();
    }
    else
      System.exit(0);
  }
}