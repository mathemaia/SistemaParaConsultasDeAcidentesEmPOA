import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Testes {
    public static void main(String[] args) throws FileNotFoundException {
        File arquivo = new File("src/vitimas.csv");
        Scanner in = new Scanner(arquivo);

        final int LINHAS = 31039;
        final int COLUNAS = 30;
        String[][] matriz = new String[LINHAS][COLUNAS];
        int tam = 0;

        int i = 0;

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            String[] colunas = linha.split(";");

            for (int j = 0; j < colunas.length; j++) {
                matriz[i][j] = colunas[j];
            }
            i++;
        }

        for (int k = 0; k < matriz.length; k++) {
            for (int l = 0; l < matriz[k].length; l++) {
                System.out.print(matriz[k][l] + ", ");
            }
        }



    }
}
