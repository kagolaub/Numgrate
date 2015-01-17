package src.calculators;
import java.util.*; 

public class Equations
{
  public static double result (String eq, double a, double y) throws Exception
  {
    ArrayList s = format (eq, a, y); 
    
    //Functions
    for (int x = 0; x < s.size ()-1; x++)
    {
      Object c = s.get (x);
      if (c instanceof String)
      {
        String ss = (String)c;
        if (ss.equals ("sin"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.sin ((Double)s.remove (x))));
        }
        else if (ss.equals ("cos"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.cos ((Double)s.remove (x))));
        }
        else if (ss.equals ("tan"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.tan ((Double)s.remove (x))));
        }
        if (ss.equals ("sinh"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.sinh ((Double)s.remove (x))));
        }
        else if (ss.equals ("cosh"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.cosh ((Double)s.remove (x))));
        }
        else if (ss.equals ("tanh"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.tanh ((Double)s.remove (x))));
        }
        else if (ss.equals ("arcsin"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.asin ((Double)s.remove (x))));
        }
        else if (ss.equals ("arccos"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.acos ((Double)s.remove (x))));
        }
        else if (ss.equals ("arctan"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.atan ((Double)s.remove (x))));
        }
        else if (ss.equals ("ln"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.log ((Double)s.remove (x))));
        }
        else if (ss.equals ("log"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.log10 ((Double)s.remove (x))));
        }
        else if (ss.equals ("sqrt"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.sqrt ((Double)s.remove (x))));
        }
        else if (ss.equals ("abs"))
        {
          s.remove (x);  
          s.add (x, new Double (Math.abs ((Double)s.remove (x))));
        }
      }
    }
    
    //Exponent
    for (int x = 1; x < s.size () - 1; x++)
    {
      Object c = s.get (x);
      if (c instanceof String)
      {
        String ss = (String)c;
        if (ss.equals ("^"))
        {
          s.remove (x);  
          s.add (x-1, new Double (Math.pow ((Double)s.remove (x-1), (Double)s.remove (x-1))));
        }
      }
    }
    
    //Division/Multiplication
    for (int x = 0; x < s.size () - 1; x++)
    {
      Object c = s.get (x);
      if (c instanceof String)
      {
        String ss = (String)c;
        if (x > 0 && ss.equals ("/"))
        {
          s.remove (x);  
          s.add (x-1, new Double ((Double)s.remove (x-1)/(Double)s.remove (x-1)));
          x--;
        }
        else if (x > 0 && ss.equals ("*"))
        {
          s.remove (x);  
          s.add (x-1, new Double ((Double)s.remove (x-1)*(Double)s.remove (x-1)));
          x--;
        }
        else if (ss.equals ("-") && (x == 0 || (x != 0 && s.get (x-1) instanceof String)))
        {
          s.remove (x); 
          s.add (x, (Double)(s.remove (x))*-1.0);
        }
      }
    }
    //Addition/Subtraction
    for (int x = 1; x < s.size () - 1; x++)
    {
      Object c = s.get (x);
      if (c instanceof String)
      { 
        String ss = (String)c;
        if (ss.equals ("+"))
        {
          s.remove (x);  
          s.add (x-1, new Double ((Double)s.remove (x-1)+(Double)s.remove (x-1)));
          x--;
        }
        else if (ss.equals ("-"))
        {
          s.remove (x);  
          s.add (x-1, new Double ((Double)s.remove (x-1)-(Double)s.remove (x-1)));
          x--;
        }
      }
    }
    return (Double)s.get (0);
  }
  
  
  //Formatting
  private static ArrayList format (String eq, double x, double y)
  {
    //System.out.println ("NEW CALL: " + eq);
    try
    {
      for (int i = 0; i < eq.length (); i++)
      {
        char c = eq.charAt (i); 
        if (c == '.' || c == ' ')
          continue;
        if (c == 'x' || c == 'y' || c == 'e')
        {
          eq = eq.substring (0, i) + " " + c + " " + eq.substring (i+1);          
          i+= 2; 
          continue;
        }
        if (i != eq.length () - 1 && eq.substring (i, i+2).equals ("pi"))
        {
          eq = eq.substring (0, i) + " pi " + eq.substring (i+2);          
          i+= 3; 
          continue;
        }
        if (isLetter (c))
        {
          if (i != eq.length () - 1 && isNumber (eq.charAt (i+1)) || isSpecial (eq.charAt (i+1))) 
            eq = eq.substring (0, i + 1) + " " + eq.substring (i+1);
          if (i != 0)
            if (isNumber (eq.charAt (i-1)) || isSpecial (eq.charAt (i-1))) 
            eq = eq.substring (0, i) + " " + eq.substring (i);
        }
        else if (isSpecial (c))
        {
          if (i != eq.length () - 1 && eq.charAt (i+1) != ' ') 
            eq = eq.substring (0, i + 1) + " " + eq.substring (i+1);
          if (i != 0)
            if (eq.charAt (i-1) != ' ') 
            eq = eq.substring (0, i) + " " + eq.substring (i);
        }
      }
      ArrayList r = new ArrayList ();
      while (eq.length () > 0)
      {
        //System.out.println (r + "|||||" + eq);
        String s = "";
        eq = eq.trim ();
        if (eq.indexOf (" ") >= 0)
        {
          s = eq.substring (0, eq.indexOf (" "));
          eq = eq.substring (eq.indexOf (" ") + 1);
        }
        else
        {
          s = eq; 
          eq = "";
        }
        try
        {
          if (s.equals ("x"))
            s = "" + x;
          else if (s.equals ("y"))
            s = "" + y;
          Double d = getDouble (s);
          if (r.size () > 0 && r.get (r.size () - 1) instanceof Double)
            r.add (new String ("*")); 
          r.add (d);
        }
        catch (NumberFormatException e)
        {
          if (s.charAt (0) == '(')
          {
            int count = 1;
            int end;
            for (end = 1; count > 0; end++)
            {
              if (eq.charAt (end) == ')')
                count--;
              else if (eq.charAt (end) == '(')
                count++;
            }
            end--;
            if (r.size () > 0 && r.get (r.size () - 1) instanceof Double)
              r.add (new String ("*")); 
            r.add (new Double (result (eq.substring (0, end), x, y))); 
            eq = eq.substring (end + 1);
          }
          else
          {  
            if (r.size () > 0 && r.get (r.size () - 1) instanceof String)
            {
              String t = (String)r.get (r.size () - 1);
              if (isLetter (s.charAt (0)) == isLetter (t.charAt (0)))
                throw new Exception ("Two consecutive letters!");
            }
            if (r.size () == 0 && !isLetter (s.charAt (0)) && s.charAt (0) != '-')
              continue;
            r.add (s);
          }
        }
      }
      return r;
    }
    catch (Exception e)
    {
      System.out.println ("SOMETHING WENT WRONG!");
      return null;
    }
  }
  
  public static boolean check (String eq)
  {
    try
    {
      for (int i = 0; i < eq.length (); i++)
      {
        char c = eq.charAt (i); 
        if (c == '.' || c == ' ')
          continue;
        if (c == 'x' || c == 'y' || c == 'e')
        {
          eq = eq.substring (0, i) + " " + c + " " + eq.substring (i+1);          
          i+= 2; 
          continue;
        }
        if (i != eq.length () - 1 && eq.substring (i, i+2).equals ("pi"))
        {
          eq = eq.substring (0, i) + " pi " + eq.substring (i+2);          
          i+= 3; 
          continue;
        }
        if (isLetter (c))
        {
          if (i != eq.length () - 1 && isNumber (eq.charAt (i+1)) || isSpecial (eq.charAt (i+1))) 
            eq = eq.substring (0, i + 1) + " " + eq.substring (i+1);
          if (i != 0)
            if (isNumber (eq.charAt (i-1)) || isSpecial (eq.charAt (i-1))) 
            eq = eq.substring (0, i) + " " + eq.substring (i);
        }
        else if (isSpecial (c))
        {
          if (i != eq.length () - 1 && eq.charAt (i+1) != ' ') 
            eq = eq.substring (0, i + 1) + " " + eq.substring (i+1);
          if (i != 0)
            if (eq.charAt (i-1) != ' ') 
            eq = eq.substring (0, i) + " " + eq.substring (i);
        }
      }
      
      ArrayList r = new ArrayList ();
      while (eq.length () > 0)
      {
        String s = "";
        eq = eq.trim ();
        if (eq.indexOf (" ") >= 0)
        {
          s = eq.substring (0, eq.indexOf (" "));
          eq = eq.substring (eq.indexOf (" ") + 1);
        }
        else
        {
          s = eq; 
          eq = "";
        }
        try
        {
          if (s.equals ("x") || s.equals ("y"))
            s = "1.0";
          Double d = getDouble (s);
          if (r.size () > 0 && r.get (r.size () - 1) instanceof Double)
            r.add (new String ("*")); 
          r.add (d);
        }
        catch (NumberFormatException e)
        {
          if (s.charAt (0) == '(')
          {
            int count = 1;
            int end;
            for (end = 1; count > 0; end++)
            {
              if (eq.charAt (end) == ')')
                count--;
              else if (eq.charAt (end) == '(')
                count++;
            }
            end--;
            if (check (eq.substring (0, end)) == false)
              return false; 
            r.add (new Double (0.0));
            eq = eq.substring (end + 1);
          }
          else
          {  
            if (r.size () > 0 && r.get (r.size () - 1) instanceof String)
            {
              char c = s.charAt (0);
              char t = ((String)r.get (r.size () - 1)).charAt (0);
              if (isLetter (c) == isLetter (t))
                return false;
            }
            if (r.size () == 0 && !isLetter (s.charAt (0)) && s.charAt (0) != '-')
              continue;
            r.add (s);
          }
        }
      }
      if (!(r.get (r.size ()-1) instanceof Double))
        return false;
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace ();
      return false;
    }
  }
  
  private static boolean isLetter (char c)
  {
    if (c >= 97 && c <= 122)
      return true; 
    return false;
  }
  private static boolean isSpecial (char c)
  {
    if (isNumber (c) || isLetter (c) || c == ' ')
      return false; 
    return true;
  }
  private static boolean isNumber (char c)
  {
    if (c >= 48 && c <= 57)
      return true; 
    return false;
  }
  private static boolean isVariable (char c)
  {
    if (c == 'x' || c == 'y' || c == 'e' || c == 'p' || c == 'i')
      return true; 
    return false;
  }
  
  public static double getDouble (String s) throws Exception
  {
    if (s.equals ("e"))
      return Math.E;
    if (s.equals ("pi"))
      return Math.PI;
    return Double.parseDouble (s);
  }
  
//  
//  public static void main (String [] args) throws Exception
//  {
//    Scanner in = new Scanner (System.in);
//    System.out.print ("Enter an equation: ");
//    String eq = in.nextLine (); 
//    System.out.println (check (eq));
//    System.out.print ("Enter x and y");
//    double x = getDouble (in.next ());
//    double y = getDouble (in.next ());
//    System.out.println ("Answer: " + result (eq, x, y));
//  }
}