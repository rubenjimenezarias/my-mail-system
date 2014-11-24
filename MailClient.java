
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // instance variables - replace the example below with your own
    private MailServer server;
    private String user;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer newServer, String newUser)
    {
        // initialise instance variables
        server = newServer;
        user = newUser;
    }

    /**
     *Metodo getNextMailItem devuelve el mensaje del correo.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     *Metodo que imprime el mensaje del correo
     */
    public void printItem()
    {
        MailItem item = server.getNextMailItem(user);
        if (item == null) {
            System.out.println("No hay mensajes.");
        }
        else {
            item.print();
        }
    }
   
   /**
     *Metodo sendMailItem envia mensaje.
     */
    public void sendMailItem(String newTo, String newMessage){
        MailItem item = new MailItem(user, newTo, newMessage);
        server.post(item);
    }
}

        
