package src.calculators;
import src.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Simpson extends Calculator {
  final double constant = 1.0/3.0;
  JLabel title = new JLabel("Simpson Rule");
  JLabel sentence = new JLabel("The intergral is approximated using the following formula:");
  JLabel formula = new JLabel();
  JLabel sentence2 = new JLabel("where N is the number of intervals.");
  
  public void init() {
    super.init();
    try {
      ImageIcon titleImg = new ImageIcon(getClass().getResource("/assets/simpsontitle.png"));
      ImageIcon formImg = new ImageIcon(getClass().getResource("/assets/simpsonform.png"));
      formImg = new ImageIcon(formImg.getImage().getScaledInstance(340,40,java.awt.Image.SCALE_SMOOTH));
      titleImg = new ImageIcon(titleImg.getImage().getScaledInstance(220,57,java.awt.Image.SCALE_SMOOTH));
      title = new JLabel(titleImg);
      formula = new JLabel(formImg);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void showUI() {
    super.showUI();
    pane.add(title);
    pane.add(sentence);
    pane.add(formula);
    pane.add(sentence2);
  }
  
  public void removeUI() {
    super.removeUI();
    pane.remove(title);
    pane.remove(sentence);
    pane.remove(formula);
    pane.remove(sentence2);
  }
  public void constraints() {
    super.constraints();
    layout.putConstraint(SpringLayout.NORTH, title, 50, SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST, title, -133, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, sentence, 110, SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST, sentence, -80, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, formula, 10, SpringLayout.SOUTH, sentence);
    layout.putConstraint(SpringLayout.EAST, formula, -74, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, sentence2, 10, SpringLayout.SOUTH, formula);
    layout.putConstraint(SpringLayout.EAST, sentence2, -142, SpringLayout.EAST, pane);
  }
  public Simpson(JPanel pane) {
    super(pane,false);
  }

  public String calculate() {
    if (interval%2 != 0)
      return "Please enter an even number of intervals.";
    double value = 0;
    for (int x = 0; x < values.size(); x++){
      if (x == 0 || x == values.size()-1)
      value += values.get(x);
      else if (x%2 == 0)
        value+=2*values.get(x);
      else
        value+=4*values.get(x);
    }
    return "" + constant*value*(outer-inner)/interval;
  }
}