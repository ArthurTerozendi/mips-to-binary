package ERE.Mips;

import java.io.IOException;

public class FormatoJ extends Converter {

    public FormatoJ(String funcao, String registradores) throws IOException {
        super(funcao, registradores);
    }

    public String converter() {
        System.out.println(funcao + " " + registradores);
        int immediate = Integer.parseInt(registradores);
        immediate /= 4;

        String immediateBin = "";
        if (immediate < 0){
            immediateBin = toBinario(immediate, true);
        } else {
            immediateBin = toBinario(immediate, false);
        }
        return comandos.get(funcao) + immediateBin;
    }

    private String toBinario (int decimal, boolean negativo) {
        String bin = Integer.toBinaryString(decimal);
        String binSplit[] = bin.split("");
        if (negativo) {
            bin = "";
            for (int i = 8; i < binSplit.length; i++) {
                bin += binSplit[i];
            }
        } else {
            for (int i = 0; i < 26 - binSplit.length ; i++) {
                bin = "0" + bin;
            }
        }


        return bin;
    }
}
