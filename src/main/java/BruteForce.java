import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class BruteForce {
    private Rashifrovka rashifrovka = new Rashifrovka();
    public void brute() throws IOException {
        int count = 0; int key =0;
        byte [] a = "ISLA DE MUERTA".getBytes();
        byte[]array = Files.readAllBytes(rashifrovka.getExamBrute());

        while (true){
            if (array[0]+key==a[0]){
                count++;
                break;
            }
            count++;
            key++;
        }
        System.out.printf("Шифр - %s.Ключ подобран, он равняется: %d, попыток ушло:%d. Результат как и было планировано ISLA DE MUERTA",Files.readAllLines(rashifrovka.getExamBrute()),key,count);
        System.out.println();
    }
}
