package ERE.Mips;

import java.io.IOException;

public class FormatoJ extends Converter {

    /**
     * Construtor que irá receber a função e os registradores
     * @param funcao
     * @param registradores
     */
    public FormatoJ(String funcao, String registradores) throws IOException {
        super(funcao, registradores);
    }

    /**
     * Método responsável por retonar o comando convertido para binario
     * @return
     */
    public String converter() {
        System.out.println(funcao + " " + registradores);
        int immediate = Integer.parseInt(registradores);
        immediate /= 4;

        String immediateBin = "";
        //verifica se o immediate é negativo ou não
        if (immediate < 0){
            immediateBin = toBinario(immediate, true);
        } else {
            immediateBin = toBinario(immediate, false);
        }
        return comandos.get(funcao) + immediateBin;
    }

    /**
     * Método responsável por formatar o binario para 26 bits
     * @param decimal
     * @param negativo
     * @return
     */
    private String toBinario (int decimal, boolean negativo) {
        String bin = Integer.toBinaryString(decimal);
        String binSplit[] = bin.split("");

        //Caso o número seja negativo, irá retirar todos os "1" a mais, deixando o binario apenas com 26 bits
        if (negativo) {
            bin = "";
            for (int i = 8; i < binSplit.length; i++) {
                bin += binSplit[i];
            }
        }
        //Caso o número seja positivo, irá preencher o binario com 0, até que tenha 26 bits
        else {
            for (int i = 0; i < 26 - binSplit.length ; i++) {
                bin = "0" + bin;
            }
        }


        return bin;
    }
}
