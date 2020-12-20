package ERE.Mips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Escrita {
    public void escreverArquivo(ArrayList<String> saidas) throws IOException {
        File path = new File("saida.txt");

        if (!path.exists()) {
            path.createNewFile();
        }

        BufferedWriter escrever = new BufferedWriter(new FileWriter(path));

        for (String saida: saidas) {
            escrever.write(saida);
            escrever.newLine();
        }
        escrever.close();
    }
}
