package ERE.Mips;

import java.io.IOException;

public class FormatoR extends Converter {

    private String rd;
    private String rs;
    private String rt;
    private String shamt;

    /**
     * Construtor que irá receber a função e os registradores
     * @param funcao
     * @param registradores
     */
    public FormatoR(String funcao, String registradores) throws IOException {
        super(funcao, registradores);
    }

    /**
     * Método que irá separar os registradores para rd, rs e o rt
     */
    public String converter() {
        String registrador[] = registradores.split(",");
        if (funcao.equals("mfhi") || funcao.equals("mflo")) {
            //essas funçôes só tem o rd

            return converterParaBinario(registradores, "00000", "00000", "00000");
        }
        else if (funcao.equals("mthi") || funcao.equals("mtlo") || funcao.equals("jr")) {
            //essas funções só tem o rs

            return converterParaBinario("00000", registradores, "00000", "00000");
        }
        else if (funcao.equals("mult") || funcao.equals("multu")
                || funcao.equals("div") || funcao.equals("divu")) {
            //essas funções tem só os rs e o rt

            rs = registrador[0];
            rt = registrador[1];

            return converterParaBinario("00000", rs, rt, "00000");
        }
        else if (funcao.equals("jalr")) {
            //essa função tem só o rs e o rd
            rd = registrador[0];
            rs = registrador[1];

            return converterParaBinario(rd, rs, "00000", "00000");
        }
        else if (funcao.equals("sra") || funcao.equals("srl") || funcao.equals("sll")) {
            //essas funções tem o rt, o rd e um numero

            rd = registrador[0];
            rt = registrador[1];
            shamt = registrador[2];

            int verificarNegativo = Integer.parseInt(shamt);
            String binario = Integer.toBinaryString(Integer.parseInt(shamt));

            if (verificarNegativo < 0){
                binario = preencherBinario(binario, true);
            } else {
                binario = preencherBinario(binario, false);
            }

            shamt = binario;

            return converterParaBinario(rd, "00000", rt, shamt);
        }
        else {
            //essas funções tem rd, rs e o rt
            rd = registrador[0];
            rs = registrador[1];
            rt = registrador[2];

            return converterParaBinario(rd, rs, rt, "00000");
        }
    }

    private String converterParaBinario(String rd, String rs, String rt, String shamt) {

        String comandoBinario = "";

        if (shamt.equals("00000")){
            comandoBinario = "000000"
                    + comandos.get(rs)
                    + comandos.get(rt)
                    + comandos.get(rd)
                    + comandos.get(shamt)
                    + comandos.get(funcao);
        } else {
            comandoBinario = "000000" + comandos.get(rs) + comandos.get(rt) + comandos.get(rd) + shamt + comandos.get(funcao);

        }


        return comandoBinario;
    }
    private String preencherBinario(String bin, boolean negativo){

        String binSplit[] = bin.split("");

        if (negativo) {
            bin = "";
            for (int i = 27; i < binSplit.length; i++) {
                bin += binSplit[i];
            }
        } else {
            for (int i = 0; i < 5 - binSplit.length ; i++) {
                bin = "0" + bin;
            }
        }

        return bin;
    }
}
