package ERE.Mips;

import java.io.IOException;

public class FormatoR extends Converter {

    private String rd;
    private String rs;
    private String rt;

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
    public String separador() {
        String registrador[] = registradores.split(",");
        rd = registrador[0];
        rs = registrador[1];
        rt = registrador[2];
        System.out.println(rd + " " + rs + " " + rt);
        return converterParaBinario(rd, rs, rt);
    }

    private String converterParaBinario(String rd, String rs, String rt) {

        String comandoBinario = "";

        comandoBinario = "000000" + comandos.get(rs) + comandos.get(rt) + comandos.get(rd) + "00000" + comandos.get(funcao);

        return comandoBinario;
    }
}
