package ERE.Mips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Escrita {
    private File path;

    public Escrita(String path) {
        this.path =  new File(path);
    }

    public void escreverArquivo(ArrayList<String> bolha, String[] reordenamento) throws IOException {
        if (!path.exists()) {
            path.createNewFile();
        }

        FileWriter escrever = new FileWriter(path);
        BufferedWriter bEscrever = new BufferedWriter(escrever);

        bEscrever.write("----- Bolha -----");
        bEscrever.newLine();

        for (String instrucao: bolha) {
            bEscrever.write(instrucao);
            bEscrever.newLine();
        }

        bEscrever.write("----- Reordenamento -----");
        bEscrever.newLine();

        for (String instrucao : reordenamento) {
            bEscrever.write(instrucao);
            bEscrever.newLine();
        }

        bEscrever.close();
        escrever.close();
    }
}
