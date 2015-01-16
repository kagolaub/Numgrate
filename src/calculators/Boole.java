package src.calculators;
import src.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Boole extends Calculator {
  int intervals;
  String formula;
  ArrayList<Integer> values = new ArrayList<Integer>();
  public Boole(JPanel pane) {
    super(pane,true);
    setInterval(5);
  }
  public void constraints() {
    super.constraints();
  }
  public void showUI() {
    super.showUI();
  }
  public void removeUI() {
    super.removeUI();
  }
  public String calculate(ArrayList<Integer>values) {
    double value = (2/45)*((outer-inner)/interval)*(7*values.get(0) + 32*values.get(1) + 12*values.get(2) + 32*values.get(3) + 7*values.get(4));
    System.out.println(values.get(0));
  return "" + value;
  }
}