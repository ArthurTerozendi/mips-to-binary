package ERE.Mips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {
    private File path;

    public Leitura (String path) {
        this.path = new File(path);
    }

    /**
     * Vai ler um arquivo com as intruções e salvar linha por linha em uma ArrayList
     * @return
     * @throws IOException
     */
    public ArrayList<String> lerArquivo () throws IOException {

        ArrayList<String> instrucoes = new ArrayList<>();
        FileReader ler = new FileReader(path);
        BufferedReader bLer = new BufferedReader(ler);

        while (bLer.ready()) {
            instrucoes.add(bLer.readLine());
        }

        bLer.close();
        ler.close();
        return instrucoes;
    }
}
