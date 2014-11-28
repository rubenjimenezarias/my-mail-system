
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
    private String lastEmail;

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
            lastEmail = email.getMessage();
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
    public void howManyMailItems()
    {
        System.out.println("Tienes " + server.howManyMailItems(user) + " correos pendientes.");
    }
    
     /**
     * Metodo para contestar automaticamente al emisor del mensaje.
     */
    public void getNextMailItemAndAutorespond()
    {
        MailItem email = server.getNextMailItem(user);
        if (email != null)
        {
            String subject = "RE " + email.getSubject();
            // OTRA FORMA DE PONER SALTOS DE LINEA String nuevalinea = System.getProperty("line.separator");
            String message = "Estoy de vacaciones.\n" + email.getMessage();
            String from = email.getFrom();
            sendMailItem(from,subject, message);
        }
    }
    
     /**
     * Metodo para ver el ulitmo metodo recivido.
     */
    public void printLastEmail()
    {
        if (lastEmail != null)
        {
            System.out.println("El ultimo mensaje recivido es:" + lastEmail);
        }
        else
        {
             System.out.println("No tienes ningun mensaje");
        }
    }
}

        
