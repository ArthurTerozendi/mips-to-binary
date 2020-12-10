package ERE.Mips;

import java.util.ArrayList;
import java.util.HashMap;

public class Reordenamento {

    public void aplicandoReordenamento(HashMap<String, ArrayList<String>> instRegist, ArrayList<String> instrucoes) {
        boolean ordenado = false;
        String auxOrdenacao[] = new String[instrucoes.size()];

        for (int i = 0; i < auxOrdenacao.length; i++) {
            auxOrdenacao[i] =  instrucoes.get(i);
        }
        while(!ordenado) {
            for (int i = 0; i < instrucoes.size()-1; i++) {
                ArrayList<String> registradoresAtual = instRegist.get(auxOrdenacao[i]);
                ArrayList<String> registradoresProx = instRegist.get(auxOrdenacao[i + 1]);
                if (registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 1))
                        || registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 2))) {
                    String aux = auxOrdenacao[i];
                    auxOrdenacao[i] = auxOrdenacao[i+1];
                    auxOrdenacao[i + 1] = aux;
                    ordenado = false;
                } else {
                    ordenado = true;
                }
            }
        }
        for (int i = 0; i < auxOrdenacao.length; i++) {
            System.out.println(auxOrdenacao[i]);
        }
    }
}
