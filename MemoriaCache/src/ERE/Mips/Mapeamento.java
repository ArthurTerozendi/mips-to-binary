package ERE.Mips;

import java.util.ArrayList;

public class Mapeamento {

    private String tamanhoMemoria;
    private ArrayList<String> endereços;
    private String bytes;
    private String palavras;
    private String blocos;
    private String conjuntos;
    private String acessosMemoria;
    public Mapeamento(ArrayList<String> entrada) {
        this.tamanhoMemoria = entrada.get(0);
        entrada.remove(0);
        separarNumeros(entrada.get(0));
        entrada.remove(0);
        this.endereços = entrada;
    }

    private void separarNumeros(String numeros) {
        String numerosSplit[] = numeros.split(" ");
        this.bytes = numerosSplit[0];
        this.palavras = numerosSplit[1];
        this.blocos = numerosSplit[2];
        this.conjuntos = numerosSplit[3];
        this.acessosMemoria = numerosSplit[4];

    }

    private String calcularTamanhoCache() {
        int tamanhoCache =  (Integer.parseInt(bytes)
                * Integer.parseInt(palavras)
                * Integer.parseInt(blocos)
                * Integer.parseInt(conjuntos));

        if (tamanhoCache >= 1024) {
            return Integer.toString(tamanhoCache / 1000) + " KB";
        } else if (tamanhoCache >= 1024*1024) {
            return Integer.toString(tamanhoCache / 1000000) + " MB";
        } else if (tamanhoCache >= 1024*1024*1024) {
            return Integer.toString(tamanhoCache / 1000000000) + " GB";
        } else {
            return Integer.toString(tamanhoCache) + " B";
        }
    }

    public void fazerMapeamentoDireto() {
        System.out.println("Tamanho da memória: " + calcularTamanhoCache());
    }

    public void fazerMapeamentoComplentamenteAssociativo() {
        System.out.println( "Tipo: 2"
                + "\nTamanho RAM: " + tamanhoMemoria
                + "\nBytes: " + bytes
                + "\nPalavras: " + palavras
                + "\nBlocos: " + blocos
                + "\nConjuntos: " + conjuntos
                + "\nAcessos à memória: " + acessosMemoria
                + "\nEndereçoes: " + endereços );
    }

    public void fazerMapeamentoAssociativoConjunto() {
        System.out.println( "Tipo: 3"
                + "\nTamanho RAM: " + tamanhoMemoria
                + "\nBytes: " + bytes
                + "\nPalavras: " + palavras
                + "\nBlocos: " + blocos
                + "\nConjuntos: " + conjuntos
                + "\nAcessos à memória: " + acessosMemoria
                + "\nEndereçoes: " + endereços );
    }

}
