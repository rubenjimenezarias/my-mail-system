
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
    private int countSend;
    private int countSpam;
    private int countRecive;

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
        MailItem email = server.getNextMailItem(user);
        String message = email.getMessage();
        String spam1 = "viagra";
        String spam2 = "oferta";
        Boolean found1;
        Boolean found2;
        found1 = message.contains(spam1);
        found2 = message.contains(spam2);
        if (found1 == true || found2 == true)
        {
            email = null;
        }
        else
        {
            lastEmail = email.getMessage();
        }
        return email;
    }
    
    /**
     *Metodo que imprime el mensaje del correo
     */
    public void printNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        String message = email.getMessage();
        String spam1 = "viagra";
        String spam2 = "oferta";
        String spam3 = "proyecto";
        Boolean found1;
        Boolean found2;
        Boolean found3;
        found1 = message.contains(spam1);
        found2 = message.contains(spam2);
        found3 = message.contains(spam3);
        if (email == null) {
            System.out.println("No hay mensajes.");
        }
        else if (found3 == true){
            email.print();
            lastEmail = email.getMessage();
            int countRecive = +1;
        }
        else if (found1 == true || found2 == true){
            System.out.println("Tu mensaje contenia un spam");
            int countRecive = +1;
            int countSpam = +1;
        }
        else {
            email.print();
            lastEmail = email.getMessage();
            int countRecive = +1;
        }
    }
   
   /**
     *Metodo sendMailItem envia mensaje.
     */
    public void sendMailItem(String to, String subject, String message){
        MailItem emailToSend = new MailItem(user, to, subject, message);
        server.post(emailToSend);
        int countSend = +1;
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
    /**
     * Metodo para ver estadisticas
     */
    public void sawStadistics()
    {
        System.out.println("Emails recividos: " + countRecive);
        System.out.println("Emails enviados: " + countSend);
        long spamPor = countRecive / countSpam * 100;
        System.out.println("Emails recividos con spam: " + countRecive + "%");
    }
}

        
