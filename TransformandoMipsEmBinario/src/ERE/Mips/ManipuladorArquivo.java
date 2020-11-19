package ERE.Mips;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ManipuladorArquivo {
    private File path;
    
    public ManipuladorArquivo(File path){
        this.path = path;
    }
    
    public HashMap leitor() throws IOException{

        BufferedReader ler = new BufferedReader(new FileReader(path)); 
        HashMap comandos = new HashMap(56);
        String linha = "";
        while(ler.ready()){
            linha.readLine();
            String[] splitLinha = linha.split(";");
            comandos.put(splitLinha[0],splitLinha[1]);
        }
        ler.close();
        return comandos;
    }
    
}