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


    /**
     * Método lerá todas as linhas do arquivo de entrada e retornará um ArrayList com todas essas linhas
     * @return
     * @throws IOException
     */
    public ArrayList<String> getEntradas() throws IOException {
        ArrayList<String> entradas = new ArrayList<>();

        FileReader ler = new FileReader(path);
        BufferedReader bLer = new BufferedReader(ler);

        //Vai ler linha por linha, até q não tenha mais nenhuma
        while (bLer.ready()) {
            //Vai adcionar a linha na ArrayList
            entradas.add(bLer.readLine());
        }

        bLer.close();
        ler.close();
        return entradas;
    }
}
