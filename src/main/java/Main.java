import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Rashifrovka rashifrovka = new Rashifrovka();
        BruteForce bruteForce = new BruteForce();

        Scanner console = new Scanner(System.in);

        System.out.println("Выберите действие:\n1)Зашифровать\n2)Расшифровать\n3)БрутФорс");

        int choice = console.nextInt();

        switch (choice){
           case 1 -> encrypt();
           case 2 -> rashifrovka.DecodeMessage();
           case 3 -> bruteForce.brute();
           default -> System.out.println("Неверно введена команда");
        }
    }
    static void encrypt() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Kodirovka kodirovka = new Kodirovka();
        System.out.println("Выберите действие:\n1)Ввод с клавиатуры\n2)Зашифровать текст: \"ISLA DE MUERTA\"\n");
        int num = scanner.nextInt();
        switch (num){
            case 1 -> kodirovka.writeToFileFromConsole();
            case 2 -> kodirovka.writeReadyText();
            default -> System.out.println("Неверно введена команда");
        }
    }
}
