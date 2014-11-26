
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
    public MailClient(MailServer server, String user)
    {
        // initialise instance variables
        this.server = server;
        this.user = user;
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
    public void printNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if (email == null) {
            System.out.println("No hay mensajes.");
        }
        else {
            email.print();
            
        }
    }
   
   /**
     *Metodo sendMailItem envia mensaje.
     */
    public void sendMailItem(String to, String subject, String message){
        MailItem emailToSend = new MailItem(user, to, subject, message);
        server.post(emailToSend);
    }
    
    /**
     * Metodo para saber cuantos correos tenemos para nosotros
     */
    public int howManyMailItems()
    {
        return server.howManyMailItems(user);
    }
    
     /**
     * Metodo para contestar automaticamente al emisor del mensaje.
     */
    public void getNextMailItemAndAutorespond()
    {
        MailItem email = server.getNextMailItem(user);
        String subject = "RE " + email.getSubject();
        String nuevalinea = System.getProperty("line.separator");
        String message = "Estoy de vacaciones" + nuevalinea + nuevalinea + email.getMessage();
        String from = email.getFrom();
        sendMailItem(from,subject, message);
    }
}

        
