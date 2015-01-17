package src;
import java.util.*;
import javax.swing.*;
import src.menus.*;
public class StateManager {
  public ArrayList <View> views;
  public final int MAINSTATE = 0;
  public final int NEWTONSTATE = 1;
  public int currentState = 0;
  public SpringLayout layout;
  public JPanel pane;
  private NumgratePane g;
  
  public StateManager(NumgratePane g, SpringLayout s) { 
    this.g = g;
    views = new ArrayList<View>();
    this.pane = g;
    this.layout = s;
    views.add(new MainMenu(this));
    views.add(new NewtonCotes(this));
    init();
    setState(MAINSTATE);
  }
  
  public void init() {
    for (View v : views)
      v.init();
  }
  
  public void setState(int state) {
    views.get(currentState).removeUI();
    currentState = state;
    pane.setSize(817,548);
    views.get(currentState).showUI();
    views.get(currentState).constraints();
    pane.repaint();
    pane.validate();
  }
}