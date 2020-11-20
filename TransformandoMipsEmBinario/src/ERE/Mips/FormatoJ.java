package ERE.Mips;

import java.io.IOException;

public class FormatoJ extends Converter {

    public FormatoJ(String funcao, String registradores) throws IOException {
        super(funcao, registradores);
    }

    public void imprimir () {
        System.out.println(funcao + " " + registradores);
    }
}
