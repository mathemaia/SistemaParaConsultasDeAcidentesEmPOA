import Dados.BancoDeDados;

import Listas.ListaDeAcidentes;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Cria uma lista com todas as ruas e todos os seus respectivos acidentes.
        BancoDeDados dataset = new BancoDeDados("src/Dados/vitimas.csv");

        // Mostra (neste caso) as 3 ruas com mais acidentes.
        System.out.println("***********************************");
        System.out.println("----- Ruas com mais acidentes -----");
        dataset.ruasComMaisAcidentes(3);
        System.out.println("-----------------------------------");
        System.out.println();

        // Mostra os 3 primeiros acidentes da rua de indice 0.
        System.out.println("***********************************");
        System.out.println("------- Exemplo de consulta -------");
        System.out.println("Rua: " + dataset.listaDeRuas().getRua(0));
        for (int i = 0; i < 2; i++) {
            System.out.println(dataset.listaDeRuas().listaDeAcidentes(0).getAcidente(i));
        }
        System.out.println("-----------------------------------");
        System.out.println();

        // Mostra o tamanho total da lista de ruas.
        System.out.println("***********************************");
        System.out.println("---- Qtd. de ruas registradas -----");
        System.out.println(dataset.listaDeRuas().size());
        System.out.println("-----------------------------------");
        System.out.println();

        // Exemplo de inserção de uma nova rua.
        System.out.println("***********************************");
        System.out.println("------ Ex. de adicao de Rua -------");
        String nome = "RUA DE EXEMPLO";
        dataset.listaDeRuas().addRua(nome, new ListaDeAcidentes(nome));
        int idx = dataset.listaDeRuas().indexOf(nome);
        System.out.println("Rua " + nome + " adicionada.");
        System.out.println("Qtd. acidentes nesta rua: " + dataset.listaDeRuas().listaDeAcidentes(idx).size());
        System.out.println("Qtd de ruas registradas: " + dataset.listaDeRuas().size());
        System.out.println("-----------------------------------");
        System.out.println();

        // Exemplo de inserção de um novo acidente na rua adicionada.
        System.out.println("***********************************");
        System.out.println("---- Ex. de adicao de Acidente ----");
        dataset.listaDeRuas().listaDeAcidentes(idx).addAcidente("00/00/00", "00:00", 0, "sexo",
                "situacao", nome, "tipo", 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, "dia", "periodo", "faixaEt", "veiculo");
        System.out.println("Rua: " + nome);
        System.out.println("Qtd. acidentes nesta rua: " + dataset.listaDeRuas().listaDeAcidentes(idx).size());
        System.out.println("---- Ex. de adicao de Acidente ----");
    }
}
