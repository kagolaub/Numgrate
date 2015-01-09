package src;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class MainMenu implements ActionListener, View {
  JPanel pane;
  JLabel title = new JLabel();
  JLabel gif = new JLabel();
  JButton intro = new JButton();
  JButton newtoncotes = new JButton();
  JButton gaussian = new JButton();
  JButton clenshaw = new JButton();
  JButton exit = new JButton();
  
  public MainMenu(JPanel pane) {
    this.pane = pane;
  }
  
  public void showUI() {
    double buttonWidthFactor = 2.75;
    double titleWidthFactor = 3.5;
    double buttonHeightFactor = 7.75;
    double titleHeightFactor = 4.6;
    
    URL titleURL = getClass().getResource("/assets/umgrate.png");
    URL introURL = getClass().getResource("/assets/introduction.png");
    URL introRollURL = getClass().getResource("/assets/introductionroll.png");
    URL newtonURL = getClass().getResource("/assets/newtoncotes.png");
    URL newtonRollURL = getClass().getResource("/assets/newtoncotesroll.png");
    URL gaussianURL = getClass().getResource("/assets/gaussian.png");
    URL gaussianRollURL = getClass().getResource("/assets/gaussianroll.png");
    URL clenshawURL = getClass().getResource("/assets/clenshaw.png");
    URL clenshawRollURL = getClass().getResource("/assets/clenshawroll.png");
    URL gifURL = getClass().getResource("/assets/gif.gif");
    
    ImageIcon gifIcon = new ImageIcon(gifURL);
    ImageIcon titleIcon = new ImageIcon(new ImageIcon(titleURL).getImage().getScaledInstance((int)(pane.getWidth()/3.5),(int)(pane.getHeight()/4.6),java.awt.Image.SCALE_SMOOTH));
    ImageIcon introIcon = new ImageIcon(introURL);
    ImageIcon introRollIcon = new ImageIcon(introRollURL);
    ImageIcon newtonIcon = new ImageIcon(newtonURL);
    ImageIcon newtonRollIcon = new ImageIcon(newtonRollURL);
    ImageIcon gaussianIcon = new ImageIcon(gaussianURL);
    ImageIcon gaussianRollIcon = new ImageIcon(gaussianRollURL);
    ImageIcon clenshawIcon = new ImageIcon(clenshawURL);
    ImageIcon clenshawRollIcon = new ImageIcon(clenshawRollURL);
   
    introIcon = new ImageIcon(introIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    introRollIcon = new ImageIcon(introRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor-1),java.awt.Image.SCALE_SMOOTH));
    newtonIcon = new ImageIcon(newtonIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    newtonRollIcon = new ImageIcon(newtonRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    gaussianIcon = new ImageIcon(gaussianIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    gaussianRollIcon = new ImageIcon(gaussianRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    clenshawIcon = new ImageIcon(clenshawIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    clenshawRollIcon = new ImageIcon(clenshawRollIcon.getImage().getScaledInstance((int)(pane.getWidth()/buttonWidthFactor),(int)(pane.getHeight()/buttonHeightFactor),java.awt.Image.SCALE_SMOOTH));
    gifIcon = new ImageIcon(gifIcon.getImage().getScaledInstance((int)(pane.getWidth()/1.7),(int)(pane.getWidth()/1.7),java.awt.Image.SCALE_FAST));

    gif.setIcon(gifIcon);
    title.setIcon(titleIcon);
    styleButton(intro,introIcon,introRollIcon);
    styleButton(newtoncotes,newtonIcon,newtonRollIcon);
    styleButton(gaussian,gaussianIcon,gaussianRollIcon);
    styleButton(clenshaw,clenshawIcon,clenshawRollIcon);
    
    constraints();
    pane.add(gif);
    pane.add(title);
    pane.add(intro);
    pane.add(newtoncotes);
    pane.add(gaussian);
    pane.add(clenshaw);
  }
  
  private void styleButton(JButton button, ImageIcon icon, ImageIcon rollIcon) {
    button.setIcon(icon);
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setFocusPainted(false);
    button.setRolloverIcon(rollIcon);
  }
  
  private void constraints() {
    double widthTitleFactor = 43;
    double heightTitleFactor = 22.5;
    double widthButtonFactor = 45.6;
    double heightIntroFactor = 40;
    
    SpringLayout layout = (SpringLayout)pane.getLayout();
    System.out.println(pane.getWidth()+ " " + pane.getHeight());
    
    layout.putConstraint(SpringLayout.WEST, title,(int)(pane.getWidth()/widthTitleFactor), SpringLayout.WEST, pane);
    layout.putConstraint(SpringLayout.NORTH, title,(int)(pane.getHeight()/heightTitleFactor), SpringLayout.NORTH, pane);
    
    layout.putConstraint(SpringLayout.WEST, intro, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, intro, (int)(pane.getHeight()/heightIntroFactor), SpringLayout.SOUTH, title);
    
    layout.putConstraint(SpringLayout.WEST, newtoncotes, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, newtoncotes, 2, SpringLayout.SOUTH, intro);
    
    layout.putConstraint(SpringLayout.WEST, gaussian, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, gaussian, 2, SpringLayout.SOUTH, newtoncotes);
    
    layout.putConstraint(SpringLayout.WEST, clenshaw, -1*(int)(pane.getWidth()/widthButtonFactor), SpringLayout.WEST,pane);
    layout.putConstraint(SpringLayout.NORTH, clenshaw, 2, SpringLayout.SOUTH, gaussian);
    
    layout.putConstraint(SpringLayout.EAST, gif, 0, SpringLayout.EAST, pane);
    layout.putConstraint(SpringLayout.NORTH, gif, 0, SpringLayout.NORTH, pane);
  }
  
  public void actionPerformed(ActionEvent ae) {
  }
}