package ERE.Mips;

import java.io.IOException;
import java.util.regex.Pattern;

public class FormatoI extends Converter {

    private String rs;
    private String rt;
    private String immediate;

    /**
     * Construtor que irá receber a função e os registradores
     * @param funcao
     * @param registradores
     */
    public FormatoI(String funcao, String registradores) throws IOException {
        super(funcao, registradores);
    }

    /**
     * Método responsável por retonar o comando convertido para binario
     * @return
     */
    public String converter() {
        String registrador[] = registradores.split(",");

        //Verifica se a função tem parenteses
        if(funcao.equals("lb") || funcao.equals("lh")
            || funcao.equals("lw")  || funcao.equals("lbu")
            || funcao.equals("lhu") || funcao.equals("lwr")
            || funcao.equals("sb")  || funcao.equals("sh")
            || funcao.equals("swl") || funcao.equals("sw")
            || funcao.equals("swr") || funcao.equals("lwl")
        ){
            rt = registrador[0];
            rs = "";

            //Tira o primeiro parenteses
            String aux[] = registrador[1].split(Pattern.quote("("));
            //Separa o parte com o segundo parenteses caracter por caracter
            String aux2[] = aux[1].split("");

            //aux[1] = "";
            //Vai juntar todos os caracteres em um string, exceto o ultimo, que é o que contém os parenteses
            for (int i = 0; i < aux2.length - 1; i++) {
                rs += aux2[i];
            }

            immediate = aux[0];
        } else if (funcao.equals("bltz")) {
            //função cujo o rt é especificamente 0
            rt = "00000";
            rs = registrador[0];
            immediate = registrador[1];
        } else if (funcao.equals("bgez")) {
            //função cujo o rt é especificamente 1
            rt = "00001";
            rs = registrador[0];
            immediate = registrador[1];
        } else if (funcao.equals("bltzal")) {
            //função cujo o rt é especificamente 16
            rt = "10000";
            rs = registrador[0];
            immediate = registrador[1];
        } else if (funcao.equals("bgezal")) {
            //função cujo o rt é especificamente 17
            rt = "10001";
            rs = registrador[0];
            immediate = registrador[1];
        } else {
            //restante das funções
            rt = registrador[0];
            rs = registrador[1];
            immediate = registrador[2];
        }
        return  converterParaBinario(rs, rt,immediate);

    }

    /**
     * Método responsável por juntar os registradores e o immediate, agora em binarios, em uma string só
     * @param rs
     * @param rt
     * @param immediate
     * @return
     */
    private String converterParaBinario(String rs, String rt, String immediate) {

        String comandoBinario = "";
        int verificarNegativo = Integer.parseInt(immediate);

        //converte o immediate para binario
        String binario = Integer.toBinaryString(Integer.parseInt(immediate));

        //Vai verificar se o immediate é negativo ou não
        if (verificarNegativo < 0){
            binario = preencherBinario(binario, true);
        } else {
            binario = preencherBinario(binario, false);
        }

        comandoBinario = comandos.get(funcao).toString() + " " + comandos.get(rs)+ " " + comandos.get(rt) + " " + binario;

        return comandoBinario;
    }

    /**
     * Método responsável por formatar o binario para 16 bits
     * @param bin
     * @param negativo
     * @return
     */
    private String preencherBinario(String bin, boolean negativo){

        String binSplit[] = bin.split("");

        //Caso o número seja negativo, irá retirar todos os "1" a mais, deixando o binario apenas com 16 bits
        if (negativo) {
            bin = "";
            for (int i = 16; i < binSplit.length; i++) {
                bin += binSplit[i];
            }
        }
        //Caso o número seja positivo, irá preencher o binario com 0, até que tenha 16 bits
        else {
            for (int i = 0; i < 16 - binSplit.length ; i++) {
                bin = "0" + bin;
            }
        }

        return bin;
    }
}
