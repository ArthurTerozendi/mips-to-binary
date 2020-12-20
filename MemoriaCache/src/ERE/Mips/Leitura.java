package ERE.Mips;

import java.io.*;
import java.util.ArrayList;

public class Leitura {

    private File path;

    public Leitura(String path) {
        this.path = new File(path);
    }

    public ArrayList<String> lerArquivo() throws IOException {
        ArrayList<String> entrada = new ArrayList<>();

        BufferedReader ler = new BufferedReader(new FileReader(path));

        while(ler.ready()) {
            entrada.add(ler.readLine());
        }

        ler.close();
        return entrada;
    }
}
