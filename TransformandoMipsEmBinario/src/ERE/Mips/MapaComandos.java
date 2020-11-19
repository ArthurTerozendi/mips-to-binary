package ERE.Mips;
import java.io.File;
import java.util.HashMap;

public class MapaComandos{
    
    private HashMap comandos; 
    private File path = new File("comandos.txt");
    public MapaComandos(HashMap comandos){
        comandos = new HashMap(56);
    }

    public HashMap carregar(File path){
        ManipuladorArquivo arquivo = new ManipuladorArquivo(path);
        
        return arquivo.leitor();
    }
}