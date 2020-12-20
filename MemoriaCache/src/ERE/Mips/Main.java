package ERE.Mips;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Leitura leitura =  new Leitura("entrada.txt");
        ArrayList<String> entrada = leitura.lerArquivo();

        //Pega o valor que define qual é o tipo de mapeamento
        String tipoMapeamento = entrada.get(0);
        entrada.remove(0);

        Mapeamento mapeamento = new Mapeamento(entrada);

        mapeamento.fazerMapeamento(tipoMapeamento);
    }
}
