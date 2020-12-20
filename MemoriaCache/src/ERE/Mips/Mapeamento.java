package ERE.Mips;

import java.io.IOException;
import java.util.ArrayList;

public class Mapeamento {

    private String tamanhoMemoria;
    private ArrayList<String> endereços;
    private String bytes;
    private String palavras;
    private String blocos;
    private String conjuntos;
    private String acessosMemoria;
    private ArrayList<String> saida;

    public Mapeamento(ArrayList<String> entrada) {
        this.tamanhoMemoria = entrada.get(0);
        entrada.remove(0);
        separarNumeros(entrada.get(0));
        entrada.remove(0);
        this.endereços = entrada;
        this.saida = new ArrayList<>();
    }

    /**
     * Separa a linha dos números para os seus respectivos campos
     * @param numeros
     */
    private void separarNumeros(String numeros) {
        String numerosSplit[] = numeros.split(" ");
        this.bytes = numerosSplit[0];
        this.palavras = numerosSplit[1];
        this.blocos = numerosSplit[2];
        this.conjuntos = numerosSplit[3];
        this.acessosMemoria = numerosSplit[4];

    }

    /**
     * Calcula o tamanho do mémoria cache
     * @return
     */
    private String calcularTamanhoCache() {
        long tamanhoCache =  (Long.parseLong(bytes)
                * Long.parseLong(palavras)
                * Long.parseLong(blocos)
                * Long.parseLong(conjuntos));

        if (tamanhoCache >= 1024 && tamanhoCache < 1024*1024) {
            return (tamanhoCache / 1000) + " KB";
        } else if (tamanhoCache >= 1024*1024 && tamanhoCache < 1024*1024*1024) {
            return (tamanhoCache / 1000000) + " MB";
        } else if (tamanhoCache >= 1024*1024*1024) {
            return (tamanhoCache / 1000000000) + " GB";
        } else {
            return (tamanhoCache) + " B";
        }
    }

    /**
     * calcula o tamanho, em bits, do endereço
     * @return
     */
    private double calcularTamanhoEndereco() {
        String grandeza = tamanhoMemoria.split(" ")[1];
        double tamMemNum = Double.parseDouble(tamanhoMemoria.split(" ")[0]);
        double enderecoBits = Math.log(tamMemNum)/Math.log(2);
        if (grandeza.equalsIgnoreCase("KB")) {
            return enderecoBits + 10;
        } else if (grandeza.equalsIgnoreCase("MB")) {
            return enderecoBits + 20;
        } else if (grandeza.equalsIgnoreCase("GB")) {
            return enderecoBits + 30;
        } else {
            return enderecoBits;
        }
    }

    /**
     * calcula o tamanho, em bits, da posição no bloco
     * @return
     */
    private double calcularBitsPosicao() {
        return Math.log(Double.parseDouble(bytes) * Double.parseDouble(palavras)) / Math.log(2);
    }

    /**
     * calcula o tamanho, em bits, do número de conjunto
     * @return
     */
    private double calcularBitsConjunto() {
        return Math.log(Double.parseDouble(conjuntos)) / Math.log(2);
    }

    /**
     * Método principal, que irá chamar todos os outros métodos,
     * e mandar o resultado para ser escrita no arquivo de saida
     * @param tipo
     * @throws IOException
     */
    public void fazerMapeamento(String tipo) throws IOException {
        int tam = (int) calcularTamanhoEndereco();
        int pos = (int) calcularBitsPosicao();
        int conj = (int) calcularBitsConjunto();
        int tag = tam - (conj + pos);
        this.saida.add("Tamanho da memória: " + calcularTamanhoCache()
                + "\nNúmero de bits do endereço: " + tam
                + "\nNúmero de bits para posição no bloco: " + pos
                + "\nNúmero de bits para o número do conjunto: " + conj
                + "\nNúmero de bits para a TAG: " + tag);
        switch (tipo){
            case "1":
                fazerMapeamentoDireto(tam, pos, conj);
                break;
            case "2":
                fazerMapeamentoComplentamenteAssociativo(tam, pos);
                break;
            case "3":
                fazerMapeamentoAssociativoConjunto(tam, pos, conj);
                break;
            default:
                System.out.println("ERROR!!! Tipo de mapeamento desconhecido");
        }

        Escrita escrita = new Escrita();
        escrita.escreverArquivo(this.saida);
    }

