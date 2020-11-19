package ERE.Mips;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);

        String registradores = "";
        String linha = in.nextLine();
        String comando[] = linha.split(" ");
        String funcao = comando[0];
        for (int i = 1; i < comando.length; i++) {
            registradores += comando[i];
        }
        if(funcao.equals("add") || funcao.equals("addu")
                || funcao.equals("sub") || funcao.equals("subu")
                || funcao.equals("and") || funcao.equals("or")
                || funcao.equals("xor") || funcao.equals("nor")
                || funcao.equals("slt") || funcao.equals("sltu")
                || funcao.equals("sll") || funcao.equals("srl")
                || funcao.equals("sra") || funcao.equals("sllv")
                || funcao.equals("srlv") || funcao.equals("srav")
                || funcao.equals("mfhi") || funcao.equals("mthi")
                || funcao.equals("mflo") || funcao.equals("mtlo")
                || funcao.equals("mult") || funcao.equals("multu")
                || funcao.equals("div") || funcao.equals("divu")
                || funcao.equals("jr") || funcao.equals("jarl")) {
            FormatoR formR = new FormatoR(funcao, registradores);
            formR.separador();
        } else if (funcao.equals("addi") || funcao.equals("ori")
                || funcao.equals("xori") || funcao.equals("lui")
                || funcao.equals("bltz") || funcao.equals("bgez")
                || funcao.equals("bltzal") || funcao.equals("beq")
                || funcao.equals("bne") || funcao.equals("blez")
                || funcao.equals("bgtz") || funcao.equals("lb")
                || funcao.equals("lh") || funcao.equals("lwl")
                || funcao.equals("lw") || funcao.equals("lbu")
                || funcao.equals("lhu") || funcao.equals("lwr")
                || funcao.equals("sb") || funcao.equals("sh")
                || funcao.equals("swl") || funcao.equals("sw")
                || funcao.equals("swr") || funcao.equals("addiu")
                || funcao.equals("slti") || funcao.equals("sltiu")
                || funcao.equals("andi")) {
            FormatoI formI = new FormatoI(funcao, registradores);
            formI.separador();
        } else {
            FormatoJ formJ = new FormatoJ(funcao, registradores);
        }
    }
}
