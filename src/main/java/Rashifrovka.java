import java.io.IOException;
import java.nio.file.*;

public class Rashifrovka {
   private Path encryptedFile;
    private Path resultOfDecode;
    private Path examBrute;
    private int key=10;

    private void setEncryptedFile() {

        this.encryptedFile =Path.of("src/main/files/encryptedFile.txt");
    }
    public Path getEncryptedFile() {

        setEncryptedFile();
        return encryptedFile;
    }

    private void setDecodedFile() {

        this.resultOfDecode =Path.of("src/main/files/resultOfDecode.txt");
    }
    private Path getDecodedFile() {
        setDecodedFile();
        return resultOfDecode;
    }

    public void DecodeMessage () throws IOException {
        Kodirovka kodirovka = new Kodirovka();

        byte[]array = Files.readAllBytes(getEncryptedFile());

        String word = String.valueOf(Files.readAllLines(getEncryptedFile()));
        DecodeAlg(array);
        Files.write(getDecodedFile(),array);
        System.out.printf("Закодированное сообщение: %s, преобразована в %s и  записана в файл, %s.",word,Files.readAllLines(getDecodedFile()),getDecodedFile());
    }
    private byte[] DecodeAlg(byte[] array){

        for (int i = 0; i <array.length; i++) {
            array[i]=(byte) (array[i]+key);
        }
        return array;
    }

    public void setExamBrute() {
        this.examBrute = Path.of("src/main/files/examBrute.txt");
    }

    public Path getExamBrute() {
        setExamBrute();
        return examBrute;
    }
}
