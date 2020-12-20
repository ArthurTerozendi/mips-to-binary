package ERE.Mips;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Leitura leitura =  new Leitura("entrada.txt");
        ArrayList<String> entrada = leitura.lerArquivo();

        String tipoMapeamento = entrada.get(0);
        entrada.remove(0);

        Mapeamento mapeamento = new Mapeamento(entrada);

        switch (tipoMapeamento){
            case "1":
                mapeamento.fazerMapeamentoDireto();
                break;
            case "2":
                mapeamento.fazerMapeamentoComplentamenteAssociativo();
                break;
            case "3":
                mapeamento.fazerMapeamentoAssociativoConjunto();
                break;
            default:
                System.out.println("ERROR!!! Tipo de mapeamento desconhecido");
        }
    }
}
