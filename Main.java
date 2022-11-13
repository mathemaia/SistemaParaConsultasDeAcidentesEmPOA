import Dados.BancoDeDados;

import java.io.FileNotFoundException;
import java.util.Scanner;
import Listas.ListaDeRuas;
import Listas.ListaDeAcidentes;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean sair = false;

        // Cria uma lista com todas as ruas e todos os seus respectivos acidentes.
        BancoDeDados dataset = new BancoDeDados("Dados/cat_vitimas.csv");

        do {
            // Menu com as opções de interação com o programa.
            Scanner in = new Scanner(System.in);
            System.out.println("[1] Ruas com mais acidentes\n" +
                    "[2] Qtd. ruas\n" +
                    "[3] Consultar rua\n" +
                    "[4] Consultar acidentes\n" +
                    "[5] Inserir nova rua\n" +
                    "[6] Inserir novo acidente\n" +
                    "[0] Sair");
            System.out.print("Digite uma OPÇÃO: ");

            // Testa se a opção inserida é inteiro.
            try {
                int entrada = Integer.parseInt(in.nextLine());

                // [1] Ruas com mais acidentes.
                // Mostra a quantidade definida de ruas com mais acidentes.
                if (entrada == 1) {
                    System.out.print("Qtd. a ser mostrada: ");
                    int qtd = in.nextInt();
                    System.out.println("\n----- Ruas com mais acidentes -----");
                    dataset.ruasComMaisAcidentes(qtd);
                    System.out.println("-----------------------------------\n");

                // [2] Qtd. ruas
                // Mostra a quantidade total de ruas na lista.
                } else if (entrada == 2) {
                    System.out.println("\n---------- Qtd. de ruas -----------");
                    System.out.println(dataset.listaDeRuas().size());
                    System.out.println("-----------------------------------\n");

                // [3] Consultar.
                // Pede o nome de uma rua e mostra
                } else if (entrada == 3) {
                    System.out.print("Digite o nome da RUA: ");
                    String nome = in.nextLine().toUpperCase();
                    if (dataset.listaDeRuas().contains(nome)) {
                        int idx = dataset.listaDeRuas().indexOf(nome);
                        System.out.println("\n-----------------------------------");
                        System.out.println(nome);
                        System.out.print("-----------------------------------\n");
                        System.out.println("Total de acidentes: " + dataset.listaDeRuas().listaDeAcidentes(idx).size());
                        // Imprime as informações dos dois primeiros acidentes da rua inserida (se existirem).
                        if (dataset.listaDeRuas().listaDeAcidentes(idx).size() > 1) {
                            System.out.println(dataset.listaDeRuas().listaDeAcidentes(idx).getAcidente(0));
                            System.out.println(dataset.listaDeRuas().listaDeAcidentes(idx).getAcidente(1));
                            System.out.println("        *\n        *\n        *\n-----------------------------------");
                        } else if (dataset.listaDeRuas().listaDeAcidentes(idx).size() == 1){
                            System.out.println(dataset.listaDeRuas().listaDeAcidentes(idx).getAcidente(0));
                            System.out.println("        *\n        *\n        *\n-----------------------------------");
                        }
                        System.out.println();
                    } else {
                        System.out.println("\nEntrada inválida...\n");
                    }

                // [4] Consultar acidentes
                // Consulta acidentes pela data ocorrida.
                } else if (entrada == 4) {
                    System.out.print("Digite o nome da RUA: ");
                    String nome = in.nextLine().toUpperCase();
                    System.out.print("Digite uma data: ");
                    String data = in.next();
                    if (dataset.listaDeRuas().contains(nome) && !nome.equals("")) {
                        int idx = dataset.listaDeRuas().indexOf(nome);
                        int count = 0;
                        // Procura acidentes na data inserida.
                        for (int i = 0; i < dataset.listaDeRuas().listaDeAcidentes(idx).size(); i++) {
                            if (dataset.listaDeRuas().listaDeAcidentes(idx).getInfo(i, "data").split(" ")[0].equals(data)) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            System.out.println("\nNão existem acidentes registrados nesta data.\n");
                        } else {
                            System.out.println("\n-----------------------------------");
                            System.out.println(data);
                            System.out.print("-----------------------------------");
                            for (int i = 0; i < dataset.listaDeRuas().listaDeAcidentes(idx).size(); i++) {
                                if (dataset.listaDeRuas().listaDeAcidentes(idx).getInfo(i, "data").split(" ")[0].equals(data)) {
                                    System.out.println(dataset.listaDeRuas().listaDeAcidentes(idx).getAcidente(i));
                                }
                            }
                            System.out.print("-----------------------------------\n\n");
                        }
                    } else {
                        System.out.println("\nNome da rua inválido.\n");
                    }

                // [5] Inserir nova rua
                // Insere uma nova rua na lista de ruas.
                } else if (entrada == 5) {
                    System.out.print("Nome da RUA: ");
                    String nome = in.nextLine().toUpperCase();
                    dataset.listaDeRuas().addRua(nome, new ListaDeAcidentes(nome));
                    int idx = dataset.listaDeRuas().indexOf(nome);
                    System.out.println("\n-----------------------------------");
                    System.out.println(nome + " adicionada.");
                    System.out.println("Qtd. acidentes: " + dataset.listaDeRuas().listaDeAcidentes(idx).size());
                    System.out.println("Nova qtd. total de ruas: " + dataset.listaDeRuas().size());
                    System.out.println("-----------------------------------");
                    System.out.println();

                // [6] Inserir novo acidente
                // Insere um novo acidente à rua escolhida.
                } else if (entrada == 6){
                    System.out.print("Nome da rua: ");
                    String nome = in.nextLine().toUpperCase();
                    if (dataset.listaDeRuas().contains(nome)) {
                        int idx = dataset.listaDeRuas().indexOf(nome);
                        System.out.println("\n-----------------------------------");
                        System.out.println("Insira os dados do acidente");
                        System.out.println("-----------------------------------");
                        // Dados que serão inseridos.
                        System.out.print("data: ");
                        String data = in.next();
                        System.out.print("hora: ");
                        String hora = in.next();
                        System.out.print("idade: ");
                        int idade = in.nextInt();
                        System.out.print("sexo: ");
                        String sexo = in.next();
                        System.out.print("sitVitima: ");
                        String sitVitima = in.next();
                        System.out.print("tipoAcid: ");
                        String tipoAcid = in.next();
                        System.out.print("auto: ");
                        int auto = in.nextInt();
                        System.out.print("taxi: ");
                        int taxi = in.nextInt();
                        System.out.print("onibusUrb: ");
                        int onibusUrb = in.nextInt();
                        System.out.print("onibusMet: ");
                        int onibusMet = in.nextInt();
                        System.out.print("onibusInt: ");
                        int onibusInt = in.nextInt();
                        System.out.print("caminhao: ");
                        int caminhao = in.nextInt();
                        System.out.print("moto: ");
                        int moto = in.nextInt();
                        System.out.print("carroca: ");
                        int carroca = in.nextInt();
                        System.out.print("bicicleta: ");
                        int bicicleta = in.nextInt();
                        System.out.print("outro: ");
                        int outro = in.nextInt();
                        System.out.print("lotacao: ");
                        int lotacao = in.nextInt();
                        System.out.print("diaSem: ");
                        String diaSem = in.next();
                        System.out.print("periodoDia: ");
                        String periodoDia = in.next();
                        System.out.print("fxEt: ");
                        String fxEt = in.next();
                        System.out.print("tipoVeic: ");
                        String tipoVeic = in.next();
                        System.out.println("-----------------------------------\n");
                        // Adiciona o acidente com os dados inseridos acima.
                        System.out.println("------- Acidente adicionado -------");
                        dataset.listaDeRuas().listaDeAcidentes(idx).addAcidente(data, hora, idade, sexo, sitVitima, nome,
                                tipoAcid, auto, taxi, onibusUrb, onibusMet, onibusInt, caminhao, moto, carroca, bicicleta,
                                outro, lotacao, diaSem, periodoDia, fxEt, tipoVeic);
                        System.out.println("Rua: " + nome);
                        System.out.println("Qtd. acidentes nesta rua: " + dataset.listaDeRuas().listaDeAcidentes(idx).size());
                        System.out.println("-----------------------------------\n");
                    } else {
                        System.out.println("\nRua inválida.\n");
                    }

                // [0] Sair
                // Finaliza a execução do programa.
                } else if (entrada == 0) {
                    sair = true;
                } else {
                    System.out.println("\nOpção inválida.\n");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada inválida.\n");
            }

            } while (!sair);
    }
}