    /**
     * Faz o mapeamento direto
     * @param tamanhoBits
     * @param posicaoBits
     * @param conjuntoBits
     */
    private void fazerMapeamentoDireto(int tamanhoBits, int posicaoBits, int conjuntoBits) {
        for (String endereco: endereços) {
            String bin = Integer.toBinaryString(Integer.parseInt(endereco));
            String aux = "";
            for (int i = 0; i < tamanhoBits - bin.length(); i++) {
                aux += "0";
            }
            bin = aux + bin;


            int endIndex = bin.length() - (posicaoBits + conjuntoBits);
            String tagBin = bin.substring(0, endIndex);

            int beginIndex = bin.length() - (posicaoBits + conjuntoBits);
            endIndex = bin.length() - posicaoBits;
            String conjBin = bin.substring(beginIndex, endIndex);

            beginIndex = bin.length() - (posicaoBits);
            String posicaoBin = bin.substring(beginIndex);

            int tagDec = Integer.parseInt(tagBin, 2);
            int conjDec = Integer.parseInt(conjBin, 2);
            int posicaoDec = Integer.parseInt(posicaoBin, 2);
            this.saida.add(tagDec + "\t\t" + conjDec + "\t\t" + posicaoDec);
        }
    }

    /**
     * Faz o mapeamento completamente associativo
     * @param tamanhoBits
     * @param posicaoBits
     */
    private void fazerMapeamentoComplentamenteAssociativo(int tamanhoBits, int posicaoBits) {
        for (String endereco: endereços) {
            String bin = Integer.toBinaryString(Integer.parseInt(endereco));
            String aux = "";
            for (int i = 0; i < tamanhoBits - bin.length(); i++) {
                aux += "0";
            }
            bin = aux + bin;


            int endIndex = bin.length() - (posicaoBits);
            String tagBin = bin.substring(0, endIndex);


            int beginIndex = bin.length() - (posicaoBits);
            String posicaoBin = bin.substring(beginIndex);

            int tagDec = Integer.parseInt(tagBin, 2);
            int posicaoDec = Integer.parseInt(posicaoBin, 2);
            this.saida.add(tagDec + "\t\t" + 0 + "\t\t" + posicaoDec);
        }
    }

    /**
     * Faz o mapeamento associativo por conjunto
     * @param tamanhoBits
     * @param posicaoBits
     * @param conjuntoBits
     */
    private void fazerMapeamentoAssociativoConjunto(int tamanhoBits, int posicaoBits, int conjuntoBits) {
        for (String endereco: endereços) {
            String bin = Integer.toBinaryString(Integer.parseInt(endereco));
            String aux = "";
            for (int i = 0; i < tamanhoBits - bin.length(); i++) {
                aux += "0";
            }
            bin = aux + bin;


            int endIndex = bin.length() - (posicaoBits + conjuntoBits);
            String tagBin = bin.substring(0, endIndex);

            int beginIndex = bin.length() - (posicaoBits + conjuntoBits);
            endIndex = bin.length() - posicaoBits;
            String conjBin = bin.substring(beginIndex, endIndex);

            beginIndex = bin.length() - (posicaoBits);
            String posicaoBin = bin.substring(beginIndex);

            int tagDec = Integer.parseInt(tagBin, 2);
            int conjDec = Integer.parseInt(conjBin, 2);
            int posicaoDec = Integer.parseInt(posicaoBin, 2);
            this.saida.add(tagDec + "\t\t" + conjDec + "\t\t" + posicaoDec);
        }
    }

}
