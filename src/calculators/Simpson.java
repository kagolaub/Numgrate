package src.calculators;
import src.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Simpson extends Calculator {
  public Simpson(JPanel pane) {
    super(pane,false);
  }

  public String calculate(ArrayList<Integer>values) {
    return "hi";
  }
  
  public void actionPerformed(ActionEvent ae) {
    System.out.println("hi");
  }
}