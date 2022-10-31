package Dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BancoDeDados {
    private String[] linha;
    private String[][] matriz;

    public BancoDeDados(String endereco) throws FileNotFoundException {
        this.matriz = new String[28056][22];
        lerArquivo(endereco);
        this.linha = null;
    }

    /**
     * Cria a matriz de dados.
     * @param endereco endereço do csv.
     * @throws FileNotFoundException lança um erro caso não encontre o arquivo.
     */
    private void lerArquivo(String endereco) throws FileNotFoundException {
        Scanner in = new Scanner(new File(endereco));

        // Conta a quantidade de linhas.
        for (int i = 0; in.hasNextLine(); i++) {
            String[] linha = in.nextLine().split(";");
            System.arraycopy(linha, 0, this.matriz[i], 0, 22);
        }
    }

    /**
     * Retorna a matriz de dados.
     * @return matriz de dados;
     */
    public String[][] getMatriz() {
        return this.matriz;
    }

    public static void main(String[] args) throws FileNotFoundException {
        BancoDeDados dataset = new BancoDeDados("src/Dados/vitimas.csv");

        String[][] dados = dataset.getMatriz();
        System.out.println(Arrays.toString(dados[5]));

    }
}
