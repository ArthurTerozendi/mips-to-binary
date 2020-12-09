package ERE.Mips;

import java.util.ArrayList;
import java.util.HashMap;

public class Bolha {
    public Bolha() {}

    public void aplicandoBolha(HashMap<String, ArrayList<String>> instRegist, ArrayList<String> instrucoes) {
        ArrayList<String> saida = new ArrayList<>();
        for (int i = 0; i < instrucoes.size() - 1; i++) {
            saida.add(instrucoes.get(i));
            ArrayList<String> registradoresAtual = instRegist.get(instrucoes.get(i));
            ArrayList<String> registradoresProx = instRegist.get(instrucoes.get(i + 1));
            if(registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size()-1))) {
                saida.add("NOP");
                saida.add("NOP");
            }
            if(i == instrucoes.size() - 1) {
                saida.add(instrucoes.get(i+1));
            }
        }
        for (String inst: saida) {
            System.out.println(inst);
        }
    }
}
