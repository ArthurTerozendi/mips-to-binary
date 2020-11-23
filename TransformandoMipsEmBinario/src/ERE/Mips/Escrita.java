package ERE.Mips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Escrita {
    File path;
    public Escrita(String path) throws IOException {
        this.path = new File(path);

        if (!this.path.exists()) {
            this.path.createNewFile();
        }
    }

    public void escrever(ArrayList<String> saidas) throws IOException {
        FileWriter escrever = new FileWriter(path);
        BufferedWriter bEscrever = new BufferedWriter(escrever);

        for ( String saida:saidas ) {
            bEscrever.write(saida);
            bEscrever.newLine();
        }

        bEscrever.close();
        escrever.close();
    }
}
