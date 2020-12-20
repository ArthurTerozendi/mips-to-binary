package ERE.Mips;

import java.util.ArrayList;
import java.util.HashMap;

public class Reordenamento {

    /**
     * Verifica se os registradores de leitura da instrução seguinte são iguais ao registrador de escrita da instrução
     * atual, e vai fazendo isso e reordenando as entradas até que sua ordem não tenha nenhum registrador de leitura
     * depois de uma escrita
     * @param instRegist
     * @param instrucoes
     */
    public String[] aplicandoReordenamento(HashMap<String, ArrayList<String>> instRegist, ArrayList<String> instrucoes) {
        boolean ordenado = false;
        String auxOrdenacao[] = new String[instrucoes.size()];

        for (int i = 0; i < auxOrdenacao.length; i++) {
            auxOrdenacao[i] =  instrucoes.get(i);
        }
        while(!ordenado) {
            for (int i = 0; i < instrucoes.size()-1; i++) {
                ArrayList<String> registradoresAtual = instRegist.get(auxOrdenacao[i]);
                ArrayList<String> registradoresProx = instRegist.get(auxOrdenacao[i + 1]);
                String funcao = registradoresProx.get(0);
                if (funcao.equals("lb") || funcao.equals("lh")
                        || funcao.equals("lw")  || funcao.equals("lbu")
                        || funcao.equals("lhu") || funcao.equals("lwr")
                        || funcao.equals("sb")  || funcao.equals("sh")
                        || funcao.equals("swl") || funcao.equals("sw")
                        || funcao.equals("swr") || funcao.equals("lwl")) {
                    String regAux = registradoresAtual.get(1);
                    String regAux2 = registradoresProx.get(registradoresProx.size() - 1);
                    if (regAux.equals(regAux2)) {
                        ordenado = false;
                    } else {
                        String aux = auxOrdenacao[i];
                        auxOrdenacao[i] = auxOrdenacao[i+1];
                        auxOrdenacao[i + 1] = aux;
                        ordenado = true;
                    }
                } else {
                    if (registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 1))
                            || registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 2))) {
                        ordenado = false;
                    } else {
                        String aux = auxOrdenacao[i];
                        auxOrdenacao[i] = auxOrdenacao[i+1];
                        auxOrdenacao[i + 1] = aux;
                        ordenado = true;
                    }
                }
            }
        }

        return  auxOrdenacao;
    }
}
