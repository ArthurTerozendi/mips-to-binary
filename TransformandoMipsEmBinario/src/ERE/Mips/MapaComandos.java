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

    /**
     * Método responsável por preencher o HashMap com os possíveis comando e registradores do mips
     * @return
     * @throws IOException
     */
    public HashMap carregarHashMap() throws IOException {
        FileReader ler = new FileReader(path);
        BufferedReader bLer = new BufferedReader(ler);

        HashMap comandos = new HashMap(73);

        String linha = "";
        //Vai ler linha por linha, até q não tenha mais nenhuma
        while(bLer.ready()){

            linha = bLer.readLine();
            //Separará a linha, tendo agora uma chave (splitLinha[0]) e o valor (splitLinha[1]) para essa chave
            String[] splitLinha = linha.split(";");
            comandos.put(splitLinha[0], splitLinha[1]);
        }
        bLer.close();
        ler.close();
        return comandos;
    }
}