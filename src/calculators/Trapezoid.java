package src.calculators;
import src.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Trapezoid extends Calculator {
  public Trapezoid(JPanel pane) {
    super(pane,false);
  }
  public String calculate(ArrayList<Integer> values) {
    return "hi";
  }
  public void init() {
  }
  public void actionPerformed(ActionEvent ae) {
    System.out.println("hi");
  }
}