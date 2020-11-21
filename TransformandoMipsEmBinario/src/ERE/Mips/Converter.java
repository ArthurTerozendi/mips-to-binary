package ERE.Mips;

import java.io.IOException;
import java.util.HashMap;

public class Converter {
    protected String funcao;
    protected String registradores;
    protected HashMap comandos;

    /**
     * Construtor da classe mãe
     * @param funcao
     * @param registradores
     * @throws IOException
     */
    public Converter(String funcao, String registradores) throws IOException {
        this.funcao = funcao;
        this.registradores = registradores;

        MapaComandos mapaComandos = new MapaComandos();

        this.comandos = mapaComandos.carregarHashMap();

    }
}
