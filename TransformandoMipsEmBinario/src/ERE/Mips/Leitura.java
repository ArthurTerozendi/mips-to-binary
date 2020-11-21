package ERE.Mips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {
    private File path;

    public Leitura() {
        this.path = new File("entradas.txt");
    }

    public ArrayList<String> getEntradas() throws IOException {
        ArrayList<String> entradas = new ArrayList<>();

        FileReader ler = new FileReader(path);
        BufferedReader bLer = new BufferedReader(ler);

        while (bLer.ready()) {
            entradas.add(bLer.readLine());
        }

        bLer.close();
        ler.close();
        return entradas;
    }
}
