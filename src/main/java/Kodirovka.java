import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Kodirovka {
   private Path zakodir;
    private int key=10;


   private Rashifrovka rashifrovka = new Rashifrovka();
   Scanner console = new Scanner(System.in);

    private void setOriginalTextFile() {
        this.zakodir =Path.of("src/main/files/zakodir.txt");
    }
   public Path getOriginalTextFile() {

        setOriginalTextFile();
        return zakodir;
    }

    public void writeToFileFromConsole() throws IOException {
        System.out.print("ВВЕДИТЕ СВОЕ СООБЩЕНИЕ: ");
        String text = console.nextLine();

        Files.writeString(getOriginalTextFile(),text);

        encryptMessage();

        System.out.printf("Введенное вами сообщение: %s, преобразована в %s и  записана в файл %s.",text,Files.readAllLines(rashifrovka.getEncryptedFile()),rashifrovka.getEncryptedFile());
    }
    public void writeReadyText() throws IOException {

        byte[]array = "ISLA DE MUERTA".getBytes();

        encryptAlg(array);

        Files.write(rashifrovka.getExamBrute(),array);
        System.out.printf("Сообщение \"ISLA DE MUERTA\" преобразована в %s и  записана в файл %s.",Files.readAllLines(rashifrovka.getEncryptedFile()),rashifrovka.getEncryptedFile());
    }

    private void encryptMessage() throws IOException {

        byte[]array = Files.readAllBytes(getOriginalTextFile());

        encryptAlg(array);
        Files.write(rashifrovka.getEncryptedFile(),array);
    }

    private byte[] encryptAlg(byte[] array){

        for (int i = 0; i <array.length; i++) {
            array[i]=(byte)(array[i]-key);
        }
        return array;
    }
}
