package ERE.Mips;

public class FormatoR extends Converter {

    private String rd;
    private String rs;
    private String rt;

    public FormatoR(String funcao, String registradores) {
        super(funcao, registradores);
    }

    public void separador() {
        String registrador[] = registradores.split(",");
        rd = registrador[0];
        rs = registrador[1];
        rt = registrador[2];

        System.out.println(rd + " " + rs + " " + rt);
    }
}
