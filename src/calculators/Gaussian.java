package src.calculators;
import javax.swing.*;
import java.net.*;
public class Gaussian extends Calculator{
  double tolerance = 0.000001;
  JLabel gaussLabel;
  JLabel weightLabel;
  JLabel weightLabel2;
  JLabel weightLabel3;
  JLabel weightLabel4;
  JLabel gaussForm;
  JLabel weightForm;
  JLabel legendre;
  JLabel where;
  JLabel where2;
  JLabel title;
  public Gaussian(JPanel pane) {
    super(pane,true);
  }
  
  public void init() {
    super.init();
    gaussLabel = new JLabel("The integral is approximated to the Riemann sum: ");
    weightLabel= new JLabel("<html>w<sub>i</sub></html>");
    weightLabel2 = new JLabel(" is defined as:");
    where = new JLabel("where ");
    where2 = new JLabel("where ");
    weightLabel3= new JLabel("<html>x<sub>i</sub> is the i<sup>th</sup></html>");
    weightLabel4 = new JLabel(" root of the Legendre Polynomial, P(n):");
    try {
      ImageIcon gauss = new ImageIcon(getClass().getResource("/assets/gaussform.png"));
      ImageIcon weight = new ImageIcon(getClass().getResource("/assets/weightformulagauss.png"));
      ImageIcon legendreImg = new ImageIcon(getClass().getResource("/assets/p(n).png"));
      ImageIcon titleImg = new ImageIcon(getClass().getResource("/assets/gaussiantitle.png"));
      gauss = new ImageIcon(gauss.getImage().getScaledInstance(200,50,java.awt.Image.SCALE_SMOOTH));
      weight = new ImageIcon(weight.getImage().getScaledInstance(160,45,java.awt.Image.SCALE_SMOOTH));
      legendreImg = new ImageIcon(legendreImg.getImage().getScaledInstance(275,60,java.awt.Image.SCALE_SMOOTH));
      titleImg = new ImageIcon(titleImg.getImage().getScaledInstance(300,43,java.awt.Image.SCALE_SMOOTH));
      gaussForm = new JLabel(gauss);
      weightForm = new JLabel(weight);
      legendre = new JLabel(legendreImg);
      title = new JLabel(titleImg);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void showUI() {
    super.showUI();
    pane.add(gaussLabel);
    pane.add(weightLabel);
    pane.add(weightLabel2);
    pane.add(weightLabel3);
    pane.add(weightLabel4);
    pane.add(gaussForm);
    pane.add(weightForm);
    pane.add(legendre);
    pane.add(where);
    pane.add(where2);
    pane.add(title);
  }
  
  public void removeUI() {
    super.removeUI();
    pane.remove(gaussLabel);
    pane.remove(weightLabel);
    pane.remove(weightLabel2);
    pane.remove(weightLabel3);
    pane.remove(weightLabel4);
    pane.remove(gaussForm);
    pane.remove(weightForm);
    pane.remove(legendre);
    pane.remove(where);
    pane.remove(where2);
    pane.remove(title);
  }
  
  public void constraints() {
    super.constraints();
    layout.putConstraint(SpringLayout.NORTH, title, 30,  SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST,  title, -96,SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, gaussLabel, 88,  SpringLayout.NORTH, pane);
    layout.putConstraint(SpringLayout.EAST, gaussLabel, -100,  SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, weightLabel, 67, SpringLayout.SOUTH, gaussLabel);
    layout.putConstraint(SpringLayout.EAST, weightLabel, -340, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, where, 67, SpringLayout.SOUTH, gaussLabel);
    layout.putConstraint(SpringLayout.EAST, where, 0, SpringLayout.WEST, weightLabel);
    
    layout.putConstraint(SpringLayout.NORTH, gaussForm, 5, SpringLayout.SOUTH, gaussLabel);
    layout.putConstraint(SpringLayout.EAST, gaussForm, -145, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, weightLabel2, 67, SpringLayout.SOUTH, gaussLabel);
    layout.putConstraint(SpringLayout.WEST, weightLabel2, 0, SpringLayout.EAST, weightLabel);
    
    layout.putConstraint(SpringLayout.NORTH, weightForm, 54, SpringLayout.SOUTH, gaussLabel);
    layout.putConstraint(SpringLayout.EAST, weightForm, -90, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, weightLabel3, 0, SpringLayout.SOUTH, weightForm);
    layout.putConstraint(SpringLayout.EAST, weightLabel3, -300, SpringLayout.EAST, pane);
    
    layout.putConstraint(SpringLayout.NORTH, where2, 5, SpringLayout.SOUTH, weightForm);
    layout.putConstraint(SpringLayout.EAST, where2, 0, SpringLayout.WEST, weightLabel3);
    
    layout.putConstraint(SpringLayout.NORTH, weightLabel4, 5, SpringLayout.SOUTH, weightForm);
    layout.putConstraint(SpringLayout.WEST, weightLabel4, 0, SpringLayout.EAST, weightLabel3);
    
    layout.putConstraint(SpringLayout.NORTH, legendre, 0, SpringLayout.SOUTH, weightLabel3);
    layout.putConstraint(SpringLayout.EAST, legendre, -108, SpringLayout.EAST, pane);
  }
  
  public String calculate() {
    double dx = outer - inner;
    double value = 1.0e+10;
    double oldValue;
    int numPoints = 10;
    int maxPoints = 100000;
    double x[] = new double[maxPoints];
    double w[] = new double[maxPoints];
    
    //Compute the integral value adding points until the solution converges or maxPoints is reached.
    while(true) {
      //Calculate the Gauss-Legouterre weights and abscissas.
      computeGaussWeights(x, w, numPoints);
      //Compute the integral value by summing up the weights times the function value at each abscissa.
      oldValue = value;
      value = 0.0;
      try {
        for(int i=0; i<numPoints; ++i) {
          value += w[i]* Equations.result(polynomial.getText(), inner + x[i]*dx, 0);
        } 
        value *= dx;
        //If the solution is converged, return the value. Otherwise, double the points in the integration domain and try again.
        if ( Math.abs(value-oldValue) <= tolerance*Math.abs(oldValue) ) {
          return "" + value;
        }
        numPoints *= 2;
        if (numPoints >= maxPoints) 
          break;
      }
      catch(Exception e) {
        e.printStackTrace();
      }
    } 
    //Solution did not converge
    return "" +12345.6;
  }
  
  public static void computeGaussWeights(double x[], double w[], int numPoints) {
    int i,j,m;
    double z, zOld, root, p3, p2, p1;
    double EPS = 1.0e-10;
    
    //The weights and abscissa values are normalized for an integration range between 0 and 1. The values
    //are symmetric about x=0.5 so you only have to compute half of them.
    
    m=(numPoints+1)/2;
    
    //Compute the Legouterre polynomial, p1, at point z using Newton's method.
    
    for(i=0; i<m; ++i) {
      z = Math.cos(Math.PI*(i+0.75)/(numPoints+0.5));
      do {
        p1 = 1.0;
        p2 = 0.0;
        for(j=0; j<numPoints; ++j) {
          p3 = p2;
          p2 = p1;
          p1 = ((2.0*(j+1) - 1.0)*z*p2 - j*p3)/(j+1.0);
        }
        root = numPoints*(z*p1 - p2)/(z*z - 1.0);
        zOld = z;
        z = zOld - p1/root;
      } while ( Math.abs(z-zOld) > EPS);
      
      //  Compute the weights and abscissas. The values are symmetric about the point z=0.5
      x[i] = 0.5*(1.0 - z);
      x[numPoints-1-i] = 0.5*(1.0 + z);
      w[i] = 1.0/((1.0- z*z)*root*root);
      w[numPoints-1-i] = w[i];
    }
  }
}