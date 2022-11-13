package Dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Dados/cat_vitimas.csv"));

        while (in.hasNextLine()) {
            if (Objects.equals(in.nextLine(), "")) {
                System.out.println(in.nextLine());
            }

        }
    }
}
