package Dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Listas.ListaDeRuas;
import Listas.ListaDeAcidentes;

public class BancoDeDados {
    private ListaDeAcidentes acidentes;
    private ListaDeRuas ruas;
    private String[][] matriz;
    private int qtdLinhas;

    public BancoDeDados(String endereco) throws FileNotFoundException {
        qtdLinhas(endereco);
        this.matriz = new String[this.qtdLinhas][22];
        lerArquivo(endereco);
    }

    /**
     * Método que conta a quantidade de linhas do banco de dados para criar a matriz de dados.
     * @param endereco endereço do arquivo.
     * @throws FileNotFoundException lança uma exceção caso não encontre o arquivo.
     */
    private void qtdLinhas(String endereco) throws FileNotFoundException {
        Scanner in = new Scanner(new File(endereco));

        // Conta a quantidade de linhas para criar a matriz de dados.
        while (in.hasNextLine()) {
            String linha = in.nextLine();
            this.qtdLinhas++;
        }
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
        ListaDeRuas ruas = new ListaDeRuas();
        ListaDeAcidentes acidentes;

        // Contador de linhas.

        // Cria todas as Ruas (nodos) da lista de ruas.
        String[][] dados = dataset.getMatriz();
        int qtdRuas = 0;
        /*
        for (int i = 1; i < dataset.getQtdLinhas(); i++) {
            if (!ruas.contains(dados[i][5])) {
                ruas.add(dados[i][5], new ListaDeAcidentes(dados[i][5]));
                qtdRuas++;
            }
        }
         */

        System.out.println(qtdRuas);
        // Cria a lista de acidentes de cada Rua e adiciona seus respectivos acidentes.
        for (int i = 0; i < qtdRuas; i++) {
            // Procura a Rua (nodo) da linha de indice 'i' do dataset.
            // Quando as Ruas se repetirem, adicionará outro acidente à lista de acidentes desta rua.
            int idx = ruas.indexOf(dados[i][5]);
            //System.out.println(dados[i][5]);
            // Adiciona o acidente de indice 'i' do dataset.
            /*
            ruas.getAcidentes(idx).addAcidente(dados[i][0], dados[i][1], Integer.parseInt(dados[i][2]), dados[i][3],
                    dados[i][4], dados[i][5], dados[i][6], Integer.parseInt(dados[i][7]),
                    Integer.parseInt(dados[i][8]), Integer.parseInt(dados[i][9]), Integer.parseInt(dados[i][10]),
                    Integer.parseInt(dados[i][11]), Integer.parseInt(dados[i][12]), Integer.parseInt(dados[i][13]),
                    Integer.parseInt(dados[i][14]), Integer.parseInt(dados[i][15]), Integer.parseInt(dados[i][16]),
                    Integer.parseInt(dados[i][17]), dados[i][18], dados[i][19], dados[i][20], dados[i][21]);
             */

        }

        //System.out.println(ruas.getAcidentes(0).getAcidente(0));



    }
}
