package ERE.Mips;

import java.io.IOException;
import java.util.regex.Pattern;

public class FormatoI extends Converter {

    private String rs;
    private String rt;
    private String immediate;

    public FormatoI(String funcao, String registradores) throws IOException {
        super(funcao, registradores);
    }

    public String separador() {
        String registrador[] = registradores.split(",");
        rs = registrador[0];

        if(funcao.equals("lb") || funcao.equals("lh")
            || funcao.equals("lw")  || funcao.equals("lbu")
            || funcao.equals("lhu") || funcao.equals("lwr")
            || funcao.equals("sb")  || funcao.equals("sh")
            || funcao.equals("swl") || funcao.equals("sw")
            || funcao.equals("swr") || funcao.equals("lwl")
        ){
            rt = "";
            String aux[] = registrador[1].split(Pattern.quote("("));
            String aux2[] = aux[1].split("");
            aux[1] = "";
            for (int i = 0; i < aux2.length - 1; i++) {
                rt += aux2[i];
            }
            immediate = aux[0];
        } else {
            rt = registrador[1];
            immediate = registrador[2];
        }
        return  converterParaBinario(rs, rt,immediate);

    }

    private String converterParaBinario(String rs, String rt, String immediate) {

        String comandoBinario = "";
        System.out.println(immediate);
        int verificarNegativo = Integer.parseInt(immediate);
        String binario = Integer.toBinaryString(Integer.parseInt(immediate));
        if (verificarNegativo < 0){
            binario = preencherBinario(binario, true);
        } else {
            binario = preencherBinario(binario, false);
        }

        comandoBinario = comandos.get(funcao).toString() + comandos.get(rs) + comandos.get(rt) + " " + binario;

        return comandoBinario;
    }

    private String preencherBinario(String bin, boolean negativo){

        String binSplit[] = bin.split("");

        if (negativo) {
            bin = "";
            for (int i = 16; i < binSplit.length; i++) {
                bin += binSplit[i];
            }
        } else {
            for (int i = 0; i < 16 - binSplit.length ; i++) {
                bin = "0" + bin;
            }
        }

        return bin;
    }
}
