package JavaExe_1_mz_rozne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static double r;
    public static Scanner scanner, scanner2;
    public static double x;


    public static void main(String[] args) {

        //   Exe38();
        //   Exe39();

        scanner2 = new Scanner(System.in);

        System.out.println("Podaj a: ");
        int a = scanner2.nextInt();
        System.out.println("Podaj b: ");
        int b = scanner2.nextInt();
        System.out.println("Podaj c: ");
        int c = scanner2.nextInt();



    }



    private static void Exe39() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Podaj liczby, zakończ podawanie liczb wporwadzając 0");

        scanner2 = new Scanner(System.in);

        int liczba = scanner2.nextInt();
        numbers.add(liczba);
        while (liczba != 0) {
            liczba = scanner2.nextInt();
            if (liczba != 0)
                numbers.add(liczba);
        }

        System.out.println("Tabela: ");
        for (int value : numbers) {
            System.out.print("[" + value + "] ");
        }

        int maxValue = -10000;
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > maxValue )
                maxValue = numbers.get(i);
        }
        System.out.println();

        System.out.println("Max value is " + maxValue);

        int minValue = 11111;
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i)<minValue)
                minValue = numbers.get(i);
        }

        System.out.println("Min value is " + minValue);
    }

    private static void Exe38() {
        scanner = new Scanner(System.in);

        do {
            System.out.println("Podaj promień koła, a ja obliczę jego pole");
            r = scanner.nextDouble();
            if (r <= 0)
                System.out.println("Błąd!");
        } while (r <= 0);

        System.out.println("Promień koła wynosi: " + circleArea(r));
    }

    public static double circleArea(double r) {
        if (r <= 0) {
            // System.out.println("Error");
            return 0;
        }
        return 0.5 * r * r;
    }
}
