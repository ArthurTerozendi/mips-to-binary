package ERE.Mips;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapaComandos{

    private File path;
    public MapaComandos(){
        this.path = new File("comandos.txt");
    }

    public HashMap carregarHashMap() throws IOException {
        FileReader ler = new FileReader(path);
        BufferedReader bLer = new BufferedReader(ler);

        HashMap comandos = new HashMap(73);

        String linha = "";
        while(bLer.ready()){
            linha = bLer.readLine();
            //System.out.println(linha);
            String[] splitLinha = linha.split(";");
            comandos.put(splitLinha[0], splitLinha[1]);
        }
        bLer.close();
        ler.close();
        return comandos;
    }
}