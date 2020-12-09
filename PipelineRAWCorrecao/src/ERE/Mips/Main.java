package ERE.Mips;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

	    Leitura leitura = new Leitura("instrucoes.txt");
        ArrayList<String> instrucoes = leitura.lerArquivo();
        SepararInstrucao separarInstrucao = new SepararInstrucao();

        HashMap<String, ArrayList<String>> instrucoesRegistradores = new HashMap<>();

        for (String instrucao : instrucoes) {
            String inst[] = instrucao.split(" ");
            String registradores = "";
            String funcao = inst[0];
            for (int i = 1; i < inst.length; i++) {
                registradores += inst[i];
            }

            //verifica se a função é do tipo R
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
                System.out.println(separarInstrucao.separarTipoR(registradores, funcao));
                System.out.println(instrucao);

                instrucoesRegistradores.put(instrucao, separarInstrucao.separarTipoR(registradores, funcao));
            }

            //verifica se a função é do tipo I
            else if (funcao.equals("addi") || funcao.equals("ori")
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
                System.out.println(separarInstrucao.separarTipoI(registradores, funcao));
                System.out.println(instrucao);

                instrucoesRegistradores.put(instrucao, separarInstrucao.separarTipoR(registradores, funcao));
            }

            //verifica se a função é do tipo J
            else if (funcao.equals("j") || funcao.equals("jal")) {
                System.out.println(separarInstrucao.separarTipoJ(registradores, funcao));

                instrucoesRegistradores.put(instrucao, separarInstrucao.separarTipoR(registradores, funcao));
            } else {
                System.out.println("ERROR - Função desconhecida!");
                System.out.println(instrucao);
            }
        }

        Bolha bolha = new Bolha();

        bolha.aplicandoBolha(instrucoesRegistradores, instrucoes);
    }
}
