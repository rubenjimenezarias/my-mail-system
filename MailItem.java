
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // instance variables - replace the example below with your own
    private String from, to, message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String newFrom, String newTo, String newMessage)
    {
        // initialise instance variables
        String from = newFrom;
        String to = newTo;
        String message = newMessage;
    }

    /**
     * Primer metodo getter
     */
    public void get1()
    {
        // put your code here
        
    }
      
    /**
    * Primer metodo getter
    */
    public void get2()
    {
        // put your code here
        
    }  
    
    /**
    * Primer metodo getter
    */
    public void get3()
    {
        // put your code here
        
    }
    /**
    * Metodo print que devuelve los valores de from to y message
    */
    public void print()
    {
         System.out.println("De: " + from);
         System.out.println("A: " + to);
         System.out.println("Este es el mensaje: " + message);
    }
    
}