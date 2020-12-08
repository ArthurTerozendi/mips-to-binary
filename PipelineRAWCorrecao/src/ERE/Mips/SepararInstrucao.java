package ERE.Mips;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class SepararInstrucao {
    public SepararInstrucao() {

    }

    /**
     *
     * @param registradores
     * @param funcao
     * @return
     */
    public ArrayList<String> separarTipoR(String registradores, String funcao) {

        String registrador[] = registradores.split(",");
        ArrayList<String> instrucoes = new ArrayList<>();

        instrucoes.add(funcao);

        for (int i = 0; i < registrador.length; i++) {
            instrucoes.add(registrador[i]);
        }
        return instrucoes;
    }

    /**
     *
     * @param registradores
     * @param funcao
     * @return
     */
    public ArrayList<String> separarTipoI(String registradores, String funcao) {

        String registrador[] = registradores.split(",");
        ArrayList<String> instrucoes = new ArrayList<>();

        instrucoes.add(funcao);

        //Verifica se a função tem parenteses
        if(funcao.equals("lb") || funcao.equals("lh")
                || funcao.equals("lw")  || funcao.equals("lbu")
                || funcao.equals("lhu") || funcao.equals("lwr")
                || funcao.equals("sb")  || funcao.equals("sh")
                || funcao.equals("swl") || funcao.equals("sw")
                || funcao.equals("swr") || funcao.equals("lwl")
        ){
            instrucoes.add(registrador[0]);
            String rs = "";

            //Tira o primeiro parenteses
            String aux[] = registrador[1].split(Pattern.quote("("));
            //Separa o parte com o segundo parenteses caracter por caracter
            String aux2[] = aux[1].split("");

            //aux[1] = "";
            //Vai juntar todos os caracteres em um string, exceto o ultimo, que é o que contém os parenteses
            for (int i = 0; i < aux2.length - 1; i++) {
                rs += aux2[i];
            }
            instrucoes.add(rs);
        } else {
            //restante das funções
            for (int i = 0; i < registrador.length; i++) {
                instrucoes.add(registrador[i]);
            }
        }
        return instrucoes;
    }

    /**
     *
     * @param registradores
     * @param funcao
     * @return
     */
    public ArrayList<String> separarTipoJ(String registradores, String funcao) {

        String registrador[] = registradores.split(",");
        ArrayList<String> instrucoes = new ArrayList<>();

        instrucoes.add(funcao);

        for (int i = 0; i < registrador.length; i++) {
            instrucoes.add(registrador[i]);
        }
        return instrucoes;
    }
}
