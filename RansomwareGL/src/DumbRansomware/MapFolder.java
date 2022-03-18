import java.io.File;
public class MapFolder implements IMapper {
    ArrayList<Files> listFiles;
    String dir;
    public MapFolder(String dir){
        this.dir=dir;
    }

    public void changeName() {
        //TODO        
    }
    
    public void cipher() {
        // TODO Auto-generated method stub
        // appel a cipher de chaque file dans les les folders ?
        
    }
    
    public String getInfos() {
        File f= new File(dir);
        // on extrait toutes les infos qu'on peut
        String name=f.getName();
        String path=f.getPath();
        String absoluteFile=f.getAbsolutePath();
        String parent=f.getParent();
        if (f.exists()){
            Boolean isWritable=f.canWrite();
            Boolean isReadable=f.canRead();
            Boolean isDirectory=f.isDirectory();
            int size=f.length();
        }
    }

    public List<Files> getFilesFolder(String dir){

    }
    public String getDir(){
        return dir;
    }
}
