package ERE.Mips;

import java.util.regex.Pattern;

public class FormatoI extends Converter {

    private String rs;
    private String rt;
    private String immediate;

    public FormatoI(String funcao, String registradores) {
        super(funcao, registradores);
    }

    public void separador() {
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
        System.out.println(rs + " " + rt + " " + immediate);

    }
}
