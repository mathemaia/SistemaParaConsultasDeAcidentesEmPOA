import Listas.ListaDeAcidentes;
import Listas.ListaDeRuas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeRuas ruas = new ListaDeRuas();

        for (int i = 0; i < 3; i++) {
            String nome = "Rua - " + i;
            // Cria uma lista de acidentes.
            ListaDeAcidentes acidentes = new ListaDeAcidentes(nome);

            // Adiciona acidentes na lista de acidentes.
            for (int j = 0; j < 4; j++) {
                acidentes.addAcidente(j, (i + "/" + i + "/" + i), (i + ":00"), i, null, null, null, i, i, i, i,
                        i, i, i, i, i, i, i, null, null, null, null);
            }

            // Adiciona uma rua a lista de ruas com uma lista de acidentes.
            ruas.add(nome, acidentes);
            ruas.getRua(i);
        }


        for (int i = 0; i < ruas.size(); i++) {
            System.out.println(ruas.getRua(i) );
            System.out.println("    " + ruas.getAcidentes(i));
            for (int j = 0; j < ruas.getAcidentes(i).size(); j++) {
                System.out.println("        " + ruas.getAcidentes(i).getAcidente(j));
            }
        }

    }
}
