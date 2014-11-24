
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
        from = newFrom;
        to = newTo;
        message = newMessage;
    }

    /**
     * Primer metodo getter
     */
    public String getFrom()
    {
        // put your code here
        return from;
    }
      
    /**
    * Primer metodo getter
    */
    public String getTo()
    {
        // put your code here
        return to;
    }  
    
    /**
    * Primer metodo getter
    */
    public String getMessage()
    {
        // put your code here
        return message;
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
