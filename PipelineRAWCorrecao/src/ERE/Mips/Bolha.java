package ERE.Mips;

import java.util.ArrayList;
import java.util.HashMap;

public class Bolha {
    public Bolha() {}

    /**
     * Verifica se os registradores de leitura da instrução seguinte são iguais ao registrador de escrita da instrução
     * atual. Se for, é colocado uma instrução NOP entre as instruções.
     * @param instRegist
     * @param instrucoes
     */
    public ArrayList<String> aplicandoBolha(HashMap<String, ArrayList<String>> instRegist, ArrayList<String> instrucoes) {
        ArrayList<String> saida = new ArrayList<>();
        for (int i = 0; i < instrucoes.size(); i++) {
            if (i == instrucoes.size() - 1) {
                saida.add(instrucoes.get(i));
            } else {
                saida.add(instrucoes.get(i));
                ArrayList<String> registradoresAtual = instRegist.get(instrucoes.get(i));
                ArrayList<String> registradoresProx = instRegist.get(instrucoes.get(i + 1));
                String funcao = registradoresAtual.get(0);
                if (funcao.equals("addi") || funcao.equals("ori")
                        || funcao.equals("xori") || funcao.equals("lui")
                        || funcao.equals("bltz") || funcao.equals("bgez")
                        || funcao.equals("bltzal") || funcao.equals("beq")
                        || funcao.equals("bne") || funcao.equals("blez")
                        || funcao.equals("bgtz") || funcao.equals("lb")
                        || funcao.equals("lh") || funcao.equals("lwl")
                        || funcao.equals("lw") || funcao.equals("lbu")
                        || funcao.equals("lhu") || funcao.equals("lwr")
                        || funcao.equals("sb") || funcao.equals("sh")
                        || funcao.equals("swl") || funcao.equals("sw")
                        || funcao.equals("swr") || funcao.equals("addiu")
                        || funcao.equals("slti") || funcao.equals("sltiu")
                        || funcao.equals("andi")) {
                    if (registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 1))) {
                        saida.add("NOP");
                        saida.add("NOP");
                    }
                } else {
                    if (registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 1))
                            || registradoresAtual.get(1).equals(registradoresProx.get(registradoresProx.size() - 2))) {
                        saida.add("NOP");
                        saida.add("NOP");
                    }
                }
                if (i == instrucoes.size() - 1) {
                    saida.add(instrucoes.get(i + 1));
                }
            }
        }
        return saida;
    }
}
